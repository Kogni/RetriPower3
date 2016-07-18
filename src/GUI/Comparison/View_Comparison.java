package GUI.Comparison;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import GUI.GUI_Controller;
import Standalone.*;

public class View_Comparison extends JFrame implements ActionListener, ChangeListener, FocusListener {

	private GUI_Controller Class_Controller;

	private JPanel						TotalPanel					= new JPanel ( );
	JPanel[]					TotalPanelLines				= new JPanel[3];

	JTabbedPane					DmgStatisticsTabPanel;
	JPanel						Tab_SpellEffects			= new JPanel ( );
	JPanel						Tab_Changes			= new JPanel ( );
	JPanel						Tab_Statistics				= new JPanel ( );

	//JTabbedPane					ModePanel;

	JPanel						StatsPanel_Comparison;
	JPanel[]					StatsCollumns_Comparison	= new JPanel[7];
	JLabel[]					Comparison_Stat				= new JLabel[28];
	JLabel[]					Comparison_NormalStats		= new JLabel[28];
	JLabel[]					Comparison_BuffStats		= new JLabel[28];
	JLabel[]					Comparison_CurrentStats		= new JLabel[28];
	JTextField[]				Comparison_Change			= new JTextField[28];
	JLabel[]					Comparison_Result			= new JLabel[28];

	Border						Bord;

	JButton						ResetChanges				= new JButton ( );
	
	public Object_Stats				UserComparisonStats;

	boolean						Updating;

	public View_Comparison (GUI_Controller Class_Controller) {
		
		super ( "Comparing" );
		this.Class_Controller = Class_Controller;
		this.Updating = true;
		UserComparisonStats = new Object_Stats();

		Startup();
	}

