package Classrules;

import java.util.Date;
import Government.Govern_Controller;
import Standalone.Object_Stats;

public class Class_Controller {
	
	Govern_Controller Class_Govern_Controller;
	Class_Model Class_Class_Model;
	Model_CombatProcessor Class_Model_CombatProcessor;

	public Class_Controller ( String Class, Govern_Controller Class_Govern_Controller ) {

		this.Class_Govern_Controller = Class_Govern_Controller;
		Class_Class_Model = new Class_Model(Class);
		Class_Model_CombatProcessor = new Model_CombatProcessor();
		
	}

	public Object_Stats ConvertToCombatstats ( Object_Stats totalStats ) {
		return Class_Model_CombatProcessor.ConvertToCombatstats ( totalStats );
	}

	public Object_Stats Get_ClassBaseStats ( ) {
		return Class_Class_Model.Get_ClassBaseStats ( );
	}

}
