package com.techelevator.tenmo.model;

import java.util.ArrayList;
import java.util.List;

public class Transfer {

    private int userId;
    private String senderUser;
    private String receiverUser;
    private String username;
    private int transferId;
    private String transferStatus;
    private double senderBalance;
    private double receiverBalance;
    private int senderAccountId;
    private int receiverAccountId;
    private double transferAmount;
    private int senderUserId;
    private int receiverUserId;
    private String senderUserName;
    private String receiverUserName;


    public Transfer(int userId, String senderUser, String receiverUser, String username, int transferId, String transferStatus, double senderBalance, double receiverBalance, int senderAccountId, int receiverAccountId, double transferAmount, int senderUserId, int receiverUserId, String senderUserName, String receiverUserName) {
        this.userId = userId;
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.username = username;
        this.transferId = transferId;
        this.transferStatus = transferStatus;
        this.senderBalance = senderBalance;
        this.receiverBalance = receiverBalance;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.transferAmount = transferAmount;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.senderUserName = senderUserName;
        this.receiverUserName = receiverUserName;
    }

    public Transfer() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(String senderUser) {
        this.senderUser = senderUser;
    }

    public String getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(String receiverUser) {
        this.receiverUser = receiverUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public double getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(double senderBalance) {
        this.senderBalance = senderBalance;
    }

    public double getReceiverBalance() {
        return receiverBalance;
    }

    public void setReceiverBalance(double receiverBalance) {
        this.receiverBalance = receiverBalance;
    }

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public int getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(int receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }




    public List<User> goodUser(String username){
        List<User> activeUser = new ArrayList<>();

        if(username != null){
            User user = new User(username);
            activeUser.add(user);
        }
        return activeUser;
    }



    @Override
    public String toString() {
        return "Transfer{" +
                "userId=" + userId +
                ", senderUser='" + senderUser + '\'' +
                ", receiverUser='" + receiverUser + '\'' +
                ", username='" + username + '\'' +
                ", transferId=" + transferId +
                ", transferStatus='" + transferStatus + '\'' +
                ", senderBalance=" + senderBalance +
                ", receiverBalance=" + receiverBalance +
                ", senderAccountId=" + senderAccountId +
                ", receiverAccountId=" + receiverAccountId +
                ", transferAmount=" + transferAmount +
                '}';
    }
}
