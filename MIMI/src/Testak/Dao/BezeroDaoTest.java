package Testak.Dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import DatuBasea.BezeroDao;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class BezeroDaoTest {
    
    private JTextField textFieldErabiltzailea;
    private JPasswordField passwordFieldPasahitza;
    
    @Before
    public void setUp() {
        textFieldErabiltzailea = new JTextField();
        passwordFieldPasahitza = new JPasswordField();
    }
    
    @Test
    public void testloginkonprobatuondo() throws SQLException {
        textFieldErabiltzailea.setText("erabiltzaile1");
        passwordFieldPasahitza.setText("pasahitza1");
        BezeroDao.LoginKomprobatu(textFieldErabiltzailea, passwordFieldPasahitza);
        assertTrue("Sesio bat hasi dela erakutsi behar da", JOptionPane.getFrameForComponent(null).isVisible());
    }

    @Test
    public void testloginkonprobatutxarto() throws SQLException {
        textFieldErabiltzailea.setText("erabiltzaile_okerra");
        passwordFieldPasahitza.setText("pasahitza_okerra");
        BezeroDao.LoginKomprobatu(textFieldErabiltzailea, passwordFieldPasahitza);
        assertTrue("Errore mezua erakutsi behar da", JOptionPane.getFrameForComponent(null).isVisible());
    }
    
    @Test
    public void testHizkuntzaAtera() {
        String[] hizkuntzak = BezeroDao.HizkuntzaAtera();
        assertNotNull("Hizkuntzak ezin du nulua izan", hizkuntzak);
        assertTrue("Hizkuntzak array-ak elementu gutxienez bat izan behar du", hizkuntzak.length > 0);
    }

    
    @Test
    public void testHartuIdBezero() throws SQLException {
        String id = BezeroDao.hartuIdBezero();
        assertTrue("Erabiltzailearen IDak BZxxx formatua izan behar du", id.matches("BZ\\d{3}"));
    }
    
    @Test
    public void testInsertFree() throws SQLException {
        FreeBezero berria = new FreeBezero();
        berria.setIzena("Berria");
        berria.setAbizena("Erabiltzailea");
        berria.setErabiltzaile("berria_erabiltzailea");
        berria.setPasahitza("berria_pasahitza");
        berria.setJaioData("2024-05-01");
        berria.setErregisData("2024-05-01");
        berria.setHizkuntza("eu");
        berria.setMota("free");
        BezeroDao.InsertFree(berria);
    }
    
    @Test
    public void testInsertPremium() throws SQLException {
        PremiumBezeroa berriaPremium = new PremiumBezeroa();
        berriaPremium.setIzena("Berria");
        berriaPremium.setAbizena("Premium Erabiltzailea");
        berriaPremium.setErabiltzaile("berria_premium");
        berriaPremium.setPasahitza("berria_pasahitza");
        berriaPremium.setJaioData("2005-05-09");
        berriaPremium.setErregisData("2024-05-06");
        berriaPremium.setHizkuntza("eu");
        berriaPremium.setMota("premium");
        berriaPremium.setPremiumMuga("2024-06-06");
        BezeroDao.InsertPremium(berriaPremium);
    }
    
    @Test
    public void testBezeroUpdate() throws SQLException {
        FreeBezero existitzenDena = new FreeBezero();
        existitzenDena.setId("BZ001");
        JTextField textIzena = new JTextField("IzenaBerria");
        JTextField textAbizena = new JTextField("AbizenaBerria");
        JTextField textErabiltzalea = new JTextField("ErabiltzaileBerria");
        JPasswordField textPasahitza = new JPasswordField("berria_pasahitza");

        BezeroDao.BezeroUpdate(existitzenDena, textIzena, textAbizena, textErabiltzalea, textPasahitza);

    }
}
