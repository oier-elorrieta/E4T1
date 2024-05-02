package funtzioak;

import Modelo.Podcast;

public class PodcastBistaFuntzioak {

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
	public static void selekzioaHautatu() {
	
	}
}
