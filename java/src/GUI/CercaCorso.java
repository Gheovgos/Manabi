package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import controller.Controller;

public class CercaCorso {

	private JFrame frame;
	Controller controller;
	
	public CercaCorso(Controller c) {
		controller = c;
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
		String[] mat = controller.returnAllMat();
		String[] rs = controller.returnAllTestName();
		
		int max = rs.length;
		controller.caricaTest(rs[0]);
		controller.caricaInsegnante(controller.t.creatoreTest);
		
		
		String tempo = controller.t.tempo.toString();
		tempo = tempo.substring(11, 19);
		
		JTextPane txtpnSelezionaCorso = new JTextPane();
		txtpnSelezionaCorso.setText("Seleziona corso");
		txtpnSelezionaCorso.setEditable(false);
		txtpnSelezionaCorso.setBounds(284, 11, 122, 20);
		frame.getContentPane().add(txtpnSelezionaCorso);
		
		JComboBox comboMat = new JComboBox();
		comboMat.setBounds(10, 32, 198, 22);
		frame.getContentPane().add(comboMat);
		comboMat.setMaximumRowCount(mat.length);
		comboMat.setModel(new DefaultComboBoxModel(mat));
		
		
		JComboBox comboBox = new JComboBox();	
		
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setBounds(284, 32, 299, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnElencoDeiTest = new JTextPane();
		txtpnElencoDeiTest.setText("Seleziona materia:");
		txtpnElencoDeiTest.setEditable(false);
		txtpnElencoDeiTest.setBounds(10, 11, 299, 20);
		frame.getContentPane().add(txtpnElencoDeiTest);
		
		JTextPane textNomeTest = new JTextPane();
		textNomeTest.setEditable(false);
		textNomeTest.setBorder(null);
		textNomeTest.setText("Nome test: "+controller.t.nomeTest);
		textNomeTest.setBounds(10, 84, 198, 43);
		frame.getContentPane().add(textNomeTest);
		
		JTextPane txtpnTempo = new JTextPane();
		txtpnTempo.setText("Tempo: "+tempo);
		txtpnTempo.setEditable(false);
		txtpnTempo.setBounds(383, 84, 200, 20);
		frame.getContentPane().add(txtpnTempo);
		
		JEditorPane editorDescrizione = new JEditorPane();
		editorDescrizione.setEditable(false);
		editorDescrizione.setText(controller.t.descrizione);
		editorDescrizione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		editorDescrizione.setBounds(10, 181, 573, 292);
		frame.getContentPane().add(editorDescrizione);
		
		JTextPane textDesc = new JTextPane();
		textDesc.setText("Descrizione:");
		textDesc.setEditable(false);
		textDesc.setBounds(10, 150, 82, 20);
		frame.getContentPane().add(textDesc);
		
		JTextPane editorMateria = new JTextPane();
		editorMateria.setEditable(false);
		editorMateria.setBorder(null);
		editorMateria.setText("Autore: "+controller.i.cognome+" "+controller.i.nome);
		editorMateria.setBounds(218, 84, 149, 43);
		frame.getContentPane().add(editorMateria);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(btnNewButton);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizzaTestInsegnante.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel.setBounds(102, 0, 823, 602);
		frame.getContentPane().add(lblNewLabel);
				
		comboBox.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				int selected = 0;			
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				
				String tempo = controller.t.tempo.toString();
				tempo = tempo.substring(11, 19); textNomeTest.setText("Nome Test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnTempo.setText("Tempo: "+tempo); editorMateria.setText("Autore: "+controller.i.cognome+" "+controller.i.nome); }
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				
				String tempo = controller.t.tempo.toString();
				tempo = tempo.substring(11, 19);
				textNomeTest.setText("Nome Test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnTempo.setText("Tempo: "+tempo); editorMateria.setText("Autore: "+controller.i.cognome+" "+controller.i.nome);
				
				
			}
		});
		
	}
}

