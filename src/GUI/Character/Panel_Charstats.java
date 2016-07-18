package GUI.Character;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import GUI.*;
import Standalone.*;


public class Panel_Charstats extends JPanel {
	
	private GUI_Controller					Class_Controller;
	
	JPanel						StatsPanel;
	JPanel						StatsBoxPanel;
	JPanel						StatsTextPanel;
	JPanel						StatsBasePanel;
	JPanel						LineDown1[]			= new JPanel[5];
	
	JPanel						StatsGearPanel;
	JPanel						StatsGemPanel;
	JPanel						StatsEnchPanel;
	JPanel						StatsTalentsPanel;
	JPanel						StatsTotalPanel;
	JPanel						StatsCombatPanel;
	
	JLabel[]					StatsNames			= new JLabel[30];
	JLabel[]					StatsBase			= new JLabel[30];
	JLabel[]					StatsGear			= new JLabel[30];
	JLabel[]					StatsGem			= new JLabel[30];
	JLabel[]					StatsEnch			= new JLabel[30];
	JLabel[]					StatsTalents		= new JLabel[30];
	JLabel[]					StatsTotal			= new JLabel[30];
	JLabel[]					StatsCombat			= new JLabel[30];
	
	Border						BordSeparation;

	public Panel_Charstats( GUI_Controller Class_Controller ){
		
		this.Class_Controller = Class_Controller;
		GridBagConstraints c = new GridBagConstraints ( );
		
		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		
		StatsPanel = new JPanel ( );
		add(StatsPanel);
		StatsPanel.setLayout ( new BoxLayout ( StatsPanel, BoxLayout.LINE_AXIS ) );
		StatsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int y = 1 ; y < this.LineDown1.length ; y++ ) {
			this.LineDown1[y] = new JPanel ( );
			this.LineDown1[y].setLayout ( new BoxLayout ( this.LineDown1[y], BoxLayout.PAGE_AXIS ) );
			this.LineDown1[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			StatsPanel.add ( this.LineDown1[y], c );
		}
		
		StatsBoxPanel = new JPanel ( );
		StatsBoxPanel.setLayout ( new BoxLayout ( StatsBoxPanel, BoxLayout.PAGE_AXIS ) );
		StatsBoxPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.LineDown1[1].add ( this.StatsBoxPanel, c );
		
		for ( int y = 0 ; y < this.StatsNames.length ; y++ ) {
			this.StatsNames[y] = new JLabel ( "" );
			this.StatsBase[y] = new JLabel ( "" );
			this.StatsGear[y] = new JLabel ( "" );
			this.StatsGem[y] = new JLabel ( "" );
			this.StatsEnch[y] = new JLabel ( "" );
			this.StatsTalents[y] = new JLabel ( "" );
			this.StatsTotal[y] = new JLabel ( "" );
			this.StatsCombat[y] = new JLabel("");
		}
		
		Object_Stats Teststats = new Object_Stats();
		for ( int y = 0 ; y < Teststats.GetStatnames ( ).length ; y++ ) {
			if ( Teststats.GetStatnames ( )[y] != null ){
				this.StatsNames[y+2].setText ( Teststats.GetStatnames ( )[y] );
			}
		}
		
		this.StatsBoxPanel.setLayout ( new BoxLayout ( this.StatsBoxPanel, BoxLayout.LINE_AXIS ) );
		StatsTextPanel = new JPanel();
		this.StatsTextPanel.setLayout ( new BoxLayout ( this.StatsTextPanel, BoxLayout.PAGE_AXIS ) );
		this.StatsTextPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.StatsTextPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNames.length ; y++ ) {
			if ( this.StatsNames[y] != null ) {
				this.StatsTextPanel.add ( this.StatsNames[y], c );
			}
		}
		this.StatsBoxPanel.add ( this.StatsTextPanel, c );
		
		this.StatsNames[1].setText ( "Stats" );
		this.StatsBase[1].setText ( "Base" );
		this.StatsGear[1].setText ( "Gear" );
		this.StatsGem[1].setText ( "Gems" );
		this.StatsEnch[1].setText ( "Ench" );
		this.StatsTalents[1].setText ( "Specc" );
		this.StatsTotal[1].setText ( "Total" );
		this.StatsCombat[1].setText ( "Combat" );

