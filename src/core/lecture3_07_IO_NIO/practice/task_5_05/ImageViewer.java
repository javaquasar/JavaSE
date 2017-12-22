package core.lecture3_07_IO_NIO.practice.task_5_05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageViewer {
	private static final Logger log = Logger.getLogger(ImageViewer.class.getName());

	public static void main(String[] args) throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File choosedDirectory = fileChooser.getSelectedFile();
			List<BufferedImage> imageList = getImagesFromDirectory(choosedDirectory);
			log.info("Из каталога " + choosedDirectory + " прочитано изображений: " + imageList.size());
		}
	}

	private static List<BufferedImage> getImagesFromDirectory(File directory) throws IOException {
		final List<BufferedImage> imageList = new ArrayList<BufferedImage>();
		Path path = Paths.get(directory.getPath());
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
				File file = path.toFile();
				try {
					BufferedImage image = ImageIO.read(file);
					if (image != null) {
						imageList.add(image);
						log.info("Прочитано изоражение из файла " + file);
					}
				} catch (Exception ex) {
					log.warning("Ошибка чтения файла " + file + ": " + ex.getLocalizedMessage());
				}
				return FileVisitResult.CONTINUE;
			}
		});
		return imageList;
	}
}
