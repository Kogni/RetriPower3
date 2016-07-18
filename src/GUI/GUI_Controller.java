package GUI;

import java.awt.*;
import javax.swing.JFrame;
import Abilities.Superclass_Ability;
import GUI.Abilities.*;
import GUI.Buffs.*;
import GUI.Character.*;
import GUI.Comparison.*;
import GUI.Enchants.*;
import GUI.Gear.*;
import GUI.Gems.*;
import GUI.Profession.*;
import GUI.Speccing.*;
import Government.Govern_Controller;
import Standalone.*;

public class GUI_Controller {
	
	Govern_Controller Class_Govern_Controller;
	
	View_Menu Class_View_Menu;
	View_ClassChoice Class_View_ClassChoice;
	
	Panel_Charstats Class_Panel_Charstats;
	Panel_CharInfo Class_Panel_CharInfo;
	View_Character Class_View_Character;
	
	//Panel_SpellTable Class_Panel_SpellTable_Difference;
	Panel_Statistics Class_Panel_Statistics;
	View_Comparison Class_View_Comparison;
	
	Panel_CurrentSpecc Class_Panel_CurrentSpecc;
	Panel_TalentEditing Class_Panel_TalentEditing;
	Panel_SpeccListing Class_Panel_SpeccListing;
	View_Speccing Class_View_Speccing;
	
	//Panel_SpellTable Class_Panel_SpellTable_Current;
	//Panel_DPSOverview Class_Panel_DPSOverview;
	//Panel_Playingmodes Class_Panel_Playingmodes;
	//Panel_Cycle Class_Panel_Cycle_Current;
	//View_DPSCycles Class_View_DPSCycles;
	
	Panel_EditItem Class_Panel_EditItem_Current;
	Panel_EditItem Class_Panel_EditItem_Comparison;
	Panel_DropSpotTree Class_Panel_DropSpotTree_Library;
	Panel_GearLibrary Class_Panel_GearLibrary;
	Panel_EditCombo Class_Panel_EditCombo;
	Panel_ComboListing Class_Panel_ComboListing;
	Panel_CurrentCombo Class_Panel_CurrentCombo;
	View_Gear Class_View_Gear;
	
	View_Gems Class_View_Gems;
	
	View_Enchants Class_View_Enchants;
	
	View_Professions Class_View_Professions;
	
	Panel_Buffrules Class_Panel_Buffrules;
	View_Buffs Class_View_Buffs;
	
	Panel_Abilityrules Class_Panel_Abilityrules;
	View_Abilities Class_View_Abilities;
	
	public GUI_Controller( Govern_Controller Class_Govern_Controller){
		
		this.Class_Govern_Controller = Class_Govern_Controller;
		
		Class_View_ClassChoice = new View_ClassChoice(this);
		
	}

	public void UserCommand_ClassChoice ( String Class ) {

		Class_Govern_Controller.UserCommand_ClassChoice ( Class );
		
		Class_Panel_Charstats = new Panel_Charstats(this);
		Class_Panel_CharInfo = new Panel_CharInfo(this);
		Class_View_Character = new View_Character(this);
		
		//Class_Panel_SpellTable_Difference = new Panel_SpellTable(this);
		Class_Panel_Statistics = new Panel_Statistics(this);
		Class_View_Comparison = new View_Comparison(this);
		
		Class_Panel_CurrentSpecc = new Panel_CurrentSpecc(this);
		Class_Panel_TalentEditing = new Panel_TalentEditing(this);
		Class_Panel_SpeccListing = new Panel_SpeccListing(this);
		Class_View_Speccing = new View_Speccing(this);
		
		//Class_Panel_SpellTable_Current = new Panel_SpellTable(this);
		//Class_Panel_DPSOverview = new Panel_DPSOverview(this);
		//Class_Panel_Playingmodes = new Panel_Playingmodes(this);
		//Class_Panel_Cycle_Current = new Panel_Cycle(this);
		//Class_View_DPSCycles = new View_DPSCycles(this);
		
		Class_Panel_EditItem_Current = new Panel_EditItem("Current", this);
		Class_Panel_EditItem_Comparison = new Panel_EditItem("Comparison", this);
		Class_Panel_DropSpotTree_Library = new Panel_DropSpotTree(this);
		Class_Panel_GearLibrary = new Panel_GearLibrary(this);
		Class_Panel_EditCombo = new Panel_EditCombo(this);
		Class_Panel_ComboListing = new Panel_ComboListing(this);
		Class_Panel_CurrentCombo = new Panel_CurrentCombo(this);
		Class_View_Gear = new View_Gear(this);
		
		Class_View_Gems = new View_Gems(this);
		
		Class_View_Enchants = new View_Enchants(this);
		
		Class_View_Professions = new View_Professions(this);
		
		Class_Panel_Buffrules = new Panel_Buffrules(this);
		Class_View_Buffs = new View_Buffs(this);
		
		Class_Panel_Abilityrules = new Panel_Abilityrules(this);
		Class_View_Abilities = new View_Abilities(this);
		
		Class_View_Menu = new View_Menu(this);
		Class_View_Menu.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		Class_View_Menu.Startup ( );
		
	}
	
