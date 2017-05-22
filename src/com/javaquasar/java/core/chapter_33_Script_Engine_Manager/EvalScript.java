package com.javaquasar.java.core.chapter_33_Script_Engine_Manager;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class EvalScript {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		engine.eval("print('Hello, World')");
	}

}
