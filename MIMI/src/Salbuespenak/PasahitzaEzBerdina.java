package Salbuespenak;

import javax.swing.JOptionPane;

public class PasahitzaEzBerdina extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasahitzaEzBerdina() {

		JOptionPane.showMessageDialog(null,
				"Pasahitza txarto edo ez baliozkoa da, begiratu bi pasahitzak berdinak diren!!", "Error", 0);

	}

}
