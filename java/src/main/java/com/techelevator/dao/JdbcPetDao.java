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
    public void create(String name, int species, int sex, Date birthDate, int[] personality, boolean isFixed, boolean hasVaccinations, int size, int userId) {
        String sql = "INSERT INTO pets (name, species, sex, birth_date, is_fixed, has_vaccinations, size, user_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";

        Integer newPetId;
        newPetId = jdbcTemplate.queryForObject(sql, Integer.class, name, species, sex, birthDate, isFixed, hasVaccinations, size,userId);

        String personalitySql = "INSERT INTO pet_personality (pet_id, personality_id) " +
                "VALUES (?,?)";
        for (int personality_id : personality) {
            jdbcTemplate.update(personalitySql,newPetId,personality_id);
        }
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
      //  pet.setPersonality(rs.getInt("personality"));
        pet.setFixed(rs.getBoolean("is_fixed"));
        pet.setHasVaccinations(rs.getBoolean("has_vaccinations"));
        pet.setSize(rs.getInt("size"));
        pet.setUserId(rs.getInt("user_id"));
        return pet;
    }
}
