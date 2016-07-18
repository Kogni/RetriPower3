package GUI.Gems;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import GUI.*;
import Standalone.*;

public class Panel_GemLibrary extends JFrame implements ActionListener, ItemListener, FocusListener, ChangeListener, MouseListener {

	private static final long	serialVersionUID			= 1L;

	private GUI_Controller				Class_Controller;

	private JPanel						TotalPanel;

	JPanel						NewGemPanel;
	JPanel[]					NewGem_RowPanel				= new JPanel[8];
	JPanel						NewGem_InfoPanel;
	JPanel[]					NewGem_InfoPanelRow			= new JPanel[6];
	JTextField					NewGem_Name;
	JComboBox					NewGem_SocketType;
	JPanel						NewGem_StatsPanel;
	JPanel[]					NewGem_StatsCollumnPanel	= new JPanel[3];
	JLabel[]					NewGem_TextCollumnItems		= new JLabel[14];
	JTextField[]				NewGem_StatsCollumnItems	= new JTextField[14];
	JButton						NewGem_Save;
	JButton						NewGem_Delete;

	JPanel						OptionsPanel;
	//JPanel[]					CheckBoxPanel				= new JPanel[11];
	//JCheckBox[]					FilterCheckboxes			= new JCheckBox[11];
	JPanel						ComboBoxPanel;
	JComboBox					SortingComboBox;
	JComboBox[]					StandardGemCombo			= new JComboBox[5];
	JButton						AutoSocket;

	JPanel						GemList;
		JScrollPane					GemTableScrollPanel			= new JScrollPane ( );
			JTable						GemTable					= new JTable ( );
				DefaultTableModel			GemTableModel;
					Vector						GemList_TableCollumnNames;
					Vector						GemList_TableContent;

	boolean						Ready						= false;

