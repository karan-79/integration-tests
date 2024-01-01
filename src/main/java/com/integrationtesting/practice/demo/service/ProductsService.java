package com.integrationtesting.practice.demo.service;

import com.integrationtesting.practice.demo.api.v1.model.APIProduct;
import com.integrationtesting.practice.demo.dao.ProductsDAO;
import com.integrationtesting.practice.demo.dao.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductsService {
    private final ProductsDAO productsDAO;

    public void addProduct(APIProduct product) {
        productsDAO.createProduct(product);
    }

    public List<APIProduct> getAllProducts() {
        return productsDAO.getAll();
    }
}
