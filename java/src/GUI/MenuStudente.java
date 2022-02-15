package GUI;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Point;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuStudente {

 JFrame frmManabi;
 Controller controller;
 private JTextField txtPunti;
 private JTextField txtTotali;
 private JTextField txtCercaCorso;
 private JTextField txtElencoCorsiSeguiti;
 private JTextField txtProfiloUtente;
 private JTextField txtTestSvolti;
 private JTextField txtMettiPuntiSce;
 private JTextField txtUltimoTestSvolto;
 private JTextField txtBenvenuto;
 private JTextField txtMettiUltimoTest;

 public MenuStudente(Controller c) {
  controller = c;
  initialize();
  frmManabi.setVisible(true);
 }

 private void initialize() {
  frmManabi = new JFrame();
  frmManabi.setTitle("Manabi");
  frmManabi.setResizable(false);
  frmManabi.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuStudente.class.getResource("/Immagini/icona manabi.png")));
  frmManabi.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
  frmManabi.getContentPane().setBackground(Color.WHITE);
  frmManabi.setBounds(100, 100, 648, 600);
  frmManabi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frmManabi.getContentPane().setLayout(null);
  
  txtTotali = new JTextField();
  txtTotali.setEditable(false);
  txtTotali.setText("TOTALI");
  txtTotali.setFont(new Font("Corbel", Font.BOLD, 18));
  txtTotali.setColumns(10);
  txtTotali.setBorder(null);
  txtTotali.setOpaque(false);
  txtTotali.setBackground(Color.WHITE);
  txtTotali.setBounds(550, 511, 63, 23);
  frmManabi.getContentPane().add(txtTotali);
  
  JButton btnElencoCorsiSeguiti = new JButton("");
  btnElencoCorsiSeguiti.addMouseListener(new MouseAdapter() {
  	@SuppressWarnings("unused")
	@Override
  	public void mouseClicked(MouseEvent e) {
  		VisualizaTestSvolti next = new VisualizaTestSvolti(controller);
  	}
  });
  btnElencoCorsiSeguiti.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/sfondi/studente1.png")));
  btnElencoCorsiSeguiti.setFont(new Font("Candara", Font.PLAIN, 13));
  btnElencoCorsiSeguiti.setBounds(472, 112, 141, 315);
  frmManabi.getContentPane().add(btnElencoCorsiSeguiti);
  
  JButton btnNewButton_4 = new JButton("LOG OUT");
  btnNewButton_4.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseClicked(MouseEvent e) {
  		
  		logout ex = new logout(controller);
  		ex.frmManabi.setVisible(true);
  	}
  });
  btnNewButton_4.setBackground(SystemColor.controlHighlight);
  btnNewButton_4.setBorder(null);
  btnNewButton_4.setFont(new Font("Candara", Font.BOLD, 13));
  btnNewButton_4.setBounds(20, 519, 107, 14);
  frmManabi.getContentPane().add(btnNewButton_4);
  
  txtPunti = new JTextField();
  txtPunti.setEditable(false);
  txtPunti.setBorder(null);
  txtPunti.setOpaque(false);
  txtPunti.setBackground(Color.WHITE);
  txtPunti.setFont(new Font("Corbel", Font.BOLD, 18));
  txtPunti.setText("PUNTI");
  txtPunti.setBounds(525, 496, 63, 23);
  frmManabi.getContentPane().add(txtPunti);
  txtPunti.setColumns(10);
  
  JSeparator separator = new JSeparator();
  separator.setBounds(439, 412, 263, -246);
  frmManabi.getContentPane().add(separator);
  
  JButton btnElencoCorsiSeguiti_1 = new JButton("");
  btnElencoCorsiSeguiti_1.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseClicked(MouseEvent e) {
		@SuppressWarnings("unused")
		UserSettings next = new UserSettings(controller, false);
  	}
  });
  btnElencoCorsiSeguiti_1.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/sfondi/studente4.png")));
  btnElencoCorsiSeguiti_1.setFont(new Font("Candara", Font.PLAIN, 13));
  btnElencoCorsiSeguiti_1.setBounds(321, 112, 141, 315);
  frmManabi.getContentPane().add(btnElencoCorsiSeguiti_1);
  
  JButton btnElencoCorsiSeguiti_1_1_1 = new JButton("");
  btnElencoCorsiSeguiti_1_1_1.addMouseListener(new MouseAdapter() {
  	@SuppressWarnings("unused")
	public void mouseClicked(MouseEvent e) {
  		VisualizzaTestDaCompilare next = new VisualizzaTestDaCompilare(controller);
  		frmManabi.setVisible(false);
		frmManabi.dispose();

  	}
  });
  btnElencoCorsiSeguiti_1_1_1.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/sfondi/studente3.png")));
  btnElencoCorsiSeguiti_1_1_1.setFont(new Font("Candara", Font.PLAIN, 13));
  btnElencoCorsiSeguiti_1_1_1.setBounds(20, 112, 141, 315);
  frmManabi.getContentPane().add(btnElencoCorsiSeguiti_1_1_1);
  
  JButton btnElencoCorsiSeguiti_1_1 = new JButton("");
 
  btnElencoCorsiSeguiti_1_1.setIgnoreRepaint(true);
  btnElencoCorsiSeguiti_1_1.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/sfondi/studente2.png")));
  btnElencoCorsiSeguiti_1_1.setFont(new Font("Candara", Font.PLAIN, 13));
  btnElencoCorsiSeguiti_1_1.setBounds(171, 112, 141, 315);
  frmManabi.getContentPane().add(btnElencoCorsiSeguiti_1_1);
  
  txtCercaCorso = new JTextField();
  txtCercaCorso.setEditable(false);
  txtCercaCorso.setHorizontalAlignment(SwingConstants.CENTER);
  txtCercaCorso.setForeground(new Color(112, 128, 144));
  txtCercaCorso.setFont(new Font("Tahoma", Font.BOLD, 13));
  txtCercaCorso.setLocation(new Point(0, 12));
  txtCercaCorso.setText("CERCA CORSO");
  txtCercaCorso.setBounds(170, 87, 142, 20);
  frmManabi.getContentPane().add(txtCercaCorso);
  txtCercaCorso.setColumns(10);
  
  txtElencoCorsiSeguiti = new JTextField();
  txtElencoCorsiSeguiti.setEditable(false);
  txtElencoCorsiSeguiti.setText("COMPILA TEST");
  txtElencoCorsiSeguiti.setLocation(new Point(0, 12));
  txtElencoCorsiSeguiti.setHorizontalAlignment(SwingConstants.CENTER);
  txtElencoCorsiSeguiti.setForeground(new Color(112, 128, 144));
  txtElencoCorsiSeguiti.setFont(new Font("Tahoma", Font.BOLD, 13));
  txtElencoCorsiSeguiti.setColumns(10);
  txtElencoCorsiSeguiti.setBounds(20, 87, 142, 20);
  frmManabi.getContentPane().add(txtElencoCorsiSeguiti);
  
  txtProfiloUtente = new JTextField();
  txtProfiloUtente.setEditable(false);
  txtProfiloUtente.setText("PROFILO UTENTE");
  txtProfiloUtente.setLocation(new Point(0, 12));
  txtProfiloUtente.setHorizontalAlignment(SwingConstants.CENTER);
  txtProfiloUtente.setForeground(new Color(112, 128, 144));
  txtProfiloUtente.setFont(new Font("Tahoma", Font.BOLD, 13));
  txtProfiloUtente.setColumns(10);
  txtProfiloUtente.setBounds(321, 87, 142, 20);
  frmManabi.getContentPane().add(txtProfiloUtente);
  
  txtTestSvolti = new JTextField();
  txtTestSvolti.setEditable(false);
  txtTestSvolti.setText("TEST SVOLTI");
  txtTestSvolti.setLocation(new Point(0, 12));
  txtTestSvolti.setHorizontalAlignment(SwingConstants.CENTER);
  txtTestSvolti.setForeground(new Color(112, 128, 144));
  txtTestSvolti.setFont(new Font("Tahoma", Font.BOLD, 13));
  txtTestSvolti.setColumns(10);
  txtTestSvolti.setBounds(471, 87, 142, 20);
  frmManabi.getContentPane().add(txtTestSvolti);
  
  txtMettiPuntiSce = new JTextField();
  txtMettiPuntiSce.setText(String.valueOf(controller.ottieniPunteggioStudente(controller.getS().username)));
  txtMettiPuntiSce.setEditable(false);
  txtMettiPuntiSce.setHorizontalAlignment(SwingConstants.CENTER);
  txtMettiPuntiSce.setBorder(null);
  txtMettiPuntiSce.setOpaque(false);
  txtMettiPuntiSce.setBounds(514, 505, 39, 39);
  frmManabi.getContentPane().add(txtMettiPuntiSce);
  txtMettiPuntiSce.setColumns(10);
  
  txtUltimoTestSvolto = new JTextField();
  txtUltimoTestSvolto.setEditable(false);
  txtUltimoTestSvolto.setHorizontalAlignment(SwingConstants.CENTER);
  txtUltimoTestSvolto.setText("ULTIMO TEST SVOLTO");
  txtUltimoTestSvolto.setBackground(SystemColor.controlHighlight);
  txtUltimoTestSvolto.setBorder(null);
  txtUltimoTestSvolto.setBounds(20, 434, 593, 14);
  frmManabi.getContentPane().add(txtUltimoTestSvolto);
  txtUltimoTestSvolto.setColumns(10);
  
  JLabel lblNewLabel_1 = new JLabel("");
  lblNewLabel_1.setIcon(new ImageIcon(MenuStudente.class.getResource("/Immagini/manabi classic blu.png")));
  lblNewLabel_1.setBounds(10, -10, 433, 111);
  frmManabi.getContentPane().add(lblNewLabel_1);
  
  txtBenvenuto = new JTextField();
  txtBenvenuto.setEditable(false);
  txtBenvenuto.setBorder(null);
  txtBenvenuto.setOpaque(false);
  txtBenvenuto.setText("Benvenuto, "+controller.getS().username);
  txtBenvenuto.setLocation(new Point(0, 12));
  txtBenvenuto.setHorizontalAlignment(SwingConstants.LEFT);
  txtBenvenuto.setForeground(new Color(112, 128, 144));
  txtBenvenuto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
  txtBenvenuto.setColumns(10);
  txtBenvenuto.setBounds(226, 11, 182, 20);
  frmManabi.getContentPane().add(txtBenvenuto);
  
  txtMettiUltimoTest = new JTextField();
  txtMettiUltimoTest.setEditable(false);
  txtMettiUltimoTest.setHorizontalAlignment(SwingConstants.CENTER);
  txtMettiUltimoTest.setText(controller.ottieniUltimoTestSvolto(controller.getS().username));
  txtMettiUltimoTest.setBorder(null);
  txtMettiUltimoTest.setOpaque(false);
  txtMettiUltimoTest.setBounds(20, 449, 593, 20);
  frmManabi.getContentPane().add(txtMettiUltimoTest);
  txtMettiUltimoTest.setColumns(10);
  
  btnElencoCorsiSeguiti_1_1.addMouseListener(new MouseAdapter() {
	  	@SuppressWarnings("unused")
		public void mouseClicked(MouseEvent e) {
	  		CercaCorso next = new CercaCorso(controller);
	  	}
	  });
 }

}