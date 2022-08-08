package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.PetNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(String name, int species, int sex, Date birthDate, int personality, boolean isFixed, boolean hasVaccinations, int size, int userId) {
        String sql = "INSERT INTO pets (name, species, sex, birth_date, personality, is_fixed, has_vaccinations, size) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";

        Integer newPetId;
        newPetId = jdbcTemplate.queryForObject(sql, Integer.class, name, species, sex, birthDate, personality, isFixed, hasVaccinations, size);

        sql = "INSERT INTO user_pet (user_id, pet_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, userId, newPetId) == 1;
    }

    @Override
    public Pet getPetById(int petId) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            return mapRowToPet(results);
        } else {
            throw new PetNotFoundException();
        }
    }

    @Override
    public List<Pet> listAllPets() {
        List<Pet> petList = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pet pet = mapRowToPet(results);
            petList.add(pet);
        }
        return petList;
    }


    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getInt("pet_id"));
        pet.setName(rs.getString("name"));
        pet.setSpecies(rs.getInt("species"));
        pet.setSex(rs.getInt("sex"));
        pet.setBirthDate(rs.getDate("birth_date"));
        pet.setPersonality(rs.getInt("personality"));
        pet.setFixed(rs.getBoolean("is_fixed"));
        pet.setHasVaccinations(rs.getBoolean("has_vaccinations"));
        pet.setSize(rs.getInt("size"));
        return pet;
    }
}
