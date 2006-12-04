import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class Decompile {

    private static void errorMessage(String message) {
        System.err.println("\nE: " + message);
        System.exit(1);
    }

    private static void bug() {
        errorMessage("You've probably found the bug in the classreader library!\n" +
                     "Please send the message with a detailed description\n" +
                     "of how this behavior can be reproduced to dolgovs@gmail.com");
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
            } catch (UnknownConstantPoolTag ex) {
                errorMessage("Class file format seems to be invalid" + 
                             " (unknown tag in constant pool)!");
            } catch(NullPointerException ex) {
                bug();
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
        try {
            classReader.printNice();
        } catch(NullPointerException ex) {
            bug();
        }
    }
}
