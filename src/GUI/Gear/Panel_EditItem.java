package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.*;
import Standalone.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Panel_EditItem<E> extends JPanel implements ActionListener {
	
	private GUI_Controller					Class_Controller;
	
	private JPanel[]					Middle_LinePanels			= new JPanel[6];

	private JPanel						TotalPanel;
	
	private JPanel						NamePanel;
	private JLabel						ItemName			= new JLabel("");
	private JLabel						ItemType;
	private JLabel						DropSpot;
	private JTabbedPane					TabPanel;
	private JPanel						StatsPanel;
	private JLabel[]					Stats				= new JLabel[28];
	private JLabel[]					Gear				= new JLabel[28];
	private JLabel[]					Gems				= new JLabel[28];
	private JLabel[]					Total				= new JLabel[28];
	
	private JPanel						GemPanel;
	private JPanel[]					Gems_LinePanels			= new JPanel[22];
	private JLabel[][]					Gems_MetaCounting		= new JLabel[3][4];
	private JLabel						MetaSocket = new JLabel();
	private JLabel						GemMeta_Name = new JLabel();
	private JLabel						GemMeta_Stats = new JLabel();
	private JLabel						Gem1Socket = new JLabel();
	private JLabel						Gem1_Name = new JLabel();
	private JLabel						Gem1_Stats = new JLabel();
	private JLabel						Gem2Socket = new JLabel();
	private JLabel						Gem2_Name = new JLabel();
	private JLabel						Gem2_Stats = new JLabel();
	private JLabel						Gem3Socket = new JLabel();
	private JLabel						Gem3_Name = new JLabel();
	private JLabel						Gem3_Stats = new JLabel();
	private JLabel						SocketBonusAmount = new JLabel();
	private JLabel						SocketBonusType = new JLabel();
	private JLabel						SocketBonusActive = new JLabel();
	
	private JPanel						EndPanel;
	private JPanel						BuffPanel;
	private JLabel						ItemBuff;
	private JLabel						MetaBuff;
	
	private JPanel[]					Name_LinePanels		= new JPanel[3];
	private JPanel[]					Stats_LinePanels	= new JPanel[5];
	private JPanel[]					End_LinePanels		= new JPanel[2];
	
	private JButton						SetAsCurrent;

	private JPanel	ButtonPanel;
	
	private String						Task;
	private Border						Seperator;
	
	public Panel_EditItem(String Task, GUI_Controller Class_Controller){
		
		this.Class_Controller = Class_Controller;
		this.Task = Task;
		
		Seperator = BorderFactory.createEmptyBorder ( 0, 3, 0, 3 );
		
		this.TotalPanel = new JPanel ( );
		this.add(TotalPanel);
		TotalPanel.setBorder ( Seperator );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setSize ( 200, 620 );
		TotalPanel.setMinimumSize ( new Dimension ( 200, 620 ));
		TotalPanel.setMaximumSize (new Dimension ( 200, 620 ));
		
		this.NamePanel = new JPanel ( );
		this.NamePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.NamePanel.setLayout ( new BoxLayout ( this.NamePanel, BoxLayout.LINE_AXIS ) );

		if ( Task.equals ( "Current" )){
			ItemName.setText ( "No item saved in this slot" );
		}
		
		ItemType = new JLabel(" ");
		
		for ( int y = 1 ; y < this.Stats_LinePanels.length ; y++ ) {
			this.Stats_LinePanels[y] = new JPanel ( );
			Stats_LinePanels[y].setLayout ( new BoxLayout ( this.Stats_LinePanels[y], BoxLayout.PAGE_AXIS ) );
		}

		Object_Stats TestStats = new Object_Stats();
		for (int y = 0 ; y < Stats.length-1 ; y++ ){
			if ( TestStats.GetStatnames ( )[y] != null ){
				Stats[y+1] = new JLabel ( TestStats.GetStatnames ( )[y] );
			}
		}
		for ( int y = 1 ; y < this.Gear.length ; y++ ) {
			this.Gear[y] = new JLabel ( "0" );
		}
		for ( int y = 1 ; y < this.Gems.length ; y++ ) {
			this.Gems[y] = new JLabel ( "0" );
		}
		for ( int y = 1 ; y < this.Total.length ; y++ ) {
			this.Total[y] = new JLabel ( "0" );
		}

		this.GemPanel = new JPanel ( );
		this.GemPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.GemPanel.setLayout ( new BoxLayout ( this.GemPanel, BoxLayout.PAGE_AXIS ) );
		
		this.StatsPanel = new JPanel ( );
		this.StatsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.StatsPanel.setLayout ( new BoxLayout ( this.StatsPanel, BoxLayout.LINE_AXIS ) );
		
		this.EndPanel = new JPanel ( );
		this.EndPanel.setLayout ( new BoxLayout ( this.EndPanel, BoxLayout.PAGE_AXIS ) );
		this.EndPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.ItemBuff = new JLabel ( "" );
		this.MetaBuff = new JLabel ( "" );
		
		this.BuffPanel = new JPanel ( );
		this.BuffPanel.setLayout ( new BoxLayout ( this.BuffPanel, BoxLayout.PAGE_AXIS ) );
		
		this.BuffPanel.add ( this.ItemBuff );
		this.BuffPanel.add ( this.MetaBuff );
		this.BuffPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.TabPanel = new JTabbedPane ( );
		this.TabPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		

		for ( int y = 1 ; y < this.Name_LinePanels.length ; y++ ) {
			this.Name_LinePanels[y] = new JPanel ( );
			Name_LinePanels[y].setLayout ( new BoxLayout ( this.Name_LinePanels[y], BoxLayout.PAGE_AXIS ) );
		}
		for ( int y = 1 ; y < this.Gems_LinePanels.length ; y++ ) {
			this.Gems_LinePanels[y] = new JPanel ( );
			this.Gems_LinePanels[y].setLayout ( new BoxLayout ( this.Gems_LinePanels[y], BoxLayout.LINE_AXIS ) );
			this.Gems_LinePanels[y].setAlignmentX ( Component.LEFT_ALIGNMENT );
		}
		for ( int y = 1 ; y < this.End_LinePanels.length ; y++ ) {
			this.End_LinePanels[y] = new JPanel ( );
			End_LinePanels[y].setLayout ( new BoxLayout ( this.End_LinePanels[y], BoxLayout.LINE_AXIS ) );
		}
		
		this.DropSpot = new JLabel ( " " );

		for ( int y = 1 ; y < this.Middle_LinePanels.length ; y++ ) {
			this.Middle_LinePanels[y] = new JPanel ( );
			Middle_LinePanels[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			Middle_LinePanels[y].setLayout ( new BoxLayout ( this.Middle_LinePanels[y], BoxLayout.LINE_AXIS ) );
			TotalPanel.add ( Middle_LinePanels[y] );
		}
		
		this.NamePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.Middle_LinePanels[1].add ( this.NamePanel );
		this.NamePanel.add ( this.Name_LinePanels[1] );
		this.Name_LinePanels[1].add ( new JLabel ( Task+" item" ) );
		this.Name_LinePanels[1].add ( new JLabel ( "Name: " ) );
		this.Name_LinePanels[1].add ( new JLabel ( "Item type: " ) );
		this.Name_LinePanels[1].add ( new JLabel ( "Drop spot: " ) );
		this.NamePanel.add ( this.Name_LinePanels[2] );
		this.Name_LinePanels[2].add ( new JLabel ( " " ) );
		this.Name_LinePanels[2].add ( this.ItemName );
		this.Name_LinePanels[2].add ( ItemType );
		this.Name_LinePanels[2].add ( this.DropSpot );
		this.Middle_LinePanels[2].add ( this.TabPanel );
		this.TabPanel.addTab ( "Item", this.StatsPanel );
		this.TabPanel.addTab ( "Sockets", this.GemPanel );
		
		this.StatsPanel.add ( this.Stats_LinePanels[1] );
		this.Stats_LinePanels[1].add ( new JLabel ( "Stats: " ) );
		for ( int y = 1 ; y < this.Stats.length ; y++ ) {
			this.Stats_LinePanels[1].add ( this.Stats[y] );
		}
		this.StatsPanel.add ( this.Stats_LinePanels[2] );
		this.Stats_LinePanels[2].add ( new JLabel ( "Gear: " ) );
		for ( int y = 1 ; y < this.Gear.length ; y++ ) {
			this.Stats_LinePanels[2].add ( this.Gear[y] );
		}
		this.StatsPanel.add ( this.Stats_LinePanels[3] );
		this.Stats_LinePanels[3].add ( new JLabel ( "Bonus: " ) );
		for ( int y = 1 ; y < this.Gems.length ; y++ ) {
			this.Stats_LinePanels[3].add ( this.Gems[y] );
		}
		this.StatsPanel.add ( this.Stats_LinePanels[4] );
		this.Stats_LinePanels[4].add ( new JLabel ( "Totals: " ) );
		for ( int y = 1 ; y < this.Total.length ; y++ ) {
			this.Stats_LinePanels[4].add ( this.Total[y] );
		}
		for ( int y = 1 ; y < this.Gems_LinePanels.length ; y++ ) {
			this.GemPanel.add ( this.Gems_LinePanels[y] );
		}

		this.Gems_LinePanels[1].add ( new JLabel ( "Sockets on the item:" ) );
		this.Gems_LinePanels[2].add ( new JLabel ( "Meta" ) );
		this.Gems_LinePanels[2].add ( new JLabel ( "Gem 1" ) );
		this.Gems_LinePanels[2].add ( new JLabel ( "Gem 2" ) );
		this.Gems_LinePanels[2].add ( new JLabel ( "Gem 3" ) );
		this.Gems_LinePanels[3].add ( this.MetaSocket );
		this.Gems_LinePanels[3].add ( this.Gem1Socket );
		this.Gems_LinePanels[3].add ( this.Gem2Socket );
		this.Gems_LinePanels[3].add ( this.Gem3Socket );

		this.Gems_LinePanels[4].add ( new JLabel ( "Socket bonus:" ) );
		this.Gems_LinePanels[5].add ( this.SocketBonusAmount );
		this.Gems_LinePanels[5].add ( this.SocketBonusType );

		this.GemMeta_Name = new JLabel ( " " );
		this.Gem1_Name = new JLabel ( " " );
		this.Gem2_Name = new JLabel ( " " );
		this.Gem3_Name = new JLabel ( " " );

		this.Gems_LinePanels[6].add ( new JLabel ( "Select gems:" ) );
		this.Gems_LinePanels[7].add ( new JLabel ( "Meta: " ) );
		this.Gems_LinePanels[7].add ( this.GemMeta_Name );
		this.Gems_LinePanels[8].add ( this.GemMeta_Stats );
		this.Gems_LinePanels[9].add ( new JLabel ( "Gem 1: " ) );
		this.Gems_LinePanels[9].add ( this.Gem1_Name );
		this.Gems_LinePanels[10].add ( this.Gem1_Stats );
		this.Gems_LinePanels[11].add ( new JLabel ( "Gem 2: " ) );
		this.Gems_LinePanels[11].add ( this.Gem2_Name );
		this.Gems_LinePanels[12].add ( this.Gem2_Stats );
		this.Gems_LinePanels[13].add ( new JLabel ( "Gem 3: " ) );
		this.Gems_LinePanels[13].add ( this.Gem3_Name );
		this.Gems_LinePanels[14].add ( this.Gem3_Stats );

		this.SocketBonusActive = new JLabel ( " " );
		this.Gems_LinePanels[16].add ( this.SocketBonusActive );
		this.Gems_LinePanels[17].add ( new JLabel ( " " ) );
		this.Gems_LinePanels[18].add ( new JLabel ( "Meta requirements:" ) );
		this.Gems_LinePanels[19].add ( new JLabel ( "Red gems:" ) );
		this.Gems_MetaCounting[1][1] = new JLabel ( "0" );
		this.Gems_MetaCounting[2][1] = new JLabel ( "0" );
		this.Gems_LinePanels[19].add ( this.Gems_MetaCounting[1][1] );
		this.Gems_LinePanels[19].add ( this.Gems_MetaCounting[2][1] );
		this.Gems_LinePanels[20].add ( new JLabel ( "Blue gems:" ) );
		this.Gems_MetaCounting[1][2] = new JLabel ( "0" );
		this.Gems_MetaCounting[2][2] = new JLabel ( "0" );
		this.Gems_LinePanels[20].add ( this.Gems_MetaCounting[1][2] );
		this.Gems_LinePanels[20].add ( this.Gems_MetaCounting[2][2] );
		this.Gems_LinePanels[21].add ( new JLabel ( "Yellow gems:" ) );
		this.Gems_MetaCounting[1][3] = new JLabel ( "0" );
		this.Gems_MetaCounting[2][3] = new JLabel ( "0" );
		this.Gems_LinePanels[21].add ( this.Gems_MetaCounting[1][3] );
		this.Gems_LinePanels[21].add ( this.Gems_MetaCounting[2][3] );
		
		this.Middle_LinePanels[3].add ( this.BuffPanel );
		
		this.ButtonPanel = new JPanel ( );
		this.ButtonPanel.setLayout ( new BoxLayout ( this.ButtonPanel, BoxLayout.LINE_AXIS ) );
		this.ButtonPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		SetAsCurrent = new JButton("Equip item");
		if ( Task.equals ( "Current" )){
			SetAsCurrent.setEnabled ( false );
		}

		this.ButtonPanel.add ( this.SetAsCurrent );
		this.EndPanel.add ( this.ButtonPanel );
		this.Middle_LinePanels[4].add ( this.EndPanel );

		AddActionlisteners();

	}
	
	public void AddActionlisteners(){
		
		SetAsCurrent.addActionListener ( this );
	}

	public void actionPerformed ( ActionEvent AE ) {

		if ( AE.getActionCommand ( ).equals ( this.SetAsCurrent.getText ( ) ) ) {
			Class_Controller.Call_SetItemAsCurrent();
		}
		
	}
	
	public JPanel GetTotalpanel(){
		return this.TotalPanel;
	}

	public double[] GetStatamount ( ) {
		Object_Stats Test = new Object_Stats();
		double[] Stats = new double[Test.GetStatamounts ( ).length];
		for ( int X = 1 ; X < Stats.length ; X ++){
			//System.out.println ( X);
			Stats[X-1] = Double.parseDouble ( this.Gear[X].getText ( ));
		}
		return Stats;
	}

	public void VisComparedItem ( E visItem ) {

		//System.out.println ("Skal vise et item");
		ItemName.setText ( ( ( Interface_Gear ) visItem ).Get_Name ( ) );
		ItemType.setText ( ( ( Interface_Gear ) visItem ).Get_ItemType ( ) );
		try {
			Object_Stats ItemStats  = new Object_Stats();
			Interface_Gear Itemet = ( Interface_Gear ) visItem;
			ItemStats  = Itemet.Get_Statset ( );
			for ( int y = 0 ; y < ItemStats.GetStatnames ( ).length ; y++ ) {
				if ( ItemStats.GetStatnames ( )[y] != null ){
					//System.out.println ("Henter " + ItemStats.GetStatnames ( )[y]+": "+ItemStats.GetStatamounts ( )[y]);
					this.Gear[y+1].setText ( ((double)ItemStats.GetStatamounts ( )[y])+"" );
					//this.Gear[y+1].setEditable ( true );
				}
			}
		} catch (Exception E){
			Object_Stats ItemStats  = new Object_Stats();
			for ( int y = 0 ; y < ItemStats.GetStatnames ( ).length ; y++ ) {
				if ( ItemStats.GetStatnames ( )[y] != null ){
					this.Gear[y+1].setText ( ((int)ItemStats.GetStatamounts ( )[y])+"" );
					//this.Gear[y+1].setEditable ( false );
				}
			}
		}
		
	}
	
	public void VisEquippedItem( Interface_Gear Equipped ){
		
		//System.out.println ( "Skal vise equipped item: "+( ( Gear ) Equipped ).GetName ( ) );
		if ( Equipped == null ){
			ItemName.setText ( "No item equipped" );
			Object_Stats ItemStats  = new Object_Stats();
			for ( int y = 0 ; y < ItemStats.GetStatnames ( ).length ; y++ ) {
				if ( ItemStats.GetStatnames ( )[y] != null ){
					this.Gear[y+1].setText ( ((int)ItemStats.GetStatamounts ( )[y])+"" );
				}
			}
		} else {
			ItemName.setText ( ( ( Interface_Gear ) Equipped ).Get_Name ( ) );
			ItemType.setText ( ( ( Interface_Gear ) Equipped ).Get_ItemType ( ) );
			try {
				Object_Stats ItemStats  = new Object_Stats();
				Interface_Gear Itemet = ( Interface_Gear ) Equipped;
				ItemStats  = Itemet.Get_Statset ( );
				for ( int y = 0 ; y < ItemStats.GetStatnames ( ).length ; y++ ) {
					if ( ItemStats.GetStatnames ( )[y] != null ){
						this.Gear[y+1].setText ( ((double)ItemStats.GetStatamounts ( )[y])+"" );
					}
				}
			} catch (Exception E){
				Object_Stats ItemStats  = new Object_Stats();
				for ( int y = 0 ; y < ItemStats.GetStatnames ( ).length ; y++ ) {
					if ( ItemStats.GetStatnames ( )[y] != null ){
						this.Gear[y+1].setText ( ((int)ItemStats.GetStatamounts ( )[y])+"" );
					}
				}
			}
		}
		
	}

}
