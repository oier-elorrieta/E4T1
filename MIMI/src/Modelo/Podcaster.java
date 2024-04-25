
package Modelo;

public class Podcaster extends Artista{
	
	//---------------- ERAIKITZAILEA ---------------- // 

	public Podcaster(String id, String izena, String info) {
		super(id, izena, info);
	}

	//---------------- ToString ---------------- //
	
	@Override
	public String toString() {
		return "Podcaster [id=" + id + ", izena=" + izena + ", info=" + info + "]";
	}

	
}

