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
        String sql="SELECT * FROM motorhomemodels";
        RowMapper<MotorhomeModel> rowMapper=new BeanPropertyRowMapper<>(MotorhomeModel.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    public void createMotorhomeModel(MotorhomeModel m){
        String sql="INSERT INTO motorhomemodels (brand,model,price,beds) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,m.getBrand(),m.getModel(),m.getPrice(),m.getBeds());
    }
    public MotorhomeModel viewMotorhomeModel(int id){
        String sql="SELECT * FROM motorhomemodels WHERE modelid = ?";
        RowMapper<MotorhomeModel> rowMapper=new BeanPropertyRowMapper<>(MotorhomeModel.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    public void updateMotorhomeModel(MotorhomeModel m){
        String sql="UPDATE motorhomemodels SET brand=?,model=?,price=?,beds=? WHERE modelid = ?";
        jdbcTemplate.update(sql,m.getBrand(),m.getModel(),m.getPrice(),m.getBeds(),m.getModelid());
    }
    public void deleteMotorhomeModel(int id){
        String sql="DELETE FROM motorhomemodels WHERE modelid = ?";
        jdbcTemplate.update(sql,id);
    }
}
