package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.tenmo.model.UserAccountView;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    public List<UserAccountView> getAccountView(String username, Principal principal){

        // get accounts associated with user
        // make sure its authenticated
        User user = userDao.findByUsername(username);

        if(user != null){
//            List<Account> userAccount =

        }
    }

    public List<Account> viewAccount(String username, String balance){
        List<Account> accountInfo = new ArrayList<>();
        if()
    }
}
