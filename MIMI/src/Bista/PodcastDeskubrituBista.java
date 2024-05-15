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

import DatuBasea.PodcasterDao;
import Modelo.Bezero;
import Modelo.Podcast;
import Modelo.Podcaster;
import funtzioak.BistakArgitaratu;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class PodcastDeskubrituBista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Podcaster> podcasterList;
	private DefaultListModel<String> model;
	private String podcasterIzena;
	public List<Podcast> podcastList;
	public Podcaster podcaster;

	public PodcastDeskubrituBista(Bezero bz) {
		setResizable(false);

		podcasterList = PodcasterDao.podcakasterAtera();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.NORTH);

		JLabel lblMenua = new JLabel("Podcast Deskubritu");
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

		JButton btnProfila = new JButton("PROFILA");
		splitPane_1.setRightComponent(btnProfila);
		btnProfila.setBounds(327, 10, 99, 29);
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BistakArgitaratu.ProfilaBistaJoan(bz);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JList<String> listPodcast = new JList<String>();
		scrollPane.setViewportView(listPodcast);

		model = new DefaultListModel<String>();
		for (int i = 0; i < podcasterList.size(); i++) {
			model.addElement(podcasterList.get(i).getIzena());
			
		}
		listPodcast.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					podcasterIzena = (String) listPodcast.getSelectedValue();
					for (int i = 0; i < podcasterList.size(); i++) {
						if(podcasterIzena.equals(podcasterList.get(i).getIzena())) {
					        podcaster  = podcasterList.get(i);
					        System.out.println(podcaster.toString());
					        BistakArgitaratu.PodcasterBistaJoan(podcaster, bz);
					        dispose();
					   
					        break;
						}
						
					}
					
					
				}
			}

		});
		listPodcast.setModel(model);

	}
}