package Assignment.Static;
class LibraryUser{
    static double finePerDay = 2.0;

    String name;
    int daysLate;

    LibraryUser(String name, int daysLate){
        this.name = name;
        this.daysLate = daysLate;
    }

    static void setFinePerDay(double newFinePerDay){
        finePerDay = newFinePerDay;
    }

    static double getFinePerDay(){
        return finePerDay;
    }

    double calculateFine(){
        return daysLate * finePerDay;
    }

    String getName(){
        return name;
    }

    int getDaysLate(){
        return daysLate;
    }

}

class LibraryUserTest{
    public static void main(String[] args) {
        LibraryUser user1 = new LibraryUser("PQR", 3);
        LibraryUser user2 = new LibraryUser("Xyz", 5);

        System.out.println("Initial Fine Per Day: " + LibraryUser.getFinePerDay());

        System.out.println(user1.getName() + "'s Fine: " + user1.calculateFine());
        System.out.println(user2.getName() + "'s Fine: " + user2.calculateFine());

        LibraryUser.setFinePerDay(3.0);
        System.out.println("Updated Fine Per Day: " + LibraryUser.getFinePerDay());

        System.out.println(user1.getName() + "'s Fine after change: " + user1.calculateFine());
        System.out.println(user2.getName() + "'s Fine after change: " + user2.calculateFine());
    }
}