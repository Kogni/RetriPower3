package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.event.*;
import GUI.*;
import Standalone.*;

public class Panel_GearLibrary extends JPanel implements ActionListener, ItemListener {

	private static final long	serialVersionUID		= 1L;

	private GUI_Controller				Class_Controller;

	private JPanel						TotalPanel;
	JPanel						LeftPanel1;
	JPanel						RightPanel1;
	JPanel						OptionsPanel;
	
	JPanel						CheckBoxPanel;
	JPanel						CheckBox[]						= new JPanel[3];
	public JCheckBox[]					FilterCheckboxes		= new JCheckBox[3];
	
	JPanel						ComboBoxPanel;
	JPanel						ComboBoxen[]					= new JPanel[7];
	public JComboBox[]					FilterComboBoxes		= new JComboBox[6];
	public JComboBox[]					SortingComboBoxes		= new JComboBox[2];

	//JPanel						RightPanel;
	JScrollPane					GearPanelScrollPanel			= new JScrollPane ( );
	JTable						GearTable						= new JTable ( );
	DefaultTableModel			GearTableModel;
	Vector						GearCollumnNames;
	Vector						GearListTableContent;

	//JPanel						BottomPanel;
	JTabbedPane					DropSpotTabbedPanel;
	//Drop spot table
	JPanel						DropSpotUpgradePanel[]	= new JPanel[5];
	JScrollPane					DropSpotUpgradeScrollPane[] = new JScrollPane[5];
	JTable						DropSpotUpgradeTable[] = new JTable[5];
	DefaultTableModel			DropSpotUpgradeTableModel[] = new DefaultTableModel[5];
	Vector						DropSpotUpgrade_TableCollumnNames[] = new Vector[5];
	Vector						DropSpotUpgrade_TableContent[] = new Vector[5];

	JPanel						DropSpotTree;

	boolean						Ready					= false;
	
	Border						HightlightBorder;

	public Panel_GearLibrary (GUI_Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );
		this.GearListTableContent = new Vector ( );
		this.GearCollumnNames = new Vector ( );
		this.GearTableModel = new DefaultTableModel ( );
		
