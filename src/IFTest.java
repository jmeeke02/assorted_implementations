
//define an integer stack interface
interface IntStack {
	void push(int item); //store an item
	int pop(); //retrieve an item from stack
}

//An Implementation of IntStack that uses fixed storage
class FixedStack implements IntStack {
	private int[] stck;
	private int tos;
	
	//allocate and initialize stack
	FixedStack(int size){
		stck = new int[size];
		tos = -1;
	}
	
	//push an item onto stack (required by interface)
	//interface methods must be public
	public void push(int item){
		if(tos == stck.length-1){ //use length number
			System.out.println("Stack is full");
		}else
			stck[++tos] = item;
	}
	
	public int pop(){
		if(tos < 0){
			System.out.println("Stack underflow");
			return 0;
		}else{
			return stck[tos--];
		}
	}
}

//Create a dynamic stack, implement a growable stack
class DynStack implements IntStack {
	private int stck[];
	private int tos;
	
	//allocate and initialize stack
	DynStack(int size){
		stck = new int[size];
		tos = -1;
	}
	
	public void push(int item){
		//if array full, allocate larger stack
		if(tos == stck.length-1){
			int temp[] = new int[stck.length * 2]; //double the size
			for(int i=0; i< stck.length; i++) temp[i] = stck[i];
			stck = temp;
		}
		stck[++tos] = item;
	}
	
	public int pop(){
		if(tos < 0){
			System.out.println("Stack underflow");
			return -1;
		}else{
			return stck[tos--];
		}
	}
}


public class IFTest {
	public static void main(String args[]){
		IntStack mystack; //create an interface reference variable
		DynStack ds = new DynStack(5);
		FixedStack fs = new FixedStack(8);
		
		mystack = ds; //load dynamic stack into interface reference variable
		for(int i = 0; i < 12; i ++) mystack.push(i); //push some numbers onto stack
		
		mystack = fs;
		for(int i = 0; i < 8; i++) mystack.push(i);
		
		mystack=ds;
		System.out.println("Values in dynamic stack");
		for(int i = 0; i < 12; i ++) System.out.println(mystack.pop());

		mystack=fs;
		System.out.println("Values in fixed stack");
		for(int i = 0; i < 8; i ++) System.out.println(mystack.pop());
		
	}
	
}
