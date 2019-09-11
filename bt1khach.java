import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
 
 public class bt1khach{
 	public final static String SERVER_IP = "127.0.0.1";
 	public final static int SERVER_PORT = 7;
 	public static void main(String args[] ) throws IOException, InterruptedException{
 		Socket s = null;
 		try{
 			s = new Socket(SERVER_IP, SERVER_PORT);
 			System.out.println("Connet to server success: "+ s);

 			InputStream is = s.getInputStream();
 			OutputStream os = s.getOutputStream();
 			
 			for(int i='0'; i<='9'; i++){
 				os.write(i);//gui tung so den may chu
 				int ch = is.read();//doi may chu tra loi
 				System.out.print((char)ch+ " ");//In ket qua ra man hinh
 				Thread.sleep(500); //tam ngung 0,5s
 			}

 		}
 		catch(IOException ie){
 			System.out.print("Can't connect to server");
 		}
 		finally{
 			if(s != null){
 				System.out.println("\nClose progam Client !");
 				s.close();
 			}
 		}
 	}
 }
