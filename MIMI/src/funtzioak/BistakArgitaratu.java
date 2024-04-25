package funtzioak;

import Bista.ErregistroBista;
import Bista.LoginBista;
import Bista.MenuaBista;

public class BistakArgitaratu {

	/**
	 * 
	 * Metodo honek Login bistara eramaten gaitu.
	 * 
	 * 
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
	 * 
	 * Metodo honek Erregistro bistara eramaten gaitu.
	 * 
	 * 
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
	 * 
	 * Metodo honek Menu bistara eramaten gaitu.
	 * 
	 * 
	 */
	public static void MenuJoan() {

		try {
			MenuaBista frame = new MenuaBista();
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
}
