package Bista;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import Modelo.Abesti;

import Modelo.Album;

import Modelo.Bezero;

import funtzioak.BistakArgitaratu;

import funtzioak.Player;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.Image;

import javax.swing.SwingConstants;

import javax.swing.JProgressBar;

import javax.swing.Timer;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.List;

public class IragarkiBista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JProgressBar progressBar;

	private Timer timer;

	/**
	 * 
	 * 
	 * 
	 * Create the frame.
	 * 
	 * 
	 * 
	 */

	public IragarkiBista(Bezero bz, List<Abesti> abestiak, Album album, String artistaIzena, List<Album> albumak,
			JButton btnAbestiAurrera, JButton btnAbestiAtzera) {

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1010, 500);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));

		String imagePath = "src/media/img/colacao2.png";

		ImageIcon icon = new ImageIcon(imagePath);

		Image image = icon.getImage();

		Image scaledImage = image.getScaledInstance(800, 400, Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel lblIrudia = new JLabel(scaledIcon);

		contentPane.add(lblIrudia, BorderLayout.CENTER);

		contentPane.add(lblIrudia, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Erosi Premium Iragarkirik Ez Ateratzeko");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 30));

		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		progressBar = new JProgressBar();

		contentPane.add(progressBar, BorderLayout.SOUTH);

		Player player = new Player();

		player.iragarkiaHasi();

		int delay = 1000;

		int duration = 20;

		int maxValue = 100;

		int incrementValue = maxValue * delay / (duration * 1000);

		progressBar.setMaximum(maxValue);

		timer = new Timer(delay, new ActionListener() {

			int currentValue = 0;

			@Override

			public void actionPerformed(ActionEvent e) {

				currentValue += incrementValue;

				progressBar.setValue(currentValue);

				if (currentValue >= maxValue) {

					((Timer) e.getSource()).stop();

					dispose();
					Player.botoiakDesgaitu(btnAbestiAurrera, btnAbestiAtzera);
					BistakArgitaratu.ErreproduktoreaBistaJoan(bz, abestiak, album, Player.indizea, artistaIzena,
							albumak, (Player.iragarkia = true));

				}

			}

		});

		timer.start();

	}

}