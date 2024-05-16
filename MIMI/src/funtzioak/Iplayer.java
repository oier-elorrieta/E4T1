package funtzioak;

/**
 * Iplayer interfazea musika-erreproduzitzailea definitzen du.
 */
public interface Iplayer {
	/**
	 * musika-erreproduzitzailea hasieratzen du.
	 */
	public void play();

	/**
	 * musika-erreproduzitzailea gelditzen du.
	 */
	public void stop();

	/** 
	 * @param filename WAV fitxategiaren izena
	 * @return Denbora formatuan itzultzen duen string-a
	 */
	public String kenduWav(String filename);

	/**
	 * Musika-erreproduzitzailea denbora formatuan itzultzen duen metodoa.
	 * 
	 * @return Denbora formatuan itzultzen duen string-a
	 */
	public String denbora();
}