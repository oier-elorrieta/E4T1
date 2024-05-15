package Modelo;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;


/**
 * Audio klasea abstraktoa da eta MIMI aplikazioaren audio objektuak
 * errepresentatzen ditu. Audio objektuak id, iraupena, irudia eta mota
 * propietateak ditu.
 */
public abstract class Audio {
	
	protected String id;
	protected Time iraupena;
	protected Blob irudia;
	protected Mota mota;

	/**
	 * Audio klasearen Mota-en enum-a. Mota podcast edo abestia izan daiteke.
	 */
	public enum Mota {
		podcast, abestia
	}

	/**
	 * Audio klasearen eraikitzailea. Id, iraupena, irudia eta mota
	 * propietateak jasoko ditu.
	 * 
	 * @param id      audioaren identifikadorea
	 * @param iraupena audioaren iraupena
	 * @param irudia  audioaren irudia
	 * @param mota    audioaren mota
	 */
	public Audio(String id, Time iraupena, Blob irudia, Mota mota) {
		this.id = id;
		this.iraupena = iraupena;
		this.irudia = irudia;
		this.mota = mota;
	}

	/**
	 * Audio klasearen eraikitzailea.
	 */
	public Audio() {
		
	}

	/**
	 * Audio objektuaren id-a itzultzen du.
	 * 
	 * @return audioaren identifikadorea
	 */
	public String getId() {
		return id;
	}

	/**
	 * Audio objektuaren id-a ezartzen du.
	 * 
	 * @param id audioaren identifikadorea
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Audio objektuaren iraupena itzultzen du.
	 * 
	 * @return audioaren iraupena
	 */
	public Time getIraupena() {
		return iraupena;
	}

	/**
	 * Audio objektuaren iraupena ezartzen du.
	 * 
	 * @param iraupena audioaren iraupena
	 */
	public void setIraupena(Time iraupena) {
		this.iraupena = iraupena;
	}

	/**
	 * Audio objektuaren irudia itzultzen du.
	 * 
	 * @return audioaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Audio objektuaren irudia ezartzen du.
	 * 
	 * @param irudia audioaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Audio objektuaren mota itzultzen du.
	 * 
	 * @return audioaren mota
	 */
	public Mota getMota() {
		return mota;
	}

	/**
	 * Audio objektuaren mota ezartzen du.
	 * 
	 * @param mota audioaren mota
	 */
	public void setMota(Mota mota) {
		this.mota = mota;
	}

	/**
	 * Audio objektuaren String errepresentazioa itzultzen du.
	 * 
	 * @return audioaren String errepresentazioa
	 */
	@Override
	public String toString() {
		return "Audio [id=" + id + ", iraupena=" + iraupena + ", irudia=" + irudia
				+ ", mota=" + mota + "]";
	}

	/**
	 * Audio objektuak beste objektu batekin berdinak diren ala ez
	 * adierazten du.
	 * 
	 * @param obj konparatzeko objektua
	 * @return objektuak berdinak diren ala ez
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return Objects.equals(id, other.id) && Objects.equals(iraupena, other.iraupena)
				&& Objects.equals(irudia, other.irudia)
				&& mota == other.mota;
	}
}