	public Panel_GemLibrary (GUI_Controller Class_ControllerT) {
		Class_Controller = Class_ControllerT;
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );

		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );

		this.NewGemPanel = new JPanel ( );
		this.NewGemPanel.setLayout ( new BoxLayout ( this.NewGemPanel, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.add ( this.NewGemPanel );

		for ( int y = 0 ; y < this.NewGem_RowPanel.length ; y++ ) {
			this.NewGem_RowPanel[y] = new JPanel ( );
			this.NewGem_RowPanel[y].setLayout ( new BoxLayout ( this.NewGem_RowPanel[y], BoxLayout.PAGE_AXIS ) );
			this.NewGemPanel.add ( this.NewGem_RowPanel[y] );
		}

		this.NewGem_InfoPanel = new JPanel ( );
		this.NewGem_InfoPanel.setLayout ( new BoxLayout ( this.NewGem_InfoPanel, BoxLayout.PAGE_AXIS ) );
		this.NewGemPanel.add ( this.NewGem_InfoPanel );

		for ( int y = 0 ; y < this.NewGem_InfoPanelRow.length ; y++ ) {
			this.NewGem_InfoPanelRow[y] = new JPanel ( );
			this.NewGem_InfoPanelRow[y].setLayout ( new BoxLayout ( this.NewGem_InfoPanelRow[y], BoxLayout.LINE_AXIS ) );
			this.NewGem_RowPanel[1].add ( this.NewGem_InfoPanelRow[y] );
		}
		this.NewGem_InfoPanelRow[1].add ( new JLabel ( "Create new gem: " ) );
		this.NewGem_InfoPanelRow[2].add ( new JLabel ( " " ) );

		this.NewGem_Name = new JTextField ( " " );
		this.NewGem_InfoPanelRow[3].add ( new JLabel ( "Gem name: " ) );
		this.NewGem_InfoPanelRow[3].add ( this.NewGem_Name );

		this.NewGem_SocketType = new JComboBox ( );
		this.NewGem_SocketType.addItem ( "Meta" );
		this.NewGem_SocketType.addItem ( "Red" );
		this.NewGem_SocketType.addItem ( "Orange" );
		this.NewGem_SocketType.addItem ( "Yellow" );
		this.NewGem_SocketType.addItem ( "Green" );
		this.NewGem_SocketType.addItem ( "Blue" );
		this.NewGem_SocketType.addItem ( "Purple" );
		this.NewGem_SocketType.addItem ( "Prismatic" );
		this.NewGem_InfoPanelRow[4].add ( new JLabel ( "Socket type: " ) );
		this.NewGem_InfoPanelRow[4].add ( this.NewGem_SocketType );
		this.NewGem_InfoPanelRow[5].add ( new JLabel ( " " ) );

		this.NewGem_StatsPanel = new JPanel ( );
		this.NewGem_StatsPanel.setLayout ( new GridLayout ( 1, 0 ) );
		this.NewGem_RowPanel[2].add ( this.NewGem_StatsPanel );

		for ( int y = 1 ; y < this.NewGem_StatsCollumnPanel.length ; y++ ) {
			this.NewGem_StatsCollumnPanel[y] = new JPanel ( );
			this.NewGem_StatsCollumnPanel[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.NewGem_StatsPanel.add ( this.NewGem_StatsCollumnPanel[y] );
		}

		for ( int y = 0 ; y < this.NewGem_TextCollumnItems.length ; y++ ) {
			this.NewGem_TextCollumnItems[y] = new JLabel ( "Text " + y );
			this.NewGem_StatsCollumnPanel[1].add ( this.NewGem_TextCollumnItems[y] );
		}
		for ( int y = 0 ; y < this.NewGem_StatsCollumnItems.length ; y++ ) {
			this.NewGem_StatsCollumnItems[y] = new JTextField ( "0" );
			this.NewGem_StatsCollumnPanel[2].add ( this.NewGem_StatsCollumnItems[y] );
		}

		this.NewGem_TextCollumnItems[0].setText ( "Strength: " );
		this.NewGem_TextCollumnItems[1].setText ( "Agility: " );
		this.NewGem_TextCollumnItems[2].setText ( "Stamina: " );
		this.NewGem_TextCollumnItems[3].setText ( "Intellect: " );
		this.NewGem_TextCollumnItems[4].setText ( "Spirit: " );
		this.NewGem_TextCollumnItems[5].setText ( "AP: " );
		this.NewGem_TextCollumnItems[6].setText ( "Spell power: " );
		this.NewGem_TextCollumnItems[7].setText ( "Hit rating: " );
		this.NewGem_TextCollumnItems[8].setText ( "Crit rating: " );
		this.NewGem_TextCollumnItems[9].setText ( "Expert. rating: " );
		this.NewGem_TextCollumnItems[10].setText ( "Haste rating: " );
		this.NewGem_TextCollumnItems[11].setText ( "Penet. rating: " );
		this.NewGem_TextCollumnItems[12].setText ( "Mp5: " );
		this.NewGem_TextCollumnItems[13].setText ( "Weapon dmg: " );

		this.NewGem_Save = new JButton ( "Save gem" );
		this.NewGem_Delete = new JButton ( "Delete gem" );
		this.NewGem_RowPanel[6].add ( new JLabel ( " " ) );
		this.NewGem_RowPanel[6].add ( this.NewGem_Save );
		this.NewGem_RowPanel[6].add ( this.NewGem_Delete );

		//----------------

		this.OptionsPanel = new JPanel ( );
		this.OptionsPanel.setLayout ( new BoxLayout ( this.OptionsPanel, BoxLayout.PAGE_AXIS ) );
		//this.TotalPanel.add ( this.OptionsPanel );
		this.NewGem_RowPanel[7].add ( this.OptionsPanel );

		this.SortingComboBox = new JComboBox ( );
		//this.SortingComboBox.setMaximumSize ( new Dimension ( 200, 20 ) );
		this.SortingComboBox.addItem ( "Name" );
		this.SortingComboBox.addItem ( "Red" );
		this.SortingComboBox.addItem ( "Yellow" );
		this.SortingComboBox.addItem ( "Blue" );
		
		this.StandardGemCombo[1] = new JComboBox ( );
		//this.StandardGemCombo[1].setMaximumSize ( new Dimension ( 200, 20 ) );

		this.StandardGemCombo[2] = new JComboBox ( );
		//this.StandardGemCombo[2].setMaximumSize ( new Dimension ( 200, 20 ) );

		this.StandardGemCombo[3] = new JComboBox ( );
		//this.StandardGemCombo[3].setMaximumSize ( new Dimension ( 200, 20 ) );

		AutoSocket = new JButton("Autosocket unequipped gear");

		this.ComboBoxPanel = new JPanel ( );
		this.ComboBoxPanel.setLayout ( new BoxLayout ( this.ComboBoxPanel, BoxLayout.PAGE_AXIS ) );
		this.ComboBoxPanel.add ( new JLabel ( " Sorting " ) );
		this.ComboBoxPanel.add ( this.SortingComboBox );
		this.ComboBoxPanel.add ( new JLabel ( " " ) );
		this.ComboBoxPanel.add ( new JLabel ( " Auto-socketing " ) );
		this.ComboBoxPanel.add ( new JLabel ( " Red standard: " ) );
		this.ComboBoxPanel.add ( this.StandardGemCombo[1] );
		this.ComboBoxPanel.add ( new JLabel ( " Blue standard: " ) );
		this.ComboBoxPanel.add ( this.StandardGemCombo[2] );
		this.ComboBoxPanel.add ( new JLabel ( " Yellow standard: " ) );
		this.ComboBoxPanel.add ( this.StandardGemCombo[3] );
		this.ComboBoxPanel.add ( this.AutoSocket );

		this.OptionsPanel.add ( this.ComboBoxPanel );

		//----------------
		this.GemList_TableContent = new Vector ( );
		this.GemList_TableCollumnNames = new Vector ( );
		this.GemTableModel = new DefaultTableModel ( );
		this.GemList_TableCollumnNames.addElement ( "Name" );
		this.GemList_TableCollumnNames.addElement ( "Socket" );
		this.GemList_TableCollumnNames.addElement ( "Stats" );
		this.GemList_TableCollumnNames.addElement ( "DPS Gain" );
		this.GemTableModel.setDataVector ( this.GemList_TableContent, this.GemList_TableCollumnNames );
		this.GemTable = new JTable ( this.GemTableModel );
		this.GemTableScrollPanel = new JScrollPane ( this.GemTable );
		this.GemTableScrollPanel.setPreferredSize ( new Dimension ( 600, 300 ) );
		this.TotalPanel.add ( this.GemTableScrollPanel );

		TableColumn column;
		column = this.GemTable.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 130 ); //name
		column = this.GemTable.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 15 ); //socket
		column = this.GemTable.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 150 ); //stats
		column = this.GemTable.getColumnModel ( ).getColumn ( 3 );
		column.setPreferredWidth ( 15 ); //upgrade

		pane.add ( this.TotalPanel, c );
	}

	public void Startup ( ) {
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " started" );
		setSize ( 850, 700 );

		this.Ready = true;
	}

	public void AddListeners ( ) {
		for ( int y = 0 ; y < this.NewGem_StatsCollumnItems.length ; y++ ) {
			this.NewGem_StatsCollumnItems[y].addFocusListener ( this );
		}
		this.NewGem_Save.addActionListener ( this );
		this.NewGem_Delete.addActionListener ( this );
		this.GemTable.addMouseListener ( this );
		this.SortingComboBox.addFocusListener ( this );
		this.SortingComboBox.addItemListener ( this );
		for ( int y = 1 ; y <= 3 ; y++ ) {
			this.StandardGemCombo[y].addFocusListener ( this );
			this.StandardGemCombo[y].addItemListener ( this );
		}
		AutoSocket.addActionListener ( this );
	}

	public void VisVindu ( ) {
		setVisible ( true );
	}

	public void mouseExited ( MouseEvent e ) {
	}

	public void mouseEntered ( MouseEvent e ) {
	}

	public void mouseReleased ( MouseEvent e ) {
	}

	public void mousePressed ( MouseEvent e ) {
	}

	public void mouseClicked ( MouseEvent e ) {
		VisSelectedGem ( );
	}

	public void itemStateChanged ( ItemEvent e ) {
		/*
		if ( e.getSource ( ) == this.SortingComboBox ) {
			FillLabels ( );
		}
		for ( int y = 0 ; y <= 3 ; y++ ) {
			if ( e.getSource ( ) == this.StandardGemCombo[y] ) {
				if ( StandardGemCombo[y].getSelectedItem ( ) != null ){
					ByttStandardGem(y);
					FillLabels ( );
				}
			}
		}
		*/
	}

	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand ( ).equals ( this.NewGem_Save.getText ( ) ) ) {
			LagreGem ( );
		}
		if ( e.getActionCommand ( ).equals ( this.NewGem_Delete.getText ( ) ) ) {
			SlettGem ( );
		}
		if ( e.getSource( ) ==  this.AutoSocket ) {
			this.Class_Controller.Call_AutoSocket ( );
		}
	}

	public void focusLost ( FocusEvent A ) {
		if ( A.getSource ( ) == this.SortingComboBox ) {
			FillLabels ( );
		}
		for ( int y = 0 ; y <= 3 ; y++ ) {
			if ( A.getSource ( ) == this.StandardGemCombo[y] ) {
				if ( StandardGemCombo[y].getSelectedItem ( ) != null ){
					ByttStandardGem(y);
					FillLabels ( );
				}
			}
		}
	}

	public void focusGained ( FocusEvent A ) {
	}

	public void stateChanged ( ChangeEvent e ) {
	}
	
	private void ByttStandardGem( int ColorID ){
		
		Interface_Gem[] RedGems = Class_Controller.Get_GemList_Normal_SortedRedUpgrade();
		Interface_Gem[] BlueGems = Class_Controller.Get_GemList_Normal_SortedBlueUpgrade();
		Interface_Gem[] YellowGems = Class_Controller.Get_GemList_Normal_SortedYellowUpgrade();
		
		if ( ColorID == 1 ){
			for ( int B = 0 ; B < RedGems.length ; B++ ) {
				if ( RedGems[B] != null ){
					if ( StandardGemCombo[ColorID].getSelectedItem ( ).equals ( RedGems[B].Get_Socket() + " : " + RedGems[B].Get_Description() + ". " + RedGems[B].Get_Upgrade() + "% Gain" )){
						Class_Controller.Set_Favorite_Red(RedGems[B], true);
					} else {
						Class_Controller.Set_Favorite_Red(RedGems[B], false);
					}
				}
			}
		} else if ( ColorID == 2 ){
			for ( int B = 0 ; B < BlueGems.length ; B++ ) {
				if ( BlueGems[B] != null ){
					if ( StandardGemCombo[ColorID].getSelectedItem ( ).equals ( BlueGems[B].Get_Socket() + " : " + BlueGems[B].Get_Description() + ". " + BlueGems[B].Get_Upgrade() + "% Gain" )){
						Class_Controller.Set_Favorite_Blue(BlueGems[B], true);
					} else {
						Class_Controller.Set_Favorite_Blue(BlueGems[B], false);
					}
				}
			}
		} else if ( ColorID == 3 ){
			for ( int B = 0 ; B < YellowGems.length ; B++ ) {
				if ( YellowGems[B] != null ){
					if ( StandardGemCombo[ColorID].getSelectedItem ( ).equals ( YellowGems[B].Get_Socket() + " : " + YellowGems[B].Get_Description() + ". " + YellowGems[B].Get_Upgrade() + "% Gain" )){
						Class_Controller.Set_Favorite_Yellow(YellowGems[B], true);
					} else {
						Class_Controller.Set_Favorite_Yellow(YellowGems[B], false);
					}
				}
			}
		}
		this.Class_Controller.Call_LagreGemDatabase ( );
		
	}

	public void FillLabels ( ) {
		if ( this.Ready == true ) {
			//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
			
			StandardGemCombo[1].removeAllItems ( );
			StandardGemCombo[2].removeAllItems ( );
			StandardGemCombo[3].removeAllItems ( );
			
			Interface_Gem[] RedGems = Class_Controller.Get_GemList_Normal_SortedRedUpgrade();
			Interface_Gem[] BlueGems = Class_Controller.Get_GemList_Normal_SortedBlueUpgrade();
			Interface_Gem[] YellowGems = Class_Controller.Get_GemList_Normal_SortedYellowUpgrade();
			
			String Favoritt1 = "";
			for ( int B = 0 ; B < RedGems.length ; B++ ) {
				if ( RedGems[B] != null ){
					StandardGemCombo[1].addItem ( RedGems[B].Get_Socket() + " : " +RedGems[B].Get_Description() + ". " + RedGems[B].Get_Upgrade() + "% Gain" );
					if ( RedGems[B].Get_Favorite_Red() == true ){
						Favoritt1 = RedGems[B].Get_Socket() + " : " + RedGems[B].Get_Description() + ". " + RedGems[B].Get_Upgrade() + "% Gain";
					}
				}
			}
			StandardGemCombo[1].setSelectedItem ( Favoritt1 );
			String Favoritt2 = "";
			for ( int B = 0 ; B < BlueGems.length ; B++ ) {
				if ( BlueGems[B] != null ){
					StandardGemCombo[2].addItem ( BlueGems[B].Get_Socket() + " : " + BlueGems[B].Get_Description() + ". " + BlueGems[B].Get_Upgrade() + "% Gain" );
					if ( BlueGems[B].Get_Favorite_Blue() == true ){
						Favoritt2 = BlueGems[B].Get_Socket() + " : " + BlueGems[B].Get_Description() + ". " + BlueGems[B].Get_Upgrade() + "% Gain";
					}
				}
			}
			StandardGemCombo[2].setSelectedItem ( Favoritt2 );
			String Favoritt3 = "";
			for ( int B = 0 ; B < YellowGems.length ; B++ ) {
				if ( YellowGems[B] != null ){
					StandardGemCombo[3].addItem ( YellowGems[B].Get_Socket() + " : " + YellowGems[B].Get_Description() + ". " + YellowGems[B].Get_Upgrade() + "% Gain" );
					if ( YellowGems[B].Get_Favorite_Yellow() == true ){
						Favoritt3 = YellowGems[B].Get_Socket() + " : " + YellowGems[B].Get_Description() + ". " + YellowGems[B].Get_Upgrade() + "% Gain";
					}
				}
			}
			StandardGemCombo[3].setSelectedItem ( Favoritt3 );
			
			Interface_Gem[] SortedAllUpgrade = Class_Controller.Get_GemList_SortedAllUpgrade();
			Interface_Gem[] SortedAlphabetically = Class_Controller.Get_GemList_Normal_SortedAlphabetically();
			Interface_Gem[] SortedRedUpgrade = Class_Controller.Get_GemList_Normal_SortedRedUpgrade();
			Interface_Gem[] SortedBlueUpgrade = Class_Controller.Get_GemList_Normal_SortedBlueUpgrade();
			Interface_Gem[] SortedYellowUpgrade = Class_Controller.Get_GemList_Normal_SortedYellowUpgrade();
			
			this.GemList_TableContent.removeAllElements ( );
			for ( int y = 1 ; y < SortedAllUpgrade.length ; y++ ) {
				Interface_Gem ProcessGem = SortedAllUpgrade[y];
				if ( this.SortingComboBox.getSelectedItem ( ).toString ( ).equals ( "Name" ) ) {
					ProcessGem = SortedAlphabetically[y];
				}
				if ( this.SortingComboBox.getSelectedItem ( ).toString ( ).equals ( "Red" ) ) {
					ProcessGem = SortedRedUpgrade[y];
				}
				if ( this.SortingComboBox.getSelectedItem ( ).toString ( ).equals ( "Blue" ) ) {
					ProcessGem = SortedBlueUpgrade[y];
				}
				if ( this.SortingComboBox.getSelectedItem ( ).toString ( ).equals ( "Yellow" ) ) {
					ProcessGem = SortedYellowUpgrade[y];
				}
				if ( ProcessGem != null ) {
					Vector Temp = new Vector ( );
					Temp.addElement ( ProcessGem.Get_GemName() );
					Temp.addElement ( ProcessGem.Get_Socket() );
					Temp.addElement ( ProcessGem.Get_Description() );
					Temp.addElement ( ProcessGem.Get_Upgrade() );

					this.GemList_TableContent.addElement ( Temp );
				}
			}
			Interface_Gem[] MetaSortedUpgrade = Class_Controller.Get_MetaGemList();
			Interface_Gem[] MetaSortedAlphabetically = Class_Controller.Get_GemList_Meta_SortedAlphabetically();
			for ( int y = 1 ; y <= this.Class_Controller.Get_MetaCounter() ; y++ ) {
				Interface_Gem ProcessGem = MetaSortedUpgrade[y];
				if ( this.SortingComboBox.getSelectedItem ( ).toString ( ).equals ( "Name" ) ) {
					ProcessGem = MetaSortedAlphabetically[y];
				}
				if ( ProcessGem != null ) {
					Vector Temp = new Vector ( );
					Temp.addElement ( ProcessGem.Get_GemName() );
					Temp.addElement ( ProcessGem.Get_Socket() );
					//Interface_Buff Metabuff = Class_Controller.Get_FindComparisonItemBuff ( ProcessGem.Get_GemName() );
					//Temp.addElement ( ProcessGem.Get_Description() + Metabuff.Get_Description() );
					Temp.addElement ( ProcessGem.Get_Description() );
					Temp.addElement ( ProcessGem.Get_Upgrade() );

					this.GemList_TableContent.addElement ( Temp );
				}
			}
		}
		this.GemTableModel.fireTableDataChanged ( );
	}

	public void VisSelectedGem ( ) {
		
		if ( this.GemTable.getSelectedRow ( ) > -1 ) {
			Interface_Gem SelectedGem;
			Interface_Gem[] NormalGemList = Class_Controller.Get_NormalGemList();
			for ( int y = 0 ; y < NormalGemList.length ; y++ ) {
				if ( NormalGemList[y] != null ) {
					if ( NormalGemList[y].Get_GemName().equals ( this.GemTableModel.getValueAt ( this.GemTable.getSelectedRow ( ), 0 ) ) ) {
						SelectedGem = NormalGemList[y];

						this.NewGem_Name.setText ( SelectedGem.Get_GemName() );
						this.NewGem_SocketType.setSelectedItem ( SelectedGem.Get_Socket() );
						this.NewGem_StatsCollumnItems[0].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Strength" ) + "" );
						this.NewGem_StatsCollumnItems[1].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Agility" ) + "" );
						this.NewGem_StatsCollumnItems[2].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Stamina" ) + "" );
						this.NewGem_StatsCollumnItems[3].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Intellect" ) + "" );
						this.NewGem_StatsCollumnItems[4].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Spirit" ) + "" );
						this.NewGem_StatsCollumnItems[5].setText ( SelectedGem.Get_GemStats().GetStatamount ( "AP" ) + "" );
						this.NewGem_StatsCollumnItems[6].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Spelldmg" ) + "" );
						this.NewGem_StatsCollumnItems[7].setText ( SelectedGem.Get_GemStats().GetStatamount ( "HitRating" ) + "" );
						this.NewGem_StatsCollumnItems[8].setText ( SelectedGem.Get_GemStats().GetStatamount ( "CritRating" ) + "" );
						this.NewGem_StatsCollumnItems[9].setText ( SelectedGem.Get_GemStats().GetStatamount ( "ExpertiseRating" ) + "" );
						this.NewGem_StatsCollumnItems[10].setText ( SelectedGem.Get_GemStats().GetStatamount ( "HasteRating" ) + "" );
						this.NewGem_StatsCollumnItems[11].setText ( SelectedGem.Get_GemStats().GetStatamount ( "PenetrationRating" ) + "" );
						this.NewGem_StatsCollumnItems[12].setText ( SelectedGem.Get_GemStats().GetStatamount ( "MP5" ) + "" );
						this.NewGem_StatsCollumnItems[13].setText ( SelectedGem.Get_GemStats().GetStatamount ( "MinDmg" ) + "" );
					}
				}
			}
			Interface_Gem[] MetaGemList = Class_Controller.Get_MetaGemList();
			for ( int y = 0 ; y < MetaGemList.length ; y++ ) {
				if ( MetaGemList[y] != null ) {
					if ( MetaGemList[y].Get_GemName().equals ( this.GemTableModel.getValueAt ( this.GemTable.getSelectedRow ( ), 0 ) ) ) {
						SelectedGem = MetaGemList[y];

						this.NewGem_Name.setText ( SelectedGem.Get_GemName() );
						this.NewGem_SocketType.setSelectedItem ( SelectedGem.Get_Socket() );
						this.NewGem_StatsCollumnItems[0].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Strength" ) + "" );
						this.NewGem_StatsCollumnItems[1].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Agility" ) + "" );
						this.NewGem_StatsCollumnItems[2].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Stamina" ) + "" );
						this.NewGem_StatsCollumnItems[3].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Intellect" ) + "" );
						this.NewGem_StatsCollumnItems[4].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Spirit" ) + "" );
						this.NewGem_StatsCollumnItems[5].setText ( SelectedGem.Get_GemStats().GetStatamount ( "AP" ) + "" );
						this.NewGem_StatsCollumnItems[6].setText ( SelectedGem.Get_GemStats().GetStatamount ( "Spelldmg" ) + "" );
						this.NewGem_StatsCollumnItems[7].setText ( SelectedGem.Get_GemStats().GetStatamount ( "HitRating" ) + "" );
						this.NewGem_StatsCollumnItems[8].setText ( SelectedGem.Get_GemStats().GetStatamount ( "CritRating" ) + "" );
						this.NewGem_StatsCollumnItems[9].setText ( SelectedGem.Get_GemStats().GetStatamount ( "ExpertiseRating" ) + "" );
						this.NewGem_StatsCollumnItems[10].setText ( SelectedGem.Get_GemStats().GetStatamount ( "HasteRating" ) + "" );
						this.NewGem_StatsCollumnItems[11].setText ( SelectedGem.Get_GemStats().GetStatamount ( "PenetrationRating" ) + "" );
						this.NewGem_StatsCollumnItems[12].setText ( SelectedGem.Get_GemStats().GetStatamount ( "MP5" ) + "" );
						this.NewGem_StatsCollumnItems[13].setText ( SelectedGem.Get_GemStats().GetStatamount ( "MinDmg" ) + "" );
					}
				}
			}
		}
	}

	public void LagreGem ( ) {
		
		Class_Controller.UserCommand_SaveGem();
		/*
		int Strength = Integer.parseInt ( this.NewGem_StatsCollumnItems[0].getText ( ) );
		int AP = Integer.parseInt ( this.NewGem_StatsCollumnItems[5].getText ( ) );
		int Stamina = Integer.parseInt ( this.NewGem_StatsCollumnItems[2].getText ( ) );
		int Intellect = Integer.parseInt ( this.NewGem_StatsCollumnItems[3].getText ( ) );
		int Agility = Integer.parseInt ( this.NewGem_StatsCollumnItems[1].getText ( ) );
		int Spirit = Integer.parseInt ( this.NewGem_StatsCollumnItems[4].getText ( ) );
		int CritRating = Integer.parseInt ( this.NewGem_StatsCollumnItems[8].getText ( ) );
		int HitRating = Integer.parseInt ( this.NewGem_StatsCollumnItems[7].getText ( ) );
		int HasteRating = Integer.parseInt ( this.NewGem_StatsCollumnItems[10].getText ( ) );
		int ExpertiseRating = Integer.parseInt ( this.NewGem_StatsCollumnItems[9].getText ( ) );
		int Penetration = Integer.parseInt ( this.NewGem_StatsCollumnItems[11].getText ( ) );
		int MP5 = Integer.parseInt ( this.NewGem_StatsCollumnItems[12].getText ( ) );
		int Spelldmg = Integer.parseInt ( this.NewGem_StatsCollumnItems[6].getText ( ) );
		int WpnDmg = Integer.parseInt ( this.NewGem_StatsCollumnItems[13].getText ( ) );
		Object_Stats StatSet = new Object_Stats ( WpnDmg, WpnDmg, 0, 0, Strength, AP, Stamina, Intellect, Agility, CritRating, HitRating, HasteRating, ExpertiseRating, Penetration, MP5, 0, Spelldmg, Spirit, 0, 0, 0 );
		String Name = this.NewGem_Name.getText ( );
		String Socket = this.NewGem_SocketType.getSelectedItem ( ).toString ( );
		int ID;
		if ( Socket.equals ( "Meta" ) ) {
			ID = ( this.Class_Controller.Get_MetaCounter() + 1 );
		} else {
			ID = ( this.Class_Controller.Get_HoeyesteNormalID() + 1 );
		}
		Interface_Gem NewGem = new Object_Gem ( ID, Name, false, Socket, " ", StatSet, null, 0, 0, 0, false, "", "" );

		this.Class_Controller.Call_SaveGem(NewGem);
		this.NewGem_Name.setText ( "" );
		this.NewGem_SocketType.setSelectedIndex ( 0 );
		for ( int y = 0 ; y < this.NewGem_StatsCollumnItems.length ; y++ ) {
			this.NewGem_StatsCollumnItems[y].setText ( "0" );
		}
		*/
		
	}

	private void SlettGem ( ) {
		String Name = this.NewGem_Name.getText ( );
		this.Class_Controller.UserCommand_DeleteGem ( Name );
		this.NewGem_Name.setText ( "" );
		this.NewGem_SocketType.setSelectedIndex ( 0 );
		for ( int y = 0 ; y < this.NewGem_StatsCollumnItems.length ; y++ ) {
			this.NewGem_StatsCollumnItems[y].setText ( "0" );
		}
	}
}
