package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CorreggiTest {

	JFrame frame;
	Controller controller;
	private JTextField txtTestIDinosauri;
	
	public CorreggiTest(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1103, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTestIDinosauri = new JTextField();
		txtTestIDinosauri.setText("TEST: I DINOSAURI");
		txtTestIDinosauri.setBounds(23, 24, 364, 20);
		frame.getContentPane().add(txtTestIDinosauri);
		txtTestIDinosauri.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(23, 55, 364, 22);
		frame.getContentPane().add(comboBox);
	}
}
