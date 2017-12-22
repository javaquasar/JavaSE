package core.lecture3.control.number_3;

import java.io.*;

public class CopyFile {

	private static final int bufferSize = 64 * 1024;

	public static void copy(String pathFrom, String pathTo, String fileName) throws IOException {
		File myPath = new File(pathTo);
		myPath.mkdirs();
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(pathFrom), bufferSize);
			out = new BufferedOutputStream(new FileOutputStream(pathTo + fileName), bufferSize);
			copy(in, out);
		} catch (IOException e) {
			throw new IOException("Exception when open and read file" + pathFrom, e);
		} finally {
			closeQuietly(in);
			closeAndFlushQuietly(out);
		}
	}

	private static void copy(InputStream in, OutputStream out) throws IOException {
		int oneByte;
		while ((oneByte = in.read()) != -1) {
			out.write(oneByte);
			// System.out.print((char) oneByte);
		}
	}

	private static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {
		byte[] buff = new byte[bufferSize];
		int count;
		while ((count = in.read(buff)) != -1) {
			out.write(buff, 0, count);
			// System.out.print((char) oneByte);
		}
	}

	private static void closeQuietly(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException ignore) {

			}
		}
	}

	private static void closeAndFlushQuietly(OutputStream out) {
		if (out != null) {
			try {
				out.flush();
			} catch (IOException ignore) {
			}
			try {
				out.close();
			} catch (IOException ignore) {
			}
		}
	}

}
