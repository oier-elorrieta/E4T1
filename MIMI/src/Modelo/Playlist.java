package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
private int id;
private String izena;
private ArrayList<Abesti> AbestiList;

//---------------- ERAIKITZAILEA ---------------- // 

public Playlist(int id, String izena, ArrayList<Abesti> abestiList) {
	super();
	this.id = id;
	this.izena = izena;
	AbestiList = abestiList;
}

// ---------------- GETTERS eta SETTERS ---------------- //

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

public ArrayList<Abesti> getAbestiList() {
	return AbestiList;
}

public void setAbestiList(ArrayList<Abesti> abestiList) {
	AbestiList = abestiList;
}

//---------------- ToString ---------------- //

@Override
public String toString() {
	return "Playlist [id=" + id + ", izena=" + izena + ", AbestiList=" + AbestiList + "]";
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
	Playlist other = (Playlist) obj;
	return Objects.equals(AbestiList, other.AbestiList) && id == other.id && Objects.equals(izena, other.izena);
}


}
