package Comparison;

import Abilities.Object_AbilityLibrary;
import Abilities.Superclass_Ability;
import Buffs.Object_BuffLibrary;
import Standalone.*;

public class Comparison_Model {
	
	Comparison_Controller Class_Comparison_Controller;
	
	StatValues StatVerdiene;
	Thread_Scenario CurrentScenario;

	public Comparison_Model ( Comparison_Controller Class_Comparison_Controller ) {

		this.Class_Comparison_Controller = Class_Comparison_Controller;
		StatVerdiene = new StatValues(); 
		
	}
	
	public void CalculateStatvalues(){
		
		System.out.println ( "D" );
		for ( int X = 0 ; X < StatVerdiene.Get_Statvalues().length ; X++ ){
			
			CreateComparison(StatVerdiene.Get_Statvalues()[X]);
			/*
			double Upgrade_Amount = 0;
			double Upgrade_Percent = 0;
			StatVerdiene.Get_Statvalues ( )[X].StatUpgrade = Upgrade_Amount;
			StatVerdiene.Get_Statvalues ( )[X].StatUpgradePrcnt = Upgrade_Percent;
			*/
		}
		//System.out.println("Ferdig å regne ut stat values");
		Class_Comparison_Controller.ShowStatValues(StatVerdiene);
	}

	public void Call_ComparingWindowComparison ( ) {

		//1. hent current non-combat stats
		Object_Stats Currentstats = this.Class_Comparison_Controller.Get_CurrentTotaltstats();
		//2. hent changed stats
		Object_Stats Changedstats = this.Class_Comparison_Controller.Get_ChangedStats();
		//3. addèr
		Object_Stats Newstats = new Object_Stats();
		for ( int X = 0 ; X < Currentstats.GetStatnames ( ).length ; X++ ){
			double New = Currentstats.GetStat_Nmr ( X ) + Changedstats.GetStat_Nmr ( X );
			Newstats.SetStat_Nmr ( X, New );
		}
		//System.out.println ( "total str="+Newstats.GetStatamount ( "Strength" ) );
		//4. konverter til combat stats
		Newstats = this.Class_Comparison_Controller.Call_ConvertToCombatstats(Newstats);
		//5. calculate changes
		double HPS_Amount = 0;
		double Oom_Amount = 0;
		double Healed_Amount = 0;
		
		Superclass_Ability[] Abilities = Class_Comparison_Controller.Get_NewAbilityLibrary().Get_Abilities();
		for ( int A = 0 ; A < Abilities.length ; A++ ) {
			if ( Abilities[A] != null ) {
				Abilities[A].Calculate(Newstats);
				HPS_Amount = HPS_Amount + Abilities[A].Get_HPS();
				Oom_Amount = Oom_Amount + Abilities[A].Get_Oom();
				Healed_Amount = Healed_Amount + Abilities[A].Get_Healed();
			}
		}
		
		//System.out.println("comparison HPS_Amount="+HPS_Amount);
		//System.out.println("comparison Oom_Amount="+Oom_Amount);
		//System.out.println("comparison Healed_Amount="+Healed_Amount);
		
		Object_ComparisonResult Results = new Object_ComparisonResult();
		Results.Set_HPSUpgrade(HPS_Amount, 0.0);
		Results.Set_OomUpgrade(Oom_Amount, 0.0);
		Results.Set_HealedUpgrade(Healed_Amount, 0.0);
		//6. send ut resultat
		this.Class_Comparison_Controller.Call_SetComparedStats(Newstats, Results);
		
	}
	
	private void CreateComparison(Interface_UpgradeObject UpgradeObject){
		
		//sammenligninger skal skje i threads, som etter kalkulering sender ut resultatet sitt.
		//threads må ha tilsendt all nødvendig informasjon før de kan starte.
		//threads må kunne fortelle mottaker nøyaktig hvilket objekt de har regnet upgrade for
		//når threads sender ut resultatet sitt så skal det evaluerte objektet identifiseres, og nødvendig gui oppdateres
		Object_AbilityLibrary Abilities = Class_Comparison_Controller.Get_NewAbilityLibrary();
		Object_Stats BaseStats = Class_Comparison_Controller.Get_BaseStats();
		Interface_Specc SpeccUsed = this.Class_Comparison_Controller.Get_CurrentSpecc();
		Object_BuffLibrary Buffs = this.Class_Comparison_Controller.Get_Buffs();
		new Thread_Scenario( "Comparison", Abilities, UpgradeObject, this, BaseStats, SpeccUsed, Buffs ).start ( );
		
	}
	
	public void CalculateCurrent(){
		
		Object_AbilityLibrary Abilities = Class_Comparison_Controller.Get_NewAbilityLibrary();
		Object_Stats BaseStats = Class_Comparison_Controller.Get_BaseStats();
		Interface_Specc SpeccUsed = this.Class_Comparison_Controller.Get_CurrentSpecc();
		Object_BuffLibrary Buffs = this.Class_Comparison_Controller.Get_Buffs();
		new Thread_Scenario( "Current", Abilities, null, this, BaseStats, SpeccUsed, Buffs ).start ( );
		
	}

	public void UpgradesUpdated ( String Task, Thread_Scenario Sender ) {
		if ( Task.equals ( "Current" )){
			this.CurrentScenario = Sender;
		} else {
			this.Class_Comparison_Controller.UpgradesUpdated ( StatVerdiene );
		}
	}

	public double Get_DPS_Current ( ) {
		if ( CurrentScenario != null ){
			return this.CurrentScenario.DPS_This;
		} else {
			return 0;
		}
	}

	public Object_ComparisonResult Get_CurrentHeal() {
		//System.out.println("comparison skal sende current results");
		return CurrentScenario.Results;
	}

}
