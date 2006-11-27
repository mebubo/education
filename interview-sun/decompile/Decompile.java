import java.io.IOException;

public class Decompile {

    public static void main(String[] args) throws IOException {
	
	ClassReader cr = new ClassReader(args[0]);
	cr.readAll();
	cr.printAll();

    }
}