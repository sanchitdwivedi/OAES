package com.oaes.dao;

import com.oaes.entity.Student;
import com.oaes.entity.User;

import java.util.regex.Pattern;

public class UserDaoProxy implements UserDao {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private UserDao userDao;

    public UserDaoProxy(){
        userDao = new UserDaoImpl();
    }
    
    private boolean validUserId(long userId){
        return userId>=0;
    }

    private boolean validUser(User user){
        return user!=null;
    }

    private boolean validEmail(String email){
        return !VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }

    @Override
    public User findByUserId(long userId) throws Exception {
        if(!validUserId(userId)) throw new Exception("Please enter a valid student id");
        return userDao.findByUserId(userId);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        if(validEmail(email)) throw new Exception("Invalid Email exception");
        return userDao.findByEmail(email);
    }

    @Override
    public void save(User user) throws Exception {
        if(!validUser(user)) throw new Exception("Invalid student exception");
        userDao.save(user);
    }
}
