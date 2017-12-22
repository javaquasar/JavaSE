package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
 
public class DosFileAttributeExample {
    public static void main(String[] args) throws Exception {
        String path = "./file/lecture_3_07_task_5_01_result.txt";
 
        Path file = Paths.get(path);
        DosFileAttributes attr = Files.readAttributes(file, DosFileAttributes.class);
 
        System.out.println("isArchive()  = " + attr.isArchive());
        System.out.println("isHidden()   = " + attr.isHidden());
        System.out.println("isReadOnly() = " + attr.isReadOnly());
        System.out.println("isSystem()   = " + attr.isSystem());
    }
}
