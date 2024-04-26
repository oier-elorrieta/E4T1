
package Modelo;

import com.mysql.cj.jdbc.Blob;

public class Podcaster extends Artista{
	
	//---------------- ERAIKITZAILEA ---------------- // 

	public Podcaster(String id, String izena, String info, Blob irudia) {
		super(id, izena, info, irudia);
	}

	//---------------- ToString ---------------- //
	
	@Override
	public String toString() {
		return "Podcaster [id=" + id + ", izena=" + izena + ", info=" + info + "]";
	}

	
}

