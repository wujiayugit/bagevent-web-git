package com.ssh.dao.impl;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {

    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User geByPhone(String cellphone) {
        return null;
    }


}
