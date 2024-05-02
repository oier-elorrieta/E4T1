package Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AlbumDao;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import funtzioak.BistakArgitaratu;

import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AlbumBista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> model;
    private List<Abesti> abestiak;

    public AlbumBista(Bezero bz, Album album) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 775, 633);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        abestiak = AlbumDao.albumarenAbestiak(album.getIzenburua());
        Abesti abesti = abestiak.get(0); 

        JList<String> listMusika = new JList<String>();
        listMusika.setBackground(SystemColor.controlLtHighlight);
        listMusika.setFont(new Font("Tahoma", Font.PLAIN, 15));
        listMusika.setBounds(22, 53, 332, 164);
        contentPane.add(listMusika);

        model = new DefaultListModel<String>();
        for (Abesti abestia : abestiak) {
            model.addElement(abestia.getAbestiIzena() + " - " + abestia.getIraupena());
        }
        listMusika.setModel(model);

        listMusika.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = listMusika.getSelectedValue();
                    String abestiIzena = splitIzena(selectedValue);
                    Abesti selectedAbesti = null;
                    for (Abesti abesti : abestiak) {
                        if (abesti.getAbestiIzena().equals(abestiIzena)) {
                            selectedAbesti = abesti;
                            break;
                        }
                    }
                    if (selectedAbesti != null) {
                        BistakArgitaratu.ErreproduktoreaBistaJoan(bz, selectedAbesti, abestiak, album);
                        dispose();
                    } else {
                        System.out.println("Abestiaren izena ez da aurkitu.");
                    }
                }
            }
        });

        JLabel lblIrudia = new JLabel("");
        lblIrudia.setBounds(20, 235, 332, 332);
        lblIrudia.setIcon(new ImageIcon(abesti.getIrudia().getBytes(1, (int) abesti.getIrudia().length())));
        contentPane.add(lblIrudia);

        JTextPane deskribapenaTextPane = new JTextPane();
        deskribapenaTextPane.setBackground(SystemColor.control);
        deskribapenaTextPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deskribapenaTextPane.setEditable(false);
        deskribapenaTextPane.setText("Kolaboratzaileak: " + album.getKolaboratzaileak() + "\nArgitaratze Data: "
                + album.getArgitaratzea() + "\nKanta kopurua: " + abestiak.size() + "\nIraupena: "
                + album.getAlbumIraupena());
        deskribapenaTextPane.setBounds(398, 53, 332, 514);
        contentPane.add(deskribapenaTextPane);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BistakArgitaratu.MenuJoan(bz);
                dispose();
            }
        });
        btnAtzera.setBounds(10, 11, 132, 23);
        contentPane.add(btnAtzera);

        JButton btnPerfil = new JButton(bz.getErabiltzaile());
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BistakArgitaratu.ProfilaBistaJoan(bz);
                dispose();
            }
        });
        btnPerfil.setBounds(572, 11, 177, 23);
        contentPane.add(btnPerfil);

        JLabel lblTitulua = new JLabel(album.getIzenburua());
        lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulua.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulua.setBounds(147, 11, 415, 33);
        contentPane.add(lblTitulua);
    }

    public String splitIzena(String izena) {
        String izenaSplit = "";
        String[] splitKatea = izena.split(" - ");
        if (splitKatea.length >= 1) {
            izenaSplit = splitKatea[0];
            System.out.println("Abestiaren izena: " + izenaSplit);
        } else {
            System.out.println("Txarto");
        }
        return izenaSplit;
    }
}