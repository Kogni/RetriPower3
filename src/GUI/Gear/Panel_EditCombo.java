package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;

public class Panel_EditCombo extends JPanel implements ActionListener, FocusListener, ItemListener, KeyListener {

	private static final long	serialVersionUID			= 1L;

	private GUI_Controller				Class_Controller;

	private JPanel						TotalPanel;
	
	JPanel						GearComboPanel;
	JComboBox					GearComboList = new JComboBox();
	JButton						LoadCombo = new JButton("Load gear combo");
	JTextField					ComboName = new JTextField("");
	JButton						SaveCombo = new JButton("Save gear combo");
	
	JPanel						GearSelectionPanel;
	JComboBox					GearSlotList;
	JComboBox					PresavedgearList;
	
	JPanel						MiddlePanel;
	JPanel						DifferencePanel;

	JPanel						Difference_NamePanel;
	JPanel						UpgradePanel;
	JPanel						Difference_StatsPanel;
	JLabel[]					Difference_Calculations		= new JLabel[27];
	JLabel[]					Difference_GUI				= new JLabel[27];

	//JLabel						GrindUpgrade;
	//JLabel						RaidUpgrade;
	//JLabel						PVPUpgrade;
	JLabel						HPSupgrade;
	JLabel						Oomupgrade;
	JLabel						Healedupgrade;

	JPanel[]					Middle_LinePanels			= new JPanel[3];

	JPanel[]					Difference_Name_LinePanels	= new JPanel[3];
	JPanel[]					Difference_Stats_LinePanels	= new JPanel[4];

	String[]					GearSlots;
	String[]					PresavedItemNames;
	String[]					Socket_MetaEnabling;
	String[]					Socket_GemColor;

	boolean						Updating					= true;

	String PreviousSelect_GearSlotList, NewSelect_GearSlotList;
	String PreviousSelect_PresavedgearList, NewSelect_PresavedgearList;
	String PreviousSelect_GearComboList, NewSelect_GearComboList;

	Object_Stats				StatsDifference;
	Object_Stats				StatsDifference_Converted;

	String[]					SocketBonusTypes;
	
	Border						Seperator;

	public Panel_EditCombo (GUI_Controller Class_Controller) {
		
		this.Class_Controller = Class_Controller;

		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		Seperator = BorderFactory.createEmptyBorder ( 5, 5, 5, 5 );
		
		this.GearComboPanel = new JPanel();
		GearComboPanel.setBorder ( Seperator );
		GearComboPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		GearComboPanel.setSize ( 550, 30 );
		GearComboPanel.setMinimumSize ( new Dimension ( 550, 30 ));
		GearComboPanel.setMaximumSize (new Dimension ( 550, 30 ));
		
		this.GearSelectionPanel = new JPanel ( );
		GearSelectionPanel.setBorder ( Seperator );
		this.GearSelectionPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		GearSelectionPanel.setSize ( 550, 30 );
		GearSelectionPanel.setMinimumSize ( new Dimension ( 550, 30 ));
		GearSelectionPanel.setMaximumSize (new Dimension ( 550, 30 ));
		
		this.MiddlePanel = new JPanel ( );
		MiddlePanel.setBorder ( Seperator );
		this.MiddlePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.DifferencePanel = new JPanel ( );
		this.DifferencePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		DifferencePanel.setSize ( 150, 620 );
		DifferencePanel.setMinimumSize ( new Dimension ( 150, 620 ));
		DifferencePanel.setMaximumSize (new Dimension ( 150, 620 ));

		this.Difference_NamePanel = new JPanel ( );
		this.Difference_NamePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Difference_StatsPanel = new JPanel ( );
		this.Difference_StatsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		//this.Difference_BuffPanel = new JPanel ( );
		//this.Difference_EndPanel = new JPanel ( );
		//this.Difference_EndPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		for ( int y = 0 ; y < this.Difference_Calculations.length ; y++ ) {
			this.Difference_Calculations[y] = new JLabel ( "" );
		}

