package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Average {
	
	public static double action(String str){
		
		double sum 		 = 0; 
		int countNumbers = 0;
		
		if(str.length() > 0){
			String[] items = str.split(" ");
			
			if(items.length > 0){ 
				
				for(int i = 0; i < items.length; i++){
					try {
						double value = Double.parseDouble(items[i]); 
						sum += value; 
						countNumbers++;
					} catch	(NumberFormatException e ){ 
						System.out.println( "Ошибка ввода  " + e);
					}
				} 
				
				if(countNumbers > 0){
					sum = sum/countNumbers;
				}   
			}
			
		}
		
		return sum;
	}
	
	
	public static void main(String args[]){
		
		try { 
			BufferedReader Inner = new BufferedReader(new InputStreamReader(System.in)); 
			
			while(true){
				String str = Inner.readLine(); 
				if(!str.equals(null)){
					double r = action(str); 
					System.out.println( str + " их среднее арифметическое => " + r);
				}
			}  
		} catch (IOException eX) {}   
		
	}
	
	
}
