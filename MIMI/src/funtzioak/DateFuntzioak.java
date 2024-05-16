package funtzioak;



import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Calendar;

import java.util.Date;



public class DateFuntzioak {

	

	/**

	 * Metodo honek emandako data java.util.Date motatik String motara bihurtzen du.

	 *

	 * @param selectDate data bihurtu nahi den java.util.Date objektua

	 * @return String motako data

	 */

	public static String DatetoString(java.util.Date selectDate) {



		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



		String strDate = dateFormat.format(selectDate);



		return strDate;

	}



	/**

	 * Konvertitzen du emandako datak String-etik Date objektuera.

	 *

	 * @param data String formatuko data bat

	 * @return datak Date objektu bezala konbertituta

	 */

	public static Date StringtoDate(String data) {



		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date dData = null;

		try {

			dData = dateFormat.parse(data);

		} catch (Exception e) {

			System.err.println("Error occurred: " + e.getMessage());

		}



		return dData;

	}



	public static String LocalDatetoString(LocalDate localDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String formattedString = localDate.format(formatter);

		return formattedString;

	}

	

	public static DateTimeFormatter LocalDateFormatua() {

		DateTimeFormatter gaurkoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return gaurkoData;

	}

}

