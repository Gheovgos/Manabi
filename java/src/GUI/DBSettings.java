package GUI;

import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textOutput = new JTextField();
		textOutput.setToolTipText("Console di Output");
		textOutput.setHorizontalAlignment(SwingConstants.LEFT);

		textOutput.setEditable(false);
		textOutput.setBounds(10, 73, 414, 130);
		frame.getContentPane().add(textOutput);
		textOutput.setColumns(10);
		
		JButton nuovoDB = new JButton("Crea DB");
		nuovoDB.setToolTipText("Se la verifica fallisce, premere qui per la creazione di un nuovo Database.");
		nuovoDB.setEnabled(false);
		nuovoDB.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(nuovoDB);
		
		JButton btnNewButton = new JButton("Test connessione");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				try {
					if(controller.checkConnection()) {
						
						textOutput.setText("Connessione effettuata con successo.\nNome: "+controller.connessione.nome+"\nConnessione: "+controller.connessione.url+"\nDriver: "+controller.connessione.driver);
						
					}
					else {textOutput.setText("Connessione al Database fallita. Clicca su 'Crea nuovo database' per creare un nuovo DB."); 	nuovoDB.setEnabled(false);}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(20, 42, 138, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		nuovoDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		

	}
}
