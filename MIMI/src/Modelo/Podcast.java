
package Modelo;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;

/**
 * 
 * Klasea Podcast bat ordezkatzen du, audio-fitxategiak elkarrizketak edo
 * tarteketen bidez.
 * 
 */

public class Podcast extends Audio {

	private String id_podcast;

	private String podcast_izena;

	private String kolaboratzaile;

	// ---------------- ERAIKITZAILEA ---------------- //

	public Podcast(String id, Time iraupena, Blob irudia, Mota mota, String id_podcast,String podcast_izena,String kolaboratzaile ) {
		super(id, iraupena, irudia, mota);
		this.id_podcast = id_podcast;
		this.podcast_izena = podcast_izena;
		this.kolaboratzaile = kolaboratzaile;
	}

	/**
	 * 
	 * Podcast-aren eraikitzailea.
	 * 
	 * 
	 * 
	 * @param id             Podcast-aren identifikazioa.
	 * 
	 * @param podcast_izena  Podcast-aren izena.
	 * 
	 * @param kolaboratzaile Kolaboratzailearen izena.
	 * 
	 * @param iraupena       Podcast-aren iraupena minututan.
	 * 
	 */

	// ---------------- GETTERS eta SETTERS ---------------- //

	

	public Podcast() {
		super();
	}

	/**
	 * Podcast-aren identifikazioa lortzen du.
	 *
	 * @return Podcast-aren identifikazioa.
	 */
	public String getId() {
		return id_podcast;
	}

	/**
	 * Podcast-aren identifikazioa ezartzen du.
	 *
	 * @param id Podcast-aren identifikazioa.
	 */
	public void setId(String id) {
		this.id_podcast = id;
	}

	/**
	 * Podcast-aren izena lortzen du.
	 *
	 * @return Podcast-aren izena.
	 */
	public String getPodcast_izena() {
		return podcast_izena;
	}

	/**
	 * Podcast-aren izena ezartzen du.
	 *
	 * @param podcast_izena Podcast-aren izena.
	 */
	public void setPodcast_izena(String podcast_izena) {
		this.podcast_izena = podcast_izena;
	}

	/**
	 * Kolaboratzailearen izena lortzen du.
	 *
	 * @return Kolaboratzailearen izena.
	 */
	public String getKolaboratzaile() {
		return kolaboratzaile;
	}

	/**
	 * Kolaboratzailearen izena ezartzen du.
	 *
	 * @param kolaboratzaile Kolaboratzailearen izena.
	 */
	public void setKolaboratzaile(String kolaboratzaile) {
		this.kolaboratzaile = kolaboratzaile;
	}


	// ---------------- ToString ---------------- //

	/**
	 * 
	 * Podcast-aren errepresentazio katea itzultzen du.
	 * 
	 * @return Podcast-aren errepresentazio katea.
	 * 
	 */

	@Override

	public String toString() {

		return super.toString() + "Podcast [id=" + id_podcast + ", podcast_izena=" + podcast_izena + ", kolaboratzaile=" + kolaboratzaile
+ "]";

	}


	// ---------------- EQUALS ---------------- //

	/**
	 * 
	 * Bi podcast-ak berdinak ala ez aztertzen du.
	 * 
	 * 
	 * 
	 * @param obj Beste podcast bat.
	 * 
	 * @return Bi podcast-ak berdinak badira true, bestela false.
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
		Podcast other = (Podcast) obj;
		return Objects.equals(id_podcast, other.id_podcast) && Objects.equals(kolaboratzaile, other.kolaboratzaile)
				&& Objects.equals(podcast_izena, other.podcast_izena);
	}

}
