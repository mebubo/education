import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.EOFException;


public class DecompileOld {

    static int magic = 0;
    static short minor_version = 0;
    static short major_version = 0;
    static long longNumber = 100000000000L;
    
    public static void main(String[] args) throws IOException {
	
	String dataFile = args[0];
	// DataInputStream in = null;
	RandomAccessFile in = null;

	try {
	    // in = new DataInputStream(new FileInputStream(dataFile));
	    in = new RandomAccessFile(dataFile, "r");
	    magic = in.readInt();
	} finally {
	    in.close();
	}
	System.out.format("%h%n", magic);
    }
}

class Foo {
      int foo = 5;
}
