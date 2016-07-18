package Abilities;

import Standalone.*;

public class Object_Ability_Heal extends Superclass_Ability {

	public Object_Ability_Heal(String Name) {
		super(Name);

	}
	
	public void Calculate ( Object_Stats CombatStats ) {

		this.Healed = 0;
		SpellPwr = CombatStats.GetStatamount("Spelldmg");
		MP5 = CombatStats.GetStatamount("MP5");
		Mana = CombatStats.GetStatamount("Mana");
		
		if ( this.Name.equals("Power Word: Shield")) {
			HealPerCast = 1098+335+(SpellPwr*1.206*1.2)+(SpellPwr*0.2);//726+145+(C5*1,206*1,2)+(C5*0,2)
			HealCD = 3.0;
			HealCost = 340;
		}
		
		HPS = HealPerCast / HealCD;
		Usage5 = HealCost / HealCD * 5;
		Net5 = Usage5 - MP5;
		Oom = (Mana / Net5)*5;
		Healed = Oom * HPS;
		Casts = Healed / HealPerCast;
		/*
		System.out.println("HPS="+HPS);
		System.out.println("Oom="+Oom);
		System.out.println("Healed="+Healed);
		System.out.println("Mana="+Mana);
		System.out.println("Net5="+Net5);
		*/
	}

}
