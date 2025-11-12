package Assignment.Inheritance;

class Animal {
    String name;
    int weight, height;
    
    Animal() {
    }

    Animal(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	int getHeight() {
		return height;
	}

	void setHeight(int height) {
		this.height = height;
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

    Dog(String name, String breed, int weight, int height) {
        super(name, height, weight);
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

class Bird extends Animal {
    int wingCount;

    
    
    public Bird(String name, int weight, int height, int wingCount) {
		super(name, height, weight);
		this.wingCount = wingCount;
	}


	int getWingCount() {
		return wingCount;
	}


	void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}


	void display() {
        super.display();
        System.out.println("Wing Count: " + this.wingCount);
    }
}

class AnimalDemo {
    public static void main(String[] args) {
       
        Dog d = new Dog("PQR", "Labrador", 45, 10);
        d.display();
        
        Bird b = new Bird("ABC", 10, 1, 2);
        b.display();

    }
}
