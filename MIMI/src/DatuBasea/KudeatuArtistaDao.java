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
	}
