package tyaiti.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TyClient{
	public static void main(String[] args) {
			System.out.println("Khoi tao Socket");
		try {//tao socket co ip va port
			Socket s = new Socket("127.0.0.1", 1026);
			System.out.println("Connect success !");
			System.out.println("Tro choi bat dau ");
			//yeu cau khoi tao mang
			
			//khai bao input output
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			//khoi tao ban co
			byte []banco = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
			int count1 = 0;
			for(int i =0; i<16; i++) {
				if(i<10) {
					System.out.print("["+banco[i]+" ] ");
				}
				else {
					System.out.print("["+banco[i]+"] ");
				}					
				count1 ++;
				if(count1==4) {
					System.out.println(" ");
					count1 = 0;
				}					
			}
			
			Scanner sc = new Scanner(System.in);
			String gui;
			byte[]b = new byte[100];
			int len;
			int count = 0;
			//trao doi dud lieu voi server dung while (true)
			while(true) {
				System.out.println("Moi nguoi choi chon vi tri tiep theo cho X: ");
				gui = sc.nextLine();
				//gui du lieu
				os.write(gui.getBytes());
				//System.out.println("du lieu vua gui la:"+gui);
				//dong ket noi neu dieu kien dung
				if(gui.equals("q")) {
					System.out.println("Dong ket noi");
					break;
				}
				//doc du lieu
				len = is.read(b);
				
				for(int i =0; i<16; i++) {
					if(i<10) {
						System.out.print("["+b[i]+" ] ");
					}
					else {
						System.out.print("["+b[i]+"] ");
					}					
					count ++;
					if(count==4) {
						System.out.println(" ");
						count = 0;
					}					
				}
			}//ket thuc vong lap while
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
