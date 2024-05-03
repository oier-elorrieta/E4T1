package Bista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DatuBasea.PlaylistDao;
import Modelo.Bezero;
import Modelo.Playlist;
import funtzioak.BistakArgitaratu;

public class PlaylistBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> model;
	private ArrayList<Playlist> playlistArray;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PlaylistBista(Bezero bz) throws SQLException {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(10, 10, 95, 29);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.MenuJoan(bz);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnAtzera);
		
		JButton btnProfila = new JButton("PROFILA");
		btnProfila.setBounds(327, 10, 99, 29);
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BistakArgitaratu.ProfilaBistaJoan(bz);
				dispose();
			}
		});
		btnProfila.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		contentPane.add(btnProfila);
		
		JList<String> listMusika = new JList<String>();
		listMusika.setBackground(SystemColor.controlLtHighlight);
		listMusika.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listMusika.setBounds(22, 53, 332, 164);
		contentPane.add(listMusika);
		
		model = new DefaultListModel<String>();
//		PlaylistDao.PlayListAtera(bz, playlistArray);

		PlaylistDao.PlayListAtera(bz);
		
		for (int i = 0; i < playlistArray.size(); i++) {
			model.addElement(playlistArray.get(i).getIzena());	
	}
		listMusika.setModel(model);
	}

}
