package Modelo;

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

	/**
	 * 
	 * Abeslariaren klaseko eraikitzailea.
	 * 
	 * @param id    Abeslariren IDa.
	 * @param izena Abeslariren izena.
	 * @param info  Abeslariri buruzko informazioa.
	 * @param mota  Abeslariren mota (Bakarlari edo Taldea).
	 * 
	 */

	public Abeslari(int id, String izena, String info, Mota mota) {

		super(id, izena, info);

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

		return "Abeslari [id=" + id + ", izena=" + izena + ", info=" + info + ", mota=" + mota + "]";
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
