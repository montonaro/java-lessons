package task8;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) { 
		
		try{
			Nokia3310 nokia = new Nokia3310("123-45-67"); 
			nokia.call("123-45-68"); 			
			nokia.call("123-45-67"); 
 
		} catch(IOException e){
			System.out.println(e.getMessage());
		} 
		System.out.println("----------------------------------");	  
		
		try{
			IPhone iphone = new IPhone("123-45-63"); 
			iphone.call("123-45-67");
			iphone.call("123-45-17");
			
		} catch(IOException e){
			System.out.println(e.getMessage());
		}  
		System.out.println("----------------------------------");  
		
		try{
			IPhone5 iphone5 = new IPhone5("123-45-67"); 		  
			iphone5.call("123-45-69");  
			 
		} catch(IOException e){
			System.out.println(e.getMessage());
		} 
		System.out.println("----------------------------------");
		
		System.out.println("Общее количество звонков:"+ Phone.getCountAllCall());
	}
}
