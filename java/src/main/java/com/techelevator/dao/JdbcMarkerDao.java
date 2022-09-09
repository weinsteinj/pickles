package com.techelevator.dao;

import com.techelevator.model.Marker;
import com.techelevator.model.MarkerNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.error.Mark;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMarkerDao implements MarkerDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcMarkerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Marker getMarkerByUserId(int userId) {
        String sql = "SELECT * FROM markers JOIN users USING (zip_code) WHERE user_Id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToMarker(results);
        } else {
            throw new MarkerNotFoundException();
        }
    }

    @Override
    public Marker getMarkerByPlaydateId(int playdateId) {
        String sql = "SELECT * FROM markers JOIN playdate USING (zip_code) WHERE playdate_Id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playdateId);
        if (results.next()) {
            return mapRowToMarker(results);
        } else {
            throw new MarkerNotFoundException();
        }
    }

    @Override
    public List<Marker> getAllPlaydateMarkers() {
        List<Marker> markers = new ArrayList<>();
        String sql = "SELECT * FROM markers JOIN playdate USING (zip_code)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Marker marker = mapRowToMarker(results);
            markers.add(marker);
        }
        return markers;
    }

    private Marker mapRowToMarker(SqlRowSet rs) {
        Marker marker = new Marker();
        marker.setLat(rs.getBigDecimal("lat"));
        marker.setLng(rs.getBigDecimal("lng"));
        marker.setZipCode(rs.getString("zip_code"));

        return marker;
    }
}
