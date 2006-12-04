import java.io.IOException;

public class InterfaceReader extends Reader {

    private int name_index;

    public void readAll() throws IOException {
	name_index = readShort();
    }

    public void printNice() {
        System.out.format("%s", getClassName(name_index));
    }


}
