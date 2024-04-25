package Testak;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Modelo.Abesti;



public class AbestiTest {

    @Test
    public void testGetId() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        assertEquals("1", abesti.getId());
    }

    @Test
    public void testSetId() {
        Abesti abesti = new Abesti("0", null, 0.0, null, null);
        abesti.setId("2");
        assertEquals("2", abesti.getId());
    }

    @Test
    public void testGetAbestiIzena() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        assertEquals("Abesti1", abesti.getAbestiIzena());
    }

    @Test
    public void testSetAbestiIzena() {
        Abesti abesti = new Abesti("0", null, 0.0, null, null);
        abesti.setAbestiIzena("Abesti2");
        assertEquals("Abesti2", abesti.getAbestiIzena());
    }

    @Test
    public void testGetIraupena() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        assertEquals(3.5, abesti.getIraupena(), 0.001);
    }

    @Test
    public void testSetIraupena() {
        Abesti abesti = new Abesti("0", null, 0.0, null, null);
        abesti.setIraupena(4.0);
        assertEquals(4.0, abesti.getIraupena(), 0.001);
    }

    @Test
    public void testGetAlbumIzena() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        assertEquals("Album1", abesti.getAlbumIzena());
    }

    @Test
    public void testSetAlbumIzena() {
        Abesti abesti = new Abesti("0", null, 0.0, null, null);
        abesti.setAlbumIzena("Album2");
        assertEquals("Album2", abesti.getAlbumIzena());
    }

    @Test
    public void testGetKolaboratzaile() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        assertEquals("Kolaboratzaile1", abesti.getKolaboratzaile());
    }

    @Test
    public void testSetKolaboratzaile() {
        Abesti abesti = new Abesti("0", null, 0.0, null, null);
        abesti.setKolaboratzaile("Kolaboratzaile2");
        assertEquals("Kolaboratzaile2", abesti.getKolaboratzaile());
    }

    @Test
    public void testEquals() {
        Abesti abesti1 = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        Abesti abesti2 = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
      
        assertTrue(abesti1.equals(abesti2));
   
    }
    
    @Test
    public void testEqualsF() {
    	Abesti abesti1 = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        Abesti abesti2 = new Abesti("2", "Abesti2", 4.0, "Album2", "Kolaboratzaile2");
        
        assertFalse(abesti1.equals(abesti2));
    }

    @Test
    public void testToString() {
        Abesti abesti = new Abesti("1", "Abesti1", 3.5, "Album1", "Kolaboratzaile1");
        String expectedToString = "Abesti [id=1, abestiIzena=Abesti1, iraupena=3.5, albumIzena=Album1, kolaboratzaile=Kolaboratzaile1]";
        assertEquals(expectedToString, abesti.toString());
    }
}