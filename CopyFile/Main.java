package copyFile; 

import java.io.IOException;
 

public class Main {
	public static void main(String[] args) throws IOException {
		
		CopyFile c = new CopyFile(); 
		c.copyFile("c:\\tmp\\1.txt", "c:\\tmp\\dir\\1.txt");
		System.out.println("Операция копирования завершена."); 
		
		MergeFiles m = new MergeFiles(); 
		m.merge("c:\\tmp\\1.txt", "c:\\tmp\\2.txt", "c:\\tmp\\dir\\2.txt"); 
		System.out.println("Операция склеивания завершена."); 
	}
}
