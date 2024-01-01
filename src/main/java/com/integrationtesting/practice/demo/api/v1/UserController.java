package com.integrationtesting.practice.demo.api.v1;


import com.integrationtesting.practice.demo.api.v1.model.UserDetails;
import com.integrationtesting.practice.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDetails userDetails){
        try {
            userService.createUser(userDetails);
            return ResponseEntity.ok("Successfully created user !!");
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
