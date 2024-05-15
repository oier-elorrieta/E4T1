package Bista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.NirePlaylistDao;
import Modelo.Bezero;
import Modelo.Playlist;
import funtzioak.BistakArgitaratu;
import funtzioak.Inabegazioa;
import funtzioak.PlaylistFuntzioak;

public class NirePlaylistBista extends JFrame implements Inabegazioa {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> playlistModel;
	private List<Playlist> listak;
	private JButton btnEzabatu;
	private JButton btnExportatu;
	private JButton btnSartu;

	public NirePlaylistBista(Bezero bz) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.MenuJoan(bz);
				dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtzera);

		JButton btnProfila = new JButton(bz.getErabiltzaile());
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profila(bz);
			}
		});
		btnProfila.setBounds(895, 11, 89, 23);
		contentPane.add(btnProfila);

		listak = NirePlaylistDao.nirePlaylistAtera(bz);

		JList<String> listPlaylist = new JList<String>();
		listPlaylist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (listPlaylist.getSelectedIndex() >= 0) {
						btnEzabatu.setEnabled(true);
						btnExportatu.setEnabled(true);
						btnSartu.setEnabled(true);
					}
				}
			}
		});
		listPlaylist.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		listPlaylist.setBounds(10, 58, 682, 379);
		contentPane.add(listPlaylist);

		playlistModel = new DefaultListModel<String>();
		for (Playlist playlista : listak) {
			playlistModel.addElement(playlista.getIzena());
		}
		listPlaylist.setModel(playlistModel);

		JButton btnSortu = new JButton("Berria Sortu");
		btnSortu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaylistSortu(bz, playlistModel, listPlaylist, listak, false);
				listPlaylist.setModel(playlistModel);

				btnEzabatu.setEnabled(false);
				btnExportatu.setEnabled(false);
				btnSartu.setEnabled(false);
			}
		});
		btnSortu.setBounds(730, 58, 240, 41);
		contentPane.add(btnSortu);

		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPlaylist.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu ezabatzeko");
				} else {
					NirePlaylistDao.ezabatuPlayList(bz, listPlaylist.getSelectedIndex(), listak);

					// Berriro lortu PlayList zerrenda
					listak = NirePlaylistDao.nirePlaylistAtera(bz);

					// Modeloa ezabatu
					playlistModel.clear();

					// Berriro kargatu modeloa
					for (Playlist playlista : listak) {
						playlistModel.addElement(playlista.getIzena());
					}

					// Birkargatu Lista Modelo berriarekin
					listPlaylist.setModel(playlistModel);

					btnEzabatu.setEnabled(false);
					btnExportatu.setEnabled(false);
					btnSartu.setEnabled(false);

				}
			}
		});
		btnEzabatu.setBounds(730, 148, 240, 41);
		contentPane.add(btnEzabatu);

		JButton btnImportatu = new JButton("Importatu");
		btnImportatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// EZARRI PLAYLIST IZENA
				PlaylistSortu(bz, playlistModel, listPlaylist, listak, true);

				btnEzabatu.setEnabled(false);
				btnExportatu.setEnabled(false);
			}
		});
		btnImportatu.setBounds(730, 232, 240, 41);
		contentPane.add(btnImportatu);

		btnExportatu = new JButton("Exportatu");
		btnExportatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnExportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Playlist playlist = new Playlist();
				playlist = listak.get(listPlaylist.getSelectedIndex());
				PlaylistFuntzioak.PlaylistaExportatu(playlist);

			}
		});

		btnSartu = new JButton("PlayLista ireki");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Player...
				Playlist playlist = new Playlist();
				playlist = listak.get(listPlaylist.getSelectedIndex());
				NirePlaylistDao.lortuAbestiakIdPlaylist(playlist);
				BistakArgitaratu.PlaylistAbestiraJoan(bz, playlist);
				dispose();

			}
		});
		btnSartu.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSartu.setEnabled(false);
		btnSartu.setBounds(730, 396, 240, 41);
		contentPane.add(btnSartu);

		btnExportatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnExportatu);
		btnEzabatu.setEnabled(false);
		btnExportatu.setEnabled(false);
		btnSartu.setEnabled(false);

	}

	public static void PlaylistSortu(Bezero bz, DefaultListModel<String> playlistModel, JList<String> listPlaylist,
			List<Playlist> listak, boolean expo) {
		String playListIzenBerri = JOptionPane.showInputDialog("Ze izen jarri nahi diozu?");
		try {
			// Crear la nueva playlist
			Playlist playlista = NirePlaylistDao.sortuPlaylist(bz, playListIzenBerri);

			// Volver a obtener la lista de playlists
			listak = NirePlaylistDao.nirePlaylistAtera(bz);

			// Limpiar el modelo actual
			playlistModel.clear();

			// Agregar las playlists actualizadas al modelo
			for (Playlist playlist : listak) {
				playlistModel.addElement(playlist.getIzena());
			}

			// Actualizar la lista JList con el nuevo modelo
			listPlaylist.setModel(playlistModel);

			// Ahora, importar los elementos a la nueva playlist
			if (expo == true) {
				PlaylistFuntzioak.PlaylistaImportatu(playlista);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void profila(Bezero bz) {
        BistakArgitaratu.ProfilaBistaJoan(bz);

	}

}
