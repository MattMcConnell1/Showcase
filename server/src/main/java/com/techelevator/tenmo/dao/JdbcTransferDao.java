package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.PostBalanceView;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Transfer> getTransfersByUserId(int userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT user_id FROM tenmo_user;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }

        return transfers;
    }

    @Override

    public Transfer getTransferInformation(int transferId) {
        //TODO: send/receiver userId, sender/receiveraccountId,
        // sender/receiverBalance transfer amount
        String sql = "SELECT sender_user_id, receiver_user_id, user_name, sender_account_id,receiver_account_id, transfer_amount\n" +
                "FROM transfer\n" +
                "WHERE transfer_id = transfer_id;\n";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if(results.next()){
            return mapRowToTransfer(results);
        }

        return null;
    }

    public PostBalanceView viewTransfer (int transferId){

        PostBalanceView postBalanceView = null;
        String sql = "SELECT transfer_id, transfer_amount, sender_user_name, receiver_user_name\n" +
                "FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);

        if(results.next()){
            PostBalanceView postBalanceView1 = new PostBalanceView(results.getInt("transfer_id"), results.getDouble("transfer_amount"), "sender_user_name", "receiver_user_name");

        }
        return postBalanceView;
    }

    @Override
    public List<User> getUserForTransfer(int userId) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username FROM tenmoe_user;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            User user = new User();
            user.setId(results.getInt("user_id"));
            user.setUsername(results.getString("username"));
            users.add(user);
        }
        return users;
    }

    @Override
    public Transfer sendTransfer(int sendUserId, int receiveUserId, double transferAmount, double senderBalance, double receiverBalance) {
        Transfer transfer = new Transfer();

        if(sendUserId == receiveUserId){
            System.out.println("Error cannot send yourself money");
        } else if (transferAmount <= 0) {
            System.out.println("Error cannot send $0 or a negative amount");
        } else if (senderBalance < transferAmount) {
            System.out.println("Error, your poor");

        } else {
            String sqlInsertTransfer = "INSERT INTO transfer (sender_account_id, receiver_account_id, user_id, sender_user_id, receiver_user_id, sender_user_name, receiver_user_name, transfer_status, sender_balance, receiver_balance, transfer_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING transfer_id;";
            int transferId = jdbcTemplate.queryForObject(sqlInsertTransfer, Integer.class, sendUserId, receiveUserId, sendUserId, sendUserId, receiveUserId, "sender_user_name", "receiver_user_name", "status", senderBalance, receiverBalance, transferAmount);


            String sqlUpdateSenderBalance = "UPDATE transfer SET sender_balance = sender_balance - ? WHERE user_id = ?;";
            jdbcTemplate.update(sqlUpdateSenderBalance, transferAmount, sendUserId);


            String sqlUpdateReceiverBalance = "UPDATE transfer SET receiver_balance = receiver_balance + ? WHERE user_id = ?;";
            jdbcTemplate.update(sqlUpdateReceiverBalance, transferAmount, receiveUserId);


            String sqlSelectTransfer = "SELECT transfer_id, sender_account_id, receiver_account_id, user_id, sender_user_id, receiver_user_id, sender_user_name, receiver_user_name, transfer_status, sender_balance, receiver_balance, transfer_amount FROM transfer WHERE transfer_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTransfer, transferId);


            if (results.next()) {
                transfer.setTransferId(results.getInt("transfer_id"));
                transfer.setSenderAccountId(results.getInt("sender_account_id"));
                transfer.setReceiverAccountId(results.getInt("receiver_account_id"));
                transfer.setUserId(results.getInt("user_id"));
                transfer.setSenderUserId(results.getInt("sender_user_id"));
                transfer.setReceiverUserId(results.getInt("receiver_user_id"));
                transfer.setSenderUserName(results.getString("sender_user_name"));
                transfer.setReceiverUserName(results.getString("receiver_user_name"));
                transfer.setTransferStatus(results.getString("transfer_status"));
                transfer.setSenderBalance(results.getDouble("sender_balance"));
                transfer.setReceiverBalance(results.getDouble("receiver_balance"));
                transfer.setTransferAmount(results.getDouble("transfer_amount"));
            }
        }
        return transfer;





    }

    @Override
    public List<Transfer> getTransferStatus(int userId, String transferStatus) {

        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_status, transfer_amount, sender_user_id, receiver_user_id\n" +
                    "FROM transfer WHERE sender_user_id = ? AND transfer_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, transferStatus);
        while(results.next()){
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }






    private Transfer mapRowToTransfer (SqlRowSet rs){
        Transfer transfer = new Transfer();
        transfer.setUserId(rs.getInt("user_id"));
        transfer.setSenderUser(rs.getString("send_user_id"));
        transfer.setReceiverUser(rs.getString("receiver_user_id"));
        transfer.setUsername(rs.getString("username"));
        transfer.setSenderAccountId(rs.getInt("sender_account_id"));
        transfer.setReceiverAccountId(rs.getInt("receiver_account_id"));
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferStatus(rs.getString("transfer_status"));
        transfer.setSenderBalance(rs.getDouble("sender_balance"));
        transfer.setReceiverBalance(rs.getDouble("receiver_balance"));
        transfer.setTransferAmount(rs.getDouble("transfer_amount"));
        return transfer;
    }
}
