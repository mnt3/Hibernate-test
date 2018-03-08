package com.HibernateDemo.hibernateDemo.service;

import com.HibernateDemo.hibernateDemo.dao.BDUderDAOimp;
import com.HibernateDemo.hibernateDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by JP17-2 on 2018.03.06.
 */
@Component
@Service
public class UserService implements UserServiceIn {

    @Autowired
    private BDUderDAOimp userDao;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @org.springframework.transaction.annotation.Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    @Override
    @Transactional
    public void updateUser(User user, String userName) {
        userDao.updateUser(user,userName);

    }


}
