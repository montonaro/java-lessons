import java.io.*;
import java.util.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Date date = new Date();
	public String from;
	public String to;
	public boolean isFile;
	public transient String text;
	public transient String path;
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("[")
			.append(date.toString())
			.append(", From: ")
			.append(from)
			.append(", To: ")
			.append(to)
			.append("] ")
			.append(text)
			.toString();
	}
	
	public void writeToStream(OutputStream out)
		throws IOException
	{
		ByteArrayOutputStream bs 	= new ByteArrayOutputStream();
		ObjectOutputStream os 		= new ObjectOutputStream(bs);
		 
		try {
			os.writeObject(this);
			
			if ( ! isFile) {
				os.writeUTF(text);
			} else {
				// write file content 
				os.writeUTF(path);  
			}
		} finally {
			os.flush();
			os.close();
		}
		
		byte[] packet = bs.toByteArray();
		
		DataOutputStream ds = new DataOutputStream(out);
		ds.writeInt(packet.length);
		ds.write(packet);
 
		
		if(isFile){
			BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(path));
			byte [] byteArray 		 = new byte[8192];
			
			ds.writeInt((int) new File(path).length());
			
			int in;
			while ((in = bis.read(byteArray)) != -1){
				ds.write(byteArray,0,in);
			}
			bis.close();  
		} 
		
		ds.flush();		
	}
	
	public static Message readFromStream(InputStream in, String login, String pathFiles) 
		throws IOException, ClassNotFoundException
	{
		if (in.available() <= 0)
			return null;
		
		DataInputStream ds = new DataInputStream(in);
		int len = ds.readInt();
		byte[] packet = new byte[len];
		ds.read(packet);
		
		ByteArrayInputStream bs = new ByteArrayInputStream(packet);
		ObjectInputStream os    = new ObjectInputStream(bs);
		try {
			Message msg = (Message) os.readObject();
			
			if(msg.from.equals(login)){
				return null;
			} 
			
			if(!msg.to.isEmpty() && !msg.to.equals(login)){
				return null;
			} 
			
			if ( ! msg.isFile) {
				msg.text = (String) os.readUTF();
			} else { // read file content 
				 
				msg.path = (String) os.readUTF(); 				  
				BufferedOutputStream bos = null; 				  
				BufferedInputStream  bis = null; 
				String filename 		 = msg.path.substring(msg.path.lastIndexOf('\\')+1);
				
				try {
					bis  		      = new BufferedInputStream(ds);
					bos 			  = new BufferedOutputStream(new FileOutputStream( pathFiles + filename ));
					byte [] byteArray = new byte[8192];
				 
					len = ds.readInt();
					
					int i; 
					while ((i = bis.read(byteArray)) != -1){
												
					    bos.write(byteArray,0,i); 
					    len -= i;
					    
					    if(len <= 0)
					    	break;  
					}  
					
				} finally {
					bos.close();
					//bis.close();
				}
				
				msg.text = "Был принят файл:"+filename; 
			}
			
			return msg;
		} finally {
			os.close();
		}
	}
}
