package Gear;
import java.io.Serializable;
import Gems.Object_Meta;
import Gems.Object_Socket;

public class Metable extends Enchantable implements Interface_Metable, Serializable {
	
	private static final long	serialVersionUID	= 0103;
	
	private Object_Meta SocketMeta = null;
	
	public Metable ( String Name, int DropSpotID, int BuffID, String BoP, Object_Stats Statset, Object_Socket[] Socket, Object_Meta SocketMeta, String Slot, String ItemType  ) {

		super ( Name, DropSpotID, BuffID, BoP, Statset, Socket, Slot, ItemType );
		this.SocketMeta = SocketMeta;
	}

	public Object_Meta GetMeta ( ) {
		return SocketMeta;
	}

	public void SetMeta ( Object_Meta Meta ) {
		SocketMeta = Meta;
	}


	
}
