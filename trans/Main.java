package translater;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {		
		
		Dictionary obj = new Dictionary();	 
		
		//obj.show(); // показать полностью что внутри
		//obj.getNewWords();	
		System.out.println(" --------------------- ");  
		//obj.show(); // показать полностью что внутри
		
		
		// для перевода
		Scanner s 			= new Scanner(System.in);
		String line 		= "";	   
		
		while(line == ""){
			System.out.println("Введите строку для перевода.");  
	    	line = s.nextLine().trim(); 
	    	
	    	if(line.length() > 0){    
	    		 
	    		String out = obj.toTranslate(line);	
	    		System.out.println("Обработка завершена: " + line+" "+out);
	    		
	    	} else {
	    		System.err.println("Ваша строка пуста! Попробуйте ввести еще раз."); 
	    		line = "";
	    	} 
		}
		 	 
		if (s != null) {
             s.close();
        }  
		
		
	}

}
