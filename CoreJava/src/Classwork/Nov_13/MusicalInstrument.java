package Classwork.Nov_13;


class MusicalInstrument {
    String name;
    String type; 
    String material;
    double price;

    MusicalInstrument() {}

    MusicalInstrument(String name, String type, String material, double price) {
        this.name = name;
        this.type = type;
        this.material = material;
        this.price = price;
    }

    String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	String getMaterial() {
		return material;
	}

	void setMaterial(String material) {
		this.material = material;
	}

	double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	void display() {
        System.out.println("\nInstrument Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Material: " + material);
        System.out.println("Price: " + price);
    }

    void play() {
        System.out.println("Playing a generic instrument sound.");
    }
}

class Tabla extends MusicalInstrument {
    boolean isSyntheticHead;
    double diameterCm;

    Tabla(String name, String material, double price, boolean isSyntheticHead, double diameterCm) {
        super(name, "Percussion", material, price);
        this.isSyntheticHead = isSyntheticHead;
        this.diameterCm = diameterCm;
    }

    boolean isSyntheticHead() {
		return isSyntheticHead;
	}

	void setSyntheticHead(boolean isSyntheticHead) {
		this.isSyntheticHead = isSyntheticHead;
	}

	double getDiameterCm() {
		return diameterCm;
	}

	void setDiameterCm(double diameterCm) {
		this.diameterCm = diameterCm;
	}

	void display() {
        super.display();
        System.out.println("Synthetic Head: " + isSyntheticHead);
        System.out.println("Diameter (cm): " + diameterCm);
    }

    void play() {
        System.out.println("Tabla: Producing rhythmic bols (dhin, na, tin)...");
    }
}

class Guitar extends MusicalInstrument {
    int numberOfStrings;
    boolean isElectric;

    Guitar(String name, String material, double price, int numberOfStrings, boolean isElectric) {
        super(name, "String", material, price);
        this.numberOfStrings = numberOfStrings;
        this.isElectric = isElectric;
    }

    int getNumberOfStrings() {
		return numberOfStrings;
	}

	void setNumberOfStrings(int numberOfStrings) {
		this.numberOfStrings = numberOfStrings;
	}

	boolean isElectric() {
		return isElectric;
	}

	void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}

	void display() {
        super.display();
        System.out.println("Number of strings: " + numberOfStrings);
        System.out.println("Electric: " + isElectric);
    }

    void play() {
        System.out.println("Guitar: Strumming chords and riffs...");
    }
}

class Piano extends MusicalInstrument {
    int numberOfKeys;
    boolean isGrand;

    Piano(String name, String material, double price, int numberOfKeys, boolean isGrand) {
        super(name, "Keyboard", material, price);
        this.numberOfKeys = numberOfKeys;
        this.isGrand = isGrand;
    }

    int getNumberOfKeys() {
		return numberOfKeys;
	}

	void setNumberOfKeys(int numberOfKeys) {
		this.numberOfKeys = numberOfKeys;
	}

	boolean isGrand() {
		return isGrand;
	}

	void setGrand(boolean isGrand) {
		this.isGrand = isGrand;
	}

	void display() {
        super.display();
        System.out.println("Number of keys: " + numberOfKeys);
        System.out.println("Grand piano: " + isGrand);
    }

    void play() {
        System.out.println("Piano: Playing melodic chords and arpeggios...");
    }
}

class TestInstruments {
    public static void main(String[] args) {
        MusicalInstrument inst;

        inst = new Tabla("Royal Tabla Set", "Sheesham", 15000.0, false, 14.0);
        inst.display();
        inst.play();

        inst = new Guitar("Fender Strat", "Alder", 70000.0, 6, true);
        inst.display();
        inst.play();

        inst = new Piano("Yamaha U1", "Maple", 450000.0, 88, true);
        inst.display();
        inst.play();
    }
}