		StatsTextPanel = new JPanel ( );
		StatsTextPanel.setLayout ( new BoxLayout ( StatsTextPanel, BoxLayout.PAGE_AXIS ) );
		StatsTextPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		this.StatsBasePanel = new JPanel ( );
		this.StatsBasePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.StatsBasePanel.setLayout ( new BoxLayout ( this.StatsBasePanel, BoxLayout.PAGE_AXIS ) );
		this.StatsBasePanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsBase.length ; y++ ) {
			if ( this.StatsBase[y] != null ) {
				this.StatsBasePanel.add ( this.StatsBase[y], c );
			}
		}
		this.StatsBoxPanel.add ( this.StatsBasePanel, c );
		
		StatsGearPanel = new JPanel ( );
		StatsGearPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsGearPanel.setLayout ( new BoxLayout ( StatsGearPanel, BoxLayout.PAGE_AXIS ) );
		StatsGearPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsGear.length ; y++ ) {
			if ( this.StatsGear[y] != null ) {
				StatsGearPanel.add ( this.StatsGear[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsGearPanel, c );

		StatsGemPanel = new JPanel ( );
		StatsGemPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsGemPanel.setLayout ( new BoxLayout ( StatsGemPanel, BoxLayout.PAGE_AXIS ) );
		StatsGemPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsGem.length ; y++ ) {
			if ( this.StatsGem[y] != null ) {
				StatsGemPanel.add ( this.StatsGem[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsGemPanel, c );

		StatsEnchPanel = new JPanel ( );
		StatsEnchPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsEnchPanel.setLayout ( new BoxLayout ( StatsEnchPanel, BoxLayout.PAGE_AXIS ) );
		StatsEnchPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsEnch.length ; y++ ) {
			if ( this.StatsEnch[y] != null ) {
				StatsEnchPanel.add ( this.StatsEnch[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsEnchPanel, c );

		StatsTalentsPanel = new JPanel ( );
		StatsTalentsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsTalentsPanel.setLayout ( new BoxLayout ( StatsTalentsPanel, BoxLayout.PAGE_AXIS ) );
		StatsTalentsPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsTalents.length ; y++ ) {
			if ( this.StatsTalents[y] != null ) {
				StatsTalentsPanel.add ( this.StatsTalents[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsTalentsPanel, c );

		StatsTotalPanel = new JPanel ( );
		StatsTotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsTotalPanel.setLayout ( new BoxLayout ( StatsTotalPanel, BoxLayout.PAGE_AXIS ) );
		StatsTotalPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsTotal.length ; y++ ) {
			if ( this.StatsTotal[y] != null ) {
				StatsTotalPanel.add ( this.StatsTotal[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsTotalPanel, c );
		
		StatsCombatPanel = new JPanel ( );
		StatsCombatPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		StatsCombatPanel.setLayout ( new BoxLayout ( StatsCombatPanel, BoxLayout.PAGE_AXIS ) );
		StatsCombatPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsCombat.length ; y++ ) {
			if ( this.StatsCombat[y] != null ) {
				StatsCombatPanel.add ( this.StatsCombat[y], c );
			}
		}
		this.StatsBoxPanel.add ( StatsCombatPanel, c );
		
		FillLabels ( );
		
	}

	public void FillLabels ( ) {
		
		Object_Stats BaseStats = this.Class_Controller.Get_CharBasestats();
		System.out.println("Skal skrive opp base stats: "+BaseStats);
		for ( int y = 0 ; y < BaseStats.GetStatnames ( ).length ; y++ ) {
			if ( BaseStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (BaseStats.GetStatamounts ( )[y]));
				this.StatsBase[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats GearStats = this.Class_Controller.Get_CurrentGearstats();
		for ( int y = 0 ; y < GearStats.GetStatnames ( ).length ; y++ ) {
			if ( GearStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (GearStats.GetStatamounts ( )[y]));
				this.StatsGear[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats GemStats = this.Class_Controller.Get_CurrentGemStats();
		for ( int y = 0 ; y < GemStats.GetStatnames ( ).length ; y++ ) {
			if ( GemStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (GemStats.GetStatamounts ( )[y]));
				this.StatsGem[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats EnchStats = this.Class_Controller.Get_CurrentEnchStats();
		for ( int y = 0 ; y < EnchStats.GetStatnames ( ).length ; y++ ) {
			if ( EnchStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (EnchStats.GetStatamounts ( )[y]));
				this.StatsEnch[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats SpeccStats = this.Class_Controller.Get_CurrentSpeccStats();
		for ( int y = 0 ; y < SpeccStats.GetStatnames ( ).length ; y++ ) {
			if ( SpeccStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (SpeccStats.GetStatamounts ( )[y]));
				this.StatsTalents[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats TotalStats = this.Class_Controller.Get_CurrentTotalstats();
		for ( int y = 0 ; y < TotalStats.GetStatnames ( ).length ; y++ ) {
			if ( TotalStats.GetStatnames ( )[y] != null ){
				int Stat = (int)(Math.round (TotalStats.GetStatamounts ( )[y]));
				this.StatsTotal[y+2].setText ( Stat+"" );
			}
		}
		
		Object_Stats CombatStats = this.Class_Controller.Get_CurrentCombatstats ( );
		for ( int y = 0 ; y < CombatStats.GetStatnames ( ).length ; y++ ) {
			if ( CombatStats.GetStatnames ( )[y] != null ){
				//int Stat = (int)(Math.round (CombatStats.GetStatamounts ( )[y]));
				double Stat = CombatStats.GetStatamounts ( )[y];
				this.StatsCombat[y+2].setText ( Stat+"" );
			}
		}
		
	}
	
}
