package com.techelevator.dao;

import com.techelevator.model.Playdate;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlaydateDao implements PlaydateDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPlaydateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(int playdateId, String location, Timestamp dateTime, String details, int rating, String status, int hostUserId, int visitingUserId, List<Integer> petId) {
        String sql = "";
    }

    @Override
    public Playdate getPlaydateById(int playdateId) {
        return null;
    }

    @Override
    public List<Playdate> listAllPlaydates() {
        return null;
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
        playdate.setLocation(rs.getString("location"));
        playdate.setDateTime(rs.getTimestamp("date_and_time"));
        playdate.setDetails(rs.getString("details"));
        playdate.setRating(rs.getInt("rating"));
        playdate.setStatus(rs.getString("status"));
        playdate.setPetId(petList);
    }
}
