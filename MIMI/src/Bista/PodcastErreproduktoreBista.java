package Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Bezero;
import Modelo.Podcast;
import funtzioak.BistakArgitaratu;
import funtzioak.PlayerPodcast;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PodcastErreproduktoreBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private PlayerPodcast playerPodcast;

    public PodcastErreproduktoreBista(Bezero bz, int selectedValue, List<Podcast> podcastList) throws SQLException {
		setResizable(false);

        // Player (Klipa hasten du hautatutako abesti zerrendarekin (album / playlist))
        playerPodcast = new PlayerPodcast(bz,selectedValue, podcastList);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1009, 585);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblInfo = new JLabel("");
        lblInfo.setBounds(148, 401, 670, 134);
        contentPane.add(lblInfo);
        
        // Info hasieratu
        playerPodcast.ateraInformazioa(lblInfo, selectedValue, podcastList);
        
        JLabel lblIrudi = new JLabel("");
        lblIrudi.setHorizontalAlignment(SwingConstants.CENTER);
        lblIrudi.setBounds(332, 66, 319, 290);
        contentPane.add(lblIrudi);
        playerPodcast.ateraArgazkia(lblIrudi, selectedValue, podcastList);
        
        JButton btnAtzera = new JButton("ATZERA");
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.pause();
                dispose();
                BistakArgitaratu.MenuJoan(bz);
                
            }
        });
        btnAtzera.setBounds(10, 11, 128, 23);
        contentPane.add(btnAtzera);
        
        JButton btnProfila = new JButton(bz.getErabiltzaile());
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.pause();
                BistakArgitaratu.ProfilaBistaJoan(bz);
                dispose();
            }
        });
        btnProfila.setBounds(855, 11, 128, 23);
        contentPane.add(btnProfila);
        
        JLabel lblNewLabel = new JLabel("Podcast Erreproduktorea");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(148, 15, 697, 39);
        contentPane.add(lblNewLabel);
        
        
        JButton btnMenu = new JButton("Menua");
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.pause();
                BistakArgitaratu.MenuJoan(bz);
                dispose();
            }
        });
        btnMenu.setBounds(252, 366, 89, 23);
        contentPane.add(btnMenu);
        
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.play();
            }
        });
        btnPlay.setBounds(450, 366, 89, 23);
        contentPane.add(btnPlay);
        
        JButton btnAbestiAtzera = new JButton("<");
        btnAbestiAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.aurreko();
                try {
					playerPodcast.ateraInformazioa(lblInfo, playerPodcast.getIndizea(), podcastList);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Llamar a ateraInformazioa nuevamente
            }
        });
        btnAbestiAtzera.setBounds(351, 366, 89, 23);
        contentPane.add(btnAbestiAtzera);
        
        JButton btnAbestiAurrera = new JButton(">");
        btnAbestiAurrera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerPodcast.next();
                try {
					playerPodcast.ateraInformazioa(lblInfo, playerPodcast.getIndizea(), podcastList);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Llamar a ateraInformazioa nuevamente
            }
        });
        btnAbestiAurrera.setBounds(548, 366, 89, 23);
        contentPane.add(btnAbestiAurrera);
        
        JButton btnLike = new JButton("x1");
        btnLike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(btnLike.getText()=="x1") {
                    btnLike.setText("x2");
                    
                }else if(btnLike.getText()=="x2") {
                    btnLike.setText("x0.5");
                }else {
                    btnLike.setText("x1");
                }
            }
        });
        btnLike.setBounds(647, 366, 76, 23);
        contentPane.add(btnLike);
    }
}
