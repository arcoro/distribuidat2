package com.spring.dao;

import com.spring.entidad.Singer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class SingerDaoImpl implements SingerDao {

    private final String LISTAR="SELECT * FROM SINGER";
    private final String insert = "INSERT INTO SINGER (firstName,lastName,birthDate,email) values (?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    public SingerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        return jdbcTemplate.query(LISTAR,new SingerMapper());
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        Object[] datos = new Object[] { singer.getFirstName(), singer.getLastName(), singer.getBirthDate(), singer.getEmail() };
        int[] tipos = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR};
        int registro = jdbcTemplate.update(insert,datos,tipos);
        return singer;
    }

    @Override
    public Singer update(Singer singer) {
        return null;
    }

    @Override
    public Integer delete(Singer singer) {
        return null;
    }
}

class SingerMapper implements RowMapper<Singer> {

    @Override
    public Singer mapRow (ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setVersion(rs.getInt("version"));
        singer.setFirstName(rs.getString("firstName"));
        singer.setLastName(rs.getString("lastName"));
        singer.setBirthDate(rs.getDate("birthDate"));
        singer.setEmail(rs.getString("email"));
        return singer;
    }
}
