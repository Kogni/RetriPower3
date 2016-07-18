package GUI.Gems;

import java.awt.*;
import javax.swing.*;
import GUI.*;

public class View_Gems extends JFrame {
	
	
	private GUI_Controller				Class_Controller;
	
	private JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	public View_Gems( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;

		setSize ( 1200, 820 );
		setResizable ( false );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Gems" );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		//TabbedPanel.addTab ( "Current DPS log", this.Class_Controller.class_p.TotalPanel );
		TotalPanel.add(TabbedPanel);
		
		pane.add ( TotalPanel, c );
		
	}

}
