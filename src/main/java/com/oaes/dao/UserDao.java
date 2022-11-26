package com.oaes.dao;

import com.oaes.entity.Student;
import com.oaes.entity.User;

import java.util.List;

public interface UserDao {
    public User findByUserId(long userId) throws Exception;
    public User findByEmail(String email) throws Exception;
    public void save(User user) throws Exception;
}
