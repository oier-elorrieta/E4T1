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
    private Clip klipa;

    public Player(List<Abesti> abestiak, int indizea) {
        abestiakPlayer = new ArrayList<>();
        for (Abesti abesti : abestiak) {
            String fileName = abesti.getid_abesti(); // abestiaren id lortu (wav izen berbera)
            File file = new File("src/media/wav/" + fileName + ".wav");
            abestiakPlayer.add(file);
        }
        // klipa hasieratu
        try {
            klipa = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void aurreko(int indizea) {
        if (indizea > 0) {
            indizea--;
        } else {
            // abesti gehiago aurrean ez badaude, zerrendako azkenengo abestia jartzen du
            indizea = abestiakPlayer.size() - 1;
        } 
        stop();
        play(indizea);
    }

    public void next(int indizea, JLabel lblIrudi, Bezero bz) {
    	
    	
    	if(bz.getMota().equals("free")) {
    	IragarkiaAtera(lblIrudi);
    	System.out.println(bz.getMota());
    	}
    	System.out.println("no entra " + bz.getMota());
    	
        if (indizea < abestiakPlayer.size() - 1) {
            indizea++;
            
        } else {
        	// abesti gehiago atzean ez badaude, zerrendako lehenengo abestia jartzen du            
        	indizea = 0;
        }
        stop();
        play(indizea);
    }

    public void play(int indizea) {
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
    
    public  void ateraArgazkia(JLabel lblIrudi, int indizea, List<Abesti> abestiak) throws SQLException {
    
    	 
    	lblIrudi.setIcon(new ImageIcon(abestiak.get(indizea).getIrudia().getBytes(1, (int) abestiak.get(indizea).getIrudia().length())));
    	
    }
    
    public void IragarkiaAtera(JLabel lblIrudi) {
    	
    	 File file = new File("src/media/iragarkia/iragarkia.wav");
    	abestiakPlayer.add(file);
    	
    	lblIrudi.setIcon(new ImageIcon(getClass().getResource("src/media/img/colacao.jpg")));
    	
        try {
            klipa = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
