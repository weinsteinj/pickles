package com.techelevator.dao;

import com.techelevator.model.Playdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcPlaydateDaoTests extends BaseDaoTests {


    private JdbcPlaydateDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPlaydateDao(jdbcTemplate);
    }
    @Test
    public void listAllPlaydates_returns_3() {
        List<Playdate> playdates = sut.listAllPlaydates();
//        Playdate testPlaydate = new Playdate (1, 2, "15212", "2022-08-22T12:00:00", "Join me at my house for snacks and fetch!");
//
//        Playdate testPlaydate2 = new Playdate (2, 3, "15212", "2022-08-15T12:00:00", "Super fun playdate at the park!");
//
//        Playdate testPlaydate3 = new Playdate (1, 3, "15202", "2022-09-30T12:00:00", "Go on a walk with us!");
//
        Assert.assertNotNull(playdates);
        Assert.assertEquals(3, playdates.size());

    }
}
