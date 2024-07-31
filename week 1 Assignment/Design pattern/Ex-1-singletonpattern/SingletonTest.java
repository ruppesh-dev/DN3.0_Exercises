package designPatterns.singletonExample;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both logger instances identical? " + (logger1 == logger2)); // Should print true

        logger1.log("Logging a sample message.");
    }
}
