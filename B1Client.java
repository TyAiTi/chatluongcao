 //ket noi tuan tu 1-1
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class B1Client {
	public static void main(String[] args) {
		System.out.println("Dang khoi tao socket...");
		int kytu, kytunhan;
		byte []chuoinhan = new byte[100];
		int len;
		while(true) {
		try {
			//B1: khoi tao socket de noi ket voi server khi biet IPv4 va port
			Socket s = new Socket("127.0.0.1", 1025);
			//System.out.println("Connect thanh cong voi: "+ s);
			//B2: lay input output stream gan voi socket de trao co the trao doi dl
			InputStream is= s.getInputStream();
			OutputStream os = s.getOutputStream();
			//B3: trao doi du lieu voi server while(true)									
				
				System.out.print("Moi ban nhap vao 1 ki tu so: ");
				kytu = System.in.read();
				
				System.in.skip(2);
				if((char)kytu=='@') {
	         		   System.out.println("Chuong trinh dung lai");
	         		   break;
         	   	}
				
				os.write((char)kytu);
				
				len = is.read(chuoinhan);
				System.out.println("Chuoi ki tu nhan tu server: "+ new String(chuoinhan,0,len));
				
			
			//B4: dong ket noi chuong trinh
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
}

