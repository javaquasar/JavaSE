package com.javaquasar.java.core.chapter_16_IO_Stream.example.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ObjectSarializationDemo {

	public static void main(String[] args) {
		
		ObjectSarializationDemo impl = new ObjectSarializationDemo();
		SerializableEmploee[] db = { new SerializableEmploee("Tom", 25, 1200.75), new SerializableEmploee("Dick", 22, 1225.85), new SerializableEmploee("Harry", 25, 1242.25) };
		String path = impl.getPackagePath("SarializationDemo.db");
		System.out.println(path);
		impl.writeData(path, db);
		impl.readData(path);
		
	}
	
	public String getPackagePath(String fileName) {
		String s = this.getClass().getPackage().toString();
		s = s.replaceAll("package ", "");
		// если указать просто replaceAll(".", "/")
		// то все символы в строке заменяться на /
		s = "./src/" + s.replaceAll("\\.", "/") + "/" + fileName;
		return s;
	}

	public void writeData(String path, SerializableEmploee[] db) {

		try {
			FileOutputStream out = new FileOutputStream(path);
			ObjectOutputStream sout = new ObjectOutputStream(out);
			for (int i = 0; i < db.length; i++) {
				sout.writeObject(db[i]);
			}
			sout.flush();
			sout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readData(String path) {
		try {
			FileInputStream in = new FileInputStream(path);
			ObjectInputStream sin = new ObjectInputStream(in);
			SerializableEmploee se = (SerializableEmploee) sin.readObject();
			se.showDetails();
			se = (SerializableEmploee) sin.readObject();
			se.showDetails();
			se = (SerializableEmploee) sin.readObject();
			se.showDetails();
			sin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
