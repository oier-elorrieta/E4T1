package Testak.Pojo;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Time;

import Modelo.Abesti;
import Modelo.Audio.Mota;



public class AbestiTest {
	
    @Test
    public void testGetMota() {
        Abesti abesti = new Abesti("1",null,null,Mota.abestia,"1", "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals(Mota.abestia, abesti.getMota());
    }

    @Test
    public void testSetMota() {
        Abesti abesti = new Abesti(null,null,null,null,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setMota(Mota.abestia);
        assertEquals(Mota.abestia, abesti.getMota());
    }

    @Test
    public void testGetId() {
        Abesti abesti = new Abesti("1",null,null,Mota.abestia,"1", "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals("1", abesti.getId());
    }

    @Test
    public void testSetId() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setId("2");
        assertEquals("2", abesti.getId());
    }
    @Test
    public void testGetIdAbesti() {
        Abesti abesti = new Abesti("1",null,null,Mota.abestia,"1", "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals("1", abesti.getid_abesti());
    }

    @Test
    public void testSetIdAbesti() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setid_abesti("2");
        assertEquals("2", abesti.getid_abesti());
    }

    @Test
    public void testGetAbestiIzena() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "AbestiIzena", "Album1", "Kolaboratzaile1");
        assertEquals("AbestiIzena", abesti.getAbestiIzena());
    }

    @Test
    public void testSetAbestiIzena() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setAbestiIzena("Abesti2");
        assertEquals("Abesti2", abesti.getAbestiIzena());
    }

    @Test
    public void testGetIraupena() {
        Time iraupena = new Time(1);
        Abesti abesti = new Abesti("1", iraupena, null, Mota.abestia, "1", "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals(iraupena, abesti.getIraupena());
    }

    @Test
    public void testSetIraupena() {
        Time iraupena = new Time(1);
        Abesti abesti = new Abesti("1", null, null, Mota.abestia, "1", "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setIraupena(iraupena);
        assertEquals(iraupena, abesti.getIraupena());
    

    }

    @Test
    public void testGetAlbumIzena() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals("Album1", abesti.getAlbumIzena());
    }

    @Test
    public void testSetAlbumIzena() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setAlbumIzena("Album2");
        assertEquals("Album2", abesti.getAlbumIzena());
    }

    @Test
    public void testGetKolaboratzaile() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        assertEquals("Kolaboratzaile1", abesti.getKolaboratzaile());
    }

    @Test
    public void testSetKolaboratzaile() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        abesti.setKolaboratzaile("Kolaboratzaile2");
        assertEquals("Kolaboratzaile2", abesti.getKolaboratzaile());
    }

    @Test
    public void testEquals() {
        Abesti abesti1 = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        Abesti abesti2 = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
      
        assertTrue(abesti1.equals(abesti2));
   
    }
    
    @Test
    public void testEqualsF() {
        Abesti abesti1 = new Abesti(null,null,null,Mota.podcast,null, "Abesti1", "Album1", "Kolaboratzaile1");
        Abesti abesti2 = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        
        assertFalse(abesti1.equals(abesti2));
    }

    @Test
    public void testToString() {
        Abesti abesti = new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1");
        String expectedToString = "Audio [id=null, iraupena=null, irudia=null, mota=abestia]Abesti [id=null, abestiIzena=Abesti1albumIzena=Album1, kolaboratzaile=Kolaboratzaile1]";
        assertEquals(expectedToString, abesti.toString());
    }
}