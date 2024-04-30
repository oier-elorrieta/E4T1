package funtzioak;

import javax.sound.sampled.*;

import Modelo.Abesti;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<File> abestiakPlayer;
    private int indizea = 0; 
    private Clip klipa;

    public Player(List<Abesti> abestiak) {
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

    public void aurreko() {
        if (indizea > 0) {
            indizea--;
        } else {
            // abesti gehiago aurrean ez badaude, zerrendako azkenengo abestia jartzen du
            indizea = abestiakPlayer.size() - 1;
        } 
        stop();
        play();
    }

    public void next() {
        if (indizea < abestiakPlayer.size() - 1) {
            indizea++;
        } else {
        	// abesti gehiago atzean ez badaude, zerrendako lehenengo abestia jartzen du            
        	indizea = 0;
        }
        stop();
        play();
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
}
