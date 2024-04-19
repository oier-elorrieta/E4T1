package Kontrolador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

    static String respuesta;

    public static Connection konektatua;
    
    public static void konexioa() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://10.5.6.108:3306/MIMI";
            String user = "admin";
            String pass = "1234";

            konektatua = DriverManager.getConnection(url, user, pass); 
            System.out.println("konektatuta");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
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