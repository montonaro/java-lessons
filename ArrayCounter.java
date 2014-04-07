
import java.util.concurrent.atomic.AtomicInteger;

class Container { 
	public AtomicInteger sum = new AtomicInteger(0);
	//public sum = 0;
}

class TestThread  extends Thread {
    private Container c;
    private int[] arr = null;
    
    private int offset 	= 0;
    private int block 	= 1;
    
    public TestThread(Container c, int [] arr, int offset, int block) {
         this.c 	 = c;
         this.arr 	 = arr;
         
         this.offset = offset;
         this.block  = block;       
    }

    public void run() {
        
    	int sum = 0; 
    	for(int i = 0; i < block; i++){  
    		sum = sum+arr[offset+i];
    	}   
    	
    	c.sum.addAndGet(sum);
    	//synchronized (c) {  
         	//c.sum = c.sum+sum; 
        //} 
    }
}


public class ArrayCounter {
	
	static int[] arr = new int[1000000]; 
	
	static {
		for (int i=0;i<arr.length;i++)
            arr[i] = 1;//(int) ( Math.random());
	}

	public static void main(String[] args) {  

		long startTime = System.nanoTime();    

		long sum = 0;
		for(int item : arr){ 
			sum += item;
		} 

		long estimatedTime = System.nanoTime() - startTime;
		System.err.println(estimatedTime);
		System.out.println(sum);
		System.out.println("\\----------------------------------------------------"); 

		startTime = System.nanoTime();    
		Container c = new Container();
		ThreadGroup group = new ThreadGroup("group");
		int blocks 	= 2;
		int block  	= (int) Math.ceil(arr.length/blocks); 
		int offset 	= 0; 

	    for (int i = 0; i < blocks; i++) {

	    	offset = block*i;	    	
	    	if(i+1 == blocks){	    		
	    		block = arr.length-(block*i);	    		
			}
	        new Thread(group, new TestThread(c, arr, offset, block)).start();
	    }

	    while(group.activeCount() > 0) { } 
		estimatedTime = System.nanoTime() - startTime;
		System.err.println(estimatedTime);
	        System.out.println(c.sum.get()); 
	    }

} 
