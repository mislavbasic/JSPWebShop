package com.mbasic.dal.service.user;

import com.mbasic.dal.model.User;

import java.util.List;

public interface UserService {

    boolean login(String username, String password);
    List<User> findAll();
}
