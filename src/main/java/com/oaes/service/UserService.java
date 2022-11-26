package com.oaes.service;

import com.oaes.dao.UserDao;
import com.oaes.dao.UserDaoProxy;
import com.oaes.entity.Student;
import com.oaes.entity.User;

public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDaoProxy();
    }

    public void updateUser(User user) throws Exception {
        userDao.save(user);
    }

    public User getUserById(long userId) throws Exception {
        return userDao.findByUserId(userId);
    }

    public User getUserByEmail(String email) throws Exception {
        return userDao.findByEmail(email);
    }
}
