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

	public PodcastDeskubrituBista(Bezero bz) {

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
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		splitPane_1.setRightComponent(btnNewButton);

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
					BistakArgitaratu.PodcasterBistaJoan(podcasterIzena, podcastList, bz);
					dispose();
				}
			}

		});
		listPodcast.setModel(model);

	}
}