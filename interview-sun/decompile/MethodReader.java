import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MethodReader extends FieldReader {

    public void printNice() {
        System.out.print(getAccessString(access_flags));
        //System.out.format("%s ", getName(descriptor_index));
        System.out.format("%s ", getType(descriptor_index));
        System.out.format("%s ", getName(name_index));
        //System.out.format("%s ", getArgs(descriptor_index));
        System.out.println(";");
    }


}
