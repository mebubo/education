import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

abstract public class Reader {

    /*-- Fields --*/
    
    /* This object should represent the .class file beeing read */
    private static DataInputStream file;
    
    /* Constant pool is common to all the subclasses, and there should
     * be only one 
     */
    private static List constant_pool;

    /*-- Constructors --*/

    public Reader() {}

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    /*-- Methods --*/

    /* Every subclass representing any particular layout of the class
     * file region should inplement readAll() and printNice().
     */

    /* readAll() should be capable of reading a particular region of
     * the class file, i.e. the whole class file or a single entry in
     * some of the nested "tables". Each subclass should implement
     * this method according to the layout of it's "zone of
     * responsibility". Typical readAll() implementation consists of a
     * number of consecutive calls to some of the
     * read{,Byte,Short,Int,Table,ConstantPool}() methods.
     */
    public abstract void readAll() throws IOException, 
                                          ClassFileMagicMismatch, UnknownConstantPoolTag;

    /* printNice() should pretty-print the info for which the
     * particular subclass is responsible. Typical printNice()
     * implementation obtains the needed strings via the calls to get*
     * methods, and outputs them via System.out.
     */
    public abstract void printNice();

    
    /* Wrapper for DataInputStream.close() */
    public void close() throws IOException {
        file.close();
    }

    /*-- Read methods --*/

    /* Read count bytes into the byte[] array, and return it */
    protected static byte[] read(int count) throws IOException {
	byte[] result = new byte[count];
	file.readFully(result);
	return result;
    }

    /* Wrapper for DataInputStream.readUnsignedByte() */
    protected static int readByte() throws IOException {
	return file.readUnsignedByte();
    }

    /* Wrapper for DataInputStream.readUnsignedShort() */
    protected static int readShort() throws IOException {
	return file.readUnsignedShort();
    }

    /* Wrapper for DataInputStream.readInt() */
    protected static int readInt() throws IOException {
	return file.readInt();
    }

    /* The so called tables are used in several class file
     * structures. Tables consist of zero or more variable-sized
     * items, each item having the same layout. The idea is to read
     * each table into an array of instances of some Reader subclass.
     * More precisely, Reader subclass whose readAll() method is
     * implemented in such a way as to read one item of that
     * particular table.
     *
     * We presume that whenever someone implementing the readAll()
     * method (in some subclass of the Reader) encounters the table he
     * needs to read, he should first implement the class (a subclass
     * of the Reader, too) capable of reading one item of that table,
     * and the simply call readTable() with the name of that class as
     * an argument. The class is dynamically loaded by name here.
     */
    protected static Reader[] readTable(String readerName) throws IOException, 
                                                                  ClassFileMagicMismatch, 
                                                                  UnknownConstantPoolTag {
        int count = readShort();
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
            System.err.format("Couldn't instantiate %s%n", readerName);
            System.exit(1);
        } catch (IllegalAccessException iae) {
            System.err.format("Permission to access class %s denied%n", readerName);
            System.exit(1);
        }
            
