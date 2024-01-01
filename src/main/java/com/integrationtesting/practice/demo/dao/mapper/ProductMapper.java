package com.integrationtesting.practice.demo.dao.mapper;

import com.integrationtesting.practice.demo.api.v1.model.APIProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static RowMapper<APIProduct> mapRow() {
        return (rs, i) -> new APIProduct(
                rs.getInt("ID"),
                rs.getString("name"),
                rs.getString("product_code"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getString("category")
        );
    }
}
