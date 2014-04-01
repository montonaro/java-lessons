package threads;


public class Main {

	public static void main(String[] args) {
		 
		MainThread main = new MainThread();
		main.start();
		
		try {
            		Thread.sleep(10000); 
            		System.out.println("Конец!");
        		main.interrupt(); 
        	 catch (InterruptedException e) { 
           		return; 
        	 } 
		
		 
	}

}
