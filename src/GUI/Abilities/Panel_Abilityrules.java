package GUI.Abilities;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Abilities.Superclass_Ability;
import GUI.*;

public class Panel_Abilityrules extends JPanel {

	private GUI_Controller				Class_Controller;
	
	public JPanel						TotalPanel				= new JPanel ( );
	
		JScrollPane					AbilityScrollPanel	= new JScrollPane ( );
		JPanel						ScrollContent		= new JPanel ();
		JPanel[]					CollumnPanel		= new JPanel[100];		//one for each spell-variable
		JLabel[][]					RowText				= new JLabel[100][31];	//one for each spell and each variable

		int AbilitiesListed;
		String[] Name = new String[100];
		boolean[] Weaponbased = new boolean[100];
		String[] Damagetype = new String[100];
		boolean[] Mitigated = new boolean[100];	
		String[] Bonusdamagetype = new String[100];
		int[] Basecritbonus = new int[100];
		int[] Ticks = new int[100];
		int[] Stacks = new int[100];
		int[] Hitcap = new int[100];
		boolean[] IsDot = new boolean[100];
		boolean[] AppliesDoT = new boolean[100];
		boolean[] Meleehitprocc = new boolean[100];
		boolean[] Spellenchantproccing = new boolean[100];
		double[] Casttime = new double[100];
		double[] CD = new double[100];
		int[] Proccchance = new int[100];
		double[] Basemanacost;
		int[] Baseragecost = new int[100];
		int[] Baseenergycost = new int[100];
		int[] Baserunicpowercost = new int[100];
		int[] Bloodrunesneeded = new int[100];
		int[] Frostrunesneeded = new int[100];
		int[] Unholyrunesneeded = new int[100];
		int[] Runicpowergenerated = new int[100];
		boolean[] IsPet = new boolean[100];
		boolean[] IsDisease = new boolean[100];
		int[] TargetHealthMax = new int[100];
		int[] MaxTargetsHit = new int[100];
		boolean[] CauseDebuff = new boolean[100];
		boolean[] IsWeaponEnchant = new boolean[100];
		

	String						Task;										//skiller mellom panelene for å finne oppgaven
	Border						Border_Boxed;
	Border						Border_Separated;

	public Panel_Abilityrules (GUI_Controller Class_Controller) {
		
		this.Class_Controller = Class_Controller;
		//System.out.println ( new Throwable ( ).fillInStackTrace ( ).getStackTrace ( )[0].getClassName ( ) + " created" );
		
		this.add ( TotalPanel );
		this.TotalPanel.setPreferredSize ( new Dimension( 960, 685 ) );
		AbilityScrollPanel = new JScrollPane ( this.ScrollContent );
		this.TotalPanel.add ( this.AbilityScrollPanel );
		AbilityScrollPanel.setVerticalScrollBar(new JScrollBar());

		for ( int y = 1 ; y < this.CollumnPanel.length ; y++ ) {
			this.CollumnPanel[y] = new JPanel ( );
			this.CollumnPanel[y].setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
			this.ScrollContent.add ( this.CollumnPanel[y] );
		}

		this.Border_Boxed = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		this.Border_Separated = BorderFactory.createEmptyBorder ( 2, 5, 2, 5 );
		
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		this.ScrollContent.setLayout ( new BoxLayout ( this.ScrollContent, BoxLayout.LINE_AXIS ) );
		for ( int y = 1 ; y < this.CollumnPanel.length ; y++ ) { //rad istedenfor
			this.CollumnPanel[y].setLayout ( new BoxLayout ( this.CollumnPanel[y], BoxLayout.PAGE_AXIS ) );
			for ( int x = 1 ; x < this.RowText[y].length ; x++ ) { //x=ability#
				this.RowText[y][x] = new JLabel ( "" );
				this.RowText[y][x].setAlignmentX ( java.awt.Label.RIGHT );
				this.CollumnPanel[y].add ( this.RowText[y][x] );
				this.RowText[y][x].setBorder ( this.Border_Separated );
				this.RowText[y][x].setText ( "" );
			}
			this.CollumnPanel[y].setBorder ( this.Border_Separated );
		}
		
	}
	
	public void FillLabels () {
		
		for ( int y = 1 ; y < this.CollumnPanel.length ; y++ ) {
			for ( int x = 1 ; x < this.RowText[y].length ; x++ ) {
				this.RowText[y][1].setText ( "" );
			}
		}
		for ( int y = 1 ; y < this.RowText[y].length ; y++ ) {
			this.RowText[1][y].setBorder ( this.Border_Boxed );
		}
		
		AbilitiesListed = 0;
		
		int X = 1;
		RowText[1][X].setText ( "Ability");
		X++;
		RowText[1][X].setText ( "Weapon based");
		X++;
		RowText[1][X].setText ( "Damage type");
		X++;
		RowText[1][X].setText ( "Mitigated");
		X++;
		RowText[1][X].setText ( "Bonus damage type");
		X++;
		RowText[1][X].setText ( "Base crit bonus");
		X++;
		RowText[1][X].setText ( "Ticks");
		X++;
		RowText[1][X].setText ( "Stacks");
		X++;
		RowText[1][X].setText ( "Hit cap");
		X++;
		RowText[1][X].setText ( "IsDot");
		X++;
		RowText[1][X].setText ( "Applies DoT");
		X++;
		RowText[1][X].setText ( "Melee hit procc");
		X++;
		RowText[1][X].setText ( "Spell enchant proccing");
		X++;
		RowText[1][X].setText ( "Cast time");
		X++;
		RowText[1][X].setText ( "CD");
		X++;
		RowText[1][X].setText ( "Procc chance");
		X++;
		RowText[1][X].setText ( "Base mana cost");
		X++;
		RowText[1][X].setText ( "Base rage cost");
		X++;
		RowText[1][X].setText ( "Base energy cost");
		X++;
		RowText[1][X].setText ( "Base runic power cost");
		X++;
		RowText[1][X].setText ( "Blood runes needed");
		X++;
		RowText[1][X].setText ( "Frost runes needed");
		X++;
		RowText[1][X].setText ( "Unholy runes needed");
		X++;
		RowText[1][X].setText ( "Runic power generated");
		X++;
		RowText[1][X].setText ( "IsPet");
		X++;
		RowText[1][X].setText ( "IsDisease");
		X++;
		RowText[1][X].setText ( "TargetHealthMax");
		X++;
		RowText[1][X].setText ( "MaxTargetsHit");
		X++;
		RowText[1][X].setText ( "CauseDebuff");
		X++;
		RowText[1][X].setText ( "IsWeaponEnchant");

		FillAbilityRules();
		
	}
	
	private void FillAbilityRules(){
		//System.out.println("skal fylle inn ability rules");
	}

	public void SendInfoTilSpellTable ( Superclass_Ability superclass_Ability ) {

		AbilitiesListed ++;
		int X = 1;
		RowText[AbilitiesListed+1 ][1].setText ( superclass_Ability.Get_Name ( ));
		
	}

}
