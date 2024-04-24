package Modelo;

import java.util.ArrayList;

/**
 * Klase honek FreeBezero objektuak errepresentatzen ditu, Bezero klasearen luzapena.
 * 
 * FreeBezero klaseak Bezero klasea heredatzen du eta berezitasun batzuk gehitzen ditu.
 */
public class FreeBezero extends Bezero {

	/**
	 * FreeBezero klasearen eraikitzailea.
	 */
	public FreeBezero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * FreeBezero klasearen eraikitzailea.
	 * 
	 * @param id           bezeroaren identifikadorea
	 * @param izena        bezeroaren izena
	 * @param abizena      bezeroaren abizena
	 * @param erabiltzaile bezeroaren erabiltzaile izena
	 * @param pasahitza    bezeroaren pasahitza
	 * @param jaioData     bezeroaren jaiotze data
	 * @param erregisData  bezeroaren erregistratzeko data
	 * @param playArray    bezeroaren erreproduzitu dituen abestiak gordetzeko ArrayList-a
	 * @param mota         bezeroaren mota
	 * @param Hizkuntza    bezeroaren hizkuntza
	 */
	public FreeBezero(String id, String izena, String abizena, String erabiltzaile, String pasahitza, String jaioData,
			String erregisData, ArrayList<Abesti> playArray, String mota, String Hizkuntza) {
		super(id, izena, abizena, erabiltzaile, pasahitza, jaioData, erregisData, playArray, mota, Hizkuntza);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten duen metodoa.
	 * 
	 * @param obj konparatzeko objektua
	 * @return true, objektuak berdinak diren adierazten badu, false bestela
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	/**
	 * Objektuaren informazioa testu moduan itzultzen duen metodoa.
	 * 
	 * @return objektuaren informazioa testu moduan
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
