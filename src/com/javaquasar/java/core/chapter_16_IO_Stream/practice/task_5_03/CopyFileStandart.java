package com.javaquasar.java.core.chapter_16_IO_Stream.practice.task_5_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyFileStandart {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * String from = "/Users/artur/Documents/workspace_luna/NIX/file/";
		 * String to = "/Users/artur/Documents/workspace_luna/NIX/fileNIO/";
		 */

		String to = "/Users/artur/Documents/workspace_luna/NIX/file/";
		String from = "/Users/artur/Documents/workspace_luna/NIX/fileNIO/";

		String fileName = "lecture_3_07_task_5_03_java_io_copy_NIO.png";

		Path pathSource = Paths.get(from + fileName);
		File myPath = new File(to);
		myPath.mkdirs();
		String fileToName = myPath.getPath() + "/" + fileName;

		System.out.println(fileToName);

		Path pathDestination = Paths.get(fileToName);
		try {
			Files.copy(pathSource, pathDestination);
			System.out.println("Source file copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Чтобы удалить файл введите 1");
		int i = scanner.nextInt();
		if (i == 1) {
			File file = new File(from);
			if (!delete(file)) {
				System.out.println("The folder is not deleted!");
			} else {
				System.out.println("Folder deleted successfully!");
			}
		}
	}

	public static boolean delete(File file) {
		if (!file.exists()) {
			return false;
		}
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				delete(f);
			}
			return file.delete();
		} else {
			return file.delete();
		}
	}

	public static Boolean copyFile(File source, File dest) {
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			int nLength;
			byte[] buf = new byte[8000];
			while (true) {
				nLength = is.read(buf);
				if (nLength < 0) {
					break;
				}
				os.write(buf, 0, nLength);
			}
			return true;
		} catch (IOException ex) {

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception ex) {
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (Exception ex) {
				}
			}
		}
		return false;
	}

	private static void copingFiles(String path, String dest) {
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				File newDir = new File(dest, fileList[i].getName());
				System.out.println(newDir.getAbsolutePath());
				newDir.mkdir();
				copingFolders(fileList[i].getAbsolutePath(), newDir.getAbsolutePath());
			} else {
				/* тут копируем файл */
			}
		}
	}

	private static void copingFolders(String path, String dest) {
		File coping = new File(path);
		File[] listFiles = coping.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File newDir = new File(dest, listFiles[i].getName());
			System.out.println(newDir.getAbsolutePath());
			newDir.mkdir();
			File[] tmpList = listFiles[i].listFiles();
			if (tmpList.length != 0) {
				copingFiles(listFiles[i].getAbsolutePath(), newDir.getAbsolutePath());
			}
		}
	}

	/*private final static int MAX_STACK_SIZE = 2048;

	public static void copyDirectory(File srcFile, File destFile)

	throws IOException {

		if (!srcFile.isDirectory() || !destFile.isDirectory()) {

			throw

			new IOException("Src or dest files are not folders");
		}

		else {
			stackCopy(srcFile, destFile);
			// recursiveCopy(srcFile, destFile);
		}
	}

	private static void stackCopy(File srcFile, File destFile) throws IOException {
		ArrayStack<File> srcStack = new ArrayStack<File>(MAX_STACK_SIZE);
		ArrayStack<File> destStack = new ArrayStack<File>(MAX_STACK_SIZE);
		File srcDirectory = srcFile;
		srcStack.push(srcDirectory);
		File destDirectory = destFile;
		destStack.push(destDirectory);

		while (srcStack.size() > 0) {
			File[] childFiles = srcDirectory.listFiles();

			for (File srcChild : childFiles) {
				File destChild =

				new File(destDirectory, srcChild.getName());

				if (srcChild.isFile())
					copyFile(srcChild, destChild);

				else {
					destChild.mkdir();
					srcStack.push(srcChild);
					destStack.push(destChild);
				}
			}
			srcDirectory = srcStack.pop();
			destDirectory = destStack.pop();
		}
	}*/

}
