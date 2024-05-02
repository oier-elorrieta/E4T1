package Testak.Pojo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import Modelo.Abesti;
import Modelo.Playlist;
import Modelo.Audio.Mota;

public class PlaylistTest {

    @Test
    public void testGetIdTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist("1", "EuskalKantak", abestiList);
        assertEquals("1", playlist.getId());
    }
    
    @Test
    public void testGetIdFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist("1", "EuskalKantak", abestiList);
        assertNotEquals(2, playlist.getId());
    }

    @Test
    public void testSetIdTrue() {
        Playlist playlist = new Playlist("0", null, null);
        playlist.setId("2");
        assertEquals("2", playlist.getId());
    }
    
    @Test
    public void testSetIdFalse() {
        Playlist playlist = new Playlist("0", null, null);
        playlist.setId("2");
        assertNotEquals("3", playlist.getId());
    }

    @Test
    public void testGetIzenaTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist("1", "EuskalKantak", abestiList);
        assertEquals("EuskalKantak", playlist.getIzena());
    }
    
    @Test
    public void testGetIzenaFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist("1", "EuskalKantak", abestiList);
        assertNotEquals("Cancionsgalegas", playlist.getIzena());
    }

    @Test
    public void testSetIzenaTrue() {
        Playlist playlist = new Playlist("0", null, null);
        playlist.setIzena("EuskalKantaBerriak");
        assertEquals("EuskalKantaBerriak", playlist.getIzena());
    }
    
    @Test
    public void testSetIzenaFalse() {
        Playlist playlist = new Playlist("0", null, null);
        playlist.setIzena("EuskalKantaBerriak");
        assertNotEquals("EuskalKantaZaharrak", playlist.getIzena());
    }

    @Test
    public void testGetAbestiListTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        Playlist playlist = new Playlist("1", "EuskalKantak", abestiList);
        assertEquals(abestiList, playlist.getAbestiList());
    }
    
    @Test
    public void testGetAbestiListFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        
        ArrayList<Abesti> AbestiLista = new ArrayList<>();
        AbestiLista.add(new Abesti(null,null,null,Mota.podcast,null, "Abesti2", "Album2", "Kolaboratzaile1"));
        
        Playlist playlist = new Playlist("1", "Playlist1", abestiList);
        
        assertNotEquals(AbestiLista, playlist.getAbestiList());
    }


    @Test
    public void testSetAbestiList() {
        ArrayList<Abesti> newAbestiList = new ArrayList<>();
        newAbestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        Playlist playlist = new Playlist("0", null, null);
        playlist.setAbestiList(newAbestiList);
        assertEquals(newAbestiList, playlist.getAbestiList());
    }

    @Test
    public void testToString() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        Playlist playlist = new Playlist("1", "Playlist1", abestiList);
        String expectedToString = "Playlist [id=1, izena=Playlist1, AbestiList=[Audio [id=null, iraupena=null, irudia=null, mota=abestia]Abesti [id=null, abestiIzena=Abesti1albumIzena=Album1, kolaboratzaile=Kolaboratzaile1]]]";
        assertEquals(expectedToString, playlist.toString());
    }

    @Test
    public void testEqualsTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        Playlist playlist1 = new Playlist("1", "EuskalKantak", abestiList);
        Playlist playlist2 = new Playlist("1", "EuskalKantak", abestiList);

        assertTrue(playlist1.equals(playlist2));
       
    }
    @Test
    public void testEqualsFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(null,null,null,Mota.abestia,null, "Abesti1", "Album1", "Kolaboratzaile1"));
        Playlist playlist1 = new Playlist("1", "EuskalKantak", abestiList);
        Playlist playlist3 = new Playlist("3", "CancionsGalegas", abestiList);

       assertFalse(playlist1.equals(playlist3));
    }
    
    
}
