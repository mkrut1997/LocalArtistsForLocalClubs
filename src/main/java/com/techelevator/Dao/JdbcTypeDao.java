package com.techelevator.Dao;

import com.techelevator.Models.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcTypeDao implements TypeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTypeDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Type getType(int typeId) {
        Type type = null;
        String sql = "SELECT * FROM performer_type WHERE type_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, typeId);
        if(result.next()){
            type = mapRowToType(result);
        }
        return type;
    }

    @Override
    public List<Type> getAllTypes() {
        List<Type> types = new ArrayList<>();
        String sql = "SELECT * FROM performer_type;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            types.add(mapRowToType(results));
        }
        return types;
    }

    private Type mapRowToType(SqlRowSet rowSet){
        Type type = new Type();
        type.setTypeId(rowSet.getInt("type_id"));
        type.setTypeName(rowSet.getString("type_name"));
        return type;
    }


}
