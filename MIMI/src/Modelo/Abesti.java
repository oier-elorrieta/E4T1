package Modelo;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;



	public class Abesti extends Audio{

	private String id_abesti;

	private String abestiIzena;

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
	
	
	
	

	// ---------------- GETTERS eta SETTERS ---------------- //


	public Abesti(String id, Time iraupena, Blob irudia, Mota mota, String id_abesti, String abestiIzena, String albumIzena, String kolaboratzaile) {
		super(id, iraupena, irudia, mota);
		this.id_abesti = id_abesti;
		this.abestiIzena = abestiIzena;
		this.albumIzena = albumIzena;
		this.kolaboratzaile = kolaboratzaile;
		
		
	}


	public Abesti() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 * Id-a hartzen du.
	 * 
	 * @return Id-a.
	 * 
	 */

	public String getid_abesti() {

		return id_abesti;

	}

	

	/**
	 * 
	 * Id-a ezartzen du.
	 * 
	 * @param id Berria izango den id-a.
	 * 
	 */

	public void setid_abesti(String id_abesti) {

		this.id_abesti = id_abesti;

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

		return super.toString() + "Abesti [id=" + id_abesti + ", abestiIzena=" + abestiIzena  + "albumIzena="
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abesti other = (Abesti) obj;
		return Objects.equals(abestiIzena, other.abestiIzena) && Objects.equals(albumIzena, other.albumIzena)
				&& Objects.equals(id_abesti, other.id_abesti) && Objects.equals(kolaboratzaile, other.kolaboratzaile);
	}

	
}
