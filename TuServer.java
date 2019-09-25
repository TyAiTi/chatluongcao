package tyaiti.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TuServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1025);
			System.out.println("Server is running");
			
			//cho server luon luon run							
			int count =0;
			//trao doi du lieu voi client
			while(true) {
				//chap nhan ket noi
				Socket s = ss.accept();
				count ++;
				System.out.println("Client thu "+count+" da ket noi");
				//tao ra 1 luong xu ly voi client	
				Xuly process = new Xuly(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// ket thuc ham main
}//ket thuc lop server


//lop na ko la lop public 
//bat buoc phai co extends Thread
class Xuly extends Thread{
	private Socket s;
	public Xuly(Socket soc) {
		s = soc;
		start(); //san tien start luon, ko bat buoc
	}
    public String tachten(String hoten){
        String []mang = hoten.split(" "); //Nguyen Van An = "Nguyen" "Van" "An"
        int cuoi = mang.length -1;// lay ten 
        String ten = mang[cuoi];
        
        return ten;
    }
	
	public void run() {
		
		try {//lay input output 
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			String nhan, gui;
			byte []b = new byte[100];
			int len;
			//trao doi du lieu voi client
			while(true) {
				len = is.read(b);				
				nhan = new String(b,0,len);
				//dieu kien dung
				if(nhan.equals("q")) {
					System.out.println("Chuong trinh dung lai");
					break;
				}
				System.out.println("Chuoi vua nhan duoc: "+ nhan);
				gui = tachten(nhan);
				os.write(gui.getBytes());
			}
			//dong chuong trinh
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
