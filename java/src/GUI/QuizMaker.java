package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JSlider;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class QuizMaker {

	JFrame frame;
	Controller controller;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	boolean isOpen = true;
	int nRisposte = 1;
	private JTextField textA;
	private JTextField textB;
	private JTextField textC;
	private JTextField textD;
	private JTextField textE;
	private JTextField inputMin;
	private JTextField inputMax;

	public QuizMaker(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	@SuppressWarnings("removal")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 997, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnQuesitoSalvaoPer = new JTextPane();
		txtpnQuesitoSalvaoPer.setEditable(false);
		txtpnQuesitoSalvaoPer.setText("Quesito salvao per il test INSERISCI TEST ");
		txtpnQuesitoSalvaoPer.setVisible(false);
		txtpnQuesitoSalvaoPer.setBounds(335, 353, 225, 20);
		frame.getContentPane().add(txtpnQuesitoSalvaoPer);
		
		inputMin = new JTextField();
		inputMin.setBounds(150, 56, 86, 20);
		frame.getContentPane().add(inputMin);
		inputMin.setColumns(10);
		
		inputMax = new JTextField();
		inputMax.setBounds(150, 86, 86, 20);
		frame.getContentPane().add(inputMax);
		inputMax.setColumns(10);
		
		JTextPane warningMin = new JTextPane();
		warningMin.setEditable(false);
		warningMin.setForeground(Color.RED);
		warningMin.setFont(new Font("Tahoma", Font.PLAIN, 7));
		warningMin.setText("Inserisci il punteggio minimo!");
		warningMin.setBounds(246, 56, 89, 20);
		frame.getContentPane().add(warningMin);
		warningMin.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio = new JTextPane();
		txtpnInserisciIlPunteggio.setText("Inserisci il punteggio massimo!");
		txtpnInserisciIlPunteggio.setForeground(Color.RED);
		txtpnInserisciIlPunteggio.setFont(new Font("Tahoma", Font.PLAIN, 7));
		txtpnInserisciIlPunteggio.setEditable(false);
		txtpnInserisciIlPunteggio.setBounds(246, 86, 89, 20);
		frame.getContentPane().add(txtpnInserisciIlPunteggio);
		txtpnInserisciIlPunteggio.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio_1 = new JTextPane();
		txtpnInserisciIlPunteggio_1.setText("Inserisci la risposta!");
		txtpnInserisciIlPunteggio_1.setForeground(Color.RED);
		txtpnInserisciIlPunteggio_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnInserisciIlPunteggio_1.setEditable(false);
		txtpnInserisciIlPunteggio_1.setBounds(130, 162, 89, 20);
		frame.getContentPane().add(txtpnInserisciIlPunteggio_1);
		txtpnInserisciIlPunteggio_1.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio_1_1 = new JTextPane();
		txtpnInserisciIlPunteggio_1_1.setText("Inserisci la risposta!");
		txtpnInserisciIlPunteggio_1_1.setForeground(Color.RED);
		txtpnInserisciIlPunteggio_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnInserisciIlPunteggio_1_1.setEditable(false);
		txtpnInserisciIlPunteggio_1_1.setBounds(130, 193, 89, 20);
		frame.getContentPane().add(txtpnInserisciIlPunteggio_1_1);
		txtpnInserisciIlPunteggio_1_1.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio_1_2 = new JTextPane();
		txtpnInserisciIlPunteggio_1_2.setText("Inserisci la risposta!");
		txtpnInserisciIlPunteggio_1_2.setForeground(Color.RED);
		txtpnInserisciIlPunteggio_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnInserisciIlPunteggio_1_2.setEditable(false);
		txtpnInserisciIlPunteggio_1_2.setBounds(130, 224, 89, 20);
		frame.getContentPane().add(txtpnInserisciIlPunteggio_1_2);
		txtpnInserisciIlPunteggio_1_2.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio_1_3 = new JTextPane();
		txtpnInserisciIlPunteggio_1_3.setText("Inserisci la risposta!");
		txtpnInserisciIlPunteggio_1_3.setForeground(Color.RED);
		txtpnInserisciIlPunteggio_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnInserisciIlPunteggio_1_3.setEditable(false);
		txtpnInserisciIlPunteggio_1_3.setBounds(130, 255, 89, 20);
		frame.getContentPane().add(txtpnInserisciIlPunteggio_1_3);
		txtpnInserisciIlPunteggio_1_3.setVisible(false);
		
		JTextPane txtpnInserisciIlPunteggio_1_4 = new JTextPane();
		txtpnInserisciIlPunteggio_1_4.setText("Inserisci la risposta!");
		txtpnInserisciIlPunteggio_1_4.setForeground(Color.RED);
		txtpnInserisciIlPunteggio_1_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnInserisciIlPunteggio_1_4.setEditable(false);
		txtpnInserisciIlPunteggio_1_4.setBounds(130, 286, 89, 20);
		txtpnInserisciIlPunteggio_1_4.setVisible(false);
		frame.getContentPane().add(txtpnInserisciIlPunteggio_1_4);
		
		JTextPane txtpnLaDomandaNon = new JTextPane();
		txtpnLaDomandaNon.setText("La domanda non pu\u00F2 essere vuota!");
		txtpnLaDomandaNon.setForeground(Color.RED);
		txtpnLaDomandaNon.setEditable(false);
		txtpnLaDomandaNon.setVisible(false);
		
		txtpnLaDomandaNon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtpnLaDomandaNon.setBounds(848, 286, 116, 34);
		frame.getContentPane().add(txtpnLaDomandaNon);
		
		JButton btnNewButton = new JButton("Genera");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				@SuppressWarnings("removal")
				Integer i = new Integer(0);
				Random rand = new Random();
				i = rand.nextInt(999);
				textField.setText(String.valueOf(i));
				while(!controller.checkQuizId(i, isOpen)) {
					i = rand.nextInt(999);
					textField.setText(String.valueOf(i));					
				}
				controller.q.idQuesito = i;
			}
		});
		btnNewButton.setBounds(246, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnIdentificativoDomanda = new JTextPane();
		txtpnIdentificativoDomanda.setText("Identificativo domanda");
		txtpnIdentificativoDomanda.setBackground(new Color(255, 255, 255));
		txtpnIdentificativoDomanda.setEditable(false);
		txtpnIdentificativoDomanda.setBounds(10, 11, 130, 34);
		frame.getContentPane().add(txtpnIdentificativoDomanda);
		
		JEditorPane dtrpnLaDomandaVa = new JEditorPane();
		dtrpnLaDomandaVa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dtrpnLaDomandaVa.setText("La domanda va qui\r\nprova");
		dtrpnLaDomandaVa.setBounds(373, 11, 591, 263);
		frame.getContentPane().add(dtrpnLaDomandaVa);
		
		btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				back.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 353, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Salva");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isOpen) {
					boolean a, b, c;
					controller.q.idTest = controller.t.id;
					if(textField.getText().equals("")) {
						
						Integer i = new Integer(0);
						Random rand = new Random();
						i = rand.nextInt(999);
						textField.setText(String.valueOf(i));
						while(!controller.checkQuizId(i, isOpen)) {
							i = rand.nextInt(999);
							textField.setText(String.valueOf(i));					
						}
						controller.q.idQuesito = i;
					}
					
					if(inputMin.getText().equals("")) {
						a = false;
						warningMin.setVisible(true);		
					}
					else {a = true; warningMin.setVisible(false); controller.q.punteggioMin = Float.parseFloat(inputMin.getText());}
					
					if(txtpnInserisciIlPunteggio.getText().equals("")) {
						b = false;
						txtpnInserisciIlPunteggio.setVisible(true);		
					}
					else {b = true; txtpnInserisciIlPunteggio.setVisible(false); controller.q.punteggioMax = Float.parseFloat(inputMax.getText());}
					
					if(dtrpnLaDomandaVa.getText().equals("")) {
						c = false;
						txtpnLaDomandaNon.setVisible(true);
						
					}
					else {
						c = true;
						txtpnLaDomandaNon.setVisible(false); controller.q.domanda = dtrpnLaDomandaVa.getText();
					}
					
					if(a && b && c)
					txtpnQuesitoSalvaoPer.setVisible(false);
					//salva nel DB
				}
			}
		});
		btnNewButton_2.setBounds(882, 353, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		textA = new JTextField();
		textA.setBounds(10, 162, 86, 20);
		frame.getContentPane().add(textA);
		textA.setColumns(10);
		textA.setVisible(false);
		
		textB = new JTextField();
		textB.setBounds(10, 193, 86, 20);
		frame.getContentPane().add(textB);
		textB.setColumns(10);
		textB.setVisible(false);
		
		textC = new JTextField();
		textC.setBounds(10, 224, 86, 20);
		frame.getContentPane().add(textC);
		textC.setColumns(10);
		textC.setVisible(false);
		
		textD = new JTextField();
		textD.setBounds(10, 255, 86, 20);
		frame.getContentPane().add(textD);
		textD.setColumns(10);
		textD.setVisible(false);
		
		textE = new JTextField();
		textE.setBounds(10, 286, 86, 20);
		frame.getContentPane().add(textE);
		textE.setColumns(10);
		textE.setVisible(false);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setEditable(false);
		txtpnA.setText("A");
		txtpnA.setBounds(106, 162, 14, 20);
		frame.getContentPane().add(txtpnA);
		txtpnA.setVisible(false);
		
		JTextPane txtpnB = new JTextPane();
		txtpnB.setText("B");
		txtpnB.setEditable(false);
		txtpnB.setBounds(106, 193, 14, 20);
		frame.getContentPane().add(txtpnB);
		txtpnB.setVisible(false);
		
		JTextPane txtpnC = new JTextPane();
		txtpnC.setText("C");
		txtpnC.setEditable(false);
		txtpnC.setBounds(106, 224, 14, 20);
		frame.getContentPane().add(txtpnC);
		txtpnC.setVisible(false);
		
		JTextPane txtpnD = new JTextPane();
		txtpnD.setText("D");
		txtpnD.setEditable(false);
		txtpnD.setBounds(106, 254, 14, 20);
		frame.getContentPane().add(txtpnD);
		txtpnD.setVisible(false);
		
		JTextPane txtpnE = new JTextPane();
		txtpnE.setText("E");
		txtpnE.setEditable(false);
		txtpnE.setBounds(106, 286, 14, 20);
		frame.getContentPane().add(txtpnE);
		txtpnE.setVisible(false);
		
		JTextPane txtpnPunteggioMinimo = new JTextPane();
		txtpnPunteggioMinimo.setEditable(false);
		txtpnPunteggioMinimo.setText("Punteggio minimo");
		txtpnPunteggioMinimo.setBounds(10, 56, 130, 20);
		frame.getContentPane().add(txtpnPunteggioMinimo);
		
		JTextPane txtpnPunteggioMasssimo = new JTextPane();
		txtpnPunteggioMasssimo.setEditable(false);
		txtpnPunteggioMasssimo.setText("Punteggio masssimo");
		txtpnPunteggioMasssimo.setBounds(10, 86, 130, 20);
		frame.getContentPane().add(txtpnPunteggioMasssimo);
		
		
		
		
		JTextPane txtpnNumeroPossibiliRisposte = new JTextPane();
		txtpnNumeroPossibiliRisposte.setEditable(false);
		txtpnNumeroPossibiliRisposte.setToolTipText("Il numero di risposte possibili. Se una, allora la domanda \u00E8 a risposta aperta, altrimenti \u00E8 a risposta multipla.");
		txtpnNumeroPossibiliRisposte.setText("Numero risposte possibili");
		txtpnNumeroPossibiliRisposte.setBounds(10, 117, 130, 20);
		frame.getContentPane().add(txtpnNumeroPossibiliRisposte);
		JTextPane textnRisposte = new JTextPane();
		textnRisposte.setText("1");
		textnRisposte.setEditable(false);
		textnRisposte.setBounds(229, 136, 20, 20);
		frame.getContentPane().add(textnRisposte);
		
		JSlider slider = new JSlider();
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				if(slider.getValue() == 1) {
					
					textA.setVisible(false); txtpnA.setVisible(false); textB.setVisible(false); txtpnB.setVisible(false);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false);  isOpen = true;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
			
				if(slider.getValue() == 2) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 3) {
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 4) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
				}
				
				if(slider.getValue() == 5) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(true); txtpnE.setVisible(true); isOpen = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
					
				}
			}
		});
		slider.setValue(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setBackground(Color.WHITE);
		slider.setBounds(135, 117, 200, 26);
		frame.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(QuizMaker.class.getResource("/Immagini/polpo blu manabi.png")));
		lblNewLabel.setBounds(594, 307, 244, 92);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(slider.getValue() == 1) {
					
					textA.setVisible(false); txtpnA.setVisible(false); textB.setVisible(false); txtpnB.setVisible(false);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); 
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
			
				if(slider.getValue() == 2) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); 
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 3) {
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); 
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 4) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(false); txtpnE.setVisible(false); 
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
				}
				
				if(slider.getValue() == 5) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(true); txtpnE.setVisible(true); 
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
					
				}
				
			}
		});
	
		
		
		
	}
}
