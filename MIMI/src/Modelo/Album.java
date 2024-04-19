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
