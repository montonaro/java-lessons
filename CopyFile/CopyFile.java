package copyFile;

import java.io.*;
 

public class CopyFile extends MyFiles { 
	
	public void copyFile(String src, String dest)  throws IOException {
		
		BufferedInputStream in   = null;
		BufferedOutputStream out = null;
		try{
			checkFile(src); 	
			in = new BufferedInputStream(new FileInputStream(src));	
			checkDest(dest);  
			out = new BufferedOutputStream(new FileOutputStream(dest));
			
			while(in.available() != 0){  
	            out.write(in.read());  
	        } 
			
		} catch (Exception e){
   	       System.out.println(e.getMessage()); 
   	    }finally {
   	    	
   	  	in.close();
		out.close();
			
	    }
	 
	}
	 
}
