<<<<<<< HEAD
package funtzioak;

import java.util.List;

import Bista.AbestiaKudeatuBista;
import Bista.AdminMenua;
import Bista.AlbumBista;
import Bista.ArtistaBista;
import Bista.ArtistakKudeatu;
import Bista.ErregistroBista;
import Bista.ErreproduktoreaBista;
import Bista.EstatistikaBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
import Bista.MusikaKudeatu;
import Bista.NirePlaylistBista;
import Bista.PlaylistAbestiakBista;
import Bista.PlaylistErreproduktoreBista;
import Bista.PodcastDeskubrituBista;
import Bista.PodcastErreproduktoreBista;
import Bista.PodcasterBista;
import Bista.ProfilaBista;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import Modelo.Playlist;
import Modelo.Podcast;
import Modelo.Podcaster;

public class BistakArgitaratu {
	
	
	
	
    public static void loginJoan() {
        try {
            LoginBista frame = new LoginBista();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void erregistroraJoan() {
        try {
            ErregistroBista frame = new ErregistroBista();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void MenuJoan(Bezero bz) {
        try {
            MenuaBista frame = new MenuaBista(bz);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void MusikaDeskubrituJoan(Bezero bz) {
        try {
            MusikaDeskubrituBista frame = new MusikaDeskubrituBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, Bezero bz) {
        try {
            ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PodcastDeskubrituJoan(Bezero bz) {
        try {
            PodcastDeskubrituBista frame = new PodcastDeskubrituBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ProfilaBistaJoan(Bezero bz) {
        try {
            ProfilaBista frame = new ProfilaBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AlbumBistaJoan(Bezero bz, Album album, String artistaIzena, List<Album> albumak) {
        try {
            AlbumBista frame = new AlbumBista(bz, album, artistaIzena, albumak);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ErreproduktoreaBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index, String artistaIzena, List<Album> albumak, Boolean iragarkia) {
        try {
            ErreproduktoreaBista frame = new ErreproduktoreaBista(bz, abestiak, album, index, artistaIzena, albumak, iragarkia);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void NirePlaylistBistaraJoan(Bezero bz) {
        try {
            NirePlaylistBista frame = new NirePlaylistBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PodcastErreproduktoreraJoan(Bezero bz, int selectedValue, List<Podcast> podcastak, Podcaster podcaster) {
        try {
            PodcastErreproduktoreBista frame = new PodcastErreproduktoreBista(bz, selectedValue, podcastak, podcaster);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void PodcasterBistaJoan(Podcaster podcaster, Bezero bz) {
		try {
			PodcasterBista frame = new PodcasterBista(podcaster, bz);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void EstatistikaBistaJoan() {
		try {
			EstatistikaBista  frame = new EstatistikaBista();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void AdminMenuaJoan() {
		
		try {
			AdminMenua frame = new AdminMenua();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

    public static void PlaylistAbestiraJoan(Bezero bz, Playlist playlista) {
    	
        try {
            PlaylistAbestiakBista frame = new PlaylistAbestiakBista(bz, playlista);
            frame.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void PlaylistErreproduktoreBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index, String artistaIzena, List<Album> albumak, Playlist playlist) {
        try {
        	PlaylistErreproduktoreBista frame = new PlaylistErreproduktoreBista(bz, abestiak, album, index, artistaIzena, albumak, playlist);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void MusikaKudeatuJoan () {
    	
    	 try {
         	MusikaKudeatu frame = new MusikaKudeatu();
             frame.setVisible(true);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    public static void ArtistakKudeatuJoan () {
    	
    	try {
    		ArtistakKudeatu frame = new ArtistakKudeatu();
    		frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
    	}
    }
    
 public static void AbestiakKudeatuJoan () {
    	
    	try {
    		AbestiaKudeatuBista frame = new AbestiaKudeatuBista();
    		frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
    	}
    }
    
}
=======
package funtzioak;

import java.util.List;
import Bista.AdminMenua;
import Bista.AlbumBista;
import Bista.ArtistaBista;
import Bista.ArtistakKudeatu;
import Bista.ErregistroBista;
import Bista.ErreproduktoreaBista;
import Bista.EstatistikaBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
import Bista.MusikaKudeatu;
import Bista.NirePlaylistBista;
import Bista.PlaylistAbestiakBista;
import Bista.PlaylistErreproduktoreBista;
import Bista.PodcastDeskubrituBista;
import Bista.PodcastErreproduktoreBista;
import Bista.PodcasterBista;
import Bista.ProfilaBista;
import Modelo.Abesti;
import Modelo.Album;
import Modelo.Bezero;
import Modelo.Playlist;
import Modelo.Podcast;
import Modelo.Podcaster;

/**
 * BistakArgitaratu klasea erabiltzaile-interfaze grafikoak bistaratzeko funtzioak dituen klasea da.
 * Klase honetan login, erregistrora joan, menua joan, musika deskubritu joan, artista bista joan,
 * podcast deskubritu joan, profila bista joan, album bista joan, erreproduktorea bista joan,
 * nire playlist bista joan, podcast erreproduktorerara joan, podcaster bista joan, estatistika bista joan,
 * admin menua joan, playlist abestira joan, playlist erreproduktore bista joan, musika kudeatu joan eta
 * artistak kudeatu joan funtzioak daude.
 */
public class BistakArgitaratu {
    
    /**
     * Metodo honek login bista bistaratu eta erakutsiko du.
     */
    public static void loginJoan() {
        try {
            LoginBista frame = new LoginBista();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo honek erregistro bista bistaratu eta erakutsiko du.
     */
    public static void erregistroraJoan() {
        try {
            ErregistroBista frame = new ErregistroBista();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo honek menu bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     */
    public static void MenuJoan(Bezero bz) {
        try {
            MenuaBista frame = new MenuaBista(bz);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo honek musika deskubritu bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     */
    public static void MusikaDeskubrituJoan(Bezero bz) {
        try {
            MusikaDeskubrituBista frame = new MusikaDeskubrituBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek artista bista bistaratu eta erakutsiko du.
     * @param artistaIzena Artista izena
     * @param albumak Albumen lista
     * @param bz Bezero objektua
     */
    public static void ArtistaBistaJoan(String artistaIzena, List<Album> albumak, Bezero bz) {
        try {
            ArtistaBista frame = new ArtistaBista(artistaIzena, albumak, bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek podcast deskubritu bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     */
    public static void PodcastDeskubrituJoan(Bezero bz) {
        try {
            PodcastDeskubrituBista frame = new PodcastDeskubrituBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek profila bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     */
    public static void ProfilaBistaJoan(Bezero bz) {
        try {
            ProfilaBista frame = new ProfilaBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek album bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     * @param album Album objektua
     * @param artistaIzena Artista izena
     * @param albumak Albumen lista
     */
    public static void AlbumBistaJoan(Bezero bz, Album album, String artistaIzena, List<Album> albumak) {
        try {
            AlbumBista frame = new AlbumBista(bz, album, artistaIzena, albumak);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek erreproduktorea bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     * @param abestiak Abestiak lista
     * @param album Album objektua
     * @param index Indizea
     * @param artistaIzena Artista izena
     * @param albumak Albumen lista
     * @param iragarkia Iragarkiaren egonkortasuna
     */
    public static void ErreproduktoreaBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index, String artistaIzena, List<Album> albumak, Boolean iragarkia) {
        try {
            ErreproduktoreaBista frame = new ErreproduktoreaBista(bz, abestiak, album, index, artistaIzena, albumak, iragarkia);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek nire playlist bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     */
    public static void NirePlaylistBistaraJoan(Bezero bz) {
        try {
            NirePlaylistBista frame = new NirePlaylistBista(bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek podcast erreproduktorerara bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     * @param selectedValue Hautatutako balioa
     * @param podcastak Podcast-ak lista
     * @param podcaster Podcaster objektua
     */
    public static void PodcastErreproduktoreraJoan(Bezero bz, int selectedValue, List<Podcast> podcastak, Podcaster podcaster) {
        try {
            PodcastErreproduktoreBista frame = new PodcastErreproduktoreBista(bz, selectedValue, podcastak, podcaster);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek podcaster bista bistaratu eta erakutsiko du.
     * @param podcaster Podcaster objektua
     * @param bz Bezero objektua
     */
    public static void PodcasterBistaJoan(Podcaster podcaster, Bezero bz) {
        try {
            PodcasterBista frame = new PodcasterBista(podcaster, bz);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek estatistika bista bistaratu eta erakutsiko du.
     */
    public static void EstatistikaBistaJoan() {
        try {
            EstatistikaBista frame = new EstatistikaBista();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek admin menua bistaratu eta erakutsiko du.
     */
    public static void AdminMenuaJoan() {
        try {
            AdminMenua frame = new AdminMenua();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek playlist abestira bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     * @param playlista Playlist objektua
     */
    public static void PlaylistAbestiraJoan(Bezero bz, Playlist playlista) {
        try {
            PlaylistAbestiakBista frame = new PlaylistAbestiakBista(bz, playlista);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek playlist erreproduktore bista bistaratu eta erakutsiko du.
     * @param bz Bezero objektua
     * @param abestiak Abestiak lista
     * @param album Album objektua
     * @param index Indizea
     * @param artistaIzena Artista izena
     * @param albumak Albumen lista
     * @param playlist Playlist objektua
     */
    public static void PlaylistErreproduktoreBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index, String artistaIzena, List<Album> albumak, Playlist playlist) {
        try {
            PlaylistErreproduktoreBista frame = new PlaylistErreproduktoreBista(bz, abestiak, album, index, artistaIzena, albumak, playlist);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek musika kudeatu bista bistaratu eta erakutsiko du.
     */
    public static void MusikaKudeatuJoan() {
        try {
            MusikaKudeatu frame = new MusikaKudeatu();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo honek artistak kudeatu bista bistaratu eta erakutsiko du.
     */
    public static void ArtistakKudeatuJoan() {
        try {
            ArtistakKudeatu frame = new ArtistakKudeatu();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> a3e52fb40761b80f0af2074e276e6aea66ffd4e8
