package com.techelevator.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private String sex;
    private LocalDate birthDate;
    private Integer[] personality;
    private boolean isFixed;
    private boolean hasVaccinations;
    private int size;
    private int userId;
    private String petPhoto;



    public Pet(int petId, String name, String species, String sex, LocalDate birthDate, Integer[] personality, boolean isFixed, boolean hasVaccinations, int size, int userId) {
        this.petId = petId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return petId == pet.petId && isFixed == pet.isFixed && hasVaccinations == pet.hasVaccinations && size == pet.size && userId == pet.userId && Objects.equals(name, pet.name) && Objects.equals(species, pet.species) && Objects.equals(sex, pet.sex) && Objects.equals(birthDate, pet.birthDate) && Arrays.equals(personality, pet.personality) && Objects.equals(petPhoto, pet.petPhoto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(petId, name, species, sex, birthDate, isFixed, hasVaccinations, size, userId, petPhoto);
        result = 31 * result + Arrays.hashCode(personality);
        return result;
    }
}
