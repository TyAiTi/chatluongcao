package tyaiti.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TuClient{
	public static void main(String[] args) {
			System.out.println("Khoi tao Socket");
		try {//tao socket co ip va port
			Socket s = new Socket("127.0.0.1", 1025);
			System.out.println("Connect success !");
			//khai bao input output
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			Scanner sc = new Scanner(System.in);
			String gui, nhan;
			byte []b = new byte[100];
			int len;
			//trao doi dud lieu voi server dung while (true)
			while(true) {
				System.out.print("Nhap vao ho va ten cua ban: ");
				gui = sc.nextLine();
				//gui du lieu
				os.write(gui.getBytes());
				
				//dong ket noi neu dieu kien dung
				if(gui.equals("q")) {
					System.out.println("Dong ket noi");
					break;
				}
				//doc du lieu
				len = is.read(b);
				nhan = new String(b,0,len);
				System.out.println("Ten cua ban la: "+nhan);
				System.out.println("--------------    ---------");
			}
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
