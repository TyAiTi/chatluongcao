import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
 
 public class khach{
 	public final static String SERVER_IP = "127.0.0.1";
 	public final static int SERVER_PORT = 7;
 	public static void main(String args[] ) throws IOException, InterruptedException{
 		Socket s = null;
 		try{
 			s = new Socket(SERVER_IP, SERVER_PORT);
 			System.out.println("Connet to server success: "+ s);

 			InputStream is = s.getInputStream();
 			OutputStream os = s.getOutputStream();
 			

 		}
 		catch(IOException ie){
 			System.out.print("Can't connect to server");
 		}
 		finally{
 			if(s != null){
 				s.close();
 			}
 		}
 	}
 }
