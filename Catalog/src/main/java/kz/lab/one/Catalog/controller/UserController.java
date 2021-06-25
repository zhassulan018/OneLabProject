package kz.lab.one.Catalog.controller;

import kz.lab.one.Catalog.models.User;
import kz.lab.one.Catalog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/{email}")
    User getByEmail(@PathVariable String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    @RequestMapping(value = "/users")
    List<User> getAllUsers(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }


}

