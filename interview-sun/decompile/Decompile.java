import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class Decompile {

    private static void errorMessage(String message) {
        System.err.println(message);
        System.exit(1);
    }

    public static void main(String[] args) {
	
        String fileName = null;
        ClassReader classReader = null;

        try {
            /* Filename should be the first command line argument */
            fileName = args[0];
        } catch(ArrayIndexOutOfBoundsException ex) {
            errorMessage("Usage: java Decompile <class file>");
        }
        try {
            try {
                /* Create ClassReader instance and fill it */
                classReader = new ClassReader(fileName);
                classReader.readAll();
            } catch(ClassFileMagicMismatch ex) {
                errorMessage("This does not appear to be a class file!");
            } catch(FileNotFoundException ex) {
                errorMessage("File not found!");
            } catch(EOFException ex) {
                errorMessage("Class file format seems to be invalid!");
            } finally {
                /* we no longer need the file object in classReader */
                if(classReader != null)
                    classReader.close();
            }
        } catch(IOException ex) {
            errorMessage("I/O error!");
        }
        /* Here goes the printing */
        System.out.format("\n/* File %s */%n", fileName);
        classReader.printNice();
    }
}
