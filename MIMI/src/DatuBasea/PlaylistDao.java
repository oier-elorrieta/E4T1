package DatuBasea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Bezero;
import Modelo.Playlist;

public class PlaylistDao {
	
public static List<Playlist> PlayListAtera(Bezero bz, List<Playlist> playlistArray) throws SQLException {
	
	
	try (Connection con = Konexioa.konexioa()) {
		String kontsulta = "select * from Playlist inner join playlist_abestiak using (idList) where idBezeroa = '" + bz.getId() + "';";
		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String idList = rs.getString("idList");
					String izenburua = rs.getString("izenburua");
					String idAudioa = rs.getString("IdAudio");
					
					Playlist pl = new Playlist(idList,izenburua,null);
					
					playlistArray.add(pl);
					for(int i = 0; i < playlistArray.size(); i++) {
						System.out.println(playlistArray.get(i));
					}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	return playlistArray;
}
}

