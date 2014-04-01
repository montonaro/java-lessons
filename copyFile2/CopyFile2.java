package copyFile2;

import java.io.*;  

public class CopyFile2 extends AFile{ 
	
	public void copyFile(String src, String dest)  throws IOException, InterruptedException { 
		
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
			
			System.out.println(len);			
			if(len > 0){
				
				int block = (int) Math.ceil(len/10);
				
				System.out.println(block);	
				int off = 0;  
				for(int i = 0; i < 10; i++){
					
					if(i+1 == 10){
						System.out.println(len + " " + off + " " + block);	
						block = (int) len-off;
					}  
					
					//System.out.println(off+" "+ block );   
					MyThread c = new MyThread("my thread #"+i, src, dest, off, block); 
					c.start();
					c.join();
			        
			        off +=block; 
				}				
			} 
	 
	} 
	 
}
