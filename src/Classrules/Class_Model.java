package Classrules;

import Standalone.Object_Stats;

public class Class_Model {
	
	String ChosenClass;

	public Class_Model ( String Class ) {

		ChosenClass = Class;
		
	}

	public Object_Stats Get_ClassBaseStats ( ) {
		
		Object_Stats BaseStats = new Object_Stats();

		if ( ChosenClass.equals ( "Paladin" )){
			BaseStats.AddStat ( "Strength", 170 );
			BaseStats.AddStat ( "Agility", 92 );
			BaseStats.AddStat ( "Stamina", 141 );
			BaseStats.AddStat ( "Intellect", 102 );
			BaseStats.AddStat ( "Spirit", 104 );
			BaseStats.AddStat ( "Mana", 3056 );
		}
		if ( ChosenClass.equals ( "Priest" )){
			BaseStats.AddStat ( "Strength", 33 );
			BaseStats.AddStat ( "Agility", 43 );
			BaseStats.AddStat ( "Stamina", 52 );
			BaseStats.AddStat ( "Intellect", 150 );
			BaseStats.AddStat ( "Spirit", 139 );
			BaseStats.AddStat ( "Mana", 1469 );
		}
		return BaseStats;
	}

}
