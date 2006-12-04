import java.io.IOException;

public class ExceptionsAttributeReader extends Reader {

    private int exception_index;

    public void readAll() throws IOException {
        exception_index = readShort();
    }

    public void printNice() {
        System.out.print(getClassName(exception_index));
    }
}
