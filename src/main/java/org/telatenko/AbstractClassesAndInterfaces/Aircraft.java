package org.telatenko.AbstractClassesAndInterfaces;

public abstract class Aircraft {
    protected String registrationNumber;

    public Aircraft(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract String getDescription();
}
