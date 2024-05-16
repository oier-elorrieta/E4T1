package Testak.Funtzio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;
import Salbuespenak.PasahitzaEzBerdina;
import funtzioak.DateFuntzioak;
import funtzioak.ErregistratuF;

public class ErregistratuFuntzioTest {
    private PremiumBezeroa berriaPre;
    private FreeBezero erregistroBezero;
     
    @Before
    public void setUp() {
        erregistroBezero = new FreeBezero();
        berriaPre = new PremiumBezeroa();
    }
    
    @Test
    public void testSortuBezeroa() {
        String txtIzena = "Iker";
        String txtAbizena = "Cortes";
        String txtErabiltzaile = "icor";
        String pasahitzaPass = "123";
        Date selectDate = DateFuntzioak.StringtoDate("2020-01-16"); 
        String txtErregistro = "2024-01-01";
        String AukeratuHizkuntza = "Euskara";
        
        FreeBezero resultFree = ErregistratuF.sortuBezeroa(erregistroBezero, txtIzena, txtAbizena, txtErabiltzaile, pasahitzaPass, selectDate, txtErregistro, AukeratuHizkuntza);
        
        assertEquals(txtIzena, resultFree.getIzena());
        assertEquals(txtAbizena, resultFree.getAbizena());
        assertEquals(txtErabiltzaile, resultFree.getErabiltzaile());
        assertEquals(pasahitzaPass, resultFree.getPasahitza());
        assertEquals("2020-01-16", resultFree.getJaioData());
        assertEquals(txtErregistro, resultFree.getErregisData());
        assertEquals(AukeratuHizkuntza, resultFree.getHizkuntza());
        assertEquals("free", resultFree.getMota());
    }

    @Test
    public void testPremiumErosi() {
        String Izena = "Martin";
        String Abizena = "Martin";
        String Erabiltzaile = "marmar";
        String pasahitza = "123";
        Date jaioData = DateFuntzioak.StringtoDate("1995-05-20");
        String Erregistro = "2024-05-16";
        String Hizkuntza = "Euskara";
        LocalDate premiumMuga = LocalDate.of(2025, 5, 16);
        
        PremiumBezeroa resultPrem = ErregistratuF.PremiumErosi(premiumMuga, Izena, Abizena, Erabiltzaile, pasahitza, jaioData, Erregistro, Hizkuntza, berriaPre);
        
        assertEquals(Izena, resultPrem.getIzena());
        assertEquals(Abizena, resultPrem.getAbizena());
        assertEquals(Erabiltzaile, resultPrem.getErabiltzaile());
        assertEquals(pasahitza, resultPrem.getPasahitza());
        assertEquals("1995-05-20", resultPrem.getJaioData());
        assertEquals(Erregistro, resultPrem.getErregisData());
        assertEquals("2025-05-16", resultPrem.getPremiumMuga());
        assertEquals(Hizkuntza, resultPrem.getHizkuntza());
        assertEquals("premium", resultPrem.getMota());
    }
    
    @Test
    public void testPasahitzaBerdina_True() {
        String pasahitzaPass = "123";
        String konfirmarPass = "123";

        try {
            boolean result = ErregistratuF.PasahitzaBerdina(pasahitzaPass, konfirmarPass);
            assertTrue(result);
        } catch (PasahitzaEzBerdina e) {
    
        }
    }

    @Test
    public void testPasahitzaBerdina_False() {
        String pasahitzaPass = "123";
        String konfirmarPass = "456";
        boolean result = true;
        try {
            result = ErregistratuF.PasahitzaBerdina(pasahitzaPass, konfirmarPass);
        } catch (PasahitzaEzBerdina e) {
            assertTrue(result);
        }
    }
}
