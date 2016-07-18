package Speccing;

import javax.swing.JButton;
import Abilities.Object_AbilityLibrary;
import Standalone.*;


public class Object_Base_Specc implements Interface_Specc {
	
	Object_Talent[] DefaultTalents;
	
	public Object_Base_Specc(){
		
	}

	public double Get_DPS ( ) {

		// TODO Auto-generated method stub
		return 0;
	}

	public String Get_Name ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public JButton Get_RespeccButton ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public Interface_Talent[] Get_Talents ( ) {

		// TODO Auto-generated method stub
		return DefaultTalents;
	}

	public void ApplySpecc ( Object_Stats PreSpeccStats, Object_Stats SpeccBonusStats, Object_AbilityLibrary abilities ) {

		// TODO Auto-generated method stub
		
	}

}
