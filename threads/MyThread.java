package threads;

public class MyThread extends Thread {
	
	MyThread(ThreadGroup  tg, String name){
		super(tg,name);
	}
	
	public void run(){ 
		do{ 
			try {
				System.out.println(getName());
	            		Thread.sleep(1000); // создадим видимость сверх вычислений
	          	} catch (InterruptedException e) { 
	           		return; 
	        	} 
		} while (!getThreadGroup().isDestroyed());  
	}
}