	public void Startup ( ) {

		setSize ( 1100, 880 );
		setResizable ( false );

		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );
		this.Bord = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );

		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );
		//this.TotalPanel.setLayout ( new GridLayout ( 1, 0 ) );
		this.TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TotalPanel.setBorder ( this.Bord );

		int Change = 200 / this.TotalPanelLines.length;
		for ( int y = 0 ; y < this.TotalPanelLines.length ; y++ ) {
			this.TotalPanelLines[y] = new JPanel ( );
			this.TotalPanelLines[y].setLayout ( new BoxLayout ( this.TotalPanelLines[y], BoxLayout.PAGE_AXIS ) );
			this.TotalPanelLines[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.TotalPanelLines[y].setBorder ( this.Bord );
			this.TotalPanel.add ( this.TotalPanelLines[y], c );
		}

		this.StatsPanel_Comparison = new JPanel ( );
		this.StatsPanel_Comparison.setLayout ( new BoxLayout ( this.StatsPanel_Comparison, BoxLayout.LINE_AXIS ) );
		//this.StatsPanel_Comparison.setLayout ( new GridLayout ( 1, 0 ) );
		this.StatsPanel_Comparison.setBorder ( this.Bord );
		Change = 200 / this.StatsCollumns_Comparison.length;
		for ( int y = 0 ; y < this.StatsCollumns_Comparison.length ; y++ ) {
			this.StatsCollumns_Comparison[y] = new JPanel ( );
			this.StatsCollumns_Comparison[y].setLayout ( new GridLayout ( 0, 1 ) );
			//StatsCollumns_Comparison[y].setLayout ( new BoxLayout ( this.StatsCollumns_Comparison[y], BoxLayout.PAGE_AXIS ) );
			this.StatsCollumns_Comparison[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.StatsPanel_Comparison.add ( this.StatsCollumns_Comparison[y] );
		}
		
		this.StatsCollumns_Comparison[1].add ( new JLabel ( " " ) );
		this.StatsCollumns_Comparison[2].add ( new JLabel ( "Normal" ) );
		this.StatsCollumns_Comparison[3].add ( new JLabel ( "Buffs" ) );
		this.StatsCollumns_Comparison[4].add ( new JLabel ( "Combat" ) );
		this.StatsCollumns_Comparison[5].add ( new JLabel ( "Change" ) );
		this.StatsCollumns_Comparison[6].add ( new JLabel ( "Result" ) );
		for ( int y = 0 ; y < this.Comparison_CurrentStats.length ; y++ ) {
			this.Comparison_Stat[y] = new JLabel ( "" );
			this.StatsCollumns_Comparison[1].add ( this.Comparison_Stat[y] );
			
			this.Comparison_NormalStats[y] = new JLabel ( "" );
			this.StatsCollumns_Comparison[2].add ( this.Comparison_NormalStats[y] );

			this.Comparison_BuffStats[y] = new JLabel ( "" );
			this.StatsCollumns_Comparison[3].add ( this.Comparison_BuffStats[y] );

			this.Comparison_CurrentStats[y] = new JLabel ( "" );
			this.StatsCollumns_Comparison[4].add ( this.Comparison_CurrentStats[y] );

			this.Comparison_Result[y] = new JLabel ( "" );
			this.StatsCollumns_Comparison[6].add ( this.Comparison_Result[y] );
		}
		Comparison_Change[0] = new JTextField ( "1" );
		Comparison_Change[0].setVisible ( false );
		StatsCollumns_Comparison[5].add ( this.Comparison_Change[0] );
		for ( int y = 1 ; y < this.Comparison_Change.length ; y++ ) {
			this.Comparison_Change[y] = new JTextField ( "0" );
			Comparison_Change[y].setMaximumSize ( new Dimension( 40, 16 ) );
			//Comparison_Change[y].setLayout ( new BoxLayout ( this.Comparison_Change[y], BoxLayout.PAGE_AXIS ) );
			this.Comparison_Change[y].addFocusListener ( this );
			this.StatsCollumns_Comparison[5].add ( this.Comparison_Change[y] );
		}
		Object_Stats Teststats = new Object_Stats();
		for ( int y = 0 ; y < Teststats.GetStatnames ( ).length ; y++ ) {
			if ( Teststats.GetStatnames ( )[y] != null ){
				//System.out.println ( "y="+y+" label="+Comparison_Stat[y+1]+" amount="+Teststats.GetStatamounts ( )[y]);
				this.Comparison_Stat[y+1].setText ( Teststats.GetStatnames ( )[y]+"" );
			}
		}
		
		this.TotalPanelLines[1].add ( this.StatsPanel_Comparison );
		this.ResetChanges = new JButton ( "Reset stat changes" );
		this.ResetChanges.addActionListener ( this );
		this.ResetChanges.setActionCommand ( "Reset" );
		this.TotalPanelLines[1].add ( this.ResetChanges );

		this.DmgStatisticsTabPanel = new JTabbedPane ( );
		this.DmgStatisticsTabPanel.setBorder ( this.Bord );
		
		this.Tab_Changes = new JPanel ( );
		this.Tab_Changes.setPreferredSize ( new Dimension( 800, 800 ) );
		this.Tab_Changes.setLayout ( new BoxLayout ( this.Tab_Changes, BoxLayout.PAGE_AXIS ) );
		this.Tab_Changes.setBorder ( this.Bord );

		this.Tab_Changes.add ( new JLabel ( "Changes:" ) );
		this.Tab_Changes.add ( new JLabel ( "Stats:" ) );
		this.Tab_Changes.add ( new JLabel ( "Abilities:" ) );
		this.Tab_Changes.add ( new JLabel ( "Buffs:" ) );
		this.Tab_Changes.add ( new JLabel ( "DPS:" ) );
		//this.Tab_Changes.add ( this.Class_Controller.Get_Class_Panel_SpellTable_Difference() );

		this.Tab_SpellEffects = new JPanel ( );
		this.Tab_SpellEffects.setPreferredSize ( new Dimension( 800, 800 ) );
		this.Tab_SpellEffects.setLayout ( new BoxLayout ( this.Tab_SpellEffects, BoxLayout.PAGE_AXIS ) );
		this.Tab_SpellEffects.setBorder ( this.Bord );

		this.Tab_SpellEffects.add ( new JLabel ( "Difference:" ) );
		//this.Tab_SpellEffects.add ( this.Class_Controller.Get_Class_Panel_SpellTable_Difference() );

		this.Tab_Statistics = new JPanel ( );
		this.Tab_Statistics.setLayout ( new BoxLayout ( this.Tab_Statistics, BoxLayout.PAGE_AXIS ) );
		this.Tab_Statistics.setBorder ( this.Bord );

		this.DmgStatisticsTabPanel.addTab ( "Changes", this.Tab_Changes );
		this.DmgStatisticsTabPanel.addTab ( "Spell effects", this.Tab_SpellEffects );
		this.DmgStatisticsTabPanel.addTab ( "Statistics", this.Class_Controller.Get_Class_Panel_Statistics() );
		this.TotalPanelLines[2].add ( this.DmgStatisticsTabPanel );

		pane.add ( this.TotalPanel, c );
		this.Updating = false;
		
		FillLabels ( );
		
	}

	public void FillLabels ( ) {

		Updating = true;
		Object_Stats Normalstats = Class_Controller.Get_CurrentTotalstats(); //rene base char stats
		Object_Stats CombatStats = Class_Controller.Get_CurrentCombatstats(); //base char stats i combat
		Object_Stats ResultStats = Class_Controller.Get_UsercomparisonCombatstats(); //buffer, trinkers etc i combat
		Object_Stats BuffStats = Class_Controller.Get_UsercomparisonBuffstats(); //base char stats i combat + buffer, uten user changes
		for ( int y = 0 ; y < Normalstats.GetStatnames ( ).length ; y++ ) {
			if ( Normalstats.GetStatnames ( )[y] != null ){
				//System.out.println("prøver #"+y+" jlabel="+Comparison_NormalStats[y]+" amount="+Charstats.GetStatamounts ( )[y]);
				
				double Stat = (Math.round (Normalstats.GetStatamounts ( )[y]*100))/100.0;
				Comparison_NormalStats[y+1].setText ( Stat+"" );
				
				Stat = (Math.round (CombatStats.GetStatamounts ( )[y]*100))/100.0;
				Comparison_CurrentStats[y+1].setText ( Stat+"" );
				
				Stat = (Math.round (BuffStats.GetStatamounts ( )[y]*100))/100.0;
				Comparison_BuffStats[y+1].setText ( Stat+"" );
				
				Stat = (Math.round (ResultStats.GetStatamounts ( )[y]*100))/100.0;
				Comparison_Result[y+1].setText ( Stat+"" );

			}
		}
		Updating = false;
		
	}

	public void stateChanged ( ChangeEvent e ) {
		
	}

	public void focusLost ( FocusEvent A ) {
		if ( Updating == false ){
			UpdateDifference ( "User changed stats" );
		}
	}

	public void focusGained ( FocusEvent A ) {
		
	}

	public void UpdateDifference ( String Source ) {
		
		//System.out.println ( "bruker ber om å sammenligne stats" );
		try {
			Updating = true;
			UserComparisonStats = new Object_Stats();
			for ( int X = 1 ; X < 28 ; X++ ){
				UserComparisonStats.SetStat_Nmr ( (X-1), Double.parseDouble ( Comparison_Change[X].getText ( )) );
			}
			this.Class_Controller.Call_ComparingWindowComparison ( );
			Updating = false;
		} catch ( NumberFormatException NFE ){
			
		}
		
	}
	
	public void FillInGearDifference( Object_Stats Difference ){
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		Updating = true;
		UserComparisonStats = Difference;
		for ( int X = 1 ; X < 27 ; X++ ){
			Comparison_Change[X].setText ( Difference.GetStat_Nmr ( X )+"" );
		}
		this.Class_Controller.Call_ComparingWindowComparison ( );
		Updating = false;
		
	}

	public void actionPerformed ( ActionEvent e ) {
		
		if ( e.getActionCommand ( ).equals ( "Reset" ) ) {
			Class_Controller.UserCommand_ResetComparisonstats();
			//Class_Controller.UserCommand_SetUsercomparisonBonusstats ( new Object_Stats() );
			FillLabels ( );
			UpdateDifference(null);
		}
		
	}

	public void Call_SetComparedStats ( Object_Stats newstats ) {
		//System.out.println ( "skal vise resultatstats" );
		for ( int y = 0 ; y < newstats.GetStatnames ( ).length ; y++ ) {
			if ( newstats.GetStatnames ( )[y] != null ){
				double Stat = (Math.round (newstats.GetStatamounts ( )[y]*100))/100.0;
				Comparison_Result[y+1].setText ( Stat+"" );

			}
		}
		
	}

}
