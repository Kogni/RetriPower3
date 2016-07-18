package Classrules;

import java.util.Date;
import Standalone.*;

public class Model_CombatProcessor {
	
	public double WhiteSpeed ( double Speed, double Haste ) {
		double White = Speed;// = ((100-Haste)/Speed)*100;
		White = Speed/(1+(Haste/100.0));
		White = (Math.round ( White*100 ))/100.0;
		
		return White;
	}

	public double Crit_RatingToChance ( double d ) {
		
		double Rating = d;
		double BaseRatio = 14;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double CritBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		CritBonus = Rating / BaseRatio / HTotal;
		
		CritBonus = Rating/14.0;
		CritBonus = CritBonus/(HA * Math.pow ( HB, HC ));
		CritBonus = (int)(CritBonus * 100);
		CritBonus = CritBonus / 100.00;

		return CritBonus;
		
	}

	public double Hit_RatingToChance ( double d ) {
		
		double Rating = d;
		double BaseRatio = 10.19;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double HitBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		HitBonus = Rating / BaseRatio / HTotal;
		//X39/10/((82/52)*(131/63)^((W39-70)/10))
		HitBonus = d/10.0;
		HitBonus = HitBonus/(HA * Math.pow ( HB, HC ));
		HitBonus = (int)(HitBonus * 100);
		HitBonus = HitBonus / 100.00;

		return HitBonus;
		
	}

	public double IntToCritChance ( int Intellect ) {
		
		double Rating = Intellect;
		double BaseRatio = 21.2766;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double CritBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		CritBonus = Rating / BaseRatio / HTotal;
		CritBonus = (int)(CritBonus * 100);
		CritBonus = CritBonus / 100.00;

		return CritBonus;
		
	}

	public double AgiToCritChance ( double d ) {
		double Rating = d;
		double BaseRatio = 14.80385;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double CritBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		CritBonus = Rating / BaseRatio / HTotal;
		CritBonus = ((int)(CritBonus * 100))/100.0;

		//System.out.println (d+" agility="+CritBonus+"% crit");
		return CritBonus;
	}

	public double HasteRatingToHasteBonus ( int HasteRating ) {
		double Rating = HasteRating;
		double BaseRatio = 10;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double HasteBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		HasteBonus = Rating / BaseRatio / HTotal;
		HasteBonus = (int)(HasteBonus * 100);
		HasteBonus = HasteBonus / 100.00;

		return HasteBonus;
	}

	public int ExpRatingToExpertise ( double d ) {
		double Rating = d;
		double BaseRatio = 2.5;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double ExpDouble; //ikke rating, ikke neglect, men expertise
		int Expertise;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		ExpDouble = Rating / BaseRatio / HTotal;
		Expertise = ( int ) ( ExpDouble );
		
		return Expertise;
	}

	public double ExpertiseToBonus ( double d ) {
		double ExpBonus = d / 4.0;
		//System.out.println ( Expertise+" expertise ble "+ExpBonus+" neglect");
		return ExpBonus;
	}

	public double PenetrationRatingToBonus ( double d ) {
		double Rating = d;
		double BaseRatio = 4.69512177;
		double HA = 0;
		double HB = 0;
		double HC = 0;
		double HTotal = 0;
		double PenBonus;
		//---- H -----
		HA = ( 82.0 / 52.0 );
		HB = ( 131.0 / 63.0 );
		HC = ( ( 80 - 70.0 ) / 10.0 );
		HTotal = HA * Math.pow ( HB, HC );
		//------------
		PenBonus = Rating / BaseRatio / HTotal;
		PenBonus = (int)(PenBonus * 100);
		PenBonus = PenBonus / 100.00;

		return PenBonus;
	}

	public double FindMitigation ( double PenetrationBonus ) {
		double AvgArmor = 5600.0;
		AvgArmor = 1;
		for ( int y = 0 ; y <= 80 ; y++ ) {
			AvgArmor = ( AvgArmor * 1.05 ) + 9.5;
		}
		double Mitigation;
		Mitigation = AvgArmor;
		PenetrationBonus = PenetrationBonus * 0.01;
		Mitigation = Mitigation - ( PenetrationBonus * AvgArmor );
		Mitigation = Mitigation / ( Mitigation + 400 + 85 * ( 80 + 4.5 * ( 80 - 59 ) ) );
		if ( Mitigation < 0.0 ) {
			Mitigation = 0.0;
		}
		Mitigation = Mitigation * ( 100.0 );
		return Mitigation;
	}
	
