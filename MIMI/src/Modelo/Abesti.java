package Modelo;

import java.util.Objects;

	public class Abesti {

	private int id;

	private String abestiIzena;

	private Double iraupena;

	private String albumIzena;

	private String kolaboratzaile;

	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * 
	 * Abestiaren eraikitzailea.
	 * 
	 * @param id             Abestiaren identifikazioa.
	 * @param abestiIzena    Abestiaren izena.
	 * @param iraupena       Abestiaren iraupena minututan.
	 * @param albumIzena     Albumaren izena.
	 * @param kolaboratzaile Kolaboratzailearen izena.
	 * 
	 */

	public Abesti(int id, String abestiIzena, Double iraupena, String albumIzena, String kolaboratzaile) {
		this.id = id;
		this.abestiIzena = abestiIzena;
		this.iraupena = iraupena;
		this.albumIzena = albumIzena;
		this.kolaboratzaile = kolaboratzaile;

	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	/**
	 * 
	 * Id-a hartzen du.
	 * 
	 * @return Id-a.
	 * 
	 */

	public int getId() {

		return id;

	}

	/**
	 * 
	 * Id-a ezartzen du.
	 * 
	 * @param id Berria izango den id-a.
	 * 
	 */

	public void setId(int id) {

		this.id = id;

	}

	/**
	 * 
	 * Abestiaren izena itzultzen du.
	 * 
	 * @return Abestiaren izena.
	 * 
	 */

	public String getAbestiIzena() {

		return abestiIzena;

	}

	/**
	 * 
	 * Abestiaren izena ezartzen du.
	 * 
	 * @param abestiIzena Berria izango den abestiaren izena.
	 * 
	 */

	public void setAbestiIzena(String abestiIzena) {

		this.abestiIzena = abestiIzena;

	}

	/**
	 * 
	 * Abestiaren iraupena itzultzen du.
	 * 
	 * @return Abestiaren iraupena minututan.
	 * 
	 */

	public Double getIraupena() {

		return iraupena;

	}

	/**
	 * 
	 * Abestiaren iraupena ezartzen du.
	 * 
	 * @param iraupena Berria izango den abestiaren iraupena.
	 * 
	 */

	public void setIraupena(Double iraupena) {

		this.iraupena = iraupena;

	}

	/**
	 * 
	 * Albumaren izena itzultzen du.
	 * 
	 * @return Albumaren izena.
	 * 
	 */

	public String getAlbumIzena() {

		return albumIzena;

	}

	/**
	 * 
	 * Albumaren izena ezartzen du.
	 *  
	 * @param albumIzena Berria izango den albumaren izena.
	 * 
	 */

	public void setAlbumIzena(String albumIzena) {

		this.albumIzena = albumIzena;

	}

	/**
	 * 
	 * Kolaboratzailearen izena itzultzen du.
	 * 
	 * @return Kolaboratzailearen izena.
	 * 
	 */

	public String getKolaboratzaile() {

		return kolaboratzaile;

	}

	/**
	 * 
	 * Kolaboratzailearen izena ezartzen du. 
	 * 
	 * @param kolaboratzaile Berria izango den kolaboratzailearen izena.
	 * 
	 */

	public void setKolaboratzaile(String kolaboratzaile) {

		this.kolaboratzaile = kolaboratzaile;

	}

	// ---------------- ToString ---------------- //

	/**
	 * 
	 * Abestiaren errepresentazio katea itzultzen du.
	 *  
	 * @return Abestiaren errepresentazio katea.
	 * 
	 */

	@Override
	public String toString() {

		return "Abesti [id=" + id + ", abestiIzena=" + abestiIzena + ", iraupena=" + iraupena + ", albumIzena="
				+ albumIzena
				+ ", kolaboratzaile=" + kolaboratzaile + "]";
	}

	// ---------------- EQUALS ---------------- //

	/**
	 * 
	 * Bi abestiak berdinak ala ez aztertzen du.
	 * 
	 * @param obj Beste abesti bat.
	 * @return Bi abestiak berdinak badira true, bestela false.
	 * 
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abesti other = (Abesti) obj;
		return Objects.equals(abestiIzena, other.abestiIzena) && Objects.equals(albumIzena, other.albumIzena)
				&& id == other.id && Objects.equals(iraupena, other.iraupena)
				&& Objects.equals(kolaboratzaile, other.kolaboratzaile);
	}
}