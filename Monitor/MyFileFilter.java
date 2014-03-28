package Monitor;

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
    	
    	//this.ext = ext;
    }
    
    @Override
    public boolean accept(File dir, String name) {
    	
    	boolean status = true;
    	
		if(ext != null){
			String patern = "|.+("+ext+")$|i"; 
			System.out.println(patern);
			status = Pattern.matches(patern, name); 
		}
		
		if(status){
			status = new File(dir, name).isFile();
		}
		return status;
    }
}
