
class Queue {
	private char q[]; //this array holds the queue
	private int putloc, getloc; //the put and get indices
	
	Queue(int size){
		q = new char[size]; //allocate memory for the queue
		putloc = getloc = 0; //set put and get indices
	}
	
	//Construct a Queue from another Queue
	Queue(Queue ob){
		putloc = ob.putloc;
		getloc = ob.getloc;
		q = new char[ob.q.length];
		
		//copy elements
		for(int i= getloc; i < putloc; i++){
			
			//DOING THIS GIVES - Queue is full errors
			// must be using obs array but not sure why
			// put(ob.get());
			q[i] = ob.q[i];
		}
	}
	//Construct a Queue with initial values
	Queue(char a[]){
		putloc = getloc = 0;
		q = new char[a.length];
		
		for(int i = 0; i < a.length; i++) put(a[i]);
	}
	
	//put a character into the queue
	void put(char ch){ //unnecessary to do typecheck on ch, Java will type check it implictly
		System.out.println(putloc + " " + q.length);
		if(putloc  == q.length){
			System.out.println(" - Queue is full.");
			return;
		}
		
		q[putloc++] = ch;
	}
	
	//get character from the queue
	char get(){
		if(getloc == putloc){
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}
		return q[getloc++];
	}
}

//Demonstrate the Queue class
class QueueDemo{
	public static void main(String[] args) {
		Queue bigQ = new Queue(100);
		Queue smallQ = new Queue(4);
		char ch;
		int i;
		
		System.out.println("Using bigQ to store the alphabet");
		//put some numbers into bigQ
		for(i=0; i<26; i++){
			bigQ.put( (char) ('A' + i)); //casting to a character
		}
		
		// retrieve and display elements from bigQ
		System.out.println("Contents of bigQ: ");
		for(i=0; i < 26; i++){
			ch = bigQ.get();
			if(ch != (char) 0) System.out.print(ch);
		}
		
		System.out.println("\n");
		
		
		System.out.println("Using smallQ to generate errors");
		//Now use smallQ to generate some errors
		for(i=0; i<5; i++){
			System.out.print("Attempting to store " + (char) ('Z' - i));
			
			smallQ.put((char) ('Z' - i));
			
			System.out.println();
		}
		System.out.println();
		
		//more errors on smallQ
		
		System.out.print("Contents of smallQ: ");
		for(i=0; i < 5; i++){
			ch = smallQ.get();
			
			if(ch != (char) 0) System.out.print(ch);
		}
		
	}
}