package GUI.Enchants;

import java.awt.*;
import javax.swing.*;
import GUI.*;

public class View_Enchants extends JFrame {
	
	
	private GUI_Controller				Class_Controller;
	
	JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	public View_Enchants( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;
		

		setSize ( 1200, 820 );
		setResizable ( false );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Enchants" );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		//TabbedPanel.addTab ( "Library", this.Class_Controller.class_.TotalPanel );
		TotalPanel.add(TabbedPanel);
		
		pane.add ( TotalPanel, c );
		
	}

}
