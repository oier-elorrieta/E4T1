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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ErreproduktoreaBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Player player;
    private int indizea = 0; 
    private JLabel lblIrudi;
    private JLabel lblInfo; 
    private String idAudioLike;
    private ArrayList<Playlist> playlistArray;

    public ErreproduktoreaBista(Bezero bz, int selectedValue, List<Abesti> abestiak, Album album) throws SQLException {
		setResizable(false);

        player = new Player(abestiak, bz, selectedValue);

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
        player.ateraInformazioa(lblInfo, selectedValue, abestiak);
        
        lblIrudi = new JLabel("");
        lblIrudi.setHorizontalAlignment(SwingConstants.CENTER);
        lblIrudi.setBounds(332, 66, 319, 290);
        contentPane.add(lblIrudi);
        
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
        
        player.ateraArgazkia(lblIrudi,indizea,abestiak);
        
        JButton btnMenu = new JButton("Menua");
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		playlistArray = PlaylistDao.PlayListAtera(bz);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            	
            	 idAudioLike = abestiak.get(indizea).getId();
            	 
            	  String[] playlistNames = new String[playlistArray.size()];
                  for (int i = 0; i < playlistArray.size(); i++) {
                      playlistNames[i] = playlistArray.get(i).getIzena();
                      System.out.println(playlistNames[i]);
                      
                  }
                  
                  String selectedPlaylist = (String) JOptionPane.showInputDialog(
                          ErreproduktoreaBista.this,
                          "Aukeratu Playlist:",
                          "Aukeratu Playlist-a",
                          JOptionPane.QUESTION_MESSAGE,
                          null,
                          playlistNames,
                          playlistNames[0]); 

                  if (selectedPlaylist != null && selectedPlaylist.length() > 0) {
                      System.out.println("Playlist aukeratua: " + selectedPlaylist + " " +idAudioLike);
                      PlaylistDao.InsertAbestiPlaylist(selectedPlaylist,idAudioLike);
                  }
        		
            }
        });
        btnMenu.setBounds(252, 366, 89, 23);
        contentPane.add(btnMenu);
        
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                idAudioLike = abestiak.get(indizea).getId();
                player.play();
                if(btnPlay.getText() == "Play") {
                    btnPlay.setText("Pause");
                }else if (btnPlay.getText() == "Pause") {
                    btnPlay.setText("Play");
                }
            }
        });
        btnPlay.setBounds(450, 366, 89, 23);
        contentPane.add(btnPlay);
        
        JButton btnAbestiAtzera = new JButton("<");
        btnAbestiAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   player.aurreko();   
                   try {
                       indizea++;
                       if (indizea >= abestiak.size()) {
                           indizea = 0;
                       }
                       player.ateraArgazkia(lblIrudi, indizea, abestiak);
                       player.ateraInformazioa(lblInfo, indizea, abestiak);
                   } catch (SQLException e1) {
                       e1.printStackTrace();
                   }
               }
        });
        btnAbestiAtzera.setBounds(351, 366, 89, 23);
        contentPane.add(btnAbestiAtzera);
        
        JButton btnAbestiAurrera = new JButton(">");
        btnAbestiAurrera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 player.next();
                 try {
                     indizea++;
                     if (indizea >= abestiak.size()) {
                         indizea = 0;
                     }
                     player.ateraArgazkia(lblIrudi, indizea, abestiak);
                     player.ateraInformazioa(lblInfo, indizea, abestiak);
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }
            }
        });
        btnAbestiAurrera.setBounds(548, 366, 89, 23);
        contentPane.add(btnAbestiAurrera);
        
        JButton btnLike = new JButton("    ❤️");
        btnLike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                idAudioLike = abestiak.get(indizea).getId();
                
                try {
                    gustukoakDao.GutokoInsert(bz, idAudioLike);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                
                
            }
        });
        btnLike.setBounds(647, 366, 76, 23);
        contentPane.add(btnLike);
      
    }
}
