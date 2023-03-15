package com.example.springDataJpa;

public enum Category {
    HOUSEHOLD("obowiazki domowe"),
    WORK("praca"),
    TRAINING("szkolenie");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
