import java.io.DataInputStream;
import java.io.IOException;
import java.lang.Exception;

/* This class reads the whole .class file, delegating the task of
 * reading the "tables" to other subclasses of the Reader (readers for
 * the items of those tables are collected in the corresponding
 * arrays).
 */
public class ClassReader extends Reader {

    private static final int classMagic = 0xcafebabe;
    
    private int magic, minor_version, major_version;
    private int access_flags, this_class, super_class;
    private Reader[] interfaces, fields, methods, attributes;

    public ClassReader(String fileName) throws IOException {
	super(fileName);
    }

    public void readAll() throws IOException, 
                                 ClassFileMagicMismatch, UnknownConstantPoolTag {
	magic = readInt();
        if(magic != classMagic) 
            throw new ClassFileMagicMismatch();
	minor_version = readShort();
	major_version = readShort();
	//constant_pool = readConstantPool();
	readConstantPool();
        access_flags = readShort();
        this_class = readShort();
        super_class = readShort();
        interfaces = readTable("InterfaceReader");
        fields = readTable("FieldReader");
        methods = readTable("FieldReader");
        attributes = readTable("AttributeReader");
    }

    public void printNice() {

        System.out.print(getAccessString(access_flags));
        System.out.format("%s ", getClassKeyword(access_flags));
        System.out.format("%s ", getClassName(this_class));
        System.out.format("extends %s ", getClassName(super_class));
        System.out.format("%s", interfaces.length > 0 ? "implements" : "");
        printTableNice(interfaces, " ", ", ", " ");

        System.out.println("{");

        System.out.println("\n\t/* Fields */");
        printTableNice(fields, "\t", "\t", "");

        System.out.println("\n\t/* Methods */");
        printTableNice(methods, "\t", "\t", "");

        System.out.println("\n\t/* Inner Classes */");
        printTableNice(attributes);

        System.out.println("}");
    }

}
