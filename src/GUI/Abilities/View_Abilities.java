package GUI.Abilities;

import java.awt.*;
import javax.swing.*;
import GUI.*;

public class View_Abilities extends JFrame {
	
	
	GUI_Controller				Class_Controller;
	
	JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	public View_Abilities( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;
		
		Startup();
		
	}

	private void Startup ( ) {

		setSize ( 1000, 750 );
		setResizable ( false );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Abilities" );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		TabbedPanel.addTab ( "Ability rules", this.Class_Controller.Get_Class_Panel_Abilityrules() );
		TotalPanel.add(TabbedPanel);
		
		pane.add ( TotalPanel, c );
		
	}

}
