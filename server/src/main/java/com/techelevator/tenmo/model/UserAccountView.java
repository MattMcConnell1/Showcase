package com.techelevator.tenmo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserAccountView {

    private String username;
    private String balance;

    public UserAccountView(String username, String balance) {
        this.username = username;
        this.balance = balance;
    }

    public UserAccountView() {
    }

    public String getUsername() {
        return username;
    }

    public String getBalance() {
        return balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    private UserAccountView mapRowToUserAccountView(SqlRowSet rs){

        UserAccountView userAccountView = new UserAccountView();
        userAccountView.setBalance(rs.getString("balance"));
        userAccountView.setUsername(rs.getString("username"));

        return userAccountView;
    }

    @Override
    public String toString() {
        return "UserAccountView{" +
                "username='" + username + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
