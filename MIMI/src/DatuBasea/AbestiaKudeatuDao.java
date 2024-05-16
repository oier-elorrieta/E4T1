package DatuBasea;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Abeslari;
import Modelo.Abesti;
import Modelo.Audio.Mota;

public class AbestiaKudeatuDao {
	
	public static List<Abesti> AbestiakAtera() {
		List<Abesti> abestiak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM audio inner join abestia using (idaudio) inner join album using (idalbum);";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						Time argitaratzea = rs.getTime("iraupena");
						Blob irudia = rs.getBlob("irudia");
						String mota = rs.getString("mota");
						String idAudio = rs.getString("idaudio");
						String abestiIzena = rs.getString("izena");
						String albumIzena = rs.getString("izenburua");
						String kolaboratzaile = rs.getString("kolaboratzaileak");
						
						if(mota.equals("abestia")) {
							Abesti abesti = new Abesti(idAudio,argitaratzea,irudia,Mota.abestia,idAudio,abestiIzena,albumIzena,kolaboratzaile);
							abestiak.add(abesti);
						}

						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abestiak;

	}
	
	public static void ezabatuAbestia(int id, List<Abesti> lista) {

		try (Connection con = Konexioa.konexioa()) {
			String selekzioa = lista.get(id).getId();

			String kontsulta = "DELETE FROM audio WHERE idaudio= '" + selekzioa + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				int rowsDeleted = pstmt.executeUpdate();
				if (rowsDeleted > 0) {
					
					JOptionPane.showMessageDialog(null, "Abestia ezabatu da!");

				} else {
					JOptionPane.showMessageDialog(null, "Ez da ezer ezabatu!");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean AbestiaBegiratuDagoen(String selectedArtista, String AbestiaIzenBerri) {
		boolean dago = false;
		
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT au.izena, m.izenartistikoa from audio au inner join abestia using (idaudio) inner join album using (idalbum) inner join musikaria m using (idmusikaria);";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						String abestia = rs.getString("izena");
						String artista = rs.getString("izenartistikoa");
						
						if (abestia == AbestiaIzenBerri && artista == selectedArtista) {
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
	public static boolean SortuAbestia(String selectedArtista, String AbestiaIzenBerri) throws SQLException {
		 boolean inserted = false;
	    Time time = new Time (0,2,52);
	    try (Connection con = Konexioa.konexioa()) {
	        String kontsulta = "{CALL abestiagehitu(?,?,?,?)}";
	        try (CallableStatement cstmt = con.prepareCall(kontsulta)) {
<<<<<<< HEAD
	        	cstmt.setString(1, AbestiaIzenBerri.substring(1,3).toUpperCase() + "AU01");
	        	cstmt.setString(2, AbestiaIzenBerri);
=======
	        	cstmt.setString(1, AbestiaIzenBerri.substring(0,2).toUpperCase() + "AU01");	        	cstmt.setString(2, AbestiaIzenBerri);
>>>>>>> 590494bb5871199ba59cdad7439cef192eb9a40e
	        	cstmt.setTime(3,time);
	        	cstmt.setString(4, "abestia");
	        	
	        	 inserted = cstmt.executeUpdate() > 0;
	        }
	    }
		return inserted;
	}
}
