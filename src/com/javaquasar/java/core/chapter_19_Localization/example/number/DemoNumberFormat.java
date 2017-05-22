package com.javaquasar.java.core.chapter_19_Localization.example.number;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class DemoNumberFormat {

	public static void main(String[] args) {
		NumberFormat nfGe = NumberFormat.getInstance(Locale.GERMAN);
		NumberFormat nfUs = NumberFormat.getInstance(Locale.US);
		NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
		NumberFormat nfUa = NumberFormat.getInstance(new Locale("ua", "UA"));
		double iGe = 0, iUs = 0, iFr = 0, iUa = 0;
		String str = "1.245,999";
		try {
			// преобразование строки в германский стандарт
			System.out.println(iGe = nfGe.parse(str).doubleValue());
			// преобразование строки в американский стандарт
			System.out.println(iUs = nfUs.parse(str).doubleValue());
			// преобразование строки во французский стандарт
			System.out.println(iFr = nfFr.parse(str).doubleValue());
			// преобразование строки в украинский стандарт
			System.out.println(iUa = nfUa.parse(str).doubleValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		// преобразование числа из германского в американский стандарт
		String sUs = nfUs.format(iGe);
		// преобразование числа из германского во французский стандарт
		String sFr = nfFr.format(iGe);
		// преобразование числа из германского в украинский стандарт
		String sUa = nfUa.format(iGe);
		System.out.println(sUs + "\n" + sFr + "\n" + sUa);
	}

}
