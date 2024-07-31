package adapterPatternExample;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    void sendPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}