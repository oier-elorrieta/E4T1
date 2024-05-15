package DatuBasea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.Bezero;
import Modelo.FreeBezero;
import Modelo.PremiumBezeroa;
import funtzioak.BistakArgitaratu;
import funtzioak.DateFuntzioak;
import funtzioak.ErregistratuF;

public class BezeroDao {

	/**
	 * Metodo honek erabiltzailearen sartutako erabiltzailea eta pasahitza
	 * konprobatzen du. Sartutako erabiltzailea eta pasahitza datu basean dauden
	 * erabiltzaile eta pasahitzarekin konparatzen ditu. Sartutako erabiltzailea eta
	 * pasahitza datu basean aurkitzen badira, sesioa hasi egokia dela adierazten du
	 * eta MenuaBista klasearen instantzia sortzen du. Sartutako erabiltzailea eta
	 * pasahitza datu basean ez badira aurkitzen, errore mezua erakusten du eta
	 * sartutako eremuak husten ditu.
	 *
	 * @param textFieldErabiltzailea Erabiltzailearen erabiltzailea sartzen duen
	 *                               JTextField objektua.
	 * @param passwordFieldPasahitza Erabiltzailearen pasahitza sartzen duen
	 *                               JPasswordField objektua.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public static boolean LoginKomprobatu(String erabiltzailea , String pasahitza)
			throws SQLException {
		boolean loginOK = false;

		try (Connection con = Konexioa.konexioa()) {
			String kontsulta = "select * from bezeroa";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						String erabiltzaileaDB = rs.getString("erabiltzailea");
						String pasahitzaDB = rs.getString("pasahitza");
						String id_bezero = rs.getString("idbezeroa");
						String mota = rs.getString("mota");
						String izena = rs.getString("izena");
						String abizena = rs.getString("abizena");
							Bezero bz = new Bezero(id_bezero, izena, abizena, erabiltzaileaDB, pasahitzaDB, null, null, null, mota, null);

					

						if (erabiltzailea.equals(erabiltzaileaDB) && pasahitza.equals(pasahitzaDB)) {
							loginOK = true;
							JOptionPane.showMessageDialog(null, "Sesioa hasi da modu egokian");
							BistakArgitaratu.MenuJoan(bz);
							
						}
					}
					if (loginOK == false) {
						JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza txarto idatzi dituzu");

					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginOK;
	}

	/**
	 * HizkuntzaAtera metodoa erabiliko da datu basean dauden hizkuntzen zerrenda
	 * ateratzeko.
	 *
	 * @return Hizkuntzen zerrenda, String array moduan.
	 */
	public static String[] HizkuntzaAtera() {
		String[] hiz = null;
		int cont = 0;
		try (Connection con = Konexioa.konexioa()) {
			String countSql = "SELECT COUNT(*) AS total FROM hizkuntza";
			try (PreparedStatement sta = con.prepareStatement(countSql)) {
				try (ResultSet res = sta.executeQuery()) {
					if (res.next()) {
						cont = res.getInt("total");
					}
				}
			}

			hiz = new String[cont];

			String kontsulta = "SELECT idhizkuntza FROM hizkuntza";
			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					int index = 0;
					while (rs.next()) {
						String id = rs.getString("idhizkuntza");

						hiz[index] = id;
						index++;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hiz;
	}

	/**
	 * Hartu bezeroaren azken id-a eta sortu berriaren id-a.
	 * 
	 * @return Bezeroaren azken id-a + 1-ekoa formatu egokian (BZ001, BZ002, ...)
	 * @throws SQLException SQL errore bat gertatzen bada
	 */
	public static String hartuIdBezero() throws SQLException {

		String idberria = "";
		try (Connection con = Konexioa.konexioa()) {

			String kontsulta = "select idbezeroa from bezeroa order by idbezeroa desc limit 1";

			try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {

						String id = rs.getString("idbezeroa");

						String zenbakiaStr = id.substring(2);
						int zbk = Integer.parseInt(zenbakiaStr);

						zbk++;

						idberria = "BZ" + String.format("%03d", zbk);

					}

				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return idberria;

	}

	/**
	 * ErregistratuF klasean dagoen InsertFree metodoa. Erregistro bat sartzen du
	 * Bezeroa taulan.
	 *
	 * @param erregistroBezero Erregistroa sartu nahi den FreeBezero objektua.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public static void InsertFree(FreeBezero erregistroBezero) throws SQLException {

		erregistroBezero.setId(hartuIdBezero());

		try (Connection con = Konexioa.konexioa()) {

			String insert = "insert into bezeroa (idbezeroa, izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata, mota) values (?,?,?,?,?,?,?,?,?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, erregistroBezero.getId());
				preparedStatement.setString(2, erregistroBezero.getIzena());
				preparedStatement.setString(3, erregistroBezero.getAbizena());
				preparedStatement.setString(4, erregistroBezero.getHizkuntza());
				preparedStatement.setString(5, erregistroBezero.getErabiltzaile());
				preparedStatement.setString(6, erregistroBezero.getPasahitza());
				preparedStatement.setDate(7,
						new java.sql.Date(DateFuntzioak.StringtoDate(erregistroBezero.getJaioData()).getTime()));
				preparedStatement.setDate(8,
						new java.sql.Date(DateFuntzioak.StringtoDate(erregistroBezero.getErregisData()).getTime()));
				preparedStatement.setString(9, erregistroBezero.getMota());

				preparedStatement.executeUpdate();

				preparedStatement.close();

				con.close();

				System.out.println("Erregistroa ondo egina");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Metodo honek PremiumBezeroa objektua hartu eta datu-basean sartzen du.
	 * 
	 * @param berriaPre PremiumBezeroa objektua, sartu nahi den bezeroaren datuekin.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public static void InsertPremium(PremiumBezeroa berriaPre) throws SQLException {

		berriaPre.setId(hartuIdBezero());

		try (Connection con = Konexioa.konexioa()) {

			String insert = "insert into bezeroa (idbezeroa, izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata, mota) values (?,?,?,?,?,?,?,?,?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(insert);
				preparedStatement.setString(1, berriaPre.getId());
				preparedStatement.setString(2, berriaPre.getIzena());
				preparedStatement.setString(3, berriaPre.getAbizena());
				preparedStatement.setString(4, berriaPre.getHizkuntza());
				preparedStatement.setString(5, berriaPre.getErabiltzaile());
				preparedStatement.setString(6, berriaPre.getPasahitza());
				preparedStatement.setDate(7,
						new java.sql.Date(DateFuntzioak.StringtoDate(berriaPre.getJaioData()).getTime()));
				preparedStatement.setDate(8,
						new java.sql.Date(DateFuntzioak.StringtoDate(berriaPre.getErregisData()).getTime()));
				preparedStatement.setString(9, berriaPre.getMota());

				preparedStatement.executeUpdate();

				System.out.println("Erregistroa ondo egina");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		PremiumTabla(berriaPre);
	}

	/**
	 * Metodo honek PremiumBezeroa objektua jasotzen du eta datu basean premium
	 * taulan sartzen du.
	 *
	 * @param berriaPre PremiumBezeroa objektua, sartu nahi den bezeroaren datuekin.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public static void PremiumTabla(PremiumBezeroa berriaPre) throws SQLException {

		try (Connection con = Konexioa.konexioa()) {

			String Premiumtabla = "insert into premium (idbezeroa,iraungitzedata) values (?,?)";

			try {
				PreparedStatement preparedStatement = con.prepareStatement(Premiumtabla);
				preparedStatement.setString(1, berriaPre.getId());
				preparedStatement.setDate(2,
						new java.sql.Date(DateFuntzioak.StringtoDate(berriaPre.getPremiumMuga()).getTime()));

				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}
	
	public static void BezeroUpdate(Bezero bz, JTextField textIzena, JTextField textAbizena, JTextField textErabiltzalea, JPasswordField textPasahitza) throws SQLException {
		
		try (Connection con = Konexioa.konexioa()) {
			
			String izena = textIzena.getText();
			String abizena = textAbizena.getText();
			String erabil = textErabiltzalea.getText();
			String pasa = textPasahitza.getText();


			String update = "Update bezeroa set izena='" + izena + "', abizena='" + abizena + "', erabiltzailea='" + erabil + "', pasahitza='" + pasa +"' where idbezeroa='" + bz.getId() + "';" ;

	
			try {
				PreparedStatement preparedStatement = con.prepareStatement(update);
			

				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
	}
	
	
	public static Bezero BezeroUpdatePremium(Bezero bz) {



		try (Connection con = Konexioa.konexioa()) {



			String update = "update bezeroa set mota = 'premium' where idbezeroa ='" + bz.getId() + "';";



			try {

				PreparedStatement preparedStatement = con.prepareStatement(update);



				preparedStatement.executeUpdate();



				JOptionPane.showMessageDialog(null, "Orain urte bat premium duzu");



				bz.setMota("premium");

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}



		} catch (SQLException e1) {

			e1.printStackTrace();

		}



		return bz;



	}

public static boolean BezeroaPremiumEdoEz (Bezero bz) {
	
	boolean dago = false;
	try (Connection con = Konexioa.konexioa()) {

		String kontsulta = "select idbezeroa from premium where idbezeroa = '" + bz.getId() +  "';";

		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					
					JOptionPane.showMessageDialog(null, bz.getErabiltzaile() + " itzaron behar duzu hurrengo urterarte");
					 dago = true;

				}
				if (dago == false) {
					BezeroUpdatePremium (bz);
				}

			}

		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return true;
	
}


public static boolean Bezeroaexistitu (JTextField txtErabiltzaile) {
	
	
	boolean dago = true;
	try (Connection con = Konexioa.konexioa()) {

		String kontsulta = "select erabiltzailea from bezeroa where erabiltzailea = '" + txtErabiltzaile.getText()  +  "';";

		try (PreparedStatement pstmt = con.prepareStatement(kontsulta)) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					
					JOptionPane.showMessageDialog(null, txtErabiltzaile.getText() + " existitzen da");
					txtErabiltzaile.setText("");
					 dago = false;

				}

			}

		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return dago;
}

}
