package com.techelevator;

public class Drink extends Product{
    public Drink(String slotLocation, String name, double price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    @Override
    public String dispenseMessage() {
        return "Glug Glug, Yum!";
    }
}
