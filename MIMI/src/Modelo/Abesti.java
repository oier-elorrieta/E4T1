package Modelo;

import java.util.Objects;

public class Abesti {
private int id;
private String abestiIzena;
private Double iraupena;
private String albumIzena;
private String kolaboratzaile;

//---------------- ERAIKITZAILEA ---------------- // 

public Abesti(int id, String abestiIzena, Double iraupena, String albumIzena, String kolaboratzaile) {
	super();
	this.id = id;
	this.abestiIzena = abestiIzena;
	this.iraupena = iraupena;
	this.albumIzena = albumIzena;
	this.kolaboratzaile = kolaboratzaile;
}

//---------------- GETTERS eta SETTERS ---------------- //

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAbestiIzena() {
	return abestiIzena;
}
public void setAbestiIzena(String abestiIzena) {
	this.abestiIzena = abestiIzena;
}
public Double getIraupena() {
	return iraupena;
}
public void setIraupena(Double iraupena) {
	this.iraupena = iraupena;
}
public String getAlbumIzena() {
	return albumIzena;
}
public void setAlbumIzena(String albumIzena) {
	this.albumIzena = albumIzena;
}
public String getKolaboratzaile() {
	return kolaboratzaile;
}
public void setKolaboratzaile(String kolaboratzaile) {
	this.kolaboratzaile = kolaboratzaile;
}

//---------------- ToString ---------------- //

@Override
public String toString() {
	return "Abesti [id=" + id + ", abestiIzena=" + abestiIzena + ", iraupena=" + iraupena + ", albumIzena=" + albumIzena
			+ ", kolaboratzaile=" + kolaboratzaile + "]";
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
	Abesti other = (Abesti) obj;
	return Objects.equals(abestiIzena, other.abestiIzena) && Objects.equals(albumIzena, other.albumIzena)
			&& id == other.id && Objects.equals(iraupena, other.iraupena)
			&& Objects.equals(kolaboratzaile, other.kolaboratzaile);
}

}
