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
import java.util.Arrays;
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
	boolean isOpen = true, ta = false, tb = false, tc = false, td = false, te = false;
	int nRisposte = 1;
	private JTextField textA;
	private JTextField textB;
	private JTextField textC;
	private JTextField textD;
	private JTextField textE;
	private JTextField inputMin;
	private JTextField inputMax;
	int i;
	private JTextField txtLaRispostaGiusta;

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
		textField.setBounds(150, 25, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnQuesitoSalvaoPer = new JTextPane();
		txtpnQuesitoSalvaoPer.setEditable(false);
		txtpnQuesitoSalvaoPer.setVisible(false);
		txtpnQuesitoSalvaoPer.setBounds(350, 353, 225, 20);
		frame.getContentPane().add(txtpnQuesitoSalvaoPer);
		
		inputMin = new JTextField();
		inputMin.setBounds(150, 56, 86, 20);
		frame.getContentPane().add(inputMin);
		inputMin.setColumns(10);
		
		inputMax = new JTextField();
		inputMax.setBounds(150, 86, 86, 20);
		frame.getContentPane().add(inputMax);
		inputMax.setColumns(10);
		
		JSlider slider = new JSlider();
		
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
		
		JTextPane minSupMax = new JTextPane();
		minSupMax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		minSupMax.setForeground(Color.RED);
		minSupMax.setToolTipText("Prova a mettere un valore minore al massimo, od ad aumentare il massimo.");
		minSupMax.setText("Il punteggio minimo supera il massimo!");
		minSupMax.setVisible(false);
		minSupMax.setEditable(false);
		minSupMax.setBounds(362, 286, 141, 34);
		frame.getContentPane().add(minSupMax);
		
		JTextPane warningMul = new JTextPane();
		warningMul.setToolTipText("Non puoi lasciare risposte vuote.");
		warningMul.setText("Inserisci tutte le risposte!");
		warningMul.setForeground(Color.RED);
		warningMul.setFont(new Font("Tahoma", Font.PLAIN, 13));
		warningMul.setEditable(false);
		warningMul.setBounds(190, 193, 89, 51);
		warningMul.setVisible(false);
		frame.getContentPane().add(warningMul);
		
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
				
				
				Random rand = new Random();
				i = rand.nextInt(999);
				textField.setText(String.valueOf(i));
				while(!controller.checkQuizId(i, isOpen)) {
					i = rand.nextInt(999);
					textField.setText(String.valueOf(i));					
				}
				
			}
		});
		btnNewButton.setBounds(246, 24, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnIdentificativoDomanda = new JTextPane();
		txtpnIdentificativoDomanda.setText("Identificativo domanda");
		txtpnIdentificativoDomanda.setBackground(new Color(255, 255, 255));
		txtpnIdentificativoDomanda.setEditable(false);
		txtpnIdentificativoDomanda.setBounds(10, 25, 130, 20);
		frame.getContentPane().add(txtpnIdentificativoDomanda);
		
		JEditorPane dtrpnLaDomandaVa = new JEditorPane();
		dtrpnLaDomandaVa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					
					String[] r = new String[0];
					boolean a, b, c, d;
					
					if(textField.getText().equals("")) {						
						Random rand = new Random();
						i = rand.nextInt(999);
						textField.setText(String.valueOf(i));
						while(!controller.checkQuizId(i, isOpen)) {
							i = rand.nextInt(999);
							textField.setText(String.valueOf(i));					
						}
					}
					
					if(inputMin.getText().equals("")) {
						a = false;
						warningMin.setVisible(true);		
					}
					else {a = true; warningMin.setVisible(false);}
					
					if(inputMax.getText().equals("")) {
						b = false;
						txtpnInserisciIlPunteggio.setVisible(true);		
					}
					else {b = true; txtpnInserisciIlPunteggio.setVisible(false);}
					
					if(dtrpnLaDomandaVa.getText().equals("")) {
						c = false;
						txtpnLaDomandaNon.setVisible(true);
						
					}
					else {
						c = true;
						txtpnLaDomandaNon.setVisible(false);
					}
					
					if(Float.parseFloat(inputMin.getText()) >= Float.parseFloat(inputMax.getText())) {minSupMax.setVisible(true); d = false;} else {minSupMax.setVisible(false); d = true;}
					
					if(isOpen && a && b && c && d) {
						controller.inizializzaQuesito(i, controller.t.id, Float.parseFloat(inputMin.getText()),  Float.parseFloat(inputMax.getText()), dtrpnLaDomandaVa.getText(), r, isOpen);
						txtpnQuesitoSalvaoPer.setText("Quesito aperto salvato per il test \""+controller.t.nomeTest+"\"");
						txtpnQuesitoSalvaoPer.setVisible(true); }
					
				}
				else {
					boolean a, b, c, d;
					
					String[] r = new String[5];
					Arrays.fill(r, "");
					if(textField.getText().equals("")) {
						
						
						Random rand = new Random();
						i = rand.nextInt(999);
						textField.setText(String.valueOf(i));
						while(!controller.checkQuizId(i, isOpen)) {
							i = rand.nextInt(999);
							textField.setText(String.valueOf(i));					
						}
						
					}
					
					if(inputMin.getText().equals("")) {
						a = false;
						warningMin.setVisible(true);		
					}
					else {a = true; warningMin.setVisible(false);}
					
					if(inputMax.getText().equals("")) {
						b = false;
						txtpnInserisciIlPunteggio.setVisible(true);		
					}
					else {b = true; txtpnInserisciIlPunteggio.setVisible(false);}
					
					if(dtrpnLaDomandaVa.getText().equals("")) {
						c = false;
						txtpnLaDomandaNon.setVisible(true);
						
					}
					else {
						c = true;
						txtpnLaDomandaNon.setVisible(false);
					}
					
					if(Float.parseFloat(inputMin.getText()) >= Float.parseFloat(inputMax.getText())) {minSupMax.setVisible(true); d = false;} else {minSupMax.setVisible(false); d = true;}
					
					if(slider.getValue() == 1) {isOpen = true;}
					
					if(slider.getValue() == 2) {
						boolean f;
						if(textA.getText().equals("") || textB.getText().equals("")) {
							warningMul.setVisible(true);
							f = false;
						}
						else {warningMul.setVisible(false); f = true; r[0] = textA.getText(); r[1] = textB.getText();  }
						
						if(!isOpen && a && b && c && d && f) {
							controller.inizializzaQuesito(i, controller.t.id, Float.parseFloat(inputMin.getText()),  Float.parseFloat(inputMax.getText()), dtrpnLaDomandaVa.getText(), r, isOpen);
							warningMul.setVisible(false);
							txtpnQuesitoSalvaoPer.setText("Quesito multiplo salvato per il test \""+controller.t.nomeTest+"\"");
							txtpnQuesitoSalvaoPer.setVisible(true); 
							//salva nel DB
						}						
					}
					if(slider.getValue() == 3) {
						boolean f;
						if(textA.getText().equals("") || textB.getText().equals("") || textC.getText().equals("")) {
							warningMul.setVisible(true);
							f = false;
						}
						else {warningMul.setVisible(false); f = true; r[0] = textA.getText(); r[1] = textB.getText(); r[2] = textC.getText();}
						
						if(!isOpen && a && b && c && d && f) {
							controller.inizializzaQuesito(i, controller.t.id, Float.parseFloat(inputMin.getText()),  Float.parseFloat(inputMax.getText()), dtrpnLaDomandaVa.getText(), r, isOpen);
							warningMul.setVisible(false);
							txtpnQuesitoSalvaoPer.setText("Quesito multiplo salvato per il test \""+controller.t.nomeTest+"\"");
							txtpnQuesitoSalvaoPer.setVisible(true); 
							//salva nel DB
						}						
					}
					
					if(slider.getValue() == 4) {
						boolean f;
						if(textA.getText().equals("") || textB.getText().equals("") || textC.getText().equals("") || textD.getText().equals("")) {
							warningMul.setVisible(true);
							f = false;
						}
						else {warningMul.setVisible(false); f = true; r[0] = textA.getText(); r[1] = textB.getText(); r[2] = textC.getText(); r[3] = textD.getText();}
						
						if(!isOpen && a && b && c && d && f) {
							controller.inizializzaQuesito(i, controller.t.id, Float.parseFloat(inputMin.getText()),  Float.parseFloat(inputMax.getText()), dtrpnLaDomandaVa.getText(), r, isOpen);
							warningMul.setVisible(false);
							txtpnQuesitoSalvaoPer.setText("Quesito multiplo salvato per il test \""+controller.t.nomeTest+"\"");
							txtpnQuesitoSalvaoPer.setVisible(true); 
							//salva nel DB
						}						
					}
					
					if(slider.getValue() == 5) {
						boolean f;
						if(textA.getText().equals("") || textB.getText().equals("") || textC.getText().equals("") || textD.getText().equals("") || textE.getText().equals("")) {
							warningMul.setVisible(true);
							f = false;
						}
						else {warningMul.setVisible(false); f = true; r[0] = textA.getText(); r[1] = textB.getText(); r[2] = textC.getText(); r[3] = textD.getText(); r[4] = textE.getText();}
						
						if(!isOpen && a && b && c && d && f) {
							controller.inizializzaQuesito(i, controller.t.id, Float.parseFloat(inputMin.getText()),  Float.parseFloat(inputMax.getText()), dtrpnLaDomandaVa.getText(), r, isOpen);
							warningMul.setVisible(false);
							txtpnQuesitoSalvaoPer.setText("Quesito multiplo salvato per il test \""+controller.t.nomeTest+"\"");
							txtpnQuesitoSalvaoPer.setVisible(true); 
							//salva nel DB
						}						
					}
					
					
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
		
		txtLaRispostaGiusta = new JTextField();
		txtLaRispostaGiusta.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtLaRispostaGiusta.setEditable(false);
		txtLaRispostaGiusta.setVisible(false);
		txtLaRispostaGiusta.setText("La risposta giusta va inserita nella risposta A.");
		txtLaRispostaGiusta.setBounds(130, 162, 171, 20);
		frame.getContentPane().add(txtLaRispostaGiusta);
		txtLaRispostaGiusta.setColumns(10);
		
		
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				if(slider.getValue() == 1) {
					
					textA.setVisible(false); txtpnA.setVisible(false); textB.setVisible(false); txtpnB.setVisible(false);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false);  isOpen = true; txtLaRispostaGiusta.setVisible(false);
					
					ta = false; tb = false; tc = false; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
			
				if(slider.getValue() == 2) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false; txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = false; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 3) {
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false; txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 4) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(false); txtpnE.setVisible(false); isOpen = false; txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = true; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
				}
				
				if(slider.getValue() == 5) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(true); txtpnE.setVisible(true); isOpen = false; txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = true; te = true;
					
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
		
		JTextPane txtpnStaiCreandoQuesiti = new JTextPane();
		txtpnStaiCreandoQuesiti.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnStaiCreandoQuesiti.setText("Stai creando quesiti per il Test \""+controller.t.nomeTest+"\"");
		txtpnStaiCreandoQuesiti.setEditable(false);
		txtpnStaiCreandoQuesiti.setBounds(10, 3, 225, 20);
		frame.getContentPane().add(txtpnStaiCreandoQuesiti);
		
		
		
		
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(slider.getValue() == 1) {
					
					textA.setVisible(false); txtpnA.setVisible(false); textB.setVisible(false); txtpnB.setVisible(false);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); txtLaRispostaGiusta.setVisible(false);
					
					ta = false; tb = false; tc = false; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
			
				if(slider.getValue() == 2) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(false); txtpnC.setVisible(false); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = false; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 3) {
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(false); txtpnD.setVisible(false); 
					
					textE.setVisible(false); txtpnE.setVisible(false); txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = false; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
				}
				
				if(slider.getValue() == 4) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(false); txtpnE.setVisible(false); txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = true; te = false;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
				}
				
				if(slider.getValue() == 5) {
					
					textA.setVisible(true); txtpnA.setVisible(true); textB.setVisible(true); txtpnB.setVisible(true);
					
					textC.setVisible(true); txtpnC.setVisible(true); textD.setVisible(true); txtpnD.setVisible(true); 
					
					textE.setVisible(true); txtpnE.setVisible(true); txtLaRispostaGiusta.setVisible(true);
					
					ta = true; tb = true; tc = true; td = true; te = true;
					
					textnRisposte.setText(String.valueOf(slider.getValue()));
					
					
				}
				
			}
		});
	
		
		
		
	}
}
