package com.HibernateDemo.hibernateDemo.controller;

import com.HibernateDemo.hibernateDemo.model.User;
import com.HibernateDemo.hibernateDemo.service.UserServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JP17-2 on 2018.03.06.
 */

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserServiceIn userDAO;

    @Autowired
    public UserController(UserServiceIn userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody final User user){
        System.out.println(user);
        userDAO.createUser(user);
    }

    @RequestMapping(path = "/delete/{username}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable final String username) {
        userDAO.deleteUser(username);
        System.out.println("Deleting user: " + username);

    }
    @RequestMapping(path = "/update/{username}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody final User user ,@PathVariable final String username){
        userDAO.updateUser(user,username);
    }


}
