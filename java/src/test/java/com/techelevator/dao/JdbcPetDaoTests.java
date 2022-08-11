package com.techelevator.dao;

import com.techelevator.model.PetDTO;
import com.techelevator.model.PetNotFoundException;
import com.techelevator.model.PetAlreadyExistsException;
import com.techelevator.model.Pet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class JdbcPetDaoTests extends BaseDaoTests {
    public static Integer[] personality = {1, 2, 3};
    public static LocalDate birthday = LocalDate.of(2022, 1, 20);
    protected static final Pet PET_1 = new Pet(1, "pet1", "dog", "male", birthday, personality, true, true, 2, 1 );
    protected static final Pet PET_2 = new Pet(2, "pet2", "dog", "male", birthday, personality, true, true, 2, 2 );
    protected static final Pet PET_3 = new Pet(3, "pet3", "dog", "male", birthday, personality, true, true, 2, 3 );


    private JdbcPetDao sut;
    private PetDTO dto;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPetDao(jdbcTemplate);

    }
    @Test
    public void create_pet_creates_new_pet() {
        PetDTO testPet = new PetDTO(0, "pet0", "dog", "male", birthday, personality, true, true, 2, 1);
        Pet createdPet = sut.create(testPet, 1);

        Assert.assertEquals(testPet, createdPet);
    }
}