	public void UserCommand_OpenCharacter ( ) {

		Class_View_Character.VisVindu ( );
		
	}

	public void UserCommand_OpenStatComparison ( ) {

		Class_View_Comparison.setVisible ( true );
		System.out.println ( "A" );
		Class_Govern_Controller.Call_CalculateStatValues ( );
		
	}

	public void UserCommand_OpenSpeccing ( ) {

		Class_View_Speccing.setVisible ( true );
		
	}

	public void UserCommand_OpenDPSScreen ( ) {

		//this.Class_Panel_SpellTable_Current.FillLabels ( );
		//Class_View_DPSCycles.setVisible ( true );
		
	}

	public void UserCommand_OpenGearScreen ( ) {

		Class_View_Gear.setVisible ( true );
		
	}

	public void UserCommand_OpenGems ( ) {

		Class_View_Gems.setVisible ( true );
		
	}

	public void UserCommand_OpenEnchants ( ) {

		Class_View_Enchants.setVisible ( true );
		
	}

	public void UserCommand_OpenProfessions ( ) {

		Class_View_Professions.setVisible ( true );
		
	}

	public void UserCommand_OpenBuffs ( ) {

		Class_View_Buffs.setVisible ( true );
		
	}

	public void UserCommand_OpenAbilities ( ) {

		Class_View_Abilities.setVisible ( true );
		Class_Panel_Abilityrules.FillLabels ( );
		
	}

	public Panel_Abilityrules Get_Class_Panel_Abilityrules ( ) {
		return Class_Panel_Abilityrules;
	}

	public Panel_Buffrules Get_Class_Panel_Buffrules ( ) {
		return Class_Panel_Buffrules;
	}

	public Panel_Charstats Get_Class_Panel_Charstats ( ) {
		return this.Class_Panel_Charstats;
	}

	public Panel_CharInfo Get_Class_Panel_CharInfo ( ) {
		return this.Class_Panel_CharInfo;
	}

	public Panel_Statistics Get_Class_Panel_Statistics ( ) {
		return Class_Panel_Statistics;
	}
	
	public Panel_EditItem Get_Panel_EditItem_Current ( ) {
		return Class_Panel_EditItem_Current;
	}

	public Panel_EditItem Get_Panel_EditItem_Compared ( ) {
		return Class_Panel_EditItem_Comparison;
	}
	
	public Panel_DropSpotTree Get_Panel_DropSpotTree_Library ( ) {
		return Class_Panel_DropSpotTree_Library;
	}
	
	public Panel_GearLibrary Get_Panel_GearLibrary ( ) {
		return Class_Panel_GearLibrary;
	}

	public Panel_EditCombo Get_Panel_EditCombo ( ) {
		return Class_Panel_EditCombo;
	}

	public Panel_ComboListing Get_Panel_ComboListing ( ) {
		return Class_Panel_ComboListing;
	}

	public Panel_CurrentCombo Get_Panel_CurrentCombo ( ) {
		return Class_Panel_CurrentCombo;
	}
	
	public Panel_CurrentSpecc Get_Class_Panel_CurrentSpecc ( ) {
		return Class_Panel_CurrentSpecc;
	}

	public Panel_TalentEditing Get_Class_Panel_TalentEditing ( ) {
		return Class_Panel_TalentEditing;
	}

