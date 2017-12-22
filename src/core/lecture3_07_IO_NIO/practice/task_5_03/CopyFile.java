package core.lecture3_07_IO_NIO.practice.task_5_03;

import java.io.*;

public class CopyFile {
	public static void main(String[] args) throws IOException {

		String fileFromName = "lecture_3_07_task_5_03_java_io.png";
		
		File myPath = new File("/Users/artur/Documents/workspace_luna/NIX/file/");  
		myPath.mkdirs();
		String fileToName = myPath.getPath() + "/lecture_3_07_task_5_03_java_io_copy.png";
		System.out.println(fileToName);

		for (int k = 1; k <= 64 * 1024; k *= 2) {
			InputStream in = null;
			OutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(fileFromName), k);
				out = new BufferedOutputStream(new FileOutputStream(fileToName), k);
				long startTime = System.currentTimeMillis();
				copy0(in, out);
				long stopTime = System.currentTimeMillis();
				double g = (stopTime - startTime);
				System.out.println(k + " byte " + "Elapsed time = " + g);
			} catch (IOException e) {
				throw new IOException("Exception when open and read file" + fileFromName, e);
			} finally {
				closeQuietly(in);
				closeAndFlushQuietly(out);
			}
		}

	}

	public static void copy0(InputStream in, OutputStream out) throws IOException {

		int oneByte;
		while ((oneByte = in.read()) != -1) {
			out.write(oneByte);
			// System.out.print((char) oneByte);
		}
	}

	public static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {

		byte[] buff = new byte[bufferSize];
		int count;
		while ((count = in.read(buff)) != -1) {
			out.write(buff, 0, count);
			// System.out.print((char) oneByte);
		}
	}

	public static void closeQuietly(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException ignore) {

			}
		}
	}

	public static void closeAndFlushQuietly(OutputStream out) {
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
