import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FieldReader extends Reader {

    private int access_flags;
    private int name_index;
    private int descriptor_index;
    private AttributeReader[] attributes;

    public void readAll() throws IOException {
	access_flags = read2();
	name_index = read2();
	descriptor_index = read2();
	attributes = readAttributes();
    }

    public void printAll() {
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("name_index = %d%n", name_index);
	System.out.format("descriptor_index = %d%n", descriptor_index);
    }

}