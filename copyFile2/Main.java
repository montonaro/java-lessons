package copyFile2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) { 
		
		CopyFile2 c = new CopyFile2(); 
		try {
			c.copyFile("c:\\tmp\\6279.mp4", "c:\\tmp\\dir\\6279.mp4");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			;
		}
		
	}

}
