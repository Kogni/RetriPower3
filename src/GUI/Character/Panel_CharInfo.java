package GUI.Character;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.border.*;
import GUI.*;

public class Panel_CharInfo extends JPanel implements ActionListener, ItemListener, ChangeListener {

	private GUI_Controller				Class_Controller;

	private JPanel						TotalPanel;
		
	JPanel[]					RowLines 				= new JPanel[21];
		JPanel[]				CollumnLines			= new JPanel[3];
		JLabel[]				RowText					= new JLabel[21];
		
		JComboBox				Race					= new JComboBox();
		JComboBox				Prof1					= new JComboBox();
		JComboBox				Prof2					= new JComboBox();

	boolean						Updating;

	public Panel_CharInfo (GUI_Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );
		this.Updating = false;

		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " started" );

		this.TotalPanel = new JPanel ( );
		add ( TotalPanel );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		
		for ( int y = 1 ; y <= 20 ; y++ ) {
			RowLines[y] = new JPanel ( );
			RowLines[y].setLayout ( new GridLayout ( 1, 0 ) );
			//RowText[y] = new JLabel(" ");
			//RowLines[y].add ( RowText[y]);
			TotalPanel.add ( RowLines[y] );
		}
		Dimension Max = new Dimension ( 200, 20 );
		
		RowLines[1].add ( new JLabel("Race: ") );
		RowLines[1].add ( Race );
		Race.addItem ( "Blood Elf" );
		Race.addItem ( "Orc" );
		Race.addItem ( "Tauren" );
		Race.addItem ( "Troll" );
		Race.addItem ( "Undead" );
		
		RowLines[3].add ( new JLabel("Profession #1: ") );
		RowLines[3].add ( Prof1 );
		Prof1.addItem ( "Blacksmithing" );
		Prof1.addItem ( "Leatherworking" );
		Prof1.addItem ( "Jewelcrafting" );
		Prof1.addItem ( "Mining" );
		Prof1.addItem ( "Skinning" );
		Prof1.addItem ( "Enchanting" );
		Prof1.addItem ( "Tailoring" );
		Prof1.addItem ( "Engineering" );
		Prof1.addItem ( "Herbalism" );
		Prof1.addItem ( "Alchemy" );
		
		RowLines[4].add ( new JLabel("Profession #2: ") );
		RowLines[4].add ( Prof2 );
		Prof2.addItem ( "Blacksmithing" );
		Prof2.addItem ( "Leatherworking" );
		Prof2.addItem ( "Jewelcrafting" );
		Prof2.addItem ( "Mining" );
		Prof2.addItem ( "Skinning" );
		Prof2.addItem ( "Enchanting" );
		Prof2.addItem ( "Tailoring" );
		Prof2.addItem ( "Engineering" );
		Prof2.addItem ( "Herbalism" );
		Prof2.addItem ( "Alchemy" );

	}

	public void AddListeners ( ) {


	}

	public void itemStateChanged ( ItemEvent e ) {



	}

	public void actionPerformed ( ActionEvent e ) {

	}

	public void stateChanged ( ChangeEvent e ) {
		

	}
	
}
