package counter;

import java.util.Scanner;
/*
 * �������������� ����� Counter ���, ����� �� ���������� ������� ����� �� ������������� ���������.
 * ������� �����, ������� ����� ������ 10 ������ �������� ������� ����� �� �����. ������� ����������� ���������� ������ � ������� ������� � �������.
 * ������� 100 �������, ������ �� ������� ������� �� ����� ���� ����� � ��������, ���� ��� �������.
 */


public class Main { 

    public static void main(String[] args) {
        try {
            Counter c = new Counter(0, 4);
            //c.start(); // ��������� �����  
            
            //---------------------------------------------------------
            
            System.out.println("Timer start, click 'Enter' - to stop!");
            Timer t = new Timer();
            t.start();
            
            Scanner sc = null;
            try{
            	sc = new Scanner(System.in); 
            	if(sc.hasNextLine()){
                	t.interrupt(); 
                }
            } finally{
            	sc.close();
            }
               
            
        } catch (Exception e) {
            ;
        }
    }
}