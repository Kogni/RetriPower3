package Classrules;

import Standalone.*;

public class Object_Priest extends Object_Unit {

	public Object_Priest(String Class, Object_Stats BaseStats) {
		super(Class, BaseStats);

	}
	
	public String[] Get_CharSlots ( ) {

		String[] Slots = new String[20];
		int X = 0;
		X++;
		Slots[X] = "Head";
		X++;
		Slots[X] = "Neck";
		X++;
		Slots[X] = "Shoulder";
		X++;
		Slots[X] = "Back";
		X++;
		Slots[X] = "Chest";
		X++;
		Slots[X] = "Wrist";
		X++;
		Slots[X] = "Main Hand";
		X++;
		Slots[X] = "Held in Off-hand";
		X++;
		Slots[X] = "Hands";
		X++;
		Slots[X] = "Waist";
		X++;
		Slots[X] = "Legs";
		X++;
		Slots[X] = "Feet";
		X++;
		Slots[X] = "Finger 1";
		X++;
		Slots[X] = "Finger 2";
		X++;
		Slots[X] = "Trinket 1";
		X++;
		Slots[X] = "Trinket 2";
		return Slots;
	}

}
