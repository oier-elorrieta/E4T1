package Kontrolador;

import Bista.LoginBista;
import Bista.MenuaBista;
<<<<<<< HEAD
import funtzioak.Konexioa;
=======
import Kontrolador.Konexioa;
import Kontrolador.Konexioa;
>>>>>>> e9cbff5e7531b321ee6c4b1b7188b027ffb7e917

public class Main {

	public static void main(String[] args) {
		  try {
              LoginBista frame = new LoginBista();
              frame.setVisible(true);
          } catch (Exception ex) {
              ex.printStackTrace();
          }
		  Konexioa.konexioa();
	}

}
