package Testak.Funtzio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PodcastFuntzioakTest {

	@Test
	public void testSplitIzenaPodcast_Ondo() {
	
		String izena = "Benetan Zabiz? - Porrotxen Heriotza";

		String result = funtzioak.PodcastBistaFuntzioak.splitIzenaPodcast(izena);
		assertEquals("Porrotxen Heriotza", result);
	}

	@Test
	public void testSplitIzenaPodcast_Txarto() {
		String izena = "Benetan Zabiz? - Porrotxen Heriotza";

		String result = funtzioak.PodcastBistaFuntzioak.splitIzenaPodcast(izena);

		assertNotEquals("", result);
	}

}
