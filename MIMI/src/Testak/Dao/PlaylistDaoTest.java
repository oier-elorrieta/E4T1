package Testak.Dao;

import static org.junit.Assert.assertEquals;
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
    public void testPlayListAtera() {
        Bezero erabiltzailea = new Bezero();
        erabiltzailea.setId("BZ001");
        
        List<Playlist> playlistZerrenda = new ArrayList<>();
        
        try {
            List<Playlist> emaitza = PlaylistDao.PlayListAtera(erabiltzailea, playlistZerrenda);
            
            assertNotNull(emaitza);
            
            assertTrue(emaitza.size() > 0);
            
            Playlist lehenengoa = emaitza.get(0);
            assertNotNull(lehenengoa.getId());
            assertNotNull(lehenengoa.getIzena());
            
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQL errore bat gertatu da: " + e.getMessage());
        }
    }
}
