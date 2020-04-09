package fr.mds.demoproject.model;

import java.io.Serializable;

public class Virus implements Serializable {

    private String name;
    private String countryName;
    private int mortalityRate;


    public Virus() {
    }

    public Virus(String name, String countryName, int mortalityRate) {
        this.name = name;
        this.countryName = countryName;
        this.mortalityRate = mortalityRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(int mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    @Override
    public String toString() {
        return name;
    }

}
