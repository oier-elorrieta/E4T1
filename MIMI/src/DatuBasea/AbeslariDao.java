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

public class AbeslariDao {

	public static List<Abeslari> musikariakAtera() {
		List<Abeslari> musikariak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM Musikaria";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Abeslari abeslari = new Abeslari();
						String id = rs.getString("Idmusikaria");
						String izenArtistikoa = rs.getString("IzenArtistikoa");
						Blob irudia = rs.getBlob("Irudia");
						String deskribapena = rs.getString("Deskribapena");
						String Ezaugarria = rs.getString("Ezaugarria");
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

			String kontsulta = "SELECT * FROM Album inner join Musikaria USING (Idmusikaria) WHERE idMusikaria = (SELECT Idmusikaria from Musikaria WHERE IzenArtistikoa like '"
					+ artistaIzena + "');";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String id = rs.getString("IdAlbum");
						String izenburua = rs.getString("Izenburua");
						Date argitaratzea = rs.getDate("urtea");
						//int AbestiKopurua = rs.getString("Idmusikaria");
						String generoa = rs.getString("generoa");
						String idmusikaria = rs.getString("Idmusikaria");
						String kolaboratzaileak = rs.getString("Kolaboratzaileak");
						

					
						Album album = new Album(id,izenburua,argitaratzea,0, generoa, idmusikaria, kolaboratzaileak);

						albumak.add(album);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return albumak;

	}
}
