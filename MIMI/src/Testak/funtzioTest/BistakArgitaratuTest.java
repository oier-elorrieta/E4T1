package Testak.funtzioTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Modelo.Album;
import Modelo.FreeBezero;
import Modelo.Podcast;
import Modelo.Podcaster;
import Modelo.Audio.Mota;

public class BistakArgitaratuTest {
FreeBezero bezero = new FreeBezero("BZ009", "talde", "talde", "mimitalde", "password", "2024-04-19",
"2024-04-20", new ArrayList<>(), null, null);
Podcaster podcaster = new Podcaster("id", "izena", "info", null);
Album album = new Album("Album_id", "Los del Rio Grandes Exitos", null, 10, "POP", "Id_DelRio", "Antonio Romero Monge y Rafael Ruiz", null);
    Podcast podcast = new Podcast("1",null,null,Mota.podcast,"1_podcast", "QSMA", "MARIO");
   
@Test
public void loginJoanOndo() {
funtzioak.BistakArgitaratu.loginJoan();
}

@Test
public void erregistroJoanOndo() {
funtzioak.BistakArgitaratu.erregistroraJoan();

}
@Test
public void MenuJoanOndo() {
funtzioak.BistakArgitaratu.MenuJoan(bezero);

}
@Test
public void MusikaDeskubrituJoanOndo() {
funtzioak.BistakArgitaratu.MusikaDeskubrituJoan(bezero);

}
@Test
public void ArtistaBistaJoanOndo() {
    ArrayList<Album> albumak = new ArrayList<>();
    funtzioak.BistakArgitaratu.ArtistaBistaJoan("Artista Izena", albumak, bezero);
}
@Test
public void PodcastDeskubrituJoanOndo() {
funtzioak.BistakArgitaratu.PodcastDeskubrituJoan(bezero);

}
@Test
public void PodcasterBistaJoanOndo() {
funtzioak.BistakArgitaratu.PodcasterBistaJoan(podcaster, bezero);

}
@Test
public void ProfilaBistaJoanOndo() {
funtzioak.BistakArgitaratu.ProfilaBistaJoan(bezero);

}
@Test
public void AlbumBistaJoanOndo() {
    funtzioak.BistakArgitaratu.AlbumBistaJoan(bezero, album);
}

@Test
public void ErreproduktoreaBistaJoanOndo() {
    funtzioak.BistakArgitaratu.ErreproduktoreaBistaJoan(bezero, 0, new ArrayList<>(), album);
}

@Test
public void PlaylistBistaraJoanOndo() {
    funtzioak.BistakArgitaratu.PlaylistBistaraJoan(bezero);
}
@Test
public void PodcastErreproduktoreraJoanOndo() {
    funtzioak.BistakArgitaratu.PodcastErreproduktoreraJoan(bezero, podcast, new ArrayList<>());
}
}