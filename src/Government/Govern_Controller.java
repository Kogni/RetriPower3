package Government;

import java.util.Date;
import Abilities.Abilities_Controller;
import Abilities.Object_AbilityLibrary;
import Abilities.Superclass_Ability;
import Buffs.Buffs_Controller;
import Buffs.Object_BuffLibrary;
import Character.Character_Controller;
import Classrules.Class_Controller;
import Comparison.Comparison_Controller;
import DropSpots.DropSpots_Controller;
import Enchants.Enchants_Controller;
import GUI.GUI_Controller;
import GUI.Panel_DropSpotTree;
import Gear.Gear_Controller;
import Gems.Gems_Controller;
import Professions.Professions_Controller;
import Speccing.Speccing_Controller;
import Standalone.*;

public class Govern_Controller {
	
	private GUI_Controller Class_GUI_Controller;
	private Speccing_Controller Class_Speccing_Controller;
	private Class_Controller Class_Class_Controller;
	private Character_Controller Class_Character_Controller;
	private Comparison_Controller Class_Comparison_Controller;
	private DropSpots_Controller Class_DropSpots_Controller;
	private Abilities_Controller Class_Abilities_Controller;
	private Enchants_Controller Class_Enchants_Controller;
	private Gear_Controller Class_Gear_Controller;
	private Gems_Controller Class_Gems_Controller;
	private Professions_Controller Class_Professions_Controller;
	private Buffs_Controller Class_Buffs_Controller;

	public Govern_Controller(){
		
		Class_GUI_Controller = new GUI_Controller(this);
		Class_Speccing_Controller = new Speccing_Controller(this);
		Class_Class_Controller = new Class_Controller("", this);
		Class_Character_Controller = new Character_Controller(this);
		Class_Comparison_Controller = new Comparison_Controller(this);
		Class_DropSpots_Controller = new DropSpots_Controller(this);
		Class_Abilities_Controller = new Abilities_Controller(this);
		Class_Enchants_Controller = new Enchants_Controller(this);
		Class_Gear_Controller = new Gear_Controller(this);
		Class_Gems_Controller = new Gems_Controller(this);
		Class_Professions_Controller = new Professions_Controller(this);
		Class_Buffs_Controller = new Buffs_Controller(this);
		
	}

	public void UserCommand_ClassChoice ( String Class ) {
		Class_Class_Controller = new Class_Controller(Class, this);
		Class_Character_Controller.MakePlayer(Class);
		Class_Abilities_Controller.CreateAbilities(Class);
		
		Class_Comparison_Controller.Call_CalculateCurrentDPS();
		this.Class_Comparison_Controller.CalculateStatvalues();
	}

	public Interface_Specc Get_CurrentSpecc ( ) {
		return Class_Speccing_Controller.Get_CurrentSpecc ( );
	}

	public Object_Stats Get_CharBasestats ( ) {
		return Class_Character_Controller.Get_CharBasestats ( );
	}

	public Object_Stats Get_CurrentGearstats ( ) {
		return Class_Character_Controller.Get_CurrentGearstats ( );
	}

	public Object_Stats Get_CurrentTotalstats ( ) {
		return Class_Character_Controller.Get_CurrentTotalstats ( );
	}

	public Object_Stats ConvertToCombatstats ( Object_Stats totalStats ) {
		//System.out.println(new Date()+" 1- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		return this.Class_Class_Controller.ConvertToCombatstats ( totalStats );
	}

	public Object_Stats Get_CurrentCombatstats ( ) {
		return Class_Character_Controller.Get_CurrentCombatstats ( );
	}

	public Object_Stats Get_UsercomparisonCombatstats ( ) {
		return Class_Character_Controller.Get_UsercomparisonCombatstats ( );
	}

	public Object_Stats Get_UsercomparisonBuffstats ( ) {
		return Class_Character_Controller.Get_UsercomparisonBuffstats ( );
	}

	public String[] Get_DropSpotTypes ( ) {
		return Class_DropSpots_Controller.Get_DropSpotTypes ( );
	}

