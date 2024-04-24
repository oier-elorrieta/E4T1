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
import Bista.MenuaBista;
import Modelo.Bezero;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class ErregistratuF {

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
	

	public static String DatetoString( java.util.Date selectDate) {

		selectDate =  Calendar.getInstance().getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		String strDate = dateFormat.format(selectDate);
		
		return strDate;

	}
	
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
	
	
	
	
}
