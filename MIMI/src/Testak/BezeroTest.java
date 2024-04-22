package Testak;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;

import Modelo.Abesti;
import Modelo.Bezero;

public class BezeroTest {

    @Test
    public void testGetAbizenaTrue() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertEquals("talde", bezero.getAbizena());
    }
    
    @Test
    public void testGetAbizenaFalse() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertNotEquals("Garcia", bezero.getAbizena());
    }

    @Test
    public void testSetAbizenaTrue() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setAbizena("Garcia");
        assertEquals("Garcia", bezero.getAbizena());
    }
    
    @Test
    public void testSetAbizenaFlase() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setAbizena("Garcia");
        assertNotEquals("Casillas", bezero.getAbizena());
    }

    @Test
    public void testGetErabiltzaileTrue() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertEquals("mimitalde", bezero.getErabiltzaile());
    }
    
    @Test
    public void testGetErabiltzaileFalse() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertNotEquals("momotalde", bezero.getErabiltzaile());
    }

    @Test
    public void testSetErabiltzaileTrue() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setErabiltzaile("mikel");
        assertEquals("mikel", bezero.getErabiltzaile());
    }
    
    @Test
    public void testSetErabiltzaileFalse() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setErabiltzaile("mikel");
        assertNotEquals("iker", bezero.getErabiltzaile());
    }

    @Test
    public void testGetPasahitzaTrue() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertEquals("password", bezero.getPasahitza());
    }
    
    @Test
    public void testGetPasahitzaFalse() {
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        assertNotEquals("pasahitza", bezero.getPasahitza());
    }

    @Test
    public void testSetPasahitzaTrue() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setPasahitza("pasahitza");
        assertEquals("pasahitza", bezero.getPasahitza());
    }
    
    @Test
    public void testSetPasahitzaFalse() {
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setPasahitza("pasahitza");
        assertNotEquals("password", bezero.getPasahitza());
    }

    @Test
    public void testGetJaioDataTrue() {
        Date jaioData = Date.valueOf("2024-04-19");
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", jaioData, Date.valueOf("2024-04-20"), new ArrayList<>());
        assertEquals(jaioData, bezero.getJaioData());
    }
    
    @Test
    public void testGetJaioDataFalse() {
        Date jaioData = Date.valueOf("2024-04-19");
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", jaioData, Date.valueOf("2024-04-20"), new ArrayList<>());
        
        Date BesteJaioData = Date.valueOf("2024-04-18");
  
        assertNotEquals(BesteJaioData, bezero.getJaioData());
    }


    @Test
    public void testSetJaioDataTrue() {
        Date jaioData = Date.valueOf("2000-01-01");
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setJaioData(jaioData);
        assertEquals(jaioData, bezero.getJaioData());
    }
    
    @Test 
    public void testSetJaioDataFalse() {
        Date jaioData = Date.valueOf("2005-11-21");
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setJaioData(jaioData);
        Date BesteJaioData = Date.valueOf("2004-11-21");
        
        assertNotEquals(BesteJaioData, bezero.getJaioData());
    }


    @Test
    public void testGetErregisData() {
        Date erregisData = Date.valueOf("2022-04-18");
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), erregisData, new ArrayList<>());
        assertEquals(erregisData, bezero.getErregisData());
    }

    @Test
    public void testSetErregisData() {
        Date erregisData = Date.valueOf("2022-04-18");
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setErregisData(erregisData);
        assertEquals(erregisData, bezero.getErregisData());
    }

    @Test
    public void testGetPlayArray() {
        ArrayList<Abesti> playArray = new ArrayList<>();
        playArray.add(new Abesti(1, "Song1", 3.5, "Album1", "Artist1"));
        Bezero bezero = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), playArray);
        assertEquals(playArray, bezero.getPlayArray());
    }

    @Test
    public void testSetPlayArray() {
        ArrayList<Abesti> playArray = new ArrayList<>();
        playArray.add(new Abesti(1, "Song1", 3.5, "Album1", "Artist1"));
        Bezero bezero = new Bezero(0, null, null, null, null, null, null, null);
        bezero.setPlayArray(playArray);
        
        assertEquals(playArray, bezero.getPlayArray());
    }

    @Test
    public void testEquals() {
        Bezero bezero1 = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        Bezero bezero2 = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());

        assertTrue(bezero1.equals(bezero2));
       
    }
    @Test
    public void testEqualsFalse() {
        Bezero bezero1 = new Bezero(1, "mimi", "talde", "mimitalde", "password", Date.valueOf("2024-04-19"), Date.valueOf("2024-04-20"), new ArrayList<>());
        Bezero bezero2 = new Bezero(2, "Mirari", "Casillas", "micasillas", "ninguna", Date.valueOf("1990-01-01"), Date.valueOf("2022-04-19"), new ArrayList<>());
        assertFalse(bezero1.equals(bezero2));
    }

    @Test
    public void testToString() {
        ArrayList<Abesti> playArray = new ArrayList<>();
        playArray.add(new Abesti(1, "Song1", 3.5, "Album1", "Artist1"));
        Bezero bezero = new Bezero(1, "John", "Doe", "johndoe", "password", Date.valueOf("2000-01-01"), Date.valueOf("2022-04-18"), playArray);
        String expectedToString = "Bezero [id=1, izena=John, abizena=Doe, erabiltzaile=johndoe, pasahitza=password, jaioData=2000-01-01, erregisData=2022-04-18, playArray=" + playArray + "]";
        
        assertEquals(expectedToString, bezero.toString());
    }
}
