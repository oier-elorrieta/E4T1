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

import DatuBasea.AlbumDao;
import DatuBasea.Konexioa;
import Modelo.Abesti;
import Modelo.Audio.Mota;

public class AlbumDaoTest {
	@Test
	public void testAlbumarenAbestiak() {
	    List<Abesti> abestiak = AlbumDao.albumarenAbestiak("Aurrera");
	    		
	    
	    assertNotNull(abestiak);
	    assertFalse(abestiak.isEmpty());
	    
	    System.out.println(abestiak.get(0).toString());
	   
	    	assertEquals(abestiak.get(0).getId(),"XIAU3");
	    	assertEquals(abestiak.get(0).getid_abesti(), "XIAU3");
	    	assertEquals(abestiak.get(0).getMota(), Mota.abestia);
	    	assertEquals(abestiak.get(0).getAbestiIzena(), "Azken Rokanrola");
	    	assertEquals(abestiak.get(0).getIraupena(), abestiak.get(0).getIraupena());
	    	assertEquals(abestiak.get(0).getKolaboratzaile(), null);
	    
	}
}
