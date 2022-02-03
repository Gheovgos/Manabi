package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.*;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class CreaStudente {

	private JFrame frame;
	Controller controller;
	private JTextField txtSonoCreaStudente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaStudente window = new CreaStudente();
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
	public CreaStudente(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtSonoCreaStudente = new JTextField();
		txtSonoCreaStudente.setText("SONO CREA STUDENTE");
		frame.getContentPane().add(txtSonoCreaStudente, BorderLayout.CENTER);
		txtSonoCreaStudente.setColumns(10);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
