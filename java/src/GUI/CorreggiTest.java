package GUI;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CorreggiTest {

	JFrame frame;
	Controller controller;
	private JTextField txtNomeTest;
	private JTextField textNomeStudente;
	private JTextPane textDomanda;
	private JTextPane textRisposta;
	private JTextField textPnt;
	int lunghezza = 0;
	int progresso = 0;
	
	public CorreggiTest(Controller c) {
		controller = c;
		controller.caricaQuesitiTest(controller.getT().getId());
		initialize();
		frame.setVisible(true);
	}

	@SuppressWarnings("removal")
	private void initialize() {
		
		for(int i = 0; i < controller.getT().getQuesiti().length; i++) {
			if(controller.getT().getQuesiti()[i].isOpen())
				lunghezza++;
		}
		while(!controller.getT().getQuesiti()[progresso].isOpen() && progresso < lunghezza) {
			progresso++;
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1011, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNomeTest = new JTextField();
		txtNomeTest.setBackground(Color.WHITE);
		txtNomeTest.setEditable(false);
		txtNomeTest.setText("TEST: "+controller.getT().getNomeTest());
		txtNomeTest.setBounds(10, 11, 364, 20);
		frame.getContentPane().add(txtNomeTest);
		txtNomeTest.setColumns(10);
		
		textNomeStudente = new JTextField();
		textNomeStudente.setBackground(Color.WHITE);
		textNomeStudente.setEditable(false);
		textNomeStudente.setText("Studente: "+controller.getS().cognome+" "+controller.getS().nome);
		textNomeStudente.setBounds(10, 42, 364, 20);
		frame.getContentPane().add(textNomeStudente);
		textNomeStudente.setColumns(10);
		
		textDomanda = new JTextPane();
		textDomanda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textDomanda.setText(controller.getT().getQuesiti()[progresso].getDomanda());
		textDomanda.setEditable(false);
		textDomanda.setBounds(10, 73, 655, 214);
		frame.getContentPane().add(textDomanda);
		
		textRisposta = new JTextPane();
		textRisposta.setText(controller.caricaRisopsta(controller.getT().getQuesiti()[progresso].getIdQuesito(), controller.getS().username));
		textRisposta.setEditable(false);
		textRisposta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textRisposta.setBounds(10, 298, 655, 214);
		frame.getContentPane().add(textRisposta);
		
		JButton btnNewButton_1 = new JButton("Avanti");
		
		btnNewButton_1.setBounds(878, 546, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(controller.getT().getQuesiti()[progresso].getPunteggioMin()), new Float(controller.getT().getQuesiti()[progresso].getPunteggioMax()), new Float(1)));
		spinner.setBounds(833, 298, 89, 20);
		frame.getContentPane().add(spinner);
		
		textPnt = new JTextField();
		textPnt.setBorder(null);
		textPnt.setBackground(Color.WHITE);
		textPnt.setText("Imposta punteggio");
		textPnt.setEditable(false);
		textPnt.setBounds(705, 298, 116, 20);
		frame.getContentPane().add(textPnt);
		textPnt.setColumns(10);
		
		JTextPane textCommento = new JTextPane();
		textCommento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textCommento.setBounds(678, 332, 288, 178);
		frame.getContentPane().add(textCommento);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override //AVANTI
			public void mouseClicked(MouseEvent e) {
				boolean avanti = true;
				controller.updateRisposta(controller.getT().getQuesiti()[progresso].getIdQuesito(), controller.getS().username, (Float) spinner.getValue(), textCommento.getText());
				progresso++;
				while(!controller.getT().getQuesiti()[progresso].isOpen() && progresso < lunghezza) {
					progresso++;
				}
				
				if(progresso >= lunghezza) {
					controller.aggiornaCorrezione(controller.getT().getId(), controller.getS().username);
					VisualizzaTestDaCorreggere back = new VisualizzaTestDaCorreggere(controller);
					frame.setVisible(false);
					frame.dispose();
					avanti = false;
					
				}
				
				if(avanti) {
					textRisposta.setText(controller.caricaRisopsta(controller.getT().getQuesiti()[progresso].getIdQuesito(), controller.getS().username));
					textDomanda.setText(controller.getT().getQuesiti()[progresso].getDomanda());
					spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(controller.getT().getQuesiti()[progresso].getPunteggioMin()), new Float(controller.getT().getQuesiti()[progresso].getPunteggioMax()), new Float(1)));
				}
				
			}
		});
	}
}
