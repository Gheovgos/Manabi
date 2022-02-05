package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;

public class MenuStudente {

	private JFrame frame;
	Controller controller;
	private JTextField txtMen;
	private JTextField txtPunti;
	private JTextField txtTotali;
	private JTextField txtUltimoTestSvolto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public MenuStudente(Controller c) {
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
		frame.setBounds(100, 100, 728, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(477, 265, 215, 20);
		frame.getContentPane().add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(477, 238, 215, 20);
		frame.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(477, 211, 215, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtTotali = new JTextField();
		txtTotali.setText("TOTALI");
		txtTotali.setFont(new Font("Corbel", Font.BOLD, 18));
		txtTotali.setColumns(10);
		txtTotali.setBorder(null);
		txtTotali.setBackground(Color.WHITE);
		txtTotali.setBounds(612, 498, 63, 23);
		frame.getContentPane().add(txtTotali);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/polipetto.png")));
		lblNewLabel.setBounds(20, -59, 253, 206);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("elenco test svolti");
		btnNewButton.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton.setBounds(20, 112, 149, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnElencoCorsiSeguiti = new JButton("elenco corsi seguiti");
		btnElencoCorsiSeguiti.setFont(new Font("Candara", Font.PLAIN, 13));
		btnElencoCorsiSeguiti.setBounds(20, 147, 149, 23);
		frame.getContentPane().add(btnElencoCorsiSeguiti);
		
		JButton btnNewButton_2 = new JButton("cerca corso");
		btnNewButton_2.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_2.setBounds(20, 185, 149, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("profilo utente");
		btnNewButton_3.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_3.setBounds(20, 224, 149, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.setFont(new Font("Candara", Font.BOLD, 15));
		btnNewButton_4.setBounds(20, 519, 107, 20);
		frame.getContentPane().add(btnNewButton_4);
		
		txtMen = new JTextField();
		txtMen.setBackground(Color.WHITE);
		txtMen.setBorder(null);
		txtMen.setEditable(false);
		txtMen.setFont(new Font("Candara", Font.BOLD, 29));
		txtMen.setText("M E N \u00D9");
		txtMen.setBounds(22, 66, 107, 63);
		frame.getContentPane().add(txtMen);
		txtMen.setColumns(10);
		
		txtPunti = new JTextField();
		txtPunti.setBorder(null);
		txtPunti.setBackground(Color.WHITE);
		txtPunti.setFont(new Font("Corbel", Font.BOLD, 18));
		txtPunti.setText("PUNTI");
		txtPunti.setBounds(592, 484, 63, 23);
		frame.getContentPane().add(txtPunti);
		txtPunti.setColumns(10);
		
		txtUltimoTestSvolto = new JTextField();
		txtUltimoTestSvolto.setBackground(new Color(255, 99, 71));
		txtUltimoTestSvolto.setText("ULTIMO TEST SVOLTO");
		txtUltimoTestSvolto.setFont(new Font("Candara", Font.BOLD, 25));
		txtUltimoTestSvolto.setEditable(false);
		txtUltimoTestSvolto.setColumns(10);
		txtUltimoTestSvolto.setBorder(null);
		txtUltimoTestSvolto.setBounds(465, 164, 242, 63);
		frame.getContentPane().add(txtUltimoTestSvolto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(439, 412, 263, -246);
		frame.getContentPane().add(separator);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(255, 99, 71));
		editorPane.setBounds(449, 164, 263, 290);
		frame.getContentPane().add(editorPane);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 99, 71));
		textField_3.setBounds(2, 0, 710, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
