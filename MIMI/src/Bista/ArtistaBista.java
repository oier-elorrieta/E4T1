package Bista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.Blob;
import java.sql.SQLException;

import Modelo.Abeslari;
import Modelo.Album;
import funtzioak.AbeslariDao;

public class ArtistaBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public List<Album> albumak;
	private DefaultListModel<String> model;
	private static List<Abeslari> musikariak;

	
    
  
   
	public ArtistaBista(String artistaIzena, List<Album> albumak) throws SQLException {
  
        this.albumak = albumak;
		musikariak = AbeslariDao.musikariakAtera();
		Abeslari abeslari = new Abeslari();

		
		for(int i = 0 ; i < musikariak.size(); i++) {
			if(musikariak.get(i).getIzena().equals(artistaIzena)) {
                abeslari = musikariak.get(i); 
                break;
			}
		} 
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 602, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(5, 5, 65, 23);
        contentPane.add(btnAtzera);
        
        // Hay 
        JButton btnPerfil = new JButton("Erabiltzaile.getIzena()");
        btnPerfil.setBounds(460, 5, 121, 23);
        contentPane.add(btnPerfil);
        
        JLabel lblTitulua = new JLabel("Artista.getIzena()");
        lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulua.setBounds(80, 9, 370, 14);
        contentPane.add(lblTitulua);
             JLabel lblirudia = new JLabel("");
        lblirudia.setVerticalAlignment(SwingConstants.TOP);
        lblirudia.setBounds(5, 50, 576, 427);
        
        Blob blob = abeslari.getIrudia();
        if (blob != null) {
            try {
                byte[] bytes = blob.getBytes(1, (int) blob.length());
                // Convertir los bytes en un ImageIcon
                ImageIcon imageIcon = new ImageIcon(bytes);
                // Establecer el ImageIcon en el JLabel
                lblirudia.setIcon(imageIcon);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
//   if (abeslari.getIrudia() != null) {
//	   System.out.println(abeslari.getIrudia());
//        	 lblirudia.setIcon( new ImageIcon(abeslari.getIrudia().getBytes(1,(int)abeslari.getIrudia().length())));
//     
        
        
//        Blob blob = abeslari.getIrudia();
//        if (blob != null) {
//            try {
//                byte[] bytes = blob.getBytes(1, (int) blob.length());
//                ImageIcon imageIcon = new ImageIcon(bytes);
//                lblirudia.setIcon(imageIcon);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            

			                
//			// Verificar si imageIcon se crea correctamente
//			if (imageIcon != null) {
//			    // Establecer el ImageIcon en el JLabel
//			    lblirudia.setIcon(imageIcon);
//			    System.out.println(abeslari.getIrudia().length());
//			    System.out.println("La imagen se estableció correctamente en el JLabel.");
//			} else{
//			    System.out.println("No se pudo crear el ImageIcon.");
//			}
//        }
         contentPane.add(lblirudia);       
        JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JList<String> listMusika = new JList<String>();
		listMusika.setBounds(5, 50, 276, 168);
        contentPane.add(listMusika);


		model = new DefaultListModel<String>();
		System.out.println(albumak.toString());
		System.out.println(artistaIzena);
		
		for (int i = 0; i < albumak.size(); i++) {
		    model.addElement(artistaIzena + " - " + albumak.get(i).getIzenburua());
		}
		listMusika.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
		

				}
			}

		});
		listMusika.setModel(model);
        
        JTextPane deskribapenaTextPane = new JTextPane();
        deskribapenaTextPane.setText(abeslari.getInfo());
        deskribapenaTextPane.setBounds(300, 50, 276, 276);
        contentPane.add(deskribapenaTextPane);
        
        

 
        
        
    }
	

}
