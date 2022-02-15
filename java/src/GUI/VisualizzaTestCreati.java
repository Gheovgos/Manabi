package GUI;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VisualizzaTestCreati {

	JFrame frame;
	Controller controller;
	
	

	public VisualizzaTestCreati(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		String[] rs = controller.returnTestName(controller.getI().username);
		int max = rs.length;
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTestCreati.class.getResource("/Immagini/icona manabi.png")));
		frame.setTitle("Manabi");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 648, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizzaTestCreati.class.getResource("/Immagini/manabi classic blu.png")));
		lblNewLabel.setBounds(5, 11, 214, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(max);
		comboBox.setModel(new DefaultComboBoxModel(rs));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(119, 253, 396, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnSelezionaIlTest = new JTextPane();
		txtpnSelezionaIlTest.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSelezionaIlTest.setEditable(false);
		txtpnSelezionaIlTest.setText("ELENCO TEST:");
		txtpnSelezionaIlTest.setBounds(265, 223, 133, 20);
		frame.getContentPane().add(txtpnSelezionaIlTest);
		
		JButton btnNewButton_2 = new JButton("Crea");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TestMaker next = new TestMaker(controller);
				
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(533, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
	
		JButton btnNewButton = new JButton("Modifica");
		
		btnNewButton.setBounds(533, 494, 89, 22);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				@SuppressWarnings("unused")
				MenuInsegnante back = new MenuInsegnante(controller);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(10, 527, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VisualizzaTestCreati.class.getResource("/Immagini/SFONDO TUTTO.png")));
		lblNewLabel_1.setBounds(0, -25, 632, 586);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int selected = 0;
				selected = comboBox.getSelectedIndex();
				controller.caricaTest(rs[selected], controller.getI().username);
				QuizMaker next = new QuizMaker(controller);
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		
		
	}
}
