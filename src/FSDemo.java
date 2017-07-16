
class FailSoftArray	{
	private int a[]; //private int array
	public int errval; //value to return if get fails
	public int length; //array length public
	
	/*Constructor, construct array given size and err to return
	 * if fails
	 */
	FailSoftArray(int size, int errv){
		a = new int[size];
		errval = errv;
		length = size;
	}
	
	public int get(int index){
		if(indexOK(index)) return a[index];
		else return errval; //prevent out of bounds index error
	}
	
	public boolean put(int index, int val){
		if(indexOK(index)){ //prevent out of bounds index error
			a[index] = val;
			return true;
		}
		return false;
	}
	
	private boolean indexOK(int index){
		return (index >= 0) && (index < length);
	}
}

//demonstrate failsoft array
class FSDemo {

	public static void main(String[] args) {
		FailSoftArray fs = new FailSoftArray(5, -1);
		int x;
		
		//show quiet failures
		System.out.println("Fail quietly.");
		for(int i=0; i< (fs.length * 2); i ++){
			fs.put(i, i* 10);
		}
		
		for(int i=0; i<(fs.length*2); i++){
			x = fs.get(i);
			if(x != -1) System.out.print(x + " ");
		}
		System.out.println("");
		
		//now, handle failures
		System.out.println("\nFail with error reports.");
		for(int i=0; i<(fs.length * 2); i ++){
			if(!fs.put(i,  i*10)) System.out.println("Index " + i + " out-of-bounds");
		}
		for(int i=0; i<(fs.length*2); i++){
			x = fs.get(i);
			if(x != -1) System.out.print(x + " ");
			else System.out.println("Index " + i+ " out-of-bounds");
		}
		
	}

}






















