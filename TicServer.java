package tyaiti.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TyServer {
	public static byte[] bancomoi = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	public static int luotdanh = 0;
	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(1026);
			System.out.println("Server is running");

			// cho server luon luon run
			int count = 0;
			String chodoi;
			// trao doi du lieu voi client
			while (true) {
				// chap nqan ket noi
				Socket s = ss.accept();
				count++;
				System.out.println("Client thu " + count + " da ket noi");
				// tao ra 1 luong xu ly voi client

				// System.out.print("da san sang");
				Xuly process = new Xuly(s, bancomoi, count);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// ket thuc ham main
}// ket thuc lop server

//lop na ko la lop public 
//bat buoc phai co extends Thread
class Xuly extends Thread {
	private Socket s;
	byte[] bancomoi;// = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	int count = 0; // khai báo biến count để kiểm tra client
	int flag; //chinh la luot danh

	public Xuly(Socket soc, byte[] b, int luotdanh) {// truyen du lieu vao day
		s = soc;
		bancomoi = b;
		flag = luotdanh;
		System.out.println("Kiem tra luot danh flag la: "+ flag);
		start(); // san tien start luon, ko bat buoc
					// System.out.print("ahih");
	}

	public String bancomoi(int index) {
		String banco;
		if (flag == 1) {
			bancomoi[index] = 'X';			
		} else {
			bancomoi[index] = 'O';
				}
		
		
		banco = new String(bancomoi, 0, 16);
		return banco;
	}

	public void run() {
		try {// lay input output
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			String nhan, gui;
			byte[] b = new byte[100];
			int len, vitri;
			// trao doi du lieu voi client
			while (true) {
				
				len = is.read(b);
				nhan = new String(b, 0, len);
				// dieu kien dung
				if (nhan.equals("q")) {
					System.out.println("Chuong trinh dung lai");
					break;
				}
				System.out.println("Chuoi vua nhan duoc: " + nhan);
				vitri = Integer.parseInt(nhan);
				gui = bancomoi(vitri);
				os.write(gui.getBytes());
				
			}
			
			// dong chuong trinh
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
