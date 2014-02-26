package task4;
 
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

	private Stack<String> stack = null;
	private String output = "";

	public static boolean isOperator(char str){ 

		switch(str){
			case '+':
			case '-':
			case '^':
			case '/':
			case '*':	
				return true; 
			default:
				return false; 
		} 	
	}  

	public void calculation(String str) throws Exception{

		Stack<String> stack = new Stack<String>();  

		if(str.length() == 0 || str.replaceAll(" ", "").length() == 0 ){
			throw new Exception("Пришла пустая строка для вычисления");
		}

		char tmp = 0; 

		String [] strArr = str.split(" ");

		for(int i = 0; i < strArr.length; i++){

			if(strArr[i].length() == 1){ // может быть символ
				
				tmp = strArr[i].charAt(0);

				try {
					int var = Integer.parseInt(strArr[i]);

					stack.push(""+var);  
					continue;
		        } catch (NumberFormatException e) {
 
		        	if(isOperator(tmp)){

						if (stack.size() < 2)
							throw new Exception("Недостаточно данных в стеке для операции "+tmp);

						int a 		= Integer.parseInt(stack.pop()); // тут полюбому число
						int b 		= Integer.parseInt(stack.pop()); // тут полюбому число				
						int res  	= 0;

						switch (tmp){
							case '*': res = a*b; break;
							case '/': res = a/b; break;
							case '+': res = a+b; break;
							case '-': res = a-b; break;
						}

						stack.push(""+res);  
					}
		        }   

			} 
			
		
			try {
				int var = Integer.parseInt(strArr[i]);  
				stack.push(""+var);  
			} catch (NumberFormatException e) {  
				//throw new Exception("Недопустимый символ в выражении: "+strArr[i]);
			}    
		}

		if (stack.size() > 1)
			throw new Exception("Количество операторов не соответствует количеству операндов");

		System.out.print(" : " + stack.pop());	
	}

	/**	
	 * @param str - заранее отформатированная строка, вида: "3 4 5 * + 7 + 4 6 - /"
	 * @throws Exception
	 */
	private void parseString(String str) throws Exception{

		if(str.length() == 0 || str.replaceAll(" ", "").length() == 0 ){
			throw new Exception("Пришла пустая строка для парсинга");
		}
 
		char tmp = 0; 

		for(int i = 0; i < str.length(); i++){  

			tmp = str.charAt(i);
			if(tmp == ' '){
				continue;
			} else if(Character.isDigit(tmp)){
				output += tmp;
			} else if(isOperator(tmp) || tmp == '(' || tmp == ')'){
				output += " ";

				switch(tmp){
		            case '+':               
		            case '-':
		            	consider(tmp, 1);     
		            	break;               
		            case '*':              
		            case '/':
		            	consider(tmp, 2);      
		            	break;               
		            case '(':               
		            	stack.push(""+tmp);   
		               break;
		            case ')':               
		            	gotParen(tmp);       
		            	break;
		            default:                
		            	throw new Exception("Что то не так: "+tmp); 
	            }  // end switch

			} else {
				throw new Exception("Недопустимый символ: "+tmp);
			}  
		}    
	}
   
	public  void gotParen(char ch){  

		while(!stack.isEmpty()){ 
			String chx = stack.pop();
			if( chx.equals('('))            
				break;               
			else                     
				output = output +" "+ chx;  // output it
		}  // end while		 
	}  

	public String getString(){
		
		if(stack.size() > 0){
			return  output + " "+  stack.pop();
		} else {
			return  output;
		}
		
	}

	public void consider(char ch, int status){    

		while(!stack.isEmpty()){ 

			String opTop = stack.pop();
       
			if( opTop.equals('(')){	
				stack.push(opTop); 
				break;
	        } else {
	        	int status2; 

	        	if(opTop.equals('+') || opTop.equals('-'))  
	        		status2 = 1;
		        else
		        	status2 = 2;

	        	if(status2 < status) {                     
	        		stack.push(opTop);  
	        		break;
	        	} else {                   
	        		output = output + opTop + " "; 
	        	}
	        }  
		}  // end while	 

		stack.push(""+ch);           
    }  


	public Calculator(String str){

		stack = new Stack<String>();  

		try {
			parseString(str);			
			String result = getString();
			
			System.out.println("" + result );
			calculation(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

 
	public static void main(String [] args) { 

		System.out.print("Введите ваше уравнение :");	 

		Scanner sc = new Scanner(System.in);  
		while(true){ 	 

			String sentence = sc.nextLine(); 
			Calculator obj = new Calculator(sentence);	
			//System.out.println(sentence);	 


		} // end while  

   }
}
