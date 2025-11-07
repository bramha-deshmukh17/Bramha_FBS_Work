class Test{

	public static void main(String[] args){
		
		String cname1="Firstbit";
		String cname2="Firstbit";
		
		System.out.println(cname1);
		System.out.println(cname2);


		String str=new String("Firstbit");
		
		if(cname1==cname2){
			System.out.println("Equal");
		}
		else{
			System.out.println("Not Equal");
		}

		//if(cname2==str){
		if(cname1.equals(str)){
			System.out.println("Equal");
		}
		else{
			System.out.println("Not Equal");
		}


		cname2="Infosys";
		System.out.println(cname1);
		System.out.println(cname2);

		if(cname1==cname2){
			System.out.println("Equal");
		}
		else{
			System.out.println("Not Equal");
		}
	
	}

}