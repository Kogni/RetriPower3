package Abilities;

import Standalone.*;

public class Superclass_Ability implements Interface_Ability {
	
	String Name;
	
	Object_Stats Statset;
	
	double CastCD;
	boolean Available;
	double CycleCD;
	int CycleChances;
	int CycleProccs;
	boolean InUse;
	int ProccChance;
	boolean Proccbased;
	boolean UseGCD;
	
	double HealPerCast;
	double HealCD;
	double HealCost;
	
	double SpellPwr;
	double MP5;
	double Mana;
	
	double Healed;
	double HPS;
	double Usage5;
	double Net5;
	double Oom;
	double Casts;
	
	public Superclass_Ability( String Name ){
		
		this.Name = Name;
		
	}

	public void Calculate ( Object_Stats CombatStats ) {
		//System.out.println("non-attack calculate "+Name);
	}

	public boolean Get_Available ( ) {
		return Available;
	}

	public double Get_CastCD ( ) {
		return CastCD;
	}

	public double Get_CycleCD ( ) {
		return CycleCD;
	}

	public int Get_CycleChances ( ) {
		return CycleChances;
	}

	public int Get_CycleProccs ( ) {
		return CycleProccs;
	}

	public boolean Get_InUse ( ) {
		return InUse;
	}

	public String Get_Name ( ) {
		return Name;
	}

	public double Get_ProccChance ( ) {
		return ProccChance;
	}

	public boolean Get_Proccbased ( ) {
		return Proccbased;
	}

	public boolean Get_UseGCD ( ) {
		return UseGCD;
	}

	public void Set_Available ( boolean Available ) {
		this.Available = Available;
	}

	public void Set_CycleCD ( double CD ) {
		CycleCD = CD;	
	}

	public void Set_CycleChances ( int Chances ) {
		CycleChances = Chances;	
	}

	public void Set_CycleProccs ( int Proccs ) {
		CycleProccs = Proccs;
	}

	public double Get_Healed() {
		//System.out.println("ability sender ut healed="+Healed);
		return Healed;
	}

	public double Get_HPS() {
		return HPS;
	}

	public double Get_Oom() {
		return Oom;
	}

}
