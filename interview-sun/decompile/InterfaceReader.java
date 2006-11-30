import java.io.IOException;

public class InterfaceReader extends Reader {

    private int name_index;

    public void readAll() throws IOException {
	name_index = read2();
    }

    public void printAll() {
	System.out.format("name_index = %d ( %s )%n", name_index, getClassName(name_index));
    }

    public void printNice() {
        System.out.format("%s", getClassName(name_index));
    }


}
