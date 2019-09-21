//input i out put 0, trao doi client-server co noi ket song song
//Server line 67, client ~ 69
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			//Khoi tao socket gan so hieu cong
			ServerSocket ss = new ServerSocket(1025);
			System.out.println("Server is running...");
			//Cho server luon luon run
			int count = 0;
			while(true) {
				//tao socket chap nhan ket noi tu client
				Socket s = ss.accept();
				count++;
				System.out.println("Client thu: "+count+" da ket noi !");
				//tao ra 1 luong xu ly vs client
				Xuly process = new Xuly(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}//ket thuc lop server


//lop nay ko phai public 
//bat buoc phai co extends Thread
class Xuly extends Thread{
	private Socket s;
	public Xuly(Socket soc) {
		s = soc;
		start();//san tien start luon
	}
	public void run() {
		
		try {
			//B1: lay input va output stream gan voi socket
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			//B2: trao doi du lieu voi server
			int kytu;
			while(true) {
				//nhan mot ki tu tu client
				kytu = is.read();
				//dieu kien dung
				if((char)kytu == 'q') break;
				//xu ly ki tu
				kytu = '0';
				//gui ket qua ve cho client
				os.write(kytu);
			}
			//B3: dong ket noi
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

//phan client
//nhan mot ki tu tu server, tra ket qua ve cho client

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		System.out.println("Dang khoi tao socket...");
		try {
			//B1: khoi tao socket de noi ket voi server khi biet IPv4 va port
			Socket s = new Socket("127.0.0.1", 1025);
			System.out.println("Connect thanh cong voi: "+ s);
			//B2: lay input output stream gan voi socket de trao co the trao doi dl
			InputStream is= s.getInputStream();
			OutputStream os = s.getOutputStream();
			//B3: trao doi du lieu voi server while(true)
			int kytu, kytunhan;
			
			while(true) {
				//nhap ki tu tu ban phim
				System.out.println("Moi ban nhap 1 ki tu: ");
				kytu = System.in.read();
				//loai bo phim enter
				System.in.skip(2);
				//gui ki tu den cho server
				os.write(kytu);
				//dong socket khi co dk dung
				if((char)kytu=='q') {
					System.out.println("Ngat ket noi voi Server");
					break;
				}
				
				//cho server gui ket qua ve
				kytunhan = is.read();
				//in ket qua server gui ve ra man hinh
				System.out.println("Server tra ve: "+ (char)kytunhan);
			}
			//B4: dong ket noi chuong trinh
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



