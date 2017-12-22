package core.lecture3_08_Reflection.practice.kv;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Vitaliy on 22.01.15.
 */
public class StringProcessor {
    final String sourceFile = "./src/reflection/StrFun.java";

    void genSource(String expression) {
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("package reflection;");
            out.println("public class StrFun {");
            out.println("  public static String transform(String s) {");
            out.println("    return " + expression + ";");
            out.println("  }");
            out.println("}");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean compile() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(null, null, null, sourceFile) == 0;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        StringProcessor sp = new StringProcessor();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение, которое нужно выполнить над строкой s:");
        String expression = scan.nextLine().replaceAll("\"", "\\\"");
        sp.genSource(expression);
        try {
            if (sp.compile()) {
                System.out.println("Введите строку s:");
                String s = scan.nextLine();
                Class<?> cls = Class.forName("reflection.StrFun");
                Method m = cls.getMethod("transform", String.class);
                System.out.println(m.invoke(null, new Object[] { s }));
            }
            else {
                System.out.println("Ошибка ввода выражения!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
