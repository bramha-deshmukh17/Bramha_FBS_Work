package Assignment.Inheritance;

class Animal {
    String name;

    Animal() {
    }

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Animal: name=" + this.name);
    }
}

class Dog extends Animal {
    String breed;

    Dog() {
    }

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    String getBreed() {
        return breed;
    }

    void setBreed(String breed) {
        this.breed = breed;
    }

    void display() {
        super.display();
        System.out.println("Breed: " + this.breed);
    }
}

class Cat extends Animal {
    String color;

    Cat() {
    }

    Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    void display() {
        super.display();
        System.out.println("Color: " + this.getColor());
    }
}

class AnimalDemo {
    public static void main(String[] args) {
       
        Dog d = new Dog("Rex", "Labrador");
        d.display();

        Cat c = new Cat("Mimi", "White");
        c.display();
    }
}
