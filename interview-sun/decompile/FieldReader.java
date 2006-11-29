import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FieldReader extends Reader {

    protected int access_flags;
    protected int name_index;
    protected int descriptor_index;
    protected Reader[] attributes;

    public void readAll() throws IOException {
	access_flags = read2();
	name_index = read2();
	descriptor_index = read2();
        attributes = readTable("AttributeReader");
    }

    public void printAll() {
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("name_index = %s%n", constant_pool.get(name_index-1));
	System.out.format("descriptor_index = %s%n", constant_pool.get(descriptor_index-1));
        printTable(attributes);
    }

    public void printNice() {
        System.out.print(getAccessString(access_flags));
        //System.out.format("%s ", getName(descriptor_index));
        System.out.format("%s", getType(descriptor_index));
        System.out.format("%s", getName(name_index));
        System.out.format("%s", getArgs(descriptor_index));
        System.out.println(";");
    }


}
