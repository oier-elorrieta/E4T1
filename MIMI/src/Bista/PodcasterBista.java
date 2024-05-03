package Bista;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import DatuBasea.PodcasterDao;
import Modelo.Podcaster;
import Modelo.Bezero;
import Modelo.Podcast;
import funtzioak.BistakArgitaratu;

public class PodcasterBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> model;
	private List<Podcast> podcastList;

	public PodcasterBista(Podcaster podcaster, Bezero bz) throws SQLException {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.PodcastDeskubrituJoan(bz);
				dispose();
			}
		});
		btnAtzera.setBounds(5, 5, 132, 23);
		contentPane.add(btnAtzera);

		JButton btnPerfil = new JButton(bz.getErabiltzaile());
		btnPerfil.setBounds(572, 5, 177, 23);
		contentPane.add(btnPerfil);

		JLabel lblTitulua = new JLabel(podcaster.getIzena());
		lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setBounds(147, 9, 415, 33);
		contentPane.add(lblTitulua);

		JLabel lblirudia = new JLabel();
		lblirudia.setHorizontalAlignment(SwingConstants.CENTER);
		lblirudia.setBounds(22, 235, 332, 332);
		lblirudia.setIcon(new ImageIcon(podcaster.getIrudia().getBytes(1, (int) podcaster.getIrudia().length())));
		contentPane.add(lblirudia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 53, 332, 164);
		contentPane.add(scrollPane);

		JList<String> listMusika = new JList<>();
		listMusika.setBackground(SystemColor.controlLtHighlight);
		listMusika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(listMusika);

		model = new DefaultListModel<>();

		// Aquí se elimina la redefinición de podcastList
		podcastList = PodcasterDao.podcastLortu(podcaster.getIzena());

		for (Podcast podcast : podcastList) {
			model.addElement(podcaster.getIzena() + " - " + podcast.getPodcast_izena());
		}
		listMusika.setModel(model);

		listMusika.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
                	
                    int selectedValue = listMusika.getSelectedIndex();
               
                 
                    if (selectedValue >= 0) {
                        BistakArgitaratu.PodcastErreproduktoreraJoan(bz, selectedValue, podcastList);
                        dispose();
                    } else {
                        System.out.println("Abestiaren izena ez da aurkitu.");
                    }
                }
			}
		});

		JTextPane deskribapenaTextPane = new JTextPane();
		deskribapenaTextPane.setBackground(SystemColor.control);
		deskribapenaTextPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deskribapenaTextPane.setEditable(false);
		deskribapenaTextPane.setText(podcaster.getInfo());
		deskribapenaTextPane.setBounds(398, 53, 332, 514);
		contentPane.add(deskribapenaTextPane);
	}


	
}
