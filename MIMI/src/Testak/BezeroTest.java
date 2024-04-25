package Testak;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;

import Modelo.Abesti;
import Modelo.*;

public class BezeroTest {

	// --------------------------------- TEST BEZERO FREE --------------------------------- //
	@Test
	public void testGetIzenaTrue() {
		FreeBezero bezero = new FreeBezero("BZ009", "talde", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		assertEquals("talde", bezero.getIzena());
	}

	@Test
	public void testSetIzenaFalse() {
		FreeBezero bezero = new FreeBezero();
		bezero.setIzena("Garcia");
		assertNotEquals("Casillas", bezero.getIzena());
	}

	@Test
	public void testGetIdTrue() {
		FreeBezero bezero = new FreeBezero("BZ009", "talde", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		assertEquals("BZ009", bezero.getId());
	}

	@Test
	public void testSetIdFalse() {
		FreeBezero bezero = new FreeBezero();
		bezero.setIzena("BZ002");
		assertNotEquals("BZ009", bezero.getId());
	}

	@Test
	public void testGetAbizenaTrue() {
		FreeBezero bezero = new FreeBezero("BZ009", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		assertEquals("talde", bezero.getAbizena());
	}

	@Test
	public void testSetAbizenaFalse() {
		FreeBezero bezero = new FreeBezero();
		bezero.setAbizena("Garcia");
		assertNotEquals("Casillas", bezero.getAbizena());
	}

	@Test
	public void testGetMotaTrue() {
		FreeBezero bezero = new FreeBezero("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01", "2023-04-04", null,
				"Premium", "EU");

		assertEquals("Premium", bezero.getMota());

	}

	@Test
	public void testGetMotaFalse() {
		FreeBezero bezero = new FreeBezero("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01", "2023-04-04", null,
				"Premium", "EU");

		assertNotEquals("Free", bezero.getMota());

	}

	@Test
	public void testSetMotaTrue() {
		FreeBezero bezero = new FreeBezero("BZ001", "Pedro", "Garcia", null, "kk", "2001-01-01", "2023-04-04", null,
				"Premium", "ES");
		bezero.setMota("Free");
		assertEquals("Free", bezero.getMota());
	}

	@Test
	public void testSetMotaFalse() {
		FreeBezero bezero = new FreeBezero("BZ001", "Pedro", "Garcia", null, "kk", "2001-01-01", "2023-04-04", null,
				"Premium", "ES");
		bezero.setMota("Free");
		assertNotEquals("Premium", bezero.getMota());

	}

	@Test
	public void testEqualsFreeTrue() {
		FreeBezero bezero1 = new FreeBezero("BZ009", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		FreeBezero bezero2 = new FreeBezero("BZ009", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);

		assertTrue(bezero1.equals(bezero2));

	}

	@Test
	public void testEqualsFreeFalse() {
		FreeBezero bezero1 = new FreeBezero("BZ003", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		FreeBezero bezero2 = new FreeBezero("BZ009", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);

		assertFalse(bezero1.equals(bezero2));
	}

	@Test
	public void testToStringFree() {
		ArrayList<Abesti> playArray = new ArrayList<>();
		playArray.add(new Abesti("1", "Song1", 3.5, "Album1", "Artist1"));
		FreeBezero bezero = new FreeBezero("BZ003", "mimi", "talde", "mimitalde", "password", "2024-04-19",
				"2024-04-20", new ArrayList<>(), null, null);
		String expectedToString = "Bezero [id=BZ003, izena=mimi, abizena=talde, erabiltzaile=mimitalde, pasahitza=password, jaioData=2024-04-19, erregisData=2024-04-20, playArray=[], mota=null, Hizkuntza=null]";
		;

		assertEquals(expectedToString, bezero.toString());

	}

	// --------------------------------- TEST BEZERO PREMIUM ----------------------------- //

	@Test
	public void testGetIzenaFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertNotEquals("Farcia", bezero.getIzena());
	}

	@Test
	public void testSetIzenaTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa();
		bezero.setIzena("Garcia");
		assertEquals("Garcia", bezero.getIzena());
	}

	@Test
	public void testGetIdFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertNotEquals("BZ003", bezero.getId());
	}

	@Test
	public void testSetIdTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa();
		bezero.setId("BZ009");
		assertEquals("BZ009", bezero.getId());
	}

	@Test
	public void testGetAbizenaFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertNotEquals("Farcia", bezero.getAbizena());
	}

