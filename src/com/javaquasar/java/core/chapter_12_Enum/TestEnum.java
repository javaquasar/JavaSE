package com.javaquasar.java.core.chapter_12_Enum;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*
Перечисление - это класс



в Java использование обобщений в enum запрещено.
 */
public class TestEnum {
    public static void main(String[] args) {
        // Enum можно исползовать в конструкциях switch
        switch (SimpleEnum.THREE) {
            case ONE:
                System.out.println("Mondays are bad.");
                break;
            case TWO:
                System.out.println("Fridays are better.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }

        /*
        Объявляя enum мы неявно создаем класс производный от java.lang.Enum.
        Условно конструкция enum SimpleEnum { ... } эквивалентна class SimpleEnum extends java.lang.Enum { ... }.
        И хотя явным образом наследоваться от java.lang.Enum нам не позволяет компилятор, все же в том, что enum наследуется,
        легко убедиться с помощью reflection:
         */

        System.out.println("SimpleEnum наследуется от = " + SimpleEnum.class.getSuperclass());
        System.out.println("SimpleEnum.ONE наследуется от = " + SimpleEnum.ONE.getClass().getSuperclass());
        System.out.println("SimpleEnum.TWO наследуется от = " + SimpleEnum.TWO.getClass().getSuperclass());
        System.out.println("SimpleEnum.THREE наследуется от = " + SimpleEnum.THREE.getClass().getSuperclass());
        System.out.println("------------------");

        System.out.println("SimpleEnum.class = " + SimpleEnum.class);
        System.out.println("SimpleEnum.ONE.getClass = " + SimpleEnum.ONE.getClass());
        System.out.println("SimpleEnum.TWO.getClass = " + SimpleEnum.TWO.getClass());
        System.out.println("SimpleEnum.THREE.getClass = " + SimpleEnum.THREE.getClass());
        System.out.println("------------------");

        /*
        Здесь объявляется перечисление Direction_2 с двумя элементами UP и DOWN. Компилятор создаст следующие классы и объекты:

        Direction_2 - класс производный от java.lang.Enum
        UP - объект 1-го класса производного от Direction_2
        DOWN - объект 2-го класса производного от Direction_2

        Два производных класса будут созданы с полиморфным методом Object opposite()
        При этом объекты классов UP и DOWN существуют в единственном экземпляре и доступны статически. В этом можно убедится:
         */
        System.out.println("Direction_2.class = " + Direction_2.class);
        System.out.println("Direction_2.UP.getClass = " + Direction_2.UP.getClass() + " " + Direction_2.UP.getClass().getSuperclass());
        System.out.println("Direction_2.DOWN.getClass = " + Direction_2.DOWN.getClass() + " " + Direction_2.DOWN.getClass().getSuperclass());
        System.out.println("------------------");

        System.out.println(Direction_1.DOWN.opposite());
        System.out.println(Direction_2.DOWN.opposite());

        /*
        Элементы enum SimpleEnum (ONE, TWO и т.д.) - это статически доступные экземпляры enum-класса SimpleEnum.
        Их статическая доступность позволяет нам выполнять сравнение с помощью оператора сравнения ссылок ==. Пример:
         */

        SimpleEnum simpleEnum = SimpleEnum.ONE;
        if (simpleEnum == SimpleEnum.TWO) {
            simpleEnum = SimpleEnum.THREE;
        }

        /*
        Как уже было сказано ранее любой enum-класс наследует java.lang.Enum,
        который содержит ряд методов полезных для всех перечислений. Пример:
         */

        SimpleEnum se = SimpleEnum.ONE;
        System.out.println("se.name()=" + se.name()
                + " se.toString()=" + se.toString()
                + " se.ordinal()=" + se.ordinal());

        /*
        Получение елемента enum по строковому представлению его имени

        Довольно часто возникает задача получить элемент enum по его строковому представлению.
        Для этих целей в каждом enum-классе компилятор автоматически создает специальный статический метод:
            public static EnumClass valueOf(String name), который возвращает элемент перечисления
            EnumClass с названием, равным name. Пример использования:
         */

        String name = "ONE";
        SimpleEnum se_2 = SimpleEnum.valueOf(name);
        System.out.println("se_2 = " + se_2);

        // Нахождение enum по внутреннему полю number
        System.out.println(EnumWithField.getEnumByNumber(10).getNameParamentr());
    }
}

enum SimpleEnum {
    ONE,
    TWO,
    THREE;
}

enum EnumWithField {
    ONE(10, "__one__"),
    TWO(20, "__two__");

    private int number;
    private String nameParamentr;

    private EnumWithField(int number, String nameParamentr) {
        this.number = number;
        this.nameParamentr = nameParamentr;
        System.out.println("Constructor block in EnumWithField");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNameParamentr() {
        return nameParamentr;
    }

    public void setNameParamentr(String nameParamentr) {
        this.nameParamentr = nameParamentr;
    }

    public static EnumWithField getEnumByNumber(int number) {
        for(EnumWithField enumWithField : values()) {
            if(enumWithField.getNumber() == number) {
                return enumWithField;
            }
        }
        return ONE;
    }

    // Секция static в enum выполняется после инициализации конструкторов объектов
    static {
        System.out.println("Static block in EnumWithField");
    }

}

// У Вас есть возможность добавлять собственные методы как в enum-класс, так и в его элементы:
enum Direction_1 {
    UP,
    DOWN;

    public Direction_1 opposite() {
        return this == UP ? DOWN : UP;
    }
}

// То же, но с полиморфизмом:
enum Direction_2 {
    UP {
        public Direction_2 opposite() { return DOWN; }
    },
    DOWN {
        public Direction_2 opposite() { return UP; }
    };

    public abstract Direction_2 opposite();
}
