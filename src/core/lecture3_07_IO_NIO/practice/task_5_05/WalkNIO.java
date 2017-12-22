package core.lecture3_07_IO_NIO.practice.task_5_05;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;


public class WalkNIO {
	

	  private static class Finder extends SimpleFileVisitor<Path> {

	    @Override
	    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	        throws IOException {
	    	DosFileAttributes attr = Files.readAttributes(file,
					DosFileAttributes.class);
	    	if(attr.isHidden())
	    		System.out.println(file);
	      return FileVisitResult.CONTINUE;
	    }

	    @Override
	    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
	        throws IOException {
	      System.out.println("----------------" + dir + "----------------");
	      return FileVisitResult.CONTINUE;
	    }

	  }

	  public static void main(String[] args) {
	    String dirName = "D:/Hidden";
	    try {
	      Files.walkFileTree(Paths.get(dirName), new Finder()); // Текущий каталог
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	}



