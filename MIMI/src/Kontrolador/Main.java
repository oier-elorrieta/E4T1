package Kontrolador;

import Bista.LoginBista;
import Bista.MenuaBista;
import funtzioak.Konexioa;

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
