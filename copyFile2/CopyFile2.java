package copyFile2;

import java.io.*;  

public class CopyFile2 extends AFile{ 
	
	public void copyFile(String src, String dest)  throws IOException, FileNotFoundException { 
		
		checkFile(src); 
		File f = new File(src);
		long len = f.length(); 
		
		File outFile = new File(dest);
		//outFile.delete();
			
		if (!outFile.exists()) {
	                File parentDir = new File(outFile.getParent());
	                if (!parentDir.exists()) {
	                     parentDir.mkdirs();
	                }
	                outFile.createNewFile();
		}
						
		if(len > 0){
			
			int block = (int) Math.ceil(len/10);
			
			int off = 0;  
			for(int i = 0; i < 10; i++){
				
				if(i+1 == 10){						
					block = (int) len-off;
				}  
				
				MyThread c = new MyThread("my thread #"+i, src, dest, off, block); 
				c.start();				
		        
		        	off +=block; 
			}				
		}   
 
	} 
	 
}
