package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Pet {
    private int petId;
    private String name;
    private int species;
    private int sex;
    private Date birthDate;
    private String personality;
    private boolean isFixed;
    private boolean hasVaccinations;
    private double weight;

    public Pet(int petId, String name, int species, int sex, Date birthDate, String personality, boolean isFixed, boolean hasVaccinations, double weight) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.birthDate = birthDate;
        this.personality = personality;
        this.isFixed = isFixed;
        this.hasVaccinations = hasVaccinations;
        this.weight = weight;
    }

    public Pet() {

    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species == pet.species && sex == pet.sex && isFixed == pet.isFixed && hasVaccinations == pet.hasVaccinations && Double.compare(pet.weight, weight) == 0 && Objects.equals(name, pet.name) && Objects.equals(birthDate, pet.birthDate) && Objects.equals(personality, pet.personality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species, sex, birthDate, personality, isFixed, hasVaccinations, weight);
    }
}
