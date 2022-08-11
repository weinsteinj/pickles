package com.techelevator.dao;

import com.techelevator.model.PetNotFoundException;
import com.techelevator.model.Playdate;
import com.techelevator.model.PlaydateNotFoundException;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlaydateDao implements PlaydateDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPlaydateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(int hostUserId, String location, Timestamp dateTime, String details, int rating, String status, List<Integer> petId) {
        String sql = "INSERT INTO playdate (host_id, location, date_and_time, details, rating, status) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING playdate_id";
        Integer newPlaydateId;
        newPlaydateId = jdbcTemplate.queryForObject(sql, Integer.class, hostUserId, location, dateTime, details, rating, status);

        String petsSql = "INSERT INTO pet_playdate (playdate_id, pet_id) " +
                "VALUES (?, ?)";
        for (int pet_id : petId) {
            jdbcTemplate.update(petsSql, newPlaydateId, pet_id);
        }
    }

    @Override
    public Playdate getPlaydateById(int playdateId) {
       String sql = "SELECT * FROM playdate WHERE playdate_id = ?";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playdateId);
       List<Integer> petsList = getPetsForPlaydate(playdateId);
       if (results.next()) {
           return mapRowToPlaydate(results, petsList);
       } else {
           throw new PlaydateNotFoundException();
       }
    }

    @Override
    public List<Playdate> listAllPlaydates() {
        List<Playdate> playdateList = new ArrayList<>();
        String sql = "SELECT * FROM playdate";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            int playdateId = results.getInt("playdate_id");
            List<Integer> pets = getPetsForPlaydate(playdateId);
            Playdate playdate = mapRowToPlaydate(results, pets);
            playdateList.add(playdate);
        }
        return playdateList;
    }

    private List<Integer> getPetsForPlaydate(int playdateId) {
        String sqlPets = "SELECT * FROM pet_playdate WHERE playdate_id = ?";
        SqlRowSet resultsPets = jdbcTemplate.queryForRowSet(sqlPets, playdateId);
        List<Integer> pets = new ArrayList<>();
        while(resultsPets.next()) {
            pets.add(resultsPets.getInt("pet_id"));
        }
        return pets;
    }

    private Playdate mapRowToPlaydate(SqlRowSet rs, List<Integer> petList) {
        Playdate playdate = new Playdate();
        playdate.setPlaydateId(rs.getInt("playdate_id"));
        playdate.setHostUserId(rs.getInt("host_id"));
        playdate.setVisitingUserId(rs.getInt("visitor_id"));
        playdate.setLocation(rs.getString("location"));
        playdate.setDateTime(rs.getTimestamp("date_and_time"));
        playdate.setDetails(rs.getString("details"));
        playdate.setRating(rs.getInt("rating"));
        playdate.setStatus(rs.getString("status"));
        playdate.setPetId(petList);

        return playdate;
    }
}
