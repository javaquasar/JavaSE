package com.javaquasar.java.core.chapter_16_IO_Stream.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Java Quasar on 26.05.2017.
 */

/*
Класс Java File имеет возможность установить права доступа к файлам, но он не является универсальным.
Самый большой его недостаток в том, что вы можете разделить права доступа к файлам только на два типа пользователей —
на владельца и на всех остальных. Вы не можете установить различные права доступа к файлам для группы или других пользователей.

Начиная с Java 7 был введен PosixFilePermission Enum и java.nio.file.Files включая метод setPosixFilePermissions(Path path, Set perms),
которые могут быть использованы для установки прав доступа к файлам.

Вот простая программа, которая наглядно показывает преимущества PosixFilePermission:
 */
public class FilePermissions {
    public static void main(String[] args) throws IOException {
        File file = new File("./file/16/file_with_permissions.txt");

        // устанавливаем права доступа для пользователей 455
        file.setExecutable(false);
        file.setReadable(false);
        file.setWritable(true);

        // изменяем права доступа для всех пользователей на 777
        // без использования групп и других пользователей
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);

        //используем PosixFilePermission для установки прав на 777
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        // добавляем разрешения для владельца
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);

        //добавляем разрешения для группы
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);

        //добавляем разрешения для всех остальных
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);

        Files.setPosixFilePermissions(Paths.get("file_with_permissions.txt"), perms);
    }
}
