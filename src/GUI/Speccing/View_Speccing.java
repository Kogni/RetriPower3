package GUI.Speccing;

import java.awt.*;
import javax.swing.*;
import GUI.*;

public class View_Speccing extends JFrame {
	
	GUI_Controller				Class_Controller;
	
	JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	StatusBar					Statusbaren = new StatusBar();
	
	public View_Speccing( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;
		
		Startup();
		
	}

	private void Startup ( ) {

		setSize ( 500, 760 );
		//setResizable ( false );
		
		//Container pane = getContentPane ( );
		//pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		//GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Speccing" );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		TabbedPanel.addTab ( "Current specc", this.Class_Controller.Get_Class_Panel_CurrentSpecc() );
		TabbedPanel.addTab ( "Specc editing", this.Class_Controller.Get_Class_Panel_TalentEditing() );
		TabbedPanel.addTab ( "Specc listing", this.Class_Controller.Get_Class_Panel_SpeccListing() );
		TotalPanel.add(TabbedPanel);
		
		//pane.add ( TotalPanel, c );
		
		add ( TotalPanel );
		add(Statusbaren, java.awt.BorderLayout.SOUTH);
		
	}

	public void SetStatusText ( String string ) {

		Statusbaren.setMessage ( string );
		
	}

}
