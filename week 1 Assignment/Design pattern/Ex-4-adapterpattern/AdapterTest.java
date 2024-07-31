package adapterPatternExample;

public class AdapterTest {
    public static void main(String[] args) {
        PayPal payPal = new PayPal();
        PaymentProcessor processor = new PayPalAdapter(payPal);
        processor.processPayment(100.0); // Should print processing through PayPal
    }
}