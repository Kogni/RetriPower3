package GUI;

import java.awt.*;
import javax.swing.*;

public class Popup_Working extends JFrame {

	public Popup_Working(){
		
		super("RetriPower is working");
		setSize ( 100, 100 );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );
		
		JPanel TotalPanel = new JPanel();
		add(TotalPanel);
		
		JLabel A = new JLabel("Calculating...");
		TotalPanel.add(A);
		
		setVisible ( true );
		
	}
	
}
