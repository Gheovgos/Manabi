package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

public class VisualizzaTestCreati {

	JFrame frame;
	Controller controller;
	
	

	public VisualizzaTestCreati(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		String[] rs = controller.returnTestName(controller.i.username);
		int max = rs.length;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 432, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(10, 61, 396, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnSelezionaIlTest = new JTextPane();
		txtpnSelezionaIlTest.setEditable(false);
		txtpnSelezionaIlTest.setText("Seleziona il test da modificare:");
		txtpnSelezionaIlTest.setBounds(10, 11, 238, 20);
		frame.getContentPane().add(txtpnSelezionaIlTest);
		
		JTextPane txtpnNonPuoiCreare = new JTextPane();
		txtpnNonPuoiCreare.setText("Non puoi creare quesiti a test gi\u00E0 esistenti. Creane uno!");
		txtpnNonPuoiCreare.setEditable(false);
		txtpnNonPuoiCreare.setVisible(false);
		txtpnNonPuoiCreare.setBounds(10, 30, 396, 23);
		frame.getContentPane().add(txtpnNonPuoiCreare);
		
		JButton btnNewButton_2 = new JButton("Crea");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TestMaker next = new TestMaker(controller);
				
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(164, 94, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setEnabled(false);
		
		
		/*if(CONTROLLA CONDIZIONE) {
			txtpnNonPuoiCreare.setVisible(true); btnNewButton_2.setVisible(true); btnNewButton_2.setEnabled(true); txtpnSelezionaIlTest.setVisible(false); comboBox.setVisible(false);					
		}*/
		
		JButton btnNewButton = new JButton("Modifica");
		
		btnNewButton.setBounds(317, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				back.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 151, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected], controller.i.username);
				QuizMaker next = new QuizMaker(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		
		
	}
}
