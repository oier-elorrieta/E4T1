package Testak.Dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import DatuBasea.PodcasterDao;
import DatuBasea.gustukoakDao;
import Modelo.Abesti;
import Modelo.Bezero;
import Modelo.Podcast;
import Modelo.Podcaster;

public class GustukoTestDao {

	
	@Test
	public void testGustukoZerrendaIrten() throws SQLException {
		
		Bezero bz1 = new Bezero("BZ002", null, null, null, null, null, null, null, null, null);
		
		String abs1 = "TSAU3";
		
		assertTrue(gustukoakDao.GustukoDelete(bz1, abs1));
		
		
	}
	
	@Test
	public void testGustukoZerrendaSartu() throws SQLException {
		
		Bezero bz1 = new Bezero("BZ002", null, null, null, null, null, null, null, null, null);
		
		String abs1 = "TSAU3";
		
		assertTrue(gustukoakDao.GustukoInsert(bz1,abs1));
		
		gustukoakDao.GustukoDelete(bz1, abs1);
	}
	
	
	@Test
	public void testGustukoZerrendaBegiratu() throws SQLException {
		
		Bezero bz1 = new Bezero("BZ002", null, null, null, null, null, null, null, null, null);
		
		String abs1 = "TSAU3";
		
		String abs2 = "TSAU2";
		
		assertFalse(gustukoakDao.DagoEdoEz(bz1, abs1));
		
		assertTrue(gustukoakDao.DagoEdoEz(bz1,abs2));
	}

	
}
