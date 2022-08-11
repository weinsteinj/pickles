package com.techelevator.dao;

import com.techelevator.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class JdbcPetDaoTests extends BaseDaoTests {
    public static Integer[] personality = {1, 2, 3};
    public static LocalDate birthday = LocalDate.of(2022, 1, 20);
    protected static final Pet PET_1 = new Pet(1, "pet1", "dog", "male", birthday, personality, true, true, 2, 1 );
    protected static final Pet PET_2 = new Pet(2, "pet2", "dog", "male", birthday, personality, true, true, 2, 1 );
    protected static final Pet PET_3 = new Pet(3, "pet3", "dog", "male", birthday, personality, true, true, 2, 1 );


    private JdbcPetDao sut;
    private PetDTO dto;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPetDao(jdbcTemplate);

    }
    @Test
    public void create_pet_creates_new_pet() {
        Pet testPet = new Pet(0, "pet0", "dog", "male", birthday, personality, true, true, 2, 1);
        PetDTO testPet2 = new PetDTO(0, "pet0", "dog", "male", birthday, personality, true, true, 2, 1);
        Pet createdPet = sut.create(testPet2, 1);

        Assert.assertEquals(testPet, createdPet);
    }

    @Test
    public void getPetById_returns_PET_1_when_given_1(){
        Pet testPet = new Pet(1, "pet1", "dog", "male", birthday, personality, true, true, 2, 1);
        Pet createdPet = sut.getPetById(1);

        Assert.assertEquals(createdPet, testPet);
    }

    @Test
    public void listAllPets_returns_3(){
        List<Pet> pets = sut.listAllPets();
        Pet testPet = new Pet(1, "pet1", "dog", "male", birthday, personality, true, true, 2, 1);
        Pet testPet2 = new Pet(2, "pet2", "dog", "male", birthday, personality, true, true, 2, 1);
        Pet testPet3 = new Pet(3, "pet3", "dog", "male", birthday, personality, true, true, 2, 1);


        Assert.assertNotNull(pets);
        Assert.assertEquals(3, pets.size());
        Assert.assertEquals(testPet, pets.get(0));
        Assert.assertEquals(testPet2, pets.get(1));
        Assert.assertEquals(testPet3, pets.get(2));
    }

    @Test
    public void getPersonalitiesForPet(){
        
    }
}
