
class Quicksort {
	//Set up a call to the actual QuickSort method
	static void qsort(char items[]){
		qs(items, 0, items.length-1);
	}
	
	//a recursive version of Quicksort method
	private static void qs(char items[], int left, int right){
		int i, j;
		char x, y;
		
		i = left; j = right;
		x = items[(left + right) / 2]; //pick an element in the middle of array
		
		do{
			while((items[i] < x) && (i < right)) i ++; //while left item is smaller than middle item && left idx < original right idx
			while((x < items[j]) &&(j > left)) j--; //while right item is bigger than middle item and right idx > original left idx
			
			/*if we find an element where left item is bigger than middle && right item is smaller than middle, 
			 * and we haven't left the bounds of our left and right index's (i and j havent gone out to the ends
			 * we can swap them
			 */
			
			if(i <= j){ 
				y = items[i];
				items[i] = items[j];
				items[j] = y;
				i++; j--; 
			}
			
		}while(i <= j);
		
		//if j didn't make it to the end of the left side, it didn't go through all the elements yet
		//recursive call with j as the new right, its shifted our window down left <<
		if(left < j) qs(items, left, j);
		
		//if i didn't make it to the end of the right size yet, it didnt get through all the elements yet
		//make recursive call with i as the new left, shift our window up right >>
		if(right > i) qs(items, i, right);
	}
}


public class DSDemo {

	public static void main(String[] args) {
		char a[] = {'d', 'x', 'a', 'r', 'p', 'j', 'i'};
		int i;
		
		System.out.print("Original array: ");
		for(i=0; i < a.length; i++){
			System.out.print(a[i]);
		}
		
		System.out.println();
		
		//now sort array with Quicksort static method qsort
		
		Quicksort.qsort(a);
		
		System.out.print("Sorted array: ");
		for(i=0; i < a.length; i++){
			System.out.print(a[i]);
		}
	}

}
