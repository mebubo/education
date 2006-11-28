import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {
    
    protected static DataInputStream file;

    public Reader(String fileName) throws IOException {
	file = new DataInputStream(new FileInputStream(fileName));
    }

    public Reader(DataInputStream dataStream) {
	file = dataStream;
    }

    public byte[] read(int count) throws IOException {
	byte[] result = new byte[count];
	file.readFully(result);
	return result;
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

    public FieldReader[] readFields() throws IOException {
	int fields_count = read2();
	FieldReader[] fields = new FieldReader[fields_count];
	for(int i = 0; i < fields_count; i++) {
	    fields[i] = new FieldReader();
	    fields[i].readAll();
	}
	return fields;
    }

    public AttributeReader[] readAttributes() throws IOException {
	int attributes_count = read2();
	AttributeReader[] attributes = new AttributeReader[attributes_count];
	for(int i = 0; i < attributes_count; i++) {
	    attributes[i] = new AttributeReader();
	    attributes[i].readAll();
	}
	return attributes;
    }

}