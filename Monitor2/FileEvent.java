package Monitor2;
 

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class FileEvent implements IFileEvent {
	@Override
	public void onFileAdded(String s, long time) {	
		
		Date lastModified = new Date(time);	 
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy H:m:s");
        String date = DATE_FORMAT.format(lastModified);
        System.out.println("File added: " + s + ". Date: "+ date );
	}
}
