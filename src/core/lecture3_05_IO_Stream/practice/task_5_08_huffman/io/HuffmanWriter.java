package core.lecture3_05_IO_Stream.practice.task_5_08_huffman.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HuffmanWriter {

	private boolean[] bits;
	private int mark;
	FileOutputStream fout;

	public HuffmanWriter(FileOutputStream fo) throws FileNotFoundException {
		this.fout = fo;
		this.bits = new boolean[20];
		this.mark = 0;
		this.fout = fo;
	}

	public void addBits(String code, boolean stop) throws IOException {
		char[] binary = code.toCharArray();
		for (int i = 0; i < binary.length; i++) {

			if (binary[i] == '1') {
				this.bits[mark] = true;
			} else {
				this.bits[mark] = false;
			}
			mark++;

			if (mark > 7) {
				writeByte();
			}
		}
		if (stop) {
			int trashBits = 0;
			if (mark > 0) {
				for (int j = mark; j < 8; j++) {
					this.bits[j] = true;
					mark++;
					trashBits++;
				}
				writeByte();
			}
			fout.write((byte) trashBits);
		}
	}

	public static int bitsToByte(boolean[] bits) {
		if (bits == null || bits.length != 8) {
			throw new IllegalArgumentException();
		}
		int data = 0;
		for (int i = 0; i < 8; i++) {
			if (bits[i]) {
				data += (1 << (7 - i));
			}
		}
		return data;
	}

	private void writeByte() throws IOException {
		boolean[] byteBits = new boolean[8];
		System.arraycopy(bits, 0, byteBits, 0, 8);
		processOverflow();
		byte b = (byte) bitsToByte(byteBits);
		fout.write(b);
	}

	private void processOverflow() {
		boolean[] newbits = new boolean[20];
		int bitsLeft = mark - 8;
		if (bitsLeft > 0) {
			System.arraycopy(bits, 8, newbits, 0, bitsLeft);
		}
		this.bits = newbits;
		this.mark = bitsLeft;
	}

}