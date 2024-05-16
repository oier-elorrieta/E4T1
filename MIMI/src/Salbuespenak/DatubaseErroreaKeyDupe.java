package Salbuespenak;

import javax.swing.JOptionPane;

public class DatubaseErroreaKeyDupe extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatubaseErroreaKeyDupe() {

		JOptionPane.showMessageDialog(null,
				"Mesedez, gure aplikazioa musika disfrutatzeko sortu egin dugu, motelago aldatu abestiak", "Error", 0);

	}

	
}
