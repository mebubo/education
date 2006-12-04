import java.io.IOException;

/* Read various attributes (of a class, method, etc) */
public class AttributeReader extends Reader {

    private static final String INNER_CLASSES = "InnerClasses";
    private static final String EXCEPTIONS = "Exceptions";
    private int attribute_name_index;
    private String attribute_name;
    private int attribute_length;
    private byte info[];
    private Reader[] attribute = null;

    public void readAll() throws IOException, 
                                 ClassFileMagicMismatch, UnknownConstantPoolTag {
	attribute_name_index = readShort();
        attribute_name = getName(attribute_name_index);
	attribute_length = readInt();
        /* Handle InnerClasses and Exceptions attributes via
         * corresponding classes. Other attributes are effectively
         * ignored.
         */
        if(attribute_name.equals(INNER_CLASSES)) {
            attribute = readTable("InnerClassesAttributeReader");
        } else if (attribute_name.equals(EXCEPTIONS)) {
            attribute = readTable("ExceptionsAttributeReader");
        } else
            info = read(attribute_length);
    }

    public void printNice() {
        if(attribute_name.equals(INNER_CLASSES) && attribute != null) {
            printTableNice(attribute, "\t", "\t", "\n");
        }
        if(attribute_name.equals(EXCEPTIONS) && attribute != null) {
            printTableNice(attribute, " throws ", ", ", "");
        }
    }

}
