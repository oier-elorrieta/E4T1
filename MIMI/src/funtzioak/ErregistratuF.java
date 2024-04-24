package funtzioak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Bista.ErregistroBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Modelo.Bezero;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class ErregistratuF {

	/**
	 * HizkuntzaAtera metodoa erabiliko da datu basean dauden hizkuntzen zerrenda ateratzeko.
	 *
	 * @return Hizkuntzen zerrenda, String array moduan.
	 */
	public static String[] HizkuntzaAtera() {
		String[] hiz = null;
		int cont = 0;
		try (Connection con = Konexioa.konexioa()) {
			String countSql = "SELECT COUNT(*) AS total FROM Hizkuntza";
			try (PreparedStatement sta = con.prepareStatement(countSql)) {
				try (ResultSet res = sta.executeQuery()) {
					if (res.next()) {
						cont = res.getInt("total");
					}
				}
			}

			hiz = new String[cont];

			String kontsulta = "SELECT idHizkuntza FROM Hizkuntza";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					int index = 0;
					while (rs.next()) {
						String id = rs.getString("idHizkuntza");

						hiz[index] = id;
						index++;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hiz;
	}

	/**
	 * Hartu bezeroaren azken id-a eta sortu berriaren id-a.
	 * 
	 * @return Bezeroaren azken id-a + 1-ekoa formatu egokian (BZ001, BZ002, ...)
	 * @throws SQLException SQL errore bat gertatzen bada
	 */
	public static String hartuIdBezero() throws SQLException {
		
		String idberria = "";
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select idBezeroa from Bezeroa order by idBezeroa desc limit 1";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {
					
					while (rs.next()) {

						String id = rs.getString("idBezeroa");
	                    
						String zenbakiaStr = id.substring(2);
				        int zbk = Integer.parseInt(zenbakiaStr);
				        
				        zbk++;
				        
				        idberria = "BZ" + String.format("%03d", zbk); 
				       
				    }
					
				}
				
				}
		}catch (SQLException e) {
		    System.out.println(e.getMessage()); 
		}
		return idberria;
		
	}
		/**
		 * ErregistratuF klasean dagoen InsertFree metodoa.
		 * Erregistro bat sartzen du Bezeroa taulan.
		 *
		 * @param erregistroBezero Erregistroa sartu nahi den FreeBezero objektua.
		 * @throws SQLException SQL errore bat gertatzen bada.
		 */
		public static void InsertFree (FreeBezero erregistroBezero) throws SQLException	{
			
			erregistroBezero.setId(hartuIdBezero());
			
			try (Connection con = Konexioa.konexioa()) {

			String insert = "insert into Bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, erabiltzailea, pasahitza, jaiotzedata, Erregistrodata, mota) values (?,?,?,?,?,?,?,?,?)";

			try {
			    PreparedStatement preparedStatement = con.prepareStatement(insert);
			    preparedStatement.setString(1, erregistroBezero.getId());
			    preparedStatement.setString(2, erregistroBezero.getIzena());
			    preparedStatement.setString(3, erregistroBezero.getAbizena());
			    preparedStatement.setString(4, erregistroBezero.getHizkuntza()); 
			    preparedStatement.setString(5, erregistroBezero.getErabiltzaile());
			    preparedStatement.setString(6, erregistroBezero.getPasahitza());
			    preparedStatement.setDate(7,  new java.sql.Date (StringtoDate(erregistroBezero.getJaioData()).getTime()));
			    preparedStatement.setDate(8,  new java.sql.Date (StringtoDate(erregistroBezero.getErregisData()).getTime())); 
			    preparedStatement.setString(9, erregistroBezero.getMota());

			    preparedStatement.executeUpdate();
			    
			    preparedStatement.close();
			   
			    con.close();

			    System.out.println("Erregistroa ondo egina");

			} catch (SQLException e) {
			    System.out.println(e.getMessage());
			}
		}
	}
	
	
