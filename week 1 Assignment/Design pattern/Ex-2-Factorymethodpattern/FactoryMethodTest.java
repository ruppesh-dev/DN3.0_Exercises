package designPatterns.factoryMethodExample;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory factory = new PdfDocumentFactory();
        Document document = factory.createDocument();
        document.open(); 
    }
}
