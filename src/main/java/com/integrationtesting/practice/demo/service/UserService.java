package com.integrationtesting.practice.demo.service;

import com.integrationtesting.practice.demo.api.v1.model.APIUserCredentials;
import com.integrationtesting.practice.demo.api.v1.model.UserDetails;
import com.integrationtesting.practice.demo.dao.UserDAO;
import com.integrationtesting.practice.demo.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public void createUser(UserDetails userDetails) {

        userDetails.setCredentials(new APIUserCredentials(
                userDetails.getCredentials().userName(), makeHash(userDetails.getCredentials().password())));

        userDetails.setId(UUID.randomUUID());

        userDAO.createUser(userDetails);
    }

    private String makeHash(String password) {
        var encoder = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
        var randomSalt = StringUtils.randomString(6);
        var hash = encoder.encode(randomSalt.concat(password));
        return randomSalt + ":" + hash;
    }
}
