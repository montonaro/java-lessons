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
		//����� � ������ ������ {x,x,0,0,x....}
		char [] arr = new char [9];
		//���� �������� � ������ �� j = �������� ����� ����;
		steps: for (int j = 0; j < 10; j++){
			//�����, ���� ������� ���;
			if (j%2 == 0) System.out.println("ճ� 1 ������:");
				else 	System.out.println("ճ� 2 ������:");
			//�������� �������� ����� �� �����;
			while (!s.hasNextInt()){
				System.out.println("����������� �������� ����� ������");
				s.next();
			}
			int i = s.nextInt() - 1;
			//�������� ��������� ����� �� 1 �� 9;
			if (i < -1 | i > 10){
				System.out.println("����������� �������� ����� ������, ������ �� 1 �� 9");
				--j;
				continue steps;
			}
			//�������� �� ����� ������;
			for (int t = 0; t < arr.length - 1; t++ ){
				if (arr[i] != 0){
				System.out.println("����� ������ ��������");
				--j;
				continue steps;
				}
			}
			// ��������� ������ � ������ � ��� �;
			if (j%2 == 0)arr [i] ='x';	
				else arr [i] = 'o';
			//��������� ���� ������;
			System.out.println(" "+arr[0]+" | "+arr[1]+" | "+arr[2]+"  ");
			System.out.println("--- --- ---");
			System.out.println(" "+arr[3]+" | "+arr[4]+" | "+arr[5]+"  ");
			System.out.println("--- --- ---");
			System.out.println(" "+arr[6]+" | "+arr[7]+" | "+arr[8]+"  ");
			//����� ��������;
			for ( int n = 0; n < arr.length - 3; n = n + 3){
				if (arr[n] == arr[n+1] & arr[n] == arr[n+2] & arr[n] != 0){
					System.out.println("������ ������� " +(j%2+1)); 
					break steps;
					}
				}
			for ( int n = 0; n < 3; n++){
				if (arr[n] == arr[n+3] & arr[n] == arr[n+6] & arr[n] != 0){
					System.out.println("������ ������� " +(j%2+1));
					break steps;
				}
			}
			int n = 0;
			if (arr[n] == arr[n+4] & arr[n] == arr[n+8] & arr[n] != 0){
				System.out.println("������ ������� " +(j%2+1));
				break steps;
			}
			if (arr[n+2] == arr[n+4] & arr[n+2] == arr[n+6] & arr[n+2] != 0){
				System.out.println("������ ������� " +(j%2+1));
				break steps;
			} 
			//����� ���;
			if ( j == 8){ 
				System.out.println("ͳ���");
				break steps;
			}
		}	
	}
}