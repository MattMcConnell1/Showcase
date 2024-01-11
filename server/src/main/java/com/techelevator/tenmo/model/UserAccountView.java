package com.techelevator.tenmo.model;

public class UserAccountView {

    private String username;
    private String balance;

    public UserAccountView(String username, String balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "UserAccountView{" +
                "username='" + username + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
