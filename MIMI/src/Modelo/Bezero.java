
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Klasea Bezero bat ordezkatzen du, erabiltzailea bezala.
 */
public class Bezero  {
    protected String id;
    protected String izena;
    protected String abizena;
    protected String erabiltzaile;
    protected String pasahitza;
    protected String jaioData;
    protected String erregisData;
    protected ArrayList<Playlist> playArray;
    protected String mota;
    protected String hizkuntza;

    //---------------- ERAIKITZAILEA ---------------- //

    /**
     * Bezeroaren eraikitzailea.
     *
     * @param id           Bezeroaren identifikazioa.
     * @param izena        Bezeroaren izena.
     * @param abizena      Bezeroaren abizena.
     * @param erabiltzaile Bezeroaren erabiltzaile izena.
     * @param pasahitza    Bezeroaren pasahitza.
     * @param jaioData     Bezeroaren jaioData.
     * @param erregisData  Bezeroaren erregisData.
     * @param playArray    Bezeroaren abesti lista.
     */
    public Bezero(String id, String izena, String abizena, String erabiltzaile, String pasahitza, String jaioData, String erregisData, ArrayList<Playlist> playArray, String mota, String hizkuntza) {
        this.id = id;
        this.izena = izena;
        this.abizena = abizena;
        this.erabiltzaile = erabiltzaile;
        this.pasahitza = pasahitza;
        this.jaioData = jaioData;
        this.erregisData = erregisData;
        this.playArray = playArray;
        this.mota = mota;
        this.hizkuntza = hizkuntza;
    }

    //---------------- GETTERS eta SETTERS ---------------- //

    public Bezero() {
		
	}

	/**
     * Bezeroaren identifikazioa lortzen du.
     *
     * @return Bezeroaren identifikazioa.
     */
    public String getId() {
        return id;
    }

    /**
     * Bezeroaren identifikazioa ezartzen du.
     *
     * @param id Bezeroaren identifikazioa.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Bezeroaren izena lortzen du.
     *
     * @return Bezeroaren izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Bezeroaren izena ezartzen du.
     *
     * @param izena Bezeroaren izena.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Bezeroaren abizena lortzen du.
     *
     * @return Bezeroaren abizena.
     */
    public String getAbizena() {
        return abizena;
    }

    /**
     * Bezeroaren abizena ezartzen du.
     *
     * @param abizena Bezeroaren abizena.
     */
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    /**
     * Bezeroaren erabiltzaile izena lortzen du.
     *
     * @return Bezeroaren erabiltzaile izena.
     */
    public String getErabiltzaile() {
        return erabiltzaile;
    }

    /**
     * Bezeroaren erabiltzaile izena ezartzen du.
     *
     * @param erabiltzaile Bezeroaren erabiltzaile izena.
     */
    public void setErabiltzaile(String erabiltzaile) {
        this.erabiltzaile = erabiltzaile;
    }

    /**
     * Bezeroaren pasahitza lortzen du.
     *
     * @return Bezeroaren pasahitza.
     */
    public String getPasahitza() {
        return pasahitza;
    }

    /**
     * Bezeroaren pasahitza ezartzen du.
     *
     * @param pasahitza Bezeroaren pasahitza.
     */
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    /**
     * Bezeroaren jaioData lortzen du.
     *
     * @return Bezeroaren jaioData.
     */
    public String getJaioData() {
        return jaioData;
    }

    /**
     * Bezeroaren jaioData ezartzen du.
     *
     * @param jaioData Bezeroaren jaioData.
     */
    public void setJaioData(String jaioData) {
        this.jaioData = jaioData;
    }

    /**
     * Bezeroaren erregisData lortzen du.
     *
     * @return Bezeroaren erregisData.
     */
    public String getErregisData() {
        return erregisData;
    }

    /**
     * Bezeroaren erregisData ezartzen du.
     *
     * @param erregisData Bezeroaren erregisData.
     */
    public void setErregisData(String erregisData) {
        this.erregisData = erregisData;
    }
    
    /**
     * Itzultzen du mota aldagaia.
     *
     * @return mota aldagaia
     */
    public String getMota() {
    	return mota;
    }
    
    /**
     * Metodo honek Bezeroaren mota ezartzen du.
     *
     * @param mota Bezeroaren mota
     */
    public void setMota(String mota) {
    	this.mota = mota;
    }

    /**
     * Bezeroaren abesti lista lortzen du.
     *
     * @return Bezeroaren abesti lista.
     */
    public ArrayList<Playlist> getPlayArray() {
        return playArray;
    }

    /**
     * Bezeroaren abesti lista ezartzen du.
     *
     * @param playlistArray Bezeroaren abesti lista.
     */
    public void setPlayArray(ArrayList<Playlist> playlistArray) {
        this.playArray = playlistArray;
    }
    
    /**
     * Metodo honek Bezeroaren hizkuntza itzultzen du.
     *
     * @return Bezeroaren hizkuntza
     */
    public String getHizkuntza() {
    	return hizkuntza;
    }
    
    /**
     * Hizkuntza aldagaia ezartzen du.
     * @param Hizkuntza Hizkuntza aldagaia
     */
    public void setHizkuntza (String hizkuntza) {
    	this.hizkuntza = hizkuntza;
    }

    //---------------- ToString ---------------- //
    
	@Override
	public String toString() {
		return "Bezero [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", erabiltzaile=" + erabiltzaile
				+ ", pasahitza=" + pasahitza + ", jaioData=" + jaioData + ", erregisData=" + erregisData
				+ ", playArray=" + playArray + ", mota=" + mota + ", hizkuntza=" + hizkuntza + "]";
	}

    /**
     * Bezeroaren errepresentazio katea itzultzen du.
     *
     * @return Bezeroaren errepresentazio katea.
     */
	
    //---------------- EQUALS ---------------- //

    

	/**
     * Bi bezeroak berdinak ala ez aztertzen du.
     *
     * @param obj Beste bezero bat.
     * @return Bi bezeroak berdinak badira true, bestela false.
     */
   

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bezero other = (Bezero) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzaile, other.erabiltzaile)
				&& Objects.equals(erregisData, other.erregisData) && id == other.id
				&& Objects.equals(izena, other.izena) && Objects.equals(jaioData, other.jaioData)
				&& Objects.equals(mota, other.mota) && Objects.equals(pasahitza, other.pasahitza)
				&& Objects.equals(playArray, other.playArray);
	}





	
}

