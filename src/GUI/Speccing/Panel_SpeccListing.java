package GUI.Speccing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;

public class Panel_SpeccListing extends JPanel implements ActionListener {
	
	private GUI_Controller Class_Controller;
	
	private JPanel TotalPanel = new JPanel();
	private JPanel[] CollumnPanel = new JPanel[4];
	private JButton CalculateDPS = new JButton("Calculate DPS on all speccs");
	private Border CollumnBorder;
	
	public Panel_SpeccListing( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;
		
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		
		CollumnBorder = BorderFactory.createEmptyBorder ( 0, 5, 0, 5 );
		for ( int X = 0 ; X < CollumnPanel.length ; X++ ){
			CollumnPanel[X] = new JPanel();
			CollumnPanel[X].setLayout ( new GridLayout ( 0, 1 ) );
			CollumnPanel[X].setBorder ( CollumnBorder );
			TotalPanel.add ( CollumnPanel[X] );
		}
		
		add(TotalPanel);
		CalculateDPS.addActionListener ( this );
		add(CalculateDPS);
		ListSpeccs();
		
	}
	
	public void ListSpeccs(){
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		CollumnPanel[0].removeAll ( );
		CollumnPanel[1].removeAll ( );
		CollumnPanel[2].removeAll ( );
		CollumnPanel[3].removeAll ( );

		Interface_Specc[] ClassSpeccs = Class_Controller.Get_ClassSpeccs();
		if ( ClassSpeccs != null ){
			for ( int X = 0 ; X < ClassSpeccs.length ; X++ ){
				if ( ClassSpeccs[X] != null ){
					CollumnPanel[0].add ( new JLabel(ClassSpeccs[X].Get_Name()));
					//System.out.println ( "Lister opp speccen "+Class_Controller.Class_Model_Talents.GetClassSpeccs()[X].Name+", dps="+Class_Controller.Class_Model_Talents.GetClassSpeccs()[X].GetDPS ( ));
					CollumnPanel[1].add ( new JLabel(Class_Controller.Get_ClassSpeccs()[X].Get_DPS ( )+""));
					//CollumnPanel[2].add ( new JLabel(Class_Controller.Class_Model_Talents.ClassSpeccs[X].Name)); //specc "path"
					CollumnPanel[3].add ( ClassSpeccs[X].Get_RespeccButton() );
				}
			}
		}
		
	}

	public void actionPerformed ( ActionEvent e ) {

		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		if ( e.getSource ( ) == CalculateDPS ){
			System.out.println ( "Ber om å regne dps på alle speccer" );
			this.Class_Controller.Call_CalculateAllSpeccDPS();
			Class_Controller.SetStatusText( "Calculated DPS for all speccs" );
		}
		ListSpeccs();
		
	}

}
