package Gear;
import java.io.Serializable;
import Gems.Object_Socket;

public class Enchantable extends Statpiece implements Interface_Enchantable,  Serializable  {
	
	private static final long	serialVersionUID	= 0100;
	
	public Enchantable ( String Name, int DropSpotID, int BuffID, String BoP, Object_Stats Statset, Object_Socket[] Socket, String Slot, String ItemType  ) {

		super ( Name, DropSpotID, BuffID, BoP, Statset, Socket, Slot, ItemType );

	}
	
}
