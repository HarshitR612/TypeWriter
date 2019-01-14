/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeWriterPackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshit
 */
public class SpeedChecker implements Runnable {
    int time;
    @Override
    public void run() {
        while(true)
        {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SpeedChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        time++;
        }
    }
    
}
