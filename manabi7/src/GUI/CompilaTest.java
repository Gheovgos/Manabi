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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class CompilaTest {

	 JFrame frame;
	Controller controller;
	private JTextPane textRispostaAperta;
	int progresso = 0;
	private JTextField warnNoRisp;
	String[] rs;
	private JTextField Ttempo;
	
	public CompilaTest(Controller c) {
		controller = c;
		controller.caricaQuesitiTest(controller.t.id);
		initialize();
		frame.setVisible(true);
		
	}

	private void initialize() {
		frame = new JFrame();
		
		int lunghezzaTest = controller.t.quesiti.length;
		rs = controller.t.quesiti[progresso].risposte;
		
		rs = shuffle(rs);
		
		//vedi timer
		
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setTitle("Manabi");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CompilaTest.class.getResource("/Immagini/icona manabi.png")));
		frame.setBounds(100, 100, 648, 602);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(lunghezzaTest);
		progressBar.setBounds(218, 541, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JButton Avanti = new JButton("AVANTI");
		Avanti.setForeground(SystemColor.textHighlight);
		
		Avanti.setBounds(521, 534, 89, 23);
		frame.getContentPane().add(Avanti);
		
		
		
		JTextPane titoloTest = new JTextPane();
		titoloTest.setFont(new Font("Tahoma", Font.BOLD, 13));
		titoloTest.setText(controller.t.nomeTest);
		titoloTest.setEditable(false);
		titoloTest.setBounds(22, 11, 192, 20);
		frame.getContentPane().add(titoloTest);
		
		JTextPane textDomanda = new JTextPane();
		textDomanda.setFont(new Font("Tahoma", Font.BOLD, 10));
		textDomanda.setText(controller.t.quesiti[progresso].domanda);
		
		textDomanda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textDomanda.setBounds(20, 42, 590, 145);
		frame.getContentPane().add(textDomanda);
		
		warnNoRisp = new JTextField();
		warnNoRisp.setOpaque(false);
		warnNoRisp.setBorder(null);
		warnNoRisp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		warnNoRisp.setText("Devi dare una risposta!");
		warnNoRisp.setForeground(SystemColor.textHighlight);
		warnNoRisp.setBackground(Color.WHITE);
		warnNoRisp.setEditable(false);
		warnNoRisp.setBounds(20, 522, 272, 43);
		frame.getContentPane().add(warnNoRisp);
		warnNoRisp.setColumns(10);
		warnNoRisp.setVisible(false);
		
		JRadioButton A = new JRadioButton("a");
		A.setOpaque(false);
		A.setVerticalAlignment(SwingConstants.TOP);
		A.setFont(new Font("Tahoma", Font.PLAIN, 8));
		A.setBackground(Color.WHITE);
		A.setBounds(30, 195, 308, 65);
		frame.getContentPane().add(A);
		
		JRadioButton B = new JRadioButton("b");
		B.setOpaque(false);
		B.setVerticalAlignment(SwingConstants.TOP);
		B.setFont(new Font("Tahoma", Font.PLAIN, 8));
		B.setBackground(Color.WHITE);
		B.setBounds(30, 263, 308, 65);
		frame.getContentPane().add(B);
		
		JRadioButton C = new JRadioButton("c");
		C.setOpaque(false);
		C.setVerticalAlignment(SwingConstants.TOP);
		C.setFont(new Font("Tahoma", Font.PLAIN, 8));
		C.setBackground(Color.WHITE);
		C.setBounds(30, 331, 308, 71);
		frame.getContentPane().add(C);
		
		JRadioButton D = new JRadioButton("d");
		D.setOpaque(false);
		D.setVerticalAlignment(SwingConstants.TOP);
		D.setFont(new Font("Tahoma", Font.PLAIN, 8));
		D.setBackground(Color.WHITE);
		D.setBounds(30, 405, 308, 69);
		frame.getContentPane().add(D);
		
		JRadioButton E = new JRadioButton("e");
		E.setOpaque(false);
		E.setVerticalAlignment(SwingConstants.TOP);
		E.setFont(new Font("Tahoma", Font.PLAIN, 8));
		E.setBackground(Color.WHITE);
		E.setBounds(30, 477, 308, 65);
		frame.getContentPane().add(E);
		
		textRispostaAperta = new JTextPane();
		textRispostaAperta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textRispostaAperta.setBounds(20, 232, 590, 280);
		frame.getContentPane().add(textRispostaAperta);
		
		Ttempo = new JTextField();
		Ttempo.setFont(new Font("Tahoma", Font.BOLD, 10));
		Ttempo.setText("TEMPO RIMASTO: 0");
		Ttempo.setEditable(false);
		Ttempo.setBounds(424, 11, 186, 20);
		frame.getContentPane().add(Ttempo);
		Ttempo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CompilaTest.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel.setBounds(174, -14, 460, 579);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		if(controller.t.quesiti[0].isOpen) {
			A.setVisible(false); B.setVisible(false); C.setVisible(false); D.setVisible(false); E.setVisible(false);
			textRispostaAperta.setVisible(true);
			
		}
		else {
			if(rs[0].equals("")) {A.setVisible(false);} else {A.setVisible(true); A.setText(rs[0]);}
			if(rs[1].equals("")) {B.setVisible(false);} else {B.setVisible(true); B.setText(rs[1]);}
			if(rs[2].equals("")) {C.setVisible(false);} else {B.setVisible(true); B.setText(rs[2]);}
			if(rs[3].equals("")) {D.setVisible(false);} else {B.setVisible(true); B.setText(rs[3]);}
			if(rs[4].equals("")) {E.setVisible(false);} else {B.setVisible(true); B.setText(rs[4]);}
			
			
			if(A.isVisible())
			
			textRispostaAperta.setVisible(false);			
		}
		
	
		Avanti.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(controller.t.quesiti[progresso].isOpen) {
					
					
						controller.insertRisposta(controller.t.quesiti[progresso].idQuesito, textRispostaAperta.getText(), controller.t.quesiti[progresso].isOpen);
						progresso++;
											
						progressBar.setValue(progresso);
						if(checkProgress(progresso, lunghezzaTest)) {
							progresso--;
							frame.setVisible(false);
							TestCompletato next = new TestCompletato(controller);	
						}
						
						textDomanda.setText(controller.t.quesiti[progresso].domanda);
						if(controller.t.quesiti[progresso].isOpen) {
							A.setVisible(false); B.setVisible(false); C.setVisible(false); D.setVisible(false); E.setVisible(false);
							textRispostaAperta.setVisible(true);}
						
						else {
							rs = controller.t.quesiti[progresso].risposte;
							rs = shuffle(rs);
							if(rs[0].equals("")) { A.setVisible(false); A.setText(rs[0]);}
							else {A.setVisible(true); A.setText(rs[0]);}
							if(rs[1].equals("")) {B.setVisible(false); B.setText(rs[1]);}
							else {B.setVisible(true); B.setText(rs[1]);}
							if(rs[2].equals("")) {C.setVisible(false); C.setText(rs[2]);}
							else {C.setVisible(true); C.setText(rs[2]);}
							if(rs[3].equals("")) {D.setVisible(false); D.setText(rs[3]);}
							else {D.setVisible(true); D.setText(rs[3]);}
							if(rs[4].equals("")) {E.setVisible(false); E.setText(rs[4]);}
							else {E.setVisible(true); E.setText(rs[4]);}
							textRispostaAperta.setVisible(false); 						
						}
					}
				
				else {
					boolean a;
					if(!(B.isSelected() || C.isSelected() || D.isSelected() || E.isSelected() || A.isSelected())) {
						a = false; warnNoRisp.setVisible(true);
					}
					else {
						a = true; warnNoRisp.setVisible(false); 
					}
					
					if(a) {
							String risposta = "";
							
							if(A.isSelected()) { risposta = A.getText();} 
						
							else if(B.isSelected()) {risposta = B.getText();} 
					
							else if(C.isSelected()) {risposta = C.getText();} 
				
							else if(D.isSelected()) {risposta = D.getText();} 
			
							else if(E.isSelected()) {risposta = E.getText();} 
						
						controller.insertRisposta(controller.t.quesiti[progresso].idQuesito, risposta, controller.t.quesiti[progresso].isOpen);
						progresso++;
						progressBar.setValue(progresso);
						if(checkProgress(progresso, lunghezzaTest)) {
							progresso--;
							frame.setVisible(false);
							TestCompletato next = new TestCompletato(controller);	
						}
						textDomanda.setText(controller.t.quesiti[progresso].domanda);
						
						
						if(controller.t.quesiti[progresso].isOpen) {
							A.setVisible(false); B.setVisible(false); C.setVisible(false); D.setVisible(false); E.setVisible(false);
							textRispostaAperta.setVisible(true);}
						else {
							A.setSelected(false); B.setSelected(false); C.setSelected(false); D.setSelected(false); E.setSelected(false);
							rs = controller.t.quesiti[progresso].risposte;
							rs = shuffle(rs);
							if(rs[0].equals("")) { A.setVisible(false); A.setText(rs[0]);}
							else {A.setVisible(true); A.setText(rs[0]);}
							if(rs[1].equals("")) {B.setVisible(false); B.setText(rs[1]);}
							else {B.setVisible(true); B.setText(rs[1]);}
							if(rs[2].equals("")) {C.setVisible(false); C.setText(rs[2]);}
							else {C.setVisible(true); C.setText(rs[2]);}
							if(rs[3].equals("")) {D.setVisible(false); D.setText(rs[3]);}
							else {D.setVisible(true); D.setText(rs[3]);}
							if(rs[4].equals("")) {E.setVisible(false); E.setText(rs[4]);}
							else {E.setVisible(true); E.setText(rs[4]);}
							textRispostaAperta.setVisible(false); 
						}
						
					}
					
				}
				
				
			}
		});
		
		A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				B.setSelected(false);
				C.setSelected(false);
				D.setSelected(false);
				E.setSelected(false);
			}
		});
		
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				A.setSelected(false);
				C.setSelected(false);
				D.setSelected(false);
				E.setSelected(false);
			}
		});
		
		C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				B.setSelected(false);
				A.setSelected(false);
				D.setSelected(false);
				E.setSelected(false);
			}
		});
		
		D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				B.setSelected(false);
				C.setSelected(false);
				A.setSelected(false);
				E.setSelected(false);
			}
		});
		
		E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				B.setSelected(false);
				C.setSelected(false);
				D.setSelected(false);
				A.setSelected(false);
			}
		});
		
		frame.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				
			}
		});
		
	}
	
	
	
	public boolean checkProgress(int progresso, int max) {
		if(progresso == max) return true;
		else return false;
	}
	
	public String[] shuffle(String [] rs) {
	
		List<String> shuffle = Arrays.asList(rs);

		Collections.shuffle(shuffle);

		shuffle.toArray(rs);
		
		for(int i = 0; i < rs.length; i++) {
			if(rs[i] == null) rs[i] = "";
		}
		
		return rs;
		
	}
}
