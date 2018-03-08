package com.HibernateDemo.hibernateDemo.dao;

import com.HibernateDemo.hibernateDemo.model.User;

import java.util.List;

/**
 * Created by JP17-2 on 2018.03.07.
 */
public interface BDUderDAOimp {

    List<User> getUsers();
     void createUser(User user);
    void deleteUser(String username);
    void updateUser(User user, String userName);
}
