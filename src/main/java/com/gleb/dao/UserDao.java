package com.gleb.dao;

import com.gleb.model.User;

import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> getByEmail(String email);
}
