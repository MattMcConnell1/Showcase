package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VendingMachineTest {

    public VendingMachine vendingMachine;
    private List<Product> products;

    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
        products = new ArrayList<>();
        vendingMachine = new VendingMachine(products);
    }

    @Test
    public void test_feed_5_return_correct_balance() {
        InputStream inputStream = new ByteArrayInputStream("5\n".getBytes());
        Scanner scanner = new Scanner(inputStream);
        VendingMachine.feedMoney(scanner);
        assertEquals(5, vendingMachine.getCurrentBalance(), 0.01);

    }
    @Test
    public void test_feed_7_return_correct_balance() {
        InputStream input = new ByteArrayInputStream("7\n".getBytes());
        Scanner scanner1 = new Scanner(input);
        VendingMachine.feedMoney(scanner1);
        assertEquals(7,vendingMachine.getCurrentBalance(),0.01);
    }

    @Test
    public void test_return_correct_change(){
        // I googled it- redirect system.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Set a balance for testing.
        vendingMachine.setCurrentBalance(1.45);
        // call the return method.
        vendingMachine.returnChange();
        // restore the standard output.
        System.setOut(System.out);
        // get the capture output
        String printedOutput = outputStream.toString().trim();
        // Expected result:
        String expected = "Returning change : 5 quarters 2 dimes 0 nickels";
        assertEquals(expected,printedOutput);

    }



}
