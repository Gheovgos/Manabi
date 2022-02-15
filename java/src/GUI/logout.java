package GUI;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logout {

	JFrame frmManabi;
	Controller controller;
	private JTextField txtSeiSicuroDi;

	public logout(Controller c) {
		controller = c;
		initialize();
		frmManabi.setVisible(true);
		
	}

	private void initialize() {
		frmManabi = new JFrame();
		frmManabi.setAlwaysOnTop(true);
		frmManabi.setTitle("Manabi");
		frmManabi.setResizable(false);
		frmManabi.setIconImage(Toolkit.getDefaultToolkit().getImage(logout.class.getResource("/Immagini/icona manabi.png")));
		frmManabi.getContentPane().setBackground(new Color(255, 255, 255));
		frmManabi.setBounds(100, 100, 391, 271);
		frmManabi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManabi.getContentPane().setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("Si");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3_1.setBackground(new Color(100, 149, 237));
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_3_1.setBounds(245, 45, 69, 23);
		frmManabi.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("No");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controller.getI() != null) {
					
					frmManabi.setVisible(false);
					frmManabi.dispose();

					
				}
				else {
					
					frmManabi.setVisible(false);
					frmManabi.dispose();

					
				}
			}
		});
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(100, 149, 237));
		btnNewButton_3.setFont(new Font("Candara", Font.PLAIN, 13));
		btnNewButton_3.setBounds(83, 45, 69, 23);
		frmManabi.getContentPane().add(btnNewButton_3);
		
		txtSeiSicuroDi = new JTextField();
		txtSeiSicuroDi.setForeground(new Color(65, 105, 225));
		txtSeiSicuroDi.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeiSicuroDi.setEditable(false);
		txtSeiSicuroDi.setText("SEI SICURO DI VOLER USCIRE?");
		txtSeiSicuroDi.setFont(new Font("Corbel", Font.BOLD, 17));
		txtSeiSicuroDi.setColumns(10);
		txtSeiSicuroDi.setBorder(null);
		txtSeiSicuroDi.setBackground(Color.WHITE);
		txtSeiSicuroDi.setBounds(51, 11, 281, 23);
		frmManabi.getContentPane().add(txtSeiSicuroDi);
	}
}
