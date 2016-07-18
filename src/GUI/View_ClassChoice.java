package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View_ClassChoice extends JFrame implements ActionListener {

	private JButton Chosen;
	private JComboBox ClassBox;
	GUI_Controller Class_Controller;

	public View_ClassChoice ( GUI_Controller Class_Controller ) {

		super ( "Choose class" );
		this.Class_Controller = Class_Controller;

		setSize ( 200, 100 );
		setResizable ( false );
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 2, 1 ) );
		
		ClassBox = new JComboBox();
		ClassBox.addItem ( "Paladin" );
		ClassBox.addItem ( "Priest" );

		//ClassBox.addActionListener ( this );
		ClassBox.setActionCommand ( "Class choice" );
		
		Chosen = new JButton("Start");
		Chosen.addActionListener ( this );
		
		add ( ClassBox );
		add ( Chosen );

		setVisible ( true );
	}

	public void actionPerformed ( ActionEvent e ) {
		
		Class_Controller.UserCommand_ClassChoice(ClassBox.getSelectedItem ( ).toString ( ));
		setVisible ( false );
		
	}
}
