package copyFile2;

import java.io.*;

public class MyThread extends Thread {
	
	protected String name = null;
	protected int off;
	protected int len;
	
	protected String src = null;
	protected String dest = null;
	
	MyThread(String name, String src, String dest, int off, int len ){
		this.name = name;
		this.off = off;
		this.len = len;
		
		this.src = src;
		this.dest = dest;
	}
	 
	/*
	 * (offset < 0)
	 * (offset > data.length) S
	 * (length < 0)
	 * (offset + length) > data.length) 
	 * (offset + length) < 0
	 */
	
	public void run(){ 
		
		
		System.out.println(name+", "+len+ " " + off + "|" + len/10);
		
		//while (!isInterrupted()) {
			BufferedInputStream in   = null;
			BufferedOutputStream out = null;
			try{  
				in = new BufferedInputStream(new FileInputStream(src), len/10);	 
				out = new BufferedOutputStream(new FileOutputStream(dest), len/10);
				
				in.skip(off);  
				
				byte[] buf = new byte[len/10]; 
				
				int counter = 0;
				int length  = buf.length;
				int r = 0; 
                do {                   	
                	
                	if(counter+length > len){   
                		length = (counter+length)-len;
                	}                	
                	               	
                    r = in.read(buf, 0, length);   
                    counter += r;                     
                    
                    if (r > 0){  
                    	out.write(buf, 0, r);
                    }   
                    
                } while (r > 0 && len >= counter);  

                
                
			} catch (Exception e){
			       System.out.println("Exception " + e.toString()); 
		    }finally { 
		    	if(in != null){ 
			   	  	try {
						in.close();
					} catch (IOException e) {
						;
					}
		    	}
		   	  	if(out != null){
			   	  	try {
						out.close();
					} catch (IOException e) {
						;
					} 
		   	  	} 
		    }
		 
			//System.out.println(name+", "+off+", " +len); 
		//}
	}
}
