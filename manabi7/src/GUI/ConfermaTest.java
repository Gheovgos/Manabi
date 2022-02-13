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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

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
		frame.setTitle("Manabi");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ConfermaTest.class.getResource("/Immagini/icona manabi.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel pngCheck = new JLabel("");
		pngCheck.setIcon(new ImageIcon(ConfermaTest.class.getResource("/Immagini/ok-xxl.png")));
		pngCheck.setBounds(200, 55, 40, 40);
		frame.getContentPane().add(pngCheck);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				
				
			}
		});
		btnNewButton.setBounds(87, 137, 120, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CREA QUESITI");
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				QuizMaker next = new QuizMaker(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(230, 137, 120, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnTestCreatoCon = new JTextPane();
		txtpnTestCreatoCon.setEditable(false);
		txtpnTestCreatoCon.setText("Test creato con successo. Puoi tornare alla homepage o creare i quesiti al tuo test.");
		txtpnTestCreatoCon.setBounds(27, 104, 387, 23);
		frame.getContentPane().add(txtpnTestCreatoCon);
	}
}
