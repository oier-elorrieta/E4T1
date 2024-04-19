package Modelo;

import java.sql.Date;
import java.util.Objects;

public class Podcast {
	private int id;
	private String podcast_izena;
	private String Kolaboratzaile;
	private Double iraupena;
	
	//---------------- ERAIKITZAILEA ---------------- // 

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

	//---------------- ToString ---------------- //

	@Override
	public String toString() {
		return "Podcast [id=" + id + ", podcast_izena=" + podcast_izena + ", Kolaboratzaile=" + Kolaboratzaile
				+ ", iraupena=" + iraupena + "]";
	}

	//---------------- EQUALS ---------------- //
	
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
