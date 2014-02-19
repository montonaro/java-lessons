package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Convert {
	 
	 
	public static String out10(int number, int in){
		
		String result 	= "";
		int tmp 		= number;  
		
		Stack theStack = new Stack(10);
		
		while(tmp > in){  			
			theStack.push(tmp%in);   
			tmp = tmp/in;
		}
		
		if(tmp <= in){ 
			theStack.push(tmp);
		}  
		
		if(in == 16){
			result  += "0x";
		}
		
		while( !theStack.isEmpty() ) {                              
	        int value = theStack.pop();    
	        
	        if(in == 16 && value > 9){
	        	switch(value){
		        	case 10:
	    				result += 'A';
	    			break;
		        	case 11:
        				result += 'B';
        			break;
		        	case 12:
        				result += 'C';
        			break;
		        	case 13:
        				result += 'D';
        			break;
		        	case 14:
        				result += 'E';
        			break;
		        	case 15:
        				result += 'F';
        			break;
	        	}
	        } else {
	        	result += value;
	        }
	        
	    }  
		
		return result;
	}

	/**	
	 * @param str - ��������
	 * @param in �� ����� �������
	 * @return - 10� �����
	 */
	public static int to10(String str, int in ){
		
		int result = 0;
		int count  = str.length();
		
		for(int i=0; i < str.length(); i++){ 
			count--;  
			int x = Character.getNumericValue(str.charAt(i));  
			result += x*(Math.pow(in, count));   
		}
		
		return result;
	}
	
	/**
	 * ����� ��� �������� �� ���������� ���� �����
	 * @param str -  ��� ����������� �� �������
	 * @param max - ������� ������� �� ����� �������� true
	 * @return true/false
	 */
	public static boolean checkRow(String str, int max){
		
		boolean status = true;
		
		for(int i=0; i < str.length(); i++){ 
			
			if(Character.getNumericValue(str.charAt(i)) > max){
				status = false;
				break;
			} 
		}
		
		return status;		
	}
	
	public static void main(String args[]){
		
		System.out.print("������� ������������� �����: ");
		
		try { 
			BufferedReader Inner = new BufferedReader(new InputStreamReader(System.in)); 
			
			while(true){ 
				
				String str = Inner.readLine(); 
				if(!str.equals(null)){  
					
					boolean decimal = true;
					String subString = "";
					
					if(str.length() > 2){
						String test = str.substring(0, 2);
						
						if(test.equals("0x")){
							decimal   = false; 
							subString = str.substring(2, str.length());
						}
					}
			
					if(decimal){
						try {
							int number = Integer.parseInt(str);  
							if(checkRow(str, 10)){
								 
								System.out.print("16-� ������������� ����� ["+str+"] " + out10(number, 16)); 
							}   						
						} catch	(NumberFormatException e ){ 
							System.out.println( "������ �����  " + e.toString());
						}
					} else if(!subString.equals(null) && checkRow(subString, 16)){						
						System.out.println("10-� ������������� ����� ["+str+"] " + to10(subString, 16));						
					}					
				}
				System.out.println("");
				System.out.print("������� ������������� �����: ");
			}  
		} catch (IOException eX) {}   
		
	}

}