	public Object_Stats ConvertToCombatstats (Object_Stats CharStats) {
		//System.out.println(new Date()+" 1- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");

		Object_Stats Combatstats = new Object_Stats();
		Combatstats.SetStat ( "AP", (CharStats.GetStatamount ( "AP" ) + ( CharStats.GetStatamount ( "Strength" ) * 2 )));
		
		//System.out.println("fra char: Melee crit%"+CharStats.GetStatamount ( "Melee crit%" )+" crit rating="+CharStats.GetStatamount ( "Crit rating" )+" agi="+CharStats.GetStatamount ( "Agility" ));
		Combatstats.SetStat ( "Melee crit%", (CharStats.GetStatamount ( "Melee crit%" ) + Crit_RatingToChance(CharStats.GetStatamount ( "Crit rating" )) + AgiToCritChance(CharStats.GetStatamount ( "Agility" )) ));
		//System.out.println("Agility total="+CharStats.GetStatamount ( "Agility" )+" crit fra agi="+AgiToCritChance(CharStats.GetStatamount ( "Agility" )));
		//System.out.println( "Crit rating="+CharStats.GetStatamount ( "Crit rating" )+" crit %="+Crit_RatingToChance(CharStats.GetStatamount ( "Crit rating" )) );
		//System.out.println("Slutt-crit="+Combatstats.GetStatamount ( "Melee crit%"));
		
		Combatstats.SetStat ( "Hit%", (CharStats.GetStatamount ( "Hit%" ) + Hit_RatingToChance(CharStats.GetStatamount ( "Hit rating" ))));
		
		Combatstats.SetStat ( "Expertise", (CharStats.GetStatamount ( "Expertise" ) + ExpRatingToExpertise(CharStats.GetStatamount ( "Expert. rating" ))));
		
		Combatstats.SetStat ( "Dodge neglect", (CharStats.GetStatamount ( "Dodge neglect" ) + ExpertiseToBonus(Combatstats.GetStatamount ( "Expertise" ))));
		//System.out.println("Expert. rating="+CharStats.GetStatamount ( "Expert. rating" )+" neglect="+Combatstats.GetStatamount ( "Dodge neglect" ));

		Combatstats.SetStat ( "Haste%", (CharStats.GetStatamount ( "Haste%" ) + this.HasteRatingToHasteBonus ( ( int ) CharStats.GetStatamount ( "Haste rating" ))));
		//System.out.println("Haste rating="+CharStats.GetStatamount ( "Haste rating" )+" haste%="+Combatstats.GetStatamount ( "Haste%" ));
		
		Combatstats.SetStat ( "Health", (CharStats.GetStatamount ( "Health" ) + ( CharStats.GetStatamount ( "Stamina" ) * 10 )));
		
		Combatstats.SetStat ( "Mana", (CharStats.GetStatamount ( "Mana" ) + ( CharStats.GetStatamount ( "Intellect" ) * 15 )));
		
		Combatstats.SetStat ( "Penet.%", (CharStats.GetStatamount ( "Penet.%" ) + PenetrationRatingToBonus(CharStats.GetStatamount ( "Penet. rating" ))));	
		if ( CharStats.GetStatamount ( "Penet.%" ) > 100.0 ) {
			Combatstats.SetStat ( "Penet.%", 100);
		}
		
		Combatstats.SetStat ( "Armor", (CharStats.GetStatamount ( "Armor" ) + ( CharStats.GetStatamount ( "Agility" ) * 2 )));
		
		Combatstats.SetStat ( "Wpn min dmg", CharStats.GetStatamount ( "Wpn min dmg" ) );
		
		Combatstats.SetStat ( "Wpn max dmg", CharStats.GetStatamount ( "Wpn max dmg" ) );
		
		Combatstats.SetStat ( "Weapon speed", CharStats.GetStatamount ( "Weapon speed" ) );
		
		Combatstats.SetStat ( "White speed", CharStats.GetStatamount ( "Weapon speed" ) );
		
		if ( Combatstats.GetStatamount ( "Haste%" ) != 0 ) {
			double BaseSpeed = CharStats.GetStatamount ( "Weapon speed" );
			double NewWhiteSpeed = WhiteSpeed ( BaseSpeed, Combatstats.GetStatamount ( "Haste%" ) );
			Combatstats.SetStat ( "White speed", NewWhiteSpeed );
		}
		
		Combatstats.SetStat ( "Spelldmg", CharStats.GetStatamount ( "Spelldmg" ) );
		
		//intellect -> crit
		//spirit
		//armor
		//spell crit
		//mp5

		//System.out.println(new Date()+" 2- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		return Combatstats;

	}

}
