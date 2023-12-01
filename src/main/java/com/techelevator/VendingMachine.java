package com.techelevator;

import java.util.List;

public class VendingMachine {
    private static List<Product> products;
    private double currentBalance;
    private double discount;

    public VendingMachine(List<Product> products) {
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getDiscount() {
        return discount;
    }

    public static void  displayMain(){
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public void displayOption(){
        System.out.println("Current Money Provide:" + getCurrentBalance());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select product");
        System.out.println("(3) Finish Transaction");
    }
    
}
