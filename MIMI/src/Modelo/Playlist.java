
package Modelo;

import java.util.ArrayList;

import java.util.Objects;

/**
 * 
 * 
 * 
 * Klasea Playlist bat ordezkatzen du, abestiak bildu eta erreproduzitzeko.
 * 
 * 
 * 
 */

public class Playlist {

	private int id;

	private String izena;

	private ArrayList<Abesti> AbestiList;

	// ---------------- ERAIKITZAILEA ---------------- //

	/**
	 * 
	 * Playlist-aren eraikitzailea.
	 *
	 * @param id         Playlist-aren identifikazioa.
	 * @param izena      Playlist-aren izena.
	 * @param abestiList Playlist-ean dauden abestiak.
	 * 
	 */

	public Playlist(int id, String izena, ArrayList<Abesti> abestiList) {

		super();

		this.id = id;

		this.izena = izena;

		AbestiList = abestiList;

	}

	// ---------------- GETTERS eta SETTERS ---------------- //

	/**
	 * 
	 * Playlist-aren identifikazioa lortzen du.
	 * 
	 * @return Playlist-aren identifikazioa.
	 * 
	 */

	public int getId() {

		return id;

	}

	/**
	 * 
	 * Playlist-aren identifikazioa ezartzen du.
	 * 
	 * @param id Playlist-aren identifikazioa.
	 * 
	 */

	public void setId(int id) {

		this.id = id;

	}

	/**
	 * 
	 * Playlist-aren izena lortzen du.
	 * 
	 * @return Playlist-aren izena.
	 * 
	 */

	public String getIzena() {

		return izena;

	}

	/**
	 * 
	 * Playlist-aren izena ezartzen du.
	 * 
	 * @param izena Playlist-aren izena.
	 * 
	 */

	public void setIzena(String izena) {

		this.izena = izena;

	}

	/**
	 * 
	 * Playlist-ean dauden abestiak lortzen ditu.
	 * 
	 * @return Playlist-ean dauden abestiak.
	 * 
	 */

	public ArrayList<Abesti> getAbestiList() {

		return AbestiList;

	}

	/**
	 * 
	 * Playlist-ean dauden abestiak ezartzen ditu.
	 * 
	 * @param abestiList Playlist-ean dauden abestiak.
	 * 
	 */

	public void setAbestiList(ArrayList<Abesti> abestiList) {

		AbestiList = abestiList;

	}

	// ---------------- ToString ---------------- //

	/**
	 * Playlist-aren errepresentazio katea itzultzen du.
	 *
	 * @return Playlist-aren errepresentazio katea.
	 */

	@Override

	public String toString() {

		return "Playlist [id=" + id + ", izena=" + izena + ", AbestiList=" + AbestiList + "]";

	}

	// ---------------- EQUALS ---------------- //

	/**
	 * 
	 * 
	 * Bi playlistak berdinak ala ez aztertzen du.
	 * 
	 * @param obj Beste playlist bat.
	 * 
	 * @return Bi playlistak berdinak badira true, bestela false.
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

		Playlist other = (Playlist) obj;

		return Objects.equals(AbestiList, other.AbestiList) && id == other.id && Objects.equals(izena, other.izena);

	}

}

