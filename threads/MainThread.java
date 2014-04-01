package threads;

import java.util.ArrayList;

public class MainThread extends Thread {
	
	public void run(){ 
		
		ArrayList<MyThread> threads = new ArrayList<MyThread>(); 
		ThreadGroup tg = new ThreadGroup("#777");
		
		for(int i = 0; i < 50; i++){
			MyThread c = new MyThread(tg, "my thread #"+i );
	        c.start();
	        threads.add(c);
		}
		
		
		
		while(!isInterrupted()){
			try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) { 
	        	tg.interrupt();
	            return; 
	        }
		} 
		tg.interrupt();
	}
}
