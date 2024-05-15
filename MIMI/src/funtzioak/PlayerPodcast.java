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

import Modelo.Bezero;
import Modelo.Podcast;

public class PlayerPodcast {
	private List<File> podcastListPlayer;
	private int indizea = 0;
	private Clip klipa;

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
			System.out.println("Error al inicializar la lista de reproducción.");
		}

		// Inicializa el Clip
		try {
			klipa = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		File unekoAbestia = podcastListPlayer.get(indizea);
		if (klipa != null) {
			if (klipa.isOpen()) { // Klipa irekita dagoen begiratzen du
				if (klipa.isRunning()) {
					pause();
				} else {
					klipa.start(); // Klipa irekita badago baina geldituta badago, berriro hasten du
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

	public void aurreko() {
		indizea--;
		if (indizea < 0) {
			indizea = podcastListPlayer.size() - 1;
		}
		stop();
		play();
	}

	public void next() {
		indizea++;
		if (indizea >= podcastListPlayer.size()) {
			indizea = 0;
		}
		stop();
		play();
	}

	public void pause() {
		if (klipa != null && klipa.isRunning()) {// Klipa irekita badago eta erreproduzitzen badago, gelditzen du
			klipa.stop();
		} else {
			System.out.println("Ez dago abestirik erreproduzitzen.");
		}
	}

	public void stop() {
		if (klipa != null) {
			klipa.stop();
			klipa.close();
		}
	}

	public void ateraArgazkia(JLabel lblIrudi, int indizea, List<Podcast> podcastak) throws SQLException {
		String filename = kenduWav(podcastListPlayer.get(indizea).getName());
		for (int i = 0; i < podcastak.size(); i++) {
			if (podcastak.get(i).getId_Podcast().equals(filename)) {
				lblIrudi.setIcon(new ImageIcon(
						podcastak.get(i).getIrudia().getBytes(1, (int) podcastak.get(i).getIrudia().length())));
			}
		}
		

	}

	public void ateraInformazioa(JLabel lblInfo, int indizea, List<Podcast> podcastak) throws SQLException {
	    Podcast p = podcastak.get(indizea);
	    
	    String info = "Podcast : " + p.getPodcast_izena() + " / Iraupena : "  + p.getIraupena() + " / Kolaboratzaile : ";
	    System.out.println(p.getKolaboratzaile());
	    if(p.getKolaboratzaile() == null ) {
	        System.out.println("Es null");
	    } else {
	        info += p.getKolaboratzaile();
	    }
	    
	    lblInfo.setText(info);
	}



	public String kenduWav(String filename) {
		String[] tarteak = filename.split("\\.");
		return tarteak[0];
	}

	public void bizkortu() {
		if (klipa != null && klipa.isOpen()) {
			if (klipa.isControlSupported(FloatControl.Type.VOLUME)) {
				FloatControl control = (FloatControl) klipa.getControl(FloatControl.Type.VOLUME);
				if (control != null) {
					// Aumentar la velocidad a x2 (2.0f)
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

	public int getIndizea() {
		return indizea;
	}
	
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
