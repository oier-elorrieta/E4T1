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

import DatuBasea.AlbumDao;
import DatuBasea.Konexioa;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Audio.Mota;
import funtzioak.DateFuntzioak;

public class AlbumDaoTest {
	@Test
	public void testAlbumarenAbestiak() {
	    List<Abesti> abestiak = AlbumDao.albumarenAbestiak("Aurrera");
	    		
	    
	    assertNotNull(abestiak);
	    assertFalse(abestiak.isEmpty());
	    
	    Time iraupena = new Time(00,02,46);
	   
	    	assertEquals(abestiak.get(0).getId(),"XIAU3");
	    	assertEquals(abestiak.get(0).getid_abesti(), "XIAU3");
	    	assertEquals(abestiak.get(0).getMota(), Mota.abestia);
	    	assertEquals(abestiak.get(0).getAbestiIzena(), "Azken Rokanrola");
	    	assertEquals(abestiak.get(0).getIraupena(), iraupena);
	    	assertEquals(abestiak.get(0).getKolaboratzaile(), null);
	    
	}
	
	@Test
	public void testlortuAlbumaIdAudio() {
	    Date data = new Date(2021-01-01);
	    String idAudio = "XIAU3";
	    Album album = AlbumDao.lortuAlbumaIdAudio(idAudio);

	    assertNotNull(album);
	    assertEquals(album.getId(), "XIAl2");
	    assertEquals(album.getIzenburua(), "Aurrera");
	    assertEquals((album.getArgitaratzea()),DateFuntzioak.StringtoDate("2021-01-01")); 
	    assertEquals(album.getGeneroa(), "Rock");
	    assertEquals(album.getIdMusikaria(), "XII01");
	    assertEquals(album.getKolaboratzaileak(), null);
	}

	
}
