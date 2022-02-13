package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
	private JLabel lblNewLabel_1;
	
	public CorreggiTest(Controller c) {
		controller = c;
		controller.caricaQuesitiTest(controller.t.id);
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		
		for(int i = 0; i < controller.t.quesiti.length; i++) {
			if(controller.t.quesiti[i].isOpen)
				lunghezza++;
		}
		while(!controller.t.quesiti[progresso].isOpen && progresso < lunghezza) {
			progresso++;
		}
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CorreggiTest.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1011, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CorreggiTest.class.getResource("/Immagini/manabi classic blu.png")));
		lblNewLabel_1.setBounds(384, 12, 214, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNomeTest = new JTextField();
		txtNomeTest.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtNomeTest.setBackground(Color.WHITE);
		txtNomeTest.setEditable(false);
		txtNomeTest.setText("TEST: "+controller.t.nomeTest);
		txtNomeTest.setBounds(10, 11, 364, 20);
		frame.getContentPane().add(txtNomeTest);
		txtNomeTest.setColumns(10);
		
		textNomeStudente = new JTextField();
		textNomeStudente.setFont(new Font("Tahoma", Font.BOLD, 10));
		textNomeStudente.setBackground(Color.WHITE);
		textNomeStudente.setEditable(false);
		textNomeStudente.setText("Studente: "+controller.s.cognome+" "+controller.s.nome);
		textNomeStudente.setBounds(10, 42, 364, 20);
		frame.getContentPane().add(textNomeStudente);
		textNomeStudente.setColumns(10);
		
		textDomanda = new JTextPane();
		textDomanda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textDomanda.setText(controller.t.quesiti[progresso].domanda);
		textDomanda.setEditable(false);
		textDomanda.setBounds(10, 73, 655, 214);
		frame.getContentPane().add(textDomanda);
		
		textRisposta = new JTextPane();
		textRisposta.setText(controller.caricaRisopsta(controller.t.quesiti[progresso].idQuesito, controller.s.username));
		textRisposta.setEditable(false);
		textRisposta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textRisposta.setBounds(10, 298, 655, 214);
		frame.getContentPane().add(textRisposta);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		
		btnNewButton_1.setBounds(877, 520, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(controller.t.quesiti[progresso].punteggioMin), new Float(controller.t.quesiti[progresso].punteggioMax), new Float(1)));
		spinner.setBounds(833, 298, 89, 20);
		frame.getContentPane().add(spinner);
		
		textPnt = new JTextField();
		textPnt.setOpaque(false);
		textPnt.setBorder(null);
		textPnt.setBackground(Color.WHITE);
		textPnt.setText("IMPOSTA PUNTEGGIO:");
		textPnt.setEditable(false);
		textPnt.setBounds(717, 298, 116, 20);
		frame.getContentPane().add(textPnt);
		textPnt.setColumns(10);
		
		JTextPane textCommento = new JTextPane();
		textCommento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textCommento.setBounds(678, 332, 288, 178);
		frame.getContentPane().add(textCommento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CorreggiTest.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel.setBounds(360, 0, 740, 569);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override //AVANTI
			public void mouseClicked(MouseEvent e) {
				boolean avanti = true;
				controller.updateRisposta(controller.t.quesiti[progresso].idQuesito, controller.s.username, (Float) spinner.getValue(), textCommento.getText());
				progresso++;
				while(!controller.t.quesiti[progresso].isOpen && progresso < lunghezza) {
					progresso++;
				}
				
				if(progresso >= lunghezza) {
					controller.aggiornaCorrezione(controller.t.id, controller.s.username);
					VisualizzaTestDaCorreggere back = new VisualizzaTestDaCorreggere(controller);
					frame.setVisible(false);
					avanti = false;
					
				}
				
				if(avanti) {
					textRisposta.setText(controller.caricaRisopsta(controller.t.quesiti[progresso].idQuesito, controller.s.username));
					textDomanda.setText(controller.t.quesiti[progresso].domanda);
					spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(controller.t.quesiti[progresso].punteggioMin), new Float(controller.t.quesiti[progresso].punteggioMax), new Float(1)));
				}
				
			}
		});
	}
}
