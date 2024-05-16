package funtzioak;

/**
 * Iplayer interfazea musika jokalaria definitzen du.
 */
public interface Iplayer {
	/**
	 * Musika jokalaria hasieratzen du.
	 */
	public void play();

	/**
	 * Musika jokalaria gelditzen du.
	 */
	public void stop();

	/**
	 * Emaitza denbora formatuan itzultzen duen metodoa.
	 * 
	 * @param filename WAV fitxategiaren izena
	 * @return Denbora formatuan itzultzen duen string-a
	 */
	public String kenduWav(String filename);

	/**
	 * Musika jokalariaren denbora formatuan itzultzen duen metodoa.
	 * 
	 * @return Denbora formatuan itzultzen duen string-a
	 */
	public String denbora();
}