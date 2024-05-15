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
import Modelo.Playlist;

public class AbeslariDao {

	public static List<Abeslari> musikariakAtera() {
		List<Abeslari> musikariak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM musikaria";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Abeslari abeslari = new Abeslari();
						String id = rs.getString("idmusikaria");
						String izenArtistikoa = rs.getString("izenartistikoa");
						Blob irudia = rs.getBlob("irudia");
						String deskribapena = rs.getString("deskribapena");
						String Ezaugarria = rs.getString("ezaugarria");
						abeslari.setId(id);
						abeslari.setIzena(izenArtistikoa);
						if (Ezaugarria.equals("bakarlaria")) {
							abeslari.setMota(Mota.Bakarlari);
						} else {
							abeslari.setMota(Mota.Taldea);
						}
						;
						abeslari.setInfo(deskribapena);
						abeslari.setIrudia(irudia);
						musikariak.add(abeslari);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return musikariak;
	}

	public static List<Album> musikariarenAlbum(String artistaIzena) {
		List<Album> albumak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "SELECT * FROM album inner join musikaria USING (idmusikaria) WHERE idmusikaria = (SELECT idmusikaria from musikaria WHERE izenartistikoa like '"
					+ artistaIzena + "');";
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
						

					
						Album album = new Album(id,izenburua,argitaratzea,0, generoa, idmusikaria, kolaboratzaileak, albumIraupena);

						albumak.add(album);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return albumak;

	}
	
	public static  ArrayList<String> AbeslariaAteraPlayList (Playlist playlist) {
		
		ArrayList<String> abeslaria = new ArrayList<>();
		
		String ab = "";
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select izenartistikoa FROM musikaria inner join album using (idmusikaria) inner join abestia USING(idalbum) inner join audio USING (idaudio) INNER join playlist_abestiak USING (idaudio) inner join playlist USING (idlist) where idlist ='" + playlist.getId() + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						
						ab = rs.getString("izenartistikoa");
						
						abeslaria.add(ab);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abeslaria;
	
	
	}
}
