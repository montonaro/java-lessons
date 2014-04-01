package counter;

import java.util.Random;

public class Counter extends Thread {
    
	int start	= 0;
	int stop 	= 0;
	
	Counter(){
		start = 0;
		stop  = 1000;
	}
	
	Counter(int start, int stop){
		this.start = start;
		this.stop  = stop;
	}
	
	public void run() {
        int x = 0;
        Random rand = new Random(); 
        int randomNum = 0;
        while (x++ < 100){ 
    	    randomNum = rand.nextInt((stop - start) + 1) + start;  
            System.out.println(getId() + ": " + randomNum);

        }
     }
}