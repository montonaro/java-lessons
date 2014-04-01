package counter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Thread{

	public void run() {
		  
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy H:m:s");
		Date d  	= null;
		String date = null;
        while ( ! isInterrupted()) {
        	
        	d = new Date(); 
            date = DATE_FORMAT.format(d);
            System.out.println("Date: "+ date );
            
            try {
                Thread.sleep(10000);  
            } catch (InterruptedException e) { 
               return; 
           }
        }
	}

}
