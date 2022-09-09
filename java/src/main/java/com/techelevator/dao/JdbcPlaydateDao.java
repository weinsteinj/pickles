package com.techelevator.dao;

import com.techelevator.model.Playdate;
import com.techelevator.model.PlaydateNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class JdbcPlaydateDao implements PlaydateDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcPlaydateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Playdate create(int hostUserId, String zipCode, LocalDateTime dateTime, String details, int rating, String status, String playdatePhoto, List<Integer> petId) {
        Playdate newPlaydate = new Playdate();
        String sql = "INSERT INTO playdate (host_id, zip_code, date_and_time, " +
                "details, rating, status, playdate_photo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING playdate_id";
        Integer newPlaydateId;


        newPlaydate.setHostUserId(hostUserId);
        newPlaydate.setZipCode(zipCode);
        newPlaydate.setDateTime(dateTime);
        newPlaydate.setDetails(details);
        newPlaydate.setRating(rating);
        //newPlaydate.setStatus("Posted");
        newPlaydate.setPetId(petId);
        newPlaydate.setPlaydatePhoto(playdatePhoto);

        newPlaydateId = jdbcTemplate.queryForObject(sql, Integer.class,
                newPlaydate.getHostUserId(), newPlaydate.getZipCode(), newPlaydate.getDateTime(),
                newPlaydate.getDetails(), newPlaydate.getRating(), newPlaydate.getStatus(),
                newPlaydate.getPlaydatePhoto());
        if (newPlaydateId != null) {
            newPlaydate.setPlaydateId(newPlaydateId);
        }

        String petsSql = "INSERT INTO pet_playdate (playdate_id, pet_id) " +
                "VALUES (?, ?)";
        for (int pet_id : petId) {
            jdbcTemplate.update(petsSql, newPlaydateId, pet_id);
        }
        return newPlaydate;
    }



    @Override
    public Playdate getPlaydateById(int playdateId) {
       String sql = "SELECT playdate.*, host_user.username AS host_username, visitor_user.username AS visitor_username " +
               "FROM playdate JOIN users AS host_user ON playdate.host_id = host_user.user_id " +
               "LEFT JOIN users AS visitor_user ON playdate.visitor_id = visitor_user.user_id WHERE playdate_id = ?";
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
        String sql = "SELECT playdate.*, host_user.username AS host_username, visitor_user.username AS visitor_username " +
                "FROM playdate JOIN users AS host_user ON playdate.host_id = host_user.user_id " +
                "LEFT JOIN users AS visitor_user ON playdate.visitor_id = visitor_user.user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            int playdateId = results.getInt("playdate_id");
            List<Integer> pets = getPetsForPlaydate(playdateId);
            Playdate playdate = mapRowToPlaydate(results, pets);
            playdateList.add(playdate);
        }

        return playdateList;
    }

    public Playdate updatePlaydate(Playdate playdate) {
        String sql = "UPDATE playdate SET host_id = ?, visitor_id = ?, " +
                "zip_code = ?, date_and_time = ?, details = ?, rating = ?, " +
                "status = ?, playdate_photo = ? " +
                "WHERE playdate_id = ?;";
        jdbcTemplate.update(sql,
                playdate.getHostUserId(),
                playdate.getVisitingUserId(),
                playdate.getZipCode(),
                playdate.getDateTime(),
                playdate.getDetails(),
                playdate.getRating(),
                playdate.getStatus(),
                playdate.getPlaydatePhoto(),
                playdate.getPlaydateId());
        return playdate;
    }

    @Override
    public int addPlaydateMarker(String zipCode, BigDecimal lat, BigDecimal lng) {
        String insertMarkerSql = "INSERT INTO markers (zip_code, lat, lng ) " +
                "VALUES (?, ? , ? ) ON CONFLICT DO NOTHING";
        // do an insert of zip lat & lng to ---> markers TABLE in DB
        // if unique zipCode to table---> returns 1;
        // if conflict--> do nothing, returns 0;
        return jdbcTemplate.update(insertMarkerSql, zipCode, lat, lng);
    }

    public int deletePlaydate(int playdateId) {
        String deletePetSql = "DELETE FROM pet_playdate WHERE playdate_id = ?;";
        jdbcTemplate.update(deletePetSql,playdateId);
        String deleteSql = "DELETE FROM playdate WHERE playdate_id = ?;";
        return jdbcTemplate.update(deleteSql,playdateId);
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
        playdate.setZipCode(rs.getString("zip_code"));
//        playdate.setDateTime(rs.getTimestamp("date_and_time"));
        Timestamp dateTime = rs.getTimestamp("date_and_time");
        if (dateTime != null) {
            playdate.setDateTime(dateTime.toLocalDateTime());
        }
        playdate.setDetails(rs.getString("details"));
        playdate.setRating(rs.getInt("rating"));
        playdate.setStatus(rs.getString("status"));
        playdate.setPlaydatePhoto(rs.getString("playdate_photo"));
        playdate.setPetId(petList);
        playdate.setHostUsername(rs.getString("host_username"));
        String visitorUsername = rs.getString("visitor_username");
        if (visitorUsername != null) {
            playdate.setVisitorUsername(visitorUsername);
        }

        return playdate;
    }
}
