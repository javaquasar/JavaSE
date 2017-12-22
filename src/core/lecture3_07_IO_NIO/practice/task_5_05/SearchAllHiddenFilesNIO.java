package core.lecture3_07_IO_NIO.practice.task_5_05;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Object> {
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
		System.out.println("file name:" + path.getFileName());
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
		System.out.println("Directory name:" + path);
		return FileVisitResult.CONTINUE;
	}
}

public class SearchAllHiddenFilesNIO {
	public static void main(String[] args) {

		Path pathSource = Paths.get("/Users/artur/Documents/workspace_luna/NIX");
		try {
			Files.walkFileTree(pathSource, new MyFileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*public static void showHiddenList(File dir) throws IOException{
  for (File f : dir.listFiles()) {
        if (!f.isDirectory())
        {
         DosFileAttributes attr = Files.readAttributes(dir.toPath(),DosFileAttributes.class);
          if (attr.isHidden())
            System.out.println(f.getCanonicalPath());
        }
      }
      for (File f : dir.listFiles()) {
        if (f.isDirectory())
          showHiddenList(f);
      }
 }*/
