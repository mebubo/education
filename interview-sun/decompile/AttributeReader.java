import java.io.IOException;

public class AttributeReader extends Reader {

    private static final String INNER_CLASSES = "InnerClasses";
    private static final String EXCEPTIONS = "Exceptions";
    private int attribute_name_index;
    private String attribute_name;
    private int attribute_length;
    private byte info[];
    private Reader[] attribute = null;

    public void readAll() throws IOException, ClassFileMagicMismatch {
	attribute_name_index = readShort();
        attribute_name = getName(attribute_name_index);
	attribute_length = readInt();
        if(attribute_name.equals(INNER_CLASSES)) {
            attribute = readTable("InnerClassesAttributeReader");
        } else if (attribute_name.equals(EXCEPTIONS)) {
            attribute = readTable("ExceptionsAttributeReader");
        } else
            info = read(attribute_length);
    }

    public void printAll() {
	System.out.format("attribute_name_index = %d%n", attribute_name_index);
	System.out.format("attribute_length = %d%n", attribute_length);
    }

    public void printNice() {
        if(attribute_name.equals(INNER_CLASSES)) {
            printTableNice(attribute, "\t", "\t", "\n");
        }
        if(attribute_name.equals(EXCEPTIONS)) {
            printTableNice(attribute, " throws ", ", ", "");
        }
    }

}
