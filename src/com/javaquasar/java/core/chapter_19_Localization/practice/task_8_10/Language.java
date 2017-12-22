package com.javaquasar.java.core.chapter_19_Localization.practice.task_8_10;

public enum Language {

    ENGLISH ("en", "english"),
    FRENCH ("fr", "french"),
    GERMAN ("de", "german"),
    ITALIAN ("it", "italian"),
    JAPANESE ("ja", "japanese"),
    KOREAN ("ko", "korean"),
    CHINESE ("zh", "chinese"),
    RUSSIAN ("ru", "russian"),
    UKRAINIAN ("uk", "ukrainian");
    
    private String acronym;
    private String language;
    
    private Language(String cronym, String language) {
    	this.acronym = cronym;
    	this.language = language;
    }
    
    public String getAcronym() {
    	return acronym;
    }
    
    public String getLanguage() {
    	return language;
    }
}
