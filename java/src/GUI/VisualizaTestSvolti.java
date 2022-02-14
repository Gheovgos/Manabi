package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
public class VisualizaTestSvolti {

	private JFrame frame;
	Controller controller;
	
	public VisualizaTestSvolti(Controller c) {
		controller  = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Manabi");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTestDaCompilare.class.getResource("/Immagini/icona manabi.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 609, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] rs = controller.returnAllTestName(controller.s.username);
		
		
		JTextPane warn = new JTextPane();
		warn.setForeground(Color.RED);
		warn.setText("Non hai svolto nessun test!");
		warn.setEditable(false);
		warn.setVisible(false);
		
		
		JTextPane txtpnIlPunteggio = new JTextPane();
		txtpnIlPunteggio.setEditable(false);
		txtpnIlPunteggio.setText("Il punteggio \u00E8 parziale. Devi attendere che l'insegnante corregga le tue risposte");
		txtpnIlPunteggio.setVisible(false);
		txtpnIlPunteggio.setBounds(109, 506, 362, 43);
		frame.getContentPane().add(txtpnIlPunteggio);
		
		warn.setBounds(319, 47, 241, 20);
		frame.getContentPane().add(warn);
		
		if(rs == null) {
			warn.setVisible(true);
			
		}
		int max = rs.length;
		controller.caricaTest(rs[0]);
		controller.caricaInsegnante(controller.t.creatoreTest);
		
		if(controller.checkAlreadySolved(controller.t.id, controller.s.username)) {txtpnIlPunteggio.setVisible(false);}
		JTextPane textPunt = new JTextPane();
		textPunt.setText("Punteggio: "+String.valueOf(controller.ottieniVotoTest(controller.s.username, controller.t.id)));
		textPunt.setBounds(377, 150, 151, 20);
		frame.getContentPane().add(textPunt);
		
		String tempo = controller.t.tempo.toString();
		tempo = tempo.substring(11, 19);
		
		
		JComboBox comboBox = new JComboBox();	
		
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setBounds(10, 47, 299, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnElencoTestSvolti = new JTextPane();
		txtpnElencoTestSvolti.setText("Elenco dei test svolti: ");
		txtpnElencoTestSvolti.setEditable(false);
		txtpnElencoTestSvolti.setBounds(10, 11, 299, 20);
		frame.getContentPane().add(txtpnElencoTestSvolti);
		
		JTextPane textNomeTest = new JTextPane();
		textNomeTest.setText("Nome test: "+controller.t.nomeTest);
		textNomeTest.setEditable(false);
		textNomeTest.setBounds(10, 96, 129, 20);
		frame.getContentPane().add(textNomeTest);
		
		JTextPane txtpnAutore = new JTextPane();
		txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome);
		txtpnAutore.setEditable(false);
		txtpnAutore.setBounds(227, 96, 140, 43);
		frame.getContentPane().add(txtpnAutore);
		
		JTextPane txtpnTempo = new JTextPane();
		txtpnTempo.setText("Tempo: "+tempo);
		txtpnTempo.setEditable(false);
		txtpnTempo.setBounds(377, 96, 200, 20);
		frame.getContentPane().add(txtpnTempo);
		
		JEditorPane editorDescrizione = new JEditorPane();
		editorDescrizione.setText(controller.t.descrizione);
		editorDescrizione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		editorDescrizione.setEditable(false);
		editorDescrizione.setBounds(10, 181, 573, 292);
		frame.getContentPane().add(editorDescrizione);
		
		JTextPane textDesc = new JTextPane();
		textDesc.setText("Descrizione:");
		textDesc.setEditable(false);
		textDesc.setBounds(10, 150, 82, 20);
		frame.getContentPane().add(textDesc);
		
		JTextPane txtpnMateria = new JTextPane();
		txtpnMateria.setText("Materia: "+controller.t.materia);
		txtpnMateria.setEditable(false);
		txtpnMateria.setBounds(227, 150, 120, 20);
		frame.getContentPane().add(txtpnMateria);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSimula = new JButton("Simula");
		btnSimula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.t.creatoreTest);
				
				
				
				SimulaTest next = new SimulaTest(controller, false);
				frame.setVisible(false);
			}
		});
		btnSimula.setBounds(494, 526, 89, 23);
		frame.getContentPane().add(btnSimula);
		
		
	
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int selected = 0;
				
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.t.creatoreTest);
				String tempo = controller.t.tempo.toString();
				tempo = tempo.substring(11, 19);
				textNomeTest.setText("Nome test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome); txtpnTempo.setText("Tempo: "+tempo); txtpnMateria.setText("Materia: "+controller.t.materia);
				
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.t.creatoreTest);
				String tempo = controller.t.tempo.toString();
				tempo = tempo.substring(11, 19);
				textNomeTest.setText("Nome test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome); txtpnTempo.setText("Tempo: "+tempo); txtpnMateria.setText("Materia: "+controller.t.materia);
				
				
			}
		});
		
	}

}
