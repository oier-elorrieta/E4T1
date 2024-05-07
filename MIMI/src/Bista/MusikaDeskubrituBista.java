package Bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatuBasea.AbeslariDao;
import Modelo.Abeslari;
import Modelo.Album;
import Modelo.Bezero;
import funtzioak.BistakArgitaratu;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class MusikaDeskubrituBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static List<Abeslari> musikariak;
	private DefaultListModel<String> model;
	public static String artistaIzena;
    public List<Album> albumak;

	public MusikaDeskubrituBista(Bezero bz) {
		setResizable(false);


		musikariak = AbeslariDao.musikariakAtera();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.NORTH);

		JLabel lblMenua = new JLabel("Musika Deskubritu");
		splitPane.setLeftComponent(lblMenua);
		lblMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenua.setFont(new Font("Monospaced", Font.PLAIN, 60));

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);

		JSplitPane splitPane_1 = new JSplitPane();
		panel.add(splitPane_1);

		JButton btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.MenuJoan(bz);
				dispose();
			}
		});

		btnAtzera.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		splitPane_1.setLeftComponent(btnAtzera);

		JButton btnNewButton = new JButton("PROFILA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BistakArgitaratu.ProfilaBistaJoan(bz);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		splitPane_1.setRightComponent(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JList<String> listMusika = new JList<String>();
		scrollPane.setViewportView(listMusika);

		model = new DefaultListModel<String>();
		for (int i = 0; i < musikariak.size(); i++) {
			model.addElement(musikariak.get(i).getIzena());

		}
		listMusika.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
		
					 artistaIzena = (String) listMusika.getSelectedValue();
					 albumak = AbeslariDao.musikariarenAlbum(artistaIzena);
					 BistakArgitaratu.ArtistaBistaJoan(artistaIzena,albumak,bz);
					 dispose();
	
				}
			}
 
		});
		listMusika.setModel(model);

	}
}
