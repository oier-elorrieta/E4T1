package Bista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AbeslariDao;
import DatuBasea.PodcasterDao;

import java.sql.SQLException;

import Modelo.Abeslari;
import Modelo.Album;
import Modelo.Podcast;
import Modelo.Podcaster;
import funtzioak.BistakArgitaratu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class PodcasterBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DefaultListModel<String> model;
	private List<Podcaster> podcasterList;


	public PodcasterBista(String artistaIzena, List<Podcast> podcastList, String erabiltzailea) throws SQLException {
		setResizable(false);

		podcasterList = PodcasterDao.podcakasterAtera();
		Podcaster podcaster = new Podcaster();

		for (int i = 0; i < podcasterList.size(); i++) {
			if (podcasterList.get(i).getIzena().equals(artistaIzena)) {
				podcaster = podcasterList.get(i);
				break;
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.PodcastDeskubrituJoan(erabiltzailea);
				dispose();
			}
		});
		btnAtzera.setBounds(5, 5, 132, 23);
		contentPane.add(btnAtzera);

		// Hay
		JButton btnPerfil = new JButton(erabiltzailea);
		btnPerfil.setBounds(572, 5, 177, 23);
		contentPane.add(btnPerfil);

		JLabel lblTitulua = new JLabel(artistaIzena);
		lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setBounds(147, 9, 415, 33);
		contentPane.add(lblTitulua);
		JLabel lblirudia = new JLabel();
		lblirudia.setHorizontalAlignment(SwingConstants.CENTER);
		lblirudia.setBounds(22, 235, 332, 332);
		contentPane.add(lblirudia);
		lblirudia.setIcon(new ImageIcon(podcaster.getIrudia().getBytes(1, (int) podcaster.getIrudia().length())));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JList<String> listMusika = new JList<String>();
		listMusika.setBackground(SystemColor.controlLtHighlight);
		listMusika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listMusika.setBounds(22, 53, 332, 164);
		contentPane.add(listMusika);

		model = new DefaultListModel<String>();
		
		podcastList = PodcasterDao.podcastLortu(artistaIzena);
		
		for (int i = 0; i < podcastList.size(); i++) {
			model.addElement(artistaIzena + " - " + podcastList.get(i).getPodcast_izena());
		}
		listMusika.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				
					

				}
			}

		});
		listMusika.setModel(model);

		JTextPane deskribapenaTextPane = new JTextPane();
		deskribapenaTextPane.setBackground(SystemColor.control);
		deskribapenaTextPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deskribapenaTextPane.setEditable(false);
		deskribapenaTextPane.setText(podcaster.getInfo());
		deskribapenaTextPane.setBounds(398, 53, 332, 514);
		contentPane.add(deskribapenaTextPane);

	}

}
