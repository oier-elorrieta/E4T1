package DatuBasea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * 
 * Datu basearekin konexioa sortzeko klasea.
 * 
 * Sortu eta itxi konexioa.
 */
public class Konexioa {

    static String respuesta;

    public static Connection konektatua;
    
    /**
     * Metodo honek konexioa sortzen du datu-basearekin.
     *
     * @return konexioa sortutako Connection objektua
     * 
     * @throws SQLException SQL errore bat gertatzen bada
     * 
     *
     */
    public static Connection konexioa() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://10.5.6.108/mimi";
//            String user = "admin";
//            String pass = "1234";
            

            String url = "jdbc:mysql://localhost:3306/mimi";
            String user = "root";
            String pass = "";

            konektatua = DriverManager.getConnection(url, user, pass); 
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Ezin da konexioa egin, mesedez egiaztatu zure konexioa edo itxi Aplikazioa", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
		return konektatua;
    }
    
   /**
    * Konexioa itzi duen metodoa.
    */
    public static void konexioaExit() {
    	try {
	        konektatua.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    

    
}