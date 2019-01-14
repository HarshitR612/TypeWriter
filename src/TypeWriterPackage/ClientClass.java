/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.currentTimeMillis;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;


/**
 *
 * @author HP
 */
public class ClientClass implements Runnable {
    
    String user;
    
    public ClientClass(String user) {
        this.user = user;
    }
    public void run() {
//        InetAddress host = null;
//        try {
//            host = InetAddress.getLocalHost();
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Socket socket = null;
        ObjectOutputStream oos = null;
        InputStream ois = null;
        try {
            System.out.println("hh");
                //establish socket connection to server
                socket = new Socket("172.31.89.51", 9785);
                System.out.println("hhh");
                //oos = new ObjectOutputStream(socket.getOutputStream());
                //ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("Sending request to Socket Server");
        ClientMultiFrame frame = new ClientMultiFrame(user, socket);
        System.out.println("Message: 1");
        frame.setVisible(true);
        System.out.println("Message: 2");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            
        System.out.println("Message: ");
            
        try {
            //close resources
            //ois.close();
            //oos.close();
            socket.close();
            //Thread.sleep(100);
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
   
