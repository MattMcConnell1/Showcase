package com.techelevator;

public class Gum extends Product{
    public Gum(String slotLocation, String name, double price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    @Override
    public String dispenseMessage() {
        return "Chew Chew, Yum!";
    }
}
