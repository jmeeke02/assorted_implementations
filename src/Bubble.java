
public class Bubble {

	public static void main(String[] args) {
		
		/*Implement Bubble sort, pretty inefficient
		normally O(n) sorting algorithm & this implementation relies on
		2 for loops */
		
		int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
		int a, b, t;
		
		//display original array
		System.out.println("Original array is:");
		for(int i = 0; i < nums.length; i++){
			System.out.print(" " + nums[i]);
		}
		
		System.out.println();
		
		//This is Bubble Sort
		for(a =1; a < nums.length; a ++){
			for(b = nums.length-1; b >= a; b--){
				
				if(nums[b-1] > nums[b]){ //if they are out of order, left > right
					//swap elements
					System.out.println("SWAP " + nums[b-1] + " " + nums[b]);
					t = nums[b-1];
					nums[b-1] = nums[b];
					nums[b] = t;
				}
			}
		}
		
		//display sorted array
		System.out.println("Sorted array is:");
		for(int i = 0; i < nums.length; i++){
			System.out.print(" " + nums[i]);
		}
		System.out.println();
	}

}
