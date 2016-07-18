package Speccing;

import javax.swing.*;
import Standalone.*;

public class Object_Talent implements Interface_Talent {

	String					Talentname;
	String					Tree;
	int						TreeRow;
	int						TreeCollumn;
	int						Points			= 0;
	Object_TalentPoint[]	TalentPoints	= new Object_TalentPoint[6];
	ImageIcon				TalentIcon;

	public Object_Talent ( String TalentnameT, String TreeT, int TreeRowT, int TreeCollumnT, String TalentIconPath ) {
		this.Talentname = TalentnameT;
		this.Tree = TreeT;
		this.TreeRow = TreeRowT;
		this.TreeCollumn = TreeCollumnT;
		this.TalentIcon = new ImageIcon ( TalentIconPath );
	}

	public void InsertTalentpointIfRightTalent ( Object_TalentPoint Point ) {
		if ( Point.TalentName.equals ( this.Talentname ) ) {
			this.Points++;
			this.TalentPoints[this.Points] = Point;
		}
	}

	public Capsule Get_Capsule_TalentPoints ( ) {

		// TODO Auto-generated method stub
		return null;
	}
	
	public Object_TalentPoint[] Get_Talentpoints(){
		return TalentPoints;
	}

	public String Get_TalentIconPath ( ) {

		// TODO Auto-generated method stub
		return null;
	}

	public int Get_TalentPoints ( ) {
		return Points;
	}

	public String Get_Tree ( ) {
		return Tree;
	}

	public int Get_TreeCollumn ( ) {
		return TreeCollumn;
	}

	public int Get_TreeRow ( ) {
		return TreeRow;
	}

}