	return items;
   
    }

    /* Constant pool is a very special entity (in that it is required
     * for the get* methods in Reader to work, and also has an unusual
     * tag-driven layout, which no other part of the .class file has),
     * and doesn't fit into the Reader model very well. That's why it
     * was decided that the task of reading it is best accomplished by
     * this method, rather then subclassing Reader to get some kind of
     * ConstantPoolReader.
     */
    protected static void readConstantPool() throws IOException, UnknownConstantPoolTag {
        /* Tags for reading constants */
        final int CONSTANT_Class = 7;
        final int CONSTANT_Fieldref = 9;
        final int CONSTANT_Methodref = 10;
        final int CONSTANT_InterfaceMethodref = 11;
        final int CONSTANT_String = 8;
        final int CONSTANT_Integer = 3;
        final int CONSTANT_Float = 4;
        final int CONSTANT_Long = 5;
        final int CONSTANT_Double = 6;
        final int CONSTANT_NameAndType = 12;
        final int CONSTANT_Utf8 = 1;

        int constant_pool_count = readShort();
        List<Object> cp = new ArrayList<Object>();
        for(int i = 0; i < constant_pool_count-1; i++) {
            switch(readByte()) {
            case CONSTANT_Class :
                cp.add(new Integer(readShort())); 
                break;
            case CONSTANT_Fieldref :
            case CONSTANT_Methodref :
            case CONSTANT_InterfaceMethodref : {
                List<Object> c = new ArrayList<Object>();
                c.add(new Integer(readShort()));
                c.add(new Integer(readShort()));
                cp.add(c);
                }
                break;
            case CONSTANT_String :
                cp.add(new Integer(readShort())); 
                break;
            case CONSTANT_Integer :
                cp.add(new Integer(readInt()));
                break;
            case CONSTANT_Float :
                cp.add(new Float(readFloat()));
                break;
            case CONSTANT_Long :
                cp.add(new Long(readLong()));
                /* CONSTANT_Long effectively occupies 2 entries in
                 * constant pool 
                 */
                cp.add(null);
                i++;
                break;
            case CONSTANT_Double :
                cp.add(new Double(readDouble()));
                /* CONSTANT_Double effectively occupies 2 entries in
                 * constant pool 
                 */
                cp.add(null);
                i++;
                break;
            case CONSTANT_NameAndType : {
                List<Object> c = new ArrayList<Object>();
                c.add(new Integer(readShort()));
                c.add(new Integer(readShort()));
                cp.add(c); }
                break;
            case CONSTANT_Utf8 : {
                cp.add(readString());
            }
                break;
            default: {
                /* An exception should be thrown here */
                throw new UnknownConstantPoolTag();
            }
            }
        }
        constant_pool = cp;
    }

    /* The following 4 read* methods are used in readConstantPool()
     * only, and are thus made private 
     */

    /* Wrapper for DataInputStream.readFloat() */
    private static float readFloat() throws IOException {
        return file.readFloat();
    }

    /* Wrapper for DataInputStream.readLong() */
    private static long readLong() throws IOException {
        return file.readLong();
    }

    /* Wrapper for DataInputStream.readDouble() */
    private static double readDouble() throws IOException {
        return file.readDouble();
    }

    /* Read the string according to how it's stored inside a constant
     * pool.
     */
    private static String readString() throws IOException {
        int length = readShort();
        byte[] bytes = new byte[length];
        file.read(bytes);
        String string = new String(bytes);
        return string;
    }

    /*-- Get methods --*/

    /* Compose an access string based on the value of flags */
    protected static String getAccessString(int flags) {
        /* Constants defining access flags */
        final int ACC_PUBLIC = 0x0001;
        final int ACC_PRIVATE = 0x0002;
        final int ACC_PROTECTED = 0x0004;
        final int ACC_STATIC = 0x0008;
        final int ACC_FINAL = 0x0010;
        final int ACC_SYNCHRONIZED = 0x0020;
        final int ACC_VOLATILE = 0x0040;
        final int ACC_TRANSIENT = 0x0080;
        final int ACC_NATIVE = 0x0100;
        final int ACC_ABSTRACT = 0x0400;
        final int ACC_STRICT = 0x0800;

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
        //if((flags & ACC_INTERFACE) != 0) string += "interface ";
        if((flags & ACC_ABSTRACT) != 0) string += "abstract ";
        if((flags & ACC_STRICT) != 0) string += "strict ";
        return string;
    }
    
    /* Given the index of CONSTANT_Class_info in the constant pool,
     * return its name as a string.
     */
    protected static String getClassName(int class_index) {
        int name_index = (Integer)constant_pool.get(class_index-1);
        String raw_name = getName(name_index);
        return raw_name.replace("/", ".");
    }
    
    /* If the ACC_INTERFACE flag is set, then the right keyword is
     * "interface", otherwise it is "class".
     */
    protected static String getClassKeyword(int access_flags) {
        final int ACC_INTERFACE = 0x0200;  
        return ((access_flags & ACC_INTERFACE) != 0) ? "interface" : "class";
    }

    /* Get an ordinary name (CONSTANT_Utf8_info) from the constant
     * pool 
     */
    protected static String getName(int name_index) {
        return (String)constant_pool.get(name_index-1);
    }

    /*-- Methods to print "tables" --*/

    /* For each entry in a Reader[] array, call its printNice method
     * (the handling of the NullPointerException is left to the user)
     */
    protected static void printTableNice(Reader[] table) {
        int length = table.length;
        for(int i = 0; i < length; i++) {
            table[i].printNice();
        }
    }

    /* First print pre, then each, except for the last, Reader[] array
     * entry with mid appended, then the last entry, then post. 
     */
    protected static void printTableNice(Reader[] table, 
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
