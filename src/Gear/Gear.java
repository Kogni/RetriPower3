package Gear;

import java.io.*;
import java.util.*;
import Scenario.*;

public class Gear extends Item implements Interface_Gear, Serializable, Interface_UpgradeObject {
	
	private static final long	serialVersionUID	= 0101;

	private String Slot = "";
	//private String ItemType = "";
	
	//private String EquippedSlot = "";
	private double[] Upgrades_Slow = new double[4];
	private double[] Upgrades_Fast = new double[4];
	private String BoP = "";

	public Gear ( String Name, int DropSpotID, int BuffID, String BoP, String Slot, String ItemType ) {

		super ( Name, DropSpotID, BuffID );
		this.BoP = BoP;
		this.Slot = Slot;
		//this.ItemType = ItemType;
		//EquippedSlot = "";
	}
/*
	public String GetEquipped ( ) {
		return EquippedSlot;
	}
	*/
	public double[] GetUpgrades_Slow ( ) {
		return Upgrades_Slow;
	}
	
	public double[] GetUpgrades_Fast ( ) {
		return Upgrades_Fast;
	}
	/*
	public void SetEquipped ( String EquippedSlot ) {
		if ( this.GetName ( ).equals ( "Ruthlessness" )){
			//System.out.println(new Date()+" 1 - " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
			//System.out.println("Equip for "+this.GetName ( )+" endres fra "+this.EquippedSlot+" til "+EquippedSlot);
		}
		this.EquippedSlot = EquippedSlot;
	}
	*/
	public void SetUpgrade_Slow ( double[] Upgrades ) {
		this.Upgrades_Slow = Upgrades;
	}
	
	public void SetUpgrade_Fast ( double[] Upgrades ) {
		this.Upgrades_Fast = Upgrades;
	}

	public String GetBoP ( ) {
		return this.BoP;
	}

	public String GetSlot ( ) {
		return this.Slot;
	}
	public void SetDPSUpgrade ( double Amount, double Percent ) {

		this.Upgrades_Slow[1] = Percent;
		
	}
	
}
