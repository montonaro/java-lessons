package task8;

import java.io.IOException;

public class IPhone5 extends IPhone {
	
	public IPhone5(String number) throws IOException{
		super(number); 
		screenSize = 4;
	}
 
	@Override
	public void sendSMS(String number, String message) {
		super.sendSMS(number, message);
		System.out.println("IPhone5 class is sending sms " + message + " to " + number);	
	}
}
