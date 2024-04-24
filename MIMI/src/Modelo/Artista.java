
package Modelo;

import java.util.Objects;

/**
 * 
 * Klase abstraktua da, Artista bat ordezkatzen duena.
 * 
 */

public abstract class Artista {
	
	protected int id;
	protected String izena;
	protected String info;

	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * 
	 * Artistaaren eraikitzailea.
	 *
	 * @param id    Artistaaren identifikazioa.
	 * @param izena Artistaaren izena.
	 * @param info  Artistaaren informazioa.
	 * 
	 */

	public Artista(int id, String izena, String info) {

		this.id = id;

		this.izena = izena;

		this.info = info;

	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	/**
	 * 
	 * Artistaaren identifikazioa itzultzen du.
	 * 
	 * 
	 * 
	 * @return Artistaaren identifikazioa.
	 * 
	 */

	public int getId() {

		return id;

	}

	/**
	 * Artistaaren identifikazioa ezartzen du.
	 * 
	 * @param id Berria izango den artistaaren identifikazioa.
	 */

	public void setId(int id) {

		this.id = id;

	}

	/**
	 * Artistaaren izena itzultzen du.
	 * 
	 * @return Artistaaren izena.
	 */

	public String getIzena() {

		return izena;

	}

	/**
	 * Artistaaren izena ezartzen du.
	 * 
	 * @param izena Berria izango den artistaaren izena.
	 */

	public void setIzena(String izena) {

		this.izena = izena;

	}

	/**
	 * Artistaaren informazioa itzultzen du.
	 * 
	 * @return Artistaaren informazioa.
	 */

	public String getInfo() {

		return info;

	}

	/**
	 * Artistaaren informazioa ezartzen du.
	 * 
	 * @param info Berria izango den artistaaren informazioa.
	 */

	public void setInfo(String info) {

		this.info = info;

	}

	// ---------------- ToString ---------------- //

	/**
	 * Artistaaren errepresentazio katea itzultzen du.
	 * 
	 * @return Artistaaren errepresentazio katea.
	 */

	@Override

	public String toString() {

		return "[id=" + id + ", izena=" + izena + ", info=" + info + "]";

	}

	// ---------------- EQUALS ---------------- //

	/**
	 * Bi artistak berdinak ala ez aztertzen du.
	 * 
	 * @param obj Beste artista bat.
	 * @return Bi artistak berdinak badira true, bestela false.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return id == other.id && Objects.equals(info, other.info) && Objects.equals(izena, other.izena);

	}

}
