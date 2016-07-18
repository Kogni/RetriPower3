package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;

public class View_Gear extends JFrame {

	private GUI_Controller				Class_Controller;
	
	private JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	StatusBar					Statusbaren = new StatusBar();
	
	public View_Gear(GUI_Controller Class_Controller){
		this.Class_Controller = Class_Controller;
		
		setSize ( 1200, 820 );
		//setResizable ( false );
		
		//Container pane = getContentPane ( );
		//pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		//pane.setLayout ( new BoxLayout ( pane, BoxLayout.LINE_AXIS ) );
		//GridBagConstraints c = new GridBagConstraints ( );
		setTitle ( "Gear" );

		TotalPanel = new JPanel ( );
		this.add(TotalPanel);
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		//TabbedPanel.setLayout ( new BoxLayout ( TabbedPanel, BoxLayout.LINE_AXIS ) );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		TabbedPanel.addTab ( "Library", this.Class_Controller.Get_Panel_GearLibrary() );
		TabbedPanel.addTab ( "Current gear combo", this.Class_Controller.Get_Panel_CurrentCombo() );
		TabbedPanel.addTab ( "Gear combo editing", this.Class_Controller.Get_Panel_EditCombo() );
		TabbedPanel.addTab ( "Gear combo list", this.Class_Controller.Get_Panel_ComboListing() );
		TotalPanel.add(TabbedPanel);
		
		//pane.add ( TotalPanel, c );
		//pane.add ( TotalPanel );
		System.out.println ("view gear ferdig loadet");
	}

	public void SetStatusText ( String string ) {

		Statusbaren.setMessage ( string );
		
	}

}
