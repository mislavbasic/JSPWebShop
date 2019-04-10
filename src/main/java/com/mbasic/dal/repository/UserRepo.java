package com.mbasic.dal.repository;

import com.mbasic.dal.model.User;

import java.util.List;

public interface UserRepo {
    boolean addUser(User user);
    boolean deleteUser(User user);
    List<User> getAllUsers();
}
