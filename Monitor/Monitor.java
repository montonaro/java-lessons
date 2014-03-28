package Monitor;

import java.io.File;
import java.util.Arrays;

public class Monitor {
	String file;
	String dir;
	boolean scanAllList = false;
	String [] files = new String[0];
	IFileEvent event; 
	
	public Monitor(String file, IFileEvent event) {
		 
		File f = new File(file); 
		if(f.isDirectory()) {
			this.dir = file;  
		}  else {
			this.file = file;
		} 
		
		this.event = event;
	}
	
	public Monitor(String [] file, IFileEvent event) { 
		
		this.files = file;
		this.event = event;
	}
	
	public Monitor(String [] file, IFileEvent event, boolean marker) { 
		
		scanAllList = marker;
		this.files 	= file;
		this.event 	= event;
	}
	
	public void start() {
		while (true) {
			 
			File f = null;
			if(file != null){ 
				
				f = new File(file); 				
				if (f.exists() || f.isFile() ) {    
					if (event != null){
						event.onFileAdded(file, f.lastModified() ); 
					} 
					break;
				}
				 
			} else if(files.length > 0){
				
				if(!checkFiles()){ 
					break;
				}  
			} 
			
			
			else if(dir != null) {
				File file2 = new File(dir);
				
				MyFileFilter filter = new MyFileFilter();
				filter.setExtension(".txt");				
				//filter.setExtension(new String[]{".doc", ".xls"});
				
				String[] directories = file2.list(filter); 
				
				//другой способ не нашел узнать новый ли это файл.
				if(directories.length > 0){
					for(String item : directories){
						f = new File(dir, item); 	
						if(System.currentTimeMillis() - f.lastModified() < 1000){					
							if (event != null){
								event.onFileAdded(item, f.lastModified() ); 
							} 
							break;
						}   
					}
				}
			} else {
				break;
			}  
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			System.out.println("Waiting...");
		}
	}
	
	private boolean checkFiles(){
		File f = null; 
		int count = (scanAllList ?  files.length : 1 );
		 
		for(String item : files){
			f = new File(item);
			if (!f.exists() && !f.isFile() ) { 
				f = null;  
			} else {
				
				if (event != null){
					event.onFileAdded(item, f.lastModified() ); 
				} 
				
				if(--count == 0){
					return false;
				}
			}   				
		}// end for 
		return true;
	}
	
}
