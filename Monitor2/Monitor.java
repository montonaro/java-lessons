package Monitor2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Monitor {
	
	String file;
	String dir;

	IFileEvent event; 
	static MyFileFilter filter;
	
	public Monitor(String dir, IFileEvent event, String[] extStr) {
		 
		File f = new File(dir); 
		if(f.isDirectory()) {
			this.dir = dir;  
		}   
		filter = new MyFileFilter(); 	
		filter.setExtension(extStr);	 
		this.event = event;
	} 
	
	private static void listAll(String path, ArrayList<File> res) 
		    throws IOException 
	{
	    File f = new File(path);
	    String[] list = f.list(filter);

	    if (list == null) return;		 

	    for (String str : list) {
	    	
	    	f = new File(path+"\\"+str); 
    	
	        if (f.isFile()) {
	             res.add(f);	   
	        } else if(f.isDirectory()) {

	             listAll(f.getCanonicalPath(), res);
	        }
	    }
	}

	
	public void search() throws IOException {
		
		ArrayList<File> list = null;
		while (true) { 
			
			if(dir != null) {  
				
				list = new ArrayList<File>(); 
				try {
					listAll(dir, list);
					
					if(list != null && event != null){
						 
						for(File f : list){
							event.onFileAdded(f.getCanonicalPath(), f.lastModified() ); 
						} 
					}
				} catch (IOException e) { 
					;
				} 
			} else {
				break;
			}  
			
			System.out.println("Waiting...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {} 
			
		}
	}


	
}