	public String[] Get_ContinentLocations ( ) {
		return Class_DropSpots_Controller.Get_ContinentLocations ( );
	}

	public int[] Get_LevelReqs ( ) {
		return Class_DropSpots_Controller.Get_LevelReqs ( );
	}

	public String[] Get_ZoneLocations ( ) {
		return Class_DropSpots_Controller.Get_ZoneLocations ( );
	}

	public String[] Get_Difficultys ( ) {
		return Class_DropSpots_Controller.Get_Difficultys ( );
	}

	public String[] Get_Instances ( ) {
		return Class_DropSpots_Controller.Get_Instances ( );
	}

	public Interface_Dropspot[] Get_DropSpotList ( ) {
		return Class_DropSpots_Controller.Get_DropSpotList ( );
	}

	public Object Get_Seal ( String currComp ) {
		return Class_Abilities_Controller.Get_Seal ( currComp );
	}

	public void UserCommand_ChangeActiveSeal ( String newSelect_Seal ) {
		Class_Abilities_Controller.UserCommand_ChangeActiveSeal ( newSelect_Seal );
	}

	public String[] Get_AvailableSeals ( ) {
		return Class_Abilities_Controller.Get_AvailableSeals ( );
	}

	public void UserCommand_ResetComparisonstats ( ) {
		this.Class_Comparison_Controller.UserCommand_ResetComparisonstats ( );
	}

	public void Call_ComparingWindowComparison ( ) {
		Class_Comparison_Controller.Call_ComparingWindowComparison() ;
	}

	public void UserCommand_DropSpotTreeSelection ( Panel_DropSpotTree panel_DropSpotTree ) {
		Class_DropSpots_Controller.UserCommand_DropSpotTreeSelection ( panel_DropSpotTree );
		
	}

	public String[] Get_EnchantSlots ( ) {
		return Class_Enchants_Controller.Get_EnchantSlots ( );
	}

	public void Call_FilterEnchants ( ) {
		Class_Enchants_Controller.Call_FilterEnchants ( );
	}

	public Interface_Enchant[] Get_EnchantList_LibraryFiltered ( ) {
		return Class_Enchants_Controller.Get_EnchantList_LibraryFiltered ( );
	}

	public void Call_AutoEnchant ( ) {
		Class_Enchants_Controller.Call_AutoEnchant ( );
	}

	public String[] Get_CharSlots ( ) {
		return this.Class_Character_Controller.Get_CharSlots ( );
	}

	public Interface_GearCombo[] Get_GearCombos ( ) {
		return Class_Gear_Controller.Get_GearCombos ( );
	}

	public boolean Call_GearComboChange ( String actionCommand ) {
		return Class_Gear_Controller.Call_GearComboChange ( actionCommand );
	}

	public void SetStatusText ( String message ) {
		this.Class_GUI_Controller.SetStatusText ( message );
	}

	public void Call_CalculateAllComboDPS ( ) {
		this.Class_Comparison_Controller.Call_CalculateAllComboDPS ( );
	}

	public Interface_GearCombo Get_CurrentGearCombo ( ) {
		return Class_Gear_Controller.Get_CurrentGearCombo ( );
	}

	public void Call_SaveGearCombo ( String text ) {
		Class_Gear_Controller.Call_SaveGearCombo ( text );
	}

	public void Call_HentItemTilGearEdit ( String string, String string2, boolean b ) {
		Class_Gear_Controller.Call_HentItemTilGearEdit ( string, string2, b );
	}

	public void Call_HentComboTilComboEdit ( String string ) {
		Class_Gear_Controller.Call_HentComboTilComboEdit ( string );
	}

	public void Call_FillGearPanelGearList ( String string ) {
		Class_Gear_Controller.Call_FillGearPanelGearList ( string );
	}

	public void Call_FillGearComboList ( ) {
		Class_Gear_Controller.Call_FillGearComboList ( );
	}

	public void Call_SetItemAsCurrent ( ) {
		Class_Gear_Controller.Call_SetItemAsCurrent ( );
	}

