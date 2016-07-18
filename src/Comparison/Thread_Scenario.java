package Comparison;

import Standalone.*;
import Abilities.Object_AbilityLibrary;
import Abilities.Superclass_Ability;
import Buffs.Object_BuffLibrary;

public class Thread_Scenario extends Thread {
	
	Interface_Specc SpeccUsed; //skal være ferdig hentet
	Object_BuffLibrary Buffs; //skal ha fylt inn og aktivert alle buffer som er tilgjengelige
	Object_AbilityLibrary Abilities; //skal ha fylt inn og aktivert alle abilities som er tilgjengelige
	
	Interface_UpgradeObject UpgradeSubject;
	Comparison_Model Mottaker;
	
	String Task;
	
	Object_Stats BaseStats; //class-specific base stats før items etc
	Object_Stats GearStats = new Object_Stats();
	Object_Stats GemStats = new Object_Stats();
	Object_Stats EnchStats = new Object_Stats();
	Object_Stats RawStats;
	Object_Stats RawStats_Converted;
	
	Object_Stats SpeccStats;
	Object_Stats OOCStats;
	Object_Stats OOCStats_Converted;
	
	Object_Stats BuffStats;
	Object_Stats CombatStats;
	Object_Stats CombatStats_Converted; //faktiske stats i combat
	
	double DPS_This, DPS_Current, DPS_Change, DPS_Prcnt_Change;
	
	Object_ComparisonResult Results;
	
	public Thread_Scenario( String Task, Object_AbilityLibrary Abilities, Interface_UpgradeObject UpgradeSubject, Comparison_Model Mottaker, Object_Stats BaseStats, Interface_Specc SpeccUsed, Object_BuffLibrary Buffs ){
		
		this.Task = Task;
		this.Abilities = Abilities;
		this.UpgradeSubject = UpgradeSubject;
		this.Mottaker = Mottaker;
		this.BaseStats = BaseStats;
		this.SpeccUsed = SpeccUsed;
		this.Buffs = Buffs;
		
		Results = new Object_ComparisonResult();
		//sammenligninger skal skje i threads, som etter kalkulering sender ut resultatet sitt.
		//threads må ha tilsendt all nødvendig informasjon før de kan starte.
		//threads må kunne fortelle mottaker nøyaktig hvilket objekt de har regnet upgrade for
		//når threads sender ut resultatet sitt så skal det evaluerte objektet identifiseres, og nødvendig gui oppdateres
		
		//nødvendig info før start:
		//utregningsobjekt/mottaker(stat\gear\specc etc)
		//mottaker/oppdateringsinformant(comparison_model)
		//all informasjon om current situation. enten må det sendes med thread eller så må thread hente det utenfra
		
		//utregningsobjekter:
		//compare stats: utregningsobjekt er object_stats
		//stat values: utregningsobjekt er object_stats
		//gear: utregningsobjekt er object_gear, som inkluderer object_stats, object_buff, object_gem
		//specc: utregningsobjekt er object_specc
		
		//leste avdelinger:
		//character
		//classrules
		//gems
		//globals
		//speccing
		
		//skrevne\appenda\kjørte avdelinger:
		//abilities
		
		//simulering:
		//- Skal finne ut slutt DPS etter et encounter som er langt nok til å være representativt
		//- Må oppdateres med tilstand hele tiden før et attack kan utføres
		//- Kun nødvendig å oppdatere buffs, stats etc før en ability skal castes
		//- Nødvendig å oppdatere buffs etc før hver eneste ability som skjer samtidig(feks seal)?
		//Aktivering av buffer, abilities etc
		//- Er det noen god måte å kun aktivere\deaktivere hver buff\ability\whatever når det endrs, istedenfor hver tick i simulering?
		
	}
	
	public void run(){
		//System.out.println ( "Thread skal sammenligne" );
		//thread må vite hva den skal sammenligne.
		//items? enten finn stat forskjell og legg den til current stats for base, gear og gems, eller fjern current item og legg til compared
		//stats? legg forskjell til current stats for base, gear og gems
		//specc? current gear, current buffs, men apply compared specc
		CalculateStats();
		
		Abilities.Calculate(CombatStats_Converted); //siste utregning
		//calculating dps change
		//double DPS_Compared, DPS_Current;
		this.DPS_This = Abilities.Get_DPS_Compared();
		this.DPS_Current = Mottaker.Get_DPS_Current();
		this.DPS_Change = this.DPS_This - this.DPS_Current;
		this.DPS_Prcnt_Change = (this.DPS_Change / this.DPS_Current) * 100;
		//applying dps change to evaluated object
		if ( UpgradeSubject != null ){
			UpgradeSubject.SetDPSUpgrade ( this.DPS_Change, this.DPS_Prcnt_Change );
		}
		//telling program to update
		//System.out.println ( "Ferdig å regne upgrade: +"+DPS_Change+"/+"+DPS_Prcnt_Change );
		
		double HPS_Amount = 0;
		double Oom_Amount = 0;
		double Healed_Amount = 0;
		
		Superclass_Ability[] Abilitylist = Abilities.Get_Abilities();
		for ( int A = 0 ; A < Abilitylist.length ; A++ ) {
			if ( Abilitylist[A] != null ) {
				HPS_Amount = HPS_Amount + Abilitylist[A].Get_HPS();
				Oom_Amount = Oom_Amount + Abilitylist[A].Get_Oom();
				Healed_Amount = Healed_Amount + Abilitylist[A].Get_Healed();
			}
		}
		
		System.out.println("scenario HPS_Amount="+HPS_Amount);
		System.out.println("scenario Oom_Amount="+Oom_Amount);
		System.out.println("scenario Healed_Amount="+Healed_Amount);
		
		Results.Set_HPSUpgrade(HPS_Amount, 0);
		Results.Set_OomUpgrade(Oom_Amount, 0.0);
		Results.Set_HealedUpgrade(Healed_Amount, 0.0);
		
		Mottaker.UpgradesUpdated( Task, this );
	}
	
