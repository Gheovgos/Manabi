package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestCompletato {

	private JFrame frame;
	Controller controller;
	
	public TestCompletato(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Torna al Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuStudente back = new MenuStudente(controller);
				frame.setVisible(false);
				back.frmManabi.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 227, 107, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
