package Abilities;

import Standalone.*;

public class Abilities_Model {
	
	Abilities_Controller Class_Abilities_Controller;
	
	Object_AbilityLibrary DefaultLibrary;
	String Class;
	
	Object_ComparisonResult CurrentResults;
	

	public Abilities_Model ( Abilities_Controller Class_Abilities_Controller ) {

		this.Class_Abilities_Controller = Class_Abilities_Controller;
		CurrentResults = new Object_ComparisonResult();

	}
	
	private void CreateLibrary(String Class){
		
		this.Class = Class;
		//class abilities ink talented
		int ClassNumber = ClassAbilityNumber(Class);
		Superclass_Ability[] ClassAbilities = new Superclass_Ability[ClassNumber];
		for ( int X = 0 ; X < ClassAbilities.length ; X++ ){
			ClassAbilities[X] = CreateClassAbility(Class, X);
		}
		//abilities fra items, set bonuser, enchants
		Superclass_Ability[] BonusAbilities = new Superclass_Ability[0];
		DefaultLibrary = new Object_AbilityLibrary( ClassAbilities, BonusAbilities );
		
	}
	
	private int ClassAbilityNumber( String Class){
		
		if ( Class.equals ( "Paladin" )){
			return 10;
		}
		if ( Class.equals ( "Priest" )){
			return 1;
		}
		return 0;
	}
	
	private Superclass_Ability CreateClassAbility( String Class, int Number){
		
		for ( int X = 0 ; X < 20 ; X++ ){
			if ( X == Number ){
				if ( X == 0 ){
					Object_Ability_Heal New = new Object_Ability_Heal("Power Word: Shield");
					return New;
				}
			}
		}
		return null;
	}

	public String[] Get_AvailableSeals ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public Object_AbilityLibrary Get_NewAbilityLibrary ( ) {

		Object_AbilityLibrary NewAbilityLibrary = new Object_AbilityLibrary(DefaultLibrary.Get_ClassAbilities(), DefaultLibrary.Get_BonusAbilities());
		return NewAbilityLibrary;
	}

	public void CreateAbilities ( String Class ) {
		CreateLibrary(Class);
	}
	/*
	public void CalculateCurrent( Object_Stats Newstats) {
		
		double HPS_Amount = 0;
		double Oom_Amount = 0;
		double Healed_Amount = 0;
		
		Superclass_Ability[] Abilities = Get_NewAbilityLibrary ( ).Get_Abilities();
		for ( int A = 0 ; A < Abilities.length ; A++ ) {
			if ( Abilities[A] != null ) {
				Abilities[A].Calculate(Newstats);
				HPS_Amount = HPS_Amount + Abilities[A].Get_HPS();
				//System.out.println("totalt "+HPS_Amount);
			}
		}
		
		CurrentResults.Set_HPSUpgrade(HPS_Amount, 0);
		
	}
*/

}
