package TypeWriterPackage;


import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Styles {
   JTextPane pane;
   
   public Styles(JTextPane tp)
   {
       this.pane = tp;
   }
   
  public void formatter(String word,int position) {
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    
    // Create the StyleContext, the document and the pane
    StyleContext sc = new StyleContext();
    StyledDocument doc; 
    doc = pane.getStyledDocument();
    
    // Create and add the main document style
    Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
    final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
   
    StyleConstants.setFontFamily(mainStyle, "Verdana");
  

    // Create and add the constant width style
    final Style cwStyle = sc.addStyle("", null);
   
    StyleConstants.setForeground(cwStyle, Color.GREEN);

    // Create and add the heading style
    
    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            doc.setLogicalStyle(0, mainStyle);
            doc.setCharacterAttributes(position, word.length(), cwStyle, false);
            
        }
      });
    } catch (Exception e) {
      System.out.println("Exception when constructing document: " + e);
    }

    
  }

    void formatter2(String word, int position) {
        try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    
    // Create the StyleContext, the document and the pane
    StyleContext sc = new StyleContext();
    StyledDocument doc; 
    doc = pane.getStyledDocument();
    
    // Create and add the main document style
    Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
    final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
   
    StyleConstants.setFontFamily(mainStyle, "Verdana");
  

    // Create and add the constant width style
    final Style cwStyle = sc.addStyle("", null);
   
    StyleConstants.setForeground(cwStyle, Color.red);

    // Create and add the heading style
    
    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            doc.setLogicalStyle(0, mainStyle);
            doc.setCharacterAttributes(position, word.length(), cwStyle, false);
            
        }
      });
    } catch (Exception e) {
      System.out.println("Exception when constructing document: " + e);
     
    }

    }

   

    void formatter3(String secondWord, int position) {
        try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    
    // Create the StyleContext, the document and the pane
    StyleContext sc = new StyleContext();
    StyledDocument doc; 
    doc = pane.getStyledDocument();
    
    // Create and add the main document style
    Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
    final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
   
    StyleConstants.setFontFamily(mainStyle, "Verdana");
  

    // Create and add the constant width style
    final Style cwStyle = sc.addStyle("", null);
   
    StyleConstants.setForeground(cwStyle, Color.magenta);

    // Create and add the heading style
    
    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            doc.setLogicalStyle(0, mainStyle);
            doc.setCharacterAttributes(position, secondWord.length(), cwStyle, false);
            
        }
      });
    } catch (Exception e) {
      System.out.println("Exception when constructing document: " + e);
    }
    }

   
}