package GUI;


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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class VisualizzaTestDaCompilare {

	JFrame frame;
	Controller controller;
	
	public VisualizzaTestDaCompilare(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Manabi");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTestDaCompilare.class.getResource("/Immagini/icona manabi.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 609, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] rs = controller.returnCompTestName(controller.getS().username);
		if(rs == null) {
			System.out.println("No test");
		}
		int max = rs.length;
		controller.caricaTest(rs[0]);
		controller.caricaInsegnante(controller.getT().getCreatoreTest());
		
		JCheckBox already = new JCheckBox("Hai gi\u00E0 compilato questo test!");
		already.setSelected(true);
		already.setBounds(319, 47, 258, 23);
		frame.getContentPane().add(already);
		already.setVisible(false);
		
		
		String tempo = controller.getT().getTempo().toString();
		tempo = tempo.substring(11, 19);
		
		
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
		textNomeTest.setText("Nome test: "+controller.getT().getNomeTest());
		textNomeTest.setEditable(false);
		textNomeTest.setBounds(10, 96, 129, 20);
		frame.getContentPane().add(textNomeTest);
		
		JTextPane txtpnAutore = new JTextPane();
		txtpnAutore.setText("Autore: "+controller.getI().cognome+" "+controller.getI().nome);
		txtpnAutore.setEditable(false);
		txtpnAutore.setBounds(227, 96, 140, 43);
		frame.getContentPane().add(txtpnAutore);
		
		JTextPane txtpnTempo = new JTextPane();
		txtpnTempo.setText("Tempo: "+tempo);
		txtpnTempo.setEditable(false);
		txtpnTempo.setBounds(377, 96, 200, 20);
		frame.getContentPane().add(txtpnTempo);
		
		JEditorPane editorDescrizione = new JEditorPane();
		editorDescrizione.setText(controller.getT().getDescrizione());
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
		txtpnMateria.setText("Materia: "+controller.getT().getMateria());
		txtpnMateria.setEditable(false);
		txtpnMateria.setBounds(227, 150, 120, 20);
		frame.getContentPane().add(txtpnMateria);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuStudente back = new MenuStudente(controller);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Compila");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.getT().getCreatoreTest());
				
				controller.addCorrezione(controller.getI().username, controller.getS().username, controller.getT().getId());
				
				CompilaTest next = new CompilaTest(controller);
				frame.setVisible(false);
				frame.dispose();
}
		});
		btnNewButton_1.setBounds(494, 526, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
			
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int selected = 0;
				
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.getT().getCreatoreTest());
				String tempo = controller.getT().getTempo().toString();
				tempo = tempo.substring(11, 19);
				textNomeTest.setText("Nome test: "+controller.getT().getNomeTest()); editorDescrizione.setText(controller.getT().getDescrizione());
				txtpnAutore.setText("Autore: "+controller.getI().cognome+" "+controller.getI().nome); txtpnTempo.setText("Tempo: "+tempo); txtpnMateria.setText("Materia: "+controller.getT().getMateria());
				if(controller.checkAlreadySolved(controller.getT().getId(), controller.getS().username)) {
					already.setVisible(false);
					btnNewButton_1.setVisible(true);				
				}
				else {
					already.setVisible(true);
					btnNewButton_1.setVisible(false);
				}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				controller.caricaInsegnante(controller.getT().getCreatoreTest());
				String tempo = controller.getT().getTempo().toString();
				tempo = tempo.substring(11, 19);
				textNomeTest.setText("Nome test: "+controller.getT().getNomeTest()); editorDescrizione.setText(controller.getT().getDescrizione());
				txtpnAutore.setText("Autore: "+controller.getI().cognome+" "+controller.getI().nome); txtpnTempo.setText("Tempo: "+tempo); txtpnMateria.setText("Materia: "+controller.getT().getMateria());
				if(controller.checkAlreadySolved(controller.getT().getId(), controller.getS().username)) {
					already.setVisible(false);
					btnNewButton_1.setVisible(true);				
				}
				else {
					already.setVisible(true);
					btnNewButton_1.setVisible(false);
				}
				
			}
		});		
	}
}
