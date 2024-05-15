package DatuBasea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Bezero;

public class gustukoakDao {

	public static boolean DagoEdoEz(Bezero bz, String idAudioLike) throws SQLException {
		boolean ezabatuta = false;
		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "SELECT * from gustukoak where idaudio = '" + idAudioLike + "' and idbezeroa = '"
					+ bz.getId() + "';";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {

						ezabatuta = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ezabatuta;
	}

	public static boolean GustukoInsert(Bezero bz, String idAudioLike) throws SQLException {

		try (Connection con = Konexioa.konexioa()) {

			String insert = "insert into gustukoak (idbezeroa, idaudio) values (?,?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, bz.getId());
				preparedStatement.setString(2, idAudioLike);

				preparedStatement.executeUpdate();

				preparedStatement.close();

				con.close();

				JOptionPane.showMessageDialog(null, "Gustuko zerrendan sartu duzu");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return true;

	}

	public static boolean GustukoDelete(Bezero bz, String idAudioLike) {

		try (Connection con = Konexioa.konexioa()) {

			String delete = "Delete from gustukoak where idaudio ='" + idAudioLike + "' and idbezeroa = '" + bz.getId()
					+ "';";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(delete);

				preparedStatement.executeUpdate();

				preparedStatement.close();

				con.close();

				JOptionPane.showMessageDialog(null, "Gustuko zerrendatik atera duzu");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}

}
