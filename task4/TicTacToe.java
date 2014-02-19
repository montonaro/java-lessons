package task4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	
	private int x = 3;
	private int y = 3;	
	
	private char[][] field;
	
	private int activeUser = 0;

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
	
	public boolean checkEmpty(int x, int y){
		
		boolean status = false; 
		
		if(x < (this.x-1) && y < (this.y-1)){
			
			if(field[y][x] == 0){
				status = true;
			}
			
		}	 
		
		return status;
	}
	
	/**
	 * ������ ���.
	 */
	public void setStep(int x, int y){ 
		
		if(activeUser == 1){
			field[y][x] = '0';
			activeUser = 2;
		} else if(activeUser == 2){			
			field[y][x] = 'X';
			activeUser = 1;
		}
	}
	
	/**
	 * ����� ��������� ��� ������ ���
	 */
	public void getUserMessage(){
		System.out.println("");
		System.out.print("����� �"+activeUser+" - ������� ���������� ����, ������ (1x0): ");
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
						System.out.print("������� ���������� ������ (����� �����) �� X (����������� ������ 3): ");
						x = sc.nextInt();
					}
					
					if(y == 0){
						System.out.print("������� ���������� ������ (����� �����) �� Y (����������� ������ 3): ");
						y = sc.nextInt();
					}
					
					obj = new TicTacToe(x,y); 
					obj.show(); 
					init = true;
					//obj.getUserMessage(); 
				} catch(InputMismatchException e){
					System.out.println("������� �� ������ �������. ��������� �������."); 
				}   
			} else {
				String str = sc.nextLine(); 
				if(!str.equals("")){				
					String [] coors  = str.split("x");
					
					if(coors.length == 2){
						
						try	{
							int userX = Integer.parseInt(coors[0]);
							int userY = Integer.parseInt(coors[1]); 
							
							if(obj.checkEmpty(userX, userY)){
								
								obj.setStep(userX, userY);
								obj.show();
								
							} else {
								System.out.println("�������� ���� ���� - ������"); 
							}		 
							
						} catch(NumberFormatException e){
							System.out.println("����������: ������ ���� ����� �����!"); 
						} 
					} else {
						System.out.println("���������� ������ ���� ���� (1x0)!"); 
					}
				}   
				obj.getUserMessage(); 
			} 
			
			
			
		} // end while  
		 
	}
}
