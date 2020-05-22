package com.ssh.service;

import com.ssh.entity.User;

public interface UserService {
    void add(User user); //添加注册的新用户
    User getByEmail(String email);
    User getByPhone(String cellphone);

}
