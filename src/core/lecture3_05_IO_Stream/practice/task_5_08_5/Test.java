package core.lecture3_05_IO_Stream.practice.task_5_08_5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) throws IOException {
		File inputFile = new File("./file/lecture_3_05_task_5_08_text.txt");
		File outputFile = new File("./file/lecture_3_05_task_5_08_text_compress");

		InputStream in = null;
		BitOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(inputFile));
			out = new BitOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			AdaptiveHuffmanCompress.compress(in, out);
		} finally {
			out.close();
			in.close();
		}
		
		// Otherwise, decompress
		File inputFileDecompress = new File("./file/lecture_3_05_task_5_08_text_compress");
		File outputFileDecompress = new File("./file/lecture_3_05_task_5_08_text_decompress.txt");
				
		BitInputStream inDecompress = new BitInputStream(new BufferedInputStream(new FileInputStream(inputFileDecompress)));
		OutputStream outDecompress = new BufferedOutputStream(new FileOutputStream(outputFileDecompress));
		try {
			AdaptiveHuffmanDecompress.decompress(inDecompress, outDecompress);
		} finally {
			out.close();
			in.close();
		}

	}

}
