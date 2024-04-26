
package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasea PremiumBezeroa bat ordezkatzen du, premium-bezero gisa.
 */
public class PremiumBezeroa extends Bezero {

	private String premiumMuga;

	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * PremiumBezeroa-aren eraikitzailea.
	 *
	 * @param id           Bezeroaren identifikazioa.
	 * @param izena        Bezeroaren izena.
	 * @param abizena      Bezeroaren abizena.
	 * @param erabiltzaile Bezeroaren erabiltzaile izena.
	 * @param pasahitza    Bezeroaren pasahitza.
	 * @param jaioData     Bezeroaren jaioData.
	 * @param erregisData  Bezeroaren erregisData.
	 * @param playArray    Bezeroaren abesti lista.
	 * @param premiumMuga  Premium bezeroaren premium muga data.
	 */
	public PremiumBezeroa(String id, String izena, String abizena, String erabiltzaile, String pasahitza, String jaioData,
			String erregisData, ArrayList<Abesti> playArray, String PremiumMuga, String mota, String Hizkuntza ) {
		super(id, izena, abizena, erabiltzaile, pasahitza, jaioData, erregisData, playArray, mota, Hizkuntza);

		this.premiumMuga = PremiumMuga;
	}
	
	

	// ---------------- GETTERS eta SETTERS ---------------- //

	public PremiumBezeroa() {
		
	}



	/**
	 * Premium bezeroaren premium muga data itzultzen du.
	 *
	 * @return Premium bezeroaren premium muga data.
	 */
	public String getPremiumMuga() {
		return premiumMuga;
	}

	/**
	 * Premium bezeroaren premium muga data ezartzen du.
	 *
	 * @param premiumMuga Premium bezeroaren premium muga data.
	 */
	public void setPremiumMuga(String premiumMuga) {
		this.premiumMuga = premiumMuga;
	}

	// ---------------- ToString ---------------- //

	/**
	 * PremiumBezeroa-aren errepresentazio katea itzultzen du.
	 *
	 * @return PremiumBezeroa-aren errepresentazio katea.
	 */
	@Override
	public String toString() {
		return super.toString() + "premiumMuga=" + premiumMuga + "]";
	}

	// ---------------- EQUALS ---------------- //

	/**
	 * Bi premium bezeroak berdinak ala ez aztertzen du.
	 *
	 * @param obj Beste premium bezero bat.
	 * @return Bi premium bezeroak berdinak badira true, bestela false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumBezeroa other = (PremiumBezeroa) obj;
		return Objects.equals(premiumMuga, other.premiumMuga);
	}

}

