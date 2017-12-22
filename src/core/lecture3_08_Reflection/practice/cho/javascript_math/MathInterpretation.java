package core.lecture3_08_Reflection.practice.cho.javascript_math;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/*7.3 ������������� �������������� ���������*
 ������� ���������, ������� ��������� ������� �������������� ���������, ��������� � �������� ���������.
 ��������� ����� �������� �� ��������, �������������� �������� � ������. ��� ���������� ������������ 
 �������� ������ javax.script.

 ����������. ��������� �������������� ��������� JavaScript ��������� ���������� Java. ��������� ����� 
 �������� � ������� ������� print() ��� �������� �������������� ����������.*/

public class MathInterpretation {

	public static void main(String[] args) throws Exception {
		String ex = new Scanner(System.in).next();
		String test = "print('12+4/3')";
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(engine.eval("c = a + b;"));
		
	}
}
