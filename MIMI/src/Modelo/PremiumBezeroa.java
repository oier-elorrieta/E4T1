package Modelo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class PremiumBezeroa extends Bezero{
private Date PremiumMuga;

//---------------- ERAIKITZAILEA ---------------- // 

	public PremiumBezeroa(int id, String izena, String abizena, String erabiltzaile, String pasahitza, Date jaioData,
			Date erregisData, ArrayList<Abesti> playArray, Date PremiumMuga) {
		super(id, izena, abizena, erabiltzaile, pasahitza, jaioData, erregisData, playArray);
		
		this.PremiumMuga=PremiumMuga;
	}
	
	//---------------- GETTERS eta SETTERS ---------------- //
	
	public Date getPremiumMuga() {
		return PremiumMuga;
	}
	public void setPremiumMuga(Date premiumMuga) {
		PremiumMuga = premiumMuga;
	}
	
	//---------------- ToString ---------------- //
	
	@Override
	public String toString() {
	    return "PremiumBezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", erabiltzaile=" + erabiltzaile
	            + ", pasahitza=" + pasahitza + ", jaioData=" + jaioData + ", erregisData=" + erregisData
	            + ", playArray=" + playArray + ", PremiumMuga=" + PremiumMuga + "]";
	}

	//---------------- EQUALS ---------------- //

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumBezeroa other = (PremiumBezeroa) obj;
		return Objects.equals(PremiumMuga, other.PremiumMuga);
	}


}
