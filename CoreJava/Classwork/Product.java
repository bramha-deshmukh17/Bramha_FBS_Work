class Product {
    int prodid;
    String pname;
    int price;
    int quantity;

    // Default constructor
    Product() {
        this.prodid = 0;
        this.pname = "";
        this.price = 0;
        this.quantity = 0;
    }

    // Parameterized constructor
    Product(int prodid, String pname, int price, int quantity) {
        this.prodid = prodid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    int getProdid() {
        return prodid;
    }

    String getPname() {
        return pname;
    }

    int getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    // Setters
    void setProdid(int prodid) {
        this.prodid = prodid;
    }

    void setPname(String pname) {
        this.pname = pname;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display method
    void display() {
        System.out.println("Product Details:");
        System.out.println("ProdId: " + prodid);
        System.out.println("Name: " + pname);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class ProductDemo {
    public static void main(String[] args) {
        // Using default constructor and setters
        Product p1 = new Product();
        p1.setProdid(101);
        p1.setPname("Abc");
        p1.setPrice(1500);
        p1.setQuantity(3);
        p1.display();

        // Using getters
        System.out.println("Data: " + p1.getProdid() + ", " + p1.getPname() + ", " + p1.getPrice() + ", " + p1.getQuantity());

        // Using parameterized constructor
        Product p2 = new Product(102, "PQR", 2000, 5);
        p2.display();

        // Update via setters and show getters
        p2.setProdid(103);
        p2.setPname("Xyz");
        p2.setPrice(2500);
        p2.setQuantity(7);
        System.out.println("Data: " + p2.getProdid() + ", " + p2.getPname() + ", " + p2.getPrice() + ", " + p2.getQuantity());
    }
}
