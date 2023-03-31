package com.nishanth.firstspringproject.domain;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setExpirationDate(rs.getInt("isExpired"));
        return user;
    }
}
