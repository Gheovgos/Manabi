package GUI;

import javax.swing.JFrame;

import controller.Controller;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class UserSettings {

	private JFrame frame;
	Controller controller;
	private JTextField txtNom;
	private JTextField txtCon;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	boolean isIns;
	String oldUsername;

	public UserSettings(Controller c, boolean is) {
		controller = c;
		isIns = is;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UserSettings.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
		frame.setBounds(100, 100, 545, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 42, 223, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 73, 223, 20);
		frame.getContentPane().add(passwordField_1);
		
	
		
		JTextPane txtpnPasswordNonValida = new JTextPane();
		txtpnPasswordNonValida.setText("Le password deve essere pi\u00F9 lunga!");
		txtpnPasswordNonValida.setForeground(Color.RED);
		txtpnPasswordNonValida.setVisible(false);
		txtpnPasswordNonValida.setEditable(false);
		txtpnPasswordNonValida.setBounds(366, 42, 140, 34);
		frame.getContentPane().add(txtpnPasswordNonValida);
		
		JTextPane txtpnLePassowordNon = new JTextPane();
		txtpnLePassowordNon.setText("Le password non corrispondono!");
		txtpnLePassowordNon.setForeground(Color.RED);
		txtpnLePassowordNon.setVisible(false);
		txtpnLePassowordNon.setEditable(false);
		txtpnLePassowordNon.setBounds(223, 205, 96, 34);
		frame.getContentPane().add(txtpnLePassowordNon);
		
		JTextPane txtpnNomeNonValido = new JTextPane();
		txtpnNomeNonValido.setText("Nome non valido!");
		txtpnNomeNonValido.setForeground(Color.RED);
		txtpnNomeNonValido.setVisible(false);
		txtpnNomeNonValido.setEditable(false);
		txtpnNomeNonValido.setBounds(366, 104, 140, 20);
		frame.getContentPane().add(txtpnNomeNonValido);
		
		JTextPane txtpnCognomeNonValido = new JTextPane();
		txtpnCognomeNonValido.setText("Cognome non valido!");
		txtpnCognomeNonValido.setVisible(false);
		txtpnCognomeNonValido.setForeground(Color.RED);
		txtpnCognomeNonValido.setEditable(false);
		txtpnCognomeNonValido.setBounds(366, 135, 140, 20);
		frame.getContentPane().add(txtpnCognomeNonValido);
		
		txtNom = new JTextField();
		
		txtNom.setColumns(10);
		txtNom.setBounds(133, 104, 223, 20);
		frame.getContentPane().add(txtNom);
		
		txtCon = new JTextField();
		
		txtCon.setColumns(10);
		txtCon.setBounds(133, 135, 223, 20);
		frame.getContentPane().add(txtCon);
		if(isIns) {
			txtNom.setText(controller.getI().nome);
			txtCon.setText(controller.getI().cognome);
			
			oldUsername = controller.getI().username;
		}
		else {
			txtNom.setText(controller.getS().nome);
			txtCon.setText(controller.getS().cognome);
			
			oldUsername = controller.getS().username;
		}
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome:");
		txtpnNome.setEditable(false);
		txtpnNome.setBackground(Color.WHITE);
		txtpnNome.setBounds(85, 104, 38, 20);
		frame.getContentPane().add(txtpnNome);
		
		JTextPane txtpnCognome = new JTextPane();
		txtpnCognome.setText("Cognome:");
		txtpnCognome.setEditable(false);
		txtpnCognome.setBackground(Color.WHITE);
		txtpnCognome.setBounds(67, 135, 56, 20);
		frame.getContentPane().add(txtpnCognome);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.WHITE);
		txtpnPassword.setBounds(59, 42, 64, 20);
		frame.getContentPane().add(txtpnPassword);
		
		JTextPane txtpnConfermaPassword = new JTextPane();
		txtpnConfermaPassword.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnConfermaPassword.setText("Conferma password:");
		txtpnConfermaPassword.setEditable(false);
		txtpnConfermaPassword.setBackground(Color.WHITE);
		txtpnConfermaPassword.setBounds(37, 73, 96, 20);
		frame.getContentPane().add(txtpnConfermaPassword);
		
		JButton btnNewButton = new JButton("Indietro");
		
		btnNewButton.setBounds(10, 216, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salva");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean b, c, d, f; 
				String password, cpassword, nome, cognome;
				

				password = passwordField.getText();
				
				if(password.length() < 8 || password.length() > 25) {txtpnPasswordNonValida.setVisible(true); b = false;}
				else {txtpnPasswordNonValida.setVisible(false); b = true;}


				nome = txtNom.getText();
				if(nome.length() < 2) {txtpnNomeNonValido.setVisible(true); c = false;}
				else {txtpnNomeNonValido.setVisible(false); c = true;}
				
				cognome = txtCon.getText();
				if(cognome.length() < 2) {	txtpnCognomeNonValido.setVisible(true); d = false;}
				else {txtpnCognomeNonValido.setVisible(false); d = true;}
				
				cpassword = passwordField_1.getText();
				
				if(!password.equals(cpassword)) {txtpnLePassowordNon.setVisible(true); f = false;}
				else {txtpnLePassowordNon.setVisible(false); f = true;}
				
				
				if(b && c && d && f)
				{			
					if(isIns) {
						controller.aggiornaUtente(cpassword, nome, cognome, isIns, oldUsername);
						controller.caricaInsegnante(controller.getI().username);
						
					}
					else {
						controller.aggiornaUtente(cpassword, nome, cognome, isIns, oldUsername);
						controller.caricaStudente(controller.getS().username);						
					}					
				}
			}
		});
		
		btnNewButton_1.setBounds(417, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isIns) {
					
					frame.setVisible(false);
					frame.dispose();
					return;
				}
				else {
					
					frame.setVisible(false);
					frame.dispose();
					return;
				}
			}
			
		});
		
	
		
	
	}
}
