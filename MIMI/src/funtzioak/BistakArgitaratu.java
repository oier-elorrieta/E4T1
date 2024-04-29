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
import Modelo.Bezero;
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
	public static void MenuJoan(Bezero bz) {

		try {
			MenuaBista frame = new MenuaBista(bz);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void MusikaDeskubrituJoan(Bezero bz) {
		try {
			MusikaDeskubrituBista frame = new MusikaDeskubrituBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, Bezero bz) {
		try { 
			ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcastDeskubrituJoan(Bezero bz) {
		try { 
			PodcastDeskubrituBista frame = new PodcastDeskubrituBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PodcasterBistaJoan(String artistaIzena, List<Podcast> podcast, Bezero bz) {
		try { 
			PodcasterBista frame = new PodcasterBista(artistaIzena,podcast, bz);
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ProfilaBistaJoan(Bezero bz) {
		try {
			ProfilaBista frame = new ProfilaBista(bz);
			frame.setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
