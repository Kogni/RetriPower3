package GUI.Gear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;

public class Panel_CurrentCombo extends JPanel {
	
	private GUI_Controller				Class_Controller;
	
	private JPanel 		TotalPanel 		= new JPanel();
	private JScrollPane	InfoScrollPane 	= new JScrollPane();
	private JPanel		ScrollContent	= new JPanel();
	private JPanel[] 	CollumnPanel 	= new JPanel[30];
	private Border 		RowBorder;
	private Border		TopicBorder;

	public Panel_CurrentCombo ( GUI_Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.LINE_AXIS ) );
		
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		//TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		this.add(TotalPanel);
		
		RowBorder = BorderFactory.createEmptyBorder ( 5, 5, 5, 5 );
		TopicBorder = BorderFactory.createLineBorder ( Color.black, 1 );
		
		for ( int X = 0 ; X < CollumnPanel.length ; X++ ){
			CollumnPanel[X] = new JPanel();
			CollumnPanel[X].setLayout ( new GridLayout ( 0, 1 ) );
			//RowPanel[X].setLayout ( new BoxLayout ( this.RowPanel[X], BoxLayout.LINE_AXIS ) );
			CollumnPanel[X].setBorder ( RowBorder );
			ScrollContent.add ( CollumnPanel[X] );
		}
		ScrollContent.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		InfoScrollPane = new JScrollPane(ScrollContent);
		ScrollContent.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		InfoScrollPane.setPreferredSize ( new Dimension ( 1170, 750 ) );
		TotalPanel.add(InfoScrollPane);
		
		ListGear();

	}
	
	public void ListGear(){
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");

		for ( int X = 0 ; X < CollumnPanel.length ; X++ ){
			CollumnPanel[X].removeAll ( );
			CollumnPanel[X].setBorder ( RowBorder );
		}
		
		String[] CharSlots = Class_Controller.Get_CharSlots ( );
		Object_Stats Stats = new Object_Stats();
		
		JLabel Topic1 = new JLabel("Item");
		Topic1.setBorder ( TopicBorder );
		CollumnPanel[0].add ( Topic1 );
		JLabel Topic2 = new JLabel("Item type");
		Topic2.setBorder ( TopicBorder );
		CollumnPanel[1].add ( Topic2 );
		int A = 1;
		for ( int Z = 0 ; Z < Stats.GetStatnames ( ).length ; Z++ ){
			if ( Stats.GetStatnames ( )[Z] != null ){
				A++;
				JLabel Topic3 = new JLabel(Stats.GetStatnames ( )[Z]+"");
				Topic3.setBorder ( TopicBorder );
				CollumnPanel[A].add ( Topic3 );
			}
		}

		String[] CharGearSlots = Class_Controller.Get_CharSlots ( );
		Interface_GearCombo EquippedCombo = Class_Controller.Get_CurrentGearCombo ( );
		//System.out.println( "Equipped combo="+EquippedCombo.GetName ( ) );
		if ( CharGearSlots != null ){
			for ( int X = 0 ; X < CharGearSlots.length ; X++ ){
				if ( CharGearSlots[X] != null ){
					Interface_Gear EquippedItem = EquippedCombo.Get_EquippedItem ( CharGearSlots[X] );
					//System.out.println( "Equipped item for slot "+CharGearSlots[X]+"="+EquippedItem);
					if ( EquippedItem != null ){
						CollumnPanel[0].add ( new JLabel(EquippedItem.Get_Name ( )));
						CollumnPanel[1].add ( new JLabel(EquippedItem.Get_ItemType ( )+""));
						int Y = 1;
						try {
							Interface_Gear Equipped = EquippedItem;
							Object_Stats ItemStats = Equipped.Get_Statset ( );

							for ( int Z = 0 ; Z < ItemStats.GetStatnames ( ).length ; Z++ ){
								if ( ItemStats.GetStatnames ( )[Z] != null ){
									Y++;
									CollumnPanel[Y].add ( new JLabel(ItemStats.GetStatamounts ( )[Z]+"") );
								}
							}
						} catch (Exception e ){
							for ( int Z = 0 ; Z < Stats.GetStatnames ( ).length ; Z++ ){
								if ( Stats.GetStatnames ( )[Z] != null ){
									Y++;
									CollumnPanel[Y].add ( new JLabel("-") );
								}
							}
						}
					} else {
						CollumnPanel[0].add ( new JLabel("-"));
						CollumnPanel[1].add ( new JLabel("-"));
						int Y = 1;
						for ( int Z = 0 ; Z < Stats.GetStatnames ( ).length ; Z++ ){
							if ( Stats.GetStatnames ( )[Z] != null ){
								Y++;
								CollumnPanel[Y].add ( new JLabel("-") );
							}
						}
					}
				}
			}
		}
		
	}

}
