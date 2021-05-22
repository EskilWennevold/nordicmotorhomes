package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.MotorhomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeModelRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<MotorhomeModel> loadAllMotorhomeModels(){
        String sql="SELECT * FROM motorhomemodel";
        RowMapper<MotorhomeModel> rowMapper=new BeanPropertyRowMapper<>(MotorhomeModel.class);
        List<MotorhomeModel> modelList=jdbcTemplate.query(sql,rowMapper);
        return modelList;
    }
}
