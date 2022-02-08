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

public class ConfermaTest {

	JFrame frmManabi;
	Controller controller;
	
	public ConfermaTest(Controller c) {
		controller = c;
		initialize();
		frmManabi.setVisible(true);
	}

	
	private void initialize() {
		frmManabi = new JFrame();
		frmManabi.setTitle("Manabi");
		frmManabi.setIconImage(Toolkit.getDefaultToolkit().getImage(ConfermaTest.class.getResource("/Immagini/ok-xxl.png")));
		frmManabi.getContentPane().setBackground(Color.WHITE);
		frmManabi.setBounds(100, 100, 450, 300);
		frmManabi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManabi.getContentPane().setLayout(null);
		
		JLabel pngCheck = new JLabel("");
		pngCheck.setIcon(new ImageIcon(ConfermaTest.class.getResource("/Immagini/ok-xxl.png")));
		pngCheck.setBounds(200, 55, 40, 40);
		frmManabi.getContentPane().add(pngCheck);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				MenuInsegnante back = new MenuInsegnante(controller);
				frmManabi.setVisible(false);
				back.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(87, 137, 120, 23);
		frmManabi.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crea quesiti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				QuizMaker next = new QuizMaker(controller);
				frmManabi.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(230, 137, 120, 23);
		frmManabi.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnTestCreatoCon = new JTextPane();
		txtpnTestCreatoCon.setEditable(false);
		txtpnTestCreatoCon.setText("Test creato con successo. Puoi tornare alla homepage o creare i quesiti al tuo test.");
		txtpnTestCreatoCon.setBounds(18, 106, 404, 23);
		frmManabi.getContentPane().add(txtpnTestCreatoCon);
	}
}
