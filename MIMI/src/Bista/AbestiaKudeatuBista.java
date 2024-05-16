package Bista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AbeslariDao;
import DatuBasea.AbestiaKudeatuDao;
import DatuBasea.AlbumDao;
import DatuBasea.KudeatuArtistaDao;
import Modelo.Abeslari;
import Modelo.Abesti;
import Modelo.Album;
import funtzioak.BistakArgitaratu;

public class AbestiaKudeatuBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEzabatu;
	private JButton btnEditatu;
	private JButton btnSartu;
	private List<Abesti> abestiak = new ArrayList<>();
	private List<Abeslari> musikariak = new ArrayList<>();
	private List<Album> album = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public AbestiaKudeatuBista() {
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BistakArgitaratu.MusikaKudeatuJoan();
                dispose();
            }
        });
        btnAtzera.setBounds(10, 11, 89, 23);
        contentPane.add(btnAtzera);
        
        JLabel lblTitle = new JLabel("Abestiak kudeatu");
        lblTitle.setFont(new Font("Monospaced", Font.PLAIN, 60));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(119, 11, 759, 55);
        contentPane.add(lblTitle);
        
        abestiak = AbestiaKudeatuDao.AbestiakAtera();
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 77, 657, 351);
		contentPane.add(scrollPane);
		
		JList<String> listAbestiak = new JList<String>();
		listAbestiak.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(listAbestiak);
		listAbestiak.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (listAbestiak.getSelectedIndex() >= 0) {
						btnEzabatu.setEnabled(true);
						btnEditatu.setEnabled(true);
					}
				}
			}
		});

		DefaultListModel<String> playlistModel = new DefaultListModel<String>();
		for (int i = 0; i < abestiak.size(); i++) {
			playlistModel.addElement(abestiak.get(i).getAbestiIzena());
		}
		
		listAbestiak.setModel(playlistModel);
		
		btnSartu = new JButton("Berria sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbestiaSortu(musikariak,abestiak,album);
					Berregin (playlistModel,abestiak, listAbestiak);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSartu.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSartu.setEnabled(true);
		btnSartu.setBounds(730, 229, 240, 41);
		contentPane.add(btnSartu);
   

		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setEnabled(true);
		btnEzabatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAbestiak.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu ezabatzeko");
				} else {
					AbestiaKudeatuDao.ezabatuAbestia(listAbestiak.getSelectedIndex(), abestiak);

					Berregin (playlistModel,abestiak, listAbestiak);


				}
			}
		});
		btnEzabatu.setBounds(730, 148, 240, 41);
		contentPane.add(btnEzabatu);
		

		btnEditatu = new JButton("Editatu");
		btnEditatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectAukera = Aukera();
				try {
					AbestiaAldatu(selectAukera,musikariak,album, listAbestiak);
					Berregin (playlistModel,abestiak, listAbestiak);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnEditatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnEditatu);
		btnEzabatu.setEnabled(false);
		btnEditatu.setEnabled(false);
		
		
		musikariak = AbeslariDao.musikariakAtera();
		
		
	}
	
	public static void AbestiaSortu( List<Abeslari> musikariak, List<Abesti> abestiak, List<Album> album) throws SQLException {
		String abestiaIzenBerri = JOptionPane.showInputDialog("Ze izen jarri nahi diozu?");
		
		String[] musikariIzena = new String[musikariak.size()];
		for (int i = 0; i < musikariak.size(); i++) {
			musikariIzena[i] = musikariak.get(i).getIzena();

		}
		String selectedArtista = (String) JOptionPane.showInputDialog(null,
				"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
				musikariIzena, musikariIzena[0]);
		
		
		
		album = AlbumDao.lortuAlbumIzenak(selectedArtista);
		
		
		String[] albumLista = new String[album.size()];
		for (int i = 0; i < album.size(); i++) {
			albumLista[i] = album.get(i).getIzenburua();
			
		}
		
		String selectedAlbum = (String) JOptionPane.showInputDialog(null,
				"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
				albumLista, albumLista[0]);

		if (selectedArtista != null && selectedArtista.length() > 0) {
			if (AbestiaKudeatuDao.AbestiaBegiratuDagoen(abestiaIzenBerri, selectedArtista) == true) {
				JOptionPane.showMessageDialog(null, "Abesti ahu badago");
			}else {
				AbestiaKudeatuDao.AbestiaAlbum(selectedAlbum,abestiaIzenBerri,selectedArtista);
			}
		}
	}
	
public static String AbestiaAldatu(String selectedAukera, List<Abeslari> musikariak, List<Album> album, JList<String> listAbestiak) throws SQLException {
		
		
		
		if (selectedAukera == "izena") {
			
			String ArtistaIzenBerri = JOptionPane.showInputDialog("Ze izen jarri nahi diozu?");
			
			return ArtistaIzenBerri;
			
		}else if (selectedAukera == "Artista") {
			String[] musikariIzena = new String[musikariak.size()];
			for (int i = 0; i < musikariak.size(); i++) {
				musikariIzena[i] = musikariak.get(i).getIzena();

			}
			String selectedArtista = (String) JOptionPane.showInputDialog(null,
					"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
					musikariIzena, musikariIzena[0]);
			
			return selectedArtista;
			
		}else {
			String[] musikariIzena = new String[musikariak.size()];
			for (int i = 0; i < musikariak.size(); i++) {
				musikariIzena[i] = musikariak.get(i).getIzena();

			}
			String selectedArtista = (String) JOptionPane.showInputDialog(null,
					"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
					musikariIzena, musikariIzena[0]);
			
			album = AlbumDao.lortuAlbumIzenak(selectedArtista);
			
			
			String[] albumLista = new String[album.size()];
			for (int i = 0; i < album.size(); i++) {
				albumLista[i] = album.get(i).getIzenburua();
				
			}
			
			String selectedAlbum = (String) JOptionPane.showInputDialog(null,
					"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
					albumLista, albumLista[0]);
			return selectedAlbum;
		}
	}
	
	
	public static String Aukera() {
		String[] AukeraAldatu = new String[4];
		AukeraAldatu[0] = "izena";
		AukeraAldatu[1] = "Albuma";
		AukeraAldatu[2] = "Artista";

		String selectedAukera = (String) JOptionPane.showInputDialog(null,
				"Aukeratu", "Aukeratu", JOptionPane.QUESTION_MESSAGE, null,
				AukeraAldatu, AukeraAldatu[0]);
		
		return selectedAukera;
	}
	
	public static void Berregin (DefaultListModel<String> playlistModel,List<Abesti> abestiak, JList<String> listAbestiak) {

		playlistModel.clear();

		for (int i = 0; i < abestiak.size(); i++) {
			playlistModel.addElement(abestiak.get(i).getAbestiIzena());
		}

		listAbestiak.setModel(playlistModel);
	}
}