package GUI.Speccing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import GUI.*;
import Standalone.*;

public class Panel_TalentEditing extends JPanel implements ChangeListener, ActionListener {

	private GUI_Controller					Class_Controller;

	public JPanel				TotalPanel = new JPanel();
	
	private JPanel						OptionPanel = new JPanel();
	private JTextField					SaveSpeccName = new JTextField("");
	private JButton						SaveButton = new JButton("Save specc");
	private JComboBox					LoadSpeccName = new JComboBox();
	private JButton						LoadButton = new JButton("Load specc");
	
	private JPanel						SpeccOverview = new JPanel();
	private JPanel[]					OverviewCollumn		= new JPanel[6];
	private JLabel						TalentPoints;
	private JLabel						UnusedPints;
	private JLabel						RetriPoints;
	private JLabel						ProtPoints;
	private JLabel						HolyPoints;
	
	private JTabbedPane					TreeTabs = new JTabbedPane ( );
	private JPanel						RetriTree;
	private JPanel						ProtTree;
	private JPanel						HolyTree;
	private JPanel[][]					TalentSpot			= new JPanel[50][4];
	private JSpinner[][]				TalentSpinner		= new JSpinner[50][4];

	private int							RetriPointsSpecced				= 0;
	private int							Prot				= 0;
	private int							Holy				= 0;
	private int							TotalPoints			= 0;
	private int							UsedPoints			= 0;
	private int							UnusedPoints		= 0;
	private JLabel						SpeccDPSUpgrade = new JLabel("+0");
	private JLabel						SpeccDPSUpgradePrcnt = new JLabel("+0%");

	private boolean						HibernateListeners	= true;
	
	

	public Panel_TalentEditing ( GUI_Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		Startup();
		
	}

