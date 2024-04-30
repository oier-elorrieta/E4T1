package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import DatuBasea.AbeslariDao;
import DatuBasea.AlbumDao;
import Modelo.Abeslari;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import funtzioak.BistakArgitaratu;

import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AlbumBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> model;
	private List<Abesti> abestiak;
	private String kolab;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AlbumBista(Bezero bz, Album album) throws SQLException {
		
		Abesti abesti = new Abesti();
		abestiak = AlbumDao.albumarenAbestiak(album.getIzenburua());
		abesti = abestiak.get(0);
		System.out.println(abesti.toString());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<String> listMusika = new JList<String>();
		listMusika.setBackground(SystemColor.controlLtHighlight);
		listMusika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listMusika.setBounds(22, 53, 332, 164);
		contentPane.add(listMusika);

		model = new DefaultListModel<String>();
		
		if(album.getKolaboratzaileak() == null) {
			kolab = "";
			
		}else {
			kolab = album.getKolaboratzaileak();
		}
		
		for (int i = 0; i < abestiak.size(); i++) {
			System.out.println(abestiak.get(i).getAbestiIzena() + " - " + abestiak.get(i).getIraupena());
			model.addElement(abestiak.get(i).getAbestiIzena() + " - " + abestiak.get(i).getIraupena());
			
		}
		listMusika.setModel(model);

		
		JLabel lblIrudia = new JLabel("");
		lblIrudia.setBounds(20, 235, 332, 332);
		contentPane.add(lblIrudia);
		lblIrudia.setIcon(new ImageIcon(abesti.getIrudia().getBytes(1, (int)abesti.getIrudia().length())));
		
		JTextPane deskribapenaTextPane = new JTextPane();
		deskribapenaTextPane.setBackground(SystemColor.control);
		deskribapenaTextPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deskribapenaTextPane.setEditable(false);
		
		deskribapenaTextPane.setText("Kolaboratzaileak: " + kolab  + "\nArgitaratze Data: " + album.getArgitaratzea() + "\nKanta kopurua: " + abestiak.size() + "\nIraupena: "+ "egin behar");
		deskribapenaTextPane.setBounds(398, 53, 332, 514);
		contentPane.add(deskribapenaTextPane);
		
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.MenuJoan(bz);
				dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 132, 23);
		contentPane.add(btnAtzera);
		
		JButton btnPerfil = new JButton(bz.getErabiltzaile());
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.ProfilaBistaJoan(bz);
				dispose();
			}
		});
		btnPerfil.setBounds(572, 11, 177, 23);
		contentPane.add(btnPerfil);
		
		JLabel lblTitulua = new JLabel(album.getIzenburua());
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulua.setBounds(147, 11, 415, 33);
		contentPane.add(lblTitulua);
	}
}
