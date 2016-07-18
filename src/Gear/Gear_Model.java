package Gear;

import Standalone.Interface_Gear;
import Standalone.Interface_GearCombo;

public class Gear_Model {
	
	//tar seg av alle gear items og gear comboer
	
	Gear_Controller Class_Gear_Controller;
	
	Interface_GearCombo[] GearCombos = new Interface_GearCombo[100];
	Interface_GearCombo ActiveCombo;
	
	public Gear_Model( Gear_Controller Class_Gear_Controller ) {
		
		this.Class_Gear_Controller = Class_Gear_Controller;
		
	}

	public Interface_GearCombo[] Get_GearCombos() {
		return GearCombos;
	}

	public boolean Call_GearComboChange(String actionCommand) {
		ActiveCombo.Set_InUse(false);
		for ( int A = 0 ; A < GearCombos.length ; A++ ) {
			if ( GearCombos[A] != null ) {
				if ( GearCombos[A].Get_Name().equals(actionCommand)) {
					GearCombos[A].Set_InUse(true);
					ActiveCombo = GearCombos[A];
				}
			}
		}
		return false;
	}

	public Interface_GearCombo Get_CurrentGearCombo() {
		return ActiveCombo;
	}

	public void Call_SaveGearCombo(String text) {
		// TODO Auto-generated method stub
		
	}

	public void Call_HentItemTilGearEdit(String string, String string2, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void Call_HentComboTilComboEdit(String string) {
		// TODO Auto-generated method stub
		
	}

	public void Call_FillGearPanelGearList(String string) {
		// TODO Auto-generated method stub
		
	}

	public void Call_FillGearComboList() {
		// TODO Auto-generated method stub
		
	}

	public void Call_SetItemAsCurrent() {
		// TODO Auto-generated method stub
		
	}

	public String[] Get_GearSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	public Interface_Gear[] Get_FilteredGearlist() {
		// TODO Auto-generated method stub
		return null;
	}

	public Interface_Gear[] Get_GearItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void Call_CalculateAllComboDPS() {
		// TODO Auto-generated method stub
		
	}

	public void Set_ComboBoxFilters(int y, String string) {
		// TODO Auto-generated method stub
		
	}

	public void Set_ComboBoxSorting(int y, String string) {
		// TODO Auto-generated method stub
		
	}

	public void Set_CheckBoxFilters(int y, boolean selected) {
		// TODO Auto-generated method stub
		
	}

	public void Call_AutoSocket() {
		// TODO Auto-generated method stub
		
	}

}
