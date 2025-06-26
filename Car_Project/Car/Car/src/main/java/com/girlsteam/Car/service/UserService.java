package com.girlsteam.Car.service;

import com.girlsteam.Car.Entity.User;
import java.util.List;

public interface UserService {
    void register(User user);
    boolean validateLogin(String email, String password);
    List<User> all();
    User get(String username);
    String update(String username, User user);
    String delete(String username);
}
