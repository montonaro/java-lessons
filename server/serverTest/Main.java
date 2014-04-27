package serverTest;

import java.io.*;
import java.net.*;
 

public class Main {
	
	static class MyThread extends Thread{
		String sourse = null;
		MyThread(String http){
			sourse = http;
		}
		@Override
		public void run() { 
			
           while ( ! isInterrupted()) {  
             	try {
             		 
        			URL s = new URL(sourse);
        	        URLConnection yc = s.openConnection();
        	        BufferedReader in = new BufferedReader(
        	                                new InputStreamReader(
        	                                yc.getInputStream()));
        	        String inputLine; 
        	        while ((inputLine = in.readLine()) != null); 
        	            //System.out.println(inputLine); 
        	        
        	        
        	        in.close();
            		 
          		} catch (Exception e) { 
          			System.err.println(e.getMessage());
          			interrupt();
          		}
           }   
       }
	} 
	
	static void start(String http){
		
		 
	    for(int i = 0; i < 200; i++){
	    	MyThread thread = null; 
       		thread = new MyThread(http);  
	        thread.start(); 
	    }
	} 
	
	public static void main(String[] args) throws IOException{		 
		
		start("http://kivra.kpi.ua");  
	}  
}
