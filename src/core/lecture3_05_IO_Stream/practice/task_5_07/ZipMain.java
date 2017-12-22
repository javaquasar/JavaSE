package core.lecture3_05_IO_Stream.practice.task_5_07;

import java.io.IOException;
import java.util.Date;

/*5.7 Архивация нескольких файлов*

Реализовать две программы, одна из которых осуществляет архивацию 
нескольких указанных файлов, а другая – извлечение их из архива.*/

public class ZipMain {
	public static void main(String[] args) throws IOException {
		String dirName = "src";// путь к папке которая упаковывается
		String zipName = "./result/lecture_3_05_task_5_07_nix.zip";// путь и имя создаваемого архива
		double startTime = System.currentTimeMillis();
		ZipOut.zipDir(dirName, zipName);
		double stopTime = System.currentTimeMillis();
		double g = (stopTime - startTime) / 1000;
		System.out.println(" архивация длилась " + g + " с.");
		
		Date date = new Date();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("./result/");
		stringBuilder.append(date);
		stringBuilder.append("_Nix.zip");
		
		double startTime2 = System.currentTimeMillis();
		ZipUtil.pack(dirName, stringBuilder.toString());
		//ZipUtil.unpack("Nix2.zip", "src");
		double stopTime2 = System.currentTimeMillis();
		double g2 = (stopTime2 - startTime2) / 1000;
		System.out.println(" архивация длилась " + g2 + " с.");
	}

}
