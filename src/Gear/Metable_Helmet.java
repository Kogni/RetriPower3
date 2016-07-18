package Gear;
import java.io.Serializable;
import Gems.Object_Meta;
import Gems.Object_Socket;

public class Metable_Helmet extends Metable implements Serializable {
	
	private static final long	serialVersionUID	= 0014;

	public Metable_Helmet ( String Name, int DropSpotID, int BuffID, String BoP, Object_Stats Statset, Object_Socket[] Socket, Object_Meta SocketMeta, String Slot, String ItemType  ) {

		super ( Name, DropSpotID, BuffID, BoP, Statset, Socket, SocketMeta, Slot, ItemType );
		// TODO Auto-generated constructor stub
	}

}
