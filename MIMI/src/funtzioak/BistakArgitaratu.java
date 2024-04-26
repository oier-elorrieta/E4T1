package funtzioak;

import java.util.List;

import Bista.ArtistaBista;
import Bista.ErregistroBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
import Bista.PodcastDeskubrituBista;
import Bista.PodcasterBista;
import Modelo.Album;
import Modelo.Podcast;

public class BistakArgitaratu {

	/**
	 * 
	 * Metodo honek Login bistara eramaten gaitu.
	 * 
	 * 
	 */
	public static void loginJoan() {

		try {
			LoginBista frame = new LoginBista();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * 
	 * Metodo honek Erregistro bistara eramaten gaitu.
	 * 
	 * 
	 */
	public static void erregistroraJoan() {

		try {
			ErregistroBista frame = new ErregistroBista();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * Metodo honek Menu bistara eramaten gaitu.
	 * 
	 * 
	 */
	public static void MenuJoan() {

		try {
			MenuaBista frame = new MenuaBista();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void MusikaDeskubrituJoan() {
		try {
			MusikaDeskubrituBista frame = new MusikaDeskubrituBista();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak) {
		try { 
			ArtistaBista frame = new ArtistaBista(artistaIzena, albumak);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcastDeskubrituJoan() {
		try { 
			PodcastDeskubrituBista frame = new PodcastDeskubrituBista();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcasterBistaJoan(String artistaIzena, List<Podcast> podcast) {
		try { 
			PodcasterBista frame = new PodcasterBista(artistaIzena,podcast);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
