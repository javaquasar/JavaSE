package core.lecture3_04_Localization.practice.task_8_10;

public enum Country {
	CHINESE ("CN", "Сhinese"),
	FRANCE ("FR", "Frence"),
	GERMANY ("DE", "Germany"),
	ITALY ("IT", "Italy"),
	JAPAN ("JP", "Japan"),
	KOREA ("KR", "Korea"),
	UK ("GB", "great Britain"),
	US ("US", "USA"),
	RUSSIA ("RU", "Russia"),
	UKRAINE ("UA", "Ukraine");
    
    private String acronym;
    private String country;
    
    private Country(String cronym, String language) {
    	this.acronym = cronym;
    	this.country = language;
    }
    
    public String getAcronym() {
    	return acronym;
    }
    
    public String getCountry() {
    	return country;
    }
}
