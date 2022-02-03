package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controller.Controller;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accesso {

	JFrame frame;
	private Controller controller;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextPane txtpnPassword;
	/**
	 * Create the application.
	 */
	public Accesso(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
	}
}
