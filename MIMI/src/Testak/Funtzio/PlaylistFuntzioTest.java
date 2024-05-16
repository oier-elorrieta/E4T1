package Testak.Funtzio;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import DatuBasea.AbeslariDao;
import DatuBasea.NirePlaylistDao;
import Modelo.Abesti;
import Modelo.Playlist;
import Modelo.Audio.Mota;
import funtzioak.PlaylistFuntzioak;

public class PlaylistFuntzioTest {

	@Test
	public void testPlaylistaExportatu() {
		Playlist playlista = new Playlist();
		playlista.setId("PL003");
		playlista = NirePlaylistDao.lortuAbestiakIdPlaylist(playlista);
		Playlist playlista2 = new Playlist();
		PlaylistFuntzioak.PlaylistaExportatu(playlista);
		try {
			playlista2 = PlaylistFuntzioak.PlaylistaImportatu(playlista2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(playlista.getAbestiList().get(0).getid_abesti(), playlista2.getAbestiList().get(0).getid_abesti());
	}

	@Test
	public void testAbestiakExportatu() {
		Playlist playlista = new Playlist();
		playlista.setId("PL003");
		playlista = NirePlaylistDao.lortuAbestiakIdPlaylist(playlista);
		ArrayList<Integer> erreprodukzioak;
		erreprodukzioak = NirePlaylistDao.ErreprodukzioakAtera(playlista);
		ArrayList<String> abeslaria;
		abeslaria = AbeslariDao.AbeslariaAteraPlayList(playlista);
		int id = 0;
		ArrayList<Abesti> abestiak = new ArrayList<Abesti>();
		Abesti abesti = new Abesti();
		abesti.setid_abesti("AB001");
		abesti.setAbestiIzena("abestia");
		abesti.setMota(Mota.abestia);
		abestiak.add(abesti);
		PlaylistFuntzioak.AbestiakExportatu(playlista, erreprodukzioak, abeslaria, id);
		
		try (BufferedReader br = new BufferedReader(new FileReader("abestiak.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				assertEquals("ABESTI HAU ENTZUN- Mockingbird - "+erreprodukzioak.get(0)+" - Eminem - 00:04:10", line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
