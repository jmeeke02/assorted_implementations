//Create a second thread
class NewThread implements Runnable {
	Thread t;
	
	NewThread(){
		//create a new second thread
		t = new Thread(this, "Demo Thread"); //called with obj that implements Runnable & name
		System.out.println("Child thread: " + t);
		t.start(); //Start the thread
	}
	
	//This is the entrypoint for the second thread
	public void run(){
		try{
				for(int i = 5; i > 0; i--){
					System.out.println("Child Thread: " + i);
					Thread.sleep(500);
				}
			}catch(InterruptedException e){
				System.out.println("Child interrupted.");
			}
		System.out.println("Exiting child thread.");
	}
}

class NewThread2 extends Thread {
	
	NewThread2(){
		//create a new, second thread
		super("Demo Thread");
		System.out.println("Child thread2: " + this);
		start(); //Start the thread
	}
	
	//This is the entrypoint
	public void run(){
		try{
				for(int i = 5; i > 0; i--){
					System.out.println("Child Thread2: " + i);
					Thread.sleep(1050);
				}
			}catch(InterruptedException e){
				System.out.println("Child2 interrupted.");
			}
		System.out.println("Exiting child thread2.");
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		new NewThread(); //create a new thread
		new NewThread2(); //creates a new thread
		
		try {
			for(int i = 5; i > 0; i--){
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread exiting");
		
	}

}