		for ( int y = 1 ; y < this.Difference_GUI.length ; y++ ) {
			this.Difference_GUI[y] = new JLabel ( "" );
		}

		this.UpgradePanel = new JPanel ( );
		this.UpgradePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.HPSupgrade = new JLabel ( "" );
		this.HPSupgrade.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.Oomupgrade = new JLabel ( "" );
		this.Oomupgrade.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.Healedupgrade = new JLabel ( "" );
		this.Healedupgrade.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		for ( int y = 1 ; y < this.Difference_Name_LinePanels.length ; y++ ) {
			this.Difference_Name_LinePanels[y] = new JPanel ( );
		}
		for ( int y = 1 ; y < this.Difference_Stats_LinePanels.length ; y++ ) {
			this.Difference_Stats_LinePanels[y] = new JPanel ( );
		}
		for ( int y = 1 ; y < this.Middle_LinePanels.length ; y++ ) {
			this.Middle_LinePanels[y] = new JPanel ( );
			//this.Middle_LinePanels[y].setLayout ( new GridLayout ( 1, 0 ) );
			Middle_LinePanels[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		}

		this.GearSlots = this.Class_Controller.Get_CharSlots();
		if ( GearSlots == null ){
			GearSlots = new String[1];
		}
		this.GearSlotList = new JComboBox ( this.GearSlots );

		this.PresavedItemNames = new String[] {};
		this.PresavedgearList = new JComboBox ( this.PresavedItemNames );

		this.Socket_MetaEnabling = new String[] { "None", "Present" };
		this.Socket_GemColor = new String[] { "None", "Red", "Blue", "Yellow", "Prismatic" };

		this.StatsDifference = new Object_Stats ();
		this.StatsDifference_Converted = new Object_Stats ();
		SetupPanel ( );
	}

