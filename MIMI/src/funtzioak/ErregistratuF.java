package funtzioak;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;

public class ErregistratuF {


	/**
	 * Metodo honek emandako data java.util.Date motatik String motara bihurtzen du.
	 *
	 * @param selectDate data bihurtu nahi den java.util.Date objektua
	 * @return String motako data
	 */
	public static String DatetoString(java.util.Date selectDate) {

		selectDate = Calendar.getInstance().getTime();

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
		Date dData = null;
		try {
			Date parsed = dateFormat.parse(data);
			dData = new Date(parsed.getTime());
		} catch (Exception e) {
			System.err.println("Error occurred" + e.getMessage());
		}

		return dData;
	}

	/**
	 * PremiumBezeroa klasea erabiltzailearen premium bezeroaren informazioa
	 * gordetzeko erabiliko da. Klase honek erabiltzailearen izena, abizena,
	 * erabiltzaile-izena, pasahitza, jaio-data, erregistro-data, premium mugak,
	 * mota eta hizkuntza gordetzen ditu.
	 * 
	 * @param erregistroBezero  FreeBezero objektua, erregistroa gordetzeko
	 *                          erabiltzen dena
	 * @param txtIzena          JTextField objektua, bezeroaren izena jaso ahal
	 *                          izateko
	 * @param txtAbizena        JTextField objektua, bezeroaren abizena jaso ahal
	 *                          izateko
	 * @param txtErabiltzaile   JTextField objektua, bezeroaren erabiltzaile izena
	 *                          jaso ahal izateko
	 * @param pasahitzaPass     JPasswordField objektua, bezeroaren pasahitza jaso
	 *                          ahal izateko
	 * @param selectDate        java.util.Date objektua, bezeroaren jaiotze data
	 *                          jaso ahal izateko
	 * @param txtErregistro     JTextField objektua, bezeroaren erregistro data jaso
	 *                          ahal izateko
	 * @param AukeratuHizkuntza JTextField objektua, bezeroaren aukeratutako
	 *                          hizkuntza jaso ahal izateko
	 * @return sortutako PremiumBezero objektua
	 */
	@SuppressWarnings("deprecation")
	public static PremiumBezeroa PremiumErosi(String premiumMuga, JTextField txtIzena, JTextField txtAbizena,
			JTextField txtErabiltzaile, JPasswordField pasahitzaPass, Date selectDate, JTextField txtErregistro,
			JTextField AukeratuHizkuntza, PremiumBezeroa berriaPre) {

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
	 * @param erregistroBezero  FreeBezero objektua, erregistroa gordetzeko
	 *                          erabiltzen dena
	 * @param txtIzena          JTextField objektua, bezeroaren izena jaso ahal
	 *                          izateko
	 * @param txtAbizena        JTextField objektua, bezeroaren abizena jaso ahal
	 *                          izateko
	 * @param txtErabiltzaile   JTextField objektua, bezeroaren erabiltzaile izena
	 *                          jaso ahal izateko
	 * @param pasahitzaPass     JPasswordField objektua, bezeroaren pasahitza jaso
	 *                          ahal izateko
	 * @param selectDate        java.util.Date objektua, bezeroaren jaiotze data
	 *                          jaso ahal izateko
	 * @param txtErregistro     JTextField objektua, bezeroaren erregistro data jaso
	 *                          ahal izateko
	 * @param AukeratuHizkuntza JTextField objektua, bezeroaren aukeratutako
	 *                          hizkuntza jaso ahal izateko
	 * @return sortutako FreeBezero objektua
	 */
	@SuppressWarnings("deprecation")
	public static FreeBezero sortuBezeroa(FreeBezero erregistroBezero, JTextField txtIzena, JTextField txtAbizena,
			JTextField txtErabiltzaile, JPasswordField pasahitzaPass, java.util.Date selectDate,
			JTextField txtErregistro, JTextField AukeratuHizkuntza) {

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
	
	public static boolean PasahitzaBedina(JPasswordField pasahitzaPass, JPasswordField konfirmarPass) {
		
		boolean pasahitzaOK = false;
		    
		    String pasahitza = new String(pasahitzaPass.getPassword());
		    String konfirmazioa = new String(konfirmarPass.getPassword());
		    
		    if (pasahitza.equals(konfirmazioa)) {
		        pasahitzaOK = true;
		    } else {
		        JOptionPane.showMessageDialog(null, "Pasahitza ez da berdina");
		        konfirmarPass.setText("");
		    }
		    
		return pasahitzaOK;
}
	
	public static String LocalDatetoString () {
		
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = localDate.format(formatter);
		
		
		return formattedString;
		
	}
}
