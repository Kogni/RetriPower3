package Abilities;

import Standalone.Interface_Ability;
import Standalone.Object_Stats;

public class Object_Ability_Spell extends Superclass_Ability {

	public Object_Ability_Spell ( String Name ) {

		super ( Name );
		

	}
	
	public void Calculate ( Object_Stats Statset, Interface_Ability ActiveSeal ) {

		//sett ability-spesifike regler
		if ( this.Name.equals ( "Exorcism" )){
			
		}
		//kall på obligatoriske metoder for videre utregninger
		//avoidance utregning
		//hit table
		//avg base damage
		//crits
		//actual damage
		//dps
		
	}

	@Override
	public boolean Get_Available() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double Get_CastCD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Get_CycleCD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Get_CycleChances() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Get_CycleProccs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Get_InUse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Get_Name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double Get_ProccChance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean Get_Proccbased() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Get_UseGCD() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Set_Available(boolean Available) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Set_CycleCD(double CD) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Set_CycleChances(int Chances) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Set_CycleProccs(int Proccs) {
		// TODO Auto-generated method stub
		
	}

}
