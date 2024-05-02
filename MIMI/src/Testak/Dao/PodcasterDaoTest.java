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
import Modelo.Podcast;
import Modelo.Podcaster;

public class PodcasterDaoTest {

	private static List<Podcaster> podcasterListTest = new ArrayList<Podcaster>();
	private static List<Podcast> podcastTest = new ArrayList<Podcast>();

	public static List<Podcaster> podcakasterAteraTest() {

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "SELECT * FROM Podcaster";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						Podcaster podcaster = new Podcaster();

						String id = rs.getString("IdPodcaster");

						String izenArtistikoa = rs.getString("IzenArtistikoa");

						Blob irudia = rs.getBlob("Irudia");

						String deskribapena = rs.getString("Deskribapena");

						podcaster.setId(id);

						podcaster.setIzena(izenArtistikoa);

						podcaster.setInfo(deskribapena);

						podcaster.setIrudia(irudia);

						podcasterListTest.add(podcaster);

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return podcasterListTest;

	}

	@Test
	public void testPodcakasterAtera() {
		List<Podcaster> podcasterListDao = PodcasterDao.podcakasterAtera();

		podcasterListTest = podcakasterAteraTest();

		assertNotNull(podcasterListTest);
		assertFalse(podcasterListTest.isEmpty());

		// Salta el equals de todo el objeto a la vez
		for (int i = 0; i < podcasterListTest.size(); i++) {
			assertEquals(podcasterListTest.get(i).getIzena(), podcasterListDao.get(i).getIzena());
			assertEquals(podcasterListTest.get(i).getId(), podcasterListDao.get(i).getId());
			assertEquals(podcasterListTest.get(i).getInfo(), podcasterListDao.get(i).getInfo());
			// assertEquals(podcasterListTest.get(i).getIrudia(),
			// podcasterListDao.get(i).getIrudia());

		}
	}

	public static List<Podcast> podcastLortuTest(String podcasterIzena) {

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select * from Audio inner join Podcast using(idAudio) inner join Podcaster using (idPodcaster) where IzenArtistikoa = '"

					+ podcasterIzena + "';";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						String IdAudio = rs.getString("IdAudio");

						String podcast_izena = rs.getString("izena");

						String kolaboratzaileak = rs.getString("Kolaboratzaileak");

						Time iraupena = rs.getTime("Iraupena");
						;

						Blob Irudia = rs.getBlob("Irudia");

						Podcast pod = new Podcast(IdAudio, iraupena, Irudia, Audio.Mota.podcast, IdAudio, podcast_izena,
								kolaboratzaileak);

						podcastTest.add(pod);

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return podcastTest;

	}
	
	@Test
	public void testPodcastLortu() {
		List<Podcast> podcastTestDao = PodcasterDao.podcastLortu("QSMA");

		podcastTest = podcastLortuTest("QSMA");

		assertNotNull(podcastTest);
		assertFalse(podcastTest.isEmpty());

		// Salta el equals de todo el objeto a la vez
		for (int i = 0; i < podcastTest.size(); i++) {
			assertEquals(podcastTest.get(i).getId_Podcast(), podcastTestDao.get(i).getId_Podcast());
			assertEquals(podcastTest.get(i).getId(), podcastTestDao.get(i).getId());
			assertEquals(podcastTest.get(i).getIraupena(), podcastTestDao.get(i).getIraupena());
			assertEquals(podcastTest.get(i).getKolaboratzaile(), podcastTestDao.get(i).getKolaboratzaile());
			assertEquals(podcastTest.get(i).getMota(), podcastTestDao.get(i).getMota());
			assertEquals(podcastTest.get(i).getPodcast_izena(), podcastTestDao.get(i).getPodcast_izena());
			// assertEquals(podcasterListTest.get(i).getIrudia(),
			

		}
	}

}
