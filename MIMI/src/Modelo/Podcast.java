package Modelo;

import java.util.Objects;

/**
 * 
 * Klasea Podcast bat ordezkatzen du, audio-fitxategiak elkarrizketak edo
 * tarteketen bidez.
 * 
 */

public class Podcast {

	private int id;

	private String podcast_izena;

	private String Kolaboratzaile;

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

	public Podcast(int id, String podcast_izena, String kolaboratzaile, Double iraupena) {

		super();

		this.id = id;

		this.podcast_izena = podcast_izena;

		Kolaboratzaile = kolaboratzaile;

		this.iraupena = iraupena;

	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPodcast_izena() {
		return podcast_izena;
	}

	public void setPodcast_izena(String podcast_izena) {
		this.podcast_izena = podcast_izena;
	}

	public String getKolaboratzaile() {
		return Kolaboratzaile;
	}

	public void setKolaboratzaile(String kolaboratzaile) {
		Kolaboratzaile = kolaboratzaile;
	}

	public Double getIraupena() {
		return iraupena;
	}

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

		return "Podcast [id=" + id + ", podcast_izena=" + podcast_izena + ", Kolaboratzaile=" + Kolaboratzaile

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

		return Objects.equals(Kolaboratzaile, other.Kolaboratzaile) && id == other.id

				&& Objects.equals(iraupena, other.iraupena) && Objects.equals(podcast_izena, other.podcast_izena);

	}

}