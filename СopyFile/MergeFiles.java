package ÑopyFile;

import java.io.*;

public class MergeFiles extends MyFiles { 
	
	public void merge(String src1, String src2, String dest) {
		  
		try{
			checkFile(src1); 
			checkFile(src2);  
			in = new SequenceInputStream(new FileInputStream(src1), new FileInputStream(src2));
			
			checkDest(dest);  
			out = new BufferedOutputStream(new FileOutputStream(dest));
			
			copy();
		} catch (Exception e){
   	       System.out.println(e.getMessage()); 
   	    } 
	} 
}
