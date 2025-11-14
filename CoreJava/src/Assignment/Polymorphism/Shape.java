package Assignment.Polymorphism;

class Shape {
    String name;

    Shape() {
    }

    Shape(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("\nShape: name=" + name);
    }

    double area() {
        return 0.0;
    }
}

class Triangle extends Shape {
    double baseLength;
    double height;

    Triangle() {
    }

    Triangle(String name, double baseLength, double height) {
        super(name);
        this.baseLength = baseLength;
        this.height = height;
    }

    double getBaseLength() {
        return baseLength;
    }

    void setBaseLength(double baseLength) {
        this.baseLength = baseLength;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double height) {
        this.height = height;
    }

    void display() {
        super.display();
        System.out.println("baseLength=" + this.baseLength);
        System.out.println("height=" + this.height);
    }

    double area() {
        return 0.5 * baseLength * height;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle() {
    }

    Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    double getLength() {
        return length;
    }

    void setLength(double length) {
        this.length = length;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    void display() {
        super.display();
        System.out.println("length=" + this.length);
        System.out.println("width=" + this.width);
    }

    double area() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;

    Circle() {
    }

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    void display() {
        super.display();
        System.out.println("radius=" + this.radius);
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class ShapeDemo {
    public static void main(String[] args) {
        Shape tri = new Triangle("Tri", 10, 5);
        tri.display();
        System.out.println("Area: " + tri.area());

        Shape rect = new Rectangle("Rect", 8, 4);
        rect.display();
        System.out.println("Area: " + rect.area());

        Shape cir = new Circle("Cir", 3);
        cir.display();
        System.out.println("Area: " + cir.area());
    }
}
