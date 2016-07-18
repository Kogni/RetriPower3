package GUI;

import java.awt.*;
import javax.swing.*;

/** Instansieres og settes i JFrames for å gi dem en statusbar **/
public class StatusBar extends JLabel {
    
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMessage("Ready");
    }
    
    public void setMessage(String message) {
    	
        setText(message);   
        
    }   
    
}