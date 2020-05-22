package com.ssh.dao;

import com.ssh.entity.User;

public interface UserDao {
    void add(User user); //添加注册的新用户
    User getByEmail(String email);
    User geByPhone(String cellphone);

}
