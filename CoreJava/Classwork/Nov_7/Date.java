class Date {
	int date, month, year;
	String dow;

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

	void display() {
		System.out.println("Day is" + this.date);
		System.out.println("Month is" + this.month);
		System.out.println("Year is" + this.year);
		System.out.println("Day of week is" + this.dow);
	}

} 
class DateTest {
	public static void main(String[] abc) {

		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date();
		arr[2] = new Date();

		for(int i = 0; i < arr.length; i++){
			arr[i].display();
		}

	}
} 





