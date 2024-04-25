
package Modelo;

import java.sql.Date;

import java.util.Objects;

/**
 * 
 * Klasea Album bat ordezkatzen du, musika album bat bezala.
 * 
 */

public class Album {

	protected String id;

	protected String abesti_izena;

	protected Date argitaratzea;

	protected int abestiKopurua;

	protected String Kolaboratzaile;

	protected Double iraupena;

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

	public Album(String id, String abesti_izena, Date argitaratzea, int AbestiKopurua, String Kolaboratzaile,
			Double iraupena) {

		this.id = id;

		this.abesti_izena = abesti_izena;

		this.argitaratzea = argitaratzea;

		this.abestiKopurua = AbestiKopurua;

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

	public String getId() {

		return id;

	}

	/**
	 * 
	 * Album-aren identifikazioa ezartzen du.
	 * 
	 * @param id Album-aren identifikazioa.
	 * 
	 */

	public void setId(String id) {

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

		return abestiKopurua;

	}

	/**
	 * 
	 * Album-aren abesti kopurua ezartzen du.
	 * 
	 * @param abestiKopurua Album-aren abesti kopurua.
	 * 
	 */

	public void setAbestiKopurua(int abestiKopurua) {

		abestiKopurua = abestiKopurua;

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

				+ ", AbestiKopurua=" + abestiKopurua + ", Kolaboratzaile=" + Kolaboratzaile + ", iraupena=" + iraupena

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

		return abestiKopurua == other.abestiKopurua && Objects.equals(Kolaboratzaile, other.Kolaboratzaile)

				&& Objects.equals(abesti_izena, other.abesti_izena) && Objects.equals(argitaratzea, other.argitaratzea)

				&& id == other.id && Objects.equals(iraupena, other.iraupena);

	}

}