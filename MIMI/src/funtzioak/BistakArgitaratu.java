package funtzioak;

import java.util.List;

import Bista.ArtistaBista;
import Bista.ErregistroBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
import Bista.PodcastDeskubrituBista;
import Bista.PodcasterBista;
import Bista.ProfilaBista;
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
	public static void MenuJoan(String erabiltzailea) {

		try {
			MenuaBista frame = new MenuaBista(erabiltzailea);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void MusikaDeskubrituJoan(String erabiltzailea) {
		try {
			MusikaDeskubrituBista frame = new MusikaDeskubrituBista(erabiltzailea);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, String erabiltzailea) {
		try { 
			ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, erabiltzailea);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcastDeskubrituJoan(String erabiltzailea) {
		try { 
			PodcastDeskubrituBista frame = new PodcastDeskubrituBista(erabiltzailea);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcasterBistaJoan(String artistaIzena, List<Podcast> podcast, String erabiltzailea) {
		try { 
			PodcasterBista frame = new PodcasterBista(artistaIzena,podcast, erabiltzailea);
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ProfilaBistaJoan(String erabiltzailea) {
		try {
			ProfilaBista frame = new ProfilaBista(erabiltzailea);
			frame.setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
