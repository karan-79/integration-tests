package com.integrationtesting.practice.demo.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class UserDetails {
    UUID id;
    String email;
    APIUserCredentials credentials;
}
