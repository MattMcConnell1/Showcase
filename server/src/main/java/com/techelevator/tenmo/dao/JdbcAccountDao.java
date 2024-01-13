package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}


    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT accountId, accountBalance, activeAccount FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Account account = mapRowToAccount(results);
            accounts.add(account);

        }
         return accounts;
    }

    @Override
    public List<Account> findAccountById(int accountId) {

        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT accountId, accountBalance, activeAccount FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Account account = new Account();
            account.setAccountId(results.getInt("accountId"));
            account.setAccountBalance(results.getDouble("accountBalance"));
            account.setActiveAccount(results.getBoolean("activeAccount"));
            accounts.add(account);

        }

        return accounts;
    }

    // I don't know how to do this becauae it really doesn't make sense to check for it this way
    // this is why i added the second method which searches for the info about the active account with the accountID
    @Override
    public boolean activateAccount(boolean activeAccount) {
        return false;
    }

    @Override
    public boolean activateAccount(int accountId) {

        String sql = "SELECT activeAccount FROM account WHERE accountId = ?";

        // Execute the SQL query and retrieve the result
        Boolean isActive = jdbcTemplate.queryForObject(sql, Boolean.class, accountId);

        // If isActive is not null, return its boolean value; otherwise, return false
        return isActive != null ? isActive : false;
    }


    private Account mapRowToAccount(SqlRowSet rs){
        Account account = new Account();
        account.setAccountBalance(rs.getDouble("accountBalance"));
        account.setAccountId(rs.getInt("accountId"));
        account.setActiveAccount(rs.getBoolean("activeAccount"));
        return account;
    }

}
