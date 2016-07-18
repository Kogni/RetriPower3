package GUI.Speccing;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import GUI.*;
import Standalone.*;

public class Panel_CurrentSpecc extends JPanel {

	GUI_Controller					Class_Controller;

	public JPanel				TotalPanel;
	JPanel						SpeccOverview;
	JPanel[]					OverviewCollumn		= new JPanel[5];
	JLabel						TalentPoints;
	JLabel						UnusedPints;
	JLabel						RetriPoints;
	JLabel						ProtPoints;
	JLabel						HolyPoints;
	JTabbedPane					TreeTabs;
	JPanel						RetriTree;
	JPanel						ProtTree;
	JPanel						HolyTree;
	JPanel[][]					TalentSpot			= new JPanel[50][4];
	JSpinner[][]				TalentSpinner		= new JSpinner[50][4];

	public Panel_CurrentSpecc ( GUI_Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		Startup();
		
	}

	public void Startup ( ) {
		
		this.removeAll ( );

		this.TotalPanel = new JPanel ( );
		add ( TotalPanel );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.SpeccOverview = new JPanel ( );
		this.SpeccOverview.setLayout ( new BoxLayout ( this.SpeccOverview, BoxLayout.LINE_AXIS ) );
		this.SpeccOverview.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		this.TotalPanel.add ( this.SpeccOverview );

		for ( int y = 1 ; y < this.OverviewCollumn.length ; y++ ) {
			this.OverviewCollumn[y] = new JPanel ( );
			this.OverviewCollumn[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.SpeccOverview.add ( this.OverviewCollumn[y] );
		}

		this.OverviewCollumn[1].add ( new JLabel ( "Talent points: " ) );
		this.OverviewCollumn[1].add ( new JLabel ( "Unused points: " ) );

		this.TalentPoints = new JLabel ( "0" );
		this.OverviewCollumn[2].add ( this.TalentPoints );
		this.UnusedPints = new JLabel ( "0" );
		this.OverviewCollumn[2].add ( this.UnusedPints );

		this.OverviewCollumn[3].add ( new JLabel ( "Retri points: " ) );
		this.OverviewCollumn[3].add ( new JLabel ( "Prot points: " ) );
		this.OverviewCollumn[3].add ( new JLabel ( "Holy points: " ) );

		this.RetriPoints = new JLabel ( "0" );
		this.OverviewCollumn[4].add ( this.RetriPoints );
		this.ProtPoints = new JLabel ( "0" );
		this.OverviewCollumn[4].add ( this.ProtPoints );
		this.HolyPoints = new JLabel ( "0" );
		this.OverviewCollumn[4].add ( this.HolyPoints );

		this.RetriTree = new JPanel ( );
		this.RetriTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.RetriTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.ProtTree = new JPanel ( );
		this.ProtTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.ProtTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.HolyTree = new JPanel ( );
		this.HolyTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.HolyTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.TreeTabs = new JTabbedPane ( );
		this.TotalPanel.add ( this.TreeTabs );
		this.TreeTabs.addTab ( "Retri", this.RetriTree );
		this.TreeTabs.addTab ( "Prot", this.ProtTree );
		this.TreeTabs.addTab ( "Holy", this.HolyTree );

		//System.out.println ( "Viser current specc="+Class_Controller.Class_Model_Talents.CurrentSpecc );
		for ( int y = 1 ; y <= 11 ; y++ ) {
			for ( int x = 1 ; x <= 4 ; x++ ) {
				boolean RetriTalentAtSpot = false;
				boolean ProtTalentAtSpot = false;
				boolean HolyTalentAtSpot = false;
				Interface_Specc CurrentSpecc = Class_Controller.Get_CurrentSpecc();
				if ( CurrentSpecc.Get_Talents() != null ){
					for ( int z = 1 ; z < CurrentSpecc.Get_Talents().length ; z++ ) {
						Interface_Talent TempTalent = CurrentSpecc.Get_Talents()[z];
						if ( TempTalent != null ) {
							if ( TempTalent.Get_TreeCollumn() == x ) {
								if ( TempTalent.Get_TreeRow() == y ) {
									if ( TempTalent.Get_Tree().equals ( "Retri" ) ) {
										this.TalentSpot[z][1] = new JPanel ( );
										//System.out.println (TempTalent.Talentname+" har points="+TempTalent.GetTalentPoints()+" talent="+TempTalent);
										SpinnerNumberModel NumberVector = new SpinnerNumberModel ( 0, 0, TempTalent.Get_TalentPoints(), 1 );
										this.TalentSpinner[z][1] = new JSpinner ( NumberVector );
										this.TalentSpot[z][1].add ( this.TalentSpinner[z][1] );
										this.TalentSpot[z][1].add ( new JLabel ( new ImageIcon ( TempTalent.Get_TalentIconPath() ) ) );
										//System.out.println("Skal vise iconet "+TempTalent.TalentIcon+" for "+TempTalent.Talentname+" path="+TempTalent.TalentIconPath);
										this.TalentSpinner[z][1].setPreferredSize ( new Dimension ( 30, 40 ) );
										this.TalentSpinner[z][1].setAlignmentX ( Component.LEFT_ALIGNMENT );
										TalentSpinner[z][1].setEnabled ( false );
										LoadSpeccIntoSpinner ( TempTalent, this.TalentSpinner[z][1] );
										this.RetriTree.add ( this.TalentSpot[z][1] );
										RetriTalentAtSpot = true;
									}
									if ( TempTalent.Get_Tree().equals ( "Prot" ) ) {
										this.TalentSpot[z][2] = new JPanel ( );
										SpinnerNumberModel NumberVector = new SpinnerNumberModel ( 0, 0, TempTalent.Get_TalentPoints(), 1 );
										this.TalentSpinner[z][2] = new JSpinner ( NumberVector );
										this.TalentSpot[z][2].add ( this.TalentSpinner[z][2] );
										this.TalentSpot[z][2].add ( new JLabel ( new ImageIcon ( TempTalent.Get_TalentIconPath() ) ) );
										this.TalentSpinner[z][2].setPreferredSize ( new Dimension ( 30, 40 ) );
										this.TalentSpinner[z][2].setAlignmentX ( Component.LEFT_ALIGNMENT );
										TalentSpinner[z][2].setEnabled ( false );
										LoadSpeccIntoSpinner ( TempTalent, this.TalentSpinner[z][2] );
										this.ProtTree.add ( this.TalentSpot[z][2] );
										ProtTalentAtSpot = true;
									}
									if ( TempTalent.Get_Tree().equals ( "Holy" ) ) {
										this.TalentSpot[z][3] = new JPanel ( );
										SpinnerNumberModel NumberVector = new SpinnerNumberModel ( 0, 0, TempTalent.Get_TalentPoints(), 1 );
										this.TalentSpinner[z][3] = new JSpinner ( NumberVector );
										this.TalentSpot[z][3].add ( this.TalentSpinner[z][3] );
										this.TalentSpot[z][3].add ( new JLabel ( new ImageIcon ( TempTalent.Get_TalentIconPath() ) ) );
										this.TalentSpinner[z][3].setPreferredSize ( new Dimension ( 30, 40 ) );
										this.TalentSpinner[z][3].setAlignmentX ( Component.LEFT_ALIGNMENT );
										TalentSpinner[z][3].setEnabled ( false );
										LoadSpeccIntoSpinner ( TempTalent, this.TalentSpinner[z][3] );
										this.HolyTree.add ( this.TalentSpot[z][3] );
										HolyTalentAtSpot = true;
									}
								}
							}
						}
					}
				}
				if ( RetriTalentAtSpot == false ) {
					this.RetriTree.add ( new JLabel ( " " ) );
				}
				if ( ProtTalentAtSpot == false ) {
					this.ProtTree.add ( new JLabel ( " " ) );
				}
				if ( HolyTalentAtSpot == false ) {
					this.HolyTree.add ( new JLabel ( " " ) );
				}
			}
		}

	}

	private void LoadSpeccIntoSpinner ( Interface_Talent TempTalent, JSpinner PointSpinner ) {
		
		for ( int z = 1 ; z < TempTalent.Get_TalentPoints ( ) ; z++ ) {
			Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints().Get_Array_Names ( )[z];
			if ( TempPoint != null ) {
				if ( TempPoint.Get_Specced() == true ) {
					PointSpinner.setValue ( z );
				}
			}
		}
		
	}

}
