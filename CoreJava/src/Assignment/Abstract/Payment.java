package Assignment.Abstract;

abstract class Payment {
    String paymentId;
    double amount;
    String payerName;
    String status = "PENDING";

    Payment(String paymentId, double amount, String payerName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.payerName = payerName;
        this.status = "PENDING";
    }

    String getPaymentId() {
        return paymentId;
    }

    void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    double getAmount() {
        return amount;
    }

    void setAmount(double amount) {
        this.amount = amount;
    }

    String getPayerName() {
        return payerName;
    }

    void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    void printSummary() {
        System.out.println("Payment Summary:");
        System.out.println("ID: " + this.paymentId);
        System.out.println("Payer: " + this.payerName);
        System.out.println("Amount: Rs. " + this.amount);
        System.out.println("Status: " + this.status);
    }

    final void process() {
        if (!validate()) {
            this.status = "FAILED";
            return;
        }
        deductAmount();
        sendNotification();
        this.status = "SUCCESS";
    }

    abstract boolean validate();

    abstract void deductAmount();

    abstract void sendNotification();
}

class CardPayment extends Payment {
    final String cardNumber;
    final String cvv;

    CardPayment(String paymentId, double amount, String payerName, String cardNumber, String cvv) {
        super(paymentId, amount, payerName);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    String getCardNumber() {
        return cardNumber;
    }

    String getCvv() {
        return cvv;
    }

    boolean validate() {
        boolean cardValid = this.cardNumber.length() == 16;
        boolean cvvValid = this.cvv.length() == 3;
        boolean amountValid = this.amount > 0;

        if (!cardValid)
            System.out.println("Invalid card number. It must be exactly 16 digits.");
        if (!cvvValid)
            System.out.println("Invalid CVV. It must be exactly 3 digits.");
        if (!amountValid)
            System.out.println("Amount must be greater than 0.");

        return cardValid && cvvValid && amountValid;
    }

    void deductAmount() {
        System.out.println("Deducting Rs." + this.amount + " from your card ************" + this.cardNumber.substring(12));
    }

    void sendNotification() {
        System.out.println("Notification: Card payment successful for " + this.payerName + " (" + this.paymentId + ")");
    }
}

class UPIPayment extends Payment {
    final String upiId;

    UPIPayment(String paymentId, double amount, String payerName, String upiId) {
        super(paymentId, amount, payerName);
        this.upiId = upiId;
    }

    String getUpiId() {
        return upiId;
    }

    boolean validate() {
        boolean upiValid = upiId != null && upiId.contains("@");
        boolean amountValid = amount >= 1 && amount <= 100000;
        if (!upiValid)
            System.out.println("Invalid UPI ID. It must contain '@'.");
        if (!amountValid)
            System.out.println("Amount must be between 1 and 100000.");
        return upiValid && amountValid;
    }

    void deductAmount() {
        System.out.println("Deducting Rs. " + this.amount + " via UPI from " + this.upiId);
    }

    void sendNotification() {
        System.out.println("Notification: UPI payment successful for " + this.payerName + " (" + this.paymentId + ")");
    }
}

class PaymentDemo {
    public static void main(String[] args) {
        Payment p1, p2, p3, p4;

        p1 = new CardPayment("P1001", 1250.50, "ABC", "1234567812345678", "123");
        System.out.println();
        p1.process();
        p1.printSummary();

        p2 = new UPIPayment("P1002", 999.99, "LMN", "lmlnop@upi");
        System.out.println();
        p2.process();
        p2.printSummary();

        p3 = new CardPayment("P1003", 1000.0, "PQR", "1111222233334444", "12");
        System.out.println();
        p3.process();
        p3.printSummary();

        p4 = new UPIPayment("P1004", 150000, "XYZ", "xyzw@ybl");
        System.out.println();
        p4.process();
        p4.printSummary();
    }
}
