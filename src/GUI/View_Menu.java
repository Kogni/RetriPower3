package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View_Menu extends JFrame implements ActionListener {

	private JButton[] MenyKnapp = new JButton[10];
	GUI_Controller Class_Controller;

	public View_Menu ( GUI_Controller Class_Controller ) {

		super ( "RetriPower WotLK" );
		this.Class_Controller = Class_Controller;

	}

	public void Startup ( ) {

		setSize ( 200, (MenyKnapp.length*40) );
		setResizable ( false );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( this.MenyKnapp.length, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		this.MenyKnapp[0] = new JButton ( "Character setup" );
		this.MenyKnapp[1] = new JButton ( "Stat comparisons" );
		this.MenyKnapp[2] = new JButton ( "Speccing" );
		this.MenyKnapp[3] = new JButton ( "DPS rotations" );
		MenyKnapp[3].setBackground ( new Color(255,0,0) );
		this.MenyKnapp[4] = new JButton ( "Gear" );
		this.MenyKnapp[5] = new JButton ( "Gems" );
		MenyKnapp[5].setBackground ( new Color(255,0,0) );
		this.MenyKnapp[6] = new JButton ( "Enchants" );
		MenyKnapp[6].setBackground ( new Color(255,0,0) );
		this.MenyKnapp[7] = new JButton ( "Professions" );
		MenyKnapp[7].setBackground ( new Color(255,0,0) );
		this.MenyKnapp[8] = new JButton ( "Buff infos" );
		MenyKnapp[8].setBackground ( new Color(255,0,0) );
		this.MenyKnapp[9] = new JButton ( "Ability infos" );
		MenyKnapp[9].setBackground ( new Color(255,0,0) );

		for ( int y = 0 ; y < this.MenyKnapp.length ; y++ ) {
			pane.add ( this.MenyKnapp[y], c );
			this.MenyKnapp[y].addActionListener ( this );
			this.MenyKnapp[y].setActionCommand ( "Vindu#" + y );
		}

		setVisible ( true );
	}

	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand ( ).equals ( "Vindu#0" ) ) {
			this.Class_Controller.UserCommand_OpenCharacter();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#1" ) ) {
			this.Class_Controller.UserCommand_OpenStatComparison();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#2" ) ) {
			this.Class_Controller.UserCommand_OpenSpeccing();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#3" ) ) {
			this.Class_Controller.UserCommand_OpenDPSScreen();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#4" ) ) {
			this.Class_Controller.UserCommand_OpenGearScreen();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#5" ) ) {
			this.Class_Controller.UserCommand_OpenGems();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#6" ) ) {
			this.Class_Controller.UserCommand_OpenEnchants();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#7" ) ) {
			this.Class_Controller.UserCommand_OpenProfessions();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#8" ) ) {
			this.Class_Controller.UserCommand_OpenBuffs();
		} else if ( e.getActionCommand ( ).equals ( "Vindu#9" ) ) {
			this.Class_Controller.UserCommand_OpenAbilities();
		}
	}
}
