import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {
    
    protected DataInputStream file;

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    public Reader(DataInputStream dataStream) {
	file = dataStream;
    }
	
    public int read1() throws IOException {
	return file.readUnsignedByte();
    }

    public int read2() throws IOException {
	return file.readUnsignedShort();
    }

    public int read4() throws IOException {
	return file.readInt();
    }

}