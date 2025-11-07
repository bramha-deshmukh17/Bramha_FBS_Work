class Printer{

	void print(){
		System.out.println("Print");
	}

	void print(int a){
		System.out.println(a);
	}

	void print(char ch){
		System.out.println(ch);
	}

	void print(String str){
		System.out.println(str);
	}

}

class PrinterDemo{

	public static void main(String[] args){
	
		Printer p1=new Printer();

		p1.print();
		p1.print(10);
		p1.print('B');
		p1.print("Sachin");
	}	
}