package com.mbasic.dal.service;

import com.mbasic.dal.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);
    boolean deleteUser(User user);
    List<User> findAllUsers();
}
