package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class JdbcPetDao implements PetDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(String name, int species, int sex, Date birthDate, String personality, boolean isFixed, boolean hasVaccinations, double weight, int userId) {
        String sql = "INSERT INTO pets (name, species, sex, birth_date, personality, is_fixed, has_vaccinations, size) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";

        Integer newPetId;
        newPetId = jdbcTemplate.queryForObject(sql, Integer.class, name, species, sex, birthDate, personality, isFixed, hasVaccinations, weight);

        sql = "INSERT INTO user_pet (user_id, pet_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, userId, newPetId) == 1;
    }

    @Override
    public Pet getPetById(int petId) {
        return null;
    }

    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setName(rs.getString("name"));
        pet.setSpecies(rs.getInt("species"));
        pet.setSex(rs.getInt("sex"));
        pet.setBirthDate(rs.getDate("birth_date"));
        pet.setPersonality(rs.getString("personality"));
        pet.setFixed(rs.getBoolean("is_fixed"));
        pet.setHasVaccinations(rs.getBoolean("has_vaccinations"));
        pet.setWeight(rs.getInt("size"));
        return pet;
    }
}
