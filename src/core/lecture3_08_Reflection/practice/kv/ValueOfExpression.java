package core.lecture3_08_Reflection.practice.kv;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * Created by Vitaliy on 21.01.15.
 */
public class ValueOfExpression {

    final String sourceFile = "./src/reflection/GenerateExpression.java";
    public void genSource(){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(new File(sourceFile)));
            writer.write("package reflection; import javax.script.ScriptEngine;\n" +
                    "import javax.script.ScriptEngineManager;\n" +
                    "import javax.script.ScriptException;");
            writer.write("public class GenerateExpression {");
            writer.write("public static void printHello(String expression) throws ScriptException {");
            writer.write("ScriptEngineManager engineManager = new ScriptEngineManager();");
            writer.write("ScriptEngine scriptEngine = engineManager.getEngineByName(\"JavaScript\");");
            writer.write("scriptEngine.eval(\"c = \" + expression + \";\" + \"print(c)\");");
           // writer.write("return"+ exp);
            writer.write("} }");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean compile(){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(null,null,null, sourceFile) == 0;
    }
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException, MalformedURLException {
        //String expression = new Scanner(System.in).next();
        ValueOfExpression valueOfExpression = new ValueOfExpression();
        valueOfExpression.genSource();
        if(valueOfExpression.compile()){
            URLClassLoader classLoader = new URLClassLoader(new URL[] {
                   new File("reflection.GenerateExpression.class").toURI().toURL() });

            System.out.println("Введите математическое выражение(без пробелов между символами) :");
            String exp  = new Scanner(System.in).next();
            Class<?> clas = null;
            try {
                //clas = Class.forName("reflection.GenerateExpression");
                clas = Class.forName("reflection.GenerateExpression", true, classLoader);
                Method m = clas.getMethod("printHello", String.class);
                m.invoke(null, new Object[]{exp});
            }
            catch (Exception e){

            }
        }
        //ScriptEngineManager engineManager = new ScriptEngineManager();
        //ScriptEngine scriptEngine = engineManager.getEngineByName("JavaScript");
        //scriptEngine.eval("c = " + expression + ";" + "print(c)");
    }
}
