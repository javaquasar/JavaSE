package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * Created by Java Quasar on 26.05.2017.
 */
/*
RandomAccessFile в Java предоставляет возможность читать с файла и записывать данные в файл.
RandomAccessFile работает с файлом как с большим массивом байтов.
Он использует курсор с помощью которого мы можем переместить указатель файла в определенную позицию.

При создании экземпляра RandomAccessFile, мы должны выбрать режим файла,
например
"r", если вы хотите прочитать данные с файла или
"rw" — если вы хотите читать с файла и писать в файл.

С помощью указателя файла мы можем читать из файла или записывать данные в файл в любом месте.
Чтобы получить текущий указатель файла, используется метод getFilePointer().

Чтобы установить индекс указателя файла используется метод seek(int i).

Следует отметить, что если мы пишем в файл по индексу, где данные уже присутствуют, то они будут заменены.
 */
public class RandomAccessFileExample {
    public static void main(String[] args) {
        try {
            String filePath = "./file/16/random_access_file.txt";
            System.out.println(new String(readCharsFromFile(filePath, 1, 5)));

            writeData(filePath, "Data", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // метод для записи данных в файл
    private static void writeData(String filePath, String data, int seek) throws IOException {
        // открываем файл с возможностью как чтения, так и записи
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        // переходим на определенный индекс
        file.seek(seek);
        // запишем данные в этом месте
        file.write(data.getBytes());
        file.close();
    }

    // метод для чтения с файла
    private static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException {
        // открываем файл только для чтения
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(seek);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }
}
