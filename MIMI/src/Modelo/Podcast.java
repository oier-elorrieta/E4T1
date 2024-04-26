
package Modelo;

import java.util.Objects;

/**
 * 
 * Klasea Podcast bat ordezkatzen du, audio-fitxategiak elkarrizketak edo
 * tarteketen bidez.
 * 
 */

public class Podcast {

	private String id;

	private String podcast_izena;

	private String kolaboratzaile;

	private Double iraupena;

	// ---------------- ERAIKITZAILEA ---------------- //

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

	public Podcast(String id, String podcast_izena, String kolaboratzaile, Double iraupena) {

		super();

		this.id = id;

		this.podcast_izena = podcast_izena;

		this.kolaboratzaile = kolaboratzaile;

		this.iraupena = iraupena;

	}

    // ---------------- GETTERS eta SETTERS ---------------- //

    /**
     * Podcast-aren identifikazioa lortzen du.
     *
     * @return Podcast-aren identifikazioa.
     */
    public String getId() {
        return id;
    }

    /**
     * Podcast-aren identifikazioa ezartzen du.
     *
     * @param id Podcast-aren identifikazioa.
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * Podcast-aren iraupena minututan lortzen du.
     *
     * @return Podcast-aren iraupena minututan.
     */
    public Double getIraupena() {
        return iraupena;
    }

    /**
     * Podcast-aren iraupena minututan ezartzen du.
     *
     * @param iraupena Podcast-aren iraupena minututan.
     */
    public void setIraupena(Double iraupena) {
        this.iraupena = iraupena;
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

		return "Podcast [id=" + id + ", podcast_izena=" + podcast_izena + ", kolaboratzaile=" + kolaboratzaile

				+ ", iraupena=" + iraupena + "]";

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

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Podcast other = (Podcast) obj;

		return Objects.equals(kolaboratzaile, other.kolaboratzaile) && id == other.id

				&& Objects.equals(iraupena, other.iraupena) && Objects.equals(podcast_izena, other.podcast_izena);

	}

}

