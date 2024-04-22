package funtzioak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Bista.MenuaBista;
import Modelo.Bezero;
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

	public void Insert() {

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "insert into Bezeroa (idBezero. izena, Abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, Erregistrodata, mota) values ('?','?','?','?','?','?','?',?,'?')";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						rs.getString("erabiltzailea");

						rs.getString("pasahitza");

						try {

							MenuaBista frame = new MenuaBista();

							frame.setVisible(true);

						} catch (Exception ex) {

							ex.printStackTrace();

						}

					}

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static String DatetoString(Date data) {

		data = Calendar.getInstance().getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		String strDate = dateFormat.format(data);
		
		return strDate;

	}
	
	public static Date StringtoDate(String data) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dData=null;
			try {
			    Date parsed =  dateFormat.parse(data);
			    dData = new Date(parsed.getTime());
			} catch(Exception e) {
			    System.err.println("Error occurred"+ e.getMessage());
			}
			
			return dData;
	}
	
	
	public static PremiumBezeroa PremiumErosi(Bezero erregistroBezeroa, String premiumMuga) {
				
		PremiumBezeroa berriaPre = new PremiumBezeroa();
		berriaPre.setMota("premium");
		berriaPre.setAbizena(erregistroBezeroa.getAbizena());
		berriaPre.setIzena(erregistroBezeroa.getIzena());
		berriaPre.setErabiltzaile(erregistroBezeroa.getErabiltzaile());
		berriaPre.setPasahitza(erregistroBezeroa.getPasahitza());
		berriaPre.setJaioData(erregistroBezeroa.getJaioData());
		berriaPre.setErregisData(erregistroBezeroa.getErregisData());
		berriaPre.setPremiumMuga((java.sql.Date) StringtoDate(premiumMuga));
		
		return berriaPre;
	}
	
	
	public static Bezero sortuBezeroa (Bezero erregistroBezeroa) {
		   
        erregistroBezero.setIzena(txtIzena.getText());
        erregistroBezero.setAbizena(txtAbizena.getText());
        erregistroBezero.setErabiltzaile(txtErabiltzaile.getText());
        erregistroBezero.setPasahitza(pasahitzaPass.getText());
        erregistroBezero.setJaioData(selectDate);
        erregistroBezero.setErregisData((Date)ErregistratuF.StringtoDate(txtErregistro.getText()));
        erregistroBezero.setMota("free");
	}
}
