package translater;
 

public class Main {
	
	
	public static void main(String[] args) {		
		
		Dictionary obj = new Dictionary();	 
		
		//obj.show(); // показать полностью что внутри
		obj.getNewWords();	
		System.out.println(" --------------------- ");  
		//obj.show(); // показать полностью что внутри		
		
		// для перевода 
		obj.translate();  	
		
	}

}
