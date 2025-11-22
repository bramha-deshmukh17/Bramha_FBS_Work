package p2;
import p1.A;
public class X {
	void myFunX() {
		A ref=new A();
		ref.myFunA();
		System.out.println("inside X");
	}
}

class Y extends A{
	void myFunY() {
		A ref=new A();
		ref.myFunA();
		System.out.println("inside Y");
	}
}