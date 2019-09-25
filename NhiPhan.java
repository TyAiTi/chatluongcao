package tyaiti.com;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		
		
        // Khai báo một biến age (tuổi)
        int kytu;
        String gui;
        String numgui, numnhan;//cho câu 1 b
        Scanner sc = new Scanner(System.in);
        while(true) {
		   System.out.print("Moi ban nhap vao 1 so: ");
		   numgui = sc.nextLine();
		   if(numgui.equals("q")) {
			   System.out.println("Chuong trinh dung lai ");
			   break;
		   }
		   //tiep theo kiem tra so nguyen hop le khong
		   if(ktsonguyen(numgui)==false) {
			   System.out.println("Ban vua nhap khong phai so nguyen ");
		   }
		   else {
			   System.out.println("Ok "+ numgui+" la so nguyen");
			   numnhan = nhiphan(numgui);
			   System.out.println("Ket qua chuoi nhi phan la:"+numnhan);
		   }
		   	
		}
 


	}
	//ham nay kiem tra chuoi 1 ki tu , neu 1 -> mot vvv
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
	
	//ham kiem tra chuoi co phai so nguyen hay khong
	public static boolean ktsonguyen(String strNum) {
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	//doi chuoi thanh nhi phan
	public static String nhiphan(String numgui) {
		String nhan;
		int t, a, i, dao, d;
		i = 0;
		d = 0;
		byte []b  = new byte[50];
		byte []c  = new byte[50];
		a = Integer.parseInt(numgui);
		//System.out.println("Kiem tra a = "+a);
		t = a;
		for(int j=0; j<=7; j++) {
			b[j] = 48;
			c[j] = 48;
		}
		
		while(a>0) {
			b[i] = (byte)((t%2)+48); //kieu byte he ho 10 thi 48 moi la so 0
			//System.out.println("Kiem tra mang vi tri i "+ i+ ": " +b[i]);
			a = a/2;
			t = a;
			i++;			
		}
		i--;
//		for(int j=0; j<i; j++) {
//			System.out.print(""+b[j]);
//		}
//		System.out.println("\nTinh toan xong ");
//		System.out.println("Chuoi nhan la: "+ b);
//		nhan = b.toString();//chuyen mang thanh chuoi
		
		//ham dao chieu gia tri mang
		System.out.println("Kiem tra i "+i);
		dao = i;
		
//		for(int j=0; j<=i; j++) {
//			c[j] = b[dao];
//			dao--;
//		}
		for(int j =7; i>=0; j--) {
			if(j==-1) {
				break;
			}
			else {
				c[j] = b[d];
				d++;
			}	
		}
		
		System.out.println("Kiem tra b ");
		for(int j=0; j<=7; j++) {
			System.out.println("vi tri: "+j+" la: "+b[j]);
		}
		System.out.println("Kiem tra c ");
		for(int j=0; j<=7; j++) {
			System.out.println("vi tri: "+j+" la: "+c[j]);
		}
		nhan = new String(c);		
		//System.out.println("Chuoi nhan Clien la: "+ nhan);
		return nhan;
	}
	
}
