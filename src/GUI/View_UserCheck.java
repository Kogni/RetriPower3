package GUI;
import java.awt.*;
import javax.swing.*;

public class View_UserCheck extends JFrame {

	public View_UserCheck ( String User ) {

		super ( "RetriPower WotLK - User Rejected" );

		setSize ( 400, 100 );
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		JTextArea Tekst3 = new JTextArea("Bruker "+User+", denne programkopien er ikke laget for deg. \nKontakt meg for å få en gyldig kopi.");
		Tekst3.setPreferredSize(new Dimension(400, 100));

		pane.add ( Tekst3, c );

		setVisible ( true );
		setResizable ( false );
	}

}
