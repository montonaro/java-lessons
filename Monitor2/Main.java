package Monitor2;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {		
			
		Monitor m;		
		m = new Monitor("C:\\tmp", new FileEvent(), new String[] {".txt", ".doc"});
		try {
			m.search();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}