package Gear;
import java.io.Serializable;
import Gems.Object_Socket;

public class Statpiece extends Gear implements Interface_Statpiece, Serializable {
	
	private static final long	serialVersionUID	= 0104;
	
	private Object_Stats Statset;
	private String GearSet;
	private Object_Socket[] Socket = new Object_Socket[4];

	public Statpiece ( String Name, int DropSpotID, int BuffID, String BoP, Object_Stats Statset, Object_Socket[] Socket, String Slot, String ItemType ) {

		super ( Name, DropSpotID, BuffID, BoP, Slot, ItemType );
		this.Statset = Statset;
		this.Socket = Socket;
		GearSet = FinnGearSet();
		
	}
	
	private String FinnGearSet(){
		
		return null;
	}

	public String GetSet ( ) {
		return GearSet;
	}

	public Object_Socket GetSocket ( int SocketNmbr ) {
		return Socket[SocketNmbr];
	}

	public Object_Stats GetStatset ( ) {
		return Statset;
	}

	public void SetSocket ( Object_Socket S, int SocketNmbr ) {
		Socket[SocketNmbr] = S;
	}

	public void SetStatset ( Object_Stats Statset ) {
		this.Statset = Statset;
	}

	public Object_Socket[] GetSockets ( ) {

		return this.Socket;
	}

	
}
