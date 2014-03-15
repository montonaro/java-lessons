package task8;

import java.io.IOException;

public class Nokia3310 extends Phone {
	
	public Nokia3310(String number) throws IOException{
		super(number); 
		
		touch = false;
		hasWifi = false;
		screenSize = 2;
	}
	
	public void call(String number) {
		
		System.out.println("Nokia3310 class is calling " + number);
		super.call(number);		
	}
	
	public void sendSMS(String number, String message) {
		super.sendSMS();
		System.out.println("Nokia3310 class is sending sms " + message + " to " + number);	
	}
}
