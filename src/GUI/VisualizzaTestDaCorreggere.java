package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import controller.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class VisualizzaTestDaCorreggere {

	JFrame frame;
	Controller controller;
	

	public VisualizzaTestDaCorreggere(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}


	private void initialize() {
		
		String[] rs = controller.returnTestName(controller.i.username, 0);
		int max = rs.length;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(10, 61, 207, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnSelezionaIlTest = new JTextPane();
		txtpnSelezionaIlTest.setEditable(false);
		txtpnSelezionaIlTest.setText("Seleziona il test da correggere:");
		txtpnSelezionaIlTest.setBounds(10, 11, 238, 20);
		frame.getContentPane().add(txtpnSelezionaIlTest);
		
		JTextPane txtpnNonPuoiCreare = new JTextPane();
		txtpnNonPuoiCreare.setText("Non ci sono test da correggere.");
		txtpnNonPuoiCreare.setEditable(false);
		txtpnNonPuoiCreare.setVisible(false);
		txtpnNonPuoiCreare.setBounds(10, 30, 396, 23);
		frame.getContentPane().add(txtpnNonPuoiCreare);
		
		
		JButton back = new JButton("Indietro");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		back.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(back);
		
		JButton correggiButton = new JButton("Correggi");
		correggiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected], controller.i.username);
				CorreggiTest next = new CorreggiTest(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		correggiButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(correggiButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(227, 61, 197, 22);
		frame.getContentPane().add(comboBox_1);
	}
}
