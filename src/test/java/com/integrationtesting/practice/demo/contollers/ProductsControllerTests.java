package com.integrationtesting.practice.demo.contollers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.integrationtesting.practice.demo.IntegrationTests;
import com.integrationtesting.practice.demo.api.v1.model.APIProduct;
import com.jayway.jsonpath.TypeRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.MediaType;


import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductsControllerTests extends IntegrationTests {

    @Test
    @Order(1)
    void postProduct() throws Exception {
        var product = new APIProduct(
                0,
                "Some Product",
                "PROD-1",
                "this is irrelevant",
                1.0,
                "Category"
        );

        mockMvc.perform(
                    post("/v1/products/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(product)))
                .andExpect(status().is(200));
    }

    @Test
    @DependsOn("postProduct")
    @Order(2)
    void getAllProducts() throws Exception {
        var product = new APIProduct(
                0,
                "Some Product",
                "PROD-1",
                "this is irrelevant",
                1.0,
                "Category"
        );

        mockMvc.perform(
                        post("/v1/products/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(product)))
                .andExpect(status().is(200));

        var res = mockMvc.perform(
                get("/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().getContentAsString();
        var a = Arrays.stream(readJSON(res,APIProduct[].class)).toList();
        var s = a.stream().filter(p-> ((APIProduct) p).productCode().equals("PROD-1")).findAny();
        Assertions.assertTrue(s.isPresent());

    }

    private <T> T readJSON(String res, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(res, type);
    }
}
