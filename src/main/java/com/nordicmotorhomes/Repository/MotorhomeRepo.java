package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Motorhome> loadAllMotorhomes(){
        String sql="SELECT * FROM motorhomes";
        RowMapper<Motorhome> rowMapper=new BeanPropertyRowMapper<>(Motorhome.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    public void createMotorhome(Motorhome motorhome){

    }
    public Motorhome readMotorhome(int motorhomeid){
        return null;
    }
    public void updateMotorhome(int motorhomeid,Motorhome motorhome){

    }
    public void deleteMotorhome(int motorhomeid){

    }
}
