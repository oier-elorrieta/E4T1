package Testak.Pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Modelo.Abeslari;
import Modelo.Abeslari.Mota;
import Modelo.Podcaster;

public class ArtistaTest {

// ------------------------------- PODCASTER ---------------------------------------- //
    @Test
    public void testGetIdp() {
    Podcaster podcaster = new Podcaster("1", "podcaster1", "Informazioa", null);
        assertEquals("1", podcaster.getId());
    }

    @Test
    public void testSetIdp() {
        Podcaster podcaster = new Podcaster("0", null, null, null);
        podcaster.setId("2");
        assertEquals("2", podcaster.getId());
    }

    @Test
    public void testGetIzenap() {
    Podcaster podcaster = new Podcaster("1", "podcaster1", "Informazioa", null);
        assertEquals("podcaster1", podcaster.getIzena());
    }

    @Test
    public void testSetIzenap() {
    Podcaster podcaster = new Podcaster("0", null, null, null);
        podcaster.setIzena("podcaster2");
        assertEquals("podcaster2", podcaster.getIzena());
    }

    @Test
    public void testGetInfop() {
    Podcaster podcaster = new Podcaster("1", "podcaster1", "Informazioa", null);
        assertEquals("Informazioa", podcaster.getInfo());
    }

    @Test
    public void testSetInfop() {
    Podcaster podcaster = new Podcaster("0", null, null, null);
        podcaster.setInfo("Beste informazio bat");
        assertEquals("Beste informazio bat", podcaster.getInfo());
    }

    @Test
    public void testToStringp() {
    Podcaster podcaster = new Podcaster("1", "podcaster1", "Informazioa", null);
        String expectedToStringp = "Podcaster [id=1, izena=podcaster1, info=Informazioa]";
        assertEquals(expectedToStringp, podcaster.toString());
    }

    @Test
    public void testEqualsp() {
    Podcaster podcaster1 = new Podcaster("1", "podcaster1", "Informazioa", null);
    Podcaster podcaster2 = new Podcaster("1", "podcaster1", "Informazioa", null);
   
        assertTrue(podcaster1.equals(podcaster2));
    
    }
    
    @Test
    public void testEqualspFalse() {
    	Podcaster podcaster1 = new Podcaster("1", "podcaster1", "Informazioa", null);
        Podcaster podcaster3 = new Podcaster("2", "podcaster2", "Beste informazio bat", null);
        assertFalse(podcaster1.equals(podcaster3));
    }
// ------------------------------- ABESLARIA ---------------------------------------- //

    @Test
    public void testGetIda() {
    Abeslari abeslari = new Abeslari("1", "abeslari1", "Informazioa", null, null);
        assertEquals("1", abeslari.getId());
    }

    @Test
    public void testSetIda() {
    Abeslari abeslari = new Abeslari("0", null, null, null, null);
        abeslari.setId("2");
        assertEquals("2", abeslari.getId());
    }

    @Test
    public void testGetIzenaa() {
    Abeslari abeslari = new Abeslari("1", "abeslari1", "Informazioa", null, null);
        assertEquals("abeslari1", abeslari.getIzena());
    }

    @Test
    public void testSetIzenaa() {
    Abeslari abeslari = new Abeslari("0", null, null, null, null);
    abeslari.setIzena("abeslari2");
        assertEquals("abeslari2", abeslari.getIzena());
    }

    @Test
    public void testGetInfoa() {
    Abeslari abeslari = new Abeslari("1", "abeslari1", "Informazioa", null, null);
        assertEquals("Informazioa", abeslari.getInfo());
    }

    @Test
    public void testSetInfoa() {
    Abeslari abeslari = new Abeslari("0", null, null, null, null);
    abeslari.setInfo("Beste informazio bat");
        assertEquals("Beste informazio bat", abeslari.getInfo());
    }
    


        @Test
        public void testGetMota() {
            Abeslari abeslari = new Abeslari("0", null, null, null, Mota.Bakarlari);
            assertEquals(Mota.Bakarlari, abeslari.getMota());
        }

        @Test
        public void testSetMota() {
            Abeslari abeslari = new Abeslari("0", null, null, null, null);
            abeslari.setMota(Mota.Taldea);
            assertEquals(Mota.Taldea, abeslari.getMota());
        
    }


    @Test
    public void testToStringA() {
        Abeslari abeslari = new Abeslari("1", "abeslari1", "Informazioa", null, null);
        
        String expectedToStringa = "[id=1, izena=abeslari1, info=Informazioa]Mota = null";
        assertEquals(expectedToStringa, abeslari.toString());
    }

    @Test
    public void testEqualsa() {
    Abeslari abeslari1 = new Abeslari("1", "abeslari1", "Informazioa", null, null);
    Abeslari abeslari2 = new Abeslari("1", "abeslari1", "Informazioa", null, null);
   
        assertTrue(abeslari1.equals(abeslari2));
       
    }
    
    @Test
    public void testEqualsaF() {
    	 Abeslari abeslari1 = new Abeslari("1", "abeslari1", "Informazioa", null, null);
    	 Abeslari abeslari3 = new Abeslari("2", "abeslari2", "Beste informazio bat", null, null);
    	 assertFalse(abeslari1.equals(abeslari3));
    }
 

}