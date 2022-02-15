package GUI;
import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TipoAccount {

	private JFrame frame;
	Controller c;
	private JTextPane txtpnCheTipoDi;

	public TipoAccount(Controller controller) {
		c = controller;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TipoAccount.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
		
		JButton btnNewButton = new JButton("CONFERMA");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("INSEGNANTE");
		btnNewButton.addActionListener(new ActionListener() { //deseleziona studente
			public void actionPerformed(ActionEvent e) {
			}
		});
		JRadioButton rdbtnStudente = new JRadioButton("STUDENTE");
		rdbtnStudente.addMouseListener(new MouseAdapter() { //deseleziona insegnante
			@Override
			public void mouseClicked(MouseEvent e) {
		
				rdbtnNewRadioButton.setEnabled(false);
				btnNewButton.setEnabled(true);
			}
		});
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtpnCheTipoDi = new JTextPane();
		txtpnCheTipoDi.setText("CHE TIPO DI ACCOUNT");
		txtpnCheTipoDi.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnCheTipoDi.setEditable(false);
		txtpnCheTipoDi.setBounds(135, 64, 196, 21);
		frame.getContentPane().add(txtpnCheTipoDi);
		
		JTextPane txtpnVuoiCreare = new JTextPane();
		txtpnVuoiCreare.setText("VUOI CREARE?");
		txtpnVuoiCreare.setFont(new Font("Dubai", Font.BOLD, 13));
		txtpnVuoiCreare.setEditable(false);
		txtpnVuoiCreare.setBounds(169, 81, 139, 21);
		frame.getContentPane().add(txtpnVuoiCreare);
		
		
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnStudente.setEnabled(false);
				btnNewButton.setEnabled(true);
			}
		});
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(170, 108, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
			
		btnNewButton.setEnabled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					CreaInsegnante i = new CreaInsegnante(c);
					frame.setVisible(false);
					frame.dispose();
				}
				else {
					CreaStudente s = new CreaStudente(c);
					frame.setVisible(false);
					frame.dispose();
				}					
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(170, 158, 91, 15);
		rdbtnStudente.setBackground(Color.WHITE);
		rdbtnStudente.setBounds(169, 131, 103, 21);
		frame.getContentPane().add(rdbtnStudente);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
	}

}
