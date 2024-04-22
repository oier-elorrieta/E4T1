package Testak;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import Modelo.Abesti;
import Modelo.Playlist;

public class PlaylistTest {

    @Test
    public void testGetIdTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist(1, "EuskalKantak", abestiList);
        assertEquals(1, playlist.getId());
    }
    
    @Test
    public void testGetIdFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist(1, "EuskalKantak", abestiList);
        assertNotEquals(2, playlist.getId());
    }

    @Test
    public void testSetIdTrue() {
        Playlist playlist = new Playlist(0, null, null);
        playlist.setId(2);
        assertEquals(2, playlist.getId());
    }
    
    @Test
    public void testSetIdFalse() {
        Playlist playlist = new Playlist(0, null, null);
        playlist.setId(2);
        assertNotEquals(3, playlist.getId());
    }

    @Test
    public void testGetIzenaTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist(1, "EuskalKantak", abestiList);
        assertEquals("EuskalKantak", playlist.getIzena());
    }
    
    @Test
    public void testGetIzenaFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        Playlist playlist = new Playlist(1, "EuskalKantak", abestiList);
        assertNotEquals("Cancionsgalegas", playlist.getIzena());
    }

    @Test
    public void testSetIzenaTrue() {
        Playlist playlist = new Playlist(0, null, null);
        playlist.setIzena("EuskalKantaBerriak");
        assertEquals("EuskalKantaBerriak", playlist.getIzena());
    }
    
    @Test
    public void testSetIzenaFalse() {
        Playlist playlist = new Playlist(0, null, null);
        playlist.setIzena("EuskalKantaBerriak");
        assertNotEquals("EuskalKantaZaharrak", playlist.getIzena());
    }

    @Test
    public void testGetAbestiListTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(1, "Noain", 3.5, "Noain", ""));
        Playlist playlist = new Playlist(1, "EuskalKantak", abestiList);
        assertEquals(abestiList, playlist.getAbestiList());
    }
    
    @Test
    public void testGetAbestiListFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(1, "Noain", 3.5, "Noain", ""));
        
        ArrayList<Abesti> AbestiLista = new ArrayList<>();
        AbestiLista.add(new Abesti(2, "Odio Eterno", 4.0, "Oi!Baldorba", ""));
        
        Playlist playlist = new Playlist(1, "Playlist1", abestiList);
        
        assertNotEquals(AbestiLista, playlist.getAbestiList());
    }


    @Test
    public void testSetAbestiList() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        ArrayList<Abesti> newAbestiList = new ArrayList<>();
        newAbestiList.add(new Abesti(2, "Abesti2", 4.0, "Album2", "Kolaboratzaile2"));
        Playlist playlist = new Playlist(0, null, null);
        playlist.setAbestiList(newAbestiList);
        assertEquals(newAbestiList, playlist.getAbestiList());
    }

    @Test
    public void testToString() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(1, "Abesti1", 3.5, "Album1", "Kolaboratzaile1"));
        Playlist playlist = new Playlist(1, "Playlist1", abestiList);
        String expectedToString = "Playlist [id=1, izena=Playlist1, AbestiList=[" +
                                  "Abesti [id=1, abestiIzena=Abesti1, iraupena=3.5, albumIzena=Album1, kolaboratzaile=Kolaboratzaile1]" +
                                  "]]";
        assertEquals(expectedToString, playlist.toString());
    }

    @Test
    public void testEqualsTrue() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(1, "Noain", 3.5, "Noain", ""));
        Playlist playlist1 = new Playlist(1, "EuskalKantak", abestiList);
        Playlist playlist2 = new Playlist(1, "EuskalKantak", abestiList);

        assertTrue(playlist1.equals(playlist2));
       
    }
    @Test
    public void testEqualsFalse() {
        ArrayList<Abesti> abestiList = new ArrayList<>();
        abestiList.add(new Abesti(1, "Noain", 3.5, "Noain", ""));
        Playlist playlist1 = new Playlist(1, "EuskalKantak", abestiList);
        Playlist playlist3 = new Playlist(3, "CancionsGalegas", abestiList);

       assertFalse(playlist1.equals(playlist3));
    }
    
    
}