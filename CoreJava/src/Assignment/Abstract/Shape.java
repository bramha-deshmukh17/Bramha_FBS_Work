package Assignment.Abstract;

abstract class Shape {
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

    public String toString() {
        return "Shape: name=" + name;
    }

    abstract double area();
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

    public String toString() {
        return super.toString() + " baseLength=" + baseLength + " height=" + height;
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

    public String toString() {
        return super.toString() + " length=" + length + " width=" + width;
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

    public String toString() {
        return super.toString() + " radius=" + radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class ShapeDemo {
    public static void main(String[] args) {
        Shape tri = new Triangle("Tri", 10, 5);
        System.out.println(tri.toString());
        System.out.println("Area: " + tri.area());

        Shape rect = new Rectangle("Rect", 8, 4);
        System.out.println(rect);
        System.out.println("Area: " + rect.area());

        Shape cir = new Circle("Cir", 3);
        System.out.println(cir.toString());
        System.out.println("Area: " + cir.area());
    }
}
