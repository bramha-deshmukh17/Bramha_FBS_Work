package p1;

public class A {
	public A() {}
	
	public void myFunA() {
		System.out.println("inside A");
		A ref=new A();
		ref.myFunA();
	}
}

class B extends A{
	public B() {}
	
	public void myFuncB() {
		System.out.println("inside B");
		A ref=new A();
		ref.myFunA();
	}
}

class C{
	public C() {}
	
	public void myFunC() {
		System.out.println("inside C");
		A ref=new A();
		ref.myFunA();
	}
}
