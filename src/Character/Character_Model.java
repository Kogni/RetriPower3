package Character;

import Classrules.*;
import Standalone.*;


public class Character_Model {
	
	Character_Controller Class_Character_Controller;
	Object_Unit Character_Current;

	public Character_Model ( Character_Controller Class_Character_Controller, String Class ) {

		this.Class_Character_Controller = Class_Character_Controller;
		if ( Class.equals("Priest")) {
			Character_Current = new Object_Priest( Class, Class_Character_Controller.Get_ClassBaseStats() );
		}
		
		ConvertToCombatstats();
	}
	
	private void ConvertToCombatstats(){
		Character_Current.Set_Combatstats ( Class_Character_Controller.ConvertToCombatstats(Character_Current.Get_Combatstats ( )));
		Character_Current.Set_UserChangeCombatStats( Class_Character_Controller.ConvertToCombatstats(Character_Current.Get_UsercomparisonCombatstats ( )) );
	}

	public Object_Stats Get_CharBasestats ( ) {
		return Character_Current.Get_CharBasestats ( );
	}

	public Object_Stats Get_CurrentGearstats ( ) {
		return Character_Current.Get_Gearstats ( );
	}

	public Object_Stats Get_CurrentTotalstats ( ) {
		return Character_Current.Get_Totalstats ( );
	}

	public Object_Stats Get_CurrentCombatstats ( ) {
		return Character_Current.Get_Combatstats ( );
	}

	public String[] Get_CharSlots ( ) {
		return Character_Current.Get_CharSlots ( );
	}

	public Object_Stats Get_UsercomparisonBuffstats ( ) {
		return Character_Current.Get_UsercomparisonBuffstats ( );
	}

	public Object_Stats Get_CurrentGemStats ( ) {
		return Character_Current.Get_CurrentGemStats ( );
	}

	public Object_Stats Get_CurrentEnchStats ( ) {
		return Character_Current.Get_CurrentEnchStats ( );
	}

	public Object_Stats Get_CurrentSpeccStats ( ) {
		return Character_Current.Get_CurrentSpeccStats ( );
	}

	public Object_Stats Get_UsercomparisonCombatstats ( ) {
		return Character_Current.Get_UsercomparisonCombatstats ( );
	}

}
