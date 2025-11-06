/*
 * 4. Create a Class Time
Attributes: hr, min, and sec
Overload the add method to perform the following operations:
• Add Two Time Objects
• Add a Time Object and an Integer Representing Hours/Minutes/Seconds
Display the result in the format hh:mm:ss.
Note: Ensure the time is properly formatted like 24:00:00.
 */

class Time {
    int hr, min, sec;

    Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        validate();
    }

    void validate() {
        if (sec >= 60) {
            min += sec / 60;
            sec %= 60;
        }
        if (min >= 60) {
            hr += min / 60;
            min %= 60;
        }
        
    }
    
    Time add(Time other) {
        return new Time(this.hr + other.hr, this.min + other.min, this.sec + other.sec);
    }

    
    Time add(int value, char unit) {
        unit = Character.toLowerCase(unit);
        switch (unit) {
            case 'h':
                return new Time(this.hr + value, this.min, this.sec);
            case 'm':
                return new Time(this.hr, this.min + value, this.sec);
            case 's':
                return new Time(this.hr, this.min, this.sec + value);
            default:
                System.out.println("Invalid unit. Use 'h', 'm', or 's'.");
                return this;
        }
    }

    void display(Time t) {
        System.out.println( t.hr + ":" + t.min + ":" + t.sec);
    }

    public static void main(String[] args) {
        Time t1 = new Time(23, 50, 30);
        Time t2 = new Time(1, 15, 45);
        t1.display(t1.add(t2)); // 25:06:15
        t1.display(t1.add(2, 'h')); // 25:50:30
        t2.display(t1.add(30, 'm')); // 24:20:30
        t1.display(t1.add(50, 's')); // 23:51:20
    }
}
