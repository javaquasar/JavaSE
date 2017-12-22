package core.lecture3_08_Reflection.practice.task_7_03;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MathInterpretation {

	public static void main(String[] args) throws Exception {
		String ex = new Scanner(System.in).next();
		String test = "print(33*2)";
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		engine.eval("print("+ex+")");
	}

}
