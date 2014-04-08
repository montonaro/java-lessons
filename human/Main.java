package human;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public final static String TMP_FILE_PATH = "c:\\tmp\\tmp.java.ser";	
	public final static int COUNT_ITEM 		 = 4;

	public static void main(String[] args) {
		
		Set<Human> people = new HashSet<Human>();		
		
		if(new File(TMP_FILE_PATH).exists()){
			FileInputStream fis 	= null;
			ObjectInputStream ois 	= null;
			try {
				fis = new FileInputStream(TMP_FILE_PATH);
			    ois = new ObjectInputStream(fis);
			    
			    people = (Set) ois.readObject(); 
			    //System.out.println(people);
			    
			    if(people.size() > 0){
			    	System.out.println("Вывод из файла:");
			    	for(Human dude:  people){ 
			    		System.out.println(dude.toString());
			    	}
			    }
				
			} catch (FileNotFoundException e) { 
				System.err.println(e.getMessage()); 
			} catch (IOException e) { 
				System.err.println(e.getMessage()); 
			} catch (ClassNotFoundException e) { 
				System.err.println("Не удалось произвести чтение из файла."); 
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
		
		//------------------------------------------------------------------------------------------------------------
		
		if(people.size() < COUNT_ITEM){
			Human dude 			= null;
			Scanner s 			= new Scanner(System.in);
			String line 		= "";		
			int growth 			= 0;
			int weight 			= 0;		
			String [] items 	= null;
			
			while(people.size() < COUNT_ITEM){
				
				System.out.print("Введите имя, рост и вес. (ЧЕРЕЗ ПРОБЕЛ): ");  
	        	line = s.nextLine();
	        	if(line.length() > 0){        		
	        		
	        		items = line.split(" ");
	        		if(items.length == 3){
	        			
	        			try	{
	        				growth = Integer.parseInt(items[1]);
	        			} catch(NumberFormatException e){
	        				System.err.println("Рост нужно ввести числом!");
	        				continue;
	        			}
	        			
	        			try	{ 
	        				weight = Integer.parseInt(items[2]);
	        			} catch(NumberFormatException e){
	        				System.err.println("Вес нужно ввести числом!");
	        				continue;
	        			}
	        			
	        			dude = new Human(items[0], growth, weight);   
	        			if(!people.equals(dude) && people.add(dude) ){ 
	        				System.out.println("Данный добавлены!");
	        			} else { 
	        				System.err.println("Вы пытаетесь ввести дубликат, попробуйте еще!");
	        			} 
	        			
	        		} else {
	        			System.err.println("Данные введены неверно!");
	        		}  
	        		//System.err.println(people.toString()); 
	        	} 
			}
			if (s != null) {
	             s.close();
	        }
			
			//------------------------------------------------------------------------------------------------------------  
			
			FileOutputStream fos   = null;
			ObjectOutputStream oos = null;	 
			
			try {
				fos = new FileOutputStream(TMP_FILE_PATH);
				oos = new ObjectOutputStream(fos);
				
				oos.writeObject(people); 
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
	}

}
