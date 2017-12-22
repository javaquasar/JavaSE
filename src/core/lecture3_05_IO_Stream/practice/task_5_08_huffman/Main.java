package core.lecture3_05_IO_Stream.practice.task_5_08_huffman;
import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree.CodeMaker;
import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree.Heap;
import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.tree.Node;
import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.io.BinaryWriter;
import core.lecture3_05_IO_Stream.practice.task_5_08_huffman.io.HuffmanWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String manual = "Ошибка!";

		File file = null;
		//String[] args = {"c", "./hamlet.txt"};
		//String[] args = { "x", "./hamlet.txt_huffpack" };

		// ./src/testi_cormen_huffpack

		if (args.length == 2) {
			file = new File(args[1]);
		} else {
			System.out.println(manual);
			System.exit(0);
		}

		if (args[0].equals("c")) {
			compress(file);
		}

		else if (args[0].equals("x")) {
			if (!file.getName().endsWith("_huffpack")) {
				System.out.println("Virhe! Antamasi tiedosto ei ole huffman-paketti");
			}
			extract(file);
		}

		else {
			System.out.println(manual);
		}
	}

	private static void calculateFreqs(File file, Heap heap)
			throws FileNotFoundException, IOException {
		FileInputStream fin = new FileInputStream(file);

		while (fin.available() > 0) {
			byte b = (byte) fin.read();
			heap.addOrIncrement(new Node(b));
		}
		fin.close();
	}

	private static void writeHuffmanBytes(File file, String[] codes,
			FileOutputStream fout) throws FileNotFoundException, IOException {
		FileInputStream fin = new FileInputStream(file);
		HuffmanWriter hw = new HuffmanWriter(fout);
		while (fin.available() > 0) {
			int b = fin.read();
			if (fin.available() == 0) {
				hw.addBits(codes[b], true);
			} else {
				hw.addBits(codes[b], false);
			}
		}
		fin.close();
		fout.close();
	}

	private static void compress(File file) throws IOException {
		FileOutputStream fout = new FileOutputStream(new File(file.getName()
				+ "_huffpack"));
		Heap heap = new Heap();
		calculateFreqs(file, heap);
		CodeMaker cm = new CodeMaker(heap);
		String[] codes = cm.getCodes();
		int codeSum = 0;
		String dictString = "";
		for (int i = 0; i < 256; i++) {
			if (codes[i] != null) {
				codeSum++;
				dictString += (char) i + " " + codes[i] + "|";
			}
		}
		fout.write((byte) codeSum);
		for (int i = 0; i < dictString.length(); i++) {
			fout.write((byte) dictString.charAt(i));
		}
		writeHuffmanBytes(file, codes, fout);
	}

	private static void extract(File file) throws FileNotFoundException,
			IOException {
		File outFile = new File(file.getName() + "_extracted");
		FileOutputStream fo = new FileOutputStream(outFile);
		BinaryWriter bw = new BinaryWriter(fo);
		FileInputStream fin = new FileInputStream(file);
		int dictLength = fin.read();

		for (int i = 0; i < dictLength; i++) {
			int b = fin.read();
			fin.read();
			String code = "";
			while (true) {
				char bit = (char) fin.read();
				if (bit == '0' || bit == '1') {
					code += bit;
				} else if (bit == '|') {
					break;
				}
			}
			bw.addCode((byte) b, code);
		}

		while (fin.available() > 0) {
			int b = fin.read();
			if (fin.available() == 0) {
				bw.addByte(b, true);
			} else {
				bw.addByte(b, false);
			}
		}

	}
}
