package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AbeslariDao;
import DatuBasea.NirePlaylistDao;
import Modelo.Bezero;
import Modelo.Playlist;
import funtzioak.BistakArgitaratu;
import funtzioak.PlaylistFuntzioak;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PlaylistAbestiakBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ArrayList<String> abeslaria = new ArrayList<>();
	private JButton btnEzabatu;
	private JButton btnExportatu;
	private JButton btnSartu;
    /**
     * Create the frame.
     */
    public PlaylistAbestiakBista(Bezero bz, Playlist playlist) {
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
                BistakArgitaratu.NirePlaylistBistaraJoan(bz);
                dispose();
            }
        });
        btnAtzera.setBounds(10, 11, 89, 23);
        contentPane.add(btnAtzera);
        
        JLabel lblTitle = new JLabel("");
        lblTitle.setFont(new Font("Monospaced", Font.PLAIN, 60));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(119, 11, 759, 55);
        contentPane.add(lblTitle);
        
        JButton btnProfila = new JButton(bz.getErabiltzaile());
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BistakArgitaratu.ProfilaBistaJoan(bz);
            }
        });
        btnProfila.setBounds(895, 11, 89, 23);
        contentPane.add(btnProfila);
        
        Playlist lista = NirePlaylistDao.AteraPlaylistAbestiak(playlist);
        int erreprodukzioak = NirePlaylistDao.ErreprodukzioakAtera(playlist);
         abeslaria = AbeslariDao.AbeslariaAteraPlayList(playlist);
        
        JList<String> listAbestiPlaylist = new JList<String>();
        listAbestiPlaylist.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				if (listAbestiPlaylist.getSelectedIndex() >= 0) {
					btnEzabatu.setEnabled(true);
					btnExportatu.setEnabled(true);
				}
			}
		}
	});
        listAbestiPlaylist.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
        listAbestiPlaylist.setBounds(10, 58, 682, 379);
		contentPane.add(listAbestiPlaylist);

		DefaultListModel<String> playlistModel = new DefaultListModel<String>();
		for (int i = 0; i < lista.getAbestiList().size(); i++) {
			playlistModel.addElement(lista.getAbestiList().get(i).getAbestiIzena() + " - "+ erreprodukzioak + " - " + abeslaria.get(i) + " - " + lista.getAbestiList().get(i).getIraupena());
		}
		listAbestiPlaylist.setModel(playlistModel);
   

		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setEnabled(false);
		btnEzabatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAbestiPlaylist.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu ezabatzeko");
				} else {
					NirePlaylistDao.ezabatuAbestiaPlayList(listAbestiPlaylist.getSelectedIndex(), lista);

					// Berriro lortu PlayList zerrenda
					 Playlist lista = NirePlaylistDao.AteraPlaylistAbestiak(playlist);
				        int erreprodukzioak = NirePlaylistDao.ErreprodukzioakAtera(playlist);
				         abeslaria = AbeslariDao.AbeslariaAteraPlayList(playlist);

					// Modeloa ezabatu
					playlistModel.clear();

					// Berriro kargatu modeloa
					for (int i = 0; i < lista.getAbestiList().size(); i++) {
						playlistModel.addElement(lista.getAbestiList().get(i).getAbestiIzena() + " - "+ erreprodukzioak + " - " + abeslaria.get(i) + " - " + lista.getAbestiList().get(i).getIraupena());
					}

					// Birkargatu Lista Modelo berriarekin
					listAbestiPlaylist.setModel(playlistModel);

					btnEzabatu.setEnabled(false);

				}
			}
		});
		btnEzabatu.setBounds(730, 148, 240, 41);
		contentPane.add(btnEzabatu);
		

		btnExportatu = new JButton("Kompartitu");
		btnExportatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnExportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlaylistFuntzioak.AbestiakExportatu(lista, erreprodukzioak, abeslaria, listAbestiPlaylist.getSelectedIndex());

			}
		});

		btnExportatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnExportatu);
		btnEzabatu.setEnabled(false);
		btnExportatu.setEnabled(false);
		
		btnSartu = new JButton("Erreprodukzitu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSartu.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSartu.setEnabled(false);
		btnSartu.setBounds(730, 229, 240, 41);
		contentPane.add(btnSartu);

		btnExportatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnExportatu);
		btnEzabatu.setEnabled(false);
		btnExportatu.setEnabled(false);
		btnSartu.setEnabled(false);

	}

	}
		
	