class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {};
    
    public static Singleton getInstance() {
	return instance;
    }
}

public class SingletonDemo {

    public static void main(String arg[]) {
	//Singleton sing1 = Singleton.getInstance();
	//Singleton sing2 = Singleton.getInstance();
	//Singleton sing3 = new Singleton();
	System.out.println("Foo");
    }

}