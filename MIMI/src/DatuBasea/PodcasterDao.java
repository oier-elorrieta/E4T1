package DatuBasea;

import java.sql.Blob;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import java.util.List;

import Modelo.Audio;
import Modelo.Podcast;

import Modelo.Podcaster;

/**
 * PodcasterDao klasea datu basearekin komunikatzeko erabiltzen den klasea da.
 * Klase honek podcaster-ak eta podcast-ak kudeatzeko metodoak eskaintzen ditu.
 */
public class PodcasterDao {

	/**
	 * Podcakasterak ateratzeko metodoa.
	 *
	 * @return Podcaster-ak duen List objektua.
	 * 
	 *         Datu basean dauden podcaster guztien informazioa lortu eta itzultzen
	 *         du.
	 * 
	 * @throws SQLException SQL errore bat gertatzen bada
	 */
	public static List<Podcaster> podcakasterAtera() {

		List<Podcaster> podcasterList = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "SELECT * FROM podcaster";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						Podcaster podcaster = new Podcaster();

						String id = rs.getString("idpodcaster");

						String izenArtistikoa = rs.getString("izenartistikoa");

						Blob irudia = rs.getBlob("irudia");

						String deskribapena = rs.getString("deskribapena");

						podcaster.setId(id);

						podcaster.setIzena(izenArtistikoa);

						podcaster.setInfo(deskribapena);

						podcaster.setIrudia(irudia);

						podcasterList.add(podcaster);

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return podcasterList;

	}

	/**
	 * Emandako podcaster izenaren arabera podcast-ak lortzen ditu.
	 *
	 * @param podcasterIzena Podcaster izena
	 * @return Podcast lista, emandako podcaster-aren podcast-ekin
	 * 
	 *         Datu basean dauden podcast guztien informazioa lortu eta itzultzen
	 *         du.
	 */
	public static List<Podcast> podcastLortu(String podcasterIzena) {

		List<Podcast> podcast = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select * from audio inner join podcast using(idaudio) inner join podcaster using (idpodcaster) where izenartistikoa = '"

					+ podcasterIzena + "';";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						String IdAudio = rs.getString("idaudio");

						String podcast_izena = rs.getString("izena");

						String kolaboratzaileak = rs.getString("kolaboratzaileak");

						Time iraupena = rs.getTime("iraupena");
						;

						Blob Irudia = rs.getBlob("irudia");

						Podcast pod = new Podcast(IdAudio, iraupena, Irudia, Audio.Mota.podcast, IdAudio, podcast_izena,
								kolaboratzaileak);

						podcast.add(pod);

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return podcast;

	}

}