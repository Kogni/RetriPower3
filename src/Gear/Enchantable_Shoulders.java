package Gear;
import java.io.Serializable;
import Gems.Object_Socket;

public class Enchantable_Shoulders extends Enchantable implements Serializable {
	
	private static final long	serialVersionUID	= 0010;

	public Enchantable_Shoulders ( String Name, int DropSpotID, int BuffID, String BoP, Object_Stats Statset, Object_Socket[] Socket, String Slot, String ItemType  ) {

		super ( Name, DropSpotID, BuffID, BoP, Statset, Socket, Slot, ItemType );
		// TODO Auto-generated constructor stub
	}

}
