package GUI;

import javax.swing.JFrame;
import controller.Controller;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Accesso {

	JFrame frame;
	private Controller controller;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextPane txtpnPassword;

	public Accesso(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100,650 ,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(259, 290, 222, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(259, 319, 222, 19);
		frame.getContentPane().add(passwordField);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnUsername.setEditable(false);
		txtpnUsername.setText("USERNAME");
		txtpnUsername.setBounds(168, 286, 95, 29);
		frame.getContentPane().add(txtpnUsername);
		
		txtpnPassword = new JTextPane();
		txtpnPassword.setText("PASSWORD");
		txtpnPassword.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBounds(168, 315, 95, 29);
		frame.getContentPane().add(txtpnPassword);
		
		JButton btnNewButton = new JButton("ACCEDI");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				controller.login(textField.getText(), passwordField.getText()); 
				
				if(controller.i != null) {
					MenuInsegnante next = new MenuInsegnante(controller);
					frame.setVisible(false);
					next.frame.setVisible(true); }
				if(controller.s != null) {
					MenuStudente next = new MenuStudente(controller);
					frame.setVisible(false);
					next.frame.setVisible(true);
				}
				else {
					
					JTextPane textError = new JTextPane();
					textError.setVisible(true);
					textError.setFont(new Font("Tahoma", Font.PLAIN, 11));
					textError.setForeground(Color.RED);
					textError.setBackground(Color.WHITE);
					textError.setText("Username o password errati.");
					textError.setEditable(false);
					textError.setBounds(491, 286, 133, 52);
					frame.getContentPane().add(textError);
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Dubai", Font.PLAIN, 12));
		btnNewButton.setBounds(259, 376, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnIscriviti = new JButton("ISCRIVITI");
		btnIscriviti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoAccount tipoAccount = new TipoAccount(controller);
				frame.setVisible(false);
				tipoAccount.setVisible(true);
			}
		});
		btnIscriviti.setFont(new Font("Dubai", Font.PLAIN, 12));
		btnIscriviti.setBounds(396, 376, 85, 21);
		frame.getContentPane().add(btnIscriviti);
		
		JLabel Settings = new JLabel("");
		Settings.setToolTipText("Apri impostazioni DB");
		Settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DBSettings next = new DBSettings(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
				
			}
		});
		Settings.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/settings.png")));
		Settings.setBounds(578, 11, 46, 36);
		frame.getContentPane().add(Settings);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/manabi.png")));
		lblNewLabel.setBounds(10, 11, 228, 138);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
