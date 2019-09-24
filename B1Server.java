/* ket noi tuan tu 1-1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuhoa
 */
//
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class B1Server {
	public static void main(String[] args) {
		try {
			//Khoi tao socket gan so hieu cong
			ServerSocket ss = new ServerSocket(1025);
			System.out.println("Server is running...");		
			
			int kytunhan;
			String gui;
			while(true) {
				//tao socket chap nhan ket noi tu client
				Socket s = ss.accept();
				//lay input output
				InputStream is = s.getInputStream();
	            OutputStream os = s.getOutputStream();
				
				System.out.println("Client thu da ket noi !");
		
				kytunhan = is.read();
				System.out.println("Client gui ve: "+(char)kytunhan);
				
	         	   if((char)kytunhan=='@') {
	         		   System.out.println("Chuong trinh dung lai");
	         		   break;
	         	   }
//	         	   if(kytu<48 || kytu>58) {
//	         		   System.out.println("Ban phai nhap so trong gioi han 0~9");
//	         		   System.out.println("ky tu" +kytu);
//	         	   }
	         	   else {
	             	   //System.out.println("Con so nhan duoc "+(char)kytu);         	   
	              	  //System.out.println("Len cua kytu "+kytu);
	         		   //goi ham xuly
	         		   gui = kytu((char)kytunhan);
	         		   os.write(gui.getBytes());
	         	   }
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
		
	}
	public static String kytu(char kytu) {
		String gui;
		switch ((char)(kytu)) {       
        case '0':
            gui = "khong";
            break;        
        case '1':
            gui = "mot";
            break;
        case '2':
            gui = "hai";            
            break;
        case '3':
            gui = "ba";
            break;
        case '4':
            gui ="bon";
            break;
        case '5':
            gui = "nam";                
            break;
        case '6':
            gui = "sau";
            break;
        case '7':
            gui = "bay";                
            break;
        case '8':
            gui = "tam";                
            break;
        case '9':
            gui = "chin";                
            break;                
        default:
                gui = "Ban chi duoc nhap gioi han tu 0~9";
            
        }
		return gui;
	}
}//ket thuc lop server