	public void SetupPanel ( ) {
		System.out.println ( "Class Panel_GearProcess is set up" );
		this.Updating = true;

		//Container pane = getContentPane ( );
		//pane.setLayout ( new GridLayout ( 1, 1 ) );

		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		
		this.GearComboPanel.setLayout ( new BoxLayout ( this.GearComboPanel, BoxLayout.LINE_AXIS ) );
		this.GearComboPanel.add ( new JLabel ( "Load gear combo: " ) );
		this.GearComboPanel.add ( this.GearComboList );
		this.GearComboPanel.add ( new JLabel ( "Save gear combo: " ) );
		this.GearComboPanel.add ( this.ComboName );
		this.GearComboPanel.add ( this.SaveCombo );
		this.TotalPanel.add ( this.GearComboPanel );
		
		this.GearSelectionPanel.setLayout ( new BoxLayout ( this.GearSelectionPanel, BoxLayout.LINE_AXIS ) );
		this.GearSelectionPanel.add ( new JLabel ( "Gear slot: " ) );
		this.GearSelectionPanel.add ( this.GearSlotList );
		this.GearSelectionPanel.add ( new JLabel ( "Presaved items: " ) );
		this.GearSelectionPanel.add ( this.PresavedgearList );
		this.TotalPanel.add ( this.GearSelectionPanel );
		
		
		
		this.MiddlePanel.setLayout ( new BoxLayout ( this.MiddlePanel, BoxLayout.LINE_AXIS ) );
		//this.MiddlePanel1.setLayout ( new GridLayout ( 1, 0 ) );
		//System.out.println ( "MiddlePanel="+MiddlePanel );
		//System.out.println ( "Class_Controller="+Class_Controller );
		//System.out.println ( "Class_Controller.Get_Panel_EditItem_Current()="+Class_Controller.Get_Panel_EditItem_Current() );
		this.MiddlePanel.add ( this.Class_Controller.Get_Panel_EditItem_Current());
		this.MiddlePanel.add ( this.Class_Controller.Get_Panel_EditItem_Compared());
		this.MiddlePanel.add ( DifferencePanel);
		this.DifferencePanel.setLayout ( new BoxLayout ( this.DifferencePanel, BoxLayout.PAGE_AXIS ) );
		
		this.DifferencePanel.add ( this.Middle_LinePanels[1] );
		this.DifferencePanel.add ( this.Middle_LinePanels[2] );
		//this.DifferencePanel.add ( this.Middle_LinePanels[3] );
		//this.DifferencePanel.add ( this.Middle_LinePanels[4] );

		this.Difference_NamePanel.setLayout ( new BoxLayout ( this.Difference_NamePanel, BoxLayout.LINE_AXIS ) );

		this.Difference_Name_LinePanels[1].add ( new JLabel ( "Line 1" ) );
		this.Difference_Name_LinePanels[2].add ( new JLabel ( "Line 2" ) );
		this.Middle_LinePanels[1].add ( this.Difference_NamePanel );

		this.Difference_NamePanel.add ( this.UpgradePanel );
		//this.UpgradePanel.add ( new JLabel ( " " ) );
		this.UpgradePanel.add ( new JLabel ( "HPS upgrade:" ) );
		this.UpgradePanel.add ( this.HPSupgrade );
		this.UpgradePanel.add ( new JLabel ( "Oom upgrade:" ) );
		this.UpgradePanel.add ( this.Oomupgrade );
		this.UpgradePanel.add ( new JLabel ( "Healed upgrade:" ) );
		this.UpgradePanel.add ( this.Healedupgrade );
		this.UpgradePanel.setLayout ( new GridLayout ( 4, 2 ) );
		this.Difference_StatsPanel.setLayout ( new BoxLayout ( this.Difference_StatsPanel, BoxLayout.LINE_AXIS ) );
		this.Middle_LinePanels[2].add ( this.Difference_StatsPanel );

		this.Difference_StatsPanel.add ( this.Difference_Stats_LinePanels[1] );

		Object_Stats TestStats = new Object_Stats();
		for (int y = 0 ; y < TestStats.GetStatnames ( ).length ; y++ ){
			Difference_Stats_LinePanels[1].add ( new JLabel ( TestStats.GetStatnames ( )[y]+": " ) );
		}

		this.Difference_StatsPanel.add ( this.Difference_Stats_LinePanels[2] );
		//this.Difference_Stats_LinePanels[2].add ( new JLabel ( " " ) );
		//this.Difference_Stats_LinePanels[2].add ( new JLabel ( " " ) );
		for ( int y = 0 ; y < this.Difference_Calculations.length ; y++ ) {
			this.Difference_Stats_LinePanels[2].add ( this.Difference_Calculations[y] );
		}

		this.Difference_StatsPanel.add ( this.Difference_Stats_LinePanels[3] );
		//this.Difference_Stats_LinePanels[3].add ( new JLabel ( " " ) );
		//this.Difference_Stats_LinePanels[3].add ( new JLabel ( " " ) );
		for ( int y = 1 ; y < this.Difference_GUI.length ; y++ ) {
			this.Difference_GUI[y] = new JLabel ( "" );
			this.Difference_Stats_LinePanels[3].add ( this.Difference_GUI[y] );
		}

		//this.Difference_BuffPanel.add ( new JLabel ( " " ) );
		//this.Difference_BuffPanel.setLayout ( new BoxLayout ( this.Difference_BuffPanel, BoxLayout.LINE_AXIS ) );
		//this.Middle_LinePanels[3].add ( this.Difference_BuffPanel );

		//this.Difference_EndPanel.setLayout ( new BoxLayout ( this.Difference_EndPanel, BoxLayout.LINE_AXIS ) );
		//this.Middle_LinePanels[4].add ( this.Difference_EndPanel );

		this.TotalPanel.add ( this.MiddlePanel );

		//this.TotalPanel.setPreferredSize ( new Dimension ( 850, 20 ) );
		//pane.add ( this.TotalPanel );
		add(TotalPanel);

		if ( GearSlotList.getSelectedItem ( ) != null ){
			this.PresavedgearList.setSelectedItem ( "Blank " + this.GearSlotList.getSelectedItem ( ).toString ( ) );
		}

		for ( int y = 1 ; y < this.Difference_Name_LinePanels.length ; y++ ) {
			//this.Difference_Name_LinePanels[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.Difference_Name_LinePanels[y].setLayout ( new BoxLayout ( this.Difference_Name_LinePanels[y], BoxLayout.PAGE_AXIS ) );
		}
		for ( int y = 1 ; y < this.Difference_Stats_LinePanels.length ; y++ ) {
			//this.Difference_Stats_LinePanels[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.Difference_Stats_LinePanels[y].setLayout ( new BoxLayout ( this.Difference_Stats_LinePanels[y], BoxLayout.PAGE_AXIS ) );
			this.Difference_Stats_LinePanels[y].setAlignmentX ( Component.LEFT_ALIGNMENT );
		}

/*
		this.Middle_LinePanels[1].setMaximumSize ( new Dimension ( 1000, 10 ) );
		this.Middle_LinePanels[2].setMaximumSize ( new Dimension ( 1000, 10 ) );

		this.UpgradePanel.setMaximumSize ( new Dimension ( 200, 100 ) );
		this.Difference_Name_LinePanels[1].setMaximumSize ( new Dimension ( 200, 120 ) );
		this.Difference_Name_LinePanels[2].setMaximumSize ( new Dimension ( 200, 120 ) );

		this.Difference_Stats_LinePanels[1].setMaximumSize ( new Dimension ( 100, 500 ) );
		this.Difference_Stats_LinePanels[2].setMaximumSize ( new Dimension ( 50, 500 ) );
		this.Difference_Stats_LinePanels[3].setMaximumSize ( new Dimension ( 50, 500 ) );
*/
		this.Updating = false;
		
		SetActionlisteners();

	}
	
