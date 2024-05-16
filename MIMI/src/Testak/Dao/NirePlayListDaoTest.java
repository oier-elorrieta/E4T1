package Testak.Dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Modelo.Abesti;
import Modelo.Bezero;
import Modelo.Playlist;
import DatuBasea.NirePlaylistDao;

public class NirePlayListDaoTest {

	@Test
	public void testSortuPlaylist() {
		Bezero bz = new Bezero();
		bz.setId("BZ001");
		String izena = "Rock FM";
		Playlist pl = new Playlist();
		pl.setIzena(izena);

		Playlist plDao = new Playlist();
		try {

			plDao = NirePlaylistDao.sortuPlaylist(bz, izena);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(pl.getIzena(), plDao.getIzena());

	}

	@Test
	public void testnirePlaylistAtera() {
		Bezero bz = new Bezero();
		bz.setId("BZ001");
		List<Playlist> playlistak = new ArrayList<Playlist>();
		playlistak = NirePlaylistDao.nirePlaylistAtera(bz);
		assertEquals(playlistak.get(0).getIzena(), "Rock FM");

	}

	@Test
	public void testLortuAbestiakIdPlaylist() {

		Playlist plDao = new Playlist();
		int abestiKop = 0;
		plDao.setId("PL004");
		NirePlaylistDao.lortuAbestiakIdPlaylist(plDao);
		abestiKop = plDao.getAbestiList().size();
		assertEquals(plDao.getAbestiList().size(), abestiKop);
	}

	@Test
	public void testLortuAbestiListaId() {
		Playlist plDao = new Playlist();
		ArrayList<Abesti> abestiak = new ArrayList<>();
		plDao.setId("PL003");
		abestiak = NirePlaylistDao.lortuAbestiListaId(plDao);
		System.out.println(abestiak.get(0).getAbestiIzena());
		assertEquals(abestiak.get(0).getid_abesti(), "EMAU1");
	}

	@Test
	public void testAbestiakIdExpo() {
		Abesti abesti = new Abesti();
		String id = "EMAU1";
		abesti = NirePlaylistDao.abestiakIdExpo(id);
		assertEquals(abesti.getAbestiIzena(), "Mockingbird");
	}

	@Test
	public void testAbestiakIdExpoNull() {
		Playlist plDao = new Playlist();
		plDao.setId("PL003");
		plDao.setIzena("Party Time");
		plDao = NirePlaylistDao.AteraPlaylistAbestiak(plDao);
		assertTrue(plDao.getAbestiList().size() > 0);
		assertEquals(plDao.getAbestiList().get(0).getAbestiIzena(), "Mockingbird");
		assertEquals(plDao.getAbestiList().get(0).getAlbumIzena(), "Encore");
		assertEquals(plDao.getAbestiList().get(0).getid_abesti(), "EMAU1");
		assertEquals(plDao.getAbestiList().get(0).getKolaboratzaile(), null);
	}

	/**
	 * 
	 * Test hau egiten da erreprodukzioak atera nahi direnean
	 * 
	 * Playlistaren lehenengo abestia erreprodukzio lortzen du
	 * 
	 */
	@Test
	public void testErreprodukzioakAtera() {
		Playlist plDao = new Playlist();
		plDao.setId("PL004");
		plDao = NirePlaylistDao.AteraPlaylistAbestiak(plDao);
		ArrayList<Integer> erreprodukzioakTest = new ArrayList<Integer>();
		erreprodukzioakTest = NirePlaylistDao.ErreprodukzioakAtera(plDao);
		assertTrue(erreprodukzioakTest.get(0) > 0);

	}

	@Test
	public void testEzabatuAbestiaPlayList() {
		int index = 0;
		int abestiKop = 0;
		Playlist plDao = new Playlist();
		plDao.setId("PL004");
		plDao = NirePlaylistDao.AteraPlaylistAbestiak(plDao);
		abestiKop = plDao.getAbestiList().size();
		NirePlaylistDao.ezabatuAbestiaPlayList(index, plDao);
		assertTrue(plDao.getAbestiList().size() < abestiKop);

	}

	@Test
	public void testEzabatuPlayList() {

		Bezero bz = new Bezero();
		bz.setId("BZ001");
		int id = 0;
		int playListLuzera = 0;
		List<Playlist> playlistak = new ArrayList<Playlist>();
		playlistak = NirePlaylistDao.nirePlaylistAtera(bz);
		playListLuzera = playlistak.size();
		NirePlaylistDao.ezabatuPlayList(bz, id, playlistak);
		assertTrue(playlistak.size() < playListLuzera);

	}
}
