package Modelo;

import java.util.Objects;

import com.mysql.cj.jdbc.Blob;

/**
 * 
 * Abeslari bat ordezkatzen duen klasea, artista motako bat da.
 * 
 */

public class Abeslari extends Artista {

	/**
	 * 
	 * Abeslariren mota, Bakarlari edo Taldea izan daitekeena.
	 * 
	 */

	protected Mota mota;

	// ---------------- ERAIKITZAILEA ---------------- //

	public Abeslari(){

	}
	
	
	/**
	 * 
	 * Abeslariaren klaseko eraikitzailea.
	 * 
	 * @param id    Abeslariren IDa.
	 * @param izena Abeslariren izsena.
	 * @param info  Abeslariri buruzko informazioa.
	 * @param mota  Abeslariren mota (Bakarlari edo Taldea).
	 * 
	 */

	public Abeslari(String id, String izena, String info, Blob irudia, Mota mota) {

		super(id, izena, info, irudia);

		this.mota = mota;

	}

	/**
	 * 
	 * Bakarlari edo Taldea mota duen abeslariren enuma.
	 * 
	 */

	public enum Mota {

		Bakarlari, Taldea;

	}

	/**
	 * 
	 * Abeslariren mota itzultzen du.
	 * 
	 * @return Abeslariren mota.
	 * 
	 */

	public Mota getMota() {

		return mota;

	}

	/**
	 * 
	 * Abeslariren mota ezartzen du.
	 * 
	 * @param mota Abeslariren berria izango den mota.
	 * 
	 */

	public void setMota(Mota mota) {

		this.mota = mota;

	}

	/**
	 * 
	 * Abeslariren errepresentazio katea itzultzen du.
	 * 
	 * @return Abeslariren errepresentazio kate bat.
	 * 
	 */

	@Override
	public String toString() {

		return super.toString() + "Mota = " + mota;
	}







	/**
	 * 
	 * Abeslariren objektua beste objektu batekin alderatzen duena, berdinak diren
	 * ala ez aztertzen du.
	 * 
	 * @param obj Abeslariri buruzko beste objektua.
	 * @return Objektuak berdinak badira true, bestela false.
	 * 
	 */

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
