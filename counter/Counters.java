package counter;

import java.util.ArrayList;

public class Counters {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Counter> threads = new ArrayList<Counter>();
        
		for (int i = 0; i < 100; i++) {
		        Counter c = new Counter(0,1);
		        c.start();
		        threads.add(c);
		}
		        
		Thread.sleep(500);
		        
		for (Counter c : threads)
		        c.interrupt();

	}

}