	public void Startup ( ) {

		add(TotalPanel);
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

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
		
		this.OverviewCollumn[5].add ( new JLabel ( "DPS: " ) );
		this.OverviewCollumn[5].add ( SpeccDPSUpgrade );
		this.OverviewCollumn[5].add ( SpeccDPSUpgradePrcnt );

		this.RetriTree = new JPanel ( );
		this.RetriTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.RetriTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.ProtTree = new JPanel ( );
		this.ProtTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.ProtTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.HolyTree = new JPanel ( );
		this.HolyTree.setLayout ( new GridLayout ( 11, 4 ) );
		this.HolyTree.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		this.TotalPanel.add ( this.TreeTabs );
		this.TreeTabs.addTab ( "Retri", this.RetriTree );
		this.TreeTabs.addTab ( "Prot", this.ProtTree );
		this.TreeTabs.addTab ( "Holy", this.HolyTree );

		for ( int y = 1 ; y <= 11 ; y++ ) {
			for ( int x = 1 ; x <= 4 ; x++ ) {
				boolean RetriTalentAtSpot = false;
				boolean ProtTalentAtSpot = false;
				boolean HolyTalentAtSpot = false;
				Interface_Specc EditedSpecc = Class_Controller.Get_EditedSpecc ( );
				if ( EditedSpecc != null ){
					for ( int z = 1 ; z < EditedSpecc.Get_Talents().length ; z++ ) {
						Interface_Talent TempTalent = EditedSpecc.Get_Talents()[z];
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
										this.TalentSpinner[z][1].addChangeListener ( this );
										this.TalentSpinner[z][1].setAlignmentX ( Component.LEFT_ALIGNMENT );
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
										this.TalentSpinner[z][2].addChangeListener ( this );
										this.TalentSpinner[z][2].setAlignmentX ( Component.LEFT_ALIGNMENT );
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
										this.TalentSpinner[z][3].addChangeListener ( this );
										this.TalentSpinner[z][3].setAlignmentX ( Component.LEFT_ALIGNMENT );
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
		
		TotalPanel.add ( OptionPanel );
		OptionPanel.setLayout ( new BoxLayout ( OptionPanel, BoxLayout.PAGE_AXIS ) );
		JPanel Line1 = new JPanel();
		Line1.setLayout ( new BoxLayout ( Line1, BoxLayout.LINE_AXIS ) );
		Line1.add ( new JLabel("Specc name: ") );
		Line1.add ( SaveSpeccName );
		Line1.add ( SaveButton );
		OptionPanel.add ( Line1 );
		JPanel Line2 = new JPanel();
		Line2.setLayout ( new BoxLayout ( Line2, BoxLayout.LINE_AXIS ) );
		Line2.add ( new JLabel("Specc name: ") );
		Line2.add ( LoadSpeccName );
		Line2.add ( LoadButton );
		OptionPanel.add ( Line2 );

		SaveButton.addActionListener ( this );
		LoadButton.addActionListener ( this );
		
		this.HibernateListeners = false;
		Update ( );
	}

	private void LoadSpeccIntoSpinner ( Interface_Talent TempTalent, JSpinner PointSpinner ) {
		
		for ( int z = 1 ; z < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; z++ ) {
			Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints().Get_Array_Names ( )[z];
			if ( TempPoint != null ) {
				if ( TempPoint.Get_Specced() == true ) {
					PointSpinner.setValue ( z );
				}
			}
		}
		
	}

	public void Update ( ) {
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		//System.out.println ("Updating TalentEditing");
		
		LoadSpeccName.removeAllItems ( );
		Interface_Specc[] Speccs = Class_Controller.Get_ClassSpeccs ( );
		if ( Speccs != null ){
			for ( int A = 1 ; A < Speccs.length ; A++ ) {
				if ( Speccs[A] != null ){
					LoadSpeccName.addItem ( Speccs[A].Get_Name() );
				}
			}
		}
		
		
		this.RetriPointsSpecced = 0;
		this.Prot = 0;
		this.Holy = 0;
		this.TotalPoints = 0;
		this.UsedPoints = 0;
		this.UnusedPoints = 0;
		
		Interface_Specc Processed_Specc = Class_Controller.Get_EditedSpecc ( );
		//System.out.println ("Edited specc name="+Processed_Specc.Name);
		if ( Processed_Specc != null ){
			Interface_Talent[] Talents = Processed_Specc.Get_Talents();
			if ( Talents != null ){
				for ( int A = 1 ; A < Talents.length ; A++ ) {
					if ( Talents[A] != null ){
						Interface_Talent Processed_Talent = Talents[A];
						Capsule Processed_Capsule = Processed_Talent.Get_Capsule_TalentPoints ( );
						for ( int B = 1 ; B < Processed_Capsule.Get_Array_Names ( ).length ; B++ ) {
							Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) Processed_Capsule.Get_Array_Names ( )[B];
							if ( TempPoint != null ) {
								//System.out.println ("Talent="+Processed_Talent.Talentname+" #"+B+" specced="+TempPoint.Specced);
								if ( TempPoint.Get_Tree().equals ( "Retri" ) ) {
									if ( TempPoint.Get_Specced() == true ) {
										this.RetriPointsSpecced++;
									}
								}
								if ( TempPoint.Get_Tree().equals ( "Prot" ) ) {
									if ( TempPoint.Get_Specced() == true ) {
										this.Prot++;
									}
								}
								if ( TempPoint.Get_Tree().equals ( "Holy" ) ) {
									if ( TempPoint.Get_Specced() == true ) {
										this.Holy++;
									}
								}
							}
						}
					}
				}
			}
		}

		this.TotalPoints = 71;
		this.UsedPoints = ( this.RetriPointsSpecced + this.Prot + this.Holy );
		this.UnusedPoints = this.TotalPoints - this.UsedPoints;
		this.TalentPoints.setText ( 71 + "" );
		this.UnusedPints.setText ( ( 71 - this.UsedPoints ) + "" );
		this.RetriPoints.setText ( this.RetriPointsSpecced + "" );
		this.ProtPoints.setText ( this.Prot + "" );
		this.HolyPoints.setText ( this.Holy + "" );

		for ( int y = 1 ; y <= 11 ; y++ ) {
			for ( int x = 1 ; x <= 4 ; x++ ) {
				Interface_Specc EditedSpecc = Class_Controller.Get_EditedSpecc ( );
				if ( EditedSpecc != null ){
					Interface_Talent[] Talents = EditedSpecc.Get_Talents();
					for ( int z = 1 ; z < Talents.length ; z++ ) {
						Interface_Talent TempTalent = Talents[z];
						if ( TempTalent != null ) {
							if ( TempTalent.Get_TreeCollumn() == x ) {
								if ( TempTalent.Get_TreeRow() == y ) {
									if ( TempTalent.Get_Tree().equals ( "Retri" ) ) {
										ColorSpeccstatus ( this.TalentSpot[z][1], TempTalent );
									}
									if ( TempTalent.Get_Tree().equals ( "Prot" ) ) {
										ColorSpeccstatus ( this.TalentSpot[z][2], TempTalent );
									}
									if ( TempTalent.Get_Tree().equals ( "Holy" ) ) {
										ColorSpeccstatus ( this.TalentSpot[z][3], TempTalent );
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private void ColorSpeccstatus ( JPanel TalentPanel, Interface_Talent TempTalent ) {
		//System.out.println ("Updating talent specc color");
		if ( this.UnusedPoints == 0 ) {
			TalentPanel.setBackground ( Color.red );
		}
		boolean FoundUnspecced = false;
		boolean NextPointSpeccable = true;
		for ( int y = 1 ; y < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; y++ ) {
			if ( TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] != null ) {
				if ( FoundUnspecced == false ) {
					if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_Specced() == true ) {
						TalentPanel.setBackground ( Color.cyan );
					} else {
						FoundUnspecced = true;
						if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredCharLevel() > 80 ) {
							TalentPanel.setBackground ( Color.red );
							NextPointSpeccable = false;
						}
						if ( TempTalent.Get_Tree().equals ( "Retri" ) ) {
							if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredSpentTreePoints() > this.RetriPointsSpecced ) {
								TalentPanel.setBackground ( Color.red );
								NextPointSpeccable = false;
							}
						}
						if ( TempTalent.Get_Tree().equals ( "Prot" ) ) {
							if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredSpentTreePoints() > this.Prot ) {
								TalentPanel.setBackground ( Color.red );
								NextPointSpeccable = false;
							}
						}
						if ( TempTalent.Get_Tree().equals ( "Holy" ) ) {
							if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredSpentTreePoints() > this.Holy ) {
								TalentPanel.setBackground ( Color.red );
								NextPointSpeccable = false;
							}
						}
						if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredTalentPoint() != null ) {
							if ( ((Interface_TalentPoint)TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y]).Get_RequiredTalentPoint().Get_Specced() == false ) {
								TalentPanel.setBackground ( Color.magenta );
								NextPointSpeccable = false;
							}
						}
						if ( NextPointSpeccable == true ) {
							TalentPanel.setBackground ( Color.green );
						}
					}
				}
			}
		}
	}

	public void stateChanged ( ChangeEvent E ) {
		//System.out.println ("State changed");
		if ( this.HibernateListeners == false ) {
			
			if ( E == null ) {
				
				HibernateListeners = true;
				for ( int y = 1 ; y <= 11 ; y++ ) {
					for ( int x = 1 ; x <= 4 ; x++ ) {
						for ( int z = 1 ; z < this.Class_Controller.Get_EditedSpecc ( ).Get_Talents().length ; z++ ) {
							if ( TalentSpinner[z][1] != null ){
								TalentSpinner[z][1].setValue ( 0 );
							}
							if ( TalentSpinner[z][2] != null ){
								TalentSpinner[z][2].setValue ( 0 );
							}
							if ( TalentSpinner[z][3] != null ){
								TalentSpinner[z][3].setValue ( 0 );
							}
						}
					}
				}
				
				for ( int y = 1 ; y <= 11 ; y++ ) {
					for ( int x = 1 ; x <= 4 ; x++ ) {
						for ( int z = 1 ; z < this.Class_Controller.Get_EditedSpecc ( ).Get_Talents().length ; z++ ) {
							Interface_Talent TempTalent = this.Class_Controller.Get_EditedSpecc ( ).Get_Talents()[z];
							if ( TempTalent != null ) {
								if ( TempTalent.Get_TreeCollumn() == x ) {
									if ( TempTalent.Get_TreeRow() == y ) {
										
										if ( TempTalent.Get_Tree().equals ( "Retri" ) ) {
											for ( int A = 1 ; A < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; A++ ) {
												Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[A];
												if ( TempPoint != null ) {
													if ( TempPoint.Get_Specced() == true ) {
														TalentSpinner[z][1].setValue ( A );
													}
												}
											}
										}
										if ( TempTalent.Get_Tree().equals ( "Prot" ) ) {
											for ( int A = 1 ; A < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; A++ ) {
												Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[A];
												if ( TempPoint != null ) {
													if ( TempPoint.Get_Specced() == true ) {
														TalentSpinner[z][2].setValue ( A );
													}
												}
											}
										}
										if ( TempTalent.Get_Tree().equals ( "Holy" ) ) {
											for ( int A = 1 ; A < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; A++ ) {
												Interface_TalentPoint TempPoint = ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[A];
												if ( TempPoint != null ) {
													if ( TempPoint.Get_Specced() == true ) {
														TalentSpinner[z][3].setValue ( A );
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				HibernateListeners = false;
				
			} else {
				
				for ( int z = 1 ; z < this.Class_Controller.Get_EditedSpecc ( ).Get_Talents().length ; z++ ) {
					Interface_Talent TempTalent = this.Class_Controller.Get_EditedSpecc ( ).Get_Talents()[z];
					if ( TempTalent != null ) {
						if ( E != null ){
							if ( E.getSource ( ) == this.TalentSpinner[z][1] ) {
								SpeccIfSpeccable ( TempTalent, Integer.parseInt ( this.TalentSpinner[z][1].getValue ( ).toString ( ) ), this.TalentSpinner[z][1] );
							}
							if ( E.getSource ( ) == this.TalentSpinner[z][2] ) {
								SpeccIfSpeccable ( TempTalent, Integer.parseInt ( this.TalentSpinner[z][2].getValue ( ).toString ( ) ), this.TalentSpinner[z][2] );
							}
							if ( E.getSource ( ) == this.TalentSpinner[z][3] ) {
								SpeccIfSpeccable ( TempTalent, Integer.parseInt ( this.TalentSpinner[z][3].getValue ( ).toString ( ) ), this.TalentSpinner[z][3] );
							}
						}
					}
				}
			}
			Update();
		}
		this.Class_Controller.Call_NewComparison ( );
		this.Class_Controller.Set_ComparedSpecc ( Class_Controller.Get_EditedSpecc ( ) );
		Class_Controller.Call_CalculateComparisonDPS ( );
		Class_Controller.Set_DPSUpgrade ( );
		SpeccDPSUpgrade.setText ( "+"+Class_Controller.Get_DPSUpgrade ( ) );
		SpeccDPSUpgradePrcnt.setText ( "+"+Class_Controller.Get_DPSUpgradePrcnt ( )+"%" );
	}

	private void SpeccIfSpeccable ( Interface_Talent TempTalent, int SelectedPoint, JSpinner PointSpinner ) {
		//System.out.println ("Speccing talent points");
		boolean Speccable = true;
		for ( int y = 1 ; y < TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; y++ ) {
			if ( TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] != null ) {
				//System.out.println ("Sjekker talent point for speccing");
				if ( y > SelectedPoint ) {
					if ( y == ( SelectedPoint + 1 ) ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_Specced() == true ) {
							if ( SjekkUnspeccable ( TempTalent, y ) == true ) {
								this.UnusedPoints++;
								Class_Controller.Call_SpeccPoint( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] );
								//TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y].Set_Specced(false);
							} else {
								this.HibernateListeners = true;
								PointSpinner.setValue ( ( SelectedPoint + 1 ) );
								this.HibernateListeners = false;
							}
						}
					}
				} else if ( y < SelectedPoint ) {
					Class_Controller.Call_SpeccPoint( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] );
					//TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y].Get_Specced() = true;
				} else if ( y == SelectedPoint ) {
					if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredCharLevel() > 80 ) {
						Speccable = false;
						System.out.println ("A Not speccable");
					}
					if ( TempTalent.Get_Tree().equals ( "Retri" ) ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() > this.RetriPointsSpecced ) {
							Speccable = false;
							System.out.println ("B Not speccable");
						}
					}
					if ( TempTalent.Get_Tree().equals ( "Prot" ) ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() > this.Prot ) {
							Speccable = false;
							System.out.println ("C Not speccable");
						}
					}
					if ( TempTalent.Get_Tree().equals ( "Holy" ) ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() > this.Holy ) {
							Speccable = false;
							System.out.println ("D Not speccable");
						}
					}
					if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredTalentPoint() != null ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredTalentPoint().Get_Specced() == false ) {
							Speccable = false;
							System.out.println ("E Not speccable");
						}
					}
					if ( Speccable == true ) {
						if ( ( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_Specced() == true ) {

						} else {
							if ( this.UnusedPoints > 0 ) {
								Class_Controller.Call_SpeccPoint( ( Interface_TalentPoint ) TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] );
								//TempTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y].Get_Specced() = true;
							} else {
								this.HibernateListeners = true;
								PointSpinner.setValue ( ( y - 1 ) );
								System.out.println ("A Not speccable, removing point");
								this.HibernateListeners = false;
							}
						}
					} else {
						this.HibernateListeners = true;
						PointSpinner.setValue ( ( y - 1 ) );
						System.out.println ("B Not speccable, removing point");
						this.HibernateListeners = false;
					}

				}
			}
		}
		this.Class_Controller.Call_EditedSpecc ( SaveSpeccName.getText ( ) );
	}

	private boolean SjekkUnspeccable ( Interface_Talent UnspeccTalent, int UnspeccPoint ) {
		//System.out.println ("Checking if speccable");
		boolean Unspeccable = true;
		int Unspecced_Retri = this.RetriPointsSpecced;
		int Unspecced_Prot = this.Prot;
		int Unspecced_Holy = this.Holy;
		if ( UnspeccTalent.Get_Tree().equals ( "Retri" ) ) {
			Unspecced_Retri--;
		} else if ( UnspeccTalent.Get_Tree().equals ( "Prot" ) ) {
			Unspecced_Prot--;
		} else if ( UnspeccTalent.Get_Tree().equals ( "Holy" ) ) {
			Unspecced_Holy--;
		}
		for ( int z = 1 ; z < this.Class_Controller.Get_EditedSpecc ( ).Get_Talents().length ; z++ ) {
			Interface_Talent CheckTalent = this.Class_Controller.Get_EditedSpecc ( ).Get_Talents()[z];
			if ( CheckTalent != null ) {
				for ( int y = 1 ; y < CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( ).length ; y++ ) {
					if ( CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] != null ) {
						if ( ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_Specced() == true ) {
							if ( ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredTalentPoint() != null ) {
								if ( ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredTalentPoint() == UnspeccTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[UnspeccPoint] ) {
									Unspeccable = false;
								}
							}
							if ( CheckTalent.Get_Tree().equals ( "Retri" ) ) {
								if ( Unspecced_Retri < ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() ) {
									Unspeccable = false;
								}
							}
							if ( CheckTalent.Get_Tree().equals ( "Prot" ) ) {
								if ( Unspecced_Prot < ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() ) {
									Unspeccable = false;
								}
							}
							if ( CheckTalent.Get_Tree().equals ( "Holy" ) ) {
								if ( Unspecced_Holy < ( ( Interface_TalentPoint ) CheckTalent.Get_Capsule_TalentPoints ( ).Get_Array_Names ( )[y] ).Get_RequiredSpentTreePoints() ) {
									Unspeccable = false;
								}
							}
						}
					}
				}
			}
		}
		return Unspeccable;
	}

	public void actionPerformed ( ActionEvent e ) {

		if ( e.getSource ( ) == SaveButton ){
			boolean Success = Class_Controller.UserCommand_SaveSpecc ( SaveSpeccName.getText ( ) );
			if ( Success == true ){
				Class_Controller.SetStatusText ( "Specc saved successfully" );
			} else {
				Class_Controller.SetStatusText ( "Error: Specc could not be saved" );
			}
		}
		if ( e.getSource ( ) == LoadButton ){
			boolean Success = Class_Controller.UserCommand_LoadSpecc ( LoadSpeccName.getSelectedItem ( ).toString ( ) );
			if ( Success == true ){
				Class_Controller.SetStatusText( "Specc loaded successfully" );
			} else {
				Class_Controller.SetStatusText( "Error: Specc could not be loaded" );
			}
		}
		
	}

}
