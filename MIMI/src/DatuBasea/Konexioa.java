package DatuBasea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

    static String respuesta;

    public static Connection konektatua;
    
    /**
     * Metodo honek konexioa sortzen du datu-basearekin.
     *
     * @return konexioa sortutako Connection objektua
     */
    public static Connection konexioa() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

           String url = "jdbc:mysql://10.5.6.108/MIMI";
            String user = "admin";
            String pass = "1234";
            

//            String url = "jdbc:mysql://localhost:3306/MIMI";
//            String user = "root";
//            String pass = "";

            konektatua = DriverManager.getConnection(url, user, pass); 
            System.out.println("konektatuta");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Tira la db");
        }
		return konektatua;
    }
    
    /**
     * It closes the connection to the database.
     * 
     * @throws SQLException if an error occurs while closing the connection
     */
    public static void konexioaExit() {
    	try {
	        konektatua.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void objetuakHasi() {
    	
    }
    
}