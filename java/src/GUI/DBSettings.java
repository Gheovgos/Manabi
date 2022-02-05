package GUI;

import java.awt.EventQueue;
import Database.*;
import controller.*;
import PostgresDAO.*;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class DBSettings {

	JFrame frame;
	private JTextField textOutput;
	Controller controller;


	public DBSettings(Controller c) {
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
		
		JTextPane txtpnImpostazioniDatabase = new JTextPane();
		txtpnImpostazioniDatabase.setEditable(false);
		txtpnImpostazioniDatabase.setText("Impostazioni Database");
		txtpnImpostazioniDatabase.setBounds(10, 11, 148, 20);
		frame.getContentPane().add(txtpnImpostazioniDatabase);
		
		JButton btnBack = new JButton("Indietro");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso back = new Accesso(controller);
				back.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textOutput = new JTextField();
		textOutput.setHorizontalAlignment(SwingConstants.LEFT);

		textOutput.setEditable(false);
		textOutput.setBounds(10, 73, 414, 130);
		frame.getContentPane().add(textOutput);
		textOutput.setColumns(10);
		
		JButton btnNewButton = new JButton("Test connessione");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				InsegnanteDAO verifica = new InsegnanteDAO();
				if(verifica.Verifica()) {
					
					textOutput.setText("Connessione effettuata con successo.");
					
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(20, 42, 138, 23);
		frame.getContentPane().add(btnNewButton);
		

	}
}
