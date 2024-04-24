package Modelo;

import java.sql.Date;
import java.util.ArrayList;

public class FreeBezero extends Bezero {

	public FreeBezero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeBezero(String id, String izena, String abizena, String erabiltzaile, String pasahitza, String jaioData,
			String erregisData, ArrayList<Abesti> playArray, String mota, String Hizkuntza) {
		super(id, izena, abizena, erabiltzaile, pasahitza, jaioData, erregisData, playArray, mota, Hizkuntza);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

	
	

}