	public String[] Get_GearSlots ( ) {
		return Class_Gear_Controller.Get_GearSlots ( );
	}

	public Interface_Gear[] Get_FilteredGearlist ( ) {
		return Class_Gear_Controller.Get_FilteredGearlist ( );
	}

	public Interface_Dropspot Get_DropSpotFromID ( int getDropspotID ) {
		return Class_DropSpots_Controller.Get_DropSpotFromID ( getDropspotID );
	}

	public void Set_ComboBoxFilters ( int y, String string ) {
		Class_Gear_Controller.Set_ComboBoxFilters ( y, string );
	}

	public void Set_ComboBoxSorting ( int y, String string ) {
		Class_Gear_Controller.Set_ComboBoxSorting ( y, string );
	}

	public void Set_CheckBoxFilters ( int y, boolean selected ) {
		Class_Gear_Controller.Set_CheckBoxFilters ( y, selected );
	}

	public Interface_Dropspot[] Get_DropSpotList_Upgrade ( ) {
		return this.Class_DropSpots_Controller.Get_DropSpotList_Upgrade ( );
	}

	public void Call_AutoSocket ( ) {
		Class_Gear_Controller.Call_AutoSocket ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedRedUpgrade ( ) {
		return Class_Gems_Controller.Get_GemList_Normal_SortedRedUpgrade ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedBlueUpgrade ( ) {
		return Class_Gems_Controller.Get_GemList_Normal_SortedBlueUpgrade ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedYellowUpgrade ( ) {
		return Class_Gems_Controller.Get_GemList_Normal_SortedYellowUpgrade ( );
	}

	public void Set_Favorite_Red ( Interface_Gem interface_Gem, boolean b ) {
		Class_Gems_Controller.Set_Favorite_Red ( interface_Gem, b );
	}

	public void Set_Favorite_Blue ( Interface_Gem interface_Gem, boolean b ) {
		Class_Gems_Controller.Set_Favorite_Blue ( interface_Gem, b );
	}

	public void Set_Favorite_Yellow ( Interface_Gem interface_Gem, boolean b ) {
		Class_Gems_Controller.Set_Favorite_Yellow ( interface_Gem, b );
	}

	public void Call_LagreGemDatabase ( ) {
		Class_Gems_Controller.Call_LagreGemDatabase ( );
	}

	public Interface_Gem[] Get_GemList_SortedAllUpgrade ( ) {
		return Class_Gems_Controller.Get_GemList_SortedAllUpgrade ( );
	}

	public Interface_Gem[] GemList_Normal_SortedAlphabetically ( ) {
		return Class_Gems_Controller.GemList_Normal_SortedAlphabetically ( );
	}

	public Interface_Gem[] Get_MetaGemList ( ) {
		return Class_Gems_Controller.Get_MetaGemList ( );
	}

	public Interface_Gem[] Get_GemList_Meta_SortedAlphabetically ( ) {
		return Class_Gems_Controller.Get_GemList_Meta_SortedAlphabetically ( );
	}

	public int Get_MetaCounter ( ) {
		return Class_Gems_Controller.Get_MetaCounter ( );
	}

	public Interface_Gem[] Get_NormalGemList ( ) {
		return Class_Gems_Controller.Get_NormalGemList ( );
	}

	public void UserCommand_SaveGem ( ) {
		Class_Gems_Controller.UserCommand_SaveGem ( );
	}

	public void UserCommand_DeleteGem ( String name ) {
		Class_Gems_Controller.UserCommand_DeleteGem ( name );
	}

	public Interface_Profession[] Get_Professions ( ) {
		return Class_Professions_Controller.Get_Professions ( );
	}

	public Interface_Gear[] Get_GearItems ( ) {
		return Class_Professions_Controller.Get_GearItems ( );
	}

	public Interface_Enchant[] Get_EnchantList ( ) {
		return Class_Professions_Controller.Get_EnchantList ( );
	}

	public Interface_Special[] Get_Specials ( ) {
		return Class_Professions_Controller.Get_Specials ( );
	}

	public Interface_Specc[] Get_ClassSpeccs ( ) {
		return this.Class_Speccing_Controller.Get_ClassSpeccs ( );
	}

	public void Call_CalculateAllSpeccDPS ( ) {
		Class_Speccing_Controller.Call_CalculateAllSpeccDPS ( );
	}

	public Interface_Specc Get_EditedSpecc ( ) {
		return Class_Speccing_Controller.Get_EditedSpecc ( );
	}

	public void Call_NewComparison ( ) {
		Class_Comparison_Controller.Call_NewComparison ( );
	}

	public void Set_ComparedSpecc ( Interface_Specc get_EditedSpecc ) {
		Class_Speccing_Controller.Set_ComparedSpecc ( get_EditedSpecc );
	}

	public void Call_CalculateComparisonDPS ( ) {
		Class_Comparison_Controller.Call_CalculateComparisonDPS ( );
	}

	public void Set_DPSUpgrade ( ) {
		Class_Comparison_Controller.Set_DPSUpgrade ( );
	}

	public String Get_DPSUpgrade ( ) {
		return Class_Comparison_Controller.Get_DPSUpgrade ( );
	}

	public String Get_DPSUpgradePrcnt ( ) {
		return Class_Comparison_Controller.Get_DPSUpgradePrcnt ( );
	}

	public void Call_SpeccPoint ( Interface_TalentPoint interface_TalentPoint ) {
		Class_Comparison_Controller.Call_SpeccPoint ( interface_TalentPoint );
	}

	public void Call_EditedSpecc ( String text ) {
		Class_Comparison_Controller.Call_EditedSpecc ( text );
	}

	public boolean UserCommand_SaveSpecc ( String text ) {
		return Class_Comparison_Controller.UserCommand_SaveSpecc ( text );
	}

	public boolean UserCommand_LoadSpecc ( String string ) {
		return Class_Comparison_Controller.UserCommand_LoadSpecc ( string );
	}

	public Object_Stats Get_CurrentGemStats ( ) {
		return Class_Character_Controller.Get_CurrentGemStats ( );
	}

	public Object_Stats Get_CurrentEnchStats ( ) {
		return Class_Character_Controller.Get_CurrentEnchStats ( );
	}

	public Object_Stats Get_CurrentSpeccStats ( ) {
		return Class_Character_Controller.Get_CurrentSpeccStats ( );
	}

	public StatValues Get_StatValues ( ) {
		return this.Class_Comparison_Controller.Get_StatValues ( );
	}

	public Object_Stats Get_ClassBaseStats ( ) {
		return this.Class_Class_Controller.Get_ClassBaseStats ( );
	}
	
	public void Call_CalculateStatValues(){
		Class_Comparison_Controller.CalculateStatvalues();
	}

	public void Call_ShowStatValues ( StatValues statVerdiene ) {
		try {
			this.Class_GUI_Controller.ShowStatValues ( statVerdiene );
		} catch ( Exception e ){
			
		}
	}

	public void Call_SetComparedStats ( Object_Stats newstats, Object_ComparisonResult Results ) {
		this.Class_GUI_Controller.Call_SetComparedStats ( newstats, Results );
	}

	public Object_Stats Get_UsercomparisonChangedstats ( ) {
		return Class_GUI_Controller.Get_UsercomparisonChangedstats ( );
	}

	public Object_AbilityLibrary Get_NewAbilityLibrary ( ) {
		return this.Class_Abilities_Controller.Get_NewAbilityLibrary ( );
	}

	public void UpgradesUpdated ( StatValues statVerdiene ) {
		Class_GUI_Controller.UpgradesUpdated ( statVerdiene );
	}

	public Object_BuffLibrary Get_BuffList ( ) {
		return this.Class_Buffs_Controller.Get_BuffList();
	}

	public String Get_PlayerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object_ComparisonResult Get_CurrentHeal() {
		return this.Class_Comparison_Controller.Get_CurrentHeal();
	}
	
}
