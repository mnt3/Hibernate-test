package com.HibernateDemo.hibernateDemo.service;

import com.HibernateDemo.hibernateDemo.model.User;

import java.util.List;

/**
 * Created by JP17-2 on 2018.03.06.
 */
public interface UserServiceIn {
    List<User> getUsers();
    void createUser(User user);
    void deleteUser(String name);
    void updateUser(User user, String userName);
}
