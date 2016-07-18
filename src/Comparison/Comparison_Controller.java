package Comparison;

import Abilities.Object_AbilityLibrary;
import Buffs.Object_BuffLibrary;
import Government.Govern_Controller;
import Standalone.*;


public class Comparison_Controller {
	
	Govern_Controller Class_Govern_Controller;
	Comparison_Model Class_Comparison_Model;

	public Comparison_Controller ( Govern_Controller Class_Govern_Controller ) {

		this.Class_Govern_Controller = Class_Govern_Controller;
		Class_Comparison_Model = new Comparison_Model(this);
		
	}
	
	public void Call_NewComparison ( ) {

		// TODO Auto-generated method stub
		
	}

	public void Call_CalculateComparisonDPS ( ) {

		// TODO Auto-generated method stub
		
	}

	public void Call_EditedSpecc ( String text ) {

		// TODO Auto-generated method stub
		
	}

	public void UserCommand_ResetComparisonstats ( ) {

		// TODO Auto-generated method stub
		
	}

	public void Call_ComparingWindowComparison ( ) {

		this.Class_Comparison_Model.Call_ComparingWindowComparison ( );
		
	}

	public void Call_CalculateAllComboDPS ( ) {

		// TODO Auto-generated method stub
		
	}

	public void Call_SpeccPoint ( Interface_TalentPoint interface_TalentPoint ) {

		// TODO Auto-generated method stub
		
	}

	public boolean UserCommand_SaveSpecc ( String text ) {

		// TODO Auto-generated method stub
		return false;
	}

	public boolean UserCommand_LoadSpecc ( String string ) {

		// TODO Auto-generated method stub
		return false;
	}

	public void Set_DPSUpgrade ( ) {

		// TODO Auto-generated method stub
		
	}

	public String Get_DPSUpgrade ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public String Get_DPSUpgradePrcnt ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public StatValues Get_StatValues ( ) {

		// TODO Auto-generated method stub
		return null;
	}
	
	public void CalculateStatvalues(){
		this.Class_Comparison_Model.CalculateStatvalues();
	}

	public void ShowStatValues ( StatValues statVerdiene ) {
		this.Class_Govern_Controller.Call_ShowStatValues ( statVerdiene );
	}

	public Object_Stats Get_CurrentTotaltstats ( ) {
		return this.Class_Govern_Controller.Get_CurrentTotalstats ( );
	}

	public Object_Stats Get_ChangedStats ( ) {
		return this.Class_Govern_Controller.Get_UsercomparisonChangedstats ( );
	}

	public Object_Stats Call_ConvertToCombatstats ( Object_Stats oldstats ) {
		return this.Class_Govern_Controller.ConvertToCombatstats ( oldstats );
	}

	public void Call_SetComparedStats ( Object_Stats newstats, Object_ComparisonResult Results ) {
		this.Class_Govern_Controller.Call_SetComparedStats ( newstats, Results );
	}

	public Object_AbilityLibrary Get_NewAbilityLibrary ( ) {
		return Class_Govern_Controller.Get_NewAbilityLibrary ( );
	}

	public void UpgradesUpdated ( StatValues statVerdiene ) {
		this.Class_Govern_Controller.UpgradesUpdated ( statVerdiene );
	}

	public Object_Stats Get_BaseStats ( ) {
		return this.Class_Govern_Controller.Get_CharBasestats ( );
	}

	public Interface_Specc Get_CurrentSpecc ( ) {
		return Class_Govern_Controller.Get_CurrentSpecc ( );
	}

	public Object_BuffLibrary Get_Buffs ( ) {
		return Class_Govern_Controller.Get_BuffList();
	}

	public void Call_CalculateCurrentDPS ( ) {
		this.Class_Comparison_Model.CalculateCurrent ( );
	}

	public Object_ComparisonResult Get_CurrentHeal() {
		return Class_Comparison_Model.Get_CurrentHeal();
	}

}
