
class Book {
    int isbn;
    String bname;
    String category;
    int price;

    // Default constructor
    Book() {
        this.isbn = 0;
        this.bname = "";
        this.category = "";
        this.price = 0;
    }

    // Parameterized constructor
    Book(int isbn, String bname, String category, int price) {
        this.isbn = isbn;
        this.bname = bname;
        this.category = category;
        this.price = price;
    }

    // Getters
    int getIsbn() {
        return isbn;
    }

    String getBname() {
        return bname;
    }

    String getCategory() {
        return category;
    }

    int getPrice() {
        return price;
    }

    // Setters
    void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    void setBname(String bname) {
        this.bname = bname;
    }

    void setCategory(String category) {
        this.category = category;
    }

    void setPrice(int price) {
        this.price = price;
    }

    // Display method
    void display() {
        System.out.println("Book Details:");
        System.out.println("ISBN: " + isbn);
        System.out.println("Name: " + bname);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }
}

class BookDemo {
    public static void main(String[] args) {
			
        // Using default constructor and setters
        Book b1 = new Book();
        b1.setIsbn(1001);
        b1.setBname("Abc");
        b1.setCategory("Xyz");
        b1.setPrice(299);
        b1.display();

        // Using getters
        System.out.println("Data: " + b1.getIsbn() + ", " + b1.getBname() + ", " + b1.getCategory() + ", " + b1.getPrice());

        // Using parameterized constructor
        Book b2 = new Book(1002, "PQR", "Abc", 349);
        b2.display();

        // Update via setters and show getters
        b2.setIsbn(1003);
        b2.setBname("Xyz");
        b2.setCategory("PQR");
        b2.setPrice(399);
        b2.display();

       }
}