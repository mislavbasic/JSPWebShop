package com.mbasic.dal.service.user;

import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.user.User;

import java.util.List;

public interface UserService {
    User login(String email, String password);
    List<User> findAll();

    List<LoginLog> findAllLog();
}
