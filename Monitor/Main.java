package Monitor;

public class Main {
	public static void main(String[] args) {
		
		String[] ways = {
						 "c:\\tmp\\1.txt",
						 "c:\\tmp\\2.txt",
						 "c:\\tmp\\3.txt",
						 "c:\\tmp\\4.txt"
						 };
		
		Monitor m;		
		//1.1
		//m = new Monitor("c:\\tmp\\1.txt", new FileEvent()); 
		//2.1
		//m = new Monitor(ways, new FileEvent());
		//2.2
		//m = new Monitor(ways, new FileEvent(), true);
		//3.1
		m = new Monitor("C:\\tmp\\", new FileEvent());
		m.start();
	}
}