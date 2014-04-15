package translater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	 
	Map<String, String> db 						= null;  	 
	public final static String TMP_FILE_PATH 	= "c:\\tmp\\tmp.java.ser";	 
		
	Dictionary(){ 		
		load(); 				
	}
	 
	private boolean insert(String key, String value){  
		
		String result = db.put(key, value);
		
		if(result != null){
			return true;
		}
		return false; 
	}

	
	void getNewWords(){		 
			
		Scanner s 			= new Scanner(System.in);
		String line 		= "";	
		String [] items 	= null;

		while(line == ""){
			System.out.println("Введите новые слова {ключ=значение}. ЧЕРЕЗ ПРОБЕЛ!");  
        	line = s.nextLine().trim(); 
        	
        	if(line.length() > 0){    
        		items = line.split(" ");	        		
        		if(items.length > 0){	        			
        			String[] str; 
        			
        			
        			for(String item : items){
        				str = item.split("=");	        				
        				if(str.length != 2){
        					System.err.println("Ошибка ввода. Попробуйте ввести еще раз {ключ=значения}: {"+item+"}");
        					line = ""; // если есть хоть одна ошибка то будет доступен повторный ввод.
        				} else {
        					insert(str[0], str[1]);
        				}  
        			}
        			
        			
        		}   
        	} else {
        		System.err.println("Ваша строка пуста! Попробуйте ввести еще раз.");
        		line = "";
        	}  
		} 
		
		if (s != null) {
             s.close();
        } 
		save();
	}
	
	
	void show(){
		System.out.println("Вывод из файла:"); 
		Iterator<Map.Entry<String, String>> itr = db.entrySet().iterator(); 
    	while (itr.hasNext()){
    	    System.out.println(itr.next().toString());
    	} 
	}
	
	
	String toTranslate(String in){
		
		if(in == null){
			return null;
		}
		
		String[] str = in.split(" ");	 
		if(str.length == 0){
			return null;
		} 
		
		StringBuilder strB 	= new StringBuilder();
		String transWord 	= null;
		for(String word : str){
			 
			if(!db.containsKey(word)){
				try {
					String json  = URLReader.getJson(word);	 
					transWord 	 = ParseJson.parse(json);
					if(transWord != null){
						strB.append(transWord+" ");
						insert(word, transWord);
					} 
				} catch (Exception e) {
					 System.err.println(e);
				}				
			} else {  
				strB.append(db.get(word)+" ");
			} 
		} 
		
		save(); 
		return strB.toString();
	}
	
	private void save(){
		
		FileOutputStream fos   = null;
		ObjectOutputStream oos = null;	 

		try {
			fos = new FileOutputStream(TMP_FILE_PATH);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(db); 
			System.out.println("Запись в файл произведена!");

		} catch (FileNotFoundException e) { 
			System.err.println(e.getMessage()); 
		} catch (IOException e) {
			System.err.println(e.getMessage()); 
		} finally {  
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {}
			}
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {}
			}
		}  
	}
	
	private void load(){
		
		db = new HashMap<String, String>();		

		if(new File(TMP_FILE_PATH).exists()){
			FileInputStream fis 	= null;
			ObjectInputStream ois 	= null;
			try {
				fis = new FileInputStream(TMP_FILE_PATH);
			    ois = new ObjectInputStream(fis);

			    db = (Map<String, String>) ois.readObject();  
			    
			    /*
			    if(db.size() > 0){  
			    	Iterator<Map.Entry<String, String>> itr = db.entrySet().iterator(); 
			    	while (itr.hasNext()){
			    	    System.out.println(itr.next().toString());
			    	} 
			    }*/

			} catch (FileNotFoundException e) { 
				System.err.println(e.getMessage()); 
			} catch (IOException e) { 
				System.err.println(e.getMessage()); 
			} catch (ClassNotFoundException e) { 
				System.err.println("Не удалось произвести чтение из файла. Файл не найден."); 
				//System.err.println(e.getMessage()); 
			} finally {  
				if(ois != null){
					try {
						ois.close();
					} catch (IOException e) {}
				}
				if(fis != null){
					try {
						fis.close();
					} catch (IOException e) {}
				}
			}
		} 
		
	}
}
