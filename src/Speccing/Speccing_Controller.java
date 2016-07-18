package Speccing;

import Government.Govern_Controller;
import Standalone.*;


public class Speccing_Controller {
	
	Govern_Controller Class_Govern_Controller;
	
	Speccing_Model Class_Speccing_Model;

	public Speccing_Controller ( Govern_Controller Class_Govern_Controller ) {

		this.Class_Govern_Controller = Class_Govern_Controller;
		
		Class_Speccing_Model = new Speccing_Model(this);
		
	}

	public Interface_Specc Get_CurrentSpecc ( ) {
		return Class_Speccing_Model.Get_CurrentSpecc ( );
	}

	public Interface_Specc[] Get_ClassSpeccs ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public void Call_CalculateAllSpeccDPS ( ) {

		// TODO Auto-generated method stub
		
	}

	public Interface_Specc Get_EditedSpecc ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public void Set_ComparedSpecc ( Interface_Specc get_EditedSpecc ) {

		// TODO Auto-generated method stub
		
	}

}
