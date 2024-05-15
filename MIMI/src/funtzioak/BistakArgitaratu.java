package funtzioak;

import java.util.List;

import Bista.AdminMenua;
import Bista.AlbumBista;
import Bista.ArtistaBista;
import Bista.ErregistroBista;
import Bista.ErreproduktoreaBista;
import Bista.EstatistikaBista;
import Bista.LoginBista;
import Bista.MenuaBista;
import Bista.MusikaDeskubrituBista;
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

    public static void MusikaDeskubrituItxi(Bezero bz) {
        try {
            MusikaDeskubrituBista frame = new MusikaDeskubrituBista(bz);
            frame.setVisible(false);
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

    public static void PodcasterBistaJoan(Podcaster podcaster, Bezero bz) {
        try {
            PodcasterBista frame = new PodcasterBista(podcaster, bz);
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

    public static void ErreproduktoreaBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index, String artistaIzena, List<Album> albumak) {
        try {
            ErreproduktoreaBista frame = new ErreproduktoreaBista(bz, abestiak, album, index, artistaIzena, albumak);
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

<<<<<<< HEAD
	public static void PodcasterBistaJoan(Podcaster podcaster, Bezero bz) {
		try {
			PodcasterBista frame = new PodcasterBista(podcaster, bz);
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

	public static void ErreproduktoreaBistaJoan(Bezero bz, List<Abesti> abestiak, Album album, int index,
			String artistaIzena, List<Album> albumak) {
		try {
			ErreproduktoreaBista frame = new ErreproduktoreaBista(bz, abestiak, album, index, artistaIzena, albumak);
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

	public static void PodcastErreproduktoreraJoan(Bezero bz, int selectedValue, List<Podcast> podcastak,
			Podcaster podcaster) {
		try {
			PodcastErreproduktoreBista frame = new PodcastErreproduktoreBista(bz, selectedValue, podcastak, podcaster);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void PlaylistAbestiraJoan(Bezero bz, Playlist playlista) {
		try {
			PlaylistAbestiakBista frame = new PlaylistAbestiakBista(bz,playlista);
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

=======
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
    
    
>>>>>>> b41cd951c9550a7fb8bac80c9fb0030a2fdd1f03
}
