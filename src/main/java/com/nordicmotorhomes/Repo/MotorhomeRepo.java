package com.nordicmotorhomes.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MotorhomeRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
}
