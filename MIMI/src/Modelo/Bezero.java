package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasea Bezero bat ordezkatzen du, erabiltzailea bezala.
 */
public class Bezero {
    protected int id;
    protected String izena;
    protected String abizena;
    protected String erabiltzaile;
    protected String pasahitza;
    protected Date jaioData;
    protected Date erregisData;
    protected ArrayList<Abesti> playArray;

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
    public Bezero(int id, String izena, String abizena, String erabiltzaile, String pasahitza, Date jaioData, Date erregisData, ArrayList<Abesti> playArray) {
        this.id = id;
        this.izena = izena;
        this.abizena = abizena;
        this.erabiltzaile = erabiltzaile;
        this.pasahitza = pasahitza;
        this.jaioData = jaioData;
        this.erregisData = erregisData;
        this.playArray = playArray;
    }

    //---------------- GETTERS eta SETTERS ---------------- //

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getErabiltzaile() {
		return erabiltzaile;
	}

	public void setErabiltzaile(String erabiltzaile) {
		this.erabiltzaile = erabiltzaile;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public Date getJaioData() {
		return jaioData;
	}

	public void setJaioData(Date jaioData) {
		this.jaioData = jaioData;
	}

	public Date getErregisData() {
		return erregisData;
	}

	public void setErregisData(Date erregisData) {
		this.erregisData = erregisData;
	}

	public ArrayList<Abesti> getPlayArray() {
		return playArray;
	}

	public void setPlayArray(ArrayList<Abesti> playArray) {
		this.playArray = playArray;
	}

    //---------------- ToString ---------------- //

    /**
     * Bezeroaren errepresentazio katea itzultzen du.
     *
     * @return Bezeroaren errepresentazio katea.
     */
    @Override
    public String toString() {
        return "Bezero [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", erabiltzaile=" + erabiltzaile + ", pasahitza=" + pasahitza + ", jaioData=" + jaioData + ", erregisData=" + erregisData + ", playArray=" + playArray + "]";
    }

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
        return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzaile, other.erabiltzaile) && Objects.equals(erregisData, other.erregisData) && id == other.id && Objects.equals(izena, other.izena) && Objects.equals(jaioData, other.jaioData) && Objects.equals(pasahitza, other.pasahitza) && Objects.equals(playArray, other.playArray);
    }
}