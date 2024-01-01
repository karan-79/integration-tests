package com.integrationtesting.practice.demo.dao;

import com.integrationtesting.practice.demo.api.v1.model.APIProduct;
import com.integrationtesting.practice.demo.dao.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@AllArgsConstructor
public class ProductsDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<APIProduct> getAll(){
        var sql = "SELECT * FROM PRODUCTS";
        return jdbcTemplate.query(sql, ProductMapper.mapRow());
    }

    public void createProduct(APIProduct product){
        var sql = """
                INSERT INTO PRODUCTS (NAME,PRODUCT_CODE,DESCRIPTION,PRICE,CATEGORY)
                VALUES (:name,:productCode,:description,:price,:category)
                """;
        jdbcTemplate.update(sql, Map.of(
                "name",product.name(),
                "productCode",product.productCode(),
                "description", product.description(),
                "price", product.price(),
                "category", product.category()
        ));
    }
}
