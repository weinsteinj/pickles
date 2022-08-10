package com.techelevator.model;

import java.util.Date;

public class PetDTO {

    private String name;
    private String species;
    private String sex;
    private Date birthDate;
    private Integer[] personality;
    private boolean isFixed;
    private boolean hasVaccinations;
    private int size;
    private int userId;

    public PetDTO(int petId, String name, String species, String sex, Date birthDate,
                  Integer[] personality, boolean isFixed, boolean hasVaccinations, int size, int userId) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.birthDate = birthDate;
        this.personality = personality;
        this.isFixed = isFixed;
        this.hasVaccinations = hasVaccinations;
        this.size = size;
        this.userId = userId;
    }

    public PetDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer[] getPersonality() {
        return personality;
    }

    public void setPersonality(Integer[] personality) {
        this.personality = personality;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isHasVaccinations() {
        return hasVaccinations;
    }

    public void setHasVaccinations(boolean hasVaccinations) {
        this.hasVaccinations = hasVaccinations;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
