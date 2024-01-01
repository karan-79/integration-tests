package com.integrationtesting.practice.demo.dao;


import com.integrationtesting.practice.demo.api.v1.model.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class UserDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(UserDetails userDetails){

        var sql = """
                INSERT INTO USERS (user_id,username,email,password)
                VALUES (:id,:username,:email,:password)
                """;

        var map = Map.of(
                "id",userDetails.getId(),
                "username",userDetails.getCredentials().userName(),
                "password", userDetails.getCredentials().password()
        );
        jdbcTemplate.update(sql,map);
    }

}
