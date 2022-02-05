package GUI;

import java.awt.EventQueue;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import controller.Controller;


public class Manabi {

	private JFrame frame;
	
	/**
	 * Avvio prima GUI
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c = new Controller();
					Accesso window = new Accesso(c); 
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Manabi(Controller c) {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
