package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarCipher {
	
	private static int step    			= 3;
	private static String alphabetUP 	= "јЅ¬√ƒ≈®∆«»… ЋћЌќѕ–—“”‘’÷„ЎўЏџ№Ёёя";  
	private static boolean right 		= true;
	
	public static char getLetter(char letter){
		
		char ouChar 	= 0;
		String alphabet = "";
		
		if(Character.isLowerCase(letter)){ 
			alphabet = alphabetUP.toLowerCase();
		} else { 
			alphabet = alphabetUP;
		} 
		 
		int index = alphabet.indexOf(letter);
		int length= alphabet.length();

		if(right){
			if(index+step < length){
				ouChar = alphabet.charAt(index+step);
			} else { 
				ouChar = alphabet.charAt( (index+step) - length ); 
			} 
		} else { 
			
			if(index-step >= 0){
				ouChar = alphabet.charAt(index-step);
			} else { 
				ouChar = alphabet.charAt( length + (index-step) ); 
			} 
		}
		
		return ouChar;
	} 
	
	
	public static String encrypt(String str){
		
		String outString = "";
		
		for(int i=0; i < str.length(); i++){ 
			
			int value = Character.valueOf(str.charAt(i));  
			if( (value == 1025 || value == 1105) || (value >= 1040 && value <= 1103) ){				
				outString += getLetter(str.charAt(i));
			} else {
				outString += str.charAt(i);
			}
		}	
		
		return outString;
	}
	
	public static void main(String args[]){
		
		System.out.print("¬ведите текст дл€ перевода: ");
		
		try { 
			BufferedReader Inner = new BufferedReader(new InputStreamReader(System.in)); 
			
			while(true){ 
				
				String str = Inner.readLine(); 
				try	{
					String result = "";
					
					if(str.length() > 3){
						String test = str.substring(0, 2);
						
						if(test.equals("-d")){ 
							
							try {
								step = Integer.parseInt(""+str.charAt(2)); 
							} catch	(NumberFormatException e ){}
							
							right = false;							
							result = encrypt(str.substring(3, str.length()));
						}
					} 
					
					if(result.equals("")){ 
						result = encrypt(str); 
					}
					
					System.out.print("–езультат: "+result);
				} catch (NullPointerException e) {}
				
			 
				System.out.println("");
				System.out.print("¬ведите текст дл€ перевода: ");
			}  
		} catch (IOException eX) {}   
		
	}
}
