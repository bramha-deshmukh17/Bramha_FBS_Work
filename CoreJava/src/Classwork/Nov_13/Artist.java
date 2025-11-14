package Classwork.Nov_13;

class Artist {
    String name;
    int age;
    String genre;
    int yearsExperience;

    Artist() {}
    

    Artist(String name, int age, String genre, int yearsExperience) {
		super();
		this.name = name;
		this.age = age;
		this.genre = genre;
		this.yearsExperience = yearsExperience;
	}


	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getGenre() {
		return genre;
	}

	void setGenre(String genre) {
		this.genre = genre;
	}

	int getYearsExperience() {
		return yearsExperience;
	}

	void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

    void display() {
        System.out.println("\nArtist Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Genre: " + genre);
        System.out.println("Years of Experience: " + yearsExperience);
    }

    void perform() {
        System.out.println("Artist performs in a general way.");
    }
}

class Painter extends Artist {
    String favoriteMedium; 
    String signatureStyle;

    Painter(){}
    
    Painter(String name, int age, String genre, int yearsExperience, String favoriteMedium, String signatureStyle) {
        super(name, age, genre, yearsExperience);
        this.favoriteMedium = favoriteMedium;
        this.signatureStyle = signatureStyle;
    }

    String getFavoriteMedium() {
		return favoriteMedium;
	}

	void setFavoriteMedium(String favoriteMedium) {
		this.favoriteMedium = favoriteMedium;
	}

	String getSignatureStyle() {
		return signatureStyle;
	}

	void setSignatureStyle(String signatureStyle) {
		this.signatureStyle = signatureStyle;
	}

	void display() {
        super.display();
        System.out.println("Favorite Medium: " + favoriteMedium);
        System.out.println("Signature Style: " + signatureStyle);
    }

    void perform() {
        System.out.println("Painter: Creating a live painting using " + favoriteMedium + " in " + signatureStyle + " style.");
    }
}

class Musician extends Artist {
    String instrument;
    String band;
    
    Musician(){}
    
    Musician(String name, int age, String genre, int yearsExperience, String instrument, String band) {
        super(name, age, genre, yearsExperience);
        this.instrument = instrument;
        this.band = band;
    }

    String getInstrument() {
		return instrument;
	}

	void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	String getBand() {
		return band;
	}

	void setBand(String band) {
		this.band = band;
	}

	void display() {
        super.display();
        System.out.println("Instrument: " + instrument);
        System.out.println("Band: " + band);
    }

    void perform() {
        System.out.println("Musician: Playing " + instrument + " with band '" + band + "' in " + genre + " style.");
    }
}

class Singer extends Artist {
    String vocalRange;
    int numberOfAlbums;
    
    Singer(){}

    Singer(String name, int age, String genre, int yearsExperience, String vocalRange, int numberOfAlbums) {
        super(name, age, genre, yearsExperience);
        this.vocalRange = vocalRange;
        this.numberOfAlbums = numberOfAlbums;
    }

    String getVocalRange() {
		return vocalRange;
	}

	void setVocalRange(String vocalRange) {
		this.vocalRange = vocalRange;
	}

	int getNumberOfAlbums() {
		return numberOfAlbums;
	}

	void setNumberOfAlbums(int numberOfAlbums) {
		this.numberOfAlbums = numberOfAlbums;
	}

	void display() {
        super.display();
        System.out.println("Vocal Range: " + vocalRange);
        System.out.println("Number of Albums: " + numberOfAlbums);
    }

    void perform() {
        System.out.println("Singer: Singing a " + genre + " set using a " + vocalRange + " range.");
    }
}

class TestArtists {
    public static void main(String[] args) {
        Artist a;

        a = new Painter("ABC", 34, "Abstract", 12, "Oil", "Geometric abstraction");
        a.display();
        a.perform();

        a = new Musician("XYZ", 28, "Rock", 8, "Electric Guitar", "The Meteors");
        a.display();
        a.perform();

        a = new Singer("PQR", 30, "Classical", 15, "Mezzo-Soprano", 5);
        a.display();
        a.perform();
    }
}
