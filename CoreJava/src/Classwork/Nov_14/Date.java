package Classwork.Nov_14;

class Date {
	int date, month, year;
	String dow;
	Date(){}

	Date(int date, int month, int year, String dow) {
		this.date = date;
		this.month = month;
		this.year = year;
		this.dow = dow;
	}

	void setDay(int x) {
		this.date = x;
	}

	void setMonth(int y) {
		this.month = y;
	}

	void setYear(int z) {
		this.year = z;
	}

	void setDOW(String str) {
		this.dow = str;
	}

	int GetDay() {
		return this.date;
	}

	int GetMonth() {
		return this.date;
	}

	int GetYear() {
		return this.date;
	}

	String GetDOW() {
		return this.dow;
	}

	
	public String toString() {
		return "Date is: " + this.date + "/" + this.month + "/" + this.year + " - " + this.dow;
	}
} 
class DateTest {
	public static void main(String[] args) {
		
		Date d1=new Date(14, 11, 2025, "Friday");
		System.out.println(d1);
		System.out.println(d1.toString());
	}
} 