	public Panel_SpeccListing Get_Class_Panel_SpeccListing ( ) {
		return Class_Panel_SpeccListing;
	}
	/*
	public Panel_DPSOverview Get_Panel_DPSOverview ( ) {
		return Class_Panel_DPSOverview;
	}

	public Panel_Playingmodes Get_Panel_Playingmodes ( ) {
		return Class_Panel_Playingmodes;
	}

	public Panel_Cycle Get_Panel_Cycle_Current ( ) {
		return Class_Panel_Cycle_Current;
	}
	*/
	//--------------------------------- GUI over
	
	public Object_Stats Get_CharBasestats ( ) {
		return Class_Govern_Controller.Get_CharBasestats ( );
	}

	public Object_Stats Get_CurrentGearstats ( ) {
		return Class_Govern_Controller.Get_CurrentGearstats ( );
	}

	public Object_Stats Get_CurrentTotalstats ( ) {
		return Class_Govern_Controller.Get_CurrentTotalstats ( );
	}

	public Object_Stats Get_CurrentCombatstats ( ) {
		return Class_Govern_Controller.Get_CurrentCombatstats ( );
	}

	public Object_Stats Get_UsercomparisonCombatstats ( ) {
		return Class_Govern_Controller.Get_UsercomparisonCombatstats ( );
	}

	public Object_Stats Get_UsercomparisonBuffstats ( ) {
		return Class_Govern_Controller.Get_UsercomparisonBuffstats ( );
	}

	public void Call_ComparingWindowComparison ( ) {
		Class_Govern_Controller.Call_ComparingWindowComparison ( );
	}

	public void UserCommand_ResetComparisonstats ( ) {
		Class_Govern_Controller.UserCommand_ResetComparisonstats ( );
	}
	
	public void UserCommand_DropSpotTreeSelection ( Panel_DropSpotTree panel_DropSpotTree ) {
		Class_Govern_Controller.UserCommand_DropSpotTreeSelection ( panel_DropSpotTree );
	}

	public String[] Get_DropSpotTypes ( ) {
		return Class_Govern_Controller.Get_DropSpotTypes ( );
	}

	public String[] Get_ContinentLocations ( ) {
		return Class_Govern_Controller.Get_ContinentLocations ( );
	}

	public int[] Get_LevelReqs ( ) {
		return Class_Govern_Controller.Get_LevelReqs ( );
	}

	public String[] Get_ZoneLocations ( ) {
		return Class_Govern_Controller.Get_ZoneLocations ( );
	}

	public String[] Get_Difficultys ( ) {
		return Class_Govern_Controller.Get_Difficultys ( );
	}

	public String[] Get_Instances ( ) {
		return Class_Govern_Controller.Get_Instances ( );
	}

	public Interface_Dropspot[] Get_DropSpotList ( ) {
		return Class_Govern_Controller.Get_DropSpotList ( );
	}

	public Object Get_Seal ( String CurrComp ) {
		return Class_Govern_Controller.Get_Seal ( CurrComp );
	}

	public void UserCommand_ChangeActiveSeal ( String newSelect_Seal ) {
		Class_Govern_Controller.UserCommand_ChangeActiveSeal ( newSelect_Seal );
	}

	public String[] Get_AvailableSeals ( ) {
		return Class_Govern_Controller.Get_AvailableSeals ( );
	}

	public String[] Get_EnchantSlots ( ) {
		return Class_Govern_Controller.Get_EnchantSlots ( );
	}

	public void Call_FilterEnchants ( ) {
		Class_Govern_Controller.Call_FilterEnchants ( );
	}

	public Interface_Enchant[] Get_EnchantList_LibraryFiltered ( ) {
		return Class_Govern_Controller.Get_EnchantList_LibraryFiltered ( );
	}

	public void Call_AutoEnchant ( ) {
		Class_Govern_Controller.Call_AutoEnchant ( );
	}

	public String[] Get_CharSlots ( ) {
		return Class_Govern_Controller.Get_CharSlots ( );
	}

	public Interface_GearCombo[] Get_GearCombos ( ) {
		return Class_Govern_Controller.Get_GearCombos ( );
	}

	public boolean Call_GearComboChange ( String actionCommand ) {
		return Class_Govern_Controller.Call_GearComboChange ( actionCommand );
	}

	public void SetStatusText ( String Message ) {
		this.Class_View_Speccing.SetStatusText ( Message );
	}

