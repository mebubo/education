import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class Decompile {

    private static void errorMessage(String message) {
        System.err.println(message);
        System.exit(1);
    }

    public static void main(String[] args) {
	
        String usage = "Usage: java Decompile <filename>";
        String fileName;
        ClassReader cr;

        try {
            /* Filename should be the first command line argument */
            fileName = args[0];
            cr = new ClassReader(fileName);
            cr.readAll();
            //cr.printAll();
            System.out.format("\n/* File %s */%n", fileName);
            cr.printNice();
            cr.close();
        } catch(ArrayIndexOutOfBoundsException ex) {
            errorMessage("Usage: java Decompile <class file>");
        } catch(ClassFileMagicMismatch ex) {
            errorMessage("This does not appear to be a class file!");
        } catch(FileNotFoundException ex) {
            errorMessage("File not found!");
        } catch(EOFException ex) {
            errorMessage("Class file format seems to be invalid!");
        } catch(IOException ex) {
            errorMessage("I/o error!");
        }
    }
}
