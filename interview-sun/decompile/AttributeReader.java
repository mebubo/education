import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AttributeReader extends Reader {

    private int attribute_name_index;
    private int attribute_length;
    private byte info[];

    public void readAll() throws IOException {
	attribute_name_index = read2();
	attribute_length = read4();
	info = read(attribute_length);
    }

    public void printAll() {
	System.out.format("attribute_name_index = %d%n", attribute_name_index);
	System.out.format("attribute_length = %d%n", attribute_length);
    }

}
