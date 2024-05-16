package Testak.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.Konexioa;
import DatuBasea.PodcasterDao;
import Modelo.Audio;
import Modelo.Audio.Mota;
import Modelo.Podcast;
import Modelo.Podcaster;

public class PodcasterDaoTest {

	@Test
	public void testPodcakasterAtera() {
		List<Podcaster> podcasterListDao = PodcasterDao.podcakasterAtera();


		assertNotNull(podcasterListDao);
		assertFalse(podcasterListDao.isEmpty());
		
		podcasterListDao.get(0).setInfo("Hemen informazioa jarri behar da");
		

			assertEquals(podcasterListDao.get(0).getIzena(), "Benetan zabiz?");
			assertEquals(podcasterListDao.get(0).getId(),"BNZB1");
			assertEquals(podcasterListDao.get(0).getInfo(), "Hemen informazioa jarri behar da");
	}
	@Test
	public void testPodcastLortu() {
		List<Podcast> podcastTestDao = PodcasterDao.podcastLortu("QSMA");


		assertNotNull(podcastTestDao);
		assertFalse(podcastTestDao.isEmpty());
		
		Time time = new Time(0,7,25);
		
		
			assertEquals(podcastTestDao.get(0).getId_Podcast(), "QMAU1");
			assertEquals(podcastTestDao.get(0).getId(),"QMAU1");
			assertEquals(podcastTestDao.get(0).getIraupena(),time);
			assertEquals(podcastTestDao.get(0).getKolaboratzaile(), null);
			assertEquals(podcastTestDao.get(0).getMota(), Mota.podcast);
			assertEquals(podcastTestDao.get(0).getPodcast_izena(), "Sueños homoeroticos");
	}

}
