package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisualizzaTestCreati {

	JFrame frame;
	Controller controller;
	private JTextField textField;

	public VisualizzaTestCreati(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 432, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnTestCreati = new JTextPane();
		txtpnTestCreati.setText("Cerca test:");
		txtpnTestCreati.setEditable(false);
		txtpnTestCreati.setBounds(10, 11, 215, 20);
		frame.getContentPane().add(txtpnTestCreati);
		
		textField = new JTextField();
		textField.setBounds(10, 42, 285, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.setBounds(317, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				back.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 151, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnToglimi = new JTextPane();
		txtpnToglimi.setText("");
		txtpnToglimi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpnToglimi.setEditable(false);
		txtpnToglimi.setBounds(10, 73, 396, 64);
		frame.getContentPane().add(txtpnToglimi);
		
		JButton btnNewButton_2 = new JButton("Cerca");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean trovato = controller.checkTestName(textField.getText(), controller.i.username);
				if(trovato) {
					txtpnToglimi.setText("controller");
					controller.caricaTest(textField.getText(), controller.i.username); 
				}
				else {
					txtpnToglimi.setText("Nessun risultato per "+textField.getText());
				}
				
			}
		});
		btnNewButton_2.setBounds(317, 41, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
