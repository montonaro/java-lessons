package �opyFile;

import java.io.*;

public class MyFiles {
	
	InputStream in;
	OutputStream out; 
 
	
	protected static void checkFile(String fileName) throws FileNotFoundException{
		
		File f = new File(fileName);
		if(!f.exists() || !f.isFile()){ 	
			throw new FileNotFoundException("�������� ���� �� ������");
		}
	} 

	protected static void checkDest(String fileName) throws FileNotFoundException{
		
		File f = new File(fileName);
		if(f.isDirectory()){ 	
			throw new FileNotFoundException("�� �� ������� ��� ��������� �����");
		} 
		
		String [] dirs = fileName.split("\\\\");
		if(dirs.length > 0){
			String path = "";
			for(int i = 0; i < dirs.length; i++){
				
				if(i+1 < dirs.length){
					path += dirs[i]+"\\";
					
					f = new File(path);
					if(!f.isDirectory()){
						f.mkdir();
						//throw new Exception("����:("+path+"). �� ������.");
					} 
				}  
			}
		} 
	}  
	 
	
	protected void copy() throws Exception {  
	    try {   
	    	int key = 0;
	    	while(true){ 
			   key = in.read();
			   if(key > 0){
				   out.write(key);
			   } else {
				   System.out.println("�������� ���������."); 
				   break;
			   }			   
	    	 } 
    	}catch (IOException e){
		     ;	 
	    } finally {
	    	in.close();
	    	out.close();
	    }
	}
	
}
 
