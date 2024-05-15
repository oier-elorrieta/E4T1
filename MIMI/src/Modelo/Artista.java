package Modelo;

import java.util.Arrays;
import java.util.Objects;

import java.sql.Blob;
import java.sql.SQLException;

/**
 * 
 * Klase abstraktua da, Artista bat ordezkatzen duena.
 * 
 */

public abstract class Artista {

    protected String id;
    protected String izena;
    protected String info;
    protected Blob irudia;

    public Artista() {

    }

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

    public Artista(String id, String izena, String info, Blob irudia) {

        this.id = id;

        this.izena = izena;

        this.info = info;

        this.irudia = irudia;

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

    public String getId() {

        return id;

    }

    /**
     * Artistaaren identifikazioa ezartzen du.
     * 
     * @param id Berria izango den artistaaren identifikazioa.
     */

    public void setId(String id) {

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

    /**
     * Artistaaren irudia itzultzen du.
     * 
     * @return
     */
    public Blob getIrudia() {
        return irudia;
    }

    /**
     * Artistaaren irudia ezartzen du.
     * 
     * @param irudia
     */
    public void setIrudia(Blob irudia) {
        this.irudia = irudia;
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
		return Objects.equals(id, other.id) && Objects.equals(info, other.info) && Objects.equals(izena, other.izena);
	}
    


}