package human; 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {			
		
		

		Scanner s	= new Scanner(System.in);
		int choice 	= 0;
		String line = null;
		
		ManagingHumans obj = new ManagingHumans();
		
		while(true){
			System.out.print("Введите [1 - добавить.]: ");  	
			line = s.nextLine();
			try{
				choice = Integer.parseInt(line); 
			   	switch(choice){
			   		case 1:
			   			obj.add();
			   			break;
			   	}
			}
			catch(NumberFormatException ex){
			    System.out.println("Its not a valid Integer");
			} catch(Exception ex){
			    System.out.println("Exception");
			} 
		}  
	}

}
