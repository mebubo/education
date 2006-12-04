import java.io.DataInputStream;
import java.io.IOException;
import java.lang.Exception;

public class ClassReader extends Reader {

    private final int classMagic = 0xcafebabe;
    
    private int magic, minor_version, major_version;
    private int access_flags, this_class, super_class;
    private Reader[] interfaces, fields, methods, attributes;

    public ClassReader(String fileName) throws IOException {
	super(fileName);
    }
    public ClassReader(DataInputStream dataStream) {
	super(dataStream);
    }

    public void readAll() throws IOException, ClassFileMagicMismatch {
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

    public void printAll() {
	System.out.format("magic = %h%n", magic);
	System.out.format("minor_version = %d%n", minor_version);
	System.out.format("major_version = %d%n", major_version);
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("this_class = %d%n", this_class);
	System.out.format("super_class = %d%n", super_class);

	System.out.format("%nInterfaces:%n");
        printTable(interfaces);

	System.out.format("%nFields:%n");
        printTable(fields);

	System.out.format("%nMethods:%n");
        printTable(methods);

	System.out.format("%nAttributes:%n");
        printTable(attributes);
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
