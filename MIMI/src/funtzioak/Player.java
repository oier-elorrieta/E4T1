package funtzioak;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Modelo.Abesti;
import Modelo.Bezero;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<File> abestiakPlayer;
	private int indizea = 0;
	private Clip klipa;

	public Player(List<Abesti> abestiak, Bezero bz, int selectedValue) {
		abestiakPlayer = new ArrayList<>();
		File selectedSong = null;

		// Añade todas las canciones a la lista de reproducción
		for (Abesti abesti : abestiak) {
			String fileName = abesti.getid_abesti();
			File file = new File("src/media/wav/" + fileName + ".wav");
			if (abestiak.indexOf(abesti) == selectedValue) {
				selectedSong = file; // Guarda la canción seleccionada
			} else {
				abestiakPlayer.add(file); // Agrega las demás canciones a la lista
			}
		}

		// Si la lista de reproducción no está vacía
		if (!abestiakPlayer.isEmpty() && selectedSong != null) {
			// Agrega la canción seleccionada al principio de la lista
			abestiakPlayer.add(0, selectedSong);
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
		File unekoAbestia = abestiakPlayer.get(indizea);
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
			indizea = abestiakPlayer.size() - 1;
		}
		stop();
		play();
	}

	public void next() {
		indizea++;
		if (indizea >= abestiakPlayer.size()) {
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

	public void ateraArgazkia(JLabel lblIrudi, int indizea, List<Abesti> abestiak) throws SQLException {
		String filename = kenduWav(abestiakPlayer.get(indizea).getName());
		for(int i = 0; i < abestiak.size(); i++) {
			if(abestiak.get(i).getid_abesti().equals(filename)) {
				lblIrudi.setIcon(new ImageIcon(
				abestiak.get(i).getIrudia().getBytes(1, (int) abestiak.get(i).getIrudia().length())));
		}
		}


	}
	public void ateraInformazioa(JLabel lblInfo, int indizea, List<Abesti> abestiak) throws SQLException {
		Abesti a = abestiak.get(indizea);
	    
	    String info = "Abesti : " + a.getAbestiIzena() + " / Iraupena : "  + a.getIraupena() + " / Kolaboratzaile : ";
	    System.out.println(a.getKolaboratzaile());
	    if(a.getKolaboratzaile() == null ) {
	        System.out.println("Es null");
	    } else {
	        info += a.getKolaboratzaile();
	    }
	    
	    lblInfo.setText(info);
	}

	public String kenduWav(String filename) {
		String[] tarteak = filename.split("\\.");
		return tarteak[0]; 
	}

}
