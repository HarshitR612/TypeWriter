/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

/**
 *
 * @author Harshit
 */

    import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class temp{
  private JTextComponent comp;


  public temp(JTextComponent c) {
    comp = c;
  }

  public void highlight(String charsToHighlight,int position) {
    // highlight all characters that appear in charsToHighlight
    Highlighter h = comp.getHighlighter();
    //h.removeAllHighlights();
    int length = charsToHighlight.length();
      try {
          h.addHighlight(position, position + length, DefaultHighlighter.DefaultPainter);
      } catch (BadLocationException ex) {
          Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

}
