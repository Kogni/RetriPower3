package Standalone;


public interface Interface_GearCombo {

	String Get_Name ( );

	double Get_DPS ( );

	Interface_Gear Get_EquippedItem ( String CharSlot );
	
	boolean Get_InUse();
	boolean Set_InUse(boolean Use);

}
