package core.lecture3_04_Localization.practice.task_8_03;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class EndToBeginString {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        CharacterIterator characterIterator = new StringCharacterIterator(str);
        System.out.println("\nвведите позицию с которой начинать пролистывание :\n");

        int position =  new Scanner(System.in).nextInt();

        assert (position <= str.length() -1);
        for (char ch = characterIterator.setIndex(position); ch != CharacterIterator.DONE ; ch = characterIterator.previous())
        {
            System.out.print(ch);
        }
    }
}
