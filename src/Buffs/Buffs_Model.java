package Buffs;


public class Buffs_Model {
	
	Buffs_Controller Class_Buffs_Controller;

	public Buffs_Model ( Buffs_Controller Class_Buffs_Controller ) {

		this.Class_Buffs_Controller = Class_Buffs_Controller;
		
	}

	public Object_BuffLibrary Get_BuffList ( ) {
		return new Object_BuffLibrary();
	}

}
