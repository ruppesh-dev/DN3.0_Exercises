package designPatterns.proxyExample;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("example_image.jpg");
        image.display(); 
        image.display(); 
    }
}
