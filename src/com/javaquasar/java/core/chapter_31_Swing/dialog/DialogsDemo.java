package com.javaquasar.java.core.chapter_31_Swing.dialog;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class DialogsDemo {

	public static void main(String[] args) {
		do {
			Double a = (double) 0;
			try {
				a = Double.parseDouble(JOptionPane.showInputDialog("Введите действительное число >= 0"));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Необходимо ввести число!");
			}
			if (a == null)
				JOptionPane.showMessageDialog(null, "Неправильное значение!");
			else
				JOptionPane.showMessageDialog(null, "Корень квадратный: " + roundNumber(getSquareRoot(a), 3));
			if (JOptionPane.showConfirmDialog(null, "Продолжить?") != JOptionPane.YES_OPTION)
				break;
		} while (true);
	}

	// квадратный корень метод Ньютона
	public static Double getSquareRoot(Double a) {
		if (a < 0) {
			return null;
		}
		double EPS = 0.000005;
		double xnew = a / 2;
		double xold = 0;
		while (Math.abs(xnew - xold) > EPS) {
			xold = xnew;
			xnew = ((xold + a / xold) / 2);
		}
		return xnew;
	}
	
	public static BigDecimal roundNumber(double value, int digits) {
        //we approximate the transferred number "value" with accuracy "digits"          
        BigDecimal num = new BigDecimal(value).setScale(digits, BigDecimal.ROUND_UP);
        return num;
    }

}
