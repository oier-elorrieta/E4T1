package funtzioak;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

import Modelo.Bezero;
import Modelo.Podcast;

public class playerPodcast {

	public playerPodcast(Bezero bz, List<Podcast> podcastak, int indizea) {
		// TODO Auto-generated constructor stub
		abestiakPlayer = new ArrayList<>();
		for (Podcast podcast : podcastak) {
			String fileName = podcast.getId_Podcast(); // abestiaren id lortu (wav izen berbera)
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
	
	public void PlayerPod(List<Podcast> podcastak, Podcast podcast) {
		abestiakPlayer = new ArrayList<>();
		for (int i = 0; i < podcastak.size(); i++) {
			if (podcast.getId_Podcast().equals(podcastak.get(i).getId_Podcast())) {
				String fileName = podcast.getId_Podcast(); // podcast id lortu (wav izen berbera)
				File file = new File("src/media/wav/" + fileName + ".wav");
				abestiakPlayer.add(file);
				break;
			}
		}
		// klipa hasieratu
		try {
			klipa = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
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
	
}
