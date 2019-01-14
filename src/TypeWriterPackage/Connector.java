/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshit
 */
public class Connector {
    
    // JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	    static final String DB_URL = "jdbc:mysql://localhost/db";
 
	    //  Database credentials
	    static final String USER = "root" ;
	    static final String PASS = "";
            Connection conn = null;
            
            public Connector(){
               //create object of Connection and define it null
	    	try //try block
	    	{
	    		//STEP 2: Register JDBC driver
	    		Class.forName("com.mysql.jdbc.Driver");
	    		//STEP 3: Open a connection
	    		System.out.println("Connecting to a selected database...");
	    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        //print on console
	    		System.out.println("Connected database successfully...");	    	
                }
	    	catch(SQLException se) //catch block
	    	{
	    		//Handle errors for JDBC
	    		//se.printStackTrace();
	    	}
	    	catch(Exception e) //catch block
	    	{
	    		//Handle errors for Class.forName
	    		e.printStackTrace();
	    	}
	    	//end try
	    	System.out.println("Goodbye!"); //print on console
	    }
    public void register(String email,String password)  {
        Statement stmt = null;
        try {
            String sql = "INSERT INTO userinfo (email, password) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
 
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
        }
        catch(SQLException se){
            se.printStackTrace();
         }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt!=null)
                conn.close();
            }
            catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    void checkLogin(String email, String password) {
    String queryCheck = "SELECT * from userinfo WHERE email = ? AND password = ?";
            PreparedStatement st;
        try {
            st = conn.prepareStatement(queryCheck);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (!rs.next())
            {
                /*Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Login Credentials");
                alert.setContentText("Wrong username or passsword");
                alert.showAndWait();*/
                JOptionPane optionPane = new JOptionPane("Invalid Login Credentials",JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
            else
            {
                LoggedinPage lp = new LoggedinPage(conn,email);
                lp.setVisible(true);
                lp.setLocationRelativeTo(null);
                lp.setDefaultCloseOperation(lp.EXIT_ON_CLOSE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
	   
	    

