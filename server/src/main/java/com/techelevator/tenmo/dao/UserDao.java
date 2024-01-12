package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserAccountView;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    UserAccountView findAccount(int userID);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password);


}
