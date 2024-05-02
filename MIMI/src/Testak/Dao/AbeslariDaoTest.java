package Testak.Dao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.AbeslariDao;
import DatuBasea.Konexioa;
import Modelo.Abeslari;
import Modelo.Album;
import Modelo.Abeslari.Mota;

public class AbeslariDaoTest {
	// DAO ALDAGAIAK
	private static List<Abeslari> musikariakTest = new ArrayList<Abeslari>();	
	private static List<Album> albumakTest = new ArrayList<Album>();

	

	public static List<Abeslari> musikariakAteraTest() {
		
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
						musikariakTest.add(abeslari);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return musikariakTest;
	}




	@Test
	public void testMusikariakAtera() {
	    // AbeslariDao klasearen bidez musikariak lortzen dira eta listan gorde.
	    List<Abeslari> musikariak = AbeslariDao.musikariakAtera();
	    
	    // musikariakAteraTest() metodoa deitu eta musikariak lortzen dira eta listan gorde.
	    musikariakTest = musikariakAteraTest();
	    
	    // musikariak ez direla nuluek eta hutsik ez daudela egiaztatu.
	    assertNotNull(musikariakTest);
	    assertFalse(musikariakTest.isEmpty());
	    for(int i = 0; i < musikariak.size() ; i ++) {
	    System.out.println(musikariak.get(i).toString());
	    System.out.println(musikariakTest.get(i).toString());
	    }
	    //Salta el equals de todo el objeto a la vez
	    for (int i = 0; i < musikariak.size(); i++) {
	    	assertEquals(musikariak.get(i).getIzena(), musikariakTest.get(i).getIzena());
	    	assertEquals(musikariak.get(i).getId(), musikariakTest.get(i).getId());
	    	assertEquals(musikariak.get(i).getInfo(), musikariakTest.get(i).getInfo());
	    	assertEquals(musikariak.get(i).getMota(), musikariakTest.get(i).getMota());
	    	//assertEquals(musikariak.get(i).getIrudia(), musikariakTest.get(i).getIrudia());

	    }
	    // lortuAreatoakTEST() metodoaren emaitzak eta AbeslariDao-rena berdina direla egiaztatu.
	}
	public static List<Album> musikariarenAlbumTest(String artistaIzena) {
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "SELECT * FROM Album inner join Musikaria USING (Idmusikaria) WHERE idMusikaria = (SELECT Idmusikaria from Musikaria WHERE IzenArtistikoa like '"
					+ artistaIzena + "');";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String id = rs.getString("IdAlbum");
						String izenburua = rs.getString("Izenburua");
						Date argitaratzea = rs.getDate("urtea");
						String generoa = rs.getString("generoa");
						String idmusikaria = rs.getString("Idmusikaria");
						String kolaboratzaileak = rs.getString("Kolaboratzaileak");
						Time albumIraupena = rs.getTime("Iraupena");
						

					
						Album album = new Album(id,izenburua,argitaratzea,0, generoa, idmusikaria, kolaboratzaileak, albumIraupena);

						albumakTest.add(album);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return albumakTest;

	}
	
	@Test
	public void testMusikariarenAlbum() {
	    List<Album> musikariarenAlbum = AbeslariDao.musikariarenAlbum("Estopa");	
	    
	    List<Album> musikariarenAlbumTest = musikariarenAlbumTest("Estopa");
    
	    assertNotNull(musikariarenAlbumTest);
	    assertFalse(musikariarenAlbumTest.isEmpty());
	    for(int i = 0; i < musikariarenAlbum.size() ; i ++) {
	    System.out.println(musikariarenAlbum.get(i).toString());
	    System.out.println(musikariarenAlbumTest.get(i).toString());
	    }
	    for (int i = 0; i < musikariarenAlbumTest.size(); i++) {
	    	assertEquals(musikariarenAlbumTest.get(i), musikariarenAlbum.get(i));
	    }
	}

}