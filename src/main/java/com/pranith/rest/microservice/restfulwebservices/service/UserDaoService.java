package com.pranith.rest.microservice.restfulwebservices.service;

import com.pranith.rest.microservice.restfulwebservices.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
class UserDaoService {
    public static List<User> userList = new ArrayList<>();
    public static int userCount = 0;

    static {
        userList.add(User.builder().id(++userCount).name("Pranith").birthDate(LocalDate.now().minusDays(30)).build());
        userList.add(User.builder().id(++userCount).name("Raj").birthDate(LocalDate.now().minusDays(40)).build());
        userList.add(User.builder().id(++userCount).name("Jajala").birthDate(LocalDate.now().minusDays(50)).build());
    }

    public List<User> findAll() {
        return userList;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        userList.add(user);
        return user;
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        userList.removeIf(predicate);
    }
}
