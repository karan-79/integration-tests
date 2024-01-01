package com.integrationtesting.practice.demo.api.v1.model;

public record APIProduct(
        int id,
        String name,
        String productCode,
        String description,
        Double price,
        String category
) {
}
