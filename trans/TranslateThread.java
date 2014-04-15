package translater;

public class TranslateThread extends Thread {
      
    private int timeout;  
    //private IFileEvents events;
    
    public TranslateThread(int key, String word) {
    	
    }
    
    public void run() {
        while ( ! isInterrupted()) {


        	
        	
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
    
    public int getTimeout() {
        return timeout;
    }
    
    public void setTimeout(int value) {
        timeout = value;
    }      
}