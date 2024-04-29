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
	public static void MenuJoan(String BezeroErabil) {

		try {
			MenuaBista frame = new MenuaBista(BezeroErabil);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void MusikaDeskubrituJoan(String BezeroErabil) {
		try {
			MusikaDeskubrituBista frame = new MusikaDeskubrituBista(BezeroErabil);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, String BezeroErabil) {
		try { 
			ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, BezeroErabil);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcastDeskubrituJoan(String BezeroErabil) {
		try { 
			PodcastDeskubrituBista frame = new PodcastDeskubrituBista(BezeroErabil);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcasterBistaJoan(String artistaIzena, List<Podcast> podcast, String BezeroErabil) {
		try { 
			PodcasterBista frame = new PodcasterBista(artistaIzena,podcast, BezeroErabil);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
