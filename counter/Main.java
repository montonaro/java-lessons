package counter;

import java.util.Scanner;
/*
 * ћодифицировать класс Counter так, чтобы он циклически выводил числа из определенного диапазона.
 * —оздать поток, который будет каждые 10 секунд выводить текущее врем€ на экран. —делать возможность прерывани€ потока с помощью команды с консоли.
 * —оздать 100 потоков, каждый их которых выведет на экран свой номер и дождетс€, пока его прервут.
 */


public class Main { 

    public static void main(String[] args) {
        try {
            Counter c = new Counter(0, 4);
            //c.start(); // запускаем поток  
            
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