package Assignment.Static;
class ElectricityBill{
    
    static double ratePerUnit = 6.5; 
    
    String customerId;
    String customerName;
    int unitsConsumed;

    ElectricityBill(String customerId, String customerName, int unitsConsumed){
        this.customerId = customerId;
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
    }

    static void setRatePerUnit(double newRate){
        ratePerUnit = newRate;
    }

    static double getRatePerUnit(){
        return ratePerUnit;
    }

    double calculateBill(){
        return unitsConsumed * ratePerUnit;
    }

    String getCustomerId(){
        return customerId;
    }

    String getCustomerName(){
        return customerName;
    }

    int getUnitsConsumed(){
        return unitsConsumed;
    }

}

class ElectricityTest{
    public static void main(String[] args){
        ElectricityBill cust1 = new ElectricityBill("C001", "ABC", 150);
        ElectricityBill cust2 = new ElectricityBill("C002", "XYZ", 250);

        System.out.println("Initial Rate Per Unit: " + ElectricityBill.getRatePerUnit());

        System.out.println(cust1.getCustomerName() + "'s Bill: " + cust1.calculateBill());
        System.out.println(cust2.getCustomerName() + "'s Bill: " + cust2.calculateBill());

        
        ElectricityBill.setRatePerUnit(7.0);
        System.out.println("Updated Rate Per Unit: " + ElectricityBill.getRatePerUnit());

        System.out.println(cust1.getCustomerName() + "'s Bill after change: " + cust1.calculateBill());
        System.out.println(cust2.getCustomerName() + "'s Bill after change: " + cust2.calculateBill());
    }
}