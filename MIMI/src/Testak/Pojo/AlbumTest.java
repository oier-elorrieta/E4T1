package Testak.Pojo;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import Modelo.Album;

public class AlbumTest {
	@Test
	public void testGetId_Audio() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals("Album_id", album.getId());
	}

	@Test
	public void testSetId_Audio() {
		Album album = new Album();
		album.setId("Album_ID2");
		assertEquals("Album_ID2", album.getId());
	}

	@Test
	public void testGetIzenburua() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals("Los del Rio Grandes Exitos", album.getIzenburua());
	}

	@Test
	public void testSetIzenburua() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		album.setIzenburua("Los del Rio Aniversario");
		assertEquals("Los del Rio Aniversario", album.getIzenburua());
	}

	@Test
	public void testGetAbestiKopurua() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals(10, album.getAbestiKopurua());
	}

	@Test
	public void testSetAbestiKopurua() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		album.setAbestiKopurua(15);
		assertEquals(15, album.getAbestiKopurua());
	}

	@Test
	public void testGetGeneroa() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals("POP", album.getGeneroa());
	}
	
	@Test
    public void testSetArgitaratzeData() {
        Date data = new Date(5); // Crear una instancia de Date para la fecha actual
        Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
                                "Antonio Romero Monge y Rafael Ruiz", null);
        album.setArgitaratzea(data); // Establecer la fecha de publicación del álbum
        assertEquals(data, album.getArgitaratzea());
    }

    @Test
    public void testGetArgitaratzea() {
        Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
                                "Antonio Romero Monge y Rafael Ruiz", null);
        assertEquals(null, album.getArgitaratzea()); // Asumiendo que inicialmente la fecha de publicación es null
    }

	@Test
	public void testSetGeneroa() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		album.setGeneroa("Rock");
		assertEquals("Rock", album.getGeneroa());
	}

	@Test
	public void testGetIdMusikaria() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals("Id_DelRio", album.getIdMusikaria());
	}

	@Test
	public void testSetIdMusikaria() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		album.setIdMusikaria("id_KAOTIKO");
		assertEquals("id_KAOTIKO", album.getIdMusikaria());
	}

	@Test
	public void testGetKolaboratzaileak() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals("Antonio Romero Monge y Rafael Ruiz", album.getKolaboratzaileak());
	}

	@Test
	public void testSetKolaboratzaileak() {
		Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		album.setKolaboratzaileak("KAOTIKO");
		assertEquals("KAOTIKO", album.getKolaboratzaileak());
	}

	@Test
    public void testGetAlbumIraupena() {
        Time iraupena = new Time(1);
        Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
                "Antonio Romero Monge y Rafael Ruiz", iraupena);

        assertEquals(iraupena, album.getAlbumIraupena());
    

    }

    @Test
    public void testSetAlbumIraupena() {
        Time iraupena = new Time(1);

        Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
                "Antonio Romero Monge y Rafael Ruiz", null);

        album.setAlbumIraupena(iraupena);
        assertEquals(iraupena, album.getAlbumIraupena());
    }

	@Test
	public void testEquals() {
		Album album1 = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		Album album2 = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertEquals(album1, album2);
	}

	@Test
	public void testEqualsF() {
		Album album1 = new Album("Album_id1", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		Album album2 = new Album("Album_id2", "Los del Rio Aniversario", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		assertNotEquals(album1, album2);
	}

	@Test
	public void testToString() {
		Album album = new Album("Album_id1", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio",
				"Antonio Romero Monge y Rafael Ruiz", null);
		String expectedToString = "Album [id=Album_id1, izenburua=Los del Rio Grandes Exitos, argitaratzea=null, abestiKopurua=10, generoa=POP, idMusikaria=Id_DelRio, kolaboratzaileak=Antonio Romero Monge y Rafael Ruiz, albumIraupena=null]";
		assertEquals(expectedToString, album.toString());
	}

}
