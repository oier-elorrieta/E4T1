package funtzioak;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class Player {
    private static List<File> abestiak = new ArrayList<>();
    private static int indizea = 0; // abestiaren indizea hasieratu
    private static Clip klipa;

    public Player() {
        File karpeta = new File("src/media/wav");
        File[] fitxategiak = karpeta.listFiles();
        if (fitxategiak != null) {
            for (File fitxategia : fitxategiak) {
                if (fitxategia.isFile()) {
                    abestiak.add(fitxategia);
                }
            }
        }
    }

    public void aurreko() {
        if (indizea > 0) {
            indizea--;
            pause();
            play();
        } else {
            System.out.println("Ez dago aurreko abestirik eskuragarri.");
        } 
    }

    public void next() {
        if (indizea < abestiak.size() - 1) {
            indizea++;
            pause();
            play();
        } else {
            System.out.println("Ez dago hurrengo abestirik eskuragarri.");
        }
    }

    public void play() {
        File unekoAbestia = abestiak.get(indizea);
        if (klipa != null && klipa.isRunning()) {
            pause();
            
        }else { 
        	try {
        		
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(unekoAbestia);
            AudioFormat formatua = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, formatua);
            klipa = (Clip) AudioSystem.getLine(info);
            klipa.open(audioStream);
            klipa.start();
            System.out.println("Orain erreproduzitzen: " + unekoAbestia.getName());
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        }
                
    }

    public void pause() {
        if (klipa != null && klipa.isRunning()) {
            klipa.stop();
            System.out.println("Abestia pausatuta: " + abestiak.get(indizea).getName());
        } else {
            System.out.println("Ez dago abestirik erreproduzitzen.");
        }
    }

}