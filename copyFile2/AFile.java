package copyFile2;

import java.io.File;
import java.io.FileNotFoundException;

abstract class AFile {
	protected static void checkFile(String fileName) throws FileNotFoundException{
			
		File f = new File(fileName);
		if(!f.exists() || !f.isFile()){ 	
			throw new FileNotFoundException("Исходный файл не найден");
		}
	} 

	protected static void checkDest(String fileName) throws FileNotFoundException{
		
		File f = new File(fileName);
		if(f.isDirectory()){ 	
			throw new FileNotFoundException("Вы не указали имя конечного файла");
		} 
		
		String [] dirs = fileName.split("\\\\");
		if(dirs.length > 0){
			String path = "";
			for(int i = 0; i < dirs.length; i++){
				
				if(i+1 < dirs.length){
					path += dirs[i]+"\\";
					
					f = new File(path);
					if(!f.isDirectory()){
						f.mkdir(); 
					} 
				}  
			}
		} 
	}
}
