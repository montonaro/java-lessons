package trash;

import java.util.HashSet;
import java.util.Iterator; 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		final Object DUMMY = new Object();

		HashSet<Integer> hs = new HashSet<Integer>(); 
		
		
		Scanner s 			= new Scanner(System.in);
		String line 		= "";	   
		
		while(line == ""){
			System.out.println("¬ведите.");  
	    	line = s.nextLine().trim(); 
	    	
	    	String [] items;
	    	
	    	if(line.length() > 0){    
	    		items = line.split(",");	        		
        		if(items.length > 0){   
        			
        			for(String item : items){ 
        				try	{
            				hs.add(Integer.parseInt(item.trim()));  
        				} catch(NumberFormatException e){
        					System.err.println(e.getMessage()); 
        				}
        			} 
        		}   
	    		
	    	} else {
	    		System.err.println("пусто!"); 
	    		line = "";
	    	} 
		}
		 	 
		if (s != null) {
             s.close();
        }  
		
		
		if(hs != null && hs.size() > 0){ 
						
			Iterator<Integer> itr = hs.iterator(); 
	    	while (itr.hasNext()){
	    	    System.out.print(itr.next().toString()+"|");
	    	} 
		}
	}

}
