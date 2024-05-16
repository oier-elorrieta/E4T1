package funtzioak;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.Bezero;
import Modelo.Podcast;

/**
 * PlayerPodcast klasea Iplayer interfazea implementatzen du.
 * Klase honek podcastak erreproduzitzeko funtzionalitateak eskaintzen ditu.
 */
public class PlayerPodcast implements Iplayer {
	private List<File> podcastListPlayer;
	private int indizea = 0;
	private Clip klipa;

	/**
	 * PlayerPodcast klasearen eraikitzailea.
	 * @param bz Bezero objektua
	 * @param selectedValue hautatutako podcastaren indizea
	 * @param podcastak podcasten zerrenda
	 */
	public PlayerPodcast(Bezero bz, int selectedValue, List<Podcast> podcastak) {
		podcastListPlayer = new ArrayList<>();
		File selectedPodcast = null;

		for (Podcast podcast : podcastak) {
			String fileName = podcast.getId_Podcast();
			File file = new File("src/media/wav/" + fileName + ".wav");
			if (podcastak.indexOf(podcast) == selectedValue) {
				selectedPodcast = file;
			} else {
				podcastListPlayer.add(file);
			}
		}

		if (!podcastListPlayer.isEmpty() && selectedPodcast != null) {
			podcastListPlayer.add(0, selectedPodcast);
		} else {
			JOptionPane.showMessageDialog(null, "Ez daude podkast, barkatu", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// Inicializa el Clip
		try {
			klipa = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Erreproduzitu aukeratutako podcasta.
	 */
	public void play() {
		File unekoAbestia = podcastListPlayer.get(indizea);
		if (klipa != null) {
			if (klipa.isOpen()) {
				if (klipa.isRunning()) {
					pause();
				} else {
					klipa.start();
				}
			} else {
				try {
					AudioInputStream audioStream = AudioSystem.getAudioInputStream(unekoAbestia);
					klipa.open(audioStream);
					klipa.start();
				} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Aurreko podcastera joan.
	 */
	public void aurreko() {
		indizea--;
		if (indizea < 0) {
			indizea = podcastListPlayer.size() - 1;
		}
		stop();
		play();
	}

	/**
	 * Hurrengo podcastera joan.
	 */
	public void next() {
		indizea++;
		if (indizea >= podcastListPlayer.size()) {
			indizea = 0;
		}
		stop();
		play();
	}

	/**
	 * Erreproduzitzen ari den podcasta pausatu.
	 */
	public void pause() {
		if (klipa != null && klipa.isRunning()) {
			klipa.stop();
		} else {
			JOptionPane.showMessageDialog(null, "Ez dago abestirik erreproduzitzen.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Erreproduzitzen ari den podcasta gelditu.
	 */
	public void stop() {
		if (klipa != null) {
			klipa.stop();
			klipa.close();
		}
	}

	/**
	 * Aukeratutako podcastaren argazkia ateratu.
	 * @param lblIrudi JLabel objektua argazkiaren bistaratzea
	 * @param indizea aukeratutako podcastaren indizea
	 * @param podcastak podcasten zerrenda
	 * @throws SQLException SQL errorea
	 */
	public void ateraArgazkia(JLabel lblIrudi, int indizea, List<Podcast> podcastak) throws SQLException {
		String filename = kenduWav(podcastListPlayer.get(indizea).getName());
		for (int i = 0; i < podcastak.size(); i++) {
			if (podcastak.get(i).getId_Podcast().equals(filename)) {
				lblIrudi.setIcon(new ImageIcon(
						podcastak.get(i).getIrudia().getBytes(1, (int) podcastak.get(i).getIrudia().length())));
			}
		}
	}

	/**
	 * Aukeratutako podcastaren informazioa ateratu.
	 * @param lblInfo JLabel objektua informazioaren bistaratzea
	 * @param indizea aukeratutako podcastaren indizea
	 * @param podcastak podcasten zerrenda
	 * @throws SQLException SQL errorea
	 */
	public void ateraInformazioa(JLabel lblInfo, int indizea, List<Podcast> podcastak) throws SQLException {
		Podcast p = podcastak.get(indizea);

		String info = "Podcast : " + p.getPodcast_izena() + " / Iraupena : "  + p.getIraupena() + " / Kolaboratzaile : ";
		if(p.getKolaboratzaile() == null ) {
		} else {
			info += p.getKolaboratzaile();
		}

		lblInfo.setText(info);
	}

	/**
	 * Wav formatua kendu fitxategiaren izenetik.
	 * @param filename fitxategiaren izena
	 * @return wav formatua kendutako fitxategiaren izena
	 */
	public String kenduWav(String filename) {
		String[] tarteak = filename.split("\\.");
		return tarteak[0];
	}

	/**
	 * Erreproduzitzen ari den podcastaren abiadura azkartu.
	 */
	public void bizkortu() {
		if (klipa != null && klipa.isOpen()) {
			if (klipa.isControlSupported(FloatControl.Type.VOLUME)) {
				FloatControl control = (FloatControl) klipa.getControl(FloatControl.Type.VOLUME);
				if (control != null) {
					control.setValue(2.0f);
				} else {
					System.out.println("No se puede ajustar la velocidad de reproducción.");
				}
			} else {
				System.out.println("El control de velocidad no es compatible con este clip de audio.");
			}
		} else {
			System.out.println("No hay ningún clip de audio abierto para ajustar la velocidad.");
		}
	}

	/**
	 * Aukeratutako podcastaren indizea itzuli.
	 * @return aukeratutako podcastaren indizea
	 */
	public int getIndizea() {
		return indizea;
	}

	/**
	 * Erreproduzitzen ari den podcastaren denbora itzuli.
	 * @return erreproduzitzen ari den podcastaren denbora
	 */
	public String denbora() {
		long position = klipa.getMicrosecondPosition();
		long duration = klipa.getMicrosecondLength();
		long remaining = duration - position;
		long milliseconds = remaining / 1_000;
		long seconds = milliseconds / 1000;
		long minutes = seconds / 60;
		long remainingSeconds = seconds % 60;
		return String.format("%02d:%02d", minutes, remainingSeconds);
	}
}
