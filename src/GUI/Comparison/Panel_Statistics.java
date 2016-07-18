package GUI.Comparison;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;

public class Panel_Statistics extends JPanel {

	private GUI_Controller					Class_Controller;

	private JPanel						TotalPanel					= new JPanel ( );
	JPanel[]					SidewardsPanel				= new JPanel[10];

	JPanel						CurrentInformation			= new JPanel ( );

	JPanel						StatsPanelTotal				= new JPanel ( );
	JPanel[]					StatsPanel					= new JPanel[4];
	JLabel[]					StatsPanelText				= new JLabel[27];
	JLabel[]					StatsPanelValue				= new JLabel[27];
	JLabel[]					StatsPanelPrcnt				= new JLabel[27];
	double[]					StatsValues					= new double[27];
	double[]					StatsPrcnt					= new double[27];

	JPanel						ComparisonInformation		= new JPanel ( );

	JPanel						DPSPanelTotal				= new JPanel ( );
	JPanel[]					DPSPanel					= new JPanel[6];
	JLabel[]					DPSPanelText				= new JLabel[6];
	public JLabel[]				DPSPanelValue_Current		= new JLabel[6];
	public JLabel[]				DPSPanelPrcnt_Current		= new JLabel[6];
	public JLabel[]				DPSPanelValue_Comparison	= new JLabel[6];
	public JLabel[]				DPSPanelPrcnt_Comparison	= new JLabel[6];
	public JLabel[]				DPSPanelValue_Difference	= new JLabel[6];
	public JLabel[]				DPSPanelPrcnt_Difference	= new JLabel[6];

	JPanel						BuffPanelTotal				= new JPanel ( );
	JPanel[]					BuffPanel					= new JPanel[4];
	JLabel[]					BuffName_Current			= new JLabel[15];
	JLabel[]					BuffName_Comparison			= new JLabel[15];

	Border						BordSeparation;
	boolean						Updating;

