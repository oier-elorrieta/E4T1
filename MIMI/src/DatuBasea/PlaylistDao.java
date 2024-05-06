package DatuBasea;

import java.sql.Blob;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Abeslari;
import Modelo.Abesti;
import Modelo.Bezero;
import Modelo.Playlist;
import funtzioak.ErregistratuF;
import Modelo.Audio.Mota;

public class PlaylistDao {
	
public static ArrayList<Playlist> PlayListAtera(Bezero bz) throws SQLException {
	
	ArrayList<Playlist> playlistArray = new ArrayList<>();
	
	
	try (Connection con = Konexioa.konexioa()) {
		String kontsulta = "select * from Playlist where idBezeroa = '" + bz.getId() + "';";
		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String idList = rs.getString("idList");
					String izenburua = rs.getString("izenburua");
					
					
					Playlist pl = new Playlist(idList,izenburua,null);
				
					playlistArray.add(pl);
					
					
					bz.setPlayArray( playlistArray);
					
					System.out.println(pl.toString());
					}
					
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return playlistArray;
}

public static void InsertAbestiPlaylist(String selectedPlaylist , String idAudioLike) throws SQLException {
	
	String idList = "";

	try (Connection con = Konexioa.konexioa()) {
		String kontsulta = "select idList from Playlist where izenburua = '" + selectedPlaylist + "';";
		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					idList = rs.getString("idList");
				
				}
			}
		}
	
	
	
	
	String gaurString = ErregistratuF.LocalDatetoString();
	
	System.out.println(gaurString);
	

		String insert = "INSERT INTO playlist_abestiak(IdAudio, IdList, data) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1,idAudioLike);
			preparedStatement.setString(2,idList);
			preparedStatement.setDate(3,
					new java.sql.Date(ErregistratuF.StringtoDate(gaurString).getTime()));

			preparedStatement.executeUpdate();

			preparedStatement.close();

			con.close();

			 JOptionPane.showMessageDialog(null,selectedPlaylist +  " zerrendan sartu duzu");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
}

