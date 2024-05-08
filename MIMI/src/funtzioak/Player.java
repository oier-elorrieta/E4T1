package funtzioak;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.protobuf.Timestamp;

import Bista.IragarkiBista;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import java.io.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Player {

	private List<File> abestiakPlayer;
	public static int indizea;
	private Clip klipa;

	public Player() {
	}

	public Player(List<Abesti> abestiak, Bezero bz, int index) {

		abestiakPlayer = new ArrayList<>();
		File selectedSong = null;

		for (Abesti abesti : abestiak) {
			String fileName = abesti.getid_abesti();
			File file = new File("src/media/wav/" + fileName + ".wav");
			abestiakPlayer.add(file);
			if (abestiak.indexOf(abesti) == index) {
				selectedSong = file;
			}
		}

		if (!abestiakPlayer.isEmpty() && selectedSong != null) {
			abestiakPlayer.remove(selectedSong);
			abestiakPlayer.add(0, selectedSong);
		} else {
			System.out.println("Error al inicializar la lista de reproducción.");
		}

		if (selectedSong != null) {
			String selectedFileName = selectedSong.getName();
			for (int i = 0; i < abestiak.size(); i++) {
				Abesti abesti = abestiak.get(i);
				String fileName = abesti.getid_abesti() + ".wav";
				if (fileName.equals(selectedFileName)) {
					abestiak.remove(i);
					abestiak.add(0, abesti);
					break;
				}
			}
		}

		try {
			klipa = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		File unekoAbestia = abestiakPlayer.get(indizea);
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

		// Actualizar el índice global Player.indize

	}

	public void aurreko(JLabel lblInfo, JLabel lblIrudi, List<Abesti> abestiak) throws SQLException {
		indizea--;
		if (indizea < 0) {
			indizea = abestiakPlayer.size() - 1;
		}
		stop();
		play();
		ateraArgazkia(lblIrudi, indizea, abestiak);
		ateraInformazioa(lblInfo, indizea, abestiak);
	}

	public void next(JLabel lblInfo, JLabel lblIrudi, List<Abesti> abestiak) throws SQLException {
		indizea++;
		if (indizea >= abestiakPlayer.size()) {
			indizea = 0;
		}
		stop();
		play();
		ateraArgazkia(lblIrudi, indizea, abestiak);
		ateraInformazioa(lblInfo, indizea, abestiak);
	}

	public void pause() {
		if (klipa != null && klipa.isRunning()) {
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
		for (Abesti abesti : abestiak) {
			if (abesti.getid_abesti().equals(filename)) {
				lblIrudi.setIcon(new ImageIcon(abesti.getIrudia().getBytes(1, (int) abesti.getIrudia().length())));
				break;
			}
		}
	}

	public void ateraInformazioa(JLabel lblInfo, int indizea, List<Abesti> abestiak) throws SQLException {
		Abesti a = abestiak.get(indizea);
		String info = "Abesti : " + a.getAbestiIzena() + " / Iraupena : " + a.getIraupena() + " / Kolaboratzaile : ";
		if (a.getKolaboratzaile() == null) {
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

	public void murrizketaHasieratu(JButton btnAbestiAurrera, JButton btnAbestiAtzera, Bezero bz, List<Abesti> abestiak,
			Album album) {
		try {
			IragarkiBista frame = new IragarkiBista(bz, abestiak, album);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Timer timer = new Timer();

		TimerTask timerTaskDisable = new TimerTask() {
			@Override
			public void run() {
				btnAbestiAurrera.setEnabled(false);
				btnAbestiAtzera.setEnabled(false);
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				btnAbestiAurrera.setEnabled(true);
				btnAbestiAtzera.setEnabled(true);
			}
		};

		timer.schedule(timerTaskDisable, 0);
	}

	public void iragarkiaHasi() {
		File file = new File("src/media/wav/iragarkia.wav");
		try {
			klipa = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			klipa.open(audioStream);
			klipa.start();
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
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



