package Standalone;

public interface Interface_Ability {
	
	abstract String Get_Name ( );
	abstract boolean Get_Available();
	abstract void Set_Available(boolean Available);
	
	abstract double Get_CycleCD();
	abstract void Set_CycleCD(double CD);
	abstract int Get_CycleProccs();
	abstract void Set_CycleProccs(int Proccs);
	abstract int Get_CycleChances();
	abstract void Set_CycleChances(int Chances);
	abstract boolean Get_Proccbased();
	abstract double Get_ProccChance();
	abstract double Get_CastCD();
	abstract boolean Get_UseGCD();
	
	abstract boolean Get_InUse();

}