		Startup();
		System.out.println ("panel gearlibrary ferdig loadet");
	}

	public void Startup ( ) {
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " started" );
		setSize ( 1150, 800 );
		
		HightlightBorder = BorderFactory.createLineBorder ( new Color ( 0, 0, 0 ), 5 );
		
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.LINE_AXIS ) );

		this.TotalPanel = new JPanel ( );
		this.add ( TotalPanel );
		//this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.LeftPanel1 = new JPanel ( );
		this.LeftPanel1.setLayout ( new BoxLayout ( this.LeftPanel1, BoxLayout.PAGE_AXIS ) );
		this.LeftPanel1.setMaximumSize ( new Dimension ( 250, 760 ) );
		//this.LeftPanel1.setBorder ( HightlightBorder );
		this.TotalPanel.add ( this.LeftPanel1 );

		this.RightPanel1 = new JPanel ( );
		this.RightPanel1.setLayout ( new BoxLayout ( this.RightPanel1, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.add ( this.RightPanel1 );

		this.OptionsPanel = new JPanel ( );
		this.OptionsPanel.setLayout ( new BoxLayout ( this.OptionsPanel, BoxLayout.PAGE_AXIS ) );
		this.OptionsPanel.setMaximumSize ( new Dimension ( 250, 400 ) );
		this.LeftPanel1.add ( this.OptionsPanel );

		this.DropSpotTree = new JPanel ( );
		this.DropSpotTree.setLayout ( new BoxLayout ( this.DropSpotTree, BoxLayout.PAGE_AXIS ) );
		this.DropSpotTree.add ( this.Class_Controller.Get_Panel_DropSpotTree_Library() );
		/*
		Dimension minimumSize = new Dimension ( 50, 150 );
		Class_Controller.Class_Panel_DropSpotTree_Library.TotalPanel.setMinimumSize ( minimumSize );
		Class_Controller.Class_Panel_DropSpotTree_Library.TotalPanel.setMinimumSize ( minimumSize );
		Class_Controller.Class_Panel_DropSpotTree_Library.TotalPanel.setPreferredSize ( new Dimension ( 250, 400 ) );
		Class_Controller.Class_Panel_DropSpotTree_Library.TotalPanel.setPreferredSize ( new Dimension ( 250, 400 ) );
*/
		this.LeftPanel1.add ( this.DropSpotTree );

		int X = 0;

		this.OptionsPanel.add ( new JLabel ( "--- Sorting ---" ) );
		X = 0;
		this.SortingComboBoxes[X] = new JComboBox ( );
		this.SortingComboBoxes[X].addItem ( "Sort by name" );
		this.SortingComboBoxes[X].addItem ( "Sort by slot" );
		this.SortingComboBoxes[X].addItem ( "Sort by F upgrade" );
		this.SortingComboBoxes[X].addItem ( "Sort by XF upgrade" );
		this.SortingComboBoxes[X].addItem ( "Sort by drop spot" );
		for ( int y = 0 ; y <= 0 ; y++ ) {
			if ( this.SortingComboBoxes[y] != null ) {
				this.SortingComboBoxes[y].setMaximumSize ( new Dimension ( 220, 20 ) );
				this.ComboBoxen[y] = new JPanel ( );
				//this.ComboBox[y].setBackground ( new Color ( ( int ) ( 200 ), ( int ) ( 200 ), ( int ) ( 200 ) ) );
				this.ComboBoxen[y].setLayout ( new BoxLayout ( this.ComboBoxen[y], BoxLayout.LINE_AXIS ) );
				this.ComboBoxen[y].add ( this.SortingComboBoxes[y] );
				this.OptionsPanel.add ( this.ComboBoxen[y] );
			}
		}
		this.OptionsPanel.add ( new JLabel ( " " ) );

		this.OptionsPanel.add ( new JLabel ( "--- Filters ---" ) );
		X = 0;
		this.FilterCheckboxes[X] = new JCheckBox ( "Show unavailable items" );
		X++;
		this.FilterCheckboxes[X] = new JCheckBox ( "Show non-plate" );

		for ( int y = 0 ; y <= 2 ; y++ ) {
			if ( this.FilterCheckboxes[y] != null ) {
				this.FilterCheckboxes[y].addActionListener ( this );
				this.FilterCheckboxes[y].setActionCommand ( "Option#" + y );
				this.CheckBox[y] = new JPanel ( );
				this.CheckBox[y].setLayout ( new BoxLayout ( this.CheckBox[y], BoxLayout.LINE_AXIS ) );
				this.CheckBox[y].add ( this.FilterCheckboxes[y] );
				this.OptionsPanel.add ( this.CheckBox[y] );
			}
		}

		X = 0;
		this.FilterComboBoxes[X] = new JComboBox ( );
		this.FilterComboBoxes[X].addItem ( "Dont show equipped" );
		this.FilterComboBoxes[X].addItem ( "Show only equipped" );
		this.FilterComboBoxes[X].addItem ( "Show all" );
		X++;
		this.FilterComboBoxes[X] = new JComboBox ( );
		this.FilterComboBoxes[X].addItem ( "Show anything" );
		this.FilterComboBoxes[X].addItem ( "Show all upgrades" );

		X++;
		this.FilterComboBoxes[X] = new JComboBox ( );
		this.FilterComboBoxes[X].addItem ( "Show all slots" );
		String[] GearSlots = Class_Controller.Get_GearSlots ( );
		if ( GearSlots != null ){
			for ( int y = 0 ; y < GearSlots.length ; y++ ) {
				this.FilterComboBoxes[X].addItem ( "Only " + GearSlots[y] );
			}
		}
		X++;
		this.FilterComboBoxes[X] = new JComboBox ( );
		this.FilterComboBoxes[X].addItem ( "Show all binds" );
		this.FilterComboBoxes[X].addItem ( "Only BoE" );
		this.FilterComboBoxes[X].addItem ( "Only BoP" );
		X++;
		this.FilterComboBoxes[X] = new JComboBox ( );
		this.FilterComboBoxes[X].addItem ( "Show any sockets" );
		this.FilterComboBoxes[X].addItem ( "No sockets only" );
		this.FilterComboBoxes[X].addItem ( "Meta sockets only" );
		this.FilterComboBoxes[X].addItem ( "Normal sockets only" );
		this.FilterComboBoxes[X].addItem ( "Red sockets only" );
		this.FilterComboBoxes[X].addItem ( "Blue sockets only" );
		this.FilterComboBoxes[X].addItem ( "Yellow sockets only" );

		for ( int y = 0 ; y <= 5 ; y++ ) {
			if ( this.FilterComboBoxes[y] != null ) {
				this.FilterComboBoxes[y].setMaximumSize ( new Dimension ( 250, 20 ) );
				//this.FilterComboBoxes[y].setBackground ( new Color ( ( int ) ( 200 ), ( int ) ( 200 ), ( int ) ( 200 ) ) );
				this.ComboBoxen[y] = new JPanel ( );
				this.ComboBoxen[y].setLayout ( new BoxLayout ( this.ComboBoxen[y], BoxLayout.LINE_AXIS ) );
				//this.ComboBox[y].setBackground ( new Color ( ( int ) ( 200 ), ( int ) ( 200 ), ( int ) ( 200 ) ) );
				this.ComboBoxen[y].add ( this.FilterComboBoxes[y] );
				this.OptionsPanel.add ( this.ComboBoxen[y] );
			}
		}

		this.GearCollumnNames.addElement ( "Item" );
		this.GearCollumnNames.addElement ( "Gear type" );
		this.GearCollumnNames.addElement ( "Equipped" );
		this.GearCollumnNames.addElement ( "BoP" );
		this.GearCollumnNames.addElement ( "Sockets" );
		this.GearCollumnNames.addElement ( "Anti avoid" );
		this.GearCollumnNames.addElement ( "Upgrade F" );
		this.GearCollumnNames.addElement ( "Upgrade XF" );
		this.GearCollumnNames.addElement ( "Drop spot" );
		this.GearTableModel.setDataVector ( this.GearListTableContent, this.GearCollumnNames );
		this.GearTable = new JTable ( this.GearTableModel );

		TableColumn column;
		column = this.GearTable.getColumnModel ( ).getColumn ( 0 ); //name
		column.setMinWidth ( 100 );
		column.setMaxWidth ( 300 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 1 ); //slot
		column.setMaxWidth ( 70 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 2 ); //equip
		column.setMaxWidth ( 60 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 3 ); //BoP
		column.setMaxWidth ( 40 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 4 ); //sockets
		column.setMaxWidth ( 60 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 5 ); //anti avoid
		column.setMaxWidth ( 60 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 6 ); //upgrade
		column.setMinWidth ( 50 );
		column.setMaxWidth ( 120 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 7 ); //upgrade
		column.setMinWidth ( 50 );
		column.setMaxWidth ( 120 );
		column = this.GearTable.getColumnModel ( ).getColumn ( 8 ); //drop spot
		column.setMinWidth ( 100 );
		column.setMaxWidth ( 170 );

		this.GearPanelScrollPanel = new JScrollPane ( this.GearTable );
		this.GearPanelScrollPanel.setPreferredSize ( new Dimension ( 900, 750 ) );
		this.RightPanel1.add ( this.GearPanelScrollPanel );
		this.RightPanel1.setPreferredSize ( new Dimension ( 900, 750 ) );

		for ( int y = 1 ; y < 5 ; y++ ) {
				this.DropSpotUpgradePanel[y] = new JPanel ( );
				this.DropSpotUpgrade_TableContent[y] = new Vector ( );
				this.DropSpotUpgrade_TableCollumnNames[y] = new Vector ( );
				this.DropSpotUpgradeTableModel[y] = new DefaultTableModel ( );
				this.DropSpotUpgrade_TableCollumnNames[y].addElement ( "Drop spot" );
				this.DropSpotUpgrade_TableCollumnNames[y].addElement ( "Total available upgrade" );
				this.DropSpotUpgradeTableModel[y].setDataVector ( this.DropSpotUpgrade_TableContent[y], this.DropSpotUpgrade_TableCollumnNames[y] );
				this.DropSpotUpgradeTable[y] = new JTable ( this.DropSpotUpgradeTableModel[y] );
				this.DropSpotUpgradeScrollPane[y] = new JScrollPane ( this.DropSpotUpgradeTable[y] );
				this.DropSpotUpgradeScrollPane[y].setPreferredSize ( new Dimension ( 600, 200 ) );
				this.DropSpotUpgradePanel[y].add ( this.DropSpotUpgradeScrollPane[y] );
				//this.RightPanel1.add ( this.DropSpotUpgradePanel );
				
				column = this.DropSpotUpgradeTable[y].getColumnModel ( ).getColumn ( 0 );
				column.setPreferredWidth ( 130 ); //name
				column = this.DropSpotUpgradeTable[y].getColumnModel ( ).getColumn ( 1 );
				column.setPreferredWidth ( 15 ); //socket
		}
		
		DropSpotTabbedPanel = new JTabbedPane ( );
		DropSpotTabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.DropSpotTabbedPanel.addTab ( "Overall", this.DropSpotUpgradePanel[1] );
		this.DropSpotTabbedPanel.addTab ( "Raid", this.DropSpotUpgradePanel[2] );
		this.DropSpotTabbedPanel.addTab ( "Instance", this.DropSpotUpgradePanel[3] );
		this.DropSpotTabbedPanel.addTab ( "Faction", this.DropSpotUpgradePanel[4] );
		//this.DropSpotTabbedPanel.addTab ( "Instances", this.Class_Controller.Panel_GemLibraryLink.TotalPanel );
		RightPanel1.add(DropSpotTabbedPanel);



		//pane.add ( this.TotalPanel, c );

		this.Ready = true;
	}

	public void AddListeners ( ) {
		for ( int y = 0 ; y < this.FilterComboBoxes.length ; y++ ) {
			if ( this.FilterComboBoxes[y] != null ) {
				this.FilterComboBoxes[y].addItemListener ( this );
			}
		}
		for ( int y = 0 ; y < this.SortingComboBoxes.length ; y++ ) {
			if ( this.SortingComboBoxes[y] != null ) {
				this.SortingComboBoxes[y].addItemListener ( this );
			}
		}
	}

	public void VisVindu ( ) {
		setVisible ( true );
		FyllLabels ( "Controller UpdateAllGUI" );
	}

	public void FyllLabels ( String Source ) {
		if ( this.Ready == true ) {
			this.GearListTableContent.removeAllElements ( );
			Interface_Gear[] Gearlist = Class_Controller.Get_FilteredGearlist();
			//System.out.println ( "Hentet arrayen "+Gearlist );
			Interface_Dropspot ItemDropSpot;
			for ( int y = 0 ; y < Gearlist.length ; y++ ) {
				//System.out.println ( y+"="+Gearlist[y]);
				if ( Gearlist[y] != null ) {
					//System.out.println ( "Fyller table, rad#"+y);
					Vector Temp = new Vector ( );

					Temp.addElement ( Gearlist[y].Get_Name ( ) );

					Temp.addElement ( Gearlist[y].Get_Slot ( ) );
/*
					if ( Gearlist[y].GetEquipped ( ).equals ( "" ) == false ) {
						Temp.addElement ( "Yes" );
					} else {
						Temp.addElement ( "No" );
					}
					*/
					Temp.addElement ( "?" );

					if ( Gearlist[y].Get_BoP().equals ( "Binds when picked up" ) ) {
						Temp.addElement ( "BoP" );
					} else {
						Temp.addElement ( "BoE" );
					}

					String Sockets = "";
					if ( Gearlist[y].getClass ( ).equals ( "Metable_Helmet" )){
						if ( ((Interface_Gear)Gearlist[y]).Get_Meta ( ) != null ) {
							Sockets = "M ";
						}
					}
					try {
						int Normal = 0;
						int Red = 0;
						int Blue = 0;
						int Yellow = 0;
						for ( int X = 0 ; X < ((Interface_Gear) Gearlist[y]).Get_Sockets().length; X++){
							if ( (( ( Interface_Gear ) Gearlist[y] ).Get_Sockets()[X]).equals ( "Red" ) ) {
								Red++;
							} else if ( (( ( Interface_Gear ) Gearlist[y] ).Get_Sockets()[X]).equals ( "Blue" ) ) {
								Blue++;
							} else if ( (( ( Interface_Gear ) Gearlist[y] ).Get_Sockets()[X]).equals ( "Yellow" ) ) {
								Yellow++;
							}
						}

						if ( Red > 0 ) {
							Sockets = Sockets + Red + "R ";
						}
						if ( Blue > 0 ) {
							Sockets = Sockets + Blue + "B ";
						}
						if ( Yellow > 0 ) {
							Sockets = Sockets + Yellow + "Y ";
						}
					} catch (Exception e ){
						
					}
					Temp.addElement ( Sockets );
					
					boolean Expertise = false;
					boolean Hit = false;
					try {
						if ( ((Interface_Gear)Gearlist[y]).Get_Statset ( ).GetStatamount ( "Expert. rating" ) > 0){
							Expertise = true;
						}
						if ( ((Interface_Gear)Gearlist[y]).Get_Statset ( ).GetStatamount ( "Hit rating" ) > 0){
							Hit = true;
						}
					} catch (Exception e ){
						
					}
					String AntiAvoid = "";
					if ( Expertise == true ){
						AntiAvoid = "Exp";
					}
					if ( Hit == true ){
						AntiAvoid = AntiAvoid + " Hit";
					}
					Temp.addElement ( AntiAvoid );

					String Upgrade1;
					Upgrade1 = Gearlist[y].GetUpgrades_Fast ( )[1] + "%";
					if ( Gearlist[y].GetUpgrades_Fast ( )[2] != -999 ) {
						Upgrade1 = Upgrade1 + " | " + Gearlist[y].GetUpgrades_Fast ( )[2] + "%";
					}
					if ( Gearlist[y].GetUpgrades_Fast ( )[3] != -999 ) {
						Upgrade1 = Upgrade1 + " | " + Gearlist[y].GetUpgrades_Fast ( )[3] + "%";
					}
					Temp.addElement ( Upgrade1 );
					
					String Upgrade2;
					Upgrade2 = Gearlist[y].GetUpgrades_Slow ( )[1] + "%";
					if ( Gearlist[y].GetUpgrades_Slow ( )[2] != -999 ) {
						Upgrade2 = Upgrade2 + " | " + Gearlist[y].GetUpgrades_Slow ( )[2] + "%";
					}
					if ( Gearlist[y].GetUpgrades_Slow ( )[3] != -999 ) {
						Upgrade2 = Upgrade2 + " | " + Gearlist[y].GetUpgrades_Slow ( )[3] + "%";
					}
					Temp.addElement ( Upgrade2 );

					ItemDropSpot = this.Class_Controller.Get_DropSpotFromID ( Gearlist[y].GetDropspotID ( ) );
					String DropSpot = ItemDropSpot.Get_DropSpotType() + " - ";
					if ( ItemDropSpot.Get_Difficulty( ).equals ( "" ) == false ){
						//DropSpot = DropSpot + ItemDropSpot.Difficulty + " ";
					}
					if ( ItemDropSpot.Get_Difficulty( ).equals ( "Normal" ) ){
						DropSpot = DropSpot + " No ";
					}
					if ( ItemDropSpot.Get_Difficulty( ).equals ( "Heroic" ) ){
						DropSpot = DropSpot + " HC ";
					}
					if ( ItemDropSpot.Get_Instance( ).equals ( "" ) == false ){
						DropSpot = DropSpot + ItemDropSpot.Get_Instance( ) + " : ";
					}

					DropSpot = DropSpot + ItemDropSpot.Get_Name( );
					
					Temp.addElement (DropSpot);

					this.GearListTableContent.addElement ( Temp );
				}
			}
			this.GearTableModel.fireTableDataChanged ( );
			UpdateDropSpotUpgradeTabel ( );

		}
	}

	public void itemStateChanged ( ItemEvent e ) {

		for ( int y = 0 ; y < this.FilterComboBoxes.length ; y++ ) {
			if ( this.FilterComboBoxes[y] != null ) {
				if ( e.getSource ( ) == this.FilterComboBoxes[y] ) {
					Class_Controller.Set_ComboBoxFilters( y, FilterComboBoxes[y].getSelectedItem().toString() );
					//this.Class_Controller.Class_Model_Gear.ComboBoxFilters[y] = this.FilterComboBoxes[y].getSelectedItem ( ).toString ( );
					FyllLabels ( "Changed library filters" );
				}
			}
		}
		for ( int y = 0 ; y < this.SortingComboBoxes.length ; y++ ) {
			if ( this.SortingComboBoxes[y] != null ) {
				if ( e.getSource ( ) == this.SortingComboBoxes[y] ) {
					Class_Controller.Set_ComboBoxSorting( y, SortingComboBoxes[y].getSelectedItem ( ).toString ( ) );
					//this.Class_Controller.Class_Model_Gear.ComboBoxSorting[y] = this.SortingComboBoxes[y].getSelectedItem ( ).toString ( );
					FyllLabels ( "Changed library filters" );
				}
			}
		}
	}

	public void actionPerformed ( ActionEvent e ) {

		for ( int y = 0 ; y < this.FilterCheckboxes.length ; y++ ) {
			if ( e.getActionCommand ( ).equals ( "Option#" + y ) ) {
				Class_Controller.Set_CheckBoxFilters( y, FilterCheckboxes[y].isSelected ( ) );
				//this.Class_Controller.Class_Model_Gear.CheckBoxFilters[y] = this.FilterCheckboxes[y].isSelected ( );
			}
		}
		FyllLabels ( "Changed library filters" );
	}

	private void UpdateDropSpotUpgradeTabel ( ) {
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		
		this.DropSpotUpgrade_TableContent[1].removeAllElements ( );
		
		Interface_Dropspot[] DropSpotList_Upgrade = Class_Controller.Get_DropSpotList_Upgrade();
		for ( int A = 0 ; A < DropSpotList_Upgrade.length ; A++ ) {
			if ( DropSpotList_Upgrade[A] != null ) {
				Vector Temp = new Vector ( );
				String Description = "(" + DropSpotList_Upgrade[A].Get_DropSpotType() + ") " + DropSpotList_Upgrade[A].Get_Instance() +" " + DropSpotList_Upgrade[A].Get_Name() + " " + DropSpotList_Upgrade[A].Get_Difficulty();
				double TotalUpgrade = 0;
				for ( int B = 0 ; B < DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade().length ; B++ ) {
					if ( DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B] > 0 ) {
						TotalUpgrade = TotalUpgrade + DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B];
					}
				}
				TotalUpgrade = (Math.round ( TotalUpgrade * 100 ))/100.0;
				if ( TotalUpgrade > 0 ) {
					Temp.addElement ( Description );
					Temp.addElement ( TotalUpgrade );
					this.DropSpotUpgrade_TableContent[1].addElement ( Temp );
				}
			}
		}
		this.DropSpotUpgradeTableModel[1].fireTableDataChanged ( );
		
		this.DropSpotUpgrade_TableContent[2].removeAllElements ( );
		for ( int A = 0 ; A < DropSpotList_Upgrade.length ; A++ ) {
			if ( DropSpotList_Upgrade[A] != null ) {
				if ( DropSpotList_Upgrade[A].Get_DropSpotType().equals ( "Raid" ) ){
						Vector Temp = new Vector ( );
						String Description = "(" + DropSpotList_Upgrade[A].Get_DropSpotType() + ") " + DropSpotList_Upgrade[A].Get_Instance() +" " +DropSpotList_Upgrade[A].Get_Name() + " " + DropSpotList_Upgrade[A].Get_Difficulty();
						double TotalUpgrade = 0;
						for ( int B = 0 ; B < DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade().length ; B++ ) {
							if ( DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B] > 0 ) {
								TotalUpgrade = TotalUpgrade + DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B];
							}
						}
						TotalUpgrade = (Math.round ( TotalUpgrade * 100 ))/100.0;
						if ( TotalUpgrade > 0 ) {
							Temp.addElement ( Description );
							Temp.addElement ( TotalUpgrade );
							this.DropSpotUpgrade_TableContent[2].addElement ( Temp );
					}
				}
			}
		}
		this.DropSpotUpgradeTableModel[2].fireTableDataChanged ( );
		
		this.DropSpotUpgrade_TableContent[3].removeAllElements ( );
		for ( int A = 0 ; A < DropSpotList_Upgrade.length ; A++ ) {
			if ( DropSpotList_Upgrade[A] != null ) {
				if ( DropSpotList_Upgrade[A].Get_Difficulty().equals ( "" ) == false ){
					Vector Temp = new Vector ( );
					String Description = "(" + DropSpotList_Upgrade[A].Get_DropSpotType() + ") " + DropSpotList_Upgrade[A].Get_Instance() +" " +DropSpotList_Upgrade[A].Get_Name() + " " + DropSpotList_Upgrade[A].Get_Difficulty();
					double TotalUpgrade = 0;
					for ( int B = 0 ; B < DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade().length ; B++ ) {
						if ( DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B] > 0 ) {
							TotalUpgrade = TotalUpgrade + DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B];
						} else {
							//System.out.println ( "Negativ upgrade for " + Class_Controller.Class_Model_DropSpots.DropSpotList_Upgrade[A].Instance +" "+Class_Controller.Class_Model_DropSpots.DropSpotList_Upgrade[A].Difficulty+": "+Class_Controller.Class_Model_DropSpots.DropSpotList_Upgrade[A].HighestPossibleUpgrade[B]);
						}
					}
					//System.out.println ( "Upgrades for "+Class_Controller.Class_Model_DropSpots.DropSpotList_Upgrade[A].Instance +" "+Class_Controller.Class_Model_DropSpots.DropSpotList_Upgrade[A].Difficulty + ": "+TotalUpgrade);
					TotalUpgrade = (Math.round ( TotalUpgrade * 100 ))/100.0;
					if ( TotalUpgrade > 0 ) {
						Temp.addElement ( Description );
						Temp.addElement ( TotalUpgrade );
						this.DropSpotUpgrade_TableContent[3].addElement ( Temp );
					}
				}
			}
		}
		this.DropSpotUpgradeTableModel[3].fireTableDataChanged ( );
		
		this.DropSpotUpgrade_TableContent[4].removeAllElements ( );
		for ( int A = 0 ; A < DropSpotList_Upgrade.length ; A++ ) {
			if ( DropSpotList_Upgrade[A] != null ) {
				if ( DropSpotList_Upgrade[A].Get_DropSpotType().equals ( "Faction" ) ){
					Vector Temp = new Vector ( );
					String Description = "(" + DropSpotList_Upgrade[A].Get_DropSpotType() + ") " + DropSpotList_Upgrade[A].Get_Instance() +" " +DropSpotList_Upgrade[A].Get_Name() + " " + DropSpotList_Upgrade[A].Get_Difficulty();
					double TotalUpgrade = 0;
					for ( int B = 0 ; B < DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade().length ; B++ ) {
						if ( DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B] > 0 ) {
							TotalUpgrade = TotalUpgrade + DropSpotList_Upgrade[A].Get_HighestPossibleUpgrade()[B];
						}
					}
					TotalUpgrade = (Math.round ( TotalUpgrade * 100 ))/100.0;
					if ( TotalUpgrade > 0 ) {
						Temp.addElement ( Description );
						Temp.addElement ( TotalUpgrade );
						this.DropSpotUpgrade_TableContent[4].addElement ( Temp );
					}
				}
			}
		}
		this.DropSpotUpgradeTableModel[4].fireTableDataChanged ( );
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
	}
}
