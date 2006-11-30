import java.io.IOException;

public class AttributeReader extends Reader {

    private int attribute_name_index;
    private int attribute_length;
    private byte info[];

    public void readAll() throws IOException {
	attribute_name_index = readShort();
	attribute_length = readInt();
	info = read(attribute_length);
    }

    public void printAll() {
	System.out.format("attribute_name_index = %d%n", attribute_name_index);
	System.out.format("attribute_length = %d%n", attribute_length);
    }

    public void printNice() {};

}
