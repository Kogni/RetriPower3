package Government;

import java.io.*;
import java.util.regex.*;
import javax.swing.*;
import GUI.*;

public class Startup {

	public static void main ( String[] args ) throws Exception {

		System.out.println ( "Starting RetriPower 3" );
		
		String macAddress = null;
		String command = "ipconfig /all";
		Process pid = Runtime.getRuntime().exec(command);
		BufferedReader in = new BufferedReader( new InputStreamReader(pid.getInputStream()));
		while ( true ) {
			String line = in.readLine();
			if (line == null)
				break;
			Pattern p = Pattern.compile(".*Physical Address.*: (.*)");
			Matcher m = p.matcher(line);
			if ( m.matches() ) {
				macAddress = m.group(1);
				break;
			}
		}
		in.close();
		
		String[] AuthorizedUser = new String[2];
		int X = -1;
		X++;
		AuthorizedUser[X]= "00-13-02-80-49-28";
		X++;
		AuthorizedUser[X]= "00-04-75-C3-DF-DA";
		boolean Accepted = false;
		for ( int A = 0 ; A <= X ; A++ ) {
			if ( macAddress.equals ( AuthorizedUser[X] ) ){
				Accepted = true;
			}
		}
		if ( Accepted == false ) {
			View_UserCheck Rejuected = new View_UserCheck(macAddress);
			Rejuected.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		} else {
			Govern_Controller Class_Controller = new Govern_Controller ( );
		}
        System.out.println(macAddress);

	}

}
