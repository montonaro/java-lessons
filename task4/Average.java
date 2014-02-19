package task4;

public class Average {
	
	public static int sumItems(int[] arr, int length){		
		if((length+1) == arr.length){
			return arr[length];
		} else {
			return arr[length]+sumItems(arr, length+1);
		} 
	}	
	
	public static void main(String [] args){
		
		int [] arr = new int[]{1,2,3,4,5,6,5,7,4,5,6,8,9,5};		
		System.out.println("" + sumItems(arr,0)/arr.length );
		
	}
	
}
