package GUI.Character;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;

public class View_Character extends JFrame implements ActionListener, ItemListener {

	private GUI_Controller					Class_Controller;
	
	private JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	
	JPanel						CharPanel;
	JPanel						StatsPanel;

	JPanel						CharLevelPanel;

	JLabel						CharDescr1;

	JPanel						cards				= new JPanel ( );


	Border						BordSeparation;

	public View_Character (GUI_Controller Class_Controller) {
		
		super ( "Character" );
		this.Class_Controller = Class_Controller;
		Startup();
		
	}

	public void VisVindu ( ) {
		
		setVisible ( true );
		setResizable ( false );
		
	}

	public void Startup ( ) {

		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		setSize ( 500, 700 );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		StatsPanel = new JPanel ( );
		StatsPanel.setLayout ( new BoxLayout ( StatsPanel, BoxLayout.LINE_AXIS ) );
		StatsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		CharPanel = new JPanel ( );
		CharPanel.setLayout ( new BoxLayout ( CharPanel, BoxLayout.LINE_AXIS ) );
		CharPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TabbedPanel.addTab ( "Char info", this.CharPanel );
		this.TabbedPanel.addTab ( "Stats", this.StatsPanel );
		TotalPanel.add(TabbedPanel);
		
		StatsPanel.add ( this.Class_Controller.Get_Class_Panel_Charstats() );
		CharPanel.add ( this.Class_Controller.Get_Class_Panel_CharInfo() );
		
		pane.add ( TotalPanel, c );
	}

	public void actionPerformed ( ActionEvent arg0 ) {

		// TODO Auto-generated method stub
		
	}

	public void itemStateChanged ( ItemEvent arg0 ) {

		// TODO Auto-generated method stub
		
	}
	
}
