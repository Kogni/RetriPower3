package Gear;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import Standalone.*;

public class Object_GearCombo {
	
	//private static final long	serialVersionUID	= 1100;
	
	private String Name;
	private boolean InUse;
	private double DPS;
	//private JButton EquipButton = new JButton("Equip combo");

	private Metable_Helmet			Equipped_Helmet;
	private Enchantable_Chest 		Equipped_Chest;
	private Enchantable_Back 		Equipped_Back;
	private Enchantable_boots		Equipped_Boots;
	private Enchantable_bracers		Equipped_Bracers;
	private Enchantable_Gloves 		Equipped_Gloves;
	private Enchantable_Leggings 	Equipped_Leggings;
	private Enchantable_Ring[] 		Equipped_Ring 			= new Enchantable_Ring[3];
	private Enchantable_Weapon 		Equipped_Weapon;
	private Enchantable_Shoulders 	Equipped_Shoulders;
	private Statpiece_Neck			Equipped_Neck;
	private Statpiece_Trinket[]		Equipped_Trinket		= new Statpiece_Trinket[3];
	private Statpiece_Belt			Equipped_Belt;
	private Gear_Relic				Equipped_Relic;
	private Gear_Glyph[]			Equipped_Glyph			= new Gear_Glyph[4];
	
	Object_Stats			GearStats;
	String Task;
	
	public Object_GearCombo ( String Name, String A ){
		
		//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		this.Name = Name;
		this.Task = A;
		
	}
	
	public String GetName(){
		return Name;
	}
	
	public void SetInUse( boolean InUse ){
		this.InUse = InUse;
	}
	
	public boolean GetinUse(){
		return InUse;
	}
	
