package GUI;

import java.awt.EventQueue;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.Font;
import modelli.*;
public class TestMaker {

	Controller controller;
	JFrame frame;
	int i = 0;
	private JTextField textidTest;
	private JTextField textNome;
	private JTextField textTempo;
	private JTextField textField;

	public TestMaker(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textidTest = new JTextField();
		textidTest.setBackground(Color.WHITE);
		textidTest.setForeground(Color.BLACK);
		textidTest.setBounds(135, 11, 86, 20);
		frame.getContentPane().add(textidTest);
		textidTest.setColumns(10);
		
		JTextPane txtpnIdentificativoTest = new JTextPane();
		txtpnIdentificativoTest.setToolTipText("Inserisci un identificativo al Test. Deve essere un numero decimale non negativo.");
		txtpnIdentificativoTest.setBackground(Color.WHITE);
		txtpnIdentificativoTest.setForeground(Color.BLACK);
		txtpnIdentificativoTest.setEditable(false);
		txtpnIdentificativoTest.setText("Identificativo Test");
		txtpnIdentificativoTest.setBounds(10, 11, 104, 20);
		frame.getContentPane().add(txtpnIdentificativoTest);
		
		
		JButton btnCasual = new JButton("Genera");
		btnCasual.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				Random rand = new Random();
				i = rand.nextInt(999);
				textidTest.setText(String.valueOf(i));
				while(!controller.checkTestId(i)) {
					i = rand.nextInt(999);
					textidTest.setText(String.valueOf(i));					
				}
				
			}
		});
		btnCasual.setToolTipText("Genera un identificativo casuale");
		btnCasual.setBounds(241, 10, 89, 23);
		frame.getContentPane().add(btnCasual);
		
		textNome = new JTextField();
		textNome.setBounds(135, 42, 86, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JTextPane txtpnNomeTest = new JTextPane();
		txtpnNomeTest.setEditable(false);
		txtpnNomeTest.setToolTipText("Inserisci il nome del test. Deve essere una stringa");
		txtpnNomeTest.setText("Nome Test");
		txtpnNomeTest.setBounds(10, 42, 96, 20);
		frame.getContentPane().add(txtpnNomeTest);
		
		textTempo = new JTextField();
		textTempo.setBounds(135, 73, 86, 20);
		frame.getContentPane().add(textTempo);
		textTempo.setColumns(10);
		
		JTextPane txtpnTempoSvolgimento = new JTextPane();
		txtpnTempoSvolgimento.setToolTipText("Tempo necessario per svolgere il test. Lasciare vuoto per un tempo determinato, altrimenti deve essere un tempo maggiore o uguale a 15 minuti.");
		txtpnTempoSvolgimento.setText("Tempo svolgimento");
		txtpnTempoSvolgimento.setEditable(false);
		txtpnTempoSvolgimento.setBounds(10, 73, 104, 20);
		frame.getContentPane().add(txtpnTempoSvolgimento);
		
		textField = new JTextField();
		textField.setBounds(135, 104, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnMateria = new JTextPane();
		txtpnMateria.setEditable(false);
		txtpnMateria.setText("Materia");
		txtpnMateria.setBounds(10, 104, 96, 20);
		frame.getContentPane().add(txtpnMateria);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				back.frame.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("Torna al menu. Le informazioni non verranno salvate.");
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JEditorPane dtrpnDescrizione = new JEditorPane();
		dtrpnDescrizione.setBorder(new LineBorder(new Color(0, 0, 0)));
		dtrpnDescrizione.setBackground(new Color(255, 255, 255));
		dtrpnDescrizione.setBounds(135, 135, 271, 82);
		frame.getContentPane().add(dtrpnDescrizione);
		
		JTextPane noId = new JTextPane();
		noId.setBackground(Color.WHITE);
		noId.setForeground(Color.RED);
		noId.setEnabled(true);
		noId.setVisible(false);
		noId.setEditable(false);
		noId.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noId.setText("Identificativo non disponibile");
		noId.setBounds(338, 11, 68, 20);
		frame.getContentPane().add(noId);
		
		JTextPane noTime = new JTextPane();
		noTime.setBackground(Color.WHITE);
		noTime.setToolTipText("Il tempo deve essere >= 15 minuti!");
		noTime.setText("Tempo svolgimento non valido");
		noTime.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noTime.setForeground(Color.RED);
		noTime.setEnabled(true);
		noTime.setVisible(false);
		noTime.setEditable(false);
		noTime.setBounds(241, 73, 89, 20);
		frame.getContentPane().add(noTime);
		
		
		JTextPane noName = new JTextPane();
		noName.setBackground(Color.WHITE);
		noName.setText("Il campo non pu\u00F2 essere vuoto!");
		noName.setForeground(Color.RED);
		noName.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noName.setEnabled(true);
		noName.setVisible(false);
		noName.setEditable(false);
		noName.setBounds(241, 44, 89, 20);
		frame.getContentPane().add(noName);
		
		JTextPane txtpnDescrizione = new JTextPane();
		txtpnDescrizione.setToolTipText("Descrizione del test. Si pu\u00F2 lasciare vuota.");
		txtpnDescrizione.setEditable(false);
		txtpnDescrizione.setText("Descrizione");
		txtpnDescrizione.setBounds(10, 135, 96, 20);
		frame.getContentPane().add(txtpnDescrizione);
		
		JButton btnNewButton_1 = new JButton("Conferma");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				boolean a, b, c = true, esegui = true;
				Date tempo = new Date(); 
				Date tMin = new Date();

				if(textTempo.getText().equals("")) {esegui = false;}
				
				if(esegui) {
				String tempoMin = "00:14:59";
				DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				

				try {
					tempo = sdf.parse(textTempo.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					tMin = sdf.parse(tempoMin);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
		
					if(tempo.before(tMin)) {c = false; noTime.setVisible(true);} else { c = true; noTime.setVisible(false);  controller.t.tempo = tempo;}
					
				}
				
				if(textidTest.getText().equals("")) { 
					
					Random rand = new Random();
					i = rand.nextInt(999);
					textidTest.setText(String.valueOf(i));
					while(!controller.checkTestId(i)) {
						i = rand.nextInt(999);
						textidTest.setText(String.valueOf(i));					
					}
					a = true;
				}
					
				if(!controller.checkTestId(Integer.parseInt(textidTest.getText()))) {a = false; noId.setVisible(true);} else {a = true; noId.setVisible(false);}
				
				if(textNome.getText().equals("")) {b = false; noName.setVisible(true);} else {b = true; noName.setVisible(false);}
				
				
				
				if(a && b && c) {
					
					controller.t = new Test(Integer.parseInt(textidTest.getText()), controller.i.username, textNome.getText(), textField.getText(), dtrpnDescrizione.getText());
					controller.t.tempo = tempo;
					//controller.inizializzaTest();
					ConfermaTest next =new  ConfermaTest(controller);
					frame.setVisible(false);
					next.frmManabi.setVisible(true);
				}
				


			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		
	}
}
