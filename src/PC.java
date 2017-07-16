
//Corrected implementation of the Producer and consumer
class Q {
	int n;
	boolean valueSet = false;
	
	synchronized int get(){
		while(!valueSet){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("Interrupted exception caught");
			}
		}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}
	
	synchronized void put(int n){
		while(valueSet){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("InterruptedException caught");
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}

//new thread by implementing runnable interface
class Producer implements Runnable {
	Q q;
	
	Producer(Q q){
		this.q = q;
		new Thread(this, "Producer").start();
	}
	
	public void run(){
		int i = 0;
		
		while(i<10){
			q.put(i++); //put a incrementing number in the queue
		}
	}
}

class Consumer implements Runnable {
	Q q;
	
	Consumer(Q q){
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	
	public void run(){
		int i = 0;
		while(i< 10){
			i++;
			q.get();
		}
	}
}



public class PC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		
		System.out.println("Press Control-C to stop.");
	}

}
