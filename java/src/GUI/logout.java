package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class logout {

	private JFrame frame;
	private JTextField txtSeiSicuroDi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logout window = new logout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("YUP");
		btnNewButton_3_1.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_3_1.setBounds(242, 95, 69, 23);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("NAH");
		btnNewButton_3.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_3.setBounds(126, 95, 69, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		txtSeiSicuroDi = new JTextField();
		txtSeiSicuroDi.setEditable(false);
		txtSeiSicuroDi.setText("sei sicuro di voler uscire?");
		txtSeiSicuroDi.setFont(new Font("Corbel", Font.PLAIN, 13));
		txtSeiSicuroDi.setColumns(10);
		txtSeiSicuroDi.setBorder(null);
		txtSeiSicuroDi.setBackground(Color.WHITE);
		txtSeiSicuroDi.setBounds(154, 74, 140, 23);
		frame.getContentPane().add(txtSeiSicuroDi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(logout.class.getResource("/Immagini/polipetto.png")));
		lblNewLabel.setBounds(192, 147, 69, 59);
		frame.getContentPane().add(lblNewLabel);
	}

}
