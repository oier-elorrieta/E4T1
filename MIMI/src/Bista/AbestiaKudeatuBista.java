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
import DatuBasea.AbeslariDao;
import DatuBasea.AbestiaKudeatuDao;
import Modelo.Abeslari;
import Modelo.Abesti;
import funtzioak.BistakArgitaratu;

public class AbestiaKudeatuBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEzabatu;
	private JButton btnEditatu;
	private JButton btnSartu;
	private List<Abesti> abestiak = new ArrayList<>();
	private List<Abeslari> musikariak = new ArrayList<>();
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

		DefaultListModel<String> playlistModel = new DefaultListModel<String>();
		for (int i = 0; i < abestiak.size(); i++) {
			playlistModel.addElement(abestiak.get(i).getAbestiIzena());
		}
		
		listAbestiak.setModel(playlistModel);
		
		btnSartu = new JButton("Berria sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbestiaSortu(playlistModel,listAbestiak,musikariak,abestiak);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSartu.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSartu.setEnabled(true);
		btnSartu.setBounds(730, 229, 240, 41);
		contentPane.add(btnSartu);
   

		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setEnabled(false);
		btnEzabatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listAbestiak.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu ezabatzeko");
				} else {
					AbestiaKudeatuDao.ezabatuAbestia(listAbestiak.getSelectedIndex(), abestiak);

					// Berriro lortu PlayList zerrenda
			
					// Modeloa ezabatu
					playlistModel.clear();

					// Berriro kargatu modeloa
					for (int i = 0; i < abestiak.size(); i++) {
						playlistModel.addElement(abestiak.get(i).getAbestiIzena());
					}

					// Birkargatu Lista Modelo berriarekin
					listAbestiak.setModel(playlistModel);

					btnEzabatu.setEnabled(false);

				}
			}
		});
		btnEzabatu.setBounds(730, 148, 240, 41);
		contentPane.add(btnEzabatu);
		

		btnEditatu = new JButton("Editatu");
		btnEditatu.setFont(new Font("Source Sans Pro Light", Font.PLAIN, 17));
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		btnEditatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnEditatu);
		btnEzabatu.setEnabled(false);
		btnEditatu.setEnabled(false);
		
		

		btnEditatu.setBounds(730, 312, 240, 41);
		contentPane.add(btnEditatu);
		btnEzabatu.setEnabled(false);
		btnEditatu.setEnabled(false);
		
		musikariak = AbeslariDao.musikariakAtera();
		
		
	}
	
	public static void AbestiaSortu(DefaultListModel<String> playlistModel, JList<String> listAbestiak, List<Abeslari> musikariak, List<Abesti> abestiak) throws SQLException {
		String AbestiaIzenBerri = JOptionPane.showInputDialog("Ze izen jarri nahi diozu?");
		
		String[] musikariIzena = new String[musikariak.size()];
		for (int i = 0; i < musikariak.size(); i++) {
			musikariIzena[i] = musikariak.get(i).getIzena();

		}

		String selectedArtista = (String) JOptionPane.showInputDialog(null,
				"Aukeratu Artista", "Aukeratu Artista", JOptionPane.QUESTION_MESSAGE, null,
				musikariIzena, musikariIzena[0]);

		if (selectedArtista != null && selectedArtista.length() > 0) {
			if (AbestiaKudeatuDao.AbestiaBegiratuDagoen(AbestiaIzenBerri, selectedArtista) == true) {
				JOptionPane.showMessageDialog(null, "Abesti ahu badago");
			}else {
				AbestiaKudeatuDao.SortuAbestia(selectedArtista,AbestiaIzenBerri);
			abestiak = AbestiaKudeatuDao.AbestiakAtera();

		// Limpiar el modelo actual
			playlistModel.clear();

		// Agregar las playlists actualizadas al modelo
		for (int i = 0; i < abestiak.size(); i++) {
			playlistModel.addElement(abestiak.get(i).getAbestiIzena());
		}

		// Actualizar la lista JList con el nuevo modelo
		listAbestiak.setModel(playlistModel);
	}
		}

	}
}