package Testak.Dao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DatuBasea.AbeslariDao;
import DatuBasea.Konexioa;
import Modelo.Abeslari;
import Modelo.Album;
import Modelo.Playlist;
import funtzioak.DateFuntzioak;
import funtzioak.ErregistratuF;
import Modelo.Abeslari.Mota;

public class AbeslariDaoTest {



	@Test
	public void testMusikariakAtera() {
	    List<Abeslari> musikariak = AbeslariDao.musikariakAtera();
	    
	    assertNotNull(musikariak);
	    assertFalse(musikariak.isEmpty());
	    	assertEquals(musikariak.get(0).getIzena(), "Bulego");
	    	assertEquals(musikariak.get(0).getId(),"BUL01");
	    	assertEquals(musikariak.get(0).getInfo(),"Euskal Herriko indie musika eskenean kokatzen den taldea da. Bere soinuak elektronika eta rock estiloak uztartzen ditu, eta testuak gehienbat euskara daude. Bulegok, gai sozial eta politikoak jorratzen dituen kantak egin ditu, eta musika-ekintza sozial gisa ere jarduten du, bertako komunitatearekin harreman zuzenak izateko ahaleginak eginez. Taldeak modernotasun eta tradizioak batzen ditu, eta euren musikak euskal kulturaren eta gizarteko errealitatearen ardatz nagusiak hartzen ditu.");
	    	assertEquals(musikariak.get(0).getMota(),Mota.Taldea);
	}

	@Test
	public void testMusikariarenAlbum() {
	    List<Album> album = AbeslariDao.musikariarenAlbum("Estopa");	
	  String argitaratze = "2022-01-01";
    
	    assertNotNull(album);
	    assertFalse(album.isEmpty());

	    
	    assertEquals(album.get(0).getId(), "ESAL1");
	    assertEquals(album.get(0).getIzenburua(), "Estopía");
	    assertEquals(album.get(0).getArgitaratzea(),DateFuntzioak.StringtoDate(argitaratze));
	    assertEquals(album.get(0).getAbestiKopurua(), 0);
	    assertEquals(album.get(0).getGeneroa(), "Pop/Rock");
	    assertEquals(album.get(0).getIdMusikaria(), "EST01");
	    assertEquals(album.get(0).getKolaboratzaileak(), "Pole eta Fito Fitipaldi");
	    assertEquals(album.get(0).getAlbumIraupena(), album.get(0).getAlbumIraupena());
	    }
	
	@Test
	public void testAbeslariaAteraPlayList() {
		Playlist plDao = new Playlist();
		plDao.setId("PL003");
		ArrayList<String> abeslaria = new ArrayList<String>();
		abeslaria = AbeslariDao.AbeslariaAteraPlayList(plDao);
		assertEquals(abeslaria.get(0), "Eminem");
	}
	
}