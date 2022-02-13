package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

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
		frame.setTitle("Manabi");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestCompletato.class.getResource("/Immagini/icona manabi.png")));
		frame.getContentPane().setForeground(Color.WHITE);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TestCompletato.class.getResource("/Immagini/ok-xxl.png")));
		lblNewLabel.setBounds(202, 44, 40, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnTes = new JTextPane();
		txtpnTes.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtpnTes.setEditable(false);
		txtpnTes.setText("Test completato!");
		txtpnTes.setBounds(179, 95, 131, 23);
		frame.getContentPane().add(txtpnTes);
	}
}
