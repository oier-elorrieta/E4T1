package DatuBasea;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Abeslari;
import Modelo.Bezero;


public class KudeatuArtistaDao {
	

	/**
	 * Artista bat ezabatzeko metodoa.
	 *
	 * @param id    Ezabatu nahi den artistaaren identifikadorea.
	 * @param lista Abeslarien zerrenda, non artista bat aurkitzen den.
	 */
	public static void ezabatuArtista(int id, List<Abeslari> lista) {

		try (Connection con = Konexioa.konexioa()) {
			String selekzioa = lista.get(id).getId();

			System.out.println(selekzioa);

			String kontsulta = "DELETE FROM musikaria WHERE idmusikaria= '" + selekzioa + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				int rowsDeleted = pstmt.executeUpdate();
				if (rowsDeleted > 0) {
					lista.remove(lista.get(id));
					JOptionPane.showMessageDialog(null, "Artista ezabatu da!");

				} else {
					JOptionPane.showMessageDialog(null, "Ez da ezer ezabatu!");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean ArtistaBegiratuDagoen(String selectedArtista) {
		boolean dago = false;
		
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT izenartistikoa from musikaria;";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String artista = rs.getString("izenartistikoa");
						
						if (artista.equals(selectedArtista)) {
							dago = true;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dago;

}
	
	/**
	 * Artista bat gehitzeko metodoa.
	 *
	 * @param textua           Artistaaren testua
	 * @param ArtistaIzenBerri Artista berriaren izena
	 * @param selectedMota     Artista mota hautatua
	 * @return                 True, gehitzea ondo gertatu bada; false, bestela
	 * @throws SQLException   SQL errorea gertatzen bada
	 */
	public static boolean InsertArtista(String textua, String ArtistaIzenBerri, String selectedMota) throws SQLException {
	    boolean inserted = false;
	    try (Connection con = Konexioa.konexioa()) {
	        String kontsulta = "{CALL musikariagehitu(?, ?,?,?)}";
	        try (CallableStatement cstmt = con.prepareCall(kontsulta)) {
	        	cstmt.setString(1, ArtistaIzenBerri.substring(0,3).toUpperCase() + "01");
	        	cstmt.setString(2, ArtistaIzenBerri);
	        	cstmt.setString(3, selectedMota);
	        	cstmt.setString(4, textua);
	            inserted = cstmt.executeUpdate() > 0;
	        }
	    }
	    return inserted;
	}
	
	public static void UpdateArtista(String erantzuna, String selectedAukera, List<Abeslari> lista, int id) throws SQLException {
		try (Connection con = Konexioa.konexioa()) {
			String update = "Update musikaria set " + selectedAukera + " = '" + erantzuna + "' where idmusikaria = '" + lista.get(id).getId() + "'";
			try (PreparedStatement pstmt = con.prepareStatement(update)) {
				pstmt.executeUpdate();
						
					}
				}
			}
		}
