package Salbuespenak;

import javax.swing.JOptionPane;

public class DatubaseErroreaKeyDupe extends Exception{

	
	/**
	 * 
	 * DatubaseErroreaKeyDupe klasea sortu dugu, datu basean sartu nahi dugun gakoaren balioa datu basean dagoeneko badagoela adierazteko.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatubaseErroreaKeyDupe() {

		JOptionPane.showMessageDialog(null,
				"Mesedez, gure aplikazioa musika disfrutatzeko sortu egin dugu, motelago aldatu abestiak", "Error", 0);

	}

	
}
