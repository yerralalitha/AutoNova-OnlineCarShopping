package com.girlsteam.Car.service;

import com.girlsteam.Car.Entity.User;
import com.girlsteam.Car.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public void register(User user) {
        if (repo.existsByUsername(user.getUsername()))
            throw new RuntimeException("Username already exists");
        repo.save(user);
    }

    public boolean validateLogin(String email, String password) {
        return repo.findAll().stream()
                .anyMatch(u -> u.getEmail().equals(email) && u.getPassword().equals(password));
    }

    public List<User> all() {
        return repo.findAll();
    }

    public User get(String username) {
        return repo.findByUsername(username);
    }

    public String update(String username, User user) {
        User u = repo.findByUsername(username);
        if (u == null) return "User not found";
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        repo.save(u);
        return "User updated";
    }

    @Transactional
    public String delete(String username) {
        if (!repo.existsByUsername(username)) return "User not found";
        repo.deleteByUsername(username);
        return "User deleted";
    }
}
