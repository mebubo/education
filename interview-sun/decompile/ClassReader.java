import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ClassReader extends Reader {

    public final int CONSTANT_Class = 7;
    public final int CONSTANT_Fieldref = 9;
    public final int CONSTANT_Methodref = 10;
    public final int CONSTANT_InterfaceMethodref = 11;
    public final int CONSTANT_String = 8;
    public final int CONSTANT_Integer = 3;
    public final int CONSTANT_Float = 4;
    public final int CONSTANT_Long = 5;
    public final int CONSTANT_Double = 6;
    public final int CONSTANT_NameAndType = 12;
    public final int CONSTANT_Utf8 = 1;
    
    private int magic, minor_version, major_version;
    private int access_flags, this_class, super_class;
    private byte[] interfaces;
    private Reader[] fields, methods, attributes;

    public ClassReader(String fileName) throws IOException {
	super(fileName);
    }
    public ClassReader(DataInputStream dataStream) {
	super(dataStream);
    }

    public List readConstantPool() throws IOException {
        int constant_pool_count = read2();
        List cp = new ArrayList();
        for(int i = 0; i < constant_pool_count-1; i++) {
            switch(read1()) {
            case CONSTANT_Class :
                cp.add(new Integer(read2())); 
                break;
            case CONSTANT_Fieldref :
            case CONSTANT_Methodref :
            case CONSTANT_InterfaceMethodref : {
                List c = new ArrayList();
                c.add(new Integer(read2()));
                c.add(new Integer(read2()));
                cp.add(c);
                }
                break;
            case CONSTANT_String :
                cp.add(new Integer(read2())); 
                break;
            case CONSTANT_Integer :
                cp.add(new Integer(read4()));
                break;
            case CONSTANT_Float :
                cp.add(new Float(readFloat()));
                break;
            case CONSTANT_Long :
                cp.add(new Long(readLong()));
                cp.add(null);
                i++;
                break;
            case CONSTANT_Double :
                cp.add(new Double(readDouble()));
                cp.add(null);
                i++;
                break;
            case CONSTANT_NameAndType : {
                List c = new ArrayList();
                c.add(new Integer(read2()));
                c.add(new Integer(read2()));
                cp.add(c); }
                break;
            case CONSTANT_Utf8 : {
                cp.add(readString());
            }
                break;
            }
        }
        
        return cp;
    }

    public void readAll() throws IOException {
	magic = read4();
	minor_version = read2();
	major_version = read2();
	constant_pool = readConstantPool();
        access_flags = read2();
        this_class = read2();
        super_class = read2();
        interfaces = readInterfaces();
        fields = readFields();
        methods = readFields();
        attributes = readAttributes();
    }

    public void printAll() {
	System.out.format("magic = %h%n", magic);
	System.out.format("minor_version = %d%n", minor_version);
	System.out.format("major_version = %d%n", major_version);
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("this_class = %d%n", this_class);
	System.out.format("super_class = %d%n", super_class);

	System.out.format("%nFields:%n");
        printTable(fields);

	System.out.format("%nMethods:%n");
        printTable(methods);

	System.out.format("%nAttributes:%n");
        printTable(attributes);
    }

}
