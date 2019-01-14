/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

/**
 *
 * @author HP
 */
public class ClientMultiFrame extends javax.swing.JFrame {
    String user;
    Socket socket = null;

    /**
     * Creates new form ClientMultiFrame
     */
    public ClientMultiFrame(String user,Socket socket) {
        this.user = user;
        this.socket = socket;
        
        initComponents();
        
        
        
        try {
            setParagraph();
        } catch (IOException ex) {
            Logger.getLogger(ClientMultiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        initialiser();
        writeTextField.requestFocusInWindow();
    }
    

    public void setParagraph() throws FileNotFoundException, IOException
    {
        String text = "";
        String s = "";
        try {
                InputStream ois = (InputStream) socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ois));
                    text = text+br.readLine();
                    text = text + "\n";
                    System.out.println(text);
                dataTextPane.setText(text);
                dataTextPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                ois.close();
                br.close();
            }
            catch (IOException ex) {
            Logger.getLogger(ClientMultiFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }
    
    private void initialiser() {
       SpeedChecker speedChecker = new SpeedChecker();
       Thread thread1 = new Thread(speedChecker);
       thread1.start();
       System.out.println("Message:qwer ");
       Checker3 checker = new Checker3(dataTextPane,writeTextField,speedChecker,user);
       Thread thread = new Thread(checker);
       thread.start();
       
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rankingsTextPane = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTextPane = new javax.swing.JTextPane();
        writeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(rankingsTextPane);

        dataTextPane.setEditable(false);
        jScrollPane2.setViewportView(dataTextPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(writeTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(writeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 127, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane dataTextPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane rankingsTextPane;
    private javax.swing.JTextField writeTextField;
    // End of variables declaration//GEN-END:variables
}
