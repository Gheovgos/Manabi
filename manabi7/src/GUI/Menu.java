package GUI;

import java.awt.EventQueue;
import controller.*;

import javax.swing.JFrame;

public class Menu {
	
	Controller controller;

	private JFrame frame;

	public Menu(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
