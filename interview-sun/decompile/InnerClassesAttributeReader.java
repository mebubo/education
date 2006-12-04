import java.io.IOException;

public class InnerClassesAttributeReader extends Reader {

    private int inner_class_info_index;	     
    private int outer_class_info_index;	     
    private int inner_name_index;	     
    private int inner_class_access_flags;

    public void readAll() throws IOException {
        inner_class_info_index = readShort();
        outer_class_info_index = readShort();
        inner_name_index = readShort();
        inner_class_access_flags = readShort();
    }

    public void printNice() {
        System.out.print(getAccessString(inner_class_access_flags));
        System.out.format("%s ", getClassKeyword(inner_class_access_flags));
        //System.out.format("%s ", getClassName(inner_class_info_index));
        System.out.print(getName(inner_name_index));
        System.out.println(" {}");
        
    }
}
