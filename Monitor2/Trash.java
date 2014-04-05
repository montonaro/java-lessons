package Monitor2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Trash { 
	
	
	private static void listAll(String path, ArrayList<String> res) 
		    throws IOException 
		{
		    File dir 	= new File(path);
		    File[] list = dir.listFiles();

		    if (list == null) return;		

		    for (File f : list) {
		        if (f.isDirectory()) {
		        	listAll(f.getCanonicalPath(), res); 
		        }
		        
		        int letters = f.getName().lastIndexOf(".");
		        if(letters < 0){
		        	letters = f.getName().length();
		        }  

		        
		        if(letters > 5 && f.getName().charAt(1) == 'A'){
		        	res.add(" " + f.getName());
		        }  
		    }
	}


	public static void main(String[] args) throws IOException { 
		ArrayList<String> list = new ArrayList<String>(); 
		listAll("C:\\tmp", list);  
		System.out.println(list.toString());
	}

}
