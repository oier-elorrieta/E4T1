<<<<<<< HEAD
package Modelo;

import java.sql.Date;
import java.util.Objects;

public class Album {
	private int id;
	private String abesti_izena;
	private Date argitaratzea;
	private int AbestiKopurua;
	private String Kolaboratzaile;
	private Double iraupena;

//---------------- ERAIKITZAILEA ---------------- // 

	public Album(int id, String abesti_izena, Date argitaratzea, int abestiKopurua, String kolaboratzaile,
			Double iraupena) {
		this.id = id;
		this.abesti_izena = abesti_izena;
		this.argitaratzea = argitaratzea;
		AbestiKopurua = abestiKopurua;
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

	public String getAbesti_izena() {
		return abesti_izena;
	}

	public void setAbesti_izena(String abesti_izena) {
		this.abesti_izena = abesti_izena;
	}

	public Date getArgitaratzea() {
		return argitaratzea;
	}

	public void setArgitaratzea(Date argitaratzea) {
		this.argitaratzea = argitaratzea;
	}

	public int getAbestiKopurua() {
		return AbestiKopurua;
	}

	public void setAbestiKopurua(int abestiKopurua) {
		AbestiKopurua = abestiKopurua;
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
		return "Album [id=" + id + ", abesti_izena=" + abesti_izena + ", argitaratzea=" + argitaratzea
				+ ", AbestiKopurua=" + AbestiKopurua + ", Kolaboratzaile=" + Kolaboratzaile + ", iraupena=" + iraupena
				+ "]";
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
		Album other = (Album) obj;
		return AbestiKopurua == other.AbestiKopurua && Objects.equals(Kolaboratzaile, other.Kolaboratzaile)
				&& Objects.equals(abesti_izena, other.abesti_izena) && Objects.equals(argitaratzea, other.argitaratzea)
				&& id == other.id && Objects.equals(iraupena, other.iraupena);
	}

}
=======
package Modelo;

import java.sql.Date;

import java.util.Objects;

/**
 * 
 * Klasea Album bat ordezkatzen du, musika album bat bezala.
 * 
 */

public class Album {

	private int id;

	private String abesti_izena;

	private Date argitaratzea;

	private int AbestiKopurua;

	private String Kolaboratzaile;

	private Double iraupena;

	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * 
	 * Albumaren eraikitzailea.
	 *
	 * @param id 			Albumaren identifikazioa.
	 * 
	 * @param abesti_izena   Abestien izena.
	 * 
	 * @param argitaratzea   Albuma argitaratu den data.	
	 * @param AbestiKopurua  Albuman dauden abesti kopurua.
	 * @param Kolaboratzaile Kolaboratzailearen izena.
	 * @param iraupena       Albumaren iraupena minututan.
	 * 
	 */

	public Album(int id, String abesti_izena, Date argitaratzea, int AbestiKopurua, String Kolaboratzaile,
			Double iraupena) {

		this.id = id;

		this.abesti_izena = abesti_izena;

		this.argitaratzea = argitaratzea;

		this.AbestiKopurua = AbestiKopurua;

		this.Kolaboratzaile = Kolaboratzaile;

		this.iraupena = iraupena;

	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	/**
	 * 
	 * Album-aren identifikazioa lortzen du.
	 * 
	 * @return Album-aren identifikazioa.
	 * 
	 */

	public int getId() {

		return id;

	}

	/**
	 * 
	 * Album-aren identifikazioa ezartzen du.
	 * 
	 * @param id Album-aren identifikazioa.
	 * 
	 */

	public void setId(int id) {

		this.id = id;

	}

	/**
	 * 
	 * Album-aren abestiaren izena lortzen du.
	 * 
	 * @return Album-aren abestiaren izena.
	 * 
	 */

	public String getAbesti_izena() {

		return abesti_izena;

	}

	/**
	 * 
	 * Album-aren abestiaren izena ezartzen du.
	 * 
	 * @param abesti_izena Album-aren abestiaren izena.
	 * 
	 */

	public void setAbesti_izena(String abesti_izena) {

		this.abesti_izena = abesti_izena;

	}

	/**
	 * 
	 * Album-aren argitaratze data lortzen du.
	 * 
	 * @return Album-aren argitaratze data.
	 * 
	 */

	public Date getArgitaratzea() {

		return argitaratzea;

	}

	/**
	 * 
	 * Album-aren argitaratze data ezartzen du.
	 * 
	 * @param argitaratzea Album-aren argitaratze data.
	 * 
	 */

	public void setArgitaratzea(Date argitaratzea) {

		this.argitaratzea = argitaratzea;

	}

	/**
	 * 
	 * Album-aren abesti kopurua lortzen du.
	 * 
	 * @return Album-aren abesti kopurua.
	 * 
	 */

	public int getAbestiKopurua() {

		return AbestiKopurua;

	}

	/**
	 * 
	 * Album-aren abesti kopurua ezartzen du.
	 * 
	 * @param abestiKopurua Album-aren abesti kopurua.
	 * 
	 */

	public void setAbestiKopurua(int abestiKopurua) {

		AbestiKopurua = abestiKopurua;

	}

	/**
	 * 
	 * Album-ean parte hartzen duten kolaboratzailearen izena lortzen du.
	 * 
	 * @return Album-ean parte hartzen duten kolaboratzailearen izena.
	 * 
	 */

	public String getKolaboratzaile() {

		return Kolaboratzaile;

	}

	/**
	 * 
	 * Album-ean parte hartzen duten kolaboratzailearen izena ezartzen du.
	 * 
	 * @param kolaboratzaile Album-ean parte hartzen duten kolaboratzailearen izena.
	 * 
	 */

	public void setKolaboratzaile(String kolaboratzaile) {

		Kolaboratzaile = kolaboratzaile;

	}

	/**
	 * 
	 * Album-aren iraupena minututan lortzen du.
	 * 
	 * @return Album-aren iraupena minututan.
	 * 
	 */

	public Double getIraupena() {

		return iraupena;

	}

	/**
	 * 
	 * Album-aren iraupena minututan ezartzen du.
	 * 
	 * @param iraupena Album-aren iraupena minututan.
	 * 
	 */

	public void setIraupena(Double iraupena) {

		this.iraupena = iraupena;

	}

	// ---------------- ToString ---------------- //

	/**
	 * 
	 * Albumaren errepresentazio katea itzultzen du
	 * 
	 * @return Albumaren errepresentazio katea.
	 * 
	 */

	@Override

	public String toString() {

		return "Album [id=" + id + ", abesti_izena=" + abesti_izena + ", argitaratzea=" + argitaratzea

				+ ", AbestiKopurua=" + AbestiKopurua + ", Kolaboratzaile=" + Kolaboratzaile + ", iraupena=" + iraupena

				+ "]";

	}

	// ---------------- EQUALS ---------------- //

	/**
	 * 
	 * Bi albumak berdinak ala ez aztertzen du.
	 *
	 * @param obj Beste album bat.
	 * 
	 * @return Bi albumak berdinak badira true, bestela false.
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

		Album other = (Album) obj;

		return AbestiKopurua == other.AbestiKopurua && Objects.equals(Kolaboratzaile, other.Kolaboratzaile)

				&& Objects.equals(abesti_izena, other.abesti_izena) && Objects.equals(argitaratzea, other.argitaratzea)

				&& id == other.id && Objects.equals(iraupena, other.iraupena);

	}

}
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917