	private void CalculateStats(){
		
		//base
		RawStats = new Object_Stats();
		for ( int X = 0 ; X < RawStats.GetStatnames ( ).length ; X++ ){
			RawStats.AddStat ( RawStats.GetStatnames ( )[X], BaseStats.GetStatamounts ( )[X] );
			RawStats.AddStat ( RawStats.GetStatnames ( )[X], GearStats.GetStatamounts ( )[X] );
			RawStats.AddStat ( RawStats.GetStatnames ( )[X], GemStats.GetStatamounts ( )[X] );
			RawStats.AddStat ( RawStats.GetStatnames ( )[X], EnchStats.GetStatamounts ( )[X] );
		}
		//hvis upgrade object er statvalue
		try {
			StatValue temp = ((StatValue)UpgradeSubject);
			RawStats.AddStat ( temp.StatNames, temp.StatAmounts );
			//System.out.println("La til stats: "+temp.StatNames);
		}catch (Exception e){
			System.out.println("Upgrade object er ikke StatValue: "+UpgradeSubject);
		}
		
		RawStats_Converted = new Object_Stats();
		for ( int X = 0 ; X < RawStats_Converted.GetStatnames ( ).length ; X++ ){
			RawStats_Converted.AddStat ( RawStats_Converted.GetStatnames ( )[X], RawStats.GetStatamounts ( )[X] );
		}
		
		//specc
		SpeccStats = new Object_Stats();
		//System.out.println("RawStats_Converted="+RawStats_Converted);
		//System.out.println("SpeccStats="+SpeccStats);
		//System.out.println("Abilities="+Abilities);
		//System.out.println("Globals="+Globals);
		//System.out.println("SpeccUsed="+SpeccUsed);
		SpeccUsed.ApplySpecc(RawStats_Converted, SpeccStats, Abilities);
		OOCStats = new Object_Stats();
		for ( int X = 0 ; X < OOCStats.GetStatnames ( ).length ; X++ ){
			OOCStats.AddStat ( OOCStats.GetStatnames ( )[X], RawStats.GetStatamounts ( )[X] );
			OOCStats.AddStat ( OOCStats.GetStatnames ( )[X], SpeccStats.GetStatamounts ( )[X] );
		}
		OOCStats_Converted = new Object_Stats();
		for ( int X = 0 ; X < OOCStats_Converted.GetStatnames ( ).length ; X++ ){
			OOCStats_Converted.AddStat ( OOCStats_Converted.GetStatnames ( )[X], OOCStats.GetStatamounts ( )[X] );
		}
		
		//buffs
		//pre-utregning
		BuffStats = new Object_Stats();
		CombatStats = new Object_Stats();
		CombatStats_Converted = new Object_Stats();
		Buffs.Calculate_OutOfCombat(BuffStats, OOCStats_Converted); //feks kings
		for ( int X = 0 ; X < CombatStats.GetStatnames ( ).length ; X++ ){
			CombatStats.AddStat ( CombatStats.GetStatnames ( )[X], OOCStats.GetStatamounts ( )[X] );
			CombatStats.AddStat ( CombatStats.GetStatnames ( )[X], BuffStats.GetStatamounts ( )[X] );
		}
		for ( int X = 0 ; X < CombatStats_Converted.GetStatnames ( ).length ; X++ ){
			CombatStats_Converted.AddStat ( CombatStats_Converted.GetStatnames ( )[X], CombatStats.GetStatamounts ( )[X] );
		}
		Abilities.Calculate(CombatStats); 
		//post-utregning
		BuffStats = new Object_Stats();
		CombatStats = new Object_Stats();
		CombatStats_Converted = new Object_Stats();
		Buffs.Calculate_InCombat(BuffStats); //alle som avhenger av at abilities brukes, feks libramer
		for ( int X = 0 ; X < CombatStats.GetStatnames ( ).length ; X++ ){
			CombatStats.AddStat ( CombatStats.GetStatnames ( )[X], OOCStats.GetStatamounts ( )[X] );
			CombatStats.AddStat ( CombatStats.GetStatnames ( )[X], BuffStats.GetStatamounts ( )[X] );
		}
		for ( int X = 0 ; X < CombatStats_Converted.GetStatnames ( ).length ; X++ ){
			CombatStats_Converted.AddStat ( CombatStats_Converted.GetStatnames ( )[X], CombatStats.GetStatamounts ( )[X] );
		}
		CombatStats_Converted = Mottaker.Class_Comparison_Controller.Call_ConvertToCombatstats(CombatStats);
		//System.out.println("mana i thread="+CombatStats.GetStatamount("Mana"));
		//System.out.println("int i thread="+CombatStats.GetStatamount("Intellect"));
		
	}

}
