import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

abstract public class Reader {

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

    protected static DataInputStream file;
    protected static List constant_pool;

    public Reader() {}

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    public Reader(DataInputStream dataStream) {
	file = dataStream;
    }

    abstract void readAll() throws IOException;

    abstract void printAll();

    abstract void printNice() {};

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

    public byte[] readInterfaces() throws IOException {
        int interfaces_count = read2();
        byte[] interfaces = read(interfaces_count);
        return interfaces;
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
            System.out.format("Class %s not found%n", readerName);
            System.exit(1);
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        }
            
	return items;
   
    }

//     public FieldReader[] readFields() throws IOException {
// 	int fields_count = read2();
// 	FieldReader[] fields = new FieldReader[fields_count];
// 	for(int i = 0; i < fields_count; i++) {
// 	    fields[i] = new FieldReader();
// 	    fields[i].readAll();
// 	}
// 	return fields;
//     }

//     public AttributeReader[] readAttributes() throws IOException {
// 	int attributes_count = read2();
// 	AttributeReader[] attributes = new AttributeReader[attributes_count];
// 	for(int i = 0; i < attributes_count; i++) {
// 	    attributes[i] = new AttributeReader();
// 	    attributes[i].readAll();
// 	}
// 	return attributes;
//     }

    public String getClassName(int class_index) {
        return (String)constant_pool.get((Integer)constant_pool.get(class_index-1)-1);
    }
    
    public String getClassKeyword(int access_flags) {
        return ((access_flags & ACC_INTERFACE) != 0) ? "interface" : "class";
    }

    public String getName(int name_index) {
        return (String)constant_pool.get(name_index-1);
    }
    
    public String getAccessString(int access_flags) {
        String string = "";
        if((access_flags & ACC_PUBLIC) != 0) string += "public ";
        if((access_flags & ACC_PRIVATE) != 0) string += "private ";
        if((access_flags & ACC_PROTECTED) != 0) string += "protected ";
        if((access_flags & ACC_STATIC) != 0) string += "static ";
        if((access_flags & ACC_FINAL) != 0) string += "final ";
        //if((access_flags & ACC_SYNCHRONIZED) != 0) string += "syncronized ";
        if((access_flags & ACC_VOLATILE) != 0) string += "volatile ";
        if((access_flags & ACC_TRANSIENT) != 0) string += "transient ";
        if((access_flags & ACC_NATIVE) != 0) string += "native ";
        if((access_flags & ACC_INTERFACE) != 0) string += "interface ";
        if((access_flags & ACC_ABSTRACT) != 0) string += "abstract ";
        if((access_flags & ACC_STRICT) != 0) string += "strict ";
        return string;
    }
    
    public void printTable(Reader[] table) {
        int length = table.length;
        for(int i = 0; i < length; i++) {
            table[i].printAll();
        }
    }

    public void printTableNice(Reader[] table) {
        int length = table.length;
        for(int i = 0; i < length; i++) {
            System.out.print("\t");
            table[i].printNice();
        }
    }

}
