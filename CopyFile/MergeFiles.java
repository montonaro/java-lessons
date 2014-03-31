package copyFile;

import java.io.*;

public class MergeFiles extends MyFiles { 
	
	public void merge(String src1, String src2, String dest) throws IOException {
		
		SequenceInputStream  in   	= null;
		BufferedOutputStream out  	= null;
		FileInputStream  f1   		= null;
		FileInputStream f2  		= null;
		
		try{
			checkFile(src1); 
			checkFile(src2);  
			checkDest(dest); 
			
			f1 = new FileInputStream(src1);
			f2 = new FileInputStream(src2);
			
			in = new SequenceInputStream(f1, f2);		
			out = new BufferedOutputStream(new FileOutputStream(dest));
			
			int marker = 0;
			while( (marker = in.read()) != -1){  
	            out.write(marker);  
	        } 
			
		} catch (Exception e){
   	       System.out.println(e.getMessage()); 
		}finally { 
		 
			f1.close(); 
			f2.close(); 
			in.close();	 
			out.close();			 
	    } 
	} 
}
