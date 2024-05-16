package Testak.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.PlaylistDao;
import Modelo.Bezero;
import Modelo.Playlist;
import Salbuespenak.DatubaseErroreaKeyDupe;

public class PlaylistDaoTest {

	@Test
	public void testPlayListAtera() throws SQLException {
		Bezero erabiltzailea = new Bezero();
		erabiltzailea.setId("BZ001");

		List<Playlist> emaitza = PlaylistDao.PlayListAtera(erabiltzailea);

		assertNotNull(emaitza);
		assertFalse(emaitza.isEmpty());
		Playlist lehenengoa = emaitza.get(0);

		assertEquals(lehenengoa.getId(), "PL001");
		assertEquals(lehenengoa.getIzena(), "Rock Hits");
		assertEquals(lehenengoa.getAbestiList(), null);

	}

	@Test
	public void testPlayListInsert() throws SQLException {

		String playlist = "";

		String audio = "";

		assertFalse(PlaylistDao.InsertAbestiPlaylist(playlist, audio));
	}

	@Test
	public void InsertErreprodukzioak() throws SQLException {

		Bezero bz = new Bezero();
		bz.setId("BZ001");
		String idAudio = "ESAU1";

		boolean emaitza = false;
		try {
			emaitza = PlaylistDao.InsertErreprodukzioak(bz, idAudio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatubaseErroreaKeyDupe e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(emaitza);

	}
	
	@Test
	public void InsertErreprodukzioakFalse() throws SQLException {

		Bezero bz = new Bezero();
		bz.setId("BZ001");
		String idAudio = "xx2";

		boolean emaitza = false;
		try {
			emaitza = PlaylistDao.InsertErreprodukzioak(bz, idAudio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatubaseErroreaKeyDupe e) {
			// TODO Auto-generated catch block
			
		}

		assertFalse(emaitza);

	}

}
