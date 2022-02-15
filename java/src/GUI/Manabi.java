package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controller.Controller;


public class Manabi {

	private JFrame frame;
	/*E' la prima classe a esser chiamata. Si occupa della creazione del controller e del passaggio alla prima schermata (quella di accesso)*/
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					Controller c = new Controller(); //Viene inizializzato il controller. Il costruttore e il metood initialize saranno inutili: il controllo verrà passato alla prossima schermata.
					Accesso window = new Accesso(c);  //si passa alla schermata di accesso
					
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
