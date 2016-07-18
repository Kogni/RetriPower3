package Abilities;

import Standalone.Interface_Ability;
import Standalone.Object_Stats;

public class Object_AbilityLibrary {
	
	//skal inneholde samtlige abilities en karakter bruker i raid
	//class abilities ink talented
	Superclass_Ability[] ClassAbilities;
	//abilities fra items, set bonuser, enchants
	Superclass_Ability[] BonusAbilities;
	
	public Object_AbilityLibrary( Superclass_Ability[] ClassAbilities, Superclass_Ability[] BonusAbilities ){
		
		this.ClassAbilities = ClassAbilities;
		this.BonusAbilities = BonusAbilities;
		
	}
	
	public void Calculate ( Object_Stats combatStats ) {
		
		Interface_Ability ActiveSeal = null;

		for ( int X = 0 ; X < ClassAbilities.length ; X ++ ){
			if ( ClassAbilities[X] != null ){
				try {
					((Superclass_Ability)ClassAbilities[X]).Calculate ( combatStats );
				} catch ( Exception e ){
					ClassAbilities[X].Calculate ( combatStats );
				}
			}
		}
		for ( int X = 0 ; X < BonusAbilities.length ; X ++ ){
			if ( BonusAbilities[X] != null ){
				try {
					((Superclass_Ability)BonusAbilities[X]).Calculate ( combatStats );
				} catch ( Exception e ){
					BonusAbilities[X].Calculate ( combatStats );
				}
			}
		}
		
	}
	public double Get_DPS_Compared ( ) {

		double DPS = 0;
		for ( int X = 0 ; X < ClassAbilities.length ; X ++ ){
			if ( ClassAbilities[X] != null ){
				try {
				DPS = DPS + ((Superclass_Ability)ClassAbilities[X]).Get_Healed();
				} catch ( Exception e){
					
				}
			}
		}
		for ( int X = 0 ; X < BonusAbilities.length ; X ++ ){
			if ( BonusAbilities[X] != null ){
				DPS = DPS + ((Superclass_Ability)BonusAbilities[X]).Get_Healed();
			}
		}
		return DPS;
	}
	public Superclass_Ability[] Get_Abilities ( ) {

		Superclass_Ability[] AllAbilities = new Superclass_Ability[ClassAbilities.length+BonusAbilities.length];
		for (int A = 0 ; A < AllAbilities.length ; A++ ) {
			if ( ClassAbilities[A] != null ) {
				AllAbilities[A] = ClassAbilities[A];
				//0-9
			} else {
				AllAbilities[A] = BonusAbilities[A-ClassAbilities.length];
				//10-10
			}
		}
		return AllAbilities;
	}

	public Superclass_Ability[] Get_ClassAbilities ( ) {
		return this.ClassAbilities;
	}

	public Superclass_Ability[] Get_BonusAbilities ( ) {
		return this.BonusAbilities;
	}
	

}
