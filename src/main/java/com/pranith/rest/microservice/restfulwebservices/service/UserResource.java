package com.pranith.rest.microservice.restfulwebservices.service;

import com.pranith.rest.microservice.restfulwebservices.model.User;
import com.pranith.rest.microservice.restfulwebservices.service.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService service;

    UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("ID=" + id);
        return user;
    }

    @DeleteMapping(path = "/users/{id}")
    void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }

    @PostMapping(path = "/users")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User currentUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(currentUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
