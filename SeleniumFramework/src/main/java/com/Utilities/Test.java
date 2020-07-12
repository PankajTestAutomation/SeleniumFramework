package com.Utilities;

public class Test {

	public static int a=10;
	public static int b=10;
	
	public static void incrementbyreference(Test x)
	{
		x.b=x.b+1;
		
		System.out.println("Value inside incrementbyreference is :" +x.b);
	}
	
	
	public static void incrementbyvalue(int x) {
		x=x+1;
		System.out.println("Value inside incrementbyvalue method :" +x);
	}
	
	
	public static void main(String[] args) {
				
		System.out.println("Value of a before incrementbyvalue ->" +a);
		System.out.println("Value of b before incrementbyreference ->" +b);
		
		Test t=new Test();
		
		incrementbyreference(t);
		incrementbyvalue(a);
		
		System.out.println("Global value of a after incrementbyvalue ->" +a);
		System.out.println("Global value of b after incrementbyreference ->" +b);
		

	}

}
