import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
 public class chu{
 	public final static int SERVER_PORT = 7;
 	public static void main(String args[] ) throws IOException{
 		ServerSocket server = null;
 		try{
 			System.out.println("Bingding to port" + SERVER_PORT +", please wait...");
 			server = new ServerSocket(SERVER_PORT);
 			System.out.println("Server started: "+server);
 			System.out.println("Waiting for a client ...");

 			while(true){
 				try{
 					Socket socket = server.accept();
 					System.out.println("Client accept "+socket);

 					InputStream is = socket.getInputStream();
 					OutputStream os = socket.getOutputStream();
 					
 				}
 				catch(IOException e){
 					System.out.println("Connection ERROR: "+e);
 				}
 			}
 		}
 		catch(IOException el){
 			el.printStackTrace();
 		}
 		finally{
 			if(server != null){
 				server.close();
 			}
 		}
 	}
 }


 
