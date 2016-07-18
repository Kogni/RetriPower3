package Abilities;

import Government.Govern_Controller;
import Standalone.*;

public class Abilities_Controller {
	
	Govern_Controller Class_Govern_Controller;
	
	Abilities_Model Class_Abilities_Model;

	public Abilities_Controller ( Govern_Controller Class_overn_Controller ) {
		this.Class_Govern_Controller = Class_overn_Controller;
		Class_Abilities_Model = new Abilities_Model(this);
	}

	public Object Get_Seal ( String currComp ) {

		// TODO Auto-generated method stub
		return null;
	}

	public void UserCommand_ChangeActiveSeal ( String newSelect_Seal ) {

		// TODO Auto-generated method stub
		
	}

	public String[] Get_AvailableSeals ( ) {
		return Class_Abilities_Model.Get_AvailableSeals ( );
	}

	public Object_AbilityLibrary Get_NewAbilityLibrary ( ) {
		return Class_Abilities_Model.Get_NewAbilityLibrary ( );
	}

	public String Get_Class ( ) {
		return this.Class_Govern_Controller.Get_PlayerClass ( );
	}

	public void CreateAbilities ( String Class ) {
		Class_Abilities_Model.CreateAbilities ( Class );
	}

}
