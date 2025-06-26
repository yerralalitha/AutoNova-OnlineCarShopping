package com.girlsteam.Car.Controller;

import com.girlsteam.Car.Entity.User;
import com.girlsteam.Car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    private boolean loggedIn = false;

    @PostMapping("/signup")
    public String signup(@RequestBody User u) {
        try {
            service.register(u);
            return "Signup success";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        loggedIn = service.validateLogin(u.getEmail(), u.getPassword());
        return loggedIn ? "Login success" : "Invalid";
    }

    @GetMapping("/all")
    public Object all() {
        return loggedIn ? service.all() : "Please login";
    }

    @GetMapping("/get/{username}")
    public Object get(@PathVariable String username) {
        return loggedIn ? service.get(username) : "Please login";
    }

    @PutMapping("/update/{username}")
    public String update(@PathVariable String username, @RequestBody User user) {
        return loggedIn ? service.update(username, user) : "Please login";
    }

    @DeleteMapping("/delete/{username}")
    public String delete(@PathVariable String username) {
        return loggedIn ? service.delete(username) : "Please login";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
