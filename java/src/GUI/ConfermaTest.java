package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import modelli.Quesiti;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfermaTest {

	JFrame frame;
	Controller controller;
	
	public ConfermaTest(Controller c) {
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
		
		JLabel pngCheck = new JLabel("");
		pngCheck.setIcon(new ImageIcon(ConfermaTest.class.getResource("/Immagini/check.png")));
		pngCheck.setBounds(200, 55, 40, 40);
		frame.getContentPane().add(pngCheck);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				back.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 212, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crea quesiti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				controller.q = new Quesiti(); 
				QuizMaker next = new QuizMaker(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(335, 212, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnTestCreatoCon = new JTextPane();
		txtpnTestCreatoCon.setEditable(false);
		txtpnTestCreatoCon.setText("Test creato con successo. Puoi tornare alla homepage o creare i quesiti al tuo test.");
		txtpnTestCreatoCon.setBounds(20, 106, 414, 79);
		frame.getContentPane().add(txtpnTestCreatoCon);
	}
}
