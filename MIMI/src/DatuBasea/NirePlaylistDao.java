package DatuBasea;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import Modelo.Playlist;
import Modelo.Audio.Mota;
import funtzioak.DateFuntzioak;

public class NirePlaylistDao {
	public static List<Playlist> nirePlaylistAtera(Bezero bz) {
		List<Playlist> lista = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM playlist WHERE idbezeroa = ?";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				pstmt.setString(1, bz.getId());
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Playlist playlist = new Playlist();
						playlist.setId(rs.getString("idlist"));
						playlist.setIzena(rs.getString("izenburua"));

						lista.add(playlist);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static Playlist sortuPlaylist(Bezero bz, String izena) throws SQLException {
		Playlist lista = new Playlist();
		java.util.Date sorreradata = DateFuntzioak.StringtoDate(DateFuntzioak.LocalDatetoString(LocalDate.now()));
		java.sql.Date sorreradatasql = new java.sql.Date(sorreradata.getTime());

		try (Connection con = Konexioa.konexioa()) {

			String insert = "insert into playlist (idList, izenburua, sorreradata, idbezeroa) values (?,?,?,?)";
			lista.setId(hartuIdPlaylist());
			lista.setIzena(izena);
			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, lista.getId());
				preparedStatement.setString(2, lista.getIzena());
				preparedStatement.setDate(3, sorreradatasql); // Utilizar java.sql.Date
				preparedStatement.setString(4, bz.getId());

				// Ejecutar la insercion en la base de datos
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return lista;
	}

	public static String hartuIdPlaylist() throws SQLException {

		String idberria = "";
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select idlist from playlist order by idlist desc limit 1";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						String id = rs.getString("idlist");

						String zenbakiaStr = id.substring(2);
						int zbk = Integer.parseInt(zenbakiaStr);

						zbk++;

						idberria = "PL" + String.format("%03d", zbk);

					}

				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return idberria;

	}

	public static void ezabatuPlayList(Bezero bz, int id, List<Playlist> listak) {

		try (Connection con = Konexioa.konexioa()) {
			String selekzioa = listak.get(id).getId();

			System.out.println(selekzioa);

			String kontsulta = "DELETE FROM playlist WHERE idlist= '" + selekzioa + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				int rowsDeleted = pstmt.executeUpdate();
				if (rowsDeleted > 0) {
					listak.remove(listak.get(id));
					JOptionPane.showMessageDialog(null, "Playlista ezabatu da!");

				} else {
					JOptionPane.showMessageDialog(null, "Ez da ezer ezabatu!");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Playlist lortuAbestiakIdPlaylist(Playlist playlist) {
		ArrayList<Abesti> abestiak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM `mimi`.`audio` inner join playlist_abestiak USING (idaudio) inner join abestia USING (idaudio) INNER JOIN album USING (idalbum) WHERE idlist = '"
					+ playlist.getId() + "' ORDER BY `idaudio` ASC";
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

						if (mota.equals("abestia")) {
							Abesti abesti = new Abesti(idAudio, argitaratzea, irudia, Mota.abestia, idAudio,
									abestiIzena, albumIzena, kolaboratzaile);
							abestiak.add(abesti);
						}

					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		playlist.setAbestiList(abestiak);

		return playlist;

	}

	public static ArrayList<Abesti> lortuAbestiListaId(Playlist playlist) {
		ArrayList<Abesti> abestiak = new ArrayList<>();
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM `mimi`.`audio` inner join playlist_abestiak USING (idaudio) inner join abestia USING (idaudio) INNER JOIN album USING (idalbum) WHERE idlist = '"
					+ playlist.getId() + "' ORDER BY `idaudio` ASC";
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

						if (mota.equals("abestia")) {
							Abesti abesti = new Abesti(idAudio, argitaratzea, irudia, Mota.abestia, idAudio,
									abestiIzena, albumIzena, kolaboratzaile);
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

	public static Abesti abestiakIdExpo(String IdAudio) {
		Abesti abesti = null;
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * FROM `mimi`.`audio` inner join abestia using (idaudio) inner join album using (idalbum) WHERE `idaudio` = ? ";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				pstmt.setString(1, IdAudio);
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Time argitaratzea = rs.getTime("iraupena");
						Blob irudia = rs.getBlob("irudia");
						String mota = rs.getString("mota");
						String idAudio = rs.getString("idaudio");
						String abestiIzena = rs.getString("izena");
						String albumIzena = rs.getString("izenburua");
						String kolaboratzaile = rs.getString("kolaboratzaileak");
						if (mota.equals("abestia")) {
							abesti = new Abesti(idAudio, argitaratzea, irudia, Mota.abestia, idAudio, abestiIzena,
									albumIzena, kolaboratzaile);

						}

					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abesti;
	}

	public static Playlist AteraPlaylistAbestiak(Playlist playlist) {

		ArrayList<Abesti> ab = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT a.iraupena,p.idlist,a.idaudio,a.izena,al.izenburua,al.kolaboratzaileak FROM musikaria m inner join album al using (idmusikaria) inner join abestia USING(idalbum) inner join audio a USING (idaudio) INNER join playlist_abestiak USING (idaudio) inner join playlist p USING (idlist) where idlist = '"
					+ playlist.getId() + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						Time iraupena = rs.getTime("iraupena");
						Blob irudia = rs.getBlob("idlist");
						String idAudio = rs.getString("idaudio");
						String abestiIzena = rs.getString("izena");
						String albumIzena = rs.getString("izenburua");
						String kolaboratzaile = rs.getString("kolaboratzaileak");

						Abesti abesti = new Abesti(idAudio, iraupena, irudia, Mota.abestia, idAudio, abestiIzena,
								albumIzena, kolaboratzaile);
						ab.add(abesti);

					}

					playlist.setAbestiList(ab);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playlist;

	}

	public static int ErreprodukzioakAtera(Playlist playlist) {

		int erreprodukzioak = 0;
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT count(*) FROM playlist INNER join playlist_abestiak USING (idlist) inner join erreprodukzioak using(idaudio) where idlist = '"
					+ playlist.getId() + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						erreprodukzioak = rs.getInt("count(*)");

					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return erreprodukzioak;

	}

	public static void ezabatuAbestiaPlayList(int selectedIndex, Playlist lista) {

		try (Connection con = Konexioa.konexioa()) {
			String selekzioa = lista.getAbestiList().get(selectedIndex).getId();

			System.out.println(selekzioa);

			String kontsulta = "DELETE FROM playlist_abestiak WHERE idaudio= '" + selekzioa + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				int rowsDeleted = pstmt.executeUpdate();
				if (rowsDeleted > 0) {
					lista.getAbestiList().remove(lista.getAbestiList().get(selectedIndex));
					JOptionPane.showMessageDialog(null, "Abestia ezabatu da!");

				} else {
					JOptionPane.showMessageDialog(null, "Ez da ezer ezabatu!");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
