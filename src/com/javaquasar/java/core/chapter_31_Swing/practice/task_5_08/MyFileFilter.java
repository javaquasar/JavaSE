package com.javaquasar.java.core.chapter_31_Swing.practice.task_5_08;

import java.io.File;

public class MyFileFilter extends javax.swing.filechooser.FileFilter {
	String ext, description;

	public String getDescription() {
		return description;
	}

	public MyFileFilter(String ext, String description) {
		this.ext = ext;
	}

	// В этом методе может быть любая проверка файла
	public boolean accept(File f) {
		if (f != null) {
			if (f.isDirectory()) {
				return true;
			}

			return f.toString().endsWith(ext);
		}
		return false;
	}
}
