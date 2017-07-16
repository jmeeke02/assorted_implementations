//An example of a deadlock
class A{
	synchronized void foo(B b){
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");
		
		try {
			Thread.sleep(1000); //this lets main thread enter a and sleep, so that racing thread can enter b
			
		}catch(Exception e){
			System.out.println("A Interrupted");
		}
		
		System.out.println(name + " trying to call B.last()");
		b.last(); //call B's synchronized method, but the other thread already entered B's monitor
		//wont be able to call any other synchronized method on object B until that other thread exits monitor
	}
	
	synchronized void last(){
		System.out.println("Inside A.last");
	}
}

class B {
	synchronized void bar(A a){
		String name =  Thread.currentThread().getName();
		System.out.println(name + " entered B.bar");
		
		try {
			Thread.sleep(1000); //gives a chance for both threads to enter the monitors of their respective objects
		}catch(Exception e){
			System.out.println("B Interrupted");
		}
		
		System.out.println(name + " trying to call A.last()");
		a.last(); //trying to call A's synchronized method, but other thread already entered A's monitor so
		//can't call any other synchronized method on that object till other thread exits monitor
	}
	
	synchronized void last(){
		System.out.println("Inside A last");
	}
}



class Deadlock implements Runnable{
	
	A a = new A();
	B b = new B();
	
	Deadlock() {
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RacingThread");
		t.start(); //runs the run method
		
		a.foo(b); //send main thread to call a.foo, main will enter a monitor
		System.out.println("Back in main thread"); //ie. the thread finished
	}
	
	public void run(){
		b.bar(a); //send child thread to call b.bar, racing thread will enter b monitor
		System.out.println("Back in other thread");
	}


	public static void main(String[] args) {
		new Deadlock();
	}

}
