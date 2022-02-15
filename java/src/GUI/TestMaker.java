package GUI;

import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
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
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
public class TestMaker {

	Controller controller;
	JFrame frame;
	int i = 0;
	private JTextField textidTest;
	private JTextField textNome;
	private JTextField textTempo;
	private JTextField textField;
	private JTextField txtCampoObbligatorio;

	public TestMaker(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestMaker.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi - Crea Test");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 648, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textidTest = new JTextField();
		textidTest.setBackground(Color.WHITE);
		textidTest.setForeground(Color.BLACK);
		textidTest.setBounds(135, 87, 96, 20);
		frame.getContentPane().add(textidTest);
		textidTest.setColumns(10);
		
		JTextPane txtpnIdentificativoTest = new JTextPane();
		txtpnIdentificativoTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnIdentificativoTest.setToolTipText("Inserisci un identificativo al Test. Deve essere un numero decimale non negativo.");
		txtpnIdentificativoTest.setBackground(Color.WHITE);
		txtpnIdentificativoTest.setForeground(Color.BLACK);
		txtpnIdentificativoTest.setEditable(false);
		txtpnIdentificativoTest.setText("*ID TEST:");
		txtpnIdentificativoTest.setBounds(33, 87, 104, 20);
		frame.getContentPane().add(txtpnIdentificativoTest);
		
		
		JButton btnCasual = new JButton("Genera");
		btnCasual.setBorder(null);
		btnCasual.setBackground(new Color(176, 196, 222));
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
		btnCasual.setBounds(241, 86, 89, 21);
		frame.getContentPane().add(btnCasual);
		
		textNome = new JTextField();
		textNome.setBounds(135, 118, 195, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JTextPane txtpnNomeTest = new JTextPane();
		txtpnNomeTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnNomeTest.setEditable(false);
		txtpnNomeTest.setToolTipText("Inserisci il nome del test. Deve essere una stringa");
		txtpnNomeTest.setText("*NOME TEST:");
		txtpnNomeTest.setBounds(33, 118, 96, 20);
		frame.getContentPane().add(txtpnNomeTest);
		
		textTempo = new JTextField();
		textTempo.setBounds(135, 149, 96, 20);
		frame.getContentPane().add(textTempo);
		textTempo.setColumns(10);
		
		JTextPane txtpnTempoSvolgimento = new JTextPane();
		txtpnTempoSvolgimento.setFont(new Font("Tahoma", Font.BOLD, 8));
		txtpnTempoSvolgimento.setToolTipText("Tempo necessario per svolgere il test. Lasciare vuoto per un tempo determinato, altrimenti deve essere un tempo maggiore o uguale a 15 minuti.");
		txtpnTempoSvolgimento.setText("TEMPO SVOLGIMENTO:");
		txtpnTempoSvolgimento.setEditable(false);
		txtpnTempoSvolgimento.setBounds(33, 149, 104, 20);
		frame.getContentPane().add(txtpnTempoSvolgimento);
		
		textField = new JTextField();
		textField.setBounds(135, 180, 195, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnMateria = new JTextPane();
		txtpnMateria.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnMateria.setEditable(false);
		txtpnMateria.setText("MATERIA:");
		txtpnMateria.setBounds(33, 180, 96, 20);
		frame.getContentPane().add(txtpnMateria);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e) {
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setToolTipText("Torna al menu. Le informazioni non verranno salvate.");
		btnNewButton.setBounds(10, 527, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JEditorPane dtrpnDescrizione = new JEditorPane();
		dtrpnDescrizione.setBorder(new LineBorder(new Color(0, 0, 0)));
		dtrpnDescrizione.setBackground(new Color(255, 255, 255));
		dtrpnDescrizione.setBounds(135, 211, 447, 180);
		frame.getContentPane().add(dtrpnDescrizione);
		
		JTextPane noId = new JTextPane();
		noId.setBackground(Color.WHITE);
		noId.setForeground(new Color(0, 0, 205));
		noId.setEnabled(true);
		noId.setVisible(false);
		noId.setEditable(false);
		noId.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noId.setText("Identificativo non disponibile");
		noId.setBounds(338, 87, 68, 20);
		frame.getContentPane().add(noId);
		
		JTextPane noTime = new JTextPane();
		noTime.setBackground(Color.WHITE);
		noTime.setToolTipText("Il tempo deve essere >= 15 minuti!");
		noTime.setText("Tempo svolgimento non valido");
		noTime.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noTime.setForeground(new Color(0, 0, 255));
		noTime.setEnabled(true);
		noTime.setVisible(false);
		noTime.setEditable(false);
		noTime.setBounds(241, 149, 89, 20);
		frame.getContentPane().add(noTime);
		
		
		JTextPane noName = new JTextPane();
		noName.setBackground(Color.WHITE);
		noName.setText("Il campo non pu\u00F2 essere vuoto!");
		noName.setForeground(new Color(0, 0, 205));
		noName.setFont(new Font("Tahoma", Font.PLAIN, 7));
		noName.setEnabled(true);
		noName.setVisible(false);
		noName.setEditable(false);
		noName.setBounds(340, 118, 89, 20);
		frame.getContentPane().add(noName);
		
		JTextPane txtpnDescrizione = new JTextPane();
		txtpnDescrizione.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnDescrizione.setToolTipText("Descrizione del test. Si pu\u00F2 lasciare vuota.");
		txtpnDescrizione.setEditable(false);
		txtpnDescrizione.setText("DESCRIZIONE:");
		txtpnDescrizione.setBounds(33, 211, 96, 20);
		frame.getContentPane().add(txtpnDescrizione);
		
		JButton btnNewButton_1 = new JButton("CONFERMA");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
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
		
					if(tempo.before(tMin)) {c = false; noTime.setVisible(true);} else { c = true; noTime.setVisible(false);}
					
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
					
					controller.setT(new Test(Integer.parseInt(textidTest.getText()), controller.getI().username, textNome.getText(), textField.getText(), dtrpnDescrizione.getText()));
					controller.getT().setTempo(tempo);
					controller.inizializzaTest();
					ConfermaTest next =new  ConfermaTest(controller);
					frame.setVisible(false);
					frame.dispose();
				}
				


			}
		});
		btnNewButton_1.setBounds(433, 402, 149, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TestMaker.class.getResource("/Immagini/manabi classic blu.png")));
		lblNewLabel.setBounds(5, 11, 214, 52);
		frame.getContentPane().add(lblNewLabel);
		
		txtCampoObbligatorio = new JTextField();
		txtCampoObbligatorio.setBorder(null);
		txtCampoObbligatorio.setForeground(new Color(0, 0, 205));
		txtCampoObbligatorio.setOpaque(false);
		txtCampoObbligatorio.setBackground(new Color(0, 0, 205));
		txtCampoObbligatorio.setText("(*) CAMPO OBBLIGATORIO");
		txtCampoObbligatorio.setBounds(35, 403, 258, 20);
		frame.getContentPane().add(txtCampoObbligatorio);
		txtCampoObbligatorio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TestMaker.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel_1.setBounds(10, 0, 645, 561);
		frame.getContentPane().add(lblNewLabel_1);

		
	}
}
