import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

abstract public class Reader implements Dummy2 {

    /* Fields */
    private final int ACC_PUBLIC = 0x0001;
    private final int ACC_PRIVATE = 0x0002;
    private final int ACC_PROTECTED = 0x0004;
    private final int ACC_STATIC = 0x0008;
    private final int ACC_FINAL = 0x0010;
    private final int ACC_SYNCHRONIZED = 0x0020;
    private final int ACC_VOLATILE = 0x0040;
    private final int ACC_TRANSIENT = 0x0080;
    private final int ACC_NATIVE = 0x0100;
    private final int ACC_INTERFACE = 0x0200;  
    private final int ACC_ABSTRACT = 0x0400;
    private final int ACC_STRICT = 0x0800;

    private static DataInputStream file;

    protected static List constant_pool;

    /* Constructors */
    public Reader() {}

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    public Reader(DataInputStream dataStream) {
	file = dataStream;
    }

    abstract void readAll() throws IOException;
    abstract void printAll();
    abstract void printNice();

    /* Read methods */
    public byte[] read(int count) throws IOException {
	byte[] result = new byte[count];
	file.readFully(result);
	return result;
    }

    public int read1() throws IOException {
	return file.readUnsignedByte();
    }

    public int read2() throws IOException {
	return file.readUnsignedShort();
    }

    public int read4() throws IOException {
	return file.readInt();
    }

    public float readFloat() throws IOException {
        return file.readFloat();
    }

    public long readLong() throws IOException {
        return file.readLong();
    }

    public double readDouble() throws IOException {
        return file.readDouble();
    }

    public String readString() throws IOException {
        int length = read2();
        byte[] bytes = new byte[length];
        file.read(bytes);
        String string = new String(bytes);
        return string;
    }

    public Reader[] readTable(String readerName) throws IOException {
        int count = read2();
        Reader[] items = new Reader[count];
        try {
            Class classObj = Class.forName(readerName);
            for(int i = 0; i < count; i++) {
                items[i] = (Reader)classObj.newInstance();
                items[i].readAll();
            } 
        } catch (ClassNotFoundException cnf) {
            System.err.format("Class %s not found%n", readerName);
            System.exit(1);
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        }
            
	return items;
   
    }

    /* Get methods */
    public String getAccessString(int flags) {
        String string = "";
        if((flags & ACC_PUBLIC) != 0) string += "public ";
        if((flags & ACC_PRIVATE) != 0) string += "private ";
        if((flags & ACC_PROTECTED) != 0) string += "protected ";
        if((flags & ACC_STATIC) != 0) string += "static ";
        if((flags & ACC_FINAL) != 0) string += "final ";
        //if((flags & ACC_SYNCHRONIZED) != 0) string += "syncronized ";
        if((flags & ACC_VOLATILE) != 0) string += "volatile ";
        if((flags & ACC_TRANSIENT) != 0) string += "transient ";
        if((flags & ACC_NATIVE) != 0) string += "native ";
        if((flags & ACC_INTERFACE) != 0) string += "interface ";
        if((flags & ACC_ABSTRACT) != 0) string += "abstract ";
        if((flags & ACC_STRICT) != 0) string += "strict ";
        return string;
    }
    
    public String getClassName(int class_index) {
        int name_index = (Integer)constant_pool.get(class_index-1);
        String raw_name = getName(name_index);
        return raw_name.replace("/", ".");
    }
    
    public String getClassKeyword(int access_flags) {
        return ((access_flags & ACC_INTERFACE) != 0) ? "interface" : "class";
    }

    public String getName(int name_index) {
        return (String)constant_pool.get(name_index-1);
    }

    public String getType(int descriptor_index) {
        String raw_descriptor = getName(descriptor_index);
        if(raw_descriptor.contains(")"))
            raw_descriptor = raw_descriptor.split("\\)")[1];
        Object[] descs = splitDescriptor(raw_descriptor);
        String result = "";
        for(int i=0; i<descs.length; i++) {
            result = result + transformDescriptor((String)descs[i]) + " ";
        }
        return result;
    }
    
    public String getArgs(int descriptor_index) {
        String raw_descriptor = getName(descriptor_index);
        if(raw_descriptor.contains(")")) 
            raw_descriptor = raw_descriptor.split("\\)")[0];
        else
            return "";
        Object[] descs = splitDescriptor(raw_descriptor);
        String result = "(";
        for(int i=0; i<descs.length; i++) {
            result = result + transformDescriptor((String)descs[i]);
            if (i < descs.length-1)
                result += ", ";
        }
        return result+")";
    }

    
    /* Utility string manipulation methods */
    public Object[] splitDescriptor(String descriptor) {
            Pattern pattern = Pattern.compile("\\[*(B|C|D|F|I|J|L.*?;|S|Z|V)");
            Matcher matcher = pattern.matcher(descriptor);
            List<Object> list = new ArrayList<Object>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            return list.toArray();
    }

    public String transformDescriptor(String descriptor) {
        Pattern pattern = Pattern.compile("\\[|(.+)");
        Matcher matcher = pattern.matcher(descriptor);
        String type = "";
        String dimensions = "";
        while (matcher.find()) {
            //            System.out.println("foo " + matcher.group() + " bar " + descriptor);
            String group = matcher.group();
            if(group.contains("["))
                dimensions = dimensions + "[]";
            else {
                switch(group.charAt(0)) {
                case('L'):
                    type = group.substring(1, group.length()-1).replace("/", ".");
                    break;
                case('B'): type = "byte"; break;
                case('C'): type = "char"; break;
                case('D'): type = "double"; break;
                case('F'): type = "float"; break;
                case('I'): type = "int"; break;
                case('J'): type = "long"; break;
                case('S'): type = "short"; break;
                case('Z'): type = "boolean"; break;
                case('V'): type = "void"; break;
                }
           }
        }    
        return type+dimensions;
    }

    /* Methods to print tables */
    public void printTable(Reader[] table) {
        int length = table.length;
        for(int i = 0; i < length; i++) {
            table[i].printAll();
        }
    }

    public void printTableNice(Reader[] table) {
        int length = table.length;
        for(int i = 0; i < length; i++) {
            table[i].printNice();
        }
    }

    public void printTableNice(Reader[] table, 
                               String pre, String mid, String post) {
        int length = table.length;
        if(length == 0) 
            return;
        System.out.print(pre);
        for(int i = 0; i < length-1; i++) {
            table[i].printNice();
            System.out.print(mid);
        }
        table[length-1].printNice();
        System.out.print(post);
    }

}
