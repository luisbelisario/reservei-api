package com.luis.reservei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String todaysDate() {
		String formattedDate = fmt.format(new Date());
		return formattedDate;
	}
	
	public static Date toDate(String stringDate) throws ParseException {
		Date date = fmt.parse(stringDate);
		return date;
	}
}
