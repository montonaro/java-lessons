package translater;

import com.google.gson.Gson;

public class ParseJson {	
	
	static class Translater { 			
		public Sentences[] sentences;
		public String src;
		public int server_time; 
	}
	
	static class Sentences {  
		public String trans;
		public String orig;
		public String translit;
		public String src_translit; 
	}	
	
	static String parse(String json){
		Gson gson = new Gson();
				
		Translater obj2 = gson.fromJson(json, Translater.class);   
		if(obj2.sentences.length > 0){
			return obj2.sentences[0].trans;
			/*
			for(Sentences obj : obj2.sentences){					
				System.out.println(obj.trans);
			}
			*/
		} 		
		return null;
	}


}
