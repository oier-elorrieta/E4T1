package Testak.Dao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.AlbestiDao;
import DatuBasea.Konexioa;
import Modelo.Abesti;
import Modelo.Audio.Mota;

public class AlbumDaoTest {
	private static List<Abesti> abestiakTest = new ArrayList<Abesti>();

	public static List<Abesti> albumarenAbestiakTest(String album) {
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
							abestiakTest.add(abesti);
						}

						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abestiakTest;

	}
	@Test
	public void testAlbumarenAbestiak() {
	    List<Abesti> abestiak = AlbestiDao.albumarenAbestiak("Aurrera");
	    		
	    		
	    abestiakTest = albumarenAbestiakTest("Aurrera");
	    
	    assertNotNull(abestiakTest);
	    assertFalse(abestiakTest.isEmpty());
	    for(int i = 0; i < abestiak.size() ; i ++) {
	    System.out.println(abestiak.get(i).toString());
	    System.out.println(abestiakTest.get(i).toString());
	    }
	    for (int i = 0; i < abestiakTest.size(); i++) {
	    	//Hay que mirar como testear las fotos.
	    	// se testea cada atributo por que las fotos salta el equals
	    	// creo que hay que convertirlo a string y compararlos en el equals
	    	assertEquals(abestiakTest.get(i).getId(), abestiak.get(i).getId());
	    	assertEquals(abestiakTest.get(i).getMota(), abestiak.get(i).getMota());
//	    	assertEquals(abestiakTest.get(i).getIrudia(), abestiak.get(i).getIrudia());
	    	assertEquals(abestiakTest.get(i).getAbestiIzena(), abestiak.get(i).getAbestiIzena());
	    	assertEquals(abestiakTest.get(i).getIraupena(), abestiak.get(i).getIraupena());
	    	assertEquals(abestiakTest.get(i).getKolaboratzaile(), abestiak.get(i).getKolaboratzaile());
	    }
	    // lortuAreatoakTEST() metodoaren emaitzak eta AbeslariDao-rena berdina direla egiaztatu.
	}
}
