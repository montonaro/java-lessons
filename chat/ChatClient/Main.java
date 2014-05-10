
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		try {
			final Scanner scanner 	= new Scanner(System.in);
			final Socket socket 	= new Socket("127.0.0.1", 5001);
			final InputStream is 	= socket.getInputStream();
			final OutputStream os 	= socket.getOutputStream();
			
			final String pathFiles 		= "C:\\tmp\\users\\";

			System.out.println("Enter login: ");
			final String login = scanner.nextLine();

            Thread th = new Thread() { 
                @Override
                public void run() {
                    try {
                        while ( ! isInterrupted()) {
                            Message msg = Message.readFromStream(is, login, pathFiles);
                            if (msg == null)
                                Thread.yield();
                            else
                                System.out.println(msg.toString());
                        }
                    } catch (Exception e) {
                        return;
                    }
                }
            };
            th.setDaemon(true);
            th.start();
			
			try {
				while (true) {
					String s = scanner.nextLine();
					if (s.isEmpty())
						break;
					
					int del = s.indexOf(':');
					String to = "";  
					
					Message m 	= new Message();
					
					if (del >= 0 && s.charAt(2) != '\\' ) {
						to 	 = s.substring(0, del);
						m.text = s.substring(del + 1);
					} else if(new File(s).isFile()){

						m.path   = s; 
						m.isFile = true;
					} else {
						m.text = s;
					}
					
					m.from 		= login;
					m.to 		= to;
					
					m.writeToStream(os);
				}
			} finally {
				th.interrupt();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
