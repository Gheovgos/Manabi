package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

import controller.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;

public class CreaStudente {
	
	

	private JFrame frame;
	Controller controller;
	private JTextField txtInserisciUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane txtpnUsername;
	private JTextPane txtpnUsername_1;
	private JTextPane txtpnUsername_2;
	private JTextPane txtpnUsername_3;
	private JTextPane txtpnUsername_4;
	private JTextPane txtpnUsername_6;
	private JTextPane txtpnInserisci;
	private JButton btnNewButton;
	private JButton btnAvanti;

	public CreaStudente(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtInserisciUsername = new JTextField();
		txtInserisciUsername.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtInserisciUsername.setBounds(235, 46, 96, 19);
		frame.getContentPane().add(txtInserisciUsername);
		txtInserisciUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 162, 96, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(235, 133, 96, 19);
		frame.getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textField.setColumns(10);
		textField.setBounds(235, 104, 96, 19);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textField_1.setColumns(10);
		textField_1.setBounds(235, 75, 96, 19);
		frame.getContentPane().add(textField_1);
		
		txtpnUsername = new JTextPane();
		txtpnUsername.setText("USERNAME");
		txtpnUsername.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(156, 42, 79, 19);
		frame.getContentPane().add(txtpnUsername);
		
		txtpnUsername_1 = new JTextPane();
		txtpnUsername_1.setText("NOME");
		txtpnUsername_1.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_1.setEditable(false);
		txtpnUsername_1.setBounds(187, 72, 48, 19);
		frame.getContentPane().add(txtpnUsername_1);
		
		txtpnUsername_2 = new JTextPane();
		txtpnUsername_2.setText("COGNOME");
		txtpnUsername_2.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_2.setEditable(false);
		txtpnUsername_2.setBounds(163, 101, 79, 19);
		frame.getContentPane().add(txtpnUsername_2);
		
		txtpnUsername_3 = new JTextPane();
		txtpnUsername_3.setText("PASSWORD");
		txtpnUsername_3.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_3.setEditable(false);
		txtpnUsername_3.setBounds(158, 130, 79, 19);
		frame.getContentPane().add(txtpnUsername_3);
		
		txtpnUsername_4 = new JTextPane();
		txtpnUsername_4.setText("CONFERMA PASSWORD");
		txtpnUsername_4.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_4.setEditable(false);
		txtpnUsername_4.setBounds(87, 158, 171, 19);
		frame.getContentPane().add(txtpnUsername_4);
		
		txtpnUsername_6 = new JTextPane();
		txtpnUsername_6.setText("UTENTE STUDENTE");
		txtpnUsername_6.setFont(new Font("Dubai", Font.BOLD, 16));
		txtpnUsername_6.setEditable(false);
		txtpnUsername_6.setBounds(42, 10, 149, 29);
		frame.getContentPane().add(txtpnUsername_6);
		
		txtpnInserisci = new JTextPane();
		txtpnInserisci.setText("compila dati");
		txtpnInserisci.setFont(new Font("Dubai", Font.PLAIN, 13));
		txtpnInserisci.setEditable(false);
		txtpnInserisci.setBounds(188, 12, 176, 19);
		frame.getContentPane().add(txtpnInserisci);
		
		btnNewButton = new JButton("INDIETRO");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoAccount tipoAccount = new TipoAccount(controller);
				frame.setVisible(false);
				tipoAccount.setVisible(true);
			}
		});
		btnNewButton.setBounds(62, 220, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		btnAvanti = new JButton("AVANTI");
		btnAvanti.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAvanti.setBounds(157, 220, 85, 21);
		frame.getContentPane().add(btnAvanti);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


}
