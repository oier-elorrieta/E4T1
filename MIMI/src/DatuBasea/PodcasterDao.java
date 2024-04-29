package DatuBasea;



import java.sql.Blob;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import java.util.List;

import Modelo.Abeslari;

import Modelo.Abeslari.Mota;

import Modelo.Album;
import Modelo.Audio;
import Modelo.Podcast;

import Modelo.Podcaster;



public class PodcasterDao {



	public static List<Podcaster> podcakasterAtera() {

		List<Podcaster> podcasterList = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "SELECT * FROM Podcaster";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						Podcaster podcaster = new Podcaster();

						String id = rs.getString("IdPodcaster");

						String izenArtistikoa = rs.getString("IzenArtistikoa");

						Blob irudia = rs.getBlob("Irudia");

						String deskribapena = rs.getString("Deskribapena");

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



	public static List<Podcast> podcastLortu(String podcasterIzena) {

		List<Podcast> podcast = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {



			String kontsulta = "select * from Audio inner join Podcast using(idAudio) inner join Podcaster using (idPodcaster) where IzenArtistikoa = '"

					+ podcasterIzena + "';";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {


						String IdAudio = rs.getString("IdAudio");
						
						String podcast_izena = rs.getString("izena");

						String kolaboratzaileak = rs.getString("Kolaboratzaileak");

						Time iraupena = rs.getTime("Iraupena");;
						
						Blob Irudia = rs.getBlob("Irudia");
						
						
			
					
						Podcast pod = new  Podcast(IdAudio,iraupena, Irudia, Audio.Mota.podcast, IdAudio,podcast_izena, kolaboratzaileak);
					
						
						



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