package funtzioak;

import Modelo.Podcast;

/**
 * Klase honek podcast-ekin lotutako funtzioak gordetzen ditu.
 */
public class PodcastBistaFuntzioak {

	/**
	 * String bat jaso eta " - " karakterearen arabera banatuta dagoen izena itzultzen du.
	 * 
	 * @param izena podcast-aren izena
	 * @return izenaSplit banatutako izena
	 */
	public static String splitIzenaPodcast(String izena) {
		String izenaSplit = "";
		String[] splitKatea = izena.split(" - ");
		if (splitKatea.length >= 1) {
			izenaSplit = splitKatea[1];
			System.out.println("Podcast ep izena: " + izenaSplit);
		} else {
			System.out.println("Txarto");
		}
		return izenaSplit;
	}
	
	/**
	 * Podcast-ak hautatzeko aukera ematen duen metodoa.
	 */
	public static void selekzioaHautatu() {
	
	}
}
