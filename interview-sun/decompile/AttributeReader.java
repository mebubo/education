import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AttributeReader extends Reader {

    private int attribute_name_index;
    private int attribute_length;
    private byte info[];

    public void readAll() throws IOException {
	attribute_name_index = read2();
	attribute_length = read2();
	info = read(attribute_length);
    }

    public void printAll() {
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("name_index = %d%n", name_index);
	System.out.format("descriptor_index = %d%n", descriptor_index);
    }

}