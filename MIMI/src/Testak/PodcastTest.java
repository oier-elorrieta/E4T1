package Testak;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import Modelo.Audio.Mota;
import Modelo.Podcast;



public class PodcastTest {
	
    @Test
    public void testGetMota() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        assertEquals(Mota.podcast, podcast.getMota());
    }

    @Test
    public void testSetMota() {
        Podcast podcast = new Podcast();
        podcast.setMota(Mota.podcast);
        assertEquals(Mota.podcast, podcast.getMota());
    }

    @Test
    public void testGetIdAudio() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        assertEquals("1", podcast.getId());
    }

    @Test
    public void testSetIdAudio() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        podcast.setId("2");
        assertEquals("2", podcast.getId());
    }
    @Test
    public void testGetIdPodcast() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        assertEquals("1_podcast", podcast.getId_Podcast());
    }

    @Test
    public void testSetIdPodcast() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        podcast.setId_Podcast("2_podcast");
        assertEquals("2_podcast", podcast.getId_Podcast());
    }

    @Test
    public void testGetPodcastiIzena() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        assertEquals("QSMA", podcast.getPodcast_izena());
    }

    @Test
    public void testSetPodcastIzena() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        podcast.setPodcast_izena("TWP");
        assertEquals("TWP", podcast.getPodcast_izena());
    }



    @Test
    public void testGetKolaboratzaile() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        assertEquals("MARIO", podcast.getKolaboratzaile());
    }

    @Test
    public void testSetKolaboratzaile() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        podcast.setKolaboratzaile("PEDRO");
        assertEquals("PEDRO", podcast.getKolaboratzaile());
    }

    @Test
    public void testEquals() {
        Podcast podcast1 = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        Podcast podcast2 = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
      
        assertTrue(podcast1.equals(podcast2));
   
    }
    
    @Test
    public void testEqualsF() {
        Podcast podcast1 = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        Podcast podcast2 = new Podcast("2",null,null,Mota.podcast,"2_podcast", "TWP", "PEDRO");
        
        assertFalse(podcast1.equals(podcast2));
    }

    @Test
    public void testToString() {
        Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
        String expectedToString = "Audio [id=1, iraupena=null, irudia=null, mota=podcast]Podcast [id=1_podcast, podcast_izena=QSMA, kolaboratzaile=MARIO]";
        assertEquals(expectedToString, podcast.toString());
    }
}