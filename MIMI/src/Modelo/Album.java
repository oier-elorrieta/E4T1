
package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 * 
 * Klasea Album bat ordezkatzen du, musika album bat bezala.
 * 
 */

public class Album {

	private String id;

	private String izenburua;

	private Date argitaratzea;

	private int abestiKopurua;

	private String generoa;
	
	private String idMusikaria;

	private String kolaboratzaileak;

	
	
	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * 
	 * Albumaren eraikitzailea.
	 *
	 * @param id 					 Albumaren identifikazioa.
	 * @param izenburua 			 Albumaren izenburua.
	 * @param argitaratzea  		 Albuma argitaratu den data.	
	 * @param AbestiKopurua 		 Albuman dauden abesti kopurua.
	 * @param generoa 				 Albumaren generoa.
	 * @param idMusikaria   		 Albumaren idMusikaria.
	 * @param kolaboratzaileak       Albumaren kolaboratzaileak minututan.
	 * 
	 */

	public Album(String id, String izenburua, Date argitaratzea, int AbestiKopurua, String generoa, String idMusikaria ,
			String kolaboratzaileak) {

		this.id = id;

		this.izenburua = izenburua;

		this.argitaratzea = argitaratzea;

		this.abestiKopurua = AbestiKopurua;

		this.generoa = generoa;

		this.idMusikaria = idMusikaria;
		
		this.kolaboratzaileak = kolaboratzaileak;

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
	 * Album-aren idMusikaria lortzen du.
	 * 
	 * @return Album-aren idMusikaria.
	 * 
	 */

	public String getIdMusikaria() {

		return idMusikaria;

	}

	/**
	 * 
	 * Album-aren idMusikaria ezartzen du.
	 * 
	 * @param Album-aren idMusikaria.
	 * 
	 */

	public void setIdMusikaria(String idMusikaria) {

		this.idMusikaria = idMusikaria;

	}

	/**
	 * 
	 * Album-aren izena lortzen du.
	 * 
	 * @return Album-aren izena.
	 * 
	 */

	public String getIzenburua() {

		return izenburua;

	}

	/**
	 * 
	 * Album-aren izena ezartzen du.
	 * 
	 * @param abesti_izena Album-aren izena.
	 * 
	 */

	public void setAbesti_izena(String izenburua) {

		this.izenburua = izenburua;

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

		this.abestiKopurua = abestiKopurua;

	}

	/**
	 * 
	 * Album-ean parte hartzen duten kolaboratzailearen izena lortzen du.
	 * 
	 * @return Album-ean parte hartzen duten kolaboratzailearen izena.
	 * 
	 */

	public String getGeneroa() {

		return generoa;

	}

	/**
	 * 
	 * Album-ean parte hartzen duten kolaboratzailearen izena ezartzen du.
	 * 
	 * @param kolaboratzaile Album-ean parte hartzen duten kolaboratzailearen izena.
	 * 
	 */

	public void setGeneroa(String generoa) {

		this.generoa = generoa;

	}

	/**
	 * 
	 * Album-aren kolaboratzaileak lortzen du.
	 * 
	 * @return Album-aren kolaboratzaileak .
	 * 
	 */

	public String getKolaboratzaileak() {

		return kolaboratzaileak;

	}

	/**
	 * 
	 * Album-aren kolaboratzaileak  ezartzen du.
	 * 
	 * @param kolaboratzaileak Album-aren kolaboratzaileak .
	 * 
	 */

	public void setKolaboratzaileak(String kolaboratzaileak) {

		this.kolaboratzaileak = kolaboratzaileak;

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

		return "Album [id=" + id + ", izenburua=" + izenburua + ", argitaratzea=" + argitaratzea

				+ ", AbestiKopurua=" + abestiKopurua + ", generoa=" + generoa + ", kolaboratzaileak=" + kolaboratzaileak

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
		return abestiKopurua == other.abestiKopurua && Objects.equals(argitaratzea, other.argitaratzea)
				&& Objects.equals(generoa, other.generoa) && Objects.equals(id, other.id)
				&& Objects.equals(idMusikaria, other.idMusikaria) && Objects.equals(izenburua, other.izenburua)
				&& Objects.equals(kolaboratzaileak, other.kolaboratzaileak);
	}
	
}