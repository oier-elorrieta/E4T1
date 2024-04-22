package Modelo;

import java.util.Objects;

public abstract class Artista {
protected int id;
protected String izena;
protected String info;

//---------------- ERAIKITZAILEA ---------------- // 

public Artista(int id, String izena, String info) {
	this.id=id;
	this.izena=izena;
	this.info=info;
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

public String getInfo() {
	return info;
}

public void setInfo(String info) {
	this.info = info;
}

//---------------- ToString ---------------- //


//---------------- EQUALS ---------------- //

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Artista other = (Artista) obj;
	return id == other.id && Objects.equals(info, other.info) && Objects.equals(izena, other.izena);
}


}

