package com.girlsteam.Car.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private boolean loggedIn = false;

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
