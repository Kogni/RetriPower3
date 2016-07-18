package GUI.Profession;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import GUI.*;
import Standalone.*;

public class Vindu_Professions extends JFrame implements MouseListener {

	private static final long	serialVersionUID		= 1L;

	private GUI_Controller				Class_Controller;

	private JPanel						TotalPanel;

	JPanel						TopHalf;
	JScrollPane					Overview_ScrollPanel	= new JScrollPane ( );
	JTable						Overview_Table			= new JTable ( );
	DefaultTableModel			Overview_TableModel;
	Vector						Overview_TableCollumnNames;
	Vector						Overview_TableContent;

	JPanel						BottomHalf;
	JScrollPane					Gains_ScrollPanel		= new JScrollPane ( );
	JTable						Gains_Table				= new JTable ( );
	DefaultTableModel			Gains_TableModel;
	Vector						Gains_TableCollumnNames;
	Vector						Gains_TableContent;

	boolean						Ready					= false;

	public Vindu_Professions ( GUI_Controller Class_ControllerT ) {

		super ( "Professions" );
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );
		this.Class_Controller = Class_ControllerT;

	}

	public void Startup ( ) {

		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " started" );

		setSize ( 600, 340 );

		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.TopHalf = new JPanel ( );
		this.TopHalf.setMaximumSize ( new Dimension ( 600, 170 ) );
		this.TopHalf.setLayout ( new BoxLayout ( this.TopHalf, BoxLayout.LINE_AXIS ) );
		this.TotalPanel.add ( this.TopHalf );

		this.BottomHalf = new JPanel ( );
		this.BottomHalf.setMaximumSize ( new Dimension ( 600, 300 ) );
		this.BottomHalf.setLayout ( new BoxLayout ( this.BottomHalf, BoxLayout.LINE_AXIS ) );
		this.TotalPanel.add ( this.BottomHalf );

		// overview table
		this.Overview_TableContent = new Vector ( );
		this.Overview_TableCollumnNames = new Vector ( );
		this.Overview_TableModel = new DefaultTableModel ( );
		this.Overview_TableCollumnNames.addElement ( "Profession" );
		this.Overview_TableCollumnNames.addElement ( "Gear upgrade" );
		this.Overview_TableCollumnNames.addElement ( "Gem upgrade" );
		this.Overview_TableCollumnNames.addElement ( "Enchant upgrade" );
		this.Overview_TableCollumnNames.addElement ( "Special upgrade" );
		this.Overview_TableCollumnNames.addElement ( "Total upgrade" );
		this.Overview_TableModel.setDataVector ( this.Overview_TableContent, this.Overview_TableCollumnNames );
		this.Overview_Table = new JTable ( this.Overview_TableModel );
		this.Overview_ScrollPanel = new JScrollPane ( this.Overview_Table );
		this.TopHalf.add ( this.Overview_ScrollPanel );

		TableColumn column;
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 75 ); //name
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 50 ); //gear upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 50 ); //gem upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 3 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 4 );
		column.setPreferredWidth ( 50 ); //special upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 5 );
		column.setPreferredWidth ( 50 ); //total upgrade

		// overview table
		this.Gains_TableContent = new Vector ( );
		this.Gains_TableCollumnNames = new Vector ( );
		this.Gains_TableModel = new DefaultTableModel ( );
		this.Gains_TableCollumnNames.addElement ( "Item name" );
		this.Gains_TableCollumnNames.addElement ( "Item type" );
		this.Gains_TableCollumnNames.addElement ( "Upgrade" );
		this.Gains_TableModel.setDataVector ( this.Gains_TableContent, this.Gains_TableCollumnNames );
		this.Gains_Table = new JTable ( this.Gains_TableModel );
		this.Gains_ScrollPanel = new JScrollPane ( this.Gains_Table );
		this.BottomHalf.add ( this.Gains_ScrollPanel );

		column = this.Gains_Table.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 100 ); //name
		column = this.Gains_Table.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 50 ); //gear upgrade
		column = this.Gains_Table.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 20 ); //gem upgrade

		this.Overview_Table.addMouseListener ( this );

		pane.add ( this.TotalPanel, c );
	}

	public void VisVindu ( ) {
		setVisible ( true );
		this.Ready = true;
	}

	public void FillLabels ( ) {
		FillOverview ( );
	}

	private void FillOverview ( ) {
		if ( this.Ready == true ) {
			this.Overview_TableContent.removeAllElements ( );
			
			Interface_Profession[] Professions = Class_Controller.Get_Professions();
			for ( int y = 1 ; y < Professions.length ; y++ ) {
				if ( Professions[y] != null ) {
					
					Vector Temp = new Vector ( );
					Temp.addElement ( Professions[y].Get_Name() );

					double TotalUpgrade = 0;

					for ( int B = 0 ; B < Professions[y].Get_HighestPossibleUpgrade_Gear_ATM().length ; B++ ) {
						if ( Professions[y].Get_HighestPossibleUpgrade_Gear_ATM()[B] > 0 ) {
							TotalUpgrade = TotalUpgrade + Professions[y].Get_HighestPossibleUpgrade_Gear_ATM()[B];
						}
					}
					TotalUpgrade = ( Math.round ( TotalUpgrade * 100 ) ) / 100.0;
					Temp.addElement ( TotalUpgrade );

					TotalUpgrade = 0;
					for ( int B = 0 ; B < Professions[y].Get_HighestPossibleUpgrade_Gems_ATM().length ; B++ ) {
						if ( Professions[y].Get_HighestPossibleUpgrade_Gems_ATM()[B] > 0 ) {
							TotalUpgrade = TotalUpgrade + Professions[y].Get_HighestPossibleUpgrade_Gems_ATM()[B];
						}
					}
					TotalUpgrade = ( Math.round ( TotalUpgrade * 100 ) ) / 100.0;
					Temp.addElement ( TotalUpgrade );

					TotalUpgrade = 0;
					for ( int B = 0 ; B < Professions[y].Get_HighestPossibleUpgrade_Enchant_ATM().length ; B++ ) {
						if ( Professions[y].Get_HighestPossibleUpgrade_Enchant_ATM()[B] > 0 ) {
							TotalUpgrade = TotalUpgrade + Professions[y].Get_HighestPossibleUpgrade_Enchant_ATM()[B];
						}
					}
					TotalUpgrade = ( Math.round ( TotalUpgrade * 100 ) ) / 100.0;
					Temp.addElement ( TotalUpgrade );

					Temp.addElement ( Professions[y].Get_TotalUpgrade_ProfessionSpecial() );

					TotalUpgrade = Professions[y].Get_TotalUpgrade();
					TotalUpgrade = ( Math.round ( TotalUpgrade * 100 ) ) / 100.0;
					Temp.addElement ( TotalUpgrade );
					this.Overview_TableContent.addElement ( Temp );
				}
			}
			this.Overview_TableModel.fireTableDataChanged ( );
		}
	}

	private void VisSelectedProfession ( ) {
		
		this.Gains_TableContent.removeAllElements ( );
		if ( this.Overview_Table.getSelectedRow ( ) > -1 ) {
			
			Interface_Gear[] GearItem = Class_Controller.Get_GearItems();
			for ( int y = 0 ; y < GearItem.length ; y++ ) {
				if ( GearItem[y] != null ) {
					if ( GearItem[y].Get_BoP().equals ( "Binds when picked up" )) {
						Interface_Dropspot DropSpot = this.Class_Controller.Get_DropSpotFromID ( GearItem[y].Get_DropSpotID() );
						if ( DropSpot.Get_Name().equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {

							Vector Temp = new Vector ( );
							Temp.addElement ( GearItem[y].Get_Name() );
							Temp.addElement ( "Gear (" + GearItem[y].Get_GearType() + ")" );
							String UpgradeText = "";
							UpgradeText = GearItem[y].Get_Upgrades_Grinding()[1] + "%";
							if ( GearItem[y].Get_Upgrades_Grinding()[2] > -999 ) {
								UpgradeText = UpgradeText + " | " + GearItem[y].Get_Upgrades_Grinding()[2] + "%";
							}
							if ( GearItem[y].Get_Upgrades_Grinding()[3] > -999 ) {
								UpgradeText = UpgradeText + " | " + GearItem[y].Get_Upgrades_Grinding()[3] + "%";
							}
							Temp.addElement ( UpgradeText );
							this.Gains_TableContent.addElement ( Temp );

						}
					}
				}
			}
			Interface_Gem[] NormalGemList = Class_Controller.Get_NormalGemList();
			for ( int y = 0 ; y < NormalGemList.length ; y++ ) {
				if ( NormalGemList[y] != null ) {
					if ( NormalGemList[y].Get_BoP() == true ) {
						if ( NormalGemList[y].Get_Profession().equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {

							Vector Temp = new Vector ( );
							Temp.addElement ( NormalGemList[y].Get_GemName() );
							Temp.addElement ( "Gem (" + NormalGemList[y].Get_Socket() + ")" );
							Temp.addElement ( NormalGemList[y].Get_Upgrade() );
							this.Gains_TableContent.addElement ( Temp );

						}
					}
				}
			}
			Interface_Gem[] MetaGemList = Class_Controller.Get_MetaGemList();
			for ( int y = 0 ; y < MetaGemList.length ; y++ ) {
				if ( MetaGemList[y] != null ) {
					if ( MetaGemList[y].Get_BoP() == true ) {
						if ( MetaGemList[y].Get_Profession().equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {

							Vector Temp = new Vector ( );
							Temp.addElement ( MetaGemList[y].Get_GemName() );
							Temp.addElement ( "Gem (" + MetaGemList[y].Get_Socket() + ")" );
							Temp.addElement ( MetaGemList[y].Get_Upgrade() );
							this.Gains_TableContent.addElement ( Temp );

						}
					}
				}
			}
			Interface_Enchant[] EnchantList = Class_Controller.Get_EnchantList();
			for ( int y = 0 ; y < EnchantList.length ; y++ ) {
				if ( EnchantList[y] != null ) {
					if ( EnchantList[y].Get_BoP() == true ) {
						if ( EnchantList[y].Get_DropSpot().equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {

							Vector Temp = new Vector ( );
							Temp.addElement ( EnchantList[y].Get_Navn() );
							Temp.addElement ( "Enchant (" + EnchantList[y].Get_Slot() + ")" );
							Temp.addElement ( EnchantList[y].Get_Upgrade() );
							this.Gains_TableContent.addElement ( Temp );

						}
					}
				}
			}
			Interface_Special[] Specials = Class_Controller.Get_Specials();
			for ( int y = 1 ; y < Specials.length ; y++ ) {
				if ( Specials[y] != null ) {
					if ( Specials[y].Get_Profession().equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {

						Vector Temp = new Vector ( );
						Temp.addElement ( Specials[y].Get_Name() );
						Temp.addElement ( "Special (" + Specials[y].Get_Type() + ")" );
						Temp.addElement ( Specials[y].Get_Upgrade() );
						this.Gains_TableContent.addElement ( Temp );

					}
				}
			}

		}
		SortGainTable ( );
		this.Gains_TableModel.fireTableDataChanged ( );
	}

	private void SortGainTable ( ) {
	}

	public void mouseClicked ( MouseEvent e ) {
		VisSelectedProfession ( );
	}

	public void mouseExited ( MouseEvent e ) {
	}

	public void mouseEntered ( MouseEvent e ) {
	}

	public void mouseReleased ( MouseEvent e ) {
	}

	public void mousePressed ( MouseEvent e ) {
	}

}
