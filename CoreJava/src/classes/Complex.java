package classes;
class Complex {
    int real;
    int imaginary;

    // Default constructor
    Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    // Parameterized constructor
    Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getters
    int getReal() {
        return real;
    }

    int getImaginary() {
        return imaginary;
    }

    // Setters
    void setReal(int real) {
        this.real = real;
    }

    void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    // Display method
    void display() {
        System.out.println("Complex Number:");
        System.out.println("Real: " + real);
        System.out.println("Imaginary: " + imaginary);
    }
}

class ComplexDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Complex c1 = new Complex();
        c1.setReal(3);
        c1.setImaginary(4);
        c1.display();

        // Using getters
        System.out.println("Data: " + c1.getReal() + ", " + c1.getImaginary());

        // Using parameterized constructor
        Complex c2 = new Complex(5, 6);
        c2.display();

        // Update via setters and show getters
        c2.setReal(7);
        c2.setImaginary(8);
        System.out.println("Data: " + c2.getReal() + ", " + c2.getImaginary());
    }
}