	public void SetActionlisteners(){
		
		GearComboList.addActionListener ( this );
		GearComboList.addItemListener ( this );
		
		SaveCombo.addActionListener ( this );
		
		GearSlotList.addActionListener ( this );
		GearSlotList.addItemListener ( this );
		
		PresavedgearList.addActionListener ( this );
		PresavedgearList.addFocusListener ( this );
		
	}

	public void actionPerformed ( ActionEvent e ) {

		if ( e.getSource ( ) == SaveCombo ){
			this.Class_Controller.Call_SaveGearCombo( ComboName.getText ( ) );
			FillComboList();
		}
		
	}
	
	public void itemStateChanged ( ItemEvent e ) {
		
		if ( this.Updating == false ) {
			
			if ( e.getSource ( ) == this.GearSlotList ) { //Brukeren endrer gear slot
				if ( e.getStateChange ( ) == 1 ) {
					this.NewSelect_GearSlotList = e.getItem ( ) + "";
				}
				if ( e.getStateChange ( ) == 2 ) {
					this.PreviousSelect_GearSlotList = e.getItem ( ) + "";
				}
				if ( this.NewSelect_GearSlotList == null ) {
				} else {
					if ( this.NewSelect_GearSlotList.equals ( this.PreviousSelect_GearSlotList ) ) {
					} else {
						this.Updating = true;
						FillGearList();
						this.Updating = false;
					}
				}
			}
			
			if ( e.getSource ( ) == this.PresavedgearList ) { //Brukeren endrer gear slot
				if ( e.getStateChange ( ) == 1 ) {
					this.NewSelect_PresavedgearList = e.getItem ( ) + "";
				}
				if ( e.getStateChange ( ) == 2 ) {
					this.PreviousSelect_PresavedgearList = e.getItem ( ) + "";
				}
				if ( this.NewSelect_PresavedgearList == null ) {
				} else {
					if ( this.NewSelect_PresavedgearList.equals ( this.PreviousSelect_PresavedgearList ) ) {
					} else {
						this.Updating = true;
						if ( PresavedgearList.getSelectedItem ( ) != null ){
							this.Class_Controller.Call_HentItemTilGearEdit(PresavedgearList.getSelectedItem ( ).toString ( ), GearSlotList.getSelectedItem ( ).toString ( ), true);
						}
						this.Updating = false;
					}
				}
			}
			
			if ( e.getSource ( ) == this.GearComboList ) { //Brukeren endrer gear slot
				if ( e.getStateChange ( ) == 1 ) {
					this.NewSelect_GearComboList = e.getItem ( ) + "";
				}
				if ( e.getStateChange ( ) == 2 ) {
					this.PreviousSelect_GearComboList = e.getItem ( ) + "";
				}
				if ( this.NewSelect_GearComboList == null ) {
				} else {
					if ( this.NewSelect_GearComboList.equals ( this.PreviousSelect_GearComboList ) ) {
					} else {
						this.Updating = true;
						if ( GearComboList.getSelectedItem ( ) != null ){
							this.Class_Controller.Call_HentComboTilComboEdit(GearComboList.getSelectedItem ( ).toString ( ));
						}
						this.Updating = false;
					}
				}
			}
			
		}
	}

