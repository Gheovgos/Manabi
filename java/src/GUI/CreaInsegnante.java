package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CreaInsegnante {

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
	private JTextPane txtpnUsername_5;
	private JTextPane txtpnUsername_6;
	private JTextPane txtpnInserisci;
	private JTextPane txtpnDatiObbligatori;
	private JButton btnNewButton;
	private JButton btnAvanti;
	private JTextPane txtpnPasswordNonValida;
	private JTextField textMateria;
	private JTextPane txtpnCognomeNonValido;
	private JTextPane txtpnNomeNonValido;
	private JTextPane txtpnLePassowordNon;

	public CreaInsegnante(Controller c) {
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
		
		JLabel icon = new JLabel("");
		icon.setToolTipText("Mostra password");
		icon.setIcon(new ImageIcon("C:\\Users\\giorg\\Downloads\\manabi\\src\\Immagini\\occhio.png"));
		icon.setBounds(312, 165, 19, 14);
		frame.getContentPane().add(icon);
		
		txtInserisciUsername = new JTextField();
		txtInserisciUsername.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtInserisciUsername.setBounds(235, 46, 96, 19);
		frame.getContentPane().add(txtInserisciUsername);
		txtInserisciUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 163, 96, 19);
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
		txtpnUsername.setText("USERNAME*");
		txtpnUsername.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(156, 42, 79, 19);
		frame.getContentPane().add(txtpnUsername);
		
		txtpnUsername_1 = new JTextPane();
		txtpnUsername_1.setText("NOME*");
		txtpnUsername_1.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_1.setEditable(false);
		txtpnUsername_1.setBounds(187, 72, 48, 19);
		frame.getContentPane().add(txtpnUsername_1);
		
		txtpnUsername_2 = new JTextPane();
		txtpnUsername_2.setText("COGNOME*");
		txtpnUsername_2.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_2.setEditable(false);
		txtpnUsername_2.setBounds(163, 101, 79, 19);
		frame.getContentPane().add(txtpnUsername_2);
		
		txtpnUsername_3 = new JTextPane();
		txtpnUsername_3.setText("PASSWORD*");
		txtpnUsername_3.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_3.setEditable(false);
		txtpnUsername_3.setBounds(158, 130, 79, 19);
		frame.getContentPane().add(txtpnUsername_3);
		
		txtpnUsername_4 = new JTextPane();
		txtpnUsername_4.setText("CONFERMA PASSWORD*");
		txtpnUsername_4.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_4.setEditable(false);
		txtpnUsername_4.setBounds(87, 158, 171, 19);
		frame.getContentPane().add(txtpnUsername_4);
		
		txtpnUsername_5 = new JTextPane();
		txtpnUsername_5.setText("MATERIA/E");
		txtpnUsername_5.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_5.setEditable(false);
		txtpnUsername_5.setBounds(154, 188, 75, 19);
		frame.getContentPane().add(txtpnUsername_5);
		
		txtpnUsername_6 = new JTextPane();
		txtpnUsername_6.setText("UTENTE INSEGNANTE");
		txtpnUsername_6.setFont(new Font("Dubai", Font.BOLD, 16));
		txtpnUsername_6.setEditable(false);
		txtpnUsername_6.setBounds(42, 10, 165, 29);
		frame.getContentPane().add(txtpnUsername_6);
		
		txtpnInserisci = new JTextPane();
		txtpnInserisci.setText("compila dati");
		txtpnInserisci.setFont(new Font("Dubai", Font.PLAIN, 13));
		txtpnInserisci.setEditable(false);
		txtpnInserisci.setBounds(204, 12, 176, 19);
		frame.getContentPane().add(txtpnInserisci);
		
		txtpnDatiObbligatori = new JTextPane();
		txtpnDatiObbligatori.setText("(*) dati obbligatori");
		txtpnDatiObbligatori.setFont(new Font("Dubai", Font.PLAIN, 13));
		txtpnDatiObbligatori.setEditable(false);
		txtpnDatiObbligatori.setBounds(276, 220, 176, 19);
		frame.getContentPane().add(txtpnDatiObbligatori);
		
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
		
		JTextPane txtpnError1 = new JTextPane();
		txtpnError1.setEditable(false);
		txtpnError1.setForeground(Color.RED);
		txtpnError1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnError1.setToolTipText("L'username deve contenere almeno 8 caratteri e massimo 25.");
		txtpnError1.setText("Username non valido!");
		txtpnError1.setBounds(341, 45, 83, 20);
		frame.getContentPane().add(txtpnError1);
		txtpnError1.setVisible(false);
		
		txtpnPasswordNonValida = new JTextPane();
		txtpnPasswordNonValida.setEditable(false);
		txtpnPasswordNonValida.setToolTipText("La password deve contenere almeno 8 caratteri e non superarne 25.");
		txtpnPasswordNonValida.setForeground(Color.RED);
		txtpnPasswordNonValida.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnPasswordNonValida.setText("Password non valida!");
		txtpnPasswordNonValida.setBounds(341, 132, 75, 20);
		frame.getContentPane().add(txtpnPasswordNonValida);
		txtpnPasswordNonValida.setVisible(false);
		
		textMateria = new JTextField();
		textMateria.setBounds(235, 192, 96, 20);
		frame.getContentPane().add(textMateria);
		textMateria.setColumns(10);
		
		txtpnCognomeNonValido = new JTextPane();
		txtpnCognomeNonValido.setForeground(Color.RED);
		txtpnCognomeNonValido.setEditable(false);
		txtpnCognomeNonValido.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnCognomeNonValido.setToolTipText("Prova a inserire un cognome reale!");
		txtpnCognomeNonValido.setText("Cognome non valido!");
		txtpnCognomeNonValido.setBounds(341, 103, 75, 20);
		frame.getContentPane().add(txtpnCognomeNonValido);
		txtpnCognomeNonValido.setVisible(false);
		
		txtpnNomeNonValido = new JTextPane();
		txtpnNomeNonValido.setForeground(Color.RED);
		txtpnNomeNonValido.setToolTipText("Prova a inserire un nome reale!");
		txtpnNomeNonValido.setText("Nome non valido!");
		txtpnNomeNonValido.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnNomeNonValido.setEditable(false);
		txtpnNomeNonValido.setBounds(341, 74, 75, 20);
		frame.getContentPane().add(txtpnNomeNonValido);
		txtpnNomeNonValido.setVisible(false);
		
		txtpnLePassowordNon = new JTextPane();
		txtpnLePassowordNon.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnLePassowordNon.setEditable(false);
		txtpnLePassowordNon.setForeground(Color.RED);
		txtpnLePassowordNon.setText("Le passoword non corrispondono");
		txtpnLePassowordNon.setBounds(341, 162, 75, 20);
		frame.getContentPane().add(txtpnLePassowordNon);
		txtpnLePassowordNon.setVisible(false);
		
		btnAvanti = new JButton("AVANTI");
		btnAvanti.addMouseListener(new MouseAdapter() {
			//verifica credenziali
			public void mouseClicked(MouseEvent e) {
				
				boolean a, b, c, d, f; //per fare un controllo alla fine (va avanti nella prossima schermata
				String s;
				controller.assignUsername(txtInserisciUsername.getText());
				if(controller.u.username.length() < 8 || controller.u.username.length() > 25) { txtpnError1.setVisible(true); a = false; }
				else {txtpnError1.setVisible(false); a = true;}

				controller.assignPassword(passwordField_1.getText());
				if(controller.u.password.length() < 8 || controller.u.password.length() > 25) {txtpnPasswordNonValida.setVisible(true); b = false;}
				else {txtpnPasswordNonValida.setVisible(false); b = true;}


				controller.assignName(textField_1.getText());
				if(controller.u.nome.length() < 2) {txtpnNomeNonValido.setVisible(true); c = false;}
				else {txtpnNomeNonValido.setVisible(false); c = true;}
				
				controller.assignSurname(textField.getText());
				if(controller.u.cognome.length() < 2) {	txtpnCognomeNonValido.setVisible(true); d = false;}
				else {txtpnCognomeNonValido.setVisible(false); d = true;}
				
				s = passwordField.getText();

				if(!controller.u.password.equals(s)) {txtpnLePassowordNon.setVisible(true); f = false;}
				else {txtpnLePassowordNon.setVisible(false); f = true;}
				
				controller.assignMat(textMateria.getText());
				
				if(a && b && c && d && f)
				{
					Menu next = new Menu(controller);
					frame.setVisible(false);
					next.setVisible(true);
				}
			}
		});
		btnAvanti.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAvanti.setBounds(157, 220, 85, 21);
		frame.getContentPane().add(btnAvanti);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
