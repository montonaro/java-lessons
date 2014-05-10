import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
	private int port;
	private Thread thread;
	private List<Message> msg = Collections.synchronizedList(new ArrayList<Message>());
	private final static String filesDir = "C:\\tmp\\server\\"; 
	
	public Server(int port) {
		this.port = port;
		
		String [] dirs = filesDir.split("\\\\");
		if(dirs.length > 0){
			String path = "";  
			for(int i = 0; i < dirs.length; i++){ 
				if(i < dirs.length){
					path += dirs[i]+"\\";

					File f = new File(path);
					if(!f.isDirectory()){
						f.mkdir(); 
					} 
				}  
			}
			 
		} 
		
	} 

	public void start() throws IOException {
		thread = new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket s = new ServerSocket(port);

					while ( ! isInterrupted()) {
						Socket c = s.accept();
						
						ClientThread ct = new ClientThread(c, msg, filesDir);
						ct.start();
					}

					s.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}
}
