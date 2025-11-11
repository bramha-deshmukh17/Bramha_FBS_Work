/*
 * 2. Create Classes for Triangle, Rectangle, and Circle
Create a class Shape and write overloaded functions to calculate the area of different shapes:
• Triangle (base and height)
• Rectangle (length and breadth)
• Circle (radius)
 */
package Assignment.Function_Overloading;
class Triangle {

    double base, height;
    Triangle (double base, double height) {
        this.base = base;
        this.height = height;
    }

 }

class Rectangle {

    double length, breadth;
    Rectangle (double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

   
}

class Circle {
    double radius;

    Circle (double radius) {
        this.radius = radius;
    }
   
}

class Shape{

    double area(Triangle triangle) {
        return 0.5 * triangle.base * triangle.height;
    }

    double area(Rectangle rectangle) {
        return rectangle.length * rectangle.breadth;
    }

    double area(Circle circle) {
        return 3.14 * circle.radius * circle.radius;
    }

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3.0, 4.0);
        Rectangle rectangle = new Rectangle(5.0, 6.0);
        Circle circle = new Circle(7.0);

        Shape s1=new Shape();
        System.out.println("Triangle area: " + s1.area(triangle));
        System.out.println("Rectangle area: " + s1.area(rectangle));
        System.out.println("Circle area: " + s1.area(circle));
    }
}
