package Testak;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Album;


public class AlbumTest {
	  @Test
	    public void testGetId_Audio() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals("Album_id", album.getId());
	  }
	  @Test
	    public void testSetId_Audio() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setId("Album_ID2");
	       assertEquals("Album_ID2", album.getId());
	  }
	  @Test
	    public void testGetIzenburua() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals("Los del Rio Grandes Exitos", album.getIzenburua());
	  }
	  @Test
	    public void testSetIzenburua() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setIzenburua("Los del Rio Aniversario");
	       assertEquals("Los del Rio Aniversario", album.getIzenburua());
	  }
	  @Test
	    public void testGetAbestiKopurua() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals(10, album.getAbestiKopurua());
	  }
	  @Test
	    public void testSetAbestiKopurua() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setAbestiKopurua(15);
	       assertEquals(15, album.getAbestiKopurua());
	  }
	  @Test
	    public void testGetGeneroa() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals("POP" , album.getGeneroa());
	  }
	  @Test
	    public void testSetGeneroa() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setGeneroa("Rock");
	       assertEquals("Rock" , album.getGeneroa());
	  }
	  @Test
	    public void testGetIdMusikaria() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals("Id_DelRio" , album.getIdMusikaria());
	  }
	  @Test
	    public void testSetIdMusikaria() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setIdMusikaria("id_KAOTIKO");
	       assertEquals("id_KAOTIKO" , album.getIdMusikaria());
	  }
	  @Test
	    public void testGetKolaboratzaileak() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals("Antonio Romero Monge y Rafael Ruiz" , album.getKolaboratzaileak());
	  }
	  @Test
	    public void testSetKolaboratzaileak() {
	       Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       album.setKolaboratzaileak("KAOTIKO");
	       assertEquals("KAOTIKO" , album.getKolaboratzaileak());	  
	  }
	  @Test
	    public void testEquals() {
	       Album album1 = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       Album album2 = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertEquals(album1 , album2);	  
	  }
	  @Test
	    public void testEqualsF() {
	       Album album1 = new Album("Album_id1", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       Album album2 = new Album("Album_id2", "Los del Rio Aniversario", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       assertNotEquals(album1 , album2);	  
	  }
	  @Test
	    public void testToString() {
	       Album album = new Album("Album_id1", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz");
	       String expectedToString = "Album [id=Album_id1, izenburua=Los del Rio Grandes Exitos, argitaratzea=null, AbestiKopurua=10, generoa=POP, kolaboratzaileak=Antonio Romero Monge y Rafael Ruiz]";
	        assertEquals(expectedToString, album.toString());
	  }
	  
	  

}
