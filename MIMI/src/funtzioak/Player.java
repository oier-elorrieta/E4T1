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

/**
 * Player klasea abestiak erreproduzitzeko eta kontrolatzeko erabiltzen da.
 * Klase honek abestiak kargatzen ditu, erreproduzitzen ditu, eta kontrola egiten du (aurrekoa, hurrengoa, pausa, etab.).
 */
public class Player {

    private List<File> abestiakPlayer;
    public static int indizea;
    private Clip klipa;

    public Player() {
    }

    /**
     * Player klasea abestien erreproduziorako erabiltzen da.
     * Abestiak, bezeroa eta indexa jasotzen ditu konstruktorea.
     */
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

    /**
     * Erreproduzitu abestia. Abestia jadanik irekita badago, bertan geratzen den
     * kliparen egoera aztertu eta beharrezko ekintza burutu egiten da (pause edo
     * start). Bestela, abestia ireki eta hasi egiten da erreproduzitzen.
     * 
     * index/indizea: abestiaren posizioa zerrendan.
     */
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


    }

    /**
     * Aurreko abestia erreproduzitzen duen metodoa.
     * 
     * Indizea 0 baino txikiagoa bada, playlistaren azkenengo abestia erreproduzitzen da.
     * 
     * @param lblInfo  Informazioa erakusteko JLabel objektua.
     * @param lblIrudi Irudia erakusteko JLabel objektua.
     * @param abestiak Abestiak gordetzeko List objektua.
     * @throws SQLException SQL errorea gertatzen bada.
     */
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

    /**
     * Indizea size baino handiagoa bada, indizea 0-ra berreskuratzen du. Gero, musika gelditzen da eta berriro erreproduzitzen da.
     * AteraArgazkia eta ateraInformazioa metodoak deitzen dira.
     * Argazkia eta informazioa pantailan erakusten dira.
     * 
     * @param lblInfo informazioa erakusteko JLabel-a
     * @param lblIrudi argazkia erakusteko JLabel-a
     * @param abestiak abestiakPlayer listako abestiak
     * @throws SQLException SQL errore bat gertatzen bada
     */
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

    /**
     * Pausatu metodoa abestia erreproduktzen ari bada.
     * Abestia erreproduktzen ari bada, abestia gelditu egiten da.
     * Abestirik ez badago erreproduktzen, "Ez dago abestirik erreproduzitzen." mezua inprimatzen da.
     */
    public void pause() {
        if (klipa != null && klipa.isRunning()) {
            klipa.stop();
        } else {
            System.out.println("Ez dago abestirik erreproduzitzen.");
        }
    }

    /**
     *
     * Stop metodoa abestia gelditzeko erabiltzen da.
     * 
     * Abestia gelditzen da eta kliparen egoera itzultzen da.
     */
    public void stop() {
        if (klipa != null) {
            klipa.stop();
            klipa.close();
        }
    }

    /**
     * Aukeratutako abestiaren irudia ateratzen du eta JLabel-ean kokatzen du.
     * 
     * KenduWav metodoa deitzen da abestiaren izena lortzeko.
     * 
     * Irudia ateratzeko, abestiaren ID lortu eta abestiaren izena irudiaren izenarekin konparatzen da.
     * 
     * @param lblIrudi JLabel-a, non irudia kokatuko den.
     * @param indizea Abestiaren indizea, aukeratutako abestia aurkitzeko erabiliko den.
     * @param abestiak Abestiak zerrenda, non abestien informazioa gordeta dagoen.
     * @throws SQLException SQL errore bat gertatzen bada.
     */
    public void ateraArgazkia(JLabel lblIrudi, int indizea, List<Abesti> abestiak) throws SQLException {
        String filename = kenduWav(abestiakPlayer.get(indizea).getName());
        for (Abesti abesti : abestiak) {
            if (abesti.getid_abesti().equals(filename)) {
                lblIrudi.setIcon(new ImageIcon(abesti.getIrudia().getBytes(1, (int) abesti.getIrudia().length())));
                break;
            }
        }
    }

    /**
     * Aukeratutako abestiaren informazioa ateratzen duen metodoa.
     * 
     * Abestia, iraupena eta kolaboratzailea erakusten dira.
     * 
     * @param lblInfo    Informazioa erakusteko JLabel komponentea
     * @param indizea    Abestiaren indizea listan
     * @param abestiak    Abestiak gordetzeko lista
     * @throws SQLException    SQL errorea gertatzen bada
     */
    public void ateraInformazioa(JLabel lblInfo, int indizea, List<Abesti> abestiak) throws SQLException {
        Abesti a = abestiak.get(indizea);
        String info = "Abesti : " + a.getAbestiIzena() + " / Iraupena : " + a.getIraupena() + " / Kolaboratzaile : ";
        if (a.getKolaboratzaile() != null) {
            info += a.getKolaboratzaile();
        } else {
            info += "Ez dauka kolaboratzaile.";
        }
        lblInfo.setText(info);
    }

    /**
     * KenduWav metodoa erabiltzen da emandako fitxategiaren izenaren luzapena kendu eta itzultzen du.
     *
     * @param filename fitxategiaren izena
     * @return fitxategiaren izenaren luzapena kendutako stringa
     */
    public String kenduWav(String filename) {
        String[] tarteak = filename.split("\\.");
        return tarteak[0];
    }

    /**
     * Metodo honek murrizketa hasieratzen du, botoiak desgaitzeko eta gero berriro gaitzeko.
     * 
     * TimerTask klasea erabiliz, botoiak desgaitzen dira eta 10 minutu gero berriz gaitzen dira.
     * 
     * Funztio honek bakarrik hasi egingo da, abestiak erreproduzitzen hasi baino lehen eta bezeroa Free planan dagoenean.
     * 
     * @param btnAbestiAurrera Abestiak aurrera mugitzeko botoia
     * @param btnAbestiAtzera Abestiak atzera mugitzeko botoia
     * @param bz Bezero objektua
     * @param abestiak Abestiak zerrenda
     * @param album Album objektua
     */
    public void murrizketaHasieratu(JButton btnAbestiAurrera, JButton btnAbestiAtzera, Bezero bz, List<Abesti> abestiak,
            Album album, String artistaIzena, List<Album> albumak) {
        try {
            IragarkiBista frame = new IragarkiBista(bz, abestiak, album,artistaIzena,albumak);
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

    /**
     * Iragarkia hasieratzen duen metodoa.
     * Metodo honek iragarkiaren soinua jaurtzen du.
     * 
     */
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

    /**
     * Metodo honek, musika kliparen denbora itzultzen du.
     *
     * 
     * 
     * @return musika kliparen denbora formatu honetan: "hh:mm"
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

