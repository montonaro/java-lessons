package task4;

import java.util.Scanner;
public class noughtsAndCrosses {
	public static void main (String[] args){
		System.out.println(" 1 | 2 | 3 ");
		System.out.println("--- --- ---");
		System.out.println(" 4 | 5 | 6 ");
		System.out.println("--- --- ---");
		System.out.println(" 7 | 8 | 9 ");
		Scanner s = new Scanner (System.in);
		//Масив з вмістом комірок {x,x,0,0,x....}
		char [] arr = new char [9];
		//Цикл введення з консолі де j = кількость вводу ходів;
		steps: for (int j = 0; j < 10; j++){
			//Умова, який гравець грає;
			if (j%2 == 0) System.out.println("Хід 1 гравця:");
				else 	System.out.println("Хід 2 гравця:");
			//Перевірка введення числа чи букви;
			while (!s.hasNextInt()){
				System.out.println("Неправильно введений номер комірки");
				s.next();
			}
			int i = s.nextInt() - 1;
			//Перевірка введеного числа від 1 до 9;
			if (i < -1 | i > 10){
				System.out.println("Неправильно введений номер комірки, введіть від 1 до 9");
				--j;
				continue steps;
			}
			//Перевірка чи вільна комірка;
			for (int t = 0; t < arr.length - 1; t++ ){
				if (arr[i] != 0){
				System.out.println("Номер комірки зайнятий");
				--j;
				continue steps;
				}
			}
			// Присвоєння гравцю і комірці Х або О;
			if (j%2 == 0)arr [i] ='x';	
				else arr [i] = 'o';
			//Виведення ходу гравця;
			System.out.println(" "+arr[0]+" | "+arr[1]+" | "+arr[2]+"  ");
			System.out.println("--- --- ---");
			System.out.println(" "+arr[3]+" | "+arr[4]+" | "+arr[5]+"  ");
			System.out.println("--- --- ---");
			System.out.println(" "+arr[6]+" | "+arr[7]+" | "+arr[8]+"  ");
			//Умови перемоги;
			for ( int n = 0; n < arr.length - 3; n = n + 3){
				if (arr[n] == arr[n+1] & arr[n] == arr[n+2] & arr[n] != 0){
					System.out.println("Переміг гравець " +(j%2+1)); 
					break steps;
					}
				}
			for ( int n = 0; n < 3; n++){
				if (arr[n] == arr[n+3] & arr[n] == arr[n+6] & arr[n] != 0){
					System.out.println("Переміг гравець " +(j%2+1));
					break steps;
				}
			}
			int n = 0;
			if (arr[n] == arr[n+4] & arr[n] == arr[n+8] & arr[n] != 0){
				System.out.println("Переміг гравець " +(j%2+1));
				break steps;
			}
			if (arr[n+2] == arr[n+4] & arr[n+2] == arr[n+6] & arr[n+2] != 0){
				System.out.println("Переміг гравець " +(j%2+1));
				break steps;
			} 
			//Умова нічиї;
			if ( j == 8){ 
				System.out.println("Нічия");
				break steps;
			}
		}	
	}
}