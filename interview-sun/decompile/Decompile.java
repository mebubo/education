import java.io.IOException;

public class Decompile {

    public static void main(String[] args) throws IOException {
	
        String fileName = args[0];
	ClassReader cr = new ClassReader(fileName);
	cr.readAll();
	//cr.printAll();
        System.out.format("\n/* File %s */%n", fileName);
        cr.printNice();
    }
}
