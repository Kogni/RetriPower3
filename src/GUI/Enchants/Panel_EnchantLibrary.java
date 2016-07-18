package GUI.Enchants;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import GUI.*;
import Standalone.*;

public class Panel_EnchantLibrary extends JFrame implements ActionListener, ItemListener {

	private static final long	serialVersionUID		= 1L;

	private GUI_Controller				Class_Controller;

	JPanel						TotalPanel;

	JPanel						LeftHalf;
	JPanel						OptionsPanel;
	JPanel[]					CheckBoxPanel			= new JPanel[11];
	JCheckBox[]					FilterCheckboxes		= new JCheckBox[11];
	JPanel						ComboBoxPanel;
	JComboBox					FilterComboBox;
	JPanel						ButtonPanel;
	JButton						AutoEnchant;

	JPanel						RightHalf;
	JScrollPane					EnchantTableScrollPanel	= new JScrollPane ( );
	JTable						EnchantTable			= new JTable ( );
	DefaultTableModel			EnchantTableModel;
	Vector						EnchantList_TableCollumnNames;
	Vector						EnchantList_TableContent;

	boolean						Ready					= false;

	public Panel_EnchantLibrary (GUI_Controller Class_ControllerT) {
		Class_Controller = Class_ControllerT;
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );

		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.LeftHalf = new JPanel ( );
		this.LeftHalf.setMaximumSize ( new Dimension ( 250, 1000 ) );
		this.LeftHalf.setLayout ( new BoxLayout ( this.LeftHalf, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.add ( this.LeftHalf );

		this.OptionsPanel = new JPanel ( );
		this.OptionsPanel.setLayout ( new BoxLayout ( this.OptionsPanel, BoxLayout.PAGE_AXIS ) );
		this.LeftHalf.add ( this.OptionsPanel );

		int X;
		X = 0;
		this.FilterCheckboxes[X] = new JCheckBox ( "Show downgrades" );
		X++;
		this.FilterCheckboxes[X] = new JCheckBox ( "Ignore level req" );
		X++;
		this.FilterCheckboxes[X] = new JCheckBox ( "Show profession-only" );

		for ( int y = 0 ; y < this.FilterCheckboxes.length ; y++ ) {
			if ( this.FilterCheckboxes[y] != null ) {
				this.FilterCheckboxes[y].addActionListener ( this );
				this.FilterCheckboxes[y].setActionCommand ( "Option#" + y );
				this.CheckBoxPanel[y] = new JPanel ( );
				this.CheckBoxPanel[y].setLayout ( new BoxLayout ( this.CheckBoxPanel[y], BoxLayout.LINE_AXIS ) );
				this.CheckBoxPanel[y].add ( this.FilterCheckboxes[y] );
				this.OptionsPanel.add ( this.CheckBoxPanel[y] );
			}
		}

		this.FilterComboBox = new JComboBox ( );
		this.FilterComboBox.setMaximumSize ( new Dimension ( 200, 20 ) );
		this.ComboBoxPanel = new JPanel ( );
		this.ComboBoxPanel.setLayout ( new BoxLayout ( this.ComboBoxPanel, BoxLayout.LINE_AXIS ) );
		this.ComboBoxPanel.add ( this.FilterComboBox );
		this.OptionsPanel.add ( this.ComboBoxPanel );

		this.ButtonPanel = new JPanel ( );
		this.ButtonPanel.setLayout ( new BoxLayout ( this.ButtonPanel, BoxLayout.LINE_AXIS ) );
		this.OptionsPanel.add ( this.ButtonPanel );

		this.AutoEnchant = new JButton ( "Auto-enchant" );
		this.ButtonPanel.add ( this.AutoEnchant );

		this.EnchantList_TableContent = new Vector ( );
		this.EnchantList_TableCollumnNames = new Vector ( );
		this.EnchantTableModel = new DefaultTableModel ( );
		this.EnchantList_TableCollumnNames.addElement ( "Name" );
		this.EnchantList_TableCollumnNames.addElement ( "Char level req" );
		this.EnchantList_TableCollumnNames.addElement ( "Gear level req" );
		this.EnchantList_TableCollumnNames.addElement ( "Slot" );
		this.EnchantList_TableCollumnNames.addElement ( "Description" );
		this.EnchantList_TableCollumnNames.addElement ( "DPS Gain" );
		//EnchantList_TableCollumnNames.addElement("ID");
		this.EnchantTableModel.setDataVector ( this.EnchantList_TableContent, this.EnchantList_TableCollumnNames );
		this.EnchantTable = new JTable ( this.EnchantTableModel );
		this.EnchantTableScrollPanel = new JScrollPane ( this.EnchantTable );
		this.TotalPanel.add ( this.EnchantTableScrollPanel );

		TableColumn column;
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 120 ); //name
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 8 ); //level req
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 8 ); //level req
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 3 );
		column.setPreferredWidth ( 10 ); //slot
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 4 );
		column.setPreferredWidth ( 150 ); //description
		column = this.EnchantTable.getColumnModel ( ).getColumn ( 5 );
		column.setPreferredWidth ( 5 ); //upgrade

		pane.add ( this.TotalPanel, c );
	}

	public void Startup ( ) {
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " started" );
		setSize ( 900, 400 );

		this.FilterComboBox.addItem ( "Show all" );
		String[] EnchantSlots = Class_Controller.Get_EnchantSlots();
		for ( int y = 0 ; y < EnchantSlots.length ; y++ ) {
			if ( EnchantSlots[y].equals ( "" ) == false ) {
				this.FilterComboBox.addItem ( "Only " + EnchantSlots[y] );
			}
		}

		this.Ready = true;
	}

	public void AddListeners ( ) {
		this.FilterComboBox.addItemListener ( this );
		this.AutoEnchant.addActionListener ( this );
	}

	public void VisVindu ( ) {
		setVisible ( true );
		FillLabels ( );
	}

	public void FillLabels ( ) {
		
		if ( this.Ready == true ) {
			this.Class_Controller.Call_FilterEnchants ( );
			this.EnchantList_TableContent.removeAllElements ( );
			Interface_Enchant[] Enchants = Class_Controller.Get_EnchantList_LibraryFiltered();
			//Interface_Buff[] EnchantBuff = Class_Controller.Get_FindComparisonItemBuff ( EnchantNames );
			for ( int y = 1 ; y < Enchants.length ; y++ ) {
				if ( Enchants[y] != null ) {
					Vector Temp = new Vector ( );
					Temp.addElement ( Enchants[y].Get_Navn ( ) );
					Temp.addElement ( Enchants[y].Get_CharLevelReq() );
					Temp.addElement ( Enchants[y].Get_GearLevelReq[y] );
					Temp.addElement ( Enchants[y].Get_Slot ( ) );
					String BuffDescription = "";
					//Interface_Buff EnchantBuff = Class_Controller.Get_FindComparisonItemBuff ( Enchants[y].Get_Navn ( ) );
					//if ( EnchantBuff != null ) {
					//	BuffDescription = EnchantBuff.Get_Description();
					//}
					Temp.addElement ( Enchants[y].Get_Description() + BuffDescription );
					Temp.addElement ( Enchants[y].Get_Upgrade ( ) );
					this.EnchantList_TableContent.addElement ( Temp );
				}
			}
			this.EnchantTableModel.fireTableDataChanged ( );
		}
		
	}

	public void actionPerformed ( ActionEvent e ) {
		if ( e.getSource ( ).equals ( this.AutoEnchant ) ) {
			System.out.println ( "Auto-enchant trykket" );
			this.Class_Controller.Call_AutoEnchant();
		}
		FillLabels ( );
	}

	public void itemStateChanged ( ItemEvent e ) {
		FillLabels ( );
	}

}
