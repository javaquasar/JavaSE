package core.lecture3.control.number_3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class LoaderForClass extends Thread {
	private static final String DOT = ".";
	private static boolean work = true;
	private String nameMethod = null;
	private String path = null;

	private static URLClassLoader classLoader = null;
	private static Class<?> c = null;
	private static ArrayList<String> res = new ArrayList<String>();

	public static void main(String[] args) {
		final String path = "../Nix2/bin/";
		LoaderForClass loaderForClass = new LoaderForClass(path, "toInit");
		loaderForClass.execute();
		try {
			classLoader = new URLClassLoader(new URL[] { new File("/Users/artur/Desktop/test/test/").toURI().toURL() });

			try {
				c = Class.forName("TestClass3", true, classLoader);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				System.out.println(e.getMessage());
			} catch (NoClassDefFoundError e) {
				System.out.println(e.toString());
			}
			// Object obj = c.newInstance();

			/*
			 * for (int i = 0; i < obj.getClass().getMethods().length; i++) { if
			 * (obj.getClass().getMethods()[i].getName().equals("toInit")) {
			 * Method m = obj.getClass().getMethods()[i]; m.invoke(obj); } }
			 */
			/*
			 * Method method = c.getDeclaredMethod("toInit", null); //
			 * c.getMethod("toInit", null).invoke(c.newInstance());
			 * method.setAccessible(true); method.invoke(c.newInstance());
			 * System.out.println("------------------"); content =
			 * Repository.lookupClass("matrix.MatrixAbstract");
			 * System.out.println(content);
			 */
		} catch (MalformedURLException | SecurityException | IllegalArgumentException e) {
			System.out.println(e.getMessage());

			// e.printStackTrace();
		}
		// Полученный объект classLoader можно испольозвать для загрузки класса:

		// work("C:/Users/Студент1/Documents/eclipse/Nix2/TestClass1",
		// "toInit");

	}

	private LoaderForClass(String path, String nameMethod) {
		this.nameMethod = nameMethod;
		this.path = path;
	}

	public static LoaderForClass getInstance(String path, String nameMethod) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			return new LoaderForClass(path, nameMethod);
		} else {
			throw new IOException("Директория " + path + "не существует!!!");
		}
	}

	@Override
	public void run() {
		listAll(path, res);
		while (!isInterrupted()) {
			// System.out.println("Работа");
		}
		print();
	}

	public void stopWork() {
		work = false;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void execute() {
		listAll(path, res);
	}

	public String getNameMethod() {
		return nameMethod;
	}

	public void setNameMethod(String nameMethod) {
		this.nameMethod = nameMethod;
	}

	private void listAll(String path, ArrayList<String> res) {
		File dir = new File(path);
		File[] list = dir.listFiles();

		for (File f : list) {
			if (!isInterrupted()) {
				if (f.isFile()) {
					if (compareExtention(f, "class")) {
						if (execute(f)) {
							// res.add("F: " + f.getName());
							try {
								// System.out.println("F: " +
								// f.getCanonicalPath());
								// res.add("F: " +
								// getFileNameWithoutExtention(f.getCanonicalPath()));
								res.add("F: " + f.getCanonicalPath());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					try {
						// res.add("D: " + f.getCanonicalPath());
						listAll(f.getCanonicalPath(), res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				print();
			}
		}
		// System.out.println("Конец поиска");
	}

	// возвращает расширение файла
	public static String getFileExtention(String filename) {
		int dotPos = filename.lastIndexOf(".") + 1;
		return filename.substring(dotPos);
	}

	// возвращает расширение файла
	public static String getFileExtention(File file) {
		return getFileExtention(file.getName());
	}

	// возвращает имя файла без расширения
	public static String getFileNameWithoutExtention(String filename) {
		int dotPos = filename.lastIndexOf(".");
		return filename.substring(0, dotPos);
	}

	// возвращает имя файла без расширения
	public static String getFileNameWithoutExtention(File file) {
		return getFileNameWithoutExtention(file.getName());
	}

	// возвращает путь к файлу без имени самого файла
	public static String getPathWithoutFilename(String path) {
		int dotPos = path.lastIndexOf("/");
		return path.substring(0, dotPos);
	}

	// возвращает путь к файлу без имени самого файла
	public static String getPathWithoutFilename(File file) {
		return getPathWithoutFilename(file.getAbsolutePath());
	}

	// возвращает пакетный путь к файлу класса без имени самого класса
	public static String getPackageClass(String path) {
		int dotPos = path.lastIndexOf("/");
		return path.substring(0, dotPos);
	}

	// возвращает путь к файлу без имени самого файла и его пакетов
	public static String getPathWithoutFilenameAndPackage(File file, String fileNameAndPAckage) {
		String s = file.getAbsolutePath();// .replace(fileNameAndPAckage +
											// ".class", "");
		int dotPos = file.getAbsolutePath().lastIndexOf(fileNameAndPAckage);
		if (dotPos < 0) {
			return null;
		}
		return s.substring(0, dotPos);
	}

	// Преобразуем имя в файловой системе в имя класса
	// (заменяем слэши на точки)
	private static String normalize(String className) {
		return className.replace('/', '.');
	}

	private static String getClassPackage(String errorMsg) {

		// Start and end index of cutting
		int startIndex = errorMsg.lastIndexOf(" ") + 1;
		int endIndex = errorMsg.length() - 1;

		// Let's save a substring
		String classPackage = errorMsg.substring(startIndex, endIndex);

		return classPackage;
	}

	// возвращает true если расширение фала совпадает с переданным
	public static boolean compareExtention(File f, String extention) {
		if (getFileExtention(f.getName()).equals(extention)) {
			return true;
		} else {
			return false;
		}
	}

	// выполняет метод указанного класса
	private boolean executeMethod(File file, String classPackage) throws NoClassDefFoundError {
		c = null;
		classLoader = null;
		Method method = null;
		try {
			if (classPackage == null) {
				classLoader = new URLClassLoader(new URL[] { new File(getPathWithoutFilename(file)).toURI().toURL() });
				c = Class.forName(getFileNameWithoutExtention(file), true, classLoader);
			} else {
				String s = getPathWithoutFilenameAndPackage(file, classPackage);
				if (s != null) {
					classLoader = new URLClassLoader(new URL[] { new File(s).toURI().toURL() });
					c = Class.forName(normalize(classPackage), true, classLoader);
				} else {
					try {
						String newPath = getPath() + "/copy/";
						String newPathToFile = newPath + getPackageClass(classPackage) + "/";
						CopyFile.copy(file.getAbsolutePath(), newPathToFile, file.getName());
						classLoader = new URLClassLoader(new URL[] { new File(newPath).toURI().toURL() });
						c = Class.forName(normalize(classPackage), true, classLoader);
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
			try {
				method = c.getDeclaredMethod(getNameMethod(), null);
				method.setAccessible(true);
				method.invoke(c.newInstance());
				return true;
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				return false;
			} catch (NoClassDefFoundError e) {
				return false;
			} catch (NoSuchMethodException e) {
				// System.out.println("Метода toInit нет в классе" +
				// file.getAbsolutePath());
				return false;
			}
		} catch (ClassNotFoundException | MalformedURLException e1) {
			return false;
		}
	}

	private boolean execute(File file) {
		try {
			return executeMethod(file, null);
		} catch (NoClassDefFoundError e) {
			String classPackage = getClassPackage(e.getMessage());
			return executeMethod(file, classPackage);
		}

	}

	private void print() {
		for (String s : res) {
			System.out.println(s);
		}
	}

	// --------------------------------------------------------------------------------------

	public static void loadClass(String directory) {

		// Get file root directory
		String rootDirectory = new File(directory).getParent();

		// Get rid of file extension
		String className = getFileNameWithoutExtension(directory);

		URL[] urls = null;
		ClassLoader cl = null;
		Class<?> dynamicClass;
		try {
			// Convert File to a URL and save them
			urls = new URL[] { new File(rootDirectory).toURI().toURL() };

			// Create a new class loader with the directory
			cl = new URLClassLoader(urls);

			// Load in the class
			dynamicClass = cl.loadClass(className);
		} catch (MalformedURLException e) {

		} catch (ClassNotFoundException e) {

		} catch (NoClassDefFoundError e) {
			// Basing on error message get the class package name
			String classPackage = getClassPackage(e.getMessage());

			try {

				// Load the class once more!
				dynamicClass = cl.loadClass(classPackage);
			} catch (ClassNotFoundException ex) {

			}
		}
	}

	private static String getFileNameWithoutExtension(String path) {
		int start = path.lastIndexOf(File.separator) + 1;
		int end = path.lastIndexOf(DOT);
		end = start < end ? end : path.length();
		String name = path.substring(start, end);

		return name;
	}

}
