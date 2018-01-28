package com.MVCProject;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String language;
    private String[] operatingSystems;
    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> languageOptions;

    public Student() {
        countryOptions = new LinkedHashMap<>();
        languageOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("AU", "Australia");
        countryOptions.put("NZ", "New Zealand");
        countryOptions.put("EN", "England");
        countryOptions.put("TH", "Tahiti");

        languageOptions.put("Java", "Java");
        languageOptions.put("JavaScript", "JavaScript");
        languageOptions.put("PHP", "PHP");
        languageOptions.put("Rust", "Rust");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String langauge) {
        this.language = langauge;
    }

    public LinkedHashMap<String, String> getLanguageOptions() {
        return languageOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
