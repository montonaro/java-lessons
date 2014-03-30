package ÑopyFile; 
 

public class Main {
	public static void main(String[] args) {
		
		ÑopyFile c = new ÑopyFile(); 
		c.copyFile("c:\\tmp\\1.txt", "c:\\tmp\\dir\\1.txt");

		MergeFiles m = new MergeFiles(); 
		m.merge("c:\\tmp\\1.txt", "c:\\tmp\\2.txt", "c:\\tmp\\dir\\2.txt"); 
	}
}