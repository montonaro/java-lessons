package Monitor2;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

class MyFileFilter  implements FilenameFilter {
    private String ext = "";  
    
    public void setExtension(String ext) {
        this.ext = "\\"+ext;
    }
    
    public void setExtension(String [] ext) {

    	if(ext.length > 0){
    		for(int i = 0; i < ext.length; i++){
    			this.ext += "\\"+ext[i];
    			
    			if(i+1 != ext.length){
    				this.ext += "|";
    			}
    		}
    	} 
    }
    
    @Override
    public boolean accept(File path, String name) {
    	
    	boolean status = true;  
    	
    	File f = new File(path, name);
    	if(f.isFile()){ 

    		if(ext != null){
    			String patern = "|.+("+ext+")$|i"; 

    			status = Pattern.matches(patern, name);  
    			
    			if(System.currentTimeMillis() - f.lastModified() > 5000){  
    				status = false;
    			}
    		} 
    	} 
		
		return status;
    }
}
