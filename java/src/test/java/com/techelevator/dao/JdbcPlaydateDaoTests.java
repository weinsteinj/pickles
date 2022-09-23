package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.model.PlaydateNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPlaydateDaoTests extends BaseDaoTests {
    private static LocalDateTime DATETIME = LocalDateTime.of(2022, 8, 20, 12, 30, 00);
    private static LocalDateTime DATETIME2 = LocalDateTime.of(2022, 10, 2, 12, 00, 00);
    private static LocalDateTime DATETIME3 = LocalDateTime.of(2022, 9, 15, 12, 45, 00);
//    private static Playdate testPlaydate = new Playdate (1, 1, 2, 15212, DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL");
//    private static Playdate testPlaydate2 = new Playdate (2, 2, 3, 15212, DATETIME2, "Super fun playdate at the park!",  5, "Accepted", "photoURL");
//    private static Playdate testPlaydate3 = new Playdate (3, 1, 2, 15202, DATETIME3, "Go on a walk with us!",  2, "Declined", "photoURL");

    private JdbcPlaydateDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPlaydateDao(jdbcTemplate);
    }
    @Test
    public void listAllPlaydates_returns_3() {
        List<Integer> pets = new ArrayList<>();
        pets.add(1);
        pets.add(2);
        List<Playdate> playdates = sut.listAllPlaydates();
        Playdate testPlaydate = new Playdate (1, 1, 2, "15212", DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL", pets);
        Playdate testPlaydate2 = new Playdate (2, 2, 3, "15212", DATETIME2, "Super fun playdate at the park!",  5, "Accepted", "photoURL", pets);
        Playdate testPlaydate3 = new Playdate (3, 1, 2, "15202", DATETIME3, "Go on a walk with us!",  2, "Declined", "photoURL", pets);

        Assert.assertNotNull(playdates);
        Assert.assertEquals(3, playdates.size());
        Assert.assertEquals(testPlaydate, playdates.get(0));
        Assert.assertEquals(testPlaydate2, playdates.get(1));
        Assert.assertEquals(testPlaydate3, playdates.get(2));
    }
    @Test
    public void create_playdate_creates_new_playdate() {
        List<Integer> pets = new ArrayList<>();
        pets.add(1);
        pets.add(2);
        Playdate testPlaydate = new Playdate(1, 1, 2, "15212", DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL", pets);
        Playdate createdPlaydate = sut.create(1, "15212", DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL", pets);
        createdPlaydate.setPlaydateId(testPlaydate.getPlaydateId());
        testPlaydate.setVisitingUserId(0);

        Assert.assertEquals(testPlaydate, createdPlaydate);
    }

    @Test
    public void getPlaydateById_returns_correct_id() {
        List<Integer> pets = new ArrayList<>();
        pets.add(1);
        pets.add(2);
        Playdate testPlaydate = new Playdate (1, 1, 2, "15212", DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL", pets);
        Playdate playdate = sut.getPlaydateById(1);
    Assert.assertEquals(playdate, testPlaydate);
    }
    @Test(expected = PlaydateNotFoundException.class)
    public void getPlaydateNotFoundExceptionWhenGivenPlaydateIdThatDoesntExist(){
        sut.getPlaydateById(-1);
    }
    @Test
    public void updatePlaydate_updates_properly() {
        List<Integer> pets = new ArrayList<>();
        pets.add(1);
        pets.add(2);
        Playdate testPlaydate = new Playdate (1, 1, 2, "15212", DATETIME, "Join me at my house for snacks and fetch!",  3, "Posted", "photoURL", pets);
        sut.updatePlaydate(testPlaydate);
        Playdate actualUpdate = sut.getPlaydateById(1);
        Assert.assertEquals(testPlaydate, actualUpdate);
    }
}

