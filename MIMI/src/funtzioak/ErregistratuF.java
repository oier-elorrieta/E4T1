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
	 * ErregistratuF klasea da, bezero berri bat sortzeko erabiliko da. Klase honek
	 * bezeroaren informazioa gordetzen du. Bezeroaren izena, abizena, erabiltzaile
	 *
	 * @param premiumMuga
	 * @param txtIzena
	 * @param txtAbizena
	 * @param txtErabiltzaile
	 * @param pasahitzaPass
	 * @param selectDate
	 * @param txtErregistro
	 * @param AukeratuHizkuntza
	 * @param berriaPre
	 * @return
	 */
	public static PremiumBezeroa PremiumErosi(LocalDate premiumMuga, String txtIzena, String txtAbizena,
			String txtErabiltzaile, String pasahitzaPass, Date selectDate, String txtErregistro,
			String AukeratuHizkuntza, PremiumBezeroa berriaPre) {

		DateFuntzioak.LocalDatetoString(premiumMuga);
		berriaPre.setIzena(txtIzena);
		berriaPre.setAbizena(txtAbizena);
		berriaPre.setErabiltzaile(txtErabiltzaile);
		berriaPre.setPasahitza(pasahitzaPass);
		berriaPre.setJaioData(DateFuntzioak.DatetoString(selectDate));
		berriaPre.setErregisData(txtErregistro);
		berriaPre.setPremiumMuga(DateFuntzioak.LocalDatetoString(premiumMuga));
		berriaPre.setMota("premium");
		berriaPre.setHizkuntza(AukeratuHizkuntza);



		return berriaPre;

	}

	/**
	 * sortuBezeroa metodoa bezero berri bat sortzeko erabiliko da. Klase honek
	 * bezeroaren informazioa gordetzen du. Bezeroaren izena, abizena, erabiltzaile
	 * @param erregistroBezero
	 * @param txtIzena
	 * @param txtAbizena
	 * @param txtErabiltzaile
	 * @param pasahitzaPass
	 * @param selectDate
	 * @param txtErregistro
	 * @param AukeratuHizkuntza
	 * @return
	 */
	public static FreeBezero sortuBezeroa(FreeBezero erregistroBezero, String txtIzena, String txtAbizena,
			String txtErabiltzaile, String pasahitzaPass, java.util.Date selectDate,
			String txtErregistro, String AukeratuHizkuntza) {

		erregistroBezero.setIzena(txtIzena);
		erregistroBezero.setAbizena(txtAbizena);
		erregistroBezero.setErabiltzaile(txtErabiltzaile);
		erregistroBezero.setPasahitza(pasahitzaPass);
		erregistroBezero.setJaioData(DateFuntzioak.DatetoString(selectDate));
		erregistroBezero.setErregisData(txtErregistro);
		erregistroBezero.setHizkuntza(AukeratuHizkuntza);
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
	public static boolean PasahitzaBerdina(String pasahitzaPass, String konfirmarPass) throws PasahitzaEzBerdina {

		boolean pasahitzaOK = false;

		
		
			if (pasahitzaPass.equals(konfirmarPass)) {
				pasahitzaOK = true;
			} else {
				throw new PasahitzaEzBerdina();
			}

		

		return pasahitzaOK;
	}

}
