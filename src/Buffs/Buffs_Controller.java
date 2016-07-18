package Buffs;

import Government.Govern_Controller;

public class Buffs_Controller {
	
	Govern_Controller Class_Govern_Controller;
	Buffs_Model Class_Buffs_Model;

	public Buffs_Controller ( Govern_Controller Class_Govern_Controller ) {

		this.Class_Govern_Controller = Class_Govern_Controller;
		Class_Buffs_Model = new Buffs_Model(this);
		
	}

	public Object_BuffLibrary Get_BuffList ( ) {
		return Class_Buffs_Model.Get_BuffList ( );
	}

}
