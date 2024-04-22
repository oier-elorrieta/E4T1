package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Bezero {
	protected int id;
	protected String izena;
	protected String abizena;
	protected String erabiltzaile;
	protected String pasahitza;
	protected Date jaioData;
	protected Date erregisData;
	protected ArrayList<Abesti> playArray;
	protected String mota;

//---------------- ERAIKITZAILEA ---------------- // 
	public Bezero() {
		
	}

	public Bezero(int id, String izena, String abizena, String erabiltzaile, String pasahitza, Date jaioData,
			Date erregisData, ArrayList<Abesti> playArray, String mota) {
		
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.erabiltzaile = erabiltzaile;
		this.pasahitza = pasahitza;
		this.jaioData = jaioData;
		this.erregisData = erregisData;
		this.playArray = playArray;
		this.mota = mota;
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

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getErabiltzaile() {
		return erabiltzaile;
	}
	
	public String getMota() {
		return mota;
	}

	public void setErabiltzaile(String erabiltzaile) {
		this.erabiltzaile = erabiltzaile;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public Date getJaioData() {
		return jaioData;
	}

	public void setJaioData(Date jaioData) {
		this.jaioData = jaioData;
	}

	public Date getErregisData() {
		return erregisData;
	}

	public void setErregisData(Date erregisData) {
		this.erregisData = erregisData;
	}
	
	public void setMota(String mota) {
		this.mota = mota;
	}

	public ArrayList<Abesti> getPlayArray() {
		return playArray;
	}

	public void setPlayArray(ArrayList<Abesti> playArray) {
		this.playArray = playArray;
	}

	//---------------- ToString ---------------- //
	
	@Override
	public String toString() {
		return "Bezero [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", erabiltzaile=" + erabiltzaile
				+ ", pasahitza=" + pasahitza + ", jaioData=" + jaioData + ", erregisData=" + erregisData
				+ ", playArray=" + playArray + ", mota " + mota + "]";
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
		Bezero other = (Bezero) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzaile, other.erabiltzaile)
				&& Objects.equals(erregisData, other.erregisData) && id == other.id
				&& Objects.equals(izena, other.izena) && Objects.equals(jaioData, other.jaioData)
				&& Objects.equals(pasahitza, other.pasahitza) && Objects.equals(playArray, other.playArray);
	}

	
}
