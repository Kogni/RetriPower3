package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;

public class Panel_ComboListing extends JPanel implements ActionListener {
	
	private GUI_Controller Class_Controller;
	
	private JPanel TotalPanel = new JPanel();
	private JPanel[] RowPanel = new JPanel[30];
	private JButton CalculateDPS = new JButton("Calculate DPS on all combos");
	private Border RowBorder;

	public Panel_ComboListing ( GUI_Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.add(TotalPanel);
		this.TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		
		RowBorder = BorderFactory.createEmptyBorder ( 5, 5, 5, 5 );
		
		for ( int X = 0 ; X < RowPanel.length ; X++ ){
			RowPanel[X] = new JPanel();
			RowPanel[X].setLayout ( new GridLayout ( 1, 0 ) );
			//RowPanel[X].setLayout ( new BoxLayout ( this.RowPanel[X], BoxLayout.LINE_AXIS ) );
			RowPanel[X].setBorder ( RowBorder );
			TotalPanel.add ( RowPanel[X] );
		}
		
		add(TotalPanel);
		CalculateDPS.addActionListener ( this );
		//add(CalculateDPS);
		ListCombos();

	}
	
	public void ListCombos(){
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		UpdateComboListDPS();
		for ( int X = 0 ; X < RowPanel.length ; X++ ){
			RowPanel[X].removeAll ( );
			RowPanel[X].setBorder ( RowBorder );
		}
		
		String[] CharSlots = Class_Controller.Get_CharSlots ( );
		
		RowPanel[0].add ( new JLabel("Combo name") );
		RowPanel[1].add ( new JLabel("DPS") );
		RowPanel[2].add ( CalculateDPS );
		
		int A = 2;
		
		if ( CharSlots != null ){
			for ( int Z = 0 ; Z < CharSlots.length ; Z++ ){
				if ( CharSlots[Z] != null ){
					A++;
					RowPanel[A].add ( new JLabel(CharSlots[Z]) );
				}
			}
		}

		Interface_GearCombo[] Comboer = Class_Controller.Get_GearCombos();
		if ( Comboer != null ){
			for ( int X = 0 ; X < Comboer.length ; X++ ){
				Interface_GearCombo Temp = Comboer[X];
				if ( Temp != null ){
					RowPanel[0].add ( new JLabel(Temp.Get_Name ( )));
					RowPanel[1].add ( new JLabel(Temp.Get_DPS ( )+""));
					//JButton EquipKnapp = Temp.GetButton ( );
					JButton EquipKnapp = new JButton("Equip combo");
					EquipKnapp.setActionCommand ( Temp.Get_Name ( ) );
					EquipKnapp.addActionListener ( this );
					RowPanel[2].add ( EquipKnapp );
					
					Interface_Gear Equipped;
					String ItemName;
					int Y = 2;
					
					for ( int Z = 0 ; Z < CharSlots.length ; Z++ ){
						if ( CharSlots[Z] != null ){
							Equipped = ( Interface_Gear ) Temp.Get_EquippedItem ( CharSlots[Z] );
							ItemName = "-";
							if ( Equipped != null ){
								ItemName = Equipped.Get_Name ( );
							}
							Y++;
							RowPanel[Y].add ( new JLabel(ItemName) );
						}
					}

				}
			}
		}
		
	}

	public void actionPerformed ( ActionEvent e ) {

		//System.out.println ( "En knapp ble trykket" );
		if ( e.getSource ( ) == CalculateDPS ){
			ListCombos();
		} else {
			boolean Successful = Class_Controller.Call_GearComboChange ( e.getActionCommand ( ) );
			if ( Successful == true ){
				Class_Controller.SetStatusText("Successfully equipped gear combo ");
			} else {
				Class_Controller.SetStatusText("Error: Could not equiip gear combo ");
			}
		}
		
	}
	
	private void UpdateComboListDPS(){
		
		this.Class_Controller.Call_CalculateAllComboDPS();
		Class_Controller.SetStatusText("Calculated DPS for all speccs" );
		this.updateUI ( );
		
	}

}
