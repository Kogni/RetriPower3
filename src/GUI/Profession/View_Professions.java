package GUI.Profession;

import java.awt.*;
import javax.swing.*;
import GUI.*;

public class View_Professions extends JFrame {
	
	
	private GUI_Controller				Class_Controller;
	
	private JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	public View_Professions( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;


		setSize ( 600, 340 );
		setResizable ( false );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Professions" );

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
