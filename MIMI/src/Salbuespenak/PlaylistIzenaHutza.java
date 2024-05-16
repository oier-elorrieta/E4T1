package Salbuespenak;

import javax.swing.JOptionPane;

public class PlaylistIzenaHutza extends Exception {

	/**
	 * 
	 * PlaylistIzenaHutza klasea sortu dugu, PlayList bat sortu nahi dugunean izena ez badagoela adierazteko.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlaylistIzenaHutza() {

		JOptionPane.showMessageDialog(null,
				"Ezin duzu PlayList bat sortu izena ez badiozu jartzen", "Error", 0);

	}

}
