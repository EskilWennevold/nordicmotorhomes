package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Motorhome;
import com.nordicmotorhomes.Model.MotorhomeModel;
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
        List<Motorhome> motorhomeList=jdbcTemplate.query(sql,rowMapper);
        return motorhomeList;
    }
    public void createMotorhome(Motorhome m){
        String sql="INSERT INTO motorhomes (modelid,platenumber) VALUES (?,?)";

        jdbcTemplate.update(sql,m.getModelid(),m.getPlatenumber());
    }
    public Motorhome viewMotorhome(int id){
        String sql="SELECT * FROM motorhomes WHERE motorhomeid = ?";
        RowMapper<Motorhome> rowMapper=new BeanPropertyRowMapper<>(Motorhome.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    public void updateMotorhome(int id, Motorhome m){
        String sql="UPDATE motorhomes SET modelid=?,platenumber=? WHERE motorhomeid = ?";
        jdbcTemplate.update(sql,m.getModelid(),m.getPlatenumber(), id);
    }
    public void updateMotorhomesModel(int motorhomeid, int id){
        String sql="UPDATE motorhomes SET modelid=? WHERE motorhomeid = ?";
        jdbcTemplate.update(sql, id, motorhomeid);
    }
    public void deleteMotorhome(int id){
        String sql="DELETE FROM motorhomes WHERE motorhomeid = ?";
        jdbcTemplate.update(sql,id);
    }
}
