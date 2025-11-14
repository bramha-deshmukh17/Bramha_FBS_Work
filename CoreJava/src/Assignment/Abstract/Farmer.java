package Assignment.Abstract;

abstract class Farmer {
    int farmerId, annualIncome, noOfEquipment;
    String farmerName, city;
    double landArea, insuranceAmt;

    Farmer() {
    }

    Farmer(int farmerId, int annualIncome, int noOfEquipment, String farmerName, String city, double landArea,
            double insuranceAmt) {
        this.farmerId = farmerId;
        this.annualIncome = annualIncome;
        this.noOfEquipment = noOfEquipment;
        this.farmerName = farmerName;
        this.city = city;
        this.landArea = landArea;
        this.insuranceAmt = insuranceAmt;
    }

    int getFarmerId() {
		return farmerId;
	}

	void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	int getAnnualIncome() {
		return annualIncome;
	}

	void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	int getNoOfEquipment() {
		return noOfEquipment;
	}

	void setNoOfEquipment(int noOfEquipment) {
		this.noOfEquipment = noOfEquipment;
	}

	String getFarmerName() {
		return farmerName;
	}

	void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	String getCity() {
		return city;
	}

	void setCity(String city) {
		this.city = city;
	}

	double getLandArea() {
		return landArea;
	}

	void setLandArea(double landArea) {
		this.landArea = landArea;
	}

	double getInsuranceAmt() {
		return insuranceAmt;
	}

	void setInsuranceAmt(double insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public String toString() {
        return "Farmer Id: " + farmerId + " Farmer Name: " + farmerName + " City: " + city + " Annual Income: "
                + annualIncome + " Number of Equipment: " + noOfEquipment + " Land Area: " + landArea
                + " Insurance Amount: " + insuranceAmt;
    }

    abstract void calSubsidy();
}

class DairyFarmer extends Farmer {
    int noOfCattles, milkProducedPerDay, dairyLicenceNumber;

    DairyFarmer() {
    }

    DairyFarmer(int farmerId, int annualIncome, int noOfEquipment, String farmerName, String city, double landArea,
            double insuranceAmt, int noOfCattles, int milkProducedPerDay, int dairyLicenceNumber) {
        super(farmerId, annualIncome, noOfEquipment, farmerName, city, landArea, insuranceAmt);
        this.noOfCattles = noOfCattles;
        this.milkProducedPerDay = milkProducedPerDay;
        this.dairyLicenceNumber = dairyLicenceNumber;
    }

    int getNoOfCattles() {
		return noOfCattles;
	}

	void setNoOfCattles(int noOfCattles) {
		this.noOfCattles = noOfCattles;
	}

	int getMilkProducedPerDay() {
		return milkProducedPerDay;
	}

	void setMilkProducedPerDay(int milkProducedPerDay) {
		this.milkProducedPerDay = milkProducedPerDay;
	}

	int getDairyLicenceNumber() {
		return dairyLicenceNumber;
	}

	void setDairyLicenceNumber(int dairyLicenceNumber) {
		this.dairyLicenceNumber = dairyLicenceNumber;
	}

	public String toString() {
        return super.toString() + " Number of Cattles: " + noOfCattles + " Milk Produced Per Day: "
                + milkProducedPerDay + " Dairy Licence Number: " + dairyLicenceNumber;
    }

    void calSubsidy() {
        System.out.println("Subsidy taken on basis of cows");
    }
}

class PoultryFarmer extends Farmer {
    int noOfChickens, noOfShades, eggProducedPerDay;
    String farmName;

    PoultryFarmer() {
    }

    PoultryFarmer(int farmerId, int annualIncome, int noOfEquipment, String farmerName, String city, double landArea,
            double insuranceAmt, int noOfChickens, int noOfShades, int eggProducedPerDay, String farmName) {
        super(farmerId, annualIncome, noOfEquipment, farmerName, city, landArea, insuranceAmt);
        this.noOfChickens = noOfChickens;
        this.noOfShades = noOfShades;
        this.eggProducedPerDay = eggProducedPerDay;
        this.farmName = farmName;
    }

    int getNoOfChickens() {
		return noOfChickens;
	}

	void setNoOfChickens(int noOfChickens) {
		this.noOfChickens = noOfChickens;
	}

	int getNoOfShades() {
		return noOfShades;
	}

	void setNoOfShades(int noOfShades) {
		this.noOfShades = noOfShades;
	}

	int getEggProducedPerDay() {
		return eggProducedPerDay;
	}

	void setEggProducedPerDay(int eggProducedPerDay) {
		this.eggProducedPerDay = eggProducedPerDay;
	}

	String getFarmName() {
		return farmName;
	}

	void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public String toString() {
        return super.toString() + " Number of Chickens: " + noOfChickens + " Number of Shades: "
                + noOfShades + " Egg Produced Per Day: " + eggProducedPerDay + " Farm Name: " + farmName;
    }

    void calSubsidy() {
        System.out.println("Subsidy taken on basis of hens");
    }
}

class OrganicFarmer extends Farmer {
    int organicId;
    String cropType, fertilizerUsed;

    OrganicFarmer() {
    }

    OrganicFarmer(int farmerId, int annualIncome, int noOfEquipment, String farmerName, String city, double landArea,
            double insuranceAmt, int organicId, String cropType, String fertilizerUsed) {
        super(farmerId, annualIncome, noOfEquipment, farmerName, city, landArea, insuranceAmt);
        this.organicId = organicId;
        this.cropType = cropType;
        this.fertilizerUsed = fertilizerUsed;
    }

    int getOrganicId() {
		return organicId;
	}

	void setOrganicId(int organicId) {
		this.organicId = organicId;
	}

	String getCropType() {
		return cropType;
	}

	void setCropType(String cropType) {
		this.cropType = cropType;
	}

	String getFertilizerUsed() {
		return fertilizerUsed;
	}

	void setFertilizerUsed(String fertilizerUsed) {
		this.fertilizerUsed = fertilizerUsed;
	}

	public String toString() {
        return super.toString() + " Organic Id: " + organicId + " Crop Type: " + cropType + " Fertilizer Used: "
                + fertilizerUsed;
    }

    void calSubsidy() {
        System.out.println("Subsidy taken on the basis of crop type");
    }
}

class FarmerDemo {
    public static void main(String[] args) {

        Farmer df = new DairyFarmer(1, 50000, 10, "ABC", "Pune", 5.0, 10000, 20, 100, 12345);
        Farmer pf = new PoultryFarmer(2, 60000, 15, "PQR", "Mumbai", 10.0, 15000, 100, 5, 200, "Lucky Farm");
        Farmer of = new OrganicFarmer(3, 70000, 20, "XYZ", "Chennai", 15.0, 20000, 54321, "Wheat",
                "Organic Fertilizer");

        System.out.println(df.toString());
        df.calSubsidy();

        System.out.println(pf);
        pf.calSubsidy();

        System.out.println(of.toString());
        of.calSubsidy();
    }
}
