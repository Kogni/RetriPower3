package Character;

import java.util.Date;
import Government.Govern_Controller;
import Standalone.Object_Stats;


public class Character_Controller {
	
	Govern_Controller Class_Govern_Controller;
	Character_Model Class_Character_Model;

	public Character_Controller ( Govern_Controller Class_Govern_Controller ) {

		this.Class_Govern_Controller = Class_Govern_Controller;
		
	}

	public Object_Stats Get_CharBasestats ( ) {
		return Class_Character_Model.Get_CharBasestats ( );
	}

	public Object_Stats Get_CurrentGearstats ( ) {
		return Class_Character_Model.Get_CurrentGearstats ( );
	}

	public Object_Stats Get_CurrentTotalstats ( ) {
		return Class_Character_Model.Get_CurrentTotalstats ( );
	}

	public Object_Stats Get_UsercomparisonCombatstats ( ) {
		return Class_Character_Model.Get_UsercomparisonCombatstats ( );
	}

	public Object_Stats Get_CurrentCombatstats ( ) {
		return Class_Character_Model.Get_CurrentCombatstats ( );
	}

	public Object_Stats Get_UsercomparisonBuffstats ( ) {
		return Class_Character_Model.Get_UsercomparisonBuffstats ( );
	}

	public String[] Get_CharSlots ( ) {
		return Class_Character_Model.Get_CharSlots ( );
	}

	public String Get_PlayerClass ( ) {
		return this.Class_Govern_Controller.Get_PlayerClass ( );
	}

	public void MakePlayer ( String Class ) {
		Class_Character_Model = new Character_Model(this, Class);
	}

	public Object_Stats Get_CurrentGemStats ( ) {
		return Class_Character_Model.Get_CurrentGemStats ( );
	}

	public Object_Stats Get_CurrentEnchStats ( ) {
		return Class_Character_Model.Get_CurrentEnchStats ( );
	}

	public Object_Stats Get_CurrentSpeccStats ( ) {
		return Class_Character_Model.Get_CurrentSpeccStats ( );
	}

	public Object_Stats Get_ClassBaseStats ( ) {
		return this.Class_Govern_Controller.Get_ClassBaseStats ( );
	}

	public Object_Stats ConvertToCombatstats ( Object_Stats get_Combatstats ) {
		//System.out.println(new Date()+" 1- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		return Class_Govern_Controller.ConvertToCombatstats ( get_Combatstats );
	}

}
