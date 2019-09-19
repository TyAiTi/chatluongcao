/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tuhoa
 */
public class TachTenServer {
    public static void main(String[] args){
        
        try {  
            ServerSocket server = new ServerSocket(1025);
            //In ra man hinh System.
            System.out.println("Khoi dong server");
            byte []c = new byte[100];
            String chuoinhan;
            while(true){
                // tao socket nhan
            Socket s = server.accept();
            System.out.println("da accept");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            int len = is.read(c);
            chuoinhan = new String(c,0,len);
            //In ra man hinh System.
//            if(chuoinhan.equals("exit")){
//                System.out.println("Ngung ket noi vs Client");
//                break;
//            }
            System.out.println("Nhan duoc: "+ chuoinhan);
            //System.out.println("Nhan duoc: "+ new String(c,0,len));
            }
        } catch (IOException ex) {
            
        }
    }
}

class Xyly1 extends Thread{
    private Socket s;
    public Xyly1(Socket soc){
        s = soc;
        start();
    }
    //ham tach ten
    public String tacten(String hoten){
        String []mang = hoten.split(" "); //Nguyen Van An = "Nguyen" "Van" "An"
        int cuoi = mang.length -1;// lay ten 
        String ten = mang[cuoi];
        
        return ten;
    }
    public void run(){
        try{
            InputStream is = s.getInputStream();
 	    OutputStream os = s.getOutputStream();
            //B2: trao doi du lieu, ko khai bao trong vong lap
             byte []b = new byte[100];
             int len ; 
             String hoten, ten;
             while(true){
               //nhan du lieu tu client
               len = is.read(b);
               //chuyen ve chuoi
               hoten = new String(b,0,len);
               
               //xu ly tach ten
               ten = "abc";
               //gui ten ve cho client
               os.write(ten.getBytes());
             }
             
             //B3 dong ket noi
        }
        catch(IOException e){
            
        }
    }
}