	public void Call_CalculateAllComboDPS ( ) {
		Class_Govern_Controller.Call_CalculateAllComboDPS ( );
	}

	public Interface_GearCombo Get_CurrentGearCombo ( ) {
		return Class_Govern_Controller.Get_CurrentGearCombo ( );
	}

	public void Call_SaveGearCombo ( String text ) {
		Class_Govern_Controller.Call_SaveGearCombo ( text );
	}

	public void Call_HentItemTilGearEdit ( String string, String string2, boolean b ) {
		Class_Govern_Controller.Call_HentItemTilGearEdit ( string, string2, b );
	}

	public void Call_HentComboTilComboEdit ( String string ) {
		Class_Govern_Controller.Call_HentComboTilComboEdit ( string );
	}

	public void Call_FillGearPanelGearList ( String string ) {
		Class_Govern_Controller.Call_FillGearPanelGearList ( string );
	}

	public void Call_FillGearComboList ( ) {
		Class_Govern_Controller.Call_FillGearComboList ( );
	}

	public void Call_SetItemAsCurrent ( ) {
		Class_Govern_Controller.Call_SetItemAsCurrent ( );
	}

	public String[] Get_GearSlots ( ) {
		return Class_Govern_Controller.Get_GearSlots ( );
	}

	public Interface_Gear[] Get_FilteredGearlist ( ) {
		return Class_Govern_Controller.Get_FilteredGearlist ( );
	}

	public Interface_Dropspot Get_DropSpotFromID ( int getDropspotID ) {
		return Class_Govern_Controller.Get_DropSpotFromID ( getDropspotID );
	}

	public void Set_ComboBoxFilters ( int y, String string ) {
		Class_Govern_Controller.Set_ComboBoxFilters ( y, string );
	}

	public void Set_ComboBoxSorting ( int y, String string ) {
		Class_Govern_Controller.Set_ComboBoxSorting ( y, string );
	}

	public void Set_CheckBoxFilters ( int y, boolean selected ) {
		Class_Govern_Controller.Set_CheckBoxFilters ( y, selected );
	}

	public Interface_Dropspot[] Get_DropSpotList_Upgrade ( ) {
		return Class_Govern_Controller.Get_DropSpotList_Upgrade ( );
	}

