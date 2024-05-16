package Bista;

import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AbeslariDao;
import DatuBasea.AbestiaKudeatuDao;
import DatuBasea.KudeatuArtistaDao;
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
		
		JList<String> listMusikaria = new JList<String>();
		listMusikaria.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(listMusikaria);

		DefaultListModel<String> playlistModel = new DefaultListModel<String>();
		for (int i = 0; i < abestiak.size(); i++) {
			playlistModel.addElement(abestiak.get(i).getAbestiIzena());
		}
		
		listMusikaria.setModel(playlistModel);
		
		btnSartu = new JButton("Berria sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				if (listMusikaria.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu ezabatzeko");
				} else {
					AbestiaKudeatuDao.ezabatuAbestia(listMusikaria.getSelectedIndex(), abestiak);

					// Berriro lortu PlayList zerrenda
			
					// Modeloa ezabatu
					playlistModel.clear();

					// Berriro kargatu modeloa
					for (int i = 0; i < abestiak.size(); i++) {
						playlistModel.addElement(abestiak.get(i).getAbestiIzena());
					}

					// Birkargatu Lista Modelo berriarekin
					listMusikaria.setModel(playlistModel);

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
		
		
	}
	
	public static void ArtistaSortu(DefaultListModel<String> playlistModel, JList<String> listmusikaria, List<Abeslari> listak) throws SQLException {
		String ArtistaIzenBerri = JOptionPane.showInputDialog("Ze izen jarri nahi diozu?");
		String textua = "";
		String[] ArtistaMota = new String[2];
		ArtistaMota[0] = "Bakarlaria";
		ArtistaMota[1] = "Taldea";

		String selectedMota = (String) JOptionPane.showInputDialog(null,
				"Aukeratu Mota:", "Aukeratu Mota", JOptionPane.QUESTION_MESSAGE, null,
				ArtistaMota, ArtistaMota[0]);
		
		JTextArea textArea = new JTextArea(10, 30); // 10 filas y 30 columnas
        textArea.setLineWrap(true); // Permitir el ajuste de línea
        textArea.setWrapStyleWord(true); // Ajuste de línea en las palabras
        
        // Encapsular el JTextArea en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Mostrar el JOptionPane con el JScrollPane
        int result = JOptionPane.showConfirmDialog(null, scrollPane, 
                "Ingrese su texto:", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);
        
        // Manejar la respuesta del usuario
        if (result == JOptionPane.OK_OPTION) {
            // Obtener el texto ingresado
             textua = textArea.getText();
        } else {
            // El usuario canceló la operación
            JOptionPane.showMessageDialog(null, "ez duzu ezer idatzi");
        }

		if (selectedMota != null && selectedMota.length() > 0) {
			KudeatuArtistaDao.InsertArtista(textua, ArtistaIzenBerri, selectedMota);
		listak = AbeslariDao.musikariakAtera();

		// Limpiar el modelo actual
		playlistModel.clear();

		// Agregar las playlists actualizadas al modelo
		for (int i = 0; i < listak.size(); i++) {
			playlistModel.addElement(listak.get(i).getIzena());
		}

		// Actualizar la lista JList con el nuevo modelo
		listmusikaria.setModel(playlistModel);
	}

	}
}