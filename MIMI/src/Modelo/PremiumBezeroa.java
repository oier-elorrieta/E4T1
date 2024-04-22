
package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasea PremiumBezeroa bat ordezkatzen du, premium-bezero gisa.
 */
public class PremiumBezeroa extends Bezero {

	private Date PremiumMuga;

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
	 * @param PremiumMuga  Premium bezeroaren premium muga data.
	 */
	public PremiumBezeroa(int id, String izena, String abizena, String erabiltzaile, String pasahitza, Date jaioData,
			Date erregisData, ArrayList<Abesti> playArray, Date PremiumMuga) {
		super(id, izena, abizena, erabiltzaile, pasahitza, jaioData, erregisData, playArray);

		this.PremiumMuga = PremiumMuga;
	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	/**
	 * Premium bezeroaren premium muga data itzultzen du.
	 *
	 * @return Premium bezeroaren premium muga data.
	 */
	public Date getPremiumMuga() {
		return PremiumMuga;
	}

	/**
	 * Premium bezeroaren premium muga data ezartzen du.
	 *
	 * @param premiumMuga Premium bezeroaren premium muga data.
	 */
	public void setPremiumMuga(Date premiumMuga) {
		PremiumMuga = premiumMuga;
	}

	// ---------------- ToString ---------------- //

	/**
	 * PremiumBezeroa-aren errepresentazio katea itzultzen du.
	 *
	 * @return PremiumBezeroa-aren errepresentazio katea.
	 */
	@Override
	public String toString() {
		return "PremiumBezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", erabiltzaile="
				+ erabiltzaile + ", pasahitza=" + pasahitza + ", jaioData=" + jaioData + ", erregisData=" + erregisData
				+ ", playArray=" + playArray + ", PremiumMuga=" + PremiumMuga + "]";
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
		return Objects.equals(PremiumMuga, other.PremiumMuga);
	}

}

