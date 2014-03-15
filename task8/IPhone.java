package task8;

import java.io.IOException;

public class IPhone extends Phone {
	
	public IPhone(String number) throws IOException {		
		super(number);

		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	final public void call(String number){
		
		System.out.println("IPhone class is calling " + number);
		super.call(number);
		
	}
	
	public void sendSMS(String number, String message) {
		super.sendSMS();
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
	}
}
