package GUI;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class CreaInsegnante {

	JFrame frame;
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
	private JTextPane txtpnDatiObbligatori;
	private JButton btnNewButton;
	private JButton btnAvanti;
	private JTextPane txtpnPasswordNonValida;
	private JTextField textMateria;
	private JTextPane txtpnCognomeNonValido;
	private JTextPane txtpnNomeNonValido;
	private JTextPane txtpnLePassowordNon;
	private JTextPane txtpnUsernameNonDisponibile;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	public CreaInsegnante(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CreaInsegnante.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 648, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CreaInsegnante.class.getResource("/Immagini/manabi classic blu.png")));
		lblNewLabel_1.setBounds(10, 10, 214, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtInserisciUsername = new JTextField();
		txtInserisciUsername.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtInserisciUsername.setBounds(241, 92, 171, 19);
		frame.getContentPane().add(txtInserisciUsername);
		txtInserisciUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 209, 171, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(241, 179, 171, 19);
		frame.getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textField.setColumns(10);
		textField.setBounds(241, 150, 171, 19);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textField_1.setColumns(10);
		textField_1.setBounds(241, 121, 171, 19);
		frame.getContentPane().add(textField_1);
		
		txtpnUsername = new JTextPane();
		txtpnUsername.setText("*USERNAME");
		txtpnUsername.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBounds(111, 93, 79, 19);
		frame.getContentPane().add(txtpnUsername);
		
		txtpnUsername_1 = new JTextPane();
		txtpnUsername_1.setText("*NOME");
		txtpnUsername_1.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_1.setEditable(false);
		txtpnUsername_1.setBounds(142, 123, 48, 19);
		frame.getContentPane().add(txtpnUsername_1);
		
		txtpnUsername_2 = new JTextPane();
		txtpnUsername_2.setText("*COGNOME");
		txtpnUsername_2.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_2.setEditable(false);
		txtpnUsername_2.setBounds(118, 152, 79, 19);
		frame.getContentPane().add(txtpnUsername_2);
		
		txtpnUsername_3 = new JTextPane();
		txtpnUsername_3.setText("*PASSWORD");
		txtpnUsername_3.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_3.setEditable(false);
		txtpnUsername_3.setBounds(113, 181, 79, 19);
		frame.getContentPane().add(txtpnUsername_3);
		
		txtpnUsername_4 = new JTextPane();
		txtpnUsername_4.setText("*CONFERMA PASSWORD");
		txtpnUsername_4.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_4.setEditable(false);
		txtpnUsername_4.setBounds(42, 209, 171, 19);
		frame.getContentPane().add(txtpnUsername_4);
		
		txtpnUsername_5 = new JTextPane();
		txtpnUsername_5.setText("MATERIA/E");
		txtpnUsername_5.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername_5.setEditable(false);
		txtpnUsername_5.setBounds(113, 239, 75, 19);
		frame.getContentPane().add(txtpnUsername_5);
		
		txtpnUsername_6 = new JTextPane();
		txtpnUsername_6.setText("UTENTE INSEGNANTE");
		txtpnUsername_6.setFont(new Font("Dubai", Font.BOLD, 16));
		txtpnUsername_6.setEditable(false);
		txtpnUsername_6.setBounds(10, 54, 165, 29);
		frame.getContentPane().add(txtpnUsername_6);
		
		txtpnDatiObbligatori = new JTextPane();
		txtpnDatiObbligatori.setForeground(SystemColor.textHighlight);
		txtpnDatiObbligatori.setText("(*) campi obbligatori");
		txtpnDatiObbligatori.setFont(new Font("Dubai", Font.PLAIN, 13));
		txtpnDatiObbligatori.setEditable(false);
		txtpnDatiObbligatori.setBounds(10, 503, 176, 19);
		frame.getContentPane().add(txtpnDatiObbligatori);
		
		btnNewButton = new JButton("INDIETRO");
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoAccount tipoAccount = new TipoAccount(controller);
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 532, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnError1 = new JTextPane();
		txtpnError1.setEditable(false);
		txtpnError1.setForeground(SystemColor.textHighlight);
		txtpnError1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnError1.setToolTipText("L'username deve contenere almeno 8 caratteri e massimo 25.");
		txtpnError1.setText("Username non valido!");
		txtpnError1.setBounds(445, 92, 83, 20);
		frame.getContentPane().add(txtpnError1);
		txtpnError1.setVisible(false);
		
		txtpnPasswordNonValida = new JTextPane();
		txtpnPasswordNonValida.setEditable(false);
		txtpnPasswordNonValida.setToolTipText("La password deve contenere almeno 8 caratteri e non superarne 25.");
		txtpnPasswordNonValida.setForeground(SystemColor.textHighlight);
		txtpnPasswordNonValida.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnPasswordNonValida.setText("Password non valida!");
		txtpnPasswordNonValida.setBounds(445, 179, 75, 20);
		frame.getContentPane().add(txtpnPasswordNonValida);
		txtpnPasswordNonValida.setVisible(false);
		
		textMateria = new JTextField();
		textMateria.setBounds(241, 238, 171, 20);
		frame.getContentPane().add(textMateria);
		textMateria.setColumns(10);
		
		txtpnCognomeNonValido = new JTextPane();
		txtpnCognomeNonValido.setForeground(SystemColor.textHighlight);
		txtpnCognomeNonValido.setEditable(false);
		txtpnCognomeNonValido.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnCognomeNonValido.setToolTipText("Prova a inserire un cognome reale!");
		txtpnCognomeNonValido.setText("Cognome non valido!");
		txtpnCognomeNonValido.setBounds(445, 150, 75, 20);
		frame.getContentPane().add(txtpnCognomeNonValido);
		txtpnCognomeNonValido.setVisible(false);
		
		txtpnNomeNonValido = new JTextPane();
		txtpnNomeNonValido.setForeground(SystemColor.textHighlight);
		txtpnNomeNonValido.setToolTipText("Prova a inserire un nome reale!");
		txtpnNomeNonValido.setText("Nome non valido!");
		txtpnNomeNonValido.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnNomeNonValido.setEditable(false);
		txtpnNomeNonValido.setBounds(445, 121, 75, 20);
		frame.getContentPane().add(txtpnNomeNonValido);
		txtpnNomeNonValido.setVisible(false);
		
		txtpnUsernameNonDisponibile = new JTextPane();
		txtpnUsernameNonDisponibile.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnUsernameNonDisponibile.setForeground(SystemColor.textHighlight);
		txtpnUsernameNonDisponibile.setBackground(Color.WHITE);
		txtpnUsernameNonDisponibile.setEditable(false);
		txtpnUsernameNonDisponibile.setToolTipText("Prova a utilizzare un username diverso.");
		txtpnUsernameNonDisponibile.setText("Username non disponibile.");
		txtpnUsernameNonDisponibile.setBounds(445, 92, 75, 20);
		frame.getContentPane().add(txtpnUsernameNonDisponibile);
		txtpnUsernameNonDisponibile.setVisible(false);
		
		
		txtpnLePassowordNon = new JTextPane();
		txtpnLePassowordNon.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnLePassowordNon.setEditable(false);
		txtpnLePassowordNon.setForeground(SystemColor.textHighlight);
		txtpnLePassowordNon.setText("Le passoword non corrispondono");
		txtpnLePassowordNon.setBounds(445, 209, 75, 20);
		frame.getContentPane().add(txtpnLePassowordNon);
		txtpnLePassowordNon.setVisible(false);
		
		btnAvanti = new JButton("AVANTI");
		btnAvanti.setOpaque(false);
		btnAvanti.setForeground(SystemColor.textHighlight);
		btnAvanti.addMouseListener(new MouseAdapter() {
			//verifica credenziali
			public void mouseClicked(MouseEvent e) {
				
				boolean a, b, c, d, f, h; 
				String s;
				controller.assignUsername(txtInserisciUsername.getText());
				
				if(controller.checkUsername()) { txtpnUsernameNonDisponibile.setVisible(true); h = false; } else {txtpnUsernameNonDisponibile.setVisible(false); h = true;}
				if(controller.u.username.length() < 8 || controller.u.username.length() > 25) {txtpnError1.setVisible(true); a = false;}
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
				
				if(a && b && c && d && f && h)
				{
					controller.inizializzaInsegnante();
					MenuInsegnante next = new MenuInsegnante(controller);
					frame.setVisible(false);
					
				}
			}
		});
		btnAvanti.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAvanti.setBounds(539, 532, 85, 21);
		frame.getContentPane().add(btnAvanti);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreaInsegnante.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel.setBounds(39, 0, 634, 563);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}