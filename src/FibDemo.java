class Fib{
	
	static int fibonacci(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int memo[] = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for(int i = 2; i < n; i++){
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		return memo[n-1] + memo[n-2];
	}
	
	static int fibonacciOpt(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int a = 0;
		int b = 1;
		int c = a + b;
		for(int i = 2; i < n; i++){
			//each time set b as a, and b as a + b;
			//essentially store result of last iteration into b and a
			//with each cycle, move the last last result into a
			//and move this most recent result into b
			c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
}


public class FibDemo {

	public static void main(String[] args) {
		int r1 = Fib.fibonacci(5);
		
		int r2 = Fib.fibonacciOpt(5);
		
		System.out.print("First: " + r1 + " Second: " + r2);

	}

}
