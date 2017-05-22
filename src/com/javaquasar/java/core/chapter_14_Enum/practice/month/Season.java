package com.javaquasar.java.core.chapter_14_Enum.practice.month;

/**
 * Created by Java Quasar on 16.05.17.
 */
public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	public Season getNextSeason() {
		switch (this) {
	      case WINTER: return Season.SPRING;
	      case SPRING: return Season.SUMMER;
	      case SUMMER: return Season.AUTUMN;
	      case AUTUMN: return Season.WINTER;
	    }
		return null;
	}
	
	public Season getLastSeason() {
		switch (this) {
	      case WINTER: return Season.AUTUMN;
	      case SPRING: return Season.WINTER;
	      case SUMMER: return Season.SPRING;
	      case AUTUMN: return Season.SUMMER;
	    }
		return null;
	}
	
	@Override
	  public String toString() {
	    switch (this) {
	      case WINTER: return "Текущий сезон - зима.";
	      case SPRING: return "Текущий сезон - весна.";
	      case SUMMER: return "Текущий сезон - лето.";
	      case AUTUMN: return "Текущий сезон - осень.";
	    }
	    return "что-то невозможное!";
	  }
}
