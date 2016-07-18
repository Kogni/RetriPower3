package Speccing;

import java.awt.event.*;
import javax.swing.*;
import Standalone.*;
import Abilities.*;

public class Object_Specc implements ActionListener, Interface_Specc {
	
	Speccing_Controller Class_Controller;
	
	public String Name;
	private String Class;
	private double DPS;
	public boolean Current = false;
	
	private int								TalentPoints			= 0;

	private int								TalentNumber			= 0;
	public	Object_Talent[]						Talents					= new Object_Talent[50];
	
	private JButton							RespeccButton 			= new JButton("Respecc");
	
	
	public Object_Specc( String Name, String Class, Object_Base_Specc BaseTalents, Speccing_Controller Class_Controller ){
		
		this.Name = Name;
		this.Class_Controller = Class_Controller;
		this.Class = Class;
		
		Get_RespeccButton().addActionListener ( this );
		
	}

	public void TalentBrain_ApplyTalentsToStats ( Object_Stats preSpeccStats, Object_Stats speccStats ) {
		
		for ( int B = 1 ; B < Talents.length ; B++ ) {
			if ( Talents[B] != null ){
				Object_Talent Current_Talent = Talents[B];
				
				//Thread_TalentpointApply NyThread = new Thread_TalentpointApply();
				//NyThread.ApplyTalentsToStats(Current_Talent, preSpeccStats, speccStats );
				Object_TalentPoint[] TalentPoints = ( Object_TalentPoint[] ) Current_Talent.Get_Capsule_TalentPoints().Get_Array_Names();
				
				for ( int C = 1 ; C < TalentPoints.length ; C++ ) {
					if ( TalentPoints[C] != null ){
						if ( TalentPoints[C].Get_Specced() ){
							TalentPoints[C].Call_ApplyStatBonus ( preSpeccStats, speccStats );
						}
					}
				}
				
			}
		}

	}

	public void TalentSpecc_ApplyTalentsToAbility ( Interface_Ability EnAbility ) {

		for ( int B = 1 ; B < Talents.length ; B++ ) {
			if ( Talents[B] != null ){
				Object_Talent Current_Talent = Talents[B];
				
				//Thread_TalentpointApply NyThread = new Thread_TalentpointApply();
				//NyThread.ApplyTalentsToAbility(Current_Talent, EnAbility );
				Object_TalentPoint[] TalentPoints = ( Object_TalentPoint[] ) Current_Talent.Get_Capsule_TalentPoints().Get_Array_Names();
				
				for ( int C = 1 ; C < TalentPoints.length ; C++ ) {
					if ( TalentPoints[C] != null ){
						if ( TalentPoints[C].Get_Specced() ){
							TalentPoints[C].Call_ApplyAbilityBonus ( EnAbility );
						}
					}
				}
				
			}
		}

	}
/*
	public void actionPerformed ( ActionEvent e ) {

		boolean Successful = Class_Controller.UserCommand_SpeccChange ( getRespeccButton() );
		if ( Successful == true ){
			Class_Controller.Class_View_Speccing.SetStatusText("Successfully respecced to "+this.Name);
		} else {
			Class_Controller.Class_View_Speccing.SetStatusText("Error: Could not respecc to "+this.Name);
		}
		
	}
*/
	public void setTalentPoints ( int talentPoints ) {
		TalentPoints = talentPoints;
	}

	public int getTalentPoints ( ) {
		return TalentPoints;
	}

	public void setTalentNumber ( int talentNumber ) {
		TalentNumber = talentNumber;
	}

	public int Get_TalentNumber ( ) {
		return TalentNumber;
	}

	public void Set_RespeccButton ( JButton respeccButton ) {
		RespeccButton = respeccButton;
	}

	public double Get_DPS ( ) {
		return DPS;
	}

	public String Get_Name ( ) {
		return Name;
	}

	public JButton Get_RespeccButton ( ) {
		return RespeccButton;
	}

	public Interface_Talent[] Get_Talents ( ) {
		return Talents;
	}

	public void ApplySpecc ( Object_Stats PreSpeccStats, Object_Stats SpeccBonusStats, Object_AbilityLibrary abilities ) {

		Superclass_Ability[] Abilities = abilities.Get_Abilities();
		for ( int TalentID = 0 ; TalentID < Talents.length ; TalentID++ ){
			Object_TalentPoint[] Talentpoints = Talents[TalentID].Get_Talentpoints ( );
			for ( int TalentPointID = 0 ; TalentPointID < Talentpoints.length ; TalentPointID++ ){
				for ( int AbilityID = 0 ; AbilityID < Abilities.length ; AbilityID++ ){
					Talentpoints[TalentPointID].Call_ApplyAbilityBonus ( Abilities[AbilityID] );
					Talentpoints[TalentPointID].Call_ApplyStatBonus ( PreSpeccStats, SpeccBonusStats );
				}
			}
		}
		
	}

	public void actionPerformed ( ActionEvent e ) {

		// TODO Auto-generated method stub
		
	}

}
