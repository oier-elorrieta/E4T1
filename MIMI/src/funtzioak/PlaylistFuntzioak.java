package funtzioak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Abesti;
import Modelo.Playlist;
import DatuBasea.PlaylistDao;
import DatuBasea.NirePlaylistDao;

public class PlaylistFuntzioak {

	private static final File filePlaylist = new File("Playlistak.txt");
	private static final File fileAbestiak = new File("Abestiak.txt");
	

	public static void PlaylistaExportatu(Playlist playlista) {
		try (BufferedWriter bW = new BufferedWriter(new FileWriter(filePlaylist))) {
			NirePlaylistDao.lortuAbestiakIdPlaylist(playlista);
			System.out.println(playlista);
			System.out.println(playlista.getAbestiList().size());
			if (playlista == null || playlista.getAbestiList().size() == 0) {
				JOptionPane.showMessageDialog(null, "Playlist hutsa dago");
				return;
			}
			ArrayList<Abesti> abestiList = playlista.getAbestiList();
			for (Abesti abesti : abestiList) {
				bW.write(abesti.getid_abesti());
				bW.newLine();
			}
			JOptionPane.showMessageDialog(null, "Playlist exportatu egin da , path: " + filePlaylist.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Playlist PlaylistaImportatu(Playlist playlista) throws SQLException {
		ArrayList<Abesti> abestiList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePlaylist))) {
			String idAudio;
			while ((idAudio = br.readLine()) != null) {
				Abesti abesti = NirePlaylistDao.abestiakIdExpo(idAudio);
				if (abesti != null) {
					abestiList.add(abesti);
					PlaylistDao.InsertAbestiPlaylist(playlista.getIzena(), abesti.getid_abesti());
				}
			}
			JOptionPane.showMessageDialog(null, playlista.getIzena() + " playlistera sartu duzu");
		} catch (IOException e) {
			e.printStackTrace();
		}
		playlista.setAbestiList(abestiList);
		return playlista;
	}
	
	public static void AbestiakExportatu(Playlist lista, int erreprodukzioak, ArrayList<String> abeslaria, int id) {
		try (BufferedWriter bW = new BufferedWriter(new FileWriter(fileAbestiak))) {
				bW.write("ABESTI HAU ENTZUN- " + lista.getAbestiList().get(id).getAbestiIzena() + " - "+ erreprodukzioak + " - " + abeslaria.get(id) + " - " + lista.getAbestiList().get(id).getIraupena());
				bW.newLine();
				
			JOptionPane.showMessageDialog(null, "Playlist exportatu egin da , path: " + fileAbestiak.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
