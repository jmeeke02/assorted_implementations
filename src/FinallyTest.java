
public class FinallyTest {
	
	public static String lem(){
		System.out.println("lem");
		return "return from lem";
	}
	
	public static String foo(){
		int x = 0;
		int y = 5;
		try {
			System.out.println("Start try");
			int b = y / x; //Divide by 0 error
			System.out.println("end try");
			return "returned from try";
		}catch(Exception ex){
			System.out.println("catch");
			return lem() + " | returned from catch";
		}finally{
			System.out.println("finally");
		}
	}
	
	public static void bar(){
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bar();
	}

}
