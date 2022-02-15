package GUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import controller.Controller;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VisualizzaTestInsegnante {

	private JFrame frame;
	Controller controller;
	private JTextField txtID;
	private JTextField txtNomeTest;
	private JTextField txtMateria;
	private JTextField warn;
	
	public VisualizzaTestInsegnante(Controller c) {
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
		String[] rs = controller.returnAllTest(controller.getI().username);
		warn = new JTextField();
		warn.setBorder(new EmptyBorder(0, 0, 0, 0));
		warn.setForeground(Color.RED);
		warn.setText("Il test non ha quesiti!");
		warn.setVisible(false);
		warn.setEditable(false);
		warn.setBounds(109, 527, 221, 20);
		frame.getContentPane().add(warn);
		warn.setColumns(10);
		
		if(rs == null) {
			warn.setText("Non hai creato alcun test!");
			warn.setVisible(true);
		}
		
		int max = rs.length;
		
		controller.caricaTest(rs[0]);
		controller.caricaInsegnante(controller.getT().getCreatoreTest());
		
		
		String tempo = controller.getT().getTempo().toString();
		tempo = tempo.substring(11, 19);
		
		
		
		JComboBox comboBox = new JComboBox();	
		
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setBounds(10, 31, 299, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnElencoDeiTest = new JTextPane();
		txtpnElencoDeiTest.setText("Elenco dei test creati: ");
		txtpnElencoDeiTest.setEditable(false);
		txtpnElencoDeiTest.setBounds(10, 11, 299, 20);
		frame.getContentPane().add(txtpnElencoDeiTest);
		
		JTextPane textNomeTest = new JTextPane();
		textNomeTest.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textNomeTest.setText(controller.getT().getNomeTest());
		textNomeTest.setBounds(10, 84, 198, 43);
		frame.getContentPane().add(textNomeTest);
		
		JTextPane txtpnTempo = new JTextPane();
		txtpnTempo.setText("Tempo: "+tempo);
		txtpnTempo.setEditable(false);
		txtpnTempo.setBounds(377, 96, 200, 20);
		frame.getContentPane().add(txtpnTempo);
		
		JEditorPane editorDescrizione = new JEditorPane();
		editorDescrizione.setText(controller.getT().getDescrizione());
		editorDescrizione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		editorDescrizione.setBounds(10, 181, 573, 292);
		frame.getContentPane().add(editorDescrizione);
		
		JTextPane textDesc = new JTextPane();
		textDesc.setText("Descrizione:");
		textDesc.setEditable(false);
		textDesc.setBounds(10, 150, 82, 20);
		frame.getContentPane().add(textDesc);
		
		JTextPane editorMateria = new JTextPane();
		editorMateria.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorMateria.setText(controller.getT().getMateria());
		editorMateria.setBounds(218, 84, 149, 43);
		frame.getContentPane().add(editorMateria);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				frame.dispose();

			}
		});
		btnNewButton.setBounds(10, 526, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				controller.getT().setNomeTest(textNomeTest.getText());
				controller.getT().setDescrizione(editorDescrizione.getText());
				controller.getT().setMateria(editorMateria.getText());
				
				controller.updateTest();
				controller.caricaTest(rs[0]);
				
			}
		});
		
		btnNewButton_1.setBounds(494, 526, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txtID = new JTextField();
		txtID.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtID.setBackground(Color.WHITE);
		txtID.setText("Identificativo: "+controller.getT().getId());
		txtID.setEditable(false);
		txtID.setBounds(336, 32, 167, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btnSimula = new JButton("Simula");
		btnSimula.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!controller.hasQ()) {
					warn.setVisible(true);
				}
				else {
					SimulaTest next = new SimulaTest(controller, true);
					frame.setVisible(false);
					frame.dispose();

				}
				
				
			}
		});
		btnSimula.setBounds(244, 484, 89, 23);
		frame.getContentPane().add(btnSimula);
		
		txtNomeTest = new JTextField();
		txtNomeTest.setBackground(Color.WHITE);
		txtNomeTest.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNomeTest.setEditable(false);
		txtNomeTest.setText("Nome test: ");
		txtNomeTest.setBounds(10, 64, 86, 20);
		frame.getContentPane().add(txtNomeTest);
		txtNomeTest.setColumns(10);
		
		txtMateria = new JTextField();
		txtMateria.setText("Materia:");
		txtMateria.setEditable(false);
		txtMateria.setColumns(10);
		txtMateria.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtMateria.setBackground(Color.WHITE);
		txtMateria.setBounds(218, 64, 86, 20);
		frame.getContentPane().add(txtMateria);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizzaTestInsegnante.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel.setBounds(102, 0, 823, 602);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		comboBox.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				int selected = 0;			
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				
				String tempo = controller.getT().getTempo().toString();
				tempo = tempo.substring(11, 19);
				txtID.setText("Identificativo: "+controller.getT().getId());
				textNomeTest.setText(controller.getT().getNomeTest()); editorDescrizione.setText(controller.getT().getDescrizione());
				txtpnTempo.setText("Tempo: "+tempo); editorMateria.setText(controller.getT().getMateria()); }
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected]);
				
				String tempo = controller.getT().getTempo().toString();
				txtID.setText("Identificativo: "+controller.getT().getId());
				tempo = tempo.substring(11, 19);
				textNomeTest.setText(controller.getT().getNomeTest()); editorDescrizione.setText(controller.getT().getDescrizione());
				txtpnTempo.setText("Tempo: "+tempo); editorMateria.setText(controller.getT().getMateria());
				
				
			}
		});
		
		
	}
}
