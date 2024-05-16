package DatuBasea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Bezero;
/**
 * 
 * GustokoakDao klasea gustukoak taularekin eragin duen funtzioak kudeatzeko erabiltzen da.
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class gustukoakDao {

	/**
	 * Metodo honek gustukoak taulan idAudioLike parametroaren eta bz parametroaren arabera aurkitzen duen erregistroa itzultzen du.
	 * 
	 * @param bz Bezero objektua
	 * @param idAudioLike Audioaren identifikazioa
	 * @return true, gustukoak taulan erregistroa aurkitzen bada; false, bestela
	 * @throws SQLException SQL errorea gertatzen bada
	 */
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

	/**
	 * Metodo honek gustukoak taulan sartzen du bezeroa eta audioaren id
	 * 
	 * @param bz           Bezero objektua, gustukoak taulan sartzeko erabiltzen den bezeroa.
	 * @param idAudioLike  String motako parametroa, gustukoak taulan sartzeko erabiltzen den audioaren identifikadorea.
	 * @return             boolean motako balioa, true itzultzen du ondo sartu bada gustukoak taulan, false itzultzen du bestela.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
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

	/**
	 * Metodo honek gustukoak taulatik erregistro bat ezabatzen du, emandako bezeroaren eta audioaren identifikadoreak erabiliz.
	 *
	 * @param bz           Bezero objektua, gustukoak taulan ezabatu nahi den bezeroa identifikatzeko.
	 * @param idAudioLike  Audioaren identifikadorea, gustukoak taulan ezabatu nahi den audioa identifikatzeko.
	 * @return             True itzultzen du ondo ezabatu bada, false itzultzen du bestela.
	 */
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
