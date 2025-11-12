package Assignment.Inheritance;

class Organization {
    String name;
    String headquarters;
    int totalEmployees;
    double annualBudget;

    Organization() {
    }

    Organization(String name, String headquarters, int totalEmployees, double annualBudget) {
        this.name = name;
        this.headquarters = headquarters;
        this.totalEmployees = totalEmployees;
        this.annualBudget = annualBudget;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getHeadquarters() {
        return headquarters;
    }

    void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    int getTotalEmployees() {
        return totalEmployees;
    }

    void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    double getAnnualBudget() {
        return annualBudget;
    }

    void setAnnualBudget(double annualBudget) {
        this.annualBudget = annualBudget;
    }

    void display() {
        System.out.println("Organization Name: " + name);
        System.out.println("Headquarters: " + headquarters);
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Annual Budget: " + annualBudget);
    }
}

class Sales extends Organization {
    String region;
    double quarterlyQuota;

    Sales() {
    }

    Sales(String name, String headquarters, int totalEmployees, double annualBudget, String region,
            double quarterlyQuota) {
        super(name, headquarters, totalEmployees, annualBudget);
        this.region = region;
        this.quarterlyQuota = quarterlyQuota;
    }

    String getRegion() {
        return region;
    }

    void setRegion(String region) {
        this.region = region;
    }

    double getQuarterlyQuota() {
        return quarterlyQuota;
    }

    void setQuarterlyQuota(double quarterlyQuota) {
        this.quarterlyQuota = quarterlyQuota;
    }

    void display() {
        super.display();
        System.out.println("Region: " + region);
        System.out.println("Quarterly Quota: " + quarterlyQuota);
    }
}

class HR extends Organization {
    int numberOfRecruitments;
    double payrollBudget;

    HR() {
    }

    HR(String name, String headquarters, int totalEmployees, double annualBudget, int numberOfRecruitments,
            double payrollBudget) {
        super(name, headquarters, totalEmployees, annualBudget);
        this.numberOfRecruitments = numberOfRecruitments;
        this.payrollBudget = payrollBudget;
    }

    int getNumberOfRecruitments() {
        return numberOfRecruitments;
    }

    void setNumberOfRecruitments(int numberOfRecruitments) {
        this.numberOfRecruitments = numberOfRecruitments;
    }

    double getPayrollBudget() {
        return payrollBudget;
    }

    void setPayrollBudget(double payrollBudget) {
        this.payrollBudget = payrollBudget;
    }

    void display() {
        super.display();
        System.out.println("Number Of Recruitments: " + numberOfRecruitments);
        System.out.println("Payroll Budget: " + payrollBudget);
    }
}

class IT extends Organization {
    int serversCount;
    int softwareLicenses;

    IT() {
    }

    IT(String name, String headquarters, int totalEmployees, double annualBudget, int serversCount,
            int softwareLicenses) {
        super(name, headquarters, totalEmployees, annualBudget);
        this.serversCount = serversCount;
        this.softwareLicenses = softwareLicenses;
    }

    int getServersCount() {
        return serversCount;
    }

    void setServersCount(int serversCount) {
        this.serversCount = serversCount;
    }

    int getSoftwareLicenses() {
        return softwareLicenses;
    }

    void setSoftwareLicenses(int softwareLicenses) {
        this.softwareLicenses = softwareLicenses;
    }

    void display() {
        super.display();
        System.out.println("Servers Count: " + serversCount);
        System.out.println("Software Licenses: " + softwareLicenses);
    }
}

class OrganizationDemo {
    public static void main(String[] args) {
        Sales sales = new Sales("TATA group", "Mumbai", 1200, 12_000_000.0, "APAC", 2_500_000.0);
        HR hr = new HR("TATA group", "Mumbai", 1200, 12_000_000.0, 40, 3_000_000.0);
        IT it = new IT("TATA group", "Mumbai", 1200, 12_000_000.0, 50, 200);

        System.out.println("Sales:");
        sales.display();

        System.out.println("\nHR:");
        hr.display();

        System.out.println("\nIT:");
        it.display();
    }
}
