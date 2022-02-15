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
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class DBSettings {

	JFrame frame;
	private JTextPane textOutput;
	Controller controller;
	private JTextField getUrl;
	private JTextField getPass;

	public DBSettings(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(DBSettings.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
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
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso back = new Accesso(controller);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textOutput = new JTextPane();
		textOutput.setBorder(new LineBorder(new Color(0, 0, 0)));
		textOutput.setToolTipText("Console di Output");
		

		textOutput.setEditable(false);
		textOutput.setBounds(10, 73, 414, 130);
		frame.getContentPane().add(textOutput);
		
		JButton btnNewButton = new JButton("Test connessione");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				

				try {
					if(controller.checkConnection()) {
						
						textOutput.setText("Connessione effettuata con successo.\r\nNome: "+controller.getConnessione().getNome()+"\r\nConnessione: "+controller.getConnessione().getUrl()+"\r\nDriver: "+controller.getConnessione().getDriver());}
					else {textOutput.setText("Connessione al Database fallita.");}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(20, 42, 138, 23);
		frame.getContentPane().add(btnNewButton);
		
		getUrl = new JTextField();
		getUrl.setText("jdbc:postgresql://localhost:5432/Manabi");
		getUrl.setBounds(286, 11, 138, 20);
		frame.getContentPane().add(getUrl);
		getUrl.setColumns(10);
		
		getPass = new JTextField();
		getPass.setText("admin");
		getPass.setColumns(10);
		getPass.setBounds(286, 43, 138, 20);
		frame.getContentPane().add(getPass);
		
		JTextPane txtpnInserisciUrl = new JTextPane();
		txtpnInserisciUrl.setEditable(false);
		txtpnInserisciUrl.setText("Inserisci URL:");
		txtpnInserisciUrl.setBounds(181, 11, 77, 20);
		frame.getContentPane().add(txtpnInserisciUrl);
		
		JTextPane txtpnInserisciPassword = new JTextPane();
		txtpnInserisciPassword.setEditable(false);
		txtpnInserisciPassword.setText("Inserisci password:");
		txtpnInserisciPassword.setBounds(181, 42, 99, 20);
		frame.getContentPane().add(txtpnInserisciPassword);
		

	}
}
