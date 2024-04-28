package Modelo;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;


public abstract class Audio {
	
protected String id;
protected Time iraupena;
protected Blob irudia;
protected Mota mota;


public enum Mota {
	podcast,abestia
}


public Audio(String id, Time iraupena, Blob irudia, Mota mota) {
	this.id = id;
	this.iraupena = iraupena;
	this.irudia = irudia;
	this.mota = mota;
}


public Audio() {
	
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public Time getIraupena() {
	return iraupena;
}


public void setIraupena(Time iraupena) {
	this.iraupena = iraupena;
}



public Blob getIrudia() {
	return irudia;
}


public void setIrudia(Blob irudia) {
	this.irudia = irudia;
}


public Mota getMota() {
	return mota;
}


public void setMota(Mota mota) {
	this.mota = mota;
}


@Override
public String toString() {
	return "Audio [id=" + id + ", iraupena=" + iraupena +  ", irudia=" + irudia
			+ ", mota=" + mota + "]";
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Audio other = (Audio) obj;
	return Objects.equals(id, other.id) && Objects.equals(iraupena, other.iraupena)
			&& Objects.equals(irudia, other.irudia)
			&& mota == other.mota;
}




}
