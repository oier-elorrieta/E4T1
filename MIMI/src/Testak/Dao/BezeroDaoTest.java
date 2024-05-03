package Testak.Dao;

import org.junit.Test;

import DatuBasea.BezeroDao;

import static org.junit.Assert.*;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Modelo.Bezero;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class BezeroDaoTest {

    @Test
    public void testLoginKomprobatu() throws SQLException {
        JTextField textFieldErabiltzailea = new JTextField("testUser");
        JPasswordField passwordFieldPasahitza = new JPasswordField("testPassword");

        BezeroDao.LoginKomprobatu(textFieldErabiltzailea, passwordFieldPasahitza);

        
    }

    @Test
    public void testHizkuntzaAtera() {
        String[] hizkuntzak = BezeroDao.HizkuntzaAtera();

        
    }

    @Test
    public void testHartuIdBezero() throws SQLException {
        String id = BezeroDao.hartuIdBezero();

        
    }

    @Test
    public void testInsertFree() throws SQLException {
        FreeBezero erregistroBezero = new FreeBezero();

        BezeroDao.InsertFree(erregistroBezero);

        
    }

    @Test
    public void testInsertPremium() throws SQLException {
        PremiumBezeroa berriaPre = new PremiumBezeroa();

        BezeroDao.InsertPremium(berriaPre);

        
    }

    @Test
    public void testBezeroUpdate() throws SQLException {
        Bezero bz = new Bezero();
        JTextField textIzena = new JTextField("John");
        JTextField textAbizena = new JTextField("Doe");
        JTextField textErabiltzalea = new JTextField("johndoe");
        JPasswordField textPasahitza = new JPasswordField("password");

        BezeroDao.BezeroUpdate(bz, textIzena, textAbizena, textErabiltzalea, textPasahitza);

        
    }
}