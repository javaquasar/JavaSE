package com.javaquasar.java.core.chapter_14_Enum.practice.gender;

/**
 * Created by Java Quasar on 16.05.17.
 */
enum Gender {
	MALE, FEMALE;

	@Override
	public String toString() {
		switch (this) {
		case MALE:
			return "мужской пол";
		case FEMALE:
			return "женский пол";
		}
		return "что-то невозможное!";
	}

}


