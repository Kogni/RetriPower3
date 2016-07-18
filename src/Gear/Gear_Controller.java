package Gear;

import Government.Govern_Controller;
import Standalone.Interface_Gear;
import Standalone.Interface_GearCombo;

public class Gear_Controller {
	
	Gear_Model Class_Gear_Model;

	public Gear_Controller ( Govern_Controller govern_Controller ) {

		Class_Gear_Model = new Gear_Model(this);
	}

	public Interface_GearCombo[] Get_GearCombos ( ) {
		return Class_Gear_Model.Get_GearCombos ( );
	}

	public boolean Call_GearComboChange ( String actionCommand ) {
		return Class_Gear_Model.Call_GearComboChange ( actionCommand );
	}

	public Interface_GearCombo Get_CurrentGearCombo ( ) {
		return Class_Gear_Model.Get_CurrentGearCombo ( );
	}

	public void Call_SaveGearCombo ( String text ) {
		Class_Gear_Model.Call_SaveGearCombo ( text );
	}

	public void Call_HentItemTilGearEdit ( String string, String string2, boolean b ) {
		Class_Gear_Model.Call_HentItemTilGearEdit ( string, string2, b );
	}

	public void Call_HentComboTilComboEdit ( String string ) {
		Class_Gear_Model.Call_HentComboTilComboEdit ( string );	
	}

	public void Call_FillGearPanelGearList ( String string ) {
		Class_Gear_Model.Call_FillGearPanelGearList ( string );
	}

	public void Call_FillGearComboList ( ) {
		Class_Gear_Model.Call_FillGearComboList ( );
	}

	public void Call_SetItemAsCurrent ( ) {
		Class_Gear_Model.Call_SetItemAsCurrent ( );	
	}

	public String[] Get_GearSlots ( ) {
		return Class_Gear_Model.Get_GearSlots ( );
	}

	public Interface_Gear[] Get_FilteredGearlist ( ) {
		return Class_Gear_Model.Get_FilteredGearlist ( );
	}

	public Interface_Gear[] Get_GearItems ( ) {
		return Class_Gear_Model.Get_GearItems ( );
	}

	public void Call_CalculateAllComboDPS ( ) {
		Class_Gear_Model.Call_CalculateAllComboDPS ( );
	}

	public void Set_ComboBoxFilters ( int y, String string ) {
		Class_Gear_Model.Set_ComboBoxFilters ( y, string );
	}

	public void Set_ComboBoxSorting ( int y, String string ) {
		Class_Gear_Model.Set_ComboBoxSorting ( y, string );
	}

	public void Set_CheckBoxFilters ( int y, boolean selected ) {
		Class_Gear_Model.Set_CheckBoxFilters ( y, selected );
	}

	public void Call_AutoSocket ( ) {
		Class_Gear_Model.Call_AutoSocket ( );
	}

}
