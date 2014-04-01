package copyFile2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {


		CopyFile2 c = new CopyFile2();
		
		c.copyFile("c:\\tmp\\1.flv", "c:\\tmp\\dir\\1.flv");
		
	}

}
