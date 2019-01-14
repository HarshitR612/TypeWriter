/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 *
 * @author Harshit
 */
public class Checker implements Runnable{
    int token = 0;
    int nextToken = 0;
    JTextPane tp;
    JTextField tf;
    StringTokenizer st;
    int position = 0;
    SpeedChecker speedChecker;
    String text;
    
    public Checker(JTextPane tp,JTextField tf,SpeedChecker speedChecker)
    {
        this.tf = tf;
        this.tp = tp;
        this.speedChecker = speedChecker;
    }

    @Override
    public void run() {
            //System.out.println("kkkkk");
            text = tp.getText();
            //temp highlight = new temp(tp);
            Styles style = new Styles(tp);
            String firstWord = null;
            String secondWord;
            //System.out.println("kkkkk");
            st = new StringTokenizer(text," ");
            firstWord = st.nextToken();
            //System.out.println("kkkkk1");
            style.formatter3(firstWord,0);
            //System.out.println("kkkkwwk");
            int count1 = 0,count2 = 0;
            while(true)
            {
                //System.out.println("kkkkk");
                //System.out.println("hi");
                String temp = tf.getText();
                int len = temp.length();
                if(len>0 && temp.charAt(len-1)==' ')
                {
                    if(st.hasMoreTokens()){
                        secondWord = st.nextToken();
                        temp = temp.substring(0, len-1);
                        if(temp.equals(firstWord))
                        {
                            System.out.println(firstWord);
                            System.out.println(secondWord);
                            style.formatter(firstWord, position);
                            style.formatter3(secondWord, position+firstWord.length()+1);
                            count1++;
                        }
                        else
                        {
                            System.out.println(firstWord);
                            System.out.println(secondWord);
                            style.formatter2(firstWord, position);
                            style.formatter3(secondWord, position+firstWord.length()+1);
                            count2++;
                        }
                    }
                    else
                    {
                        temp = temp.substring(0, len-1);
                        System.out.println(firstWord);
                        if(temp.equals(firstWord))
                        {
                            style.formatter(firstWord, position);
                            count1++;
                        }
                        else
                        {
                            System.out.println(firstWord);
                            style.formatter2(firstWord, position);
                            count2++;
                        }
                        break;
                    }
                    position += (firstWord.length()+1);
                    firstWord = secondWord;
                    tf.setText("");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Checker.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("hello");
                }
            }
        try{
        System.out.println(count1+" "+count2+" "+speedChecker.time);
        String accuracy = ""+(int) ((count1*100)/(count1+count2));
        String netSpeed = ""+(int)(count1/((double)speedChecker.time/60));
        String grossSpeed = ""+(int)((count1+count2)/((double)speedChecker.time/60));
        
        JOptionPane optionPane = new JOptionPane("Accuracy: "+accuracy+"%\n Net Speed: "+netSpeed+"\n Gross Speed: "+grossSpeed+"\n",JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Your Performance");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
        }catch(Exception e){}
    }
    
}
