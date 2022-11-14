package in.com.raystec.jdbc;

//example of singleton class

//step-1: make class final
public final class SingletonClass {
	
//step-2: declare variable static
	private static SingletonClass tsc;

//step-3: make default constructor private	
	private SingletonClass() {
		//hinder other class to create instance of this class
		
		System.out.println(".............");
	}
	
//step-4: make a getInstance() static method
	public static SingletonClass getInstance() {
		if(null == tsc) {
			tsc = new SingletonClass();
		}
		return tsc;
	}
	
	
	
	//testing of singleton class
	public static class testSingletonClass{
		public static void main(String[] args) {
			SingletonClass tsc = SingletonClass.getInstance();//this can create instance 
			SingletonClass tsc1 = SingletonClass.getInstance();//this can not create instance
		}
	} 
}
