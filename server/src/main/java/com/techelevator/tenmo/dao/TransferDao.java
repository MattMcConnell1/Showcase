package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.util.List;

public interface TransferDao {

    //todo: user_id, account_id, sender_balance, receiver_balance, transfer_status

    List<Transfer> getTransfersByUserId(int userId);
    Transfer getTransferInformation (int transferId);
    List<User> getUserForTransfer(int userId);
    Transfer sendTransfer(int sendUserId, String receiveUserId, double amount);
    List<Transfer> getTransferStatus( int userId, String transferStatus);

}
