package GUI;

import java.awt.EventQueue;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class MenuInsegnante {

	JFrame frame;
	Controller controller;
	private JTextField txtBenvenuto;
	
	public MenuInsegnante(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtBenvenuto = new JTextField();
		txtBenvenuto.setBackground(Color.WHITE);
		txtBenvenuto.setEditable(false);
		txtBenvenuto.setText("Benvenuto, "+controller.i.username);
		txtBenvenuto.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(txtBenvenuto);
		txtBenvenuto.setColumns(10);
	}
}