	@Test
	public void testSetAbizenaTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa();
		bezero.setAbizena("Garcia");
		assertEquals("Garcia", bezero.getAbizena());
	}

	@Test
	public void testGetErabiltzaileTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertEquals("pedrus", bezero.getErabiltzaile());
	}

	@Test
	public void testGetErabiltzaileFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertNotEquals("momotalde", bezero.getErabiltzaile());
	}

	@Test
	public void testSetErabiltzaileTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", null, "kk", "2001-01-01", "2023-04-04",
				null, "2024-04-04", "Premium", "ES");
		bezero.setErabiltzaile("mikel");
		assertEquals("mikel", bezero.getErabiltzaile());
	}

	@Test
	public void testSetErabiltzaileFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", null, "kk", "2001-01-01", "2023-04-04",
				null, "2024-04-04", "Premium", "ES");
		bezero.setErabiltzaile("mikel");
		assertNotEquals("iker", bezero.getErabiltzaile());
	}

	@Test
	public void testGetPasahitzaTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertEquals("kk", bezero.getPasahitza());
	}

	@Test
	public void testGetPasahitzaFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertNotEquals("pasahitza", bezero.getPasahitza());
	}

	@Test
	public void testSetPasahitzaTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", null, "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		bezero.setPasahitza("pasahitza");
		assertEquals("pasahitza", bezero.getPasahitza());
	}

	@Test
	public void testSetPasahitzaFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", null, "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		bezero.setPasahitza("pasahitza");
		assertNotEquals("password", bezero.getPasahitza());
	}

	@Test
	public void testSetPremiumMugaTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", null, "2001-01-01",
				"2023-04-04", null, null, "Premium", "ES");
		bezero.setPremiumMuga("2024-04-04");
		assertEquals("2024-04-04", bezero.getPremiumMuga());
	}

	@Test
	public void testSetPremiumMugaFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", null, "2001-01-01",
				"2023-04-04", null, null, "Premium", "ES");
		bezero.setPremiumMuga("2024-04-04");
		assertNotEquals("2023-04-04", bezero.getPremiumMuga());
	}

	@Test
	public void testGetJaioDataTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");
		assertEquals("2001-01-01", bezero.getJaioData());
	}

	@Test
	public void testGetJaioDataFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", "2001-01-01",
				"2023-04-04", null, "2024-04-04", "Premium", "ES");

		assertNotEquals("2024-04-18", bezero.getJaioData());
	}

	@Test
	public void testSetJaioDataTrue() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, "2023-04-04", null,
				"2024-04-04", "Premium", "ES");
		bezero.setJaioData("2000-01-01");
		assertEquals("2000-01-01", bezero.getJaioData());
	}

	@Test
	public void testSetJaioDataFalse() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, "2023-04-04", null,
				"2024-04-04", "Premium", "ES");
		bezero.setJaioData("2001-01-01");

		assertNotEquals("20012-01-01", bezero.getJaioData());
	}

	@Test
	public void testGetErregisData() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, "2023-04-04", null,
				"2024-04-04", "Premium", "ES");
		assertEquals("2023-04-04", bezero.getErregisData());
	}

	@Test
	public void testSetErregisData() {
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		bezero.setErregisData("2022-04-18");
		assertEquals("2022-04-18", bezero.getErregisData());
	}

	@Test
	public void testGetPlayArray() {
		ArrayList<Abesti> playArray = new ArrayList<>();
		playArray.add(new Abesti("1", "Song1", 3.5, "Album1", "Artist1"));
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, "2023-04-04",
				playArray, "2024-04-04", "Premium", "ES");
		assertEquals(playArray, bezero.getPlayArray());
	}

	@Test
	public void testSetPlayArray() {
		ArrayList<Abesti> playArray = new ArrayList<>();
		playArray.add(new Abesti("1", "Song1", 3.5, "Album1", "Artist1"));
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		bezero.setPlayArray(playArray);

		assertEquals(playArray, bezero.getPlayArray());
	}

	@Test
	public void testEqualsPremTrue() {
		PremiumBezeroa bezero1 = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		PremiumBezeroa bezero2 = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");

		assertTrue(bezero1.equals(bezero2));

	}

	@Test
	public void testEqualsPremFalse() {
		PremiumBezeroa bezero1 = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		PremiumBezeroa bezero2 = new PremiumBezeroa("BZ002", "Pedra", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		assertFalse(bezero1.equals(bezero2));
	}

	@Test
	public void testToStringPremium() {
		ArrayList<Abesti> playArray = new ArrayList<>();
		playArray.add(new Abesti("1", "Song1", 3.5, "Album1", "Artist1"));
		PremiumBezeroa bezero = new PremiumBezeroa("BZ001", "Pedro", "Garcia", "pedrus", "kk", null, null, null,
				"2024-04-04", "Premium", "ES");
		String expectedToString = "Bezero [id=BZ001, izena=Pedro, abizena=Garcia, erabiltzaile=pedrus, pasahitza=kk, jaioData=null, erregisData=null, playArray=null, mota=Premium, Hizkuntza=ES]PremiumMuga=2024-04-04]";

		assertEquals(expectedToString, bezero.toString());
	}

}
