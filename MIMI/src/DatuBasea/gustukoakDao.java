package DatuBasea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Bezero;

public class gustukoakDao {
	
	
	
public static void GutokoInsert (Bezero bz, String idAudioLike) throws SQLException {
	
	
	
	System.out.println(bz.getId() + " eta " + idAudioLike);
	
	try (Connection con = Konexioa.konexioa()) {

		String insert = "insert into gustukoak (IdBezeroa, IdAudio) values (?,?)";

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
		}
	}
	
}
}

