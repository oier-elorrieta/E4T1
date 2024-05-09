package Bista;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import DatuBasea.PlaylistDao;

import DatuBasea.gustukoakDao;

import Modelo.Abesti;

import Modelo.Album;

import Modelo.Bezero;

import Modelo.Playlist;

import funtzioak.BistakArgitaratu;

import funtzioak.Player;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.sql.Time;

import java.util.ArrayList;

import java.util.List;

import java.util.Timer;

import java.util.TimerTask;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.SwingConstants;

import java.awt.Font;

public class ErreproduktoreaBista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Player player;

	private JLabel lblIrudi;

	private JLabel lblInfo;

	private String idAudioLike;

	private ArrayList<Playlist> playlistArray;

	private JButton btnAbestiAtzera;

	private JButton btnAbestiAurrera;

	private JButton btnLike;

	private JLabel lblDenbora;

	private Timer timer;

	public ErreproduktoreaBista(Bezero bz, List<Abesti> abestiak, Album album, int index) throws SQLException {

		setResizable(false);

		player = new Player(abestiak, bz, index);

		player.play();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1009, 500);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		lblInfo = new JLabel("");

		lblInfo.setBounds(148, 401, 670, 60);

		contentPane.add(lblInfo);

// Info hasieratu

		player.ateraInformazioa(lblInfo, Player.indizea, abestiak);

		lblIrudi = new JLabel("");

		lblIrudi.setHorizontalAlignment(SwingConstants.CENTER);

		lblIrudi.setBounds(332, 66, 319, 290);

		contentPane.add(lblIrudi);

		btnLike = new JButton("");

// TEXTUA ALDATU LIKE 

		btnLike = new JButton("");

		// Comprobar si la canción está en la lista de favoritos

		if (gustukoakDao.DagoEdoEz(bz, idAudioLike)) {

			btnLike.setText(" ❌ ");

		} else {

			btnLike.setText(" ❤️ ");

		}

		btnLike.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				idAudioLike = abestiak.get(Player.indizea).getId();

				try {

					if (gustukoakDao.DagoEdoEz(bz, idAudioLike) == true) {

						btnLike.setText("  ❤️");

					} else {

						btnLike.setText(" ❌ ");

					}

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

			}

		});

		btnLike.setBounds(647, 366, 76, 23);

		contentPane.add(btnLike);

		JButton btnAtzera = new JButton("ATZERA");

		btnAtzera.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				player.pause();

				dispose();

				BistakArgitaratu.AlbumBistaJoan(bz, album);

			}

		});

		btnAtzera.setBounds(10, 11, 128, 23);

		contentPane.add(btnAtzera);

		JButton btnProfila = new JButton(bz.getErabiltzaile());

		btnProfila.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				player.pause();

				BistakArgitaratu.ProfilaBistaJoan(bz);

				dispose();

			}

		});

		btnProfila.setBounds(855, 11, 128, 23);

		contentPane.add(btnProfila);

		JLabel lblNewLabel = new JLabel("Musika Erreproduktorea");

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setBounds(148, 15, 697, 39);

		contentPane.add(lblNewLabel);

		player.ateraArgazkia(lblIrudi, Player.indizea, abestiak);

		JButton btnMenu = new JButton("Menua");

		btnMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					playlistArray = PlaylistDao.PlayListAtera(bz);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

				idAudioLike = abestiak.get(Player.indizea).getId();

				String[] playlistNames = new String[playlistArray.size()];

				for (int i = 0; i < playlistArray.size(); i++) {

					playlistNames[i] = playlistArray.get(i).getIzena();

					System.out.println(playlistNames[i]);

				}

				String selectedPlaylist = (String) JOptionPane.showInputDialog(ErreproduktoreaBista.this,

						"Aukeratu Playlist:", "Aukeratu Playlist-a", JOptionPane.QUESTION_MESSAGE, null, playlistNames,

						playlistNames[0]);

				if (selectedPlaylist != null && selectedPlaylist.length() > 0) {

					System.out.println("Playlist aukeratua: " + selectedPlaylist + " " + idAudioLike);

					try {

						PlaylistDao.InsertAbestiPlaylist(selectedPlaylist, idAudioLike);

					} catch (SQLException e1) {

						e1.printStackTrace();

					}

				}

			}

		});

		btnMenu.setBounds(252, 366, 89, 23);

		contentPane.add(btnMenu);

		JButton btnPlay = new JButton("Pause");

		btnPlay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				idAudioLike = abestiak.get(Player.indizea).getId();

				player.play();

				if (btnPlay.getText().equals("Play")) {

					btnPlay.setText("Pause");

				} else if (btnPlay.getText().equals("Pause")) {

					btnPlay.setText("Play");

				}

			}

		});

		btnPlay.setBounds(450, 366, 89, 23);

		contentPane.add(btnPlay);

		btnAbestiAtzera = new JButton("<");

		btnAbestiAtzera.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					player.aurreko(lblInfo, lblIrudi, abestiak);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

				System.out.println(Player.indizea + " indice del boton (no dentro de anuncio)");

				if (bz.getMota().equals("free")) {

					player.murrizketaHasieratu(btnAbestiAurrera, btnAbestiAtzera, bz, abestiak, album);

					player.stop();

					dispose();

				}

			}

		});

		btnAbestiAtzera.setBounds(351, 366, 89, 23);

		contentPane.add(btnAbestiAtzera);

		btnAbestiAurrera = new JButton(">");

		btnAbestiAurrera.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					player.next(lblInfo, lblIrudi, abestiak);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

				if (bz.getMota().equals("free")) {

					player.murrizketaHasieratu(btnAbestiAurrera, btnAbestiAtzera, bz, abestiak, album);

					player.stop();

					dispose();

				}

			}

		});

		btnAbestiAurrera.setBounds(548, 366, 89, 23);

		contentPane.add(btnAbestiAurrera);

		lblDenbora = new JLabel("");

		lblDenbora.setHorizontalAlignment(SwingConstants.CENTER);

		lblDenbora.setBounds(267, 342, 54, 14);

		contentPane.add(lblDenbora);

		timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {

			@Override

			public void run() {

				String denbora = player.denbora();

				if (denbora != null) {

					lblDenbora.setText(denbora.toString());

				}

			}

		}, 0, 1000);

	}

}