package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompilaTest {

	 JFrame frame;
	Controller controller;
	int index;
	private JTextField textRispostaAperta;
	
	public CompilaTest(Controller c) {
		controller = c;
		index = controller.setIndexTest(controller.t.id);
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setTitle("Manabi");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CompilaTest.class.getResource("/Immagini/icona manabi.png")));
		frame.setBounds(100, 100, 840, 641);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(337, 577, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JButton btnNewButton = new JButton("Avanti");
		
		btnNewButton.setBounds(725, 568, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane titoloTest = new JTextPane();
		titoloTest.setText(controller.t.nomeTest);
		titoloTest.setEditable(false);
		titoloTest.setBounds(10, 11, 192, 20);
		frame.getContentPane().add(titoloTest);
		
		JTextPane textDomanda = new JTextPane();
		textDomanda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textDomanda.setBounds(20, 42, 769, 209);
		frame.getContentPane().add(textDomanda);
		
		JRadioButton A = new JRadioButton("New radio button");
		A.setBackground(Color.WHITE);
		A.setBounds(271, 270, 261, 23);
		frame.getContentPane().add(A);
		
		JRadioButton B = new JRadioButton("New radio button");
		B.setBackground(Color.WHITE);
		B.setBounds(271, 310, 261, 23);
		frame.getContentPane().add(B);
		
		JRadioButton C = new JRadioButton("New radio button");
		C.setBackground(Color.WHITE);
		C.setBounds(271, 352, 261, 23);
		frame.getContentPane().add(C);
		
		JRadioButton D = new JRadioButton("New radio button");
		D.setBackground(Color.WHITE);
		D.setBounds(271, 391, 261, 23);
		frame.getContentPane().add(D);
		
		JRadioButton E = new JRadioButton("New radio button");
		E.setBackground(Color.WHITE);
		E.setBounds(271, 430, 261, 23);
		frame.getContentPane().add(E);
		
		textRispostaAperta = new JTextField();
		textRispostaAperta.setBounds(20, 284, 769, 262);
		frame.getContentPane().add(textRispostaAperta);
		textRispostaAperta.setColumns(10);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		for(int i = 0; i < index; i++) {
			
			
			
		}
	}
}
