/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Harshit
 */
public class Login extends javax.swing.JFrame {

    String files[] = {"f1","f2","f3","f4"};
    String file;
    /**
     * Creates new form Login
     */
    public Login() throws IOException {
        initComponents();
        myinit();
        setParagraph();
        userTextField.requestFocusInWindow();
        initialiser();
        
        
    }
    public void setParagraph() throws FileNotFoundException, IOException
    {
        Random rn = new Random(System.currentTimeMillis());
        int j = (rn.nextInt()%4+4) % 4;
        file = files[j];
        String text = "";
        FileReader fileReader = new FileReader("C:\\Users\\HP\\Desktop\\"+file+".txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s= "";
        while((s = br.readLine()) != null)
        {
            text = text+s;
            text = text + "\n";
        }
        br.close();
        fileReader.close();
        mainTextArea.setText(text);
        mainTextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeWriterPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        signupButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        userTextField = new javax.swing.JTextField();
        footerField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainTextArea = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Type Writer");
        setBackground(new java.awt.Color(255, 51, 51));

        typeWriterPanel.setBackground(new java.awt.Color(255, 51, 51));

        userPanel.setBackground(new java.awt.Color(255, 51, 51));

        signupButton.setBackground(new java.awt.Color(255, 255, 255));
        signupButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        signupButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        loginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        userTextField.setBackground(new java.awt.Color(255, 255, 102));

        footerField.setEditable(false);
        footerField.setBackground(new java.awt.Color(0, 153, 204));
        footerField.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        footerField.setForeground(new java.awt.Color(255, 255, 255));
        footerField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        footerField.setText("Type as fast as you can");
        footerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                footerFieldActionPerformed(evt);
            }
        });

        mainTextArea.setEditable(false);
        mainTextArea.setBackground(new java.awt.Color(255, 204, 255));
        mainTextArea.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(mainTextArea);

        javax.swing.GroupLayout typeWriterPanelLayout = new javax.swing.GroupLayout(typeWriterPanel);
        typeWriterPanel.setLayout(typeWriterPanelLayout);
        typeWriterPanelLayout.setHorizontalGroup(
            typeWriterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(typeWriterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typeWriterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTextField)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(footerField, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        typeWriterPanelLayout.setVerticalGroup(
            typeWriterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typeWriterPanelLayout.createSequentialGroup()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(footerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(typeWriterPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void footerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_footerFieldActionPerformed
    }//GEN-LAST:event_footerFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        lp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        loginDetails login = new loginDetails(this);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_signupButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField footerField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextPane mainTextArea;
    private javax.swing.JButton signupButton;
    private javax.swing.JPanel typeWriterPanel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
     
    private void initialiser() {
       SpeedChecker speedChecker = new SpeedChecker();
       Thread thread1 = new Thread(speedChecker);
       thread1.start();
       Checker checker = new Checker(mainTextArea,userTextField,speedChecker);
       Thread thread = new Thread(checker);
       thread.start();
    }

    private void myinit() {
        
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\login2.jpg");
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(69, 20,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon loginIcon = new ImageIcon(newimg);
        loginButton.setIcon(loginIcon);
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\HP\\Desktop\\signup.jpg");
        Image image2 = imageIcon2.getImage(); 
        Image newimg2 = image2.getScaledInstance(69, 20,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon loginIcon2 = new ImageIcon(newimg2);
        signupButton.setIcon(loginIcon2);
    }

}