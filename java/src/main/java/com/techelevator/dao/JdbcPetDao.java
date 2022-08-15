package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.PetDTO;
import com.techelevator.model.PetNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pet create(PetDTO newPetDTO, int userId) {
        Pet newPet = new Pet();
        String sql = "INSERT INTO pets (name, species, sex, birth_date, is_fixed, has_vaccinations, size, user_id, pet_photo) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";

        Integer newPetId;
        newPetId = jdbcTemplate.queryForObject(sql, Integer.class, newPetDTO.getName(),
                newPetDTO.getSpecies(), newPetDTO.getSex(), newPetDTO.getBirthDate(), newPetDTO.isFixed(),
                newPetDTO.isHasVaccinations(), newPetDTO.getSize(), userId, newPetDTO.getPetPhoto());
        newPet.setPetId(newPetDTO.getPetId());
        newPet.setName(newPetDTO.getName());
        newPet.setSpecies(newPetDTO.getSpecies());
        newPet.setSex(newPetDTO.getSex());
        newPet.setBirthDate(newPetDTO.getBirthDate());
        newPet.setFixed(newPetDTO.isFixed());
        newPet.setHasVaccinations(newPetDTO.isHasVaccinations());
        newPet.setSize(newPetDTO.getSize());
        newPet.setUserId(newPetDTO.getUserId());
        newPet.setPetPhoto(newPetDTO.getPetPhoto());
        String personalitySql = "INSERT INTO pet_personality (pet_id, personality_id) " +
                "VALUES (?,?)";
        Integer[] personality = newPetDTO.getPersonality();
        for (int personality_id : personality) {
           // System.out.println(personality_id);
            jdbcTemplate.update(personalitySql,newPetId,personality_id);
        }
        newPet.setPersonality(personality);

        return newPet;
    }

    @Override
    public Pet getPetById(int petId) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        Integer[] personalityArray = getPersonalitiesForPet(petId);
        if (results.next()) {
            return mapRowToPet(results, personalityArray);
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
            int petId = results.getInt("pet_id");
            Integer[] personality = getPersonalitiesForPet(petId);
            Pet pet = mapRowToPet(results,personality);
            petList.add(pet);
        }
        return petList;
    }

    public Integer[] getPersonalitiesForPet(int petId) {
        String sqlPersonality = "SELECT * FROM pet_personality WHERE pet_id = ?";
        SqlRowSet resultsPersonality = jdbcTemplate.queryForRowSet(sqlPersonality,petId);
        List<Integer> personality = new ArrayList<>();
        while(resultsPersonality.next()) {
            personality.add(resultsPersonality.getInt("personality_id"));
        }
        Integer[] personalityArray = personality.toArray(new Integer[0]);
        return personalityArray;
    }

    @Override
    public List<Pet> getPetsByUserId(int userId) {
        List<Pet> petsByUserId = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE user_id = ?";
//        int userId = petByUserDTO.getUserId();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, userId);
        while(rs.next()) {
            Integer[] personality = getPersonalitiesForPet(rs.getInt("pet_id"));
            // in line 100 we need specific PET ID
            Pet pet = mapRowToPet(rs,personality);
            petsByUserId.add(pet);
        }
        return petsByUserId;
    }


    @Override
    public Pet updatePet(Pet pet, int petId) {
        String sql = "UPDATE pets SET name = ?, species = ?, sex = ?, birth_date = ?, " +
                "is_fixed = ?, has_vaccinations = ?, size = ?, user_id = ?, pet_photo = ? " +
                "WHERE pet_id = ?;";
        jdbcTemplate.update(sql,
                pet.getName(),
                pet.getSpecies(),
                pet.getSex(),
                pet.getBirthDate(),
                pet.isFixed(),
                pet.isHasVaccinations(),
                pet.getSize(),
                pet.getUserId(),
                pet.getPetPhoto(),
                petId);
        return pet;
    }


    private Pet mapRowToPet(SqlRowSet rs, Integer[] personality) {
        Pet pet = new Pet();
        pet.setPetId(rs.getInt("pet_id"));
        pet.setName(rs.getString("name"));
        pet.setSpecies(rs.getString("species"));
        pet.setSex(rs.getString("sex"));
//        pet.setBirthDate(rs.getDate("birth_date"));
        Date date = rs.getDate("birth_date");
        if (date != null) {
            pet.setBirthDate(date.toLocalDate());
        }
        pet.setFixed(rs.getBoolean("is_fixed"));
        pet.setHasVaccinations(rs.getBoolean("has_vaccinations"));
        pet.setSize(rs.getInt("size"));
        pet.setUserId(rs.getInt("user_id"));
        pet.setPetPhoto(rs.getString("pet_photo"));
        pet.setPersonality(personality);

        return pet;
    }
}
