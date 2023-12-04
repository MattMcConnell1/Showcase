package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VendingMachineTest {

    public VendingMachine vendingMachine;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public  void test_feed_money_return_correct_balance(){
        InputStream inputStream = new ByteArrayInputStream("5\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
//        VendingMachine.feedMoney(scanner);
    }

}