	public void focusGained ( FocusEvent arg0 ) {
	}

	public void focusLost ( FocusEvent e ) {
		
		if ( e.getSource ( ) == this.PresavedgearList ) {
			if ( PresavedgearList.getSelectedItem ( ) != null ){
				this.Class_Controller.Call_HentItemTilGearEdit(PresavedgearList.getSelectedItem ( ).toString ( ), GearSlotList.getSelectedItem ( ).toString ( ), true);
			}
		}
		if ( e.getSource ( ) == this.GearComboList ) {
			if ( GearComboList.getSelectedItem ( ) != null ){
				this.Class_Controller.Call_HentComboTilComboEdit(GearComboList.getSelectedItem ( ).toString ( ));
			}
		}
		
	}
	
	public void ShowItemDifference( Object_Stats Difference, double Upgrade ){
		
		//System.out.println("panel gearediting AP forskjell="+Difference.GetStatamount ( "AP" ));
		for ( int y = 0 ; y < Difference.GetStatnames ( ).length ; y++ ) {
			//System.out.println ( "Difference_Calculations[y]="+Difference_Calculations[y]+" Difference.GetStatamounts ( )[y]="+Difference.GetStatamounts ( )[y]);
			double StatDiff = Difference.GetStatamounts ( )[y];
			if ( StatDiff != 0.00 ){
				this.Difference_Calculations[y].setText ( StatDiff+"" );
			} else {
				this.Difference_Calculations[y].setText ( " " );
			}
		}
		this.HPSupgrade.setText ( Upgrade+"%" );
		this.Oomupgrade.setText ( Upgrade+"%" );
		this.Healedupgrade.setText ( Upgrade+"%" );
		
	}

	public void keyPressed ( KeyEvent arg0 ) {
	}

	public void keyReleased ( KeyEvent arg0 ) {
	}

	public void keyTyped ( KeyEvent arg0 ) {
	}
	
	public void FillGearList(){
		
		//System.out.println ("Skal fylle gear liste");
		PresavedgearList.removeAllItems ( );
		Class_Controller.Call_FillGearPanelGearList(GearSlotList.getSelectedItem ( ).toString ( ));
		if (  PresavedgearList.getSelectedItem ( ) != null ){
			Class_Controller.Call_HentItemTilGearEdit(PresavedgearList.getSelectedItem ( ).toString ( ), GearSlotList.getSelectedItem ( ).toString ( ), true);
		}
		
	}
	
	public void FillComboList(){
		
		GearComboList.removeAllItems ( );
		Class_Controller.Call_FillGearComboList();
		
	}
	
	public void AddItemToGearList(String Name){
		PresavedgearList.addItem ( Name );
	}

	public String GetGeartSlot ( ) {

		return this.GearSlotList.getSelectedItem ( ).toString ( );
	}

	public void AddItemToGearComboList ( String comboName ) {
		GearComboList.addItem ( comboName );
	}

	public String GetSelectedCombo ( ) {

		if ( GearComboList.getSelectedItem ( ) != null ){
			return GearComboList.getSelectedItem ( ).toString ( );
		}
		return "";
	}

	public String GetSelectedItem ( ) {
		return PresavedgearList.getSelectedItem ( ).toString ( );
	}

}
