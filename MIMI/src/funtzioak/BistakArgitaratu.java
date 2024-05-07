package funtzioak;

import java.util.List;

import Bista.AlbumBista;
import Bista.ArtistaBista;
import Bista.ErregistroBista;
import Bista.ErreproduktoreaBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
import Bista.PlaylistBista;
import Bista.PodcastDeskubrituBista;
import Bista.PodcastErreproduktoreBista;
import Bista.PodcasterBista;
import Bista.ProfilaBista;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import Modelo.Podcast;
import Modelo.Podcaster;

public class BistakArgitaratu {

	/**
	 * Metodo honek Login bistara eramaten gaitu.
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
	 * Metodo honek Erregistro bistara eramaten gaitu.
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
	 * Metodo honek Menu bistara eramaten gaitu.
	 */
	public static void MenuJoan(Bezero bz) {

		try {
			MenuaBista frame = new MenuaBista(bz);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Metodo honek MusikaDeskubritu bistara eramaten gaitu.
	 */
	public static void MusikaDeskubrituJoan(Bezero bz) {
		try {
			MusikaDeskubrituBista frame = new MusikaDeskubrituBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek ArtistaBista bistara eramaten gaitu.
	 * @param artistaIzena Artista izena
	 * @param albumak Albumen lista
	 * @param bz Bezero objektua
	 */
	public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, Bezero bz) {
		try {
			ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek PodcastDeskubritu bistara eramaten gaitu.
	 */
	public static void PodcastDeskubrituJoan(Bezero bz) {
		try {
			PodcastDeskubrituBista frame = new PodcastDeskubrituBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek PodcasterBista bistara eramaten gaitu.
	 * @param podcaster Podcaster objektua
	 * @param bz Bezero objektua
	 */
	public static void PodcasterBistaJoan(Podcaster podcaster, Bezero bz) {
		try {
			PodcasterBista frame = new PodcasterBista(podcaster, bz);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek ProfilaBista bistara eramaten gaitu.
	 * @param bz Bezero objektua
	 */
	public static void ProfilaBistaJoan(Bezero bz) {
		try {
			ProfilaBista frame = new ProfilaBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek AlbumBista bistara eramaten gaitu.
	 * @param bz Bezero objektua
	 * @param album Album objektua
	 */
	public static void AlbumBistaJoan(Bezero bz, Album album) {
		try {
			AlbumBista frame = new AlbumBista(bz,album);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek ErreproduktoreaBista bistara eramaten gaitu.
	 * @param bz Bezero objektua
	 * @param selectedValue Hautatutako balioa
	 * @param abestiak Abestiak lista
	 * @param album Album objektua
	 */
	public static void ErreproduktoreaBistaJoan(Bezero bz, int selectedValue, List<Abesti> abestiak, Album album) {
		try {
			ErreproduktoreaBista frame = new ErreproduktoreaBista(bz, selectedValue, abestiak, album);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek PlaylistBista bistara eramaten gaitu.
	 * @param bz Bezero objektua
	 */
	public static void PlaylistBistaraJoan(Bezero bz) {
		try {
			PlaylistBista frame = new PlaylistBista(bz);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo honek PodcastErreproduktoreBista bistara eramaten gaitu.
	 * @param bz Bezero objektua
	 * @param podcast Podcast objektua
	 * @param podcastak Podcast-en lista
	 */
	public static void PodcastErreproduktoreraJoan(Bezero bz, Podcast podcast, List<Podcast> podcastak) {
		try {
			PodcastErreproduktoreBista frame = new PodcastErreproduktoreBista(bz, podcast, podcastak);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
