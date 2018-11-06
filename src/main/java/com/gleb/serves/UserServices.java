package com.gleb.serves;

import com.gleb.model.User;

import java.util.Optional;

public interface UserServices {

    void addUser(User user);

    Optional<User> getUserByEmail(String email);

    Optional<User> verifyPassword(User email, User user);
}
