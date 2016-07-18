package Speccing;

import Standalone.Interface_Specc;


public class Speccing_Model {
	
	Object_Base_Specc BaseSpecc;

	public Speccing_Model ( Speccing_Controller speccing_Controller ) {

		BaseSpecc = new Object_Base_Specc();
	}

	public Interface_Specc Get_CurrentSpecc ( ) {

		return BaseSpecc;
	}

}
