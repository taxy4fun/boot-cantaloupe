package com.taxy4fun.services;

/**
 * Created by Springuers on 23/06/17.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String username, String password) {
        return "Welcome to Spring Boot " + username;
    }

}
