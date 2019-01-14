/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class ServerClass implements Runnable {
    private static int listenOnPort = 9785;
    private static ServerSocket server;
    String email;
    Socket socket[] = new Socket[1000];
    InputStream ois[] = new ObjectInputStream[1000];
    OutputStream oos[] = new ObjectOutputStream[1000];
    PrintWriter pw[] = new PrintWriter[1000];
    String files[] = {"f1","f2","f3","f4"};
    String file;
    
    public ServerClass (String email) {
        this.email = email;
    }
    
    public void run() {
        int i = 0;
        try {
            server = new ServerSocket(listenOnPort);
            System.out.println(Inet4Address.getLocalHost().getHostAddress());
            
            long startClock = System.currentTimeMillis();
             
            
                System.out.println("Waiting for the client to connect...");
         
//                long endClock = System.currentTimeMillis();
//                if ((endClock - startClock)>5000) {
//                System.out.println("Connection refused");
//                break;
                //}
                System.out.println("hello");
                socket[i] = server.accept();
                //ois[i] = socket[i].getInputStream();
                System.out.println("hello2");
                pw[i] = new PrintWriter(socket[i].getOutputStream());
                System.out.println("hello1");
                //i++;
            } catch (IOException ex) {
                Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        String text = "";
        try{
            Random rn = new Random();
            int j = (rn.nextInt()%4+4) % 4;
            file = files[j];
            
            FileReader fileReader = new FileReader("C:\\Users\\HP\\Desktop\\"+file+".txt");
            BufferedReader br = new BufferedReader(fileReader);
            String s= "";
            while((s = br.readLine()) != null)
            {
                text = text+s;
                text = text + "\n";
            }
            System.out.println(text);
            br.close();
            fileReader.close();
        } catch (IOException ex) {
                Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        //for(int j=0;j<i;j++)
        //{
        System.out.println("b");
            pw[0].println(text);
            pw[0].flush();
            System.out.println("f");
        //}
            
            MultiFrame multiFrame = new MultiFrame(email, file);
            System.out.println("kk");
            multiFrame.setVisible(true);
            multiFrame.setLocationRelativeTo(null);
            multiFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        try {
            socket[0].close();
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}

    
