package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.converter.json.GsonBuilderUtils;
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
            Transfer transfer = mapRowToUser(results);
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
            return mapRowToUser(results);
        }

        return null;
    }

    @Override
    public List<User> getUserForTransfer(int userId) {
        return null;
    }

    @Override
    public Transfer sendTransfer(int sendUserId, String receiveUserId, double amount) {
        return null;
    }

    @Override
    public List<Transfer> getTransferStatus(int userId, String transferStatus) {
        return null;
    }

    private Transfer mapRowToUser (SqlRowSet rs){
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
