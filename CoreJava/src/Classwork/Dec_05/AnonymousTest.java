package Classwork.Dec_05;

interface Mall{
	
	void discount();
}


class FashionMall implements Mall{

	@Override
	public void discount() {
		System.out.println("20% discount");
		
	}
	
}

public class AnonymousTest {

	public static void main(String[] args) {

		Mall m1=new FashionMall();
		m1.discount();

		Mall m2=new FashionMall();
		m2.discount();
		
		new Mall() {
			public void discount() {
				System.out.println("50% discount");
			}
		}.discount();
	}

}
