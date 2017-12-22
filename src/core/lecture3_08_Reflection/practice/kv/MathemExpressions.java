package core.lecture3_08_Reflection.practice.kv;

import javax.script.*;
import java.util.Scanner;

/**
 * Created by Vitaliy on 21.01.15.
 */
public class MathemExpressions {
    public static void main(String[] args) throws ScriptException {
        String expression = "Math.PI*2";
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        engine.eval("c = " + expression + ";" + "print(c)");
    }
}
