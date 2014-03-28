package task8;

import java.io.IOException;

public abstract class Phone {
	
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
	
	protected static int countAllCall 	= 0;
	protected static int countAllSMS  	= 0;
	protected int countCall 			= 0;
	protected int countSMS  			= 0;
	
	protected static ActivePhones list	= null;
	protected String phoneNumber;
	
	public Phone( String number) throws IOException{
				
		//можно было бы написать валидацию для номера телефона. 
		//так как нам на номер телефона все равно, это упускается.
		phoneNumber = number; 
			
		if(list == null){ 
			list = new ActivePhones();
		} else {
			if(list.find(number) >= 0){
				throw new IOException ("Номер '"+number+"' уже зарегестрирован.");
			}
		}			 
		
		list.add(this); 		 
	}
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	public String getPhone(){
		return phoneNumber;
	}
	
	public int getCountCall(){
		return countCall;
	}
	
	public int getCountSMS(){
		return countSMS;
	}
	
	public static int getCountAllCall(){
		return countAllCall;
	}
	
	public static int getCountAllSMS(){
		return countAllSMS;
	}
	
	protected void call(String number){ 
		
		try{
			if(number == phoneNumber){
				throw new IOException ("Вы пытаетесь позвонить на свой же номер.");
			}
			
			int i = list.find(number);
			if(i < 0){
				throw new IOException ("Номер '"+number+"' не найден.");
			}
			
			Phone p = list.get(i);
			p.answer(); 
			 
			countCall++;
			countAllCall++; 
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		} 
		
	}
	
	public void sendSMS(){
		countSMS++;
		countAllSMS++;
	} 
	
	public void answer(){ 
		System.out.println(this.getClass().getName()+"("+this.getPhone()+"): Алё");
	}
}
