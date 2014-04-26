package serverSearch;
 
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	static void getServersList() throws FileNotFoundException{
		
		String src = "c:\\tmp\\servers.txt";
		File f = new File(src);
		if(!f.exists() || !f.isFile()){ 	
			throw new FileNotFoundException("Файл не найден");
		}
		
		try {

	        BufferedReader in = new BufferedReader(new FileReader(src));
	        try {

	            String s;
	            String [] items;
	            int port;
	            while ((s = in.readLine()) != null) {
            		
	            	items = s.split(":");
	            	if(items.length == 2){
	            		try {
	            			port = Integer.parseInt(items[1]);  
	            	        new Socket(items[0], port);	            	        
	            	    } catch (ConnectException e) { 
	            	        System.out.println(s+"=Offline");
	            	        continue;
	            	    }   
	            	}
	            	
	            	System.out.println(s+"=Online");
	            }
	        } finally { 
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		
		
	}
	
	
	public static void main(String[] args) {

		try {
			getServersList();
		} catch (FileNotFoundException e) {

			System.err.println(e.getMessage());
		}
		
	}

}
