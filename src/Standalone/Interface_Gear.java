package Standalone;

public abstract interface Interface_Gear{

	
	abstract void SetUpgrade_Slow(double[] Upgrades);
	abstract void SetUpgrade_Fast(double[] Upgrades);
	
	abstract double[] GetUpgrades();
	abstract double[] GetUpgrades_Slow();
	abstract double[] GetUpgrades_Fast();
	
	abstract int GetDropspotID();
	abstract String Get_BoP ( );
	abstract int Get_DropSpotID ( );
	abstract String Get_Name ( );
	abstract String Get_GearType ( );
	abstract double[] Get_Upgrades_Grinding ( );
	abstract String Get_ItemType ( );
	abstract Object_Stats Get_Statset ( );
	abstract String Get_Slot ( );
	abstract Interface_Gem Get_Meta ( );
	abstract String[] Get_Sockets ( );
	
}
