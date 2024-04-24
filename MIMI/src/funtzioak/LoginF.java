package funtzioak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Bista.MenuaBista;

public class LoginF {
	

	/**
	 * Metodo honek erabiltzailearen sartutako erabiltzailea eta pasahitza konprobatzen du.
	 * Sartutako erabiltzailea eta pasahitza datu basean dauden erabiltzaile eta pasahitzarekin konparatzen ditu.
	 * Sartutako erabiltzailea eta pasahitza datu basean aurkitzen badira, sesioa hasi egokia dela adierazten du eta MenuaBista klasearen instantzia sortzen du.
	 * Sartutako erabiltzailea eta pasahitza datu basean ez badira aurkitzen, errore mezua erakusten du eta sartutako eremuak husten ditu.
	 *
	 * @param textFieldErabiltzailea Erabiltzailearen erabiltzailea sartzen duen JTextField objektua.
	 * @param passwordFieldPasahitza Erabiltzailearen pasahitza sartzen duen JPasswordField objektua.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	  public static void LoginKomprobatu (JTextField textFieldErabiltzailea, JPasswordField passwordFieldPasahitza ) throws SQLException {
	        boolean loginOK = false;

	    	 String erabiltzailea = textFieldErabiltzailea.getText();
	         String pasahitza = new String(passwordFieldPasahitza.getPassword());
	    	
	    	try(Connection con = Konexioa.konexioa()){
	    		String kontsulta = "select erabiltzailea,pasahitza from Bezeroa";
	    		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    while (rs.next()) {
	                        String erabiltzaileaDB = rs.getString("erabiltzailea");
	                        String pasahitzaDB = rs.getString("pasahitza");
	                        
	                        if (erabiltzailea.equals(erabiltzaileaDB) && pasahitza.equals(pasahitzaDB)) {
	                        	loginOK = true;
	                        	JOptionPane.showMessageDialog(null, "Sesioa hasi da modu egokian");
	                            try {
	                                MenuaBista frame = new MenuaBista();
	                                frame.setVisible(true);
	                                
	                                
	                            } catch (Exception ex) {
	                                ex.printStackTrace();
	                            }
	                            
	                        }
	                    } if (loginOK == false){
	                    	JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza txarto idatzi dituzu");
	                    	textFieldErabiltzailea.setText("");
	                    	passwordFieldPasahitza.setText("");
	                    
	                    }

	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	    	}
	    	
	    	
	    }

}
