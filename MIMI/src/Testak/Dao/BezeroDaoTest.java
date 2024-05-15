package Testak.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import DatuBasea.BezeroDao;
import Modelo.Bezero;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class BezeroDaoTest {

	@Test
	public void testLoginKomprobatu() throws SQLException {

		// b erabiltzailea existitzen dela egiaztatu True ematen du
		assertTrue(BezeroDao.LoginKomprobatu("b", "b"));

	}

	@Test
	public void testLoginKomprobatuFalse() throws SQLException {

		assertFalse(BezeroDao.LoginKomprobatu("a", "abc"));
	}

	@Test
	public void testHizkuntzaAtera() {
		String[] hizkuntzak = BezeroDao.HizkuntzaAtera();
		assertNotNull("Hizkuntzak ezin du nulua izan", hizkuntzak);
		assertTrue("Hizkuntzak array-ak elementu gutxienez bat izan behar du", hizkuntzak.length > 0);
	}

	@Test
	public void testHartuIdBezero() throws SQLException {
		String id = BezeroDao.hartuIdBezero();
		assertTrue("Erabiltzailearen IDak BZxxx formatua izan behar du", id.matches("BZ\\d{3}"));
	}

	@Test
	public void testInsertFree() throws SQLException {
		FreeBezero berria = new FreeBezero();
		berria.setIzena("Berria");
		berria.setAbizena("Erabiltzailea");
		berria.setErabiltzaile("berria_erabiltzailea");
		berria.setPasahitza("berria_pasahitza");
		berria.setJaioData("2024-05-01");
		berria.setErregisData("2024-05-01");
		berria.setHizkuntza("eu");
		berria.setMota("free");
		BezeroDao.InsertFree(berria);
		assertTrue(BezeroDao.Bezeroaexistitu(berria.getErabiltzaile()));
	}

	@Test
	public void testInsertPremium() throws SQLException {
		PremiumBezeroa berriaPremium = new PremiumBezeroa();
		berriaPremium.setIzena("Berria");
		berriaPremium.setAbizena("Premium Erabiltzailea");
		berriaPremium.setErabiltzaile("berria_premium");
		berriaPremium.setPasahitza("berria_pasahitza");
		berriaPremium.setJaioData("2005-05-09");
		berriaPremium.setErregisData("2024-05-06");
		berriaPremium.setHizkuntza("eu");
		berriaPremium.setMota("premium");
		berriaPremium.setPremiumMuga("2024-06-06");
		BezeroDao.InsertPremium(berriaPremium);
		assertTrue(BezeroDao.Bezeroaexistitu(berriaPremium.getErabiltzaile()));
	}

	@Test
	public void testBezeroUpdate() throws SQLException {
		FreeBezero existitzenDena = new FreeBezero();
		existitzenDena.setId("BZ002");
		JTextField textIzena = new JTextField("IzenaBerria");
		JTextField textAbizena = new JTextField("AbizenaBerria");
		JTextField textErabiltzalea = new JTextField("ErabiltzaileBerria");
		JPasswordField textPasahitza = new JPasswordField("berria_pasahitza");

		BezeroDao.BezeroUpdate(existitzenDena, textIzena, textAbizena, textErabiltzalea, textPasahitza);

	}

	@Test
	public void testBezeroPremiumEdoEz() throws SQLException {

		PremiumBezeroa pm2 = new PremiumBezeroa();
		PremiumBezeroa pm1 = new PremiumBezeroa();
		pm2.setId("BZ005");
		pm1.setId("BZ006");

		assertTrue(BezeroDao.BezeroaPremiumEdoEz(pm1));

		assertTrue(BezeroDao.BezeroaPremiumEdoEz(pm2));

	}

	@Test
	public void testBezeroUpdatePremium() throws SQLException {
		FreeBezero berria = new FreeBezero();
		berria.setIzena("Berria");
		berria.setAbizena("Erabiltzailea");
		berria.setErabiltzaile("berria_erabiltzailea");
		berria.setPasahitza("berria_pasahitza");
		berria.setJaioData("2024-05-01");
		berria.setErregisData("2024-05-01");
		berria.setHizkuntza("eu");
		berria.setMota("free");
		BezeroDao.InsertFree(berria);
		BezeroDao.BezeroUpdatePremium(berria);
		assertEquals(berria.getMota(), "premium");

	}

	@Test
	public void testBezeroaexistitu() throws SQLException {
		// Bezeroa existitzen dela egiaztatu False ematen du

		assertFalse(BezeroDao.Bezeroaexistitu("a"));

	}

	@Test
	public void testBezeroaexistituFalse() throws SQLException {
		// Bezeroa ez existitzen dela egiaztatu True ematen du

		assertTrue(BezeroDao.Bezeroaexistitu("ajdisjaoifjoagfij"));

	}

}
