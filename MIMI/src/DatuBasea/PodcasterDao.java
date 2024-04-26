package DatuBasea;



import java.sql.Blob;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import Modelo.Abeslari;

import Modelo.Abeslari.Mota;

import Modelo.Album;

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



			String kontsulta = "SELECT * FROM Podcast inner join Podcaster USING (IdPodcaster) WHERE IdPodcaster = (SELECT IdPodcaster from Podcaster WHERE IzenArtistikoa like '"

					+ podcasterIzena + "');";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {



						String idAudio = rs.getString("idAudio");

						String kolaboratzaileak = rs.getString("Kolaboratzaileak");

						String idPodcaster = rs.getString("IdPodcaster");

						String deskribapena = rs.getString("Deskribapena");


			
					

						

					 //Podcast podcast = new Podcast(idAudio,kolaboratzaileak,idPodcaster,deskribapena);



					//	albumak.add(album);

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}



		return null;



	}

}