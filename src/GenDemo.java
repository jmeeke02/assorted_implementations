//A simple generic class
//Here T is a parameter that will be replaced
//by a real timpe
//when an object of Gen is created
class Gen<T> {
	T ob; //declare an object of type T
	
	//pass the constructor a reference to an
	//object of type T
	Gen(T o){
		ob = o;
	}
	
	//return ob
	T getob(){
		return ob;
	}
	
	//Show type
	void showType(){
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}

class NonGen {
	Object ob; //ob is now of type Object
	
	//Pass the constructor a reference to 
	//an object of type Object
	NonGen(Object o){
		ob = 0;
	}
	
	Object getOb(){
		return ob;
	}
	
	void showType(){
		System.out.println("Type of ob is " + ob.getClass().getName());
	}
}

//Demonstrate Generic Class
public class GenDemo {

	public static void main(String[] args) {
		//Create a Gen reference for integers
		Gen<Integer> iOb;
		
		//Create a Gen<Integer> Object, assign its reference to iOb
		//Notice use of autoboxing to encapsulate the vlaue 88 within
		//and Integer object.
		
		iOb = new Gen<Integer>(88);
		
		//Show the type of data used by iOb
		iOb.showType();
		
		
		//Get value of iOb. No cast is needed
		int v = iOb.getob(); //don't need cast from Integer to primitive int
		System.out.println("value: " + v);
		
		System.out.println();
		
		
		//Create a Gen reference for Strings
		Gen<String> strOb = new Gen<String> ("Generics Test");
		
		strOb.showType();
		
		//Get value of strOb, again notice no cast is needed
		String str = strOb.getob();
		System.out.println("value: " + str);
		
		System.out.println();
		//DemonStrate NonGen Object
		
		NonGen iOb2;
		iOb2 = new NonGen(88);
		
		iOb2.showType();
		
		//Get value of iOb
		//need to cast as neccessary
		
		int v2 = (Integer) iOb2.getOb();
		
		System.out.println("value: " + v2);
		
		System.out.println();
		
		//Create another NonGen wtih String
		
		NonGen strOb2 = new NonGen("Non-Generics Test");
		
		strOb2.showType();
		
		//Get value and cast
		String str2 = (String) strOb2.getOb();
		System.out.println("value: " + str);
		
		//This compiles but is conceptually wrong because they are of different input types
		
		iOb2 = strOb2; //Wrong
		v2 = (Integer) iOb2.getOb(); //This will produce a runtime error, since trying to case String into integer
	}

}
