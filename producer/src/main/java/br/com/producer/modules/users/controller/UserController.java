package br.com.producer.modules.users.controller;

import br.com.producer.modules.users.requests.UserCreatePostRequestBody;
import br.com.producer.modules.users.entity.User;
import br.com.producer.modules.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/users"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = {"/create"})
    public ResponseEntity<User> createUser(@RequestBody UserCreatePostRequestBody userCreatePostRequestBody) {
        User userCreated = userService.createUser(userCreatePostRequestBody);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }
}
