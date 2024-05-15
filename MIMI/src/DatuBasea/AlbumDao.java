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

import Modelo.Abesti;
import Modelo.Album;
import Modelo.Audio.Mota;

public class AlbumDao {
	
	public static List<Abesti> albumarenAbestiak(String album) {
		List<Abesti> abestiak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			System.out.println(album);
			String kontsulta = "SELECT * FROM audio inner join abestia USING (idaudio) inner join album USING (idalbum) WHERE izenburua ='" + album + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						Time argitaratzea = rs.getTime("iraupena");
						Blob irudia = rs.getBlob("irudia");
						String mota = rs.getString("mota");
						String idAudio = rs.getString("idaudio");
						String abestiIzena = rs.getString("izena");
						String albumIzena = rs.getString("izenburua");
						String kolaboratzaile = rs.getString("kolaboratzaileak");
						
						if(mota.equals("abestia")) {
							Abesti abesti = new Abesti(idAudio,argitaratzea,irudia,Mota.abestia,idAudio,abestiIzena,albumIzena,kolaboratzaile);
							abestiak.add(abesti);
						}

						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abestiak;

	}
	
	public static Album lortuAlbumaIdAudio(String idAudio) {
		Album album = new Album();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT album.* FROM album INNER JOIN abestia USING (idalbum) WHERE abestia.idaudio = '"
					+ idAudio + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String id = rs.getString("idalbum");
						String izenburua = rs.getString("izenburua");
						Date argitaratzea = rs.getDate("urtea");
						String generoa = rs.getString("generoa");
						String idmusikaria = rs.getString("idmusikaria");
						String kolaboratzaileak = rs.getString("kolaboratzaileak");
						Time albumIraupena = rs.getTime("iraupena");

						album.setAlbumIraupena(albumIraupena);
						album.setArgitaratzea(argitaratzea);
						album.setGeneroa(generoa);
						album.setId(id);
						album.setIdMusikaria(idmusikaria);
						album.setIzenburua(izenburua);
						album.setKolaboratzaileak(kolaboratzaileak);

					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return album;

	}

}