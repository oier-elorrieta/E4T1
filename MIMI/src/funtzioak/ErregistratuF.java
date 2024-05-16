package funtzioak;

import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;
import Salbuespenak.PasahitzaEzBerdina;

public class ErregistratuF {

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
	public static PremiumBezeroa PremiumErosi(LocalDate premiumMuga, JTextField txtIzena, JTextField txtAbizena,
			JTextField txtErabiltzaile, JPasswordField pasahitzaPass, Date selectDate, JTextField txtErregistro,
			JTextField AukeratuHizkuntza, PremiumBezeroa berriaPre) {

		DateFuntzioak.LocalDatetoString(premiumMuga);

		berriaPre.setIzena(txtIzena.getText());
		berriaPre.setAbizena(txtAbizena.getText());
		berriaPre.setErabiltzaile(txtErabiltzaile.getText());
		berriaPre.setPasahitza(pasahitzaPass.getText());
		berriaPre.setJaioData(DateFuntzioak.DatetoString(selectDate));
		berriaPre.setErregisData(txtErregistro.getText());
		berriaPre.setPremiumMuga(DateFuntzioak.LocalDatetoString(premiumMuga));
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
		erregistroBezero.setJaioData(DateFuntzioak.DatetoString(selectDate));
		erregistroBezero.setErregisData(txtErregistro.getText());
		erregistroBezero.setHizkuntza(AukeratuHizkuntza.getText());
		erregistroBezero.setMota("free");

		return erregistroBezero;
	}

	/**
	 * PasahitzaBerdina metodoa bi pasahitzak berdinak diren konprobatzen du.
	 *
	 * @param pasahitzaPass    lehenengo pasahitzaren JPasswordField objektua
	 * @param konfirmarPass    bigarren pasahitzaren JPasswordField objektua
	 * @return                 true, pasahitzak berdinak diren adierazten du; false, bestela
	 * 
	 * @throws PasahitzaEzBerdina pasahitzak ezberdinak direnean 
	 * 
	 * konfirmarPass.setText("") eta pasahitzaPass.setText("") egiten dira jarritako pasahitzak kenduz
	 * 
	 * 
	 */
	public static boolean PasahitzaBerdina(JPasswordField pasahitzaPass, JPasswordField konfirmarPass) {

		boolean pasahitzaOK = false;

		String pasahitza = new String(pasahitzaPass.getPassword());
		String konfirmazioa = new String(konfirmarPass.getPassword());
		try {
			if (pasahitza.equals(konfirmazioa)) {
				pasahitzaOK = true;
			} else {
				throw new PasahitzaEzBerdina();
			}

		} catch (PasahitzaEzBerdina ex) {
			konfirmarPass.setText("");
			pasahitzaPass.setText("");
		}

		return pasahitzaOK;
	}

}
