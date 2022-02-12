package GUI;

import java.awt.EventQueue;
import controller.*;
import modelli.Quesiti;
import modelli.Test;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInsegnante {

	JFrame frame;
	Controller controller;
	private JTextField txtBenvenuto;
	private JTextField txtCreaTest;
	private JTextField txtCreaQuesito;
	private JTextField txtVisualizzaTest;
	private JTextField txtCorreggiTest;
	private JTextField txtNonHaiCreato;
	private JTextField txtNonHaiCreato_1;
	
	public MenuInsegnante(Controller c) {
		controller = c;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Manabi");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInsegnante.class.getResource("/Immagini/icona manabi.png")));
		frame.setBackground(new Color(211, 211, 211));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 648, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/manabi.png")));
		lblNewLabel.setBounds(10, 9, 254, 72);
		frame.getContentPane().add(lblNewLabel);
		
		txtCreaTest = new JTextField();
		txtCreaTest.setText("CREA TEST");
		txtCreaTest.setLocation(new Point(0, 12));
		txtCreaTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreaTest.setForeground(new Color(60, 179, 113));
		txtCreaTest.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtCreaTest.setEditable(false);
		txtCreaTest.setColumns(10);
		txtCreaTest.setBounds(10, 495, 146, 20);
		frame.getContentPane().add(txtCreaTest);
		
		txtBenvenuto = new JTextField();
		txtBenvenuto.setBackground(Color.WHITE);
		txtBenvenuto.setEditable(false);
		txtBenvenuto.setText("Benvenuto, "+controller.i.username);
		txtBenvenuto.setBounds(247, 35, 294, 20);
		frame.getContentPane().add(txtBenvenuto);
		txtBenvenuto.setColumns(10);
		
		JButton creaTest = new JButton("");
		creaTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		creaTest.setBackground(new Color(255, 204, 204));
		creaTest.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/depositphotos_397023826-stock-illustration-multiethnic-big-group-of-people.jpg")));
		creaTest.setBorderPainted(false);
		creaTest.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TestMaker testmaker = new TestMaker(controller);
				frame.setVisible(false);
				testmaker.frame.setVisible(true);
			}
		});
		creaTest.setToolTipText("Crea un nuovo test");
		creaTest.setBounds(10, 85, 146, 399);
		frame.getContentPane().add(creaTest);
		
		JButton vediTest = new JButton("");
		vediTest.setBackground(new Color(255, 255, 102));
		vediTest.setBorderPainted(false);
		vediTest.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/photo5778473851175418934.jpg")));
		vediTest.setToolTipText("Apre una finestra in cui puoi vedere i tuoi test creati e le relative informazioni");
		vediTest.setBounds(319, 85, 147, 399);
		frame.getContentPane().add(vediTest);
		
		JButton correggiTest = new JButton("");
		correggiTest.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/photo5776222051361732470.jpg")));
		correggiTest.setBackground(new Color(255, 153, 102));
		correggiTest.setBorderPainted(false);
		correggiTest.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				VisualizzaTestDaCorreggere next = new VisualizzaTestDaCorreggere(controller);
				next.frame.setVisible(true);
				
			}
		});
		correggiTest.setBounds(473, 85, 147, 399);
		frame.getContentPane().add(correggiTest);
		
		JButton creaQuiz = new JButton("");
		creaQuiz.setBorderPainted(false);
		creaQuiz.setBackground(new Color(0, 153, 153));
		creaQuiz.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/157165096418396890.jpg")));
		creaQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				VisualizzaTestCreati next = new VisualizzaTestCreati(controller); 
				frame.setVisible(false);
				next.frame.setVisible(true);
			}
		});
		creaQuiz.setBounds(166, 85, 147, 399);
		frame.getContentPane().add(creaQuiz);
		
		JButton logout = new JButton("LOG OUT");
		logout.setFont(new Font("Tahoma", Font.PLAIN, 9));
		logout.setBorderPainted(false);
		logout.setBackground(new Color(51, 153, 102));
		logout.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				logout Logout = new logout(controller);
				Logout.frmManabi.setVisible(true);
			}
		});
		logout.setBounds(10, 526, 103, 23);
		frame.getContentPane().add(logout);
		
		JButton apriSettings = new JButton("");
		apriSettings.setContentAreaFilled(false);
		apriSettings.setBorderPainted(false);
		apriSettings.setIcon(new ImageIcon(MenuInsegnante.class.getResource("/Immagini/settings.png")));
		apriSettings.setBounds(574, 11, 48, 32);
		frame.getContentPane().add(apriSettings);
		
		txtCreaQuesito = new JTextField();
		txtCreaQuesito.setText("CREA QUESITO");
		txtCreaQuesito.setLocation(new Point(0, 12));
		txtCreaQuesito.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreaQuesito.setForeground(new Color(0, 153, 204));
		txtCreaQuesito.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtCreaQuesito.setEditable(false);
		txtCreaQuesito.setColumns(10);
		txtCreaQuesito.setBounds(166, 495, 147, 20);
		frame.getContentPane().add(txtCreaQuesito);
		
		txtVisualizzaTest = new JTextField();
		txtVisualizzaTest.setText("VISUALIZZA TEST");
		txtVisualizzaTest.setLocation(new Point(0, 12));
		txtVisualizzaTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtVisualizzaTest.setForeground(new Color(255, 204, 0));
		txtVisualizzaTest.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtVisualizzaTest.setEditable(false);
		txtVisualizzaTest.setColumns(10);
		txtVisualizzaTest.setBounds(319, 495, 147, 20);
		frame.getContentPane().add(txtVisualizzaTest);
		
		txtCorreggiTest = new JTextField();
		txtCorreggiTest.setText("CORREGGI TEST");
		txtCorreggiTest.setLocation(new Point(0, 12));
		txtCorreggiTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreggiTest.setForeground(new Color(255, 102, 0));
		txtCorreggiTest.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtCorreggiTest.setEditable(false);
		txtCorreggiTest.setColumns(10);
		txtCorreggiTest.setBounds(473, 495, 149, 20);
		frame.getContentPane().add(txtCorreggiTest);
		
		txtNonHaiCreato = new JTextField();
		txtNonHaiCreato.setForeground(new Color(255, 99, 71));
		txtNonHaiCreato.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNonHaiCreato.setOpaque(false);
		txtNonHaiCreato.setBorder(null);
		txtNonHaiCreato.setEditable(false);
		txtNonHaiCreato.setText("Non hai creato ancora nessun test! Prima di poterlo visualizzare devi crearne uno.");
		txtNonHaiCreato.setBounds(139, 526, 471, 20);
		frame.getContentPane().add(txtNonHaiCreato);
		txtNonHaiCreato.setColumns(10);
		
		txtNonHaiCreato_1 = new JTextField();
		txtNonHaiCreato_1.setText("Non hai creato ancora nessun test! Prima di poter aggiungere quesiti devi crearlo.");
		txtNonHaiCreato_1.setOpaque(false);
		txtNonHaiCreato_1.setForeground(new Color(255, 99, 71));
		txtNonHaiCreato_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNonHaiCreato_1.setEditable(false);
		txtNonHaiCreato_1.setColumns(10);
		txtNonHaiCreato_1.setBorder(null);
		txtNonHaiCreato_1.setBounds(139, 540, 471, 20);
		frame.getContentPane().add(txtNonHaiCreato_1);
	}
}