	public void SetGearStats () {

		GearStats = new Object_Stats();
		for ( int X = 0 ; X < GearStats.GetStatnames ( ).length ; X++ ){
			if (  GearStats.GetStatnames ( )[X] != null ){
				if (  Equipped_Helmet != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Helmet.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Chest != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Chest.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Back != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Back.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Boots != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Boots.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Bracers != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Bracers.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Gloves != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Gloves.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Leggings != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Leggings.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Weapon != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Weapon.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Shoulders != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Shoulders.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Neck != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Neck.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Belt != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Belt.GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Ring[1] != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Ring[1].GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Ring[2] != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Ring[2].GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Trinket[1] != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Trinket[1].GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
				if (  Equipped_Trinket[2] != null ){
					double Stat = GearStats.GetStat_Nmr ( X ) + Equipped_Trinket[2].GetStatset ( ).GetStat_Nmr ( X );
					GearStats.SetStat_Nmr ( X, Stat );
				}
			}
		}
		
	}
	
	public void SetItemAsCurrent ( E newEquip, String CharSlot ) {

		if (CharSlot.equals ( "Head" )){
			Equipped_Helmet = ( Metable_Helmet ) newEquip;
		} else if (CharSlot.equals ( "Chest" )){
			Equipped_Chest = ( Enchantable_Chest ) newEquip;
		} else if (CharSlot.equals ( "Hands" )){
			Equipped_Gloves = ( Enchantable_Gloves ) newEquip;
		} else if (CharSlot.equals ( "Legs" )){
			Equipped_Leggings = ( Enchantable_Leggings ) newEquip;
		} else if (CharSlot.equals ( "Back" )){
			Equipped_Back = ( Enchantable_Back ) newEquip;
		} else if (CharSlot.equals ( "Wrist" )){
			Equipped_Bracers = ( Enchantable_bracers ) newEquip;
		}  else if (CharSlot.equals ( "Waist" )){
			Equipped_Belt = ( Statpiece_Belt ) newEquip;
		} else if (CharSlot.equals ( "Two-Hand" )){
			Equipped_Weapon = ( Enchantable_Weapon ) newEquip;
		} else if (CharSlot.equals ( "Feet" )){
			Equipped_Boots = ( Enchantable_boots ) newEquip;
		} else if (CharSlot.equals ( "Shoulder" )){
			Equipped_Shoulders = ( Enchantable_Shoulders ) newEquip;
		} else if (CharSlot.equals ( "Finger 1" )){
			Equipped_Ring[1] = ( Enchantable_Ring ) newEquip;
		} else if (CharSlot.equals ( "Finger 2" )){
			Equipped_Ring[2] = ( Enchantable_Ring ) newEquip;
		} else if (CharSlot.equals ( "Trinket 1" )){
			Equipped_Trinket[1] = ( Statpiece_Trinket ) newEquip;
		} else if (CharSlot.equals ( "Trinket 2" )){
			Equipped_Trinket[2] = ( Statpiece_Trinket ) newEquip;
		} else if (CharSlot.equals ( "Neck" )){
			Equipped_Neck = ( Statpiece_Neck ) newEquip;
		} else if (CharSlot.equals ( "Relic" )){
			Equipped_Relic = ( Gear_Relic ) newEquip;
		} else if (CharSlot.equals ( "Glyph 1" )){
			Equipped_Glyph[1] = ( Gear_Glyph ) newEquip;
		} else if (CharSlot.equals ( "Glyph 2" )){
			Equipped_Glyph[2] = ( Gear_Glyph ) newEquip;
		} else if (CharSlot.equals ( "Glyph 3" )){
			Equipped_Glyph[3] = ( Gear_Glyph ) newEquip;
		} else {
			System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
			System.err.println ( "GearCombo sier Ukjent slot: "+CharSlot);
		}
		
		//System.out.println ( "Gear combo "+this.Name+" ble forandret");

	}

	public Object_Stats HentGearStats ( ) {
		return this.GearStats;
	}

	public synchronized E HentEquippedItem ( String Slot ) {

		if (Slot.equals ( "Helmet" )){
			return ( E ) Equipped_Helmet;
		} else if (Slot.equals ( "Head" )){
			return ( E ) Equipped_Helmet;
		} else if (Slot.equals ( "Chest" )){
			return ( E ) Equipped_Chest;
		} else if (Slot.equals ( "Hands" )){
			return ( E ) Equipped_Gloves;
		} else if (Slot.equals ( "Gloves" )){
			return ( E ) Equipped_Gloves;
		} else if (Slot.equals ( "Leggings" )){
			return ( E ) Equipped_Leggings;
		} else if (Slot.equals ( "Legs" )){
			return ( E ) Equipped_Leggings;
		} else if (Slot.equals ( "Back" )){
			return ( E ) Equipped_Back;
		} else if (Slot.equals ( "Wrist" )){
			return ( E ) Equipped_Bracers;
		} else if (Slot.equals ( "Bracers" )){
			return ( E ) Equipped_Bracers;
		}  else if (Slot.equals ( "Waist" )){
			return ( E ) Equipped_Belt;
		}  else if (Slot.equals ( "Belt" )){
			return ( E ) Equipped_Belt;
		} else if (Slot.equals ( "Two-Hand" )){
			return ( E ) Equipped_Weapon;
		} else if (Slot.equals ( "Feet" )){
			return ( E ) Equipped_Boots;
		} else if (Slot.equals ( "Boots" )){
			return ( E ) Equipped_Boots;
		} else if (Slot.equals ( "Shoulder" )){
			return ( E ) Equipped_Shoulders;
		} else if (Slot.equals ( "Shoulders" )){
			return ( E ) Equipped_Shoulders;
		} else if (Slot.equals ( "Finger 1" )){
			return ( E ) Equipped_Ring[1];
		} else if (Slot.equals ( "Finger 2" )){
			return ( E ) Equipped_Ring[2];
		} else if (Slot.equals ( "Ring 1" )){
			return ( E ) Equipped_Ring[1];
		} else if (Slot.equals ( "Ring 2" )){
			return ( E ) Equipped_Ring[2];
		} else if (Slot.equals ( "Trinket 1" )){
			return ( E ) Equipped_Trinket[1];
		} else if (Slot.equals ( "Trinket 2" )){
			return ( E ) Equipped_Trinket[2];
		} else if (Slot.equals ( "Neck" )){
			return ( E ) Equipped_Neck;
		} else if (Slot.equals ( "Relic" )){
			return ( E ) Equipped_Relic;
		} else if (Slot.equals ( "Glyph Major 1" )){
			return ( E ) Equipped_Glyph[1];
		} else if (Slot.equals ( "Glyph Major 2" )){
			return ( E ) Equipped_Glyph[2];
		} else if (Slot.equals ( "Glyph Major 3" )){
			return ( E ) Equipped_Glyph[3];
		} else {
			//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
			//System.out.println ( "----------------- UKJENT SLOT: "+Slot);
		}
		return null;
	}

	public Object_Stats HentGemStats ( ) {
		return new Object_Stats();
	}

	public void CopyEquippedItems ( GearCombo equippedGear ) {

		Equipped_Helmet = equippedGear.Equipped_Helmet;
		Equipped_Chest = equippedGear.Equipped_Chest;
		Equipped_Back = equippedGear.Equipped_Back;
		Equipped_Boots = equippedGear.Equipped_Boots;
		Equipped_Bracers = equippedGear.Equipped_Bracers;
		Equipped_Gloves = equippedGear.Equipped_Gloves;
		Equipped_Leggings = equippedGear.Equipped_Leggings;
		Equipped_Ring = equippedGear.Equipped_Ring;
		Equipped_Weapon = equippedGear.Equipped_Weapon;
		Equipped_Shoulders = equippedGear.Equipped_Shoulders;
		Equipped_Neck = equippedGear.Equipped_Neck;
		Equipped_Trinket = equippedGear.Equipped_Trinket;
		Equipped_Belt = equippedGear.Equipped_Belt;
		Equipped_Relic = equippedGear.Equipped_Relic;
		Equipped_Glyph = equippedGear.Equipped_Glyph;
		
	}

	public double GetDPS ( ) {
		return DPS;
	}
	/*
	public JButton GetButton(){
		return EquipButton;
	}
*/
	public void SetDPS ( double DPS ) {
		this.DPS = DPS;
	}
	
}
