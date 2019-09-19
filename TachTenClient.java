/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author tuhoa
 */
public class TachTenClient {
     	public final static String SERVER_IP = "127.0.0.1";
 	public final static int SERVER_PORT = 1025;
    public static void main(String [] args){
        
        try {
            //B1tao ra socket noi ket server
            Socket s = new Socket(SERVER_IP, SERVER_PORT);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
                        
            Scanner sc = new Scanner(System.in);
            String chuoi;
            while(true){
                //nhap du lieu tu ban phim
                System.out.println("Moi ban nhap ho va ten: ");
                chuoi = sc.nextLine();
                //DIEU KIEN KET THUC
                if(chuoi.equals("exit")){
                    System.out.println("Ngat Client");
                    break;
                }
                
                //gui chuoi cho server
                //byte []b = chuoi.getBytes();
                os.write(chuoi.getBytes());
            }
            
            
            
//            if(!chuoi.equals("exit")) {
//                 break;
//            } 
            
            
            //cho nhan ten tu server
            byte []b = new byte[100];
            int len = is.read(b);
            //In ra man hinh System.
            System.out.println("Nhan duoc: "+ new String(b,0,len));
            
        } catch (IOException ex) {
           System.out.println("KO the ket NOI SERVER");
        }
    }
}
