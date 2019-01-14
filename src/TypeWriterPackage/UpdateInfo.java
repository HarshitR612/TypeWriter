/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;



/**
 *
 * @author Harshit
 */
public class UpdateInfo implements Runnable{
    Connection conn;
    String user;
    JTable table;
    JTable table2;
    int count = 0;
    
    public UpdateInfo(Connection conn,String user,JTable table,JTable table2)
    {
        this.conn = conn;
        this.user = user;
        this.table = table;
        this.table2 = table2;
    }
    @Override
    public void run() {
        while(true)
        {
            String queryCheck = "SELECT * from userdetails where email = ?";
            PreparedStatement st;
            
        
            try {
                st = conn.prepareStatement(queryCheck);
                st.setString(1,user);
                ResultSet rs = st.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
                
//                Document doc1 = tpane1.getDocument();
//                Document doc2 = tpane2.getDocument();
                while(rs.next()) {

                    String time = rs.getString("time");
                    String date = rs.getString("date");
                    String grossSpeed = rs.getString("grossSpeed");
                    String netSpeed = rs.getString("netSpeed");
                    String accuracy = rs.getString("accuracy");
                    String mode = rs.getString("mode");
                    count++;
                    //String text = time + "    " + date + "     " + grossSpeed + "      " + netSpeed + "      " + accuracy + "\n";
                    
                    if (mode.equals("s") ) {
                        
                        model2.addRow(new Object[]{date, time, grossSpeed,netSpeed,accuracy});
//                        try {
//                            System.out.println(text+"hello1");
//                            doc1.insertString(doc1.getLength(), text, null);
//                        } catch (BadLocationException ex) {
//                            Logger.getLogger(UpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }
                    else
                    {
                        model.addRow(new Object[]{date, time, grossSpeed,netSpeed,accuracy});
//                        try {
//                            System.out.println(mode);
//                            doc2.insertString(doc2.getLength(), text, null);
//                        } catch (BadLocationException ex) {
//                            Logger.getLogger(UpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }

    
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(model2.getRowCount());
                
                int len = model.getRowCount();
                for( int i = 0; i < len; i++ )
                {
                    model.removeRow(0);
                    
                }
                int len2 = model2.getRowCount();
                for( int i = 0; i < len2; i++ )
                {
                    model2.removeRow(0);
                }
                
                
                
            } catch (SQLException ex) {
               // Logger.getLogger(UpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }   
}
