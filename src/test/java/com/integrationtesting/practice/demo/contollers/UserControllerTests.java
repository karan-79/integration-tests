package com.integrationtesting.practice.demo.contollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.integrationtesting.practice.demo.IntegrationTests;
import com.integrationtesting.practice.demo.api.v1.model.APIUserCredentials;
import com.integrationtesting.practice.demo.api.v1.model.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTests extends IntegrationTests {

    @Test
    void postUser() throws Exception {

        var userDetails = new UserDetails(null, "test.test@email.com", new APIUserCredentials("username", "password"));

        mockMvc.perform(post("/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userDetails)))
                .andExpect(status().is(200));


    }
}
