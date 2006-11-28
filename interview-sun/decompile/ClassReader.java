import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassReader extends Reader {

    private int magic, minor_version, major_version;
    private int constant_pool_count;

    public ClassReader(String fileName) throws IOException {
	super(fileName);
    }
    public ClassReader(DataInputStream dataStream) {
	super(dataStream);
    }

    public void readAll() throws IOException {
	magic = read4();
	minor_version = read2();
	major_version = read2();
	constant_pool_count = read2();
    }

    public void printAll() {
	System.out.format("magic = %h%n", magic);
	System.out.format("minor_version = %d%n", minor_version);
	System.out.format("major_version = %d%n", major_version);
	System.out.format("constant_pool_count = %d%n", constant_pool_count);
    }

}