package Standalone;

import javax.swing.*;
import Abilities.Object_AbilityLibrary;


public interface Interface_Specc {

	Interface_Talent[] Get_Talents ( );

	String Get_Name ( );

	double Get_DPS ( );

	JButton Get_RespeccButton ( );

	void ApplySpecc ( Object_Stats PreSpeccStats, Object_Stats SpeccBonusStats, Object_AbilityLibrary abilities );

}