/**
 * Metodo honek PremiumBezeroa objektua hartu eta datu-basean sartzen du.
 * 
 * @param berriaPre PremiumBezeroa objektua, sartu nahi den bezeroaren datuekin.
 * @throws SQLException SQL errore bat gertatzen bada.
 */
public static void InsertPremium (PremiumBezeroa berriaPre) throws SQLException {
	
	berriaPre.setId(hartuIdBezero());
	
	try (Connection con = Konexioa.konexioa()) {

	String insert = "insert into Bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, erabiltzailea, pasahitza, jaiotzedata, Erregistrodata, mota) values (?,?,?,?,?,?,?,?,?)";

	try {
	    PreparedStatement preparedStatement = con.prepareStatement(insert);
	    preparedStatement.setString(1, berriaPre.getId());
	    preparedStatement.setString(2, berriaPre.getIzena());
	    preparedStatement.setString(3, berriaPre.getAbizena());
	    preparedStatement.setString(4, berriaPre.getHizkuntza()); 
	    preparedStatement.setString(5, berriaPre.getErabiltzaile());
	    preparedStatement.setString(6, berriaPre.getPasahitza());
	    preparedStatement.setDate(7,  new java.sql.Date (StringtoDate(berriaPre.getJaioData()).getTime()));
	    preparedStatement.setDate(8,  new java.sql.Date (StringtoDate(berriaPre.getErregisData()).getTime())); 
	    preparedStatement.setString(9, berriaPre.getMota());

	    preparedStatement.executeUpdate();
	    
	   

	    System.out.println("Erregistroa ondo egina");

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	}
	
	PremiumTabala (berriaPre);
}
	
	/**
	 * Metodo honek PremiumBezeroa objektua jasotzen du eta datu basean premium taulan sartzen du.
	 *
	 * @param berriaPre PremiumBezeroa objektua, sartu nahi den bezeroaren datuekin.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public static void PremiumTabala (PremiumBezeroa berriaPre) throws SQLException {
		
		try (Connection con = Konexioa.konexioa()) {
			
	String Premiumtabla = "insert into premium (IdBezeroa,iraungitzedata) values (?,?)";

	try {
	    PreparedStatement preparedStatement = con.prepareStatement(Premiumtabla);
	    preparedStatement.setString(1, berriaPre.getId());
	    preparedStatement.setDate(2,  new java.sql.Date (StringtoDate(berriaPre.getPremiumMuga()).getTime()));
	    
	    preparedStatement.executeUpdate();
	    
}catch (SQLException e) {
    System.out.println(e.getMessage());
}
	
	}	
	
}
	

	/**
	 * Metodo honek emandako data java.util.Date motatik String motara bihurtzen du.
	 *
	 * @param selectDate data bihurtu nahi den java.util.Date objektua
	 * @return String motako data
	 */
	public static String DatetoString( java.util.Date selectDate) {

		selectDate =  Calendar.getInstance().getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		String strDate = dateFormat.format(selectDate);
		
		return strDate;

	}
	
	/**
	 * Konvertitzen du emandako datak String-etik Date objektuera.
	 *
	 * @param data String formatuko data bat
	 * @return datak Date objektu bezala konbertituta
	 */
	public static Date StringtoDate(String data) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dData=null;
			try {
			    Date parsed = dateFormat.parse(data);
			    dData = new Date(parsed.getTime());
			} catch(Exception e) {
			    System.err.println("Error occurred"+ e.getMessage());
			}
			
			return dData;
	}
	
	
	/**
	 * PremiumBezeroa klasea erabiltzailearen premium bezeroaren informazioa gordetzeko erabiliko da.
	 * Klase honek erabiltzailearen izena, abizena, erabiltzaile-izena, pasahitza, jaio-data, erregistro-data,
	 * premium mugak, mota eta hizkuntza gordetzen ditu.
	 * @param erregistroBezero FreeBezero objektua, erregistroa gordetzeko erabiltzen dena
	 * @param txtIzena JTextField objektua, bezeroaren izena jaso ahal izateko
	 * @param txtAbizena JTextField objektua, bezeroaren abizena jaso ahal izateko
	 * @param txtErabiltzaile JTextField objektua, bezeroaren erabiltzaile izena jaso ahal izateko
	 * @param pasahitzaPass JPasswordField objektua, bezeroaren pasahitza jaso ahal izateko
	 * @param selectDate java.util.Date objektua, bezeroaren jaiotze data jaso ahal izateko
	 * @param txtErregistro JTextField objektua, bezeroaren erregistro data jaso ahal izateko
	 * @param AukeratuHizkuntza JTextField objektua, bezeroaren aukeratutako hizkuntza jaso ahal izateko
	 * @return sortutako PremiumBezero objektua
	 */
	public static PremiumBezeroa PremiumErosi(String premiumMuga, JTextField txtIzena, JTextField txtAbizena, JTextField txtErabiltzaile, JPasswordField pasahitzaPass, Date selectDate, JTextField txtErregistro, JTextField AukeratuHizkuntza, PremiumBezeroa berriaPre) {
				
		
		berriaPre.setIzena(txtIzena.getText());
		berriaPre.setAbizena(txtAbizena.getText());
		berriaPre.setErabiltzaile(txtErabiltzaile.getText());
		berriaPre.setPasahitza(pasahitzaPass.getText());
		berriaPre.setJaioData(DatetoString(selectDate));
		berriaPre.setErregisData(txtErregistro.getText());
		berriaPre.setPremiumMuga(premiumMuga);
		berriaPre.setMota("premium");
		berriaPre.setHizkuntza(AukeratuHizkuntza.getText());
		
		return berriaPre;
	}
	
	
	/**
	 * SortuBezeroa metodoa erabiltzen da FreeBezero objektua sortzeko.
	 *
	 * @param erregistroBezero FreeBezero objektua, erregistroa gordetzeko erabiltzen dena
	 * @param txtIzena JTextField objektua, bezeroaren izena jaso ahal izateko
	 * @param txtAbizena JTextField objektua, bezeroaren abizena jaso ahal izateko
	 * @param txtErabiltzaile JTextField objektua, bezeroaren erabiltzaile izena jaso ahal izateko
	 * @param pasahitzaPass JPasswordField objektua, bezeroaren pasahitza jaso ahal izateko
	 * @param selectDate java.util.Date objektua, bezeroaren jaiotze data jaso ahal izateko
	 * @param txtErregistro JTextField objektua, bezeroaren erregistro data jaso ahal izateko
	 * @param AukeratuHizkuntza JTextField objektua, bezeroaren aukeratutako hizkuntza jaso ahal izateko
	 * @return sortutako FreeBezero objektua
	 */
	public static FreeBezero sortuBezeroa (FreeBezero erregistroBezero, JTextField txtIzena, JTextField txtAbizena, JTextField txtErabiltzaile, JPasswordField pasahitzaPass, java.util.Date selectDate, JTextField txtErregistro, JTextField AukeratuHizkuntza) {
		   
		erregistroBezero.setIzena(txtIzena.getText());
        erregistroBezero.setAbizena(txtAbizena.getText());
        erregistroBezero.setErabiltzaile(txtErabiltzaile.getText());
        erregistroBezero.setPasahitza(pasahitzaPass.getText());
        erregistroBezero.setJaioData(DatetoString(selectDate));
        erregistroBezero.setErregisData(txtErregistro.getText());
        erregistroBezero.setHizkuntza(AukeratuHizkuntza.getText());
        erregistroBezero.setMota("free");
        
        return erregistroBezero;
	}
	
	public static void loginJoan() {
		
		 try {
             LoginBista frame = new LoginBista();
             frame.setVisible(true);
         } catch (Exception ex) {
             ex.printStackTrace();
         }

     }
		
	
	
	
	
	
}