	public void Call_AutoSocket ( ) {
		Class_Govern_Controller.Call_AutoSocket ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedRedUpgrade ( ) {
		return Class_Govern_Controller.Get_GemList_Normal_SortedRedUpgrade ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedBlueUpgrade ( ) {
		return Class_Govern_Controller.Get_GemList_Normal_SortedBlueUpgrade ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedYellowUpgrade ( ) {
		return Class_Govern_Controller.Get_GemList_Normal_SortedYellowUpgrade ( );
	}

	public void Set_Favorite_Red ( Interface_Gem interface_Gem, boolean b ) {
		Class_Govern_Controller.Set_Favorite_Red ( interface_Gem, b );
	}

	public void Set_Favorite_Blue ( Interface_Gem interface_Gem, boolean b ) {
		Class_Govern_Controller.Set_Favorite_Blue ( interface_Gem, b );
	}

	public void Set_Favorite_Yellow ( Interface_Gem interface_Gem, boolean b ) {
		Class_Govern_Controller.Set_Favorite_Yellow ( interface_Gem, b );
	}

	public void Call_LagreGemDatabase ( ) {
		Class_Govern_Controller.Call_LagreGemDatabase ( );
	}

	public Interface_Gem[] Get_GemList_SortedAllUpgrade ( ) {
		return Class_Govern_Controller.Get_GemList_SortedAllUpgrade ( );
	}

	public Interface_Gem[] Get_GemList_Normal_SortedAlphabetically ( ) {
		return Class_Govern_Controller.GemList_Normal_SortedAlphabetically ( );
	}

	public Interface_Gem[] Get_MetaGemList ( ) {
		return Class_Govern_Controller.Get_MetaGemList ( );
	}

	public Interface_Gem[] Get_GemList_Meta_SortedAlphabetically ( ) {
		return Class_Govern_Controller.Get_GemList_Meta_SortedAlphabetically ( );
	}

	public int Get_MetaCounter ( ) {
		return Class_Govern_Controller.Get_MetaCounter ( );
	}

	public Interface_Gem[] Get_NormalGemList ( ) {
		return Class_Govern_Controller. Get_NormalGemList ( );
	}

	public void UserCommand_SaveGem ( ) {
		Class_Govern_Controller.UserCommand_SaveGem ( );
	}

	public void UserCommand_DeleteGem ( String name ) {
		Class_Govern_Controller.UserCommand_DeleteGem ( name );
	}

	public Interface_Profession[] Get_Professions ( ) {
		return Class_Govern_Controller.Get_Professions ( );
	}

	public Interface_Gear[] Get_GearItems ( ) {
		return Class_Govern_Controller.Get_GearItems ( );
	}

	public Interface_Enchant[] Get_EnchantList ( ) {
		return Class_Govern_Controller.Get_EnchantList ( );
	}

	public Interface_Special[] Get_Specials ( ) {
		return Class_Govern_Controller.Get_Specials ( );
	}

	public Interface_Specc Get_CurrentSpecc ( ) {
		return Class_Govern_Controller.Get_CurrentSpecc ( );
	}

	public Interface_Specc[] Get_ClassSpeccs ( ) {
		return Class_Govern_Controller.Get_ClassSpeccs ( );
	}

	public void Call_CalculateAllSpeccDPS ( ) {
		Class_Govern_Controller.Call_CalculateAllSpeccDPS ( );
	}

	public Interface_Specc Get_EditedSpecc ( ) {
		return Class_Govern_Controller.Get_EditedSpecc ( );
	}

	public void Call_NewComparison ( ) {
		Class_Govern_Controller.Call_NewComparison ( );
	}

	public void Set_ComparedSpecc ( Interface_Specc get_EditedSpecc ) {
		Class_Govern_Controller.Set_ComparedSpecc ( get_EditedSpecc );
	}

	public void Call_CalculateComparisonDPS ( ) {
		Class_Govern_Controller.Call_CalculateComparisonDPS ( );
	}

	public void Set_DPSUpgrade ( ) {
		Class_Govern_Controller.Set_DPSUpgrade ( );
	}

	public String Get_DPSUpgrade ( ) {
		return Class_Govern_Controller.Get_DPSUpgrade ( );
	}

	public String Get_DPSUpgradePrcnt ( ) {
		return Class_Govern_Controller.Get_DPSUpgradePrcnt ( );
	}

	public void Call_SpeccPoint ( Interface_TalentPoint interface_TalentPoint ) {
		Class_Govern_Controller.Call_SpeccPoint ( interface_TalentPoint );
	}

	public void Call_EditedSpecc ( String text ) {
		Class_Govern_Controller.Call_EditedSpecc ( text );
	}

	public boolean UserCommand_SaveSpecc ( String text ) {
		return Class_Govern_Controller.UserCommand_SaveSpecc ( text );
	}

	public boolean UserCommand_LoadSpecc ( String string ) {
		return Class_Govern_Controller.UserCommand_LoadSpecc ( string );
	}

	public Object_Stats Get_CurrentGemStats ( ) {
		return Class_Govern_Controller.Get_CurrentGemStats ( );
	}

	public Object_Stats Get_CurrentEnchStats ( ) {
		return Class_Govern_Controller.Get_CurrentEnchStats ( );
	}

	public Object_Stats Get_CurrentSpeccStats ( ) {
		return Class_Govern_Controller.Get_CurrentSpeccStats ( );
	}

	public StatValues Get_StatValues ( ) {
		return Class_Govern_Controller.Get_StatValues ( );
	}

	public void ShowStatValues ( StatValues statVerdiene ) {
		Class_Panel_Statistics.ShowStatValues ( statVerdiene );	
	}

	public void Call_SetComparedStats ( Object_Stats newstats, Object_ComparisonResult Results ) {
		this.Class_View_Comparison.Call_SetComparedStats ( newstats );
		this.Class_Panel_Statistics.SetUpgrade(Results);
	}

	public Object_Stats Get_UsercomparisonChangedstats ( ) {
		return this.Class_View_Comparison.UserComparisonStats;
	}

	public void UpgradesUpdated ( StatValues statVerdiene ) {
		try {
			this.Class_Panel_Statistics.UpgradesUpdated ( statVerdiene );
		} catch ( Exception e ){
			
		}
	}

	public Object_ComparisonResult Get_CurrentHeal() {
		return this.Class_Govern_Controller.Get_CurrentHeal();
	}

}