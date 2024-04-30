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
			String kontsulta = "SELECT * FROM Audio inner join Abestia USING (IdAudio) inner join Album USING (IdAlbum) WHERE Izenburua ='" + album + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String idAlbum = rs.getString("IdAlbum");
						Time argitaratzea = rs.getTime("Iraupena");
						Blob irudia = rs.getBlob("Irudia");
						String mota = rs.getString("mota");
						String idAudio = rs.getString("IdAudio");
						String abestiIzena = rs.getString("Izena");
						String albumIzena = rs.getString("Izenburua");
						String kolaboratzaile = rs.getString("Kolaboratzaileak");
						
						if(mota.equals("abestia")) {
							Abesti abesti = new Abesti(idAlbum,argitaratzea,irudia,Mota.abestia,idAudio,abestiIzena,albumIzena,kolaboratzaile);
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
}