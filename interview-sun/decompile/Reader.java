import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

abstract public class Reader implements Dummy2 {

    /* Fields */
    
    /* This object should represent the .class file beeing read */
    private static DataInputStream file;
    
    /* Constant pool is shared by all the subclasses (and also shoud
     * be filled by one of them prior to use) 
     */
    protected static List constant_pool;

    /* Constants defining access flags */
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

    /* Constructors */
    public Reader() {}

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    public Reader(DataInputStream dataStream) {
	file = dataStream;
    }

    /* Every subclass representing any particular layout of the class
     * file region should inplement theese methods
     */
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