	public Panel_Statistics ( GUI_Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		//this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		BordSeparation = BorderFactory.createEmptyBorder ( 2, 2, 2, 2 );
		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.setPreferredSize ( new Dimension ( 800, 700 ) );
		this.TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TotalPanel.setBorder ( this.BordSeparation );

		for ( int y = 1 ; y < this.SidewardsPanel.length ; y++ ) {
			this.SidewardsPanel[y] = new JPanel ( );
			this.SidewardsPanel[y].setLayout ( new BoxLayout ( this.SidewardsPanel[y], BoxLayout.LINE_AXIS ) );
			this.SidewardsPanel[y].setBorder ( this.BordSeparation );
			this.TotalPanel.add ( this.SidewardsPanel[y] );
		}

		this.CurrentInformation = new JPanel ( );
		this.CurrentInformation.setLayout ( new FlowLayout ( ) );
		this.CurrentInformation.setBorder ( this.BordSeparation );
		this.SidewardsPanel[1].add ( this.CurrentInformation );

		this.ComparisonInformation = new JPanel ( );
		this.ComparisonInformation.setLayout ( new BoxLayout ( this.ComparisonInformation, BoxLayout.PAGE_AXIS ) );
		this.ComparisonInformation.setBorder ( this.BordSeparation );
		this.SidewardsPanel[2].add ( this.ComparisonInformation );

		// ---- DPS statistics
		this.DPSPanelTotal = new JPanel ( );
		this.DPSPanelTotal.setLayout ( new FlowLayout ( ) );
		this.DPSPanelTotal.setBorder ( this.BordSeparation );
		this.ComparisonInformation.add ( this.DPSPanelTotal );

		for ( int y = 1 ; y < this.DPSPanel.length ; y++ ) {
			this.DPSPanel[y] = new JPanel ( );
			this.DPSPanel[y].setLayout ( new BoxLayout ( this.DPSPanel[y], BoxLayout.PAGE_AXIS ) );
			this.DPSPanel[y].setBorder ( this.BordSeparation );
			this.DPSPanelTotal.add ( this.DPSPanel[y] );
		}

		this.DPSPanel[1].add ( new JLabel ( "Heal statistics: " ) );
		this.DPSPanel[1].add ( new JLabel ( "  " ) );
		this.DPSPanel[1].add ( new JLabel ( "HPS: " ) );
		this.DPSPanel[1].add ( new JLabel ( "Oom: " ) );
		this.DPSPanel[1].add ( new JLabel ( "Healed: " ) );

		for ( int y = 1 ; y < this.DPSPanelValue_Current.length ; y++ ) {
			
			this.DPSPanelValue_Current[y] = new JLabel ( "-" );
			this.DPSPanel[2].add ( this.DPSPanelValue_Current[y] );
			
			this.DPSPanelValue_Comparison[y] = new JLabel ( "-" );
			this.DPSPanel[3].add ( this.DPSPanelValue_Comparison[y] );
			
			this.DPSPanelValue_Difference[y] = new JLabel ( "-" );
			this.DPSPanel[4].add ( this.DPSPanelValue_Difference[y] );
			this.DPSPanelPrcnt_Difference[y] = new JLabel ( "-" );
			this.DPSPanel[5].add ( this.DPSPanelPrcnt_Difference[y] );
			
		}
		DPSPanelValue_Current[1].setText ( "Current" );
		
		DPSPanelValue_Comparison[1].setText ( "Comparison" );
		
		DPSPanelValue_Difference[1].setText ( "Upgrade" );
		DPSPanelPrcnt_Difference[1].setText ( "%" );

		// Stats
		
		this.StatsPanelTotal = new JPanel ( );
		this.StatsPanelTotal.setLayout ( new FlowLayout ( ) );
		this.StatsPanelTotal.setBorder ( this.BordSeparation );
		this.CurrentInformation.add ( this.StatsPanelTotal );

		for ( int y = 1 ; y < this.StatsPanel.length ; y++ ) {
			this.StatsPanel[y] = new JPanel ( );
			this.StatsPanel[y].setLayout ( new BoxLayout ( this.StatsPanel[y], BoxLayout.PAGE_AXIS ) );
			this.StatsPanel[y].setBorder ( this.BordSeparation );
			this.StatsPanelTotal.add ( this.StatsPanel[y] );
		}

		StatsPanel[1].add ( new JLabel ( "DPS from stats: " ) );
		StatValues Tempstats = new StatValues();
		for ( int X = 0 ; X < Tempstats.Get_Statvalues ( ).length ; X++ ){
			StatsPanel[1].add ( new JLabel ( Tempstats.Get_Statvalues ( )[X].StatAmounts+"x "+ Tempstats.Get_Statvalues ( )[X].StatNames ) );
		}
		
		this.StatsPanel[2].add ( new JLabel ( " " ));
		this.StatsPanel[3].add ( new JLabel ( " " ));
		for ( int y = 1 ; y < this.StatsPanelValue.length ; y++ ) {
			this.StatsPanelValue[y] = new JLabel ( " " );
			this.StatsPanel[2].add ( this.StatsPanelValue[y] );
			this.StatsPanelPrcnt[y] = new JLabel ( " " );
			this.StatsPanel[3].add ( this.StatsPanelPrcnt[y] );
		}

		//----- Buffs

		this.BuffPanelTotal = new JPanel ( );
		this.BuffPanelTotal.setLayout ( new GridLayout ( 1, 2 ) );
		this.BuffPanelTotal.setBorder ( this.BordSeparation );
		this.ComparisonInformation.add ( this.BuffPanelTotal );

		for ( int y = 1 ; y < 3 ; y++ ) {
			this.BuffPanel[y] = new JPanel ( );
			this.BuffPanel[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.BuffPanel[y].setBorder ( this.BordSeparation );
			this.BuffPanelTotal.add ( this.BuffPanel[y] );
		}
		for ( int y = 0 ; y < this.BuffName_Current.length ; y++ ) {
			this.BuffName_Current[y] = new JLabel ( "--- Current buffs ---" );
			this.BuffPanel[1].add ( this.BuffName_Current[y] );
		}
		for ( int y = 0 ; y < this.BuffName_Comparison.length ; y++ ) {
			this.BuffName_Comparison[y] = new JLabel ( "--- Compared buffs ---" );
			this.BuffPanel[2].add ( this.BuffName_Comparison[y] );
		}
		
		this.add ( TotalPanel );
		this.Updating = false;
		
	}
	
	public void FillLabels ( StatValues Tempstats ) {
		
		//System.out.println("Fyller statistics. Tempstats="+Tempstats);
		if ( Tempstats != null ){
			for ( int X = 0 ; X < Tempstats.Get_Statvalues ( ).length ; X++ ){
				//System.out.println("upgrade="+Tempstats.StatUpgrade[X]);
				StatsPanelValue[X+1].setText ( Tempstats.Get_Statvalues()[X].StatUpgrade+"" );
				StatsPanelPrcnt[X+1].setText ( Tempstats.Get_Statvalues()[X].StatUpgradePrcnt+"" );
			}
		}
		
	}

	public void ShowStatValues ( StatValues statVerdiene ) {
		FillLabels ( statVerdiene );
	}

	public void UpgradesUpdated ( StatValues statVerdiene ) {
		FillLabels ( statVerdiene );
	}

	public void SetUpgrade(Object_ComparisonResult results) {
		
		Object_ComparisonResult Current = this.Class_Controller.Get_CurrentHeal();
		double Current_Amount;
		double Upgrade_Amount;
		double Upgrade_Percent;
		
		Current_Amount = Current.Get_HPS_Amount();
		DPSPanelValue_Current[3].setText(Current_Amount+"");
		DPSPanelValue_Comparison[3].setText(results.Get_HPS_Amount()+"");
		Upgrade_Amount = results.Get_HPS_Amount() - Current_Amount;
		Upgrade_Amount = (Math.floor(Upgrade_Amount*100))/100.0;
		Upgrade_Percent = ((results.Get_HPS_Amount() / Current_Amount)-1)*100;
		Upgrade_Percent = (Math.floor(Upgrade_Percent*100))/100.0;
		DPSPanelValue_Difference[3].setText(Upgrade_Amount+"");
		DPSPanelPrcnt_Difference[3].setText(Upgrade_Percent+"%");
		
		Current_Amount = Current.Get_Oom_Amount();
		DPSPanelValue_Current[4].setText(Current_Amount+"");
		DPSPanelValue_Comparison[4].setText(results.Get_Oom_Amount()+"");
		Upgrade_Amount = results.Get_Oom_Amount() - Current_Amount;
		Upgrade_Amount = (Math.floor(Upgrade_Amount*100))/100.0;
		Upgrade_Percent = ((results.Get_Oom_Amount() / Current_Amount)-1)*100;
		Upgrade_Percent = (Math.floor(Upgrade_Percent*100))/100.0;
		DPSPanelValue_Difference[4].setText(Upgrade_Amount+"");
		DPSPanelPrcnt_Difference[4].setText(Upgrade_Percent+"%");
		
		Current_Amount = Current.Get_Healed_Amount();
		DPSPanelValue_Current[5].setText(Current_Amount+"");
		DPSPanelValue_Comparison[5].setText(results.Get_Healed_Amount()+"");
		Upgrade_Amount = results.Get_Healed_Amount() - Current_Amount;
		Upgrade_Amount = (Math.floor(Upgrade_Amount*100))/100.0;
		Upgrade_Percent = ((results.Get_Healed_Amount() / Current_Amount)-1)*100;
		Upgrade_Percent = (Math.floor(Upgrade_Percent*100))/100.0;
		DPSPanelValue_Difference[5].setText(Upgrade_Amount+"");
		DPSPanelPrcnt_Difference[5].setText(Upgrade_Percent+"%");
		
	}

}
