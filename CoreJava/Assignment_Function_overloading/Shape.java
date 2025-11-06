/*
 * 2. Create Classes for Triangle, Rectangle, and Circle
Create a class Shape and write overloaded functions to calculate the area of different shapes:
• Triangle (base and height)
• Rectangle (length and breadth)
• Circle (radius)
 */

class Triangle {

    double area(double base, double height) {
        return 0.5 * base * height;
    }

 }

class Rectangle {

    double area(double length, double breadth) {
        return length * breadth;
    }

   
}

class Circle {

    double area(double radius) {
        return 3.14 * radius * radius;
    }
    
   
}

class Shape {

    public static void main(String[] args) {
        

        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        System.out.println("Triangle area: " + triangle.area(3.0, 4.0));
        System.out.println("Rectangle area: " + rectangle.area(5.0, 6.0));
        System.out.println("Circle area: " + circle.area(7.0));
    }
}
