package com.techelevator.Dao;

import com.techelevator.Models.Equipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcEquipmentDao implements EquipmentDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcEquipmentDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Equipment getEquipment(int eqId) {
        Equipment equipment = null;
        String sql = "SELECT * FROM equipment WHERE eq_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eqId);
        if(results.next()){
            equipment = mapRowToEquipment(results);
        }
        return equipment;
    }

    @Override
    public List<Equipment> getAllEquipment() {
        List<Equipment> equipments = new ArrayList<>();
        String sql = "SELECT * FROM equipment;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            equipments.add(mapRowToEquipment(results));
        }
        return equipments;
    }

    private Equipment mapRowToEquipment(SqlRowSet rowSet){
        Equipment equipment = new Equipment();
        equipment.setEqId(rowSet.getInt("eq_id"));
        equipment.setEqName(rowSet.getString("eq_name"));
        return equipment;
    }



}
