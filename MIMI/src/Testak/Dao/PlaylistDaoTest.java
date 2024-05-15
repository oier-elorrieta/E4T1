package Testak.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.PlaylistDao;
import Modelo.Bezero;
import Modelo.Playlist;

public class PlaylistDaoTest {

    @Test
    public void testPlayListAtera() throws SQLException {
        Bezero erabiltzailea = new Bezero();
        erabiltzailea.setId("BZ001");
        
            List<Playlist> emaitza = PlaylistDao.PlayListAtera(erabiltzailea);
            
            assertNotNull(emaitza);
            assertFalse(emaitza.isEmpty());
            Playlist lehenengoa = emaitza.get(0);
            System.out.println(lehenengoa);
            
            
            assertEquals(lehenengoa.getId(), "PL001");
            assertEquals(lehenengoa.getIzena(), "Rock Hits");
            assertEquals(lehenengoa.getAbestiList(), null);
            
    }
    
    @Test
    public void testPlayListInsert() throws SQLException {
    	
    	String playlist = "";
    	
    	String audio = "";
    	
    	assertFalse(PlaylistDao.InsertAbestiPlaylist(playlist,audio));
    }
}
