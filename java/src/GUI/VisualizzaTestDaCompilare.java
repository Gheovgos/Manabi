package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VisualizzaTestDaCompilare {

	JFrame frame;
	Controller controller;
	
	public VisualizzaTestDaCompilare(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 609, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] rs = controller.returnCompTestName(controller.s.username);
		int max = rs.length;
		controller.caricaTest(rs[0]);
		controller.caricaInsegnante(controller.t.creatoreTest);
		
		
		JComboBox comboBox = new JComboBox();	
		
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setBounds(10, 47, 299, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnElencoDeiTest = new JTextPane();
		txtpnElencoDeiTest.setText("Elenco dei test da poter compilare: ");
		txtpnElencoDeiTest.setEditable(false);
		txtpnElencoDeiTest.setBounds(10, 11, 299, 20);
		frame.getContentPane().add(txtpnElencoDeiTest);
		
		JTextPane textNomeTest = new JTextPane();
		textNomeTest.setText("Nome test: "+controller.t.nomeTest);
		textNomeTest.setEditable(false);
		textNomeTest.setBounds(10, 96, 129, 20);
		frame.getContentPane().add(textNomeTest);
		
		JTextPane txtpnAutore = new JTextPane();
		txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome);
		txtpnAutore.setEditable(false);
		txtpnAutore.setBounds(227, 96, 140, 20);
		frame.getContentPane().add(txtpnAutore);
		
		JTextPane txtpnTempo = new JTextPane();
		txtpnTempo.setText("Tempo: "+controller.t.tempo);
		txtpnTempo.setEditable(false);
		txtpnTempo.setBounds(377, 96, 165, 20);
		frame.getContentPane().add(txtpnTempo);
		
		JEditorPane editorDescrizione = new JEditorPane();
		editorDescrizione.setText(controller.t.descrizione);
		editorDescrizione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		editorDescrizione.setEditable(false);
		editorDescrizione.setBounds(10, 181, 567, 141);
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
		btnNewButton.setBounds(10, 378, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Compila");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				controller.addCorrezione(controller.i.username, controller.s.username, controller.t.id);
				CompilaTest next = new CompilaTest(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(484, 378, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				textNomeTest.setText("Nome test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome); txtpnTempo.setText("Tempo: "+controller.t.tempo); txtpnMateria.setText("Materia: "+controller.t.materia);
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				textNomeTest.setText("Nome test: "+controller.t.nomeTest); editorDescrizione.setText(controller.t.descrizione);
				txtpnAutore.setText("Autore: "+controller.i.cognome+" "+controller.i.nome); txtpnTempo.setText("Tempo: "+controller.t.tempo); txtpnMateria.setText("Materia: "+controller.t.materia);
				
			}
		});
		
		
		
	}
}
