package core.lecture3_04_Localization.practice.task_8_10;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class df {

	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = formatter.format(today);
		System.out.println(formattedDate);  
		DateFormatSymbols symbols = new DateFormatSymbols();
		String[] oddMonthAbbreviations = new String[] {"Ja","Fe","Mh","Ap","My","Jn","Jy","Au","Se","Oc","No","De" };
		symbols.setShortMonths(oddMonthAbbreviations);
		formatter = new SimpleDateFormat("MMM dd, yyyy", symbols);
		formattedDate = formatter.format(today);
		System.out.println(formattedDate);  
	}

}
