package ÑopyFile;

import java.io.*;
 

public class ÑopyFile  extends MyFiles { 
	
	public void copyFile(String src, String dest) {
		  
		try{
			checkFile(src); 	
			in = new BufferedInputStream(new FileInputStream(src));	
			checkDest(dest);  
			out = new BufferedOutputStream(new FileOutputStream(dest));
			
			copy();
		} catch (Exception e){
   	       System.out.println(e.getMessage()); 
   	    }
	 
	}
	 
}
