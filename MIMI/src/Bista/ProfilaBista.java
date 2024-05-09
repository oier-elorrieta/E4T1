package Bista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DatuBasea.BezeroDao;
import Modelo.Bezero;
import Modelo.PremiumBezeroa;
import funtzioak.BistakArgitaratu;
import funtzioak.ErregistratuF;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class ProfilaBista extends TxantiloiaBista {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIzena;
	private JTextField textAbizena;
	private JTextField textErabiltzalea;
	private JPasswordField textPasahitza;
	private JPasswordField textKonfirmatu;


	/**
	 * Create the frame.
	 */
	public ProfilaBista(Bezero bz) {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.MenuJoan(bz);
				dispose();
			}
		});
		btnAtzera.setBounds(5, 5, 177, 36);
		contentPane.add(btnAtzera);
		
		JLabel ProfilaIzena = new JLabel("Izena");
		ProfilaIzena.setHorizontalAlignment(SwingConstants.TRAILING);
		ProfilaIzena.setForeground(Color.BLACK);
		ProfilaIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaIzena.setBounds(113, 112, 46, 14);
		contentPane.add(ProfilaIzena);
		
		textIzena = new JTextField(bz.getIzena());
		textIzena.setEditable(false);
		textIzena.setBounds(183, 111, 123, 20);
		contentPane.add(textIzena);
		textIzena.setColumns(10);
		
		JLabel ProfilaAbizena = new JLabel("Abizena");
		ProfilaAbizena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaAbizena.setBounds(429, 112, 69, 14);
		contentPane.add(ProfilaAbizena);
		
		textAbizena = new JTextField(bz.getAbizena());
		textAbizena.setEditable(false);
		textAbizena.setBounds(508, 111, 138, 20);
		contentPane.add(textAbizena);
		textAbizena.setColumns(10);
		
		JLabel ProfilaErabiltzailea = new JLabel("Erabiltzailea");
		ProfilaErabiltzailea.setHorizontalAlignment(SwingConstants.TRAILING);
		ProfilaErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaErabiltzailea.setBounds(68, 156, 91, 14);
		contentPane.add(ProfilaErabiltzailea);
		
		textErabiltzalea = new JTextField(bz.getErabiltzaile());
		textErabiltzalea.setEditable(false);
		textErabiltzalea.setBounds(183, 155, 123, 20);
		contentPane.add(textErabiltzalea);
		textErabiltzalea.setColumns(10);
		
		JLabel ProfilaPasahitza = new JLabel("Pasahitza");
		ProfilaPasahitza.setHorizontalAlignment(SwingConstants.TRAILING);
		ProfilaPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaPasahitza.setBounds(90, 203, 69, 14);
		contentPane.add(ProfilaPasahitza);
		
		textPasahitza = new JPasswordField(bz.getPasahitza());
		textPasahitza.setEditable(false);
		textPasahitza.setBounds(183, 202, 177, 20);
		contentPane.add(textPasahitza);
		textPasahitza.setColumns(10);
		
		JLabel ProfilaKonfirmatu = new JLabel("Konfirmatu");
		ProfilaKonfirmatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaKonfirmatu.setBounds(414, 203, 84, 14);
		contentPane.add(ProfilaKonfirmatu);
		
		textKonfirmatu = new JPasswordField(bz.getPasahitza());
		textKonfirmatu.setEditable(false);
		textKonfirmatu.setBounds(508, 202, 138, 20);
		contentPane.add(textKonfirmatu);
		textKonfirmatu.setColumns(10);
		
		JLabel lblTitulua = new JLabel("PROFILA");
		lblTitulua.setFont(new Font("Monospaced", Font.PLAIN, 60));
		lblTitulua.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulua.setBounds(258, 0, 260, 77);
		contentPane.add(lblTitulua);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(5, 309, 753, 59);
		contentPane.add(splitPane);
		
		
		JButton btnEditatu = new JButton("Editatu");
		splitPane.setLeftComponent(btnEditatu);
		
		JButton btnGorde = new JButton("Gorde");
		splitPane.setRightComponent(btnGorde);
		
		JButton btnErosiPremium = new JButton("Erosi Premium");
		btnErosiPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BezeroDao.BezeroaPremiumEdoEz(bz);
			}
		});
		btnErosiPremium.setBounds(304, 275, 144, 23);
		contentPane.add(btnErosiPremium);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BezeroDao.BezeroUpdate(bz, textIzena, textAbizena, textErabiltzalea, textPasahitza);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
		
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIzena.setEditable(true);
				textAbizena.setEditable(true);
				textErabiltzalea.setEditable(true);
				textPasahitza.setEditable(true);
				textKonfirmatu.setEditable(true);
			}
		});

		
	}
}

