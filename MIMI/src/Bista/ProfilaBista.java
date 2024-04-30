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
import funtzioak.BistakArgitaratu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

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
		setBounds(100, 100, 774, 633);
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
		ProfilaIzena.setForeground(Color.BLACK);
		ProfilaIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaIzena.setBounds(57, 102, 46, 14);
		contentPane.add(ProfilaIzena);
		
		textIzena = new JTextField(bz.getIzena());
		textIzena.setEditable(false);
		textIzena.setBounds(101, 101, 116, 20);
		contentPane.add(textIzena);
		textIzena.setColumns(10);
		
		JLabel ProfilaAbizena = new JLabel("Abizena");
		ProfilaAbizena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaAbizena.setBounds(372, 104, 69, 14);
		contentPane.add(ProfilaAbizena);
		
		textAbizena = new JTextField(bz.getAbizena());
		textAbizena.setEditable(false);
		textAbizena.setBounds(436, 101, 138, 20);
		contentPane.add(textAbizena);
		textAbizena.setColumns(10);
		
		JLabel ProfilaErabiltzailea = new JLabel("Erabiltzailea");
		ProfilaErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaErabiltzailea.setBounds(30, 179, 73, 14);
		contentPane.add(ProfilaErabiltzailea);
		
		textErabiltzalea = new JTextField(bz.getErabiltzaile());
		textErabiltzalea.setEditable(false);
		textErabiltzalea.setBounds(113, 178, 123, 20);
		contentPane.add(textErabiltzalea);
		textErabiltzalea.setColumns(10);
		
		JLabel ProfilaPasahitza = new JLabel("Pasahitza");
		ProfilaPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaPasahitza.setBounds(357, 179, 69, 14);
		contentPane.add(ProfilaPasahitza);
		
		textPasahitza = new JPasswordField(bz.getPasahitza());
		textPasahitza.setEditable(false);
		textPasahitza.setBounds(436, 178, 138, 20);
		contentPane.add(textPasahitza);
		textPasahitza.setColumns(10);
		
		JLabel ProfilaKonfirmatu = new JLabel("Konfirmatu");
		ProfilaKonfirmatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProfilaKonfirmatu.setBounds(357, 245, 84, 14);
		contentPane.add(ProfilaKonfirmatu);
		
		textKonfirmatu = new JPasswordField(bz.getPasahitza());
		textKonfirmatu.setEditable(false);
		textKonfirmatu.setBounds(436, 244, 138, 20);
		contentPane.add(textKonfirmatu);
		textKonfirmatu.setColumns(10);
		
		
		JButton btnEditatu = new JButton("Editatu");
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIzena.setEditable(true);
				textAbizena.setEditable(true);
				textErabiltzalea.setEditable(true);
				textPasahitza.setEditable(true);
				textKonfirmatu.setEditable(true);
			}
		});
		btnEditatu.setBounds(74, 426, 108, 36);
		contentPane.add(btnEditatu);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BezeroDao.BezeroUpdate(bz, textIzena, textAbizena, textErabiltzalea, textPasahitza);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGorde.setBounds(476, 426, 108, 36);
		contentPane.add(btnGorde);

		
	}
}

