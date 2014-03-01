package task5;

import java.util.Arrays;

public class SumArrays {
	
	private int minimalElements 	= 2;
	private int keyTop 		= 0;
	private int keyBottom 		= 0;
	private int [] arr;
	
	public void sum(){
		
		 keyTop = keyTop/2;		  
		 
		 for(int i = keyBottom; i < keyTop; i++){
			 
			 if((i+keyTop) < arr.length){
				 arr[i] = arr[i]+arr[i+keyTop];
			 }
		 }
		 
		 if(keyTop > minimalElements){ 
			 showArray();
			 sum();
		 }  
	}
	
	public void showArray(){		
		
		System.out.print("[");
		for(int i = keyBottom; i < keyTop; i++){
			System.out.print(arr[i]);			
			if(i+1 < keyTop){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	public SumArrays(int minElements, int [] arr) throws Exception{		
		
		if(arr.length == 0 ){ 
			throw new Exception("Длина массива равна нулю!");	
		}
		
		this.arr 		= arr;
		minimalElements = minElements;
		this.keyTop 	= arr.length;
	}
	
	public static void main(String[] args) {

		int [] arr = new int[]{1,2,3,4,5,6,5,4,3,2,3,4,5,6,5,3,2,2,3,4,5}; 		
		
		System.out.println(Arrays.toString(arr));
		
		SumArrays obj;
		try {
			obj = new SumArrays(2, arr);
			obj.sum();
			obj.showArray();
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}		
	} 
	
}
