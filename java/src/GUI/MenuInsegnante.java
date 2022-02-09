package GUI;

import java.awt.EventQueue;
import controller.*;
import modelli.Quesiti;
import modelli.Test;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setBounds(100, 100, 649, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtBenvenuto = new JTextField();
		txtBenvenuto.setBackground(Color.WHITE);
		txtBenvenuto.setEditable(false);
		txtBenvenuto.setText("Benvenuto, "+controller.i.username);
		txtBenvenuto.setBounds(10, 11, 294, 20);
		frame.getContentPane().add(txtBenvenuto);
		txtBenvenuto.setColumns(10);
		
		JButton creaTest = new JButton("Crea nuovo Test");
		creaTest.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TestMaker testmaker = new TestMaker(controller);
				frame.setVisible(false);
				testmaker.frame.setVisible(true);
			}
		});
		creaTest.setToolTipText("Crea un nuovo test");
		creaTest.setBounds(10, 221, 613, 93);
		frame.getContentPane().add(creaTest);
		
		JButton vediTest = new JButton("Visualizza Test creati");
		vediTest.setToolTipText("Apre una finestra in cui puoi vedere i tuoi test creati e le relative informazioni");
		vediTest.setBounds(10, 119, 613, 93);
		frame.getContentPane().add(vediTest);
		
		JButton correggiTest = new JButton("Correggi Test");
		correggiTest.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				VisualizzaTestDaCorreggere next = new VisualizzaTestDaCorreggere(controller);
				next.frame.setVisible(true);
				
			}
		});
		correggiTest.setBounds(10, 325, 613, 93);
		frame.getContentPane().add(correggiTest);
		
		JButton creaQuiz = new JButton("Crea Quesiti");
		creaQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				VisualizzaTestCreati next = new VisualizzaTestCreati(controller); 
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		creaQuiz.setBounds(10, 44, 613, 64);
		frame.getContentPane().add(creaQuiz);
		
		JButton logout = new JButton("Logout");
		logout.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				logout Logout = new logout(controller);
				Logout.frmManabi.setVisible(true);
			}
		});
		logout.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(logout);
		
		JButton apriSettings = new JButton("Apri impostazioni");
		apriSettings.setBounds(10, 429, 613, 64);
		frame.getContentPane().add(apriSettings);
	}
}
