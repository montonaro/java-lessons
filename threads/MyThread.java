package threads;

public class MyThread extends Thread {
	
	MyThread(ThreadGroup  tg, String name){
		super(tg,name);
	}
	
	public void run(){ 
		
		while ( ! isInterrupted()) {
			
			try {
				System.out.println(getName());
	            		Thread.sleep(1000); // создадим видимость сверх вычислений
	        	} catch (InterruptedException e) { 
		           return; 
		        } 
		}
	}
}
