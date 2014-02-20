package task4;
 
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	
	private final int longStep = 3; // длина хода
	private int x = 3; //размер поля x
	private int y = 3; //размер поля y	
	
	private int userX = 0;  // ход пользователя x
	private int userY = 0;  // ход пользователя y
	
	private char[][] field;
	
	private int activeUser = 0; // активный пользователь

	public TicTacToe(int x, int y){ 
		
		if(x > 3){
			this.x = x;
		}		
		if(y > 3){
			this.y = y;
		} 
		
		field 		= new char[this.y][this.x];		
		activeUser 	= 1;
	}
	
	public void setUserCoors(int x, int y){
		userX = x;
		userY = y;
	}
	
	public void show(){
		System.out.print("  ");
		for(int i=0; i<field[0].length; i++){
			System.out.print(""+i);
		}
		System.out.println("");
		//-------------------------------
		for(int i=0; i<field.length; i++){
			System.out.print(i+"|"); 
			
			for(int j=0; j<field[i].length; j++){		 
				
				if(field[i][j] != 0){
					System.out.print(""+field[i][j]);
				} else {
					System.out.print("_");
				} 
				
			}	
			System.out.println("");
		}
	}
	
	/**
	 * @return символ активного пользователя
	 */
	private char getUserSymbol(){
		if(activeUser == 1){
			return '0'; 
		} else if(activeUser == 2){			
			return 'X'; 
		}
		
		return ' ';
	}
	
	/*	
	 * Проверка рекурсией
	 */
	private boolean countSteps(int x, int y, String way, int count){ 
		//System.out.println(field[y-1][x] + " "+ getUserSymbol()+ " x-"+x + " Y-"+(y-1));
		
		switch(way){
			case "up": 
				if(checkEmpty(x,y-1) >= 0){  
					//если следующий такой же символ
					if(field[y-1][x] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x, y-1, way, count+1);
						} 
					}
				}   
				break;
			case "up-left": 
				if(checkEmpty(x-1,y-1) >= 0){  
					//если следующий такой же символ
					if(field[y-1][x-1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x-1, y-1, way, count+1);
						} 
					}
				}   
				break;
			
			case "up-right": 
				if(checkEmpty(x+1,y-1) >= 0){  
					//если следующий такой же символ
					if(field[y-1][x+1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x+1, y-1, way, count+1);
						} 
					}
				}   
				break;
				
			case "down": 
				if(checkEmpty(x,y+1) >= 0){  
					//если следующий такой же символ
					if(field[y+1][x] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x, y+1, way, count+1);
						} 
					}
				}   
				break;
				
			case "down-left":   
				if(checkEmpty(x-1,y+1) >= 0){  
					//если следующий такой же символ
					if(field[y+1][x-1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x-1, y+1, way, count+1);
						} 
					}
				}   
				break;
				 
			case "down-right":  
				if(checkEmpty(x+1,y+1) >= 0){  
					//если следующий такой же символ
					if(field[y+1][x+1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x+1, y+1, way, count+1);
						} 
					}
				}   
				break;
				
			case "left": 
				if(checkEmpty(x-1,y) >= 0){  
					//если следующий такой же символ
					if(field[y][x-1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x-1, y, way, count+1);
						} 
					}
				}   
				break;
				
			case "right": 
				if(checkEmpty(x+1,y) >= 0){  
					//если следующий такой же символ
					if(field[y][x+1] == getUserSymbol()){  						
						if(count+1 == longStep-1){ //достигнуто максимальное количество
							return true;
						} else {
							return countSteps(x+1, y, way, count+1);
						} 
					}
				}   
				break;
		}
		return false;
	}
	
	
	/** 
	 *  Проверка на конец игры
	 *  ранее проверено что ячейка пуста и не выходит за предел поля
	 */
	private boolean checkStop(){
		
		String [] arr = new String[]{"up", "down", "left", "right", "up-left", "up-right", "down-left", "down-right"};
		
		for(int i = 0; i < arr.length; i++){
			if(countSteps(userX, userY, arr[i], 0)){
				return true;
			}
		} 
		
		return false;
	}
	
	/**	 
	 * @return int 0 - занято, -1 - выход за диапазон, 1 - пусто 
	 */
	public int checkEmpty(int x, int y){
		
		int status = 0;  
		
		if((x >= 0 && y >= 0) && (x < this.x && y < this.y)){
			
			if(field[y][x] == 0){
				status = 1;
			} 
			
		} else {	 
			status = -1; // выход за диапазон
		}
		
		return status;
	}
	
	/**
	 * Делаем ход. 
	 */
	private void setStep(){ 
	
		if(activeUser == 1){
			field[userY][userX] = getUserSymbol();
			activeUser = 2;
		} else if(activeUser == 2){			
			field[userY][userX] = getUserSymbol();
			activeUser = 1;
		}
	}
	
	/**
	 * Вывод сообщения чей сейчас ход
	 */
	public void getUserMessage(){
		System.out.println("");
		System.out.print("Игрок №"+activeUser+" - введите координаты хода, пример (1x0): ");
	}
	
	@SuppressWarnings("resource")
	public static void main(String [] args){
		
		Scanner sc = null; 
		
		int x = 0;
		int y = 0;
		TicTacToe obj = null;
		boolean init = false; 
		
		
		while(true){ 
			
			if(!init){
				
				try{	
					
					sc = new Scanner(System.in);
					
					if(x == 0){
						System.out.print("Введите количество клеток (целое число) по X (минимальный размер 3): ");
						x = sc.nextInt();
					}
					
					if(y == 0){
						System.out.print("Введите количество клеток (целое число) по Y (минимальный размер 3): ");
						y = sc.nextInt();
					}
					
					obj = new TicTacToe(x,y); 
					obj.show(); 
					init = true;
					//obj.getUserMessage(); 
				} catch(InputMismatchException e){
					System.out.println("Введены не верные символы. Повторите попытку."); 
				}   
			} else {
				String str = sc.nextLine(); 
				if(!str.equals("")){				
					String [] coors  = str.split("x");
					
					if(coors.length == 2){
						
						try	{
							int userX = Integer.parseInt(coors[0]);
							int userY = Integer.parseInt(coors[1]); 
							
							obj.setUserCoors(userX, userY);
							
							int status = obj.checkEmpty(userX, userY);
							
							//switch
							if(status > 0){				
								
								boolean end = obj.checkStop();
								String message = "Кoнец. Победа игрока №"+obj.activeUser;
								
								
								obj.setStep();  
								obj.show();
								
								
								if(end){  
									System.out.println(message); 
									break;
								} 
								
							} else if(status == -1){
								System.out.println("Выход за диапазон"); 
							} else {
								System.out.println("Желаемое вами поле - занято"); 
							}		 
							
						} catch(NumberFormatException e){
							System.out.println("Координаты: должны быть целые числа!"); 
						} 
					} else {
						System.out.println("Координаты должны быть вида (1x0)!"); 
					}
				}   
				obj.getUserMessage(); 
			} 
			
			
			
		} // end while  
		 
	}
}
