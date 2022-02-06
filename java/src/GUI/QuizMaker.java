package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
public class QuizMaker {

	JFrame frame;
	Controller controller;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public QuizMaker(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1156, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Genera");
		btnNewButton.setBounds(246, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnIdentificativoDomanda = new JTextPane();
		txtpnIdentificativoDomanda.setText("Identificativo domanda");
		txtpnIdentificativoDomanda.setBackground(new Color(255, 255, 255));
		txtpnIdentificativoDomanda.setEditable(false);
		txtpnIdentificativoDomanda.setBounds(10, 11, 130, 34);
		frame.getContentPane().add(txtpnIdentificativoDomanda);
		
		btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.setBounds(10, 478, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Salva");
		btnNewButton_2.setBounds(1018, 478, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(206, 55, 30, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(206, 86, 30, 20);
		frame.getContentPane().add(spinner_1);
		
		JEditorPane dtrpnLaDomandaVa = new JEditorPane();
		dtrpnLaDomandaVa.setText("La domanda va qui\r\nprova");
		dtrpnLaDomandaVa.setBounds(499, 11, 591, 263);
		frame.getContentPane().add(dtrpnLaDomandaVa);
	}
}
