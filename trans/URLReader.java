package translater;

import java.net.*;
import java.nio.charset.Charset;
import java.io.*;

public class URLReader {
    static String getJson(String word) throws Exception {
		
    	String url = "http://translate.google.ru/translate_a/t?client=x&text="+word+"&sl=ru&tl=en";
    	
    	URLConnection connection = new URL(url).openConnection();
    	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
    	connection.connect();

    	BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

    	StringBuilder sb = new StringBuilder();
    	String line;
    	while ((line = r.readLine()) != null) {
    	    sb.append(line);
    	}
    	//System.out.println(sb.toString()); 
    	return sb.toString();
    }
}