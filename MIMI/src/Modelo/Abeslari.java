package Modelo;

import java.util.Objects;

public class Abeslari extends Artista{
protected Mota mota;

//---------------- ERAIKITZAILEA ---------------- // 

	public Abeslari(int id, String izena, String info, Mota mota) {
		super(id, izena, info);
		this.mota=mota;
	}
	
public enum Mota{
	Bakarlari,Taldea;
}

//---------------- GETTERS eta SETTERS ---------------- //

public Mota getMota() {
	return mota;
}
public void setMota(Mota mota) {
	this.mota = mota;
}

//---------------- ToString ---------------- //

@Override
public String toString() {
	return "Abeslari [id=" + id + ", izena=" + izena + ", info=" + info + ", mota=" + mota + "]";
}

//---------------- EQUALS ---------------- //

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Abeslari other = (Abeslari) obj;
	return mota == other.mota;
}


}
