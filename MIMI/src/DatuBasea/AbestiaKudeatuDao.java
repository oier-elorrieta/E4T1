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
import funtzioak.DateFuntzioak;

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
	public static String SortuAbestia(String selectedArtista, String AbestiaIzenBerri) throws SQLException {
		
		String id = "";
		String idberria = "";
		 boolean inserted = false;
		 Time time = new Time (0,2,52);

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select idaudio from audio where idaudio like '" + selectedArtista.substring(0,2).toUpperCase() + "%'" +  "order by idaudio desc limit 1";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						id = rs.getString("idaudio");

						String zenbakiaStr = id.substring(4);
						int zbk = Integer.parseInt(zenbakiaStr);

						zbk++;

						id = id.substring(0,2) + String.format("%03d", zbk);

					}
					
					idberria = selectedArtista.substring(0,2).toUpperCase() + "AU1";

				}

			}
	
	        String kontsulta2 = "{CALL abestiagehitu(?,?,?,?)}";
	        try (CallableStatement cstmt = con.prepareCall(kontsulta2)) {
	        	if (id != "") {
	        	cstmt.setString(1, id);
	        	return id;
	        	}else {
	        		cstmt.setString(1, idberria);
	        		
	        	}
	        	cstmt.setString(2, AbestiaIzenBerri);
	        	cstmt.setTime(3,time);
	        	cstmt.setString(4, "abestia");
	        	
	        	 inserted = cstmt.executeUpdate() > 0;
	        }
	    }
		return idberria;
	}
	
	public static void AbestiaAlbum (String selectedAlbum, String AbestiaIzenBerri, String selectedArtista) throws SQLException {
		
		String idalbum = "";
		
		String idaudio = SortuAbestia(selectedArtista, AbestiaIzenBerri);

		try (Connection con = Konexioa.konexioa()) {
			
			String kontsulta = "Select idalbum from album where izenburua = '" + selectedAlbum + "'";
			
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						
						idalbum = rs.getString("idalbum");
						
						
					}
				}
			}

			String insert = "insert into abestia (idaudio,idalbum) values (?,?)";
			

			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, idaudio);
				preparedStatement.setString(2, idalbum);

				preparedStatement.executeUpdate();

				preparedStatement.close();


			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
		
	}
