package DatuBasea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Bezero;
import Modelo.Playlist;
import Salbuespenak.DatubaseErroreaKeyDupe;
import funtzioak.DateFuntzioak;

public class PlaylistDao {

	public static ArrayList<Playlist> PlayListAtera(Bezero bz) throws SQLException {

		ArrayList<Playlist> playlistArray = new ArrayList<>();

		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "select * from playlist where idbezeroa = '" + bz.getId() + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						String idList = rs.getString("idlist");
						String izenburua = rs.getString("izenburua");

						Playlist pl = new Playlist(idList, izenburua, null);

						playlistArray.add(pl);

						bz.setPlayArray(playlistArray);
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playlistArray;
	}

	public static boolean InsertErreprodukzioak(Bezero bz, String idAudio) throws SQLException, DatubaseErroreaKeyDupe {

		boolean inserted = false;

		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "{CALL erreprodukzioagehitu(?, ?)}";

			try (CallableStatement cstmt = con.prepareCall(kontsulta)) {

				cstmt.setString(1, bz.getId());

				cstmt.setString(2, idAudio);

				inserted = cstmt.executeUpdate() > 0;

			}

		} catch (SQLException ex) {

			throw new DatubaseErroreaKeyDupe();

		}

		return inserted;

	}

	public static boolean InsertAbestiPlaylist(String selectedPlaylist, String idAudioLike) throws SQLException {

		String idList = "";

		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "select idlist from playlist where izenburua = '" + selectedPlaylist + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						idList = rs.getString("idlist");

					}
				}
			}

			LocalDate localDate = LocalDate.now();
			String gaurString = DateFuntzioak.LocalDatetoString(localDate);

			String insert = "INSERT INTO playlist_abestiak(idaudio, idlist, data) VALUES (?,?,?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, idAudioLike);
				preparedStatement.setString(2, idList);
				preparedStatement.setDate(3, new java.sql.Date(DateFuntzioak.StringtoDate(gaurString).getTime()));

				preparedStatement.executeUpdate();

				preparedStatement.close();

				con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}

		return true;
	